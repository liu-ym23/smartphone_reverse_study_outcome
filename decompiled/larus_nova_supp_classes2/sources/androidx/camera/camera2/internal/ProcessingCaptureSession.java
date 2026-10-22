package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.params.DynamicRangesCompat;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionShouldUseMrirQuirk;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.camera.core.impl.OutputSurface;
import androidx.camera.core.impl.OutputSurfaceConfiguration;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.SessionProcessorSurface;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class ProcessingCaptureSession implements CaptureSessionInterface {
    private static final String TAG = "ProcessingCaptureSession";
    private static final long TIMEOUT_GET_SURFACE_IN_MS = 5000;
    private static List<DeferrableSurface> sHeldProcessorSurfaces;
    private static int sNextInstanceId;
    private final Camera2CameraInfoImpl mCamera2CameraInfoImpl;
    private final CaptureSession mCaptureSession;
    final Executor mExecutor;
    private int mInstanceId;
    private List<DeferrableSurface> mOutputSurfaces;
    private volatile List<CaptureConfig> mPendingCaptureConfigs;
    private SessionConfig mProcessorSessionConfig;
    private ProcessorState mProcessorState;
    private Camera2RequestProcessor mRequestProcessor;
    private final ScheduledExecutorService mScheduledExecutorService;
    private SessionConfig mSessionConfig;
    private CaptureRequestOptions mSessionOptions;
    private final SessionProcessor mSessionProcessor;
    private final SessionProcessorCaptureCallback mSessionProcessorCaptureCallback;
    private CaptureRequestOptions mStillCaptureOptions;

    public static class CaptureCallbackAdapter implements SessionProcessor.CaptureCallback {
        private List<CameraCaptureCallback> mCameraCaptureCallbacks;
        private final int mCaptureConfigId;
        private CameraCaptureResult mCaptureResult;

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public final /* synthetic */ void onCaptureProcessStarted(int r1) {
            SessionProcessor.CaptureCallback.CC.$default$onCaptureProcessStarted(this, r1);
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public final /* synthetic */ void onCaptureSequenceAborted(int r1) {
            SessionProcessor.CaptureCallback.CC.$default$onCaptureSequenceAborted(this, r1);
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureFailed(int r5) {
            Iterator<CameraCaptureCallback> r6 = this.mCameraCaptureCallbacks.iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            r6.next().onCaptureFailed(this.mCaptureConfigId, new CameraCaptureFailure(CameraCaptureFailure.Reason.ERROR));
            goto L4
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureProcessProgressed(int r4) {
            Iterator<CameraCaptureCallback> r0 = this.mCameraCaptureCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().onCaptureProcessProgressed(this.mCaptureConfigId, r4);
            goto L4
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureSequenceCompleted(int r4) {
            CameraCaptureResult r5 = this.mCaptureResult;
            if (r5 != null) goto L6;
            r5 = new CameraCaptureResult.EmptyCameraCaptureResult();
        L6:
            Iterator<CameraCaptureCallback> r0 = this.mCameraCaptureCallbacks.iterator();
        L8:
            if (r0.hasNext() == false) goto L10;
            r0.next().onCaptureCompleted(this.mCaptureConfigId, r5);
            goto L8
        }

        private CaptureCallbackAdapter(int r2, List<CameraCaptureCallback> r3) {
            this.mCaptureResult = null;
            this.mCaptureConfigId = r2;
            this.mCameraCaptureCallbacks = r3;
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureStarted(int r1, long r2) {
            Iterator<CameraCaptureCallback> r3 = this.mCameraCaptureCallbacks.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            r3.next().onCaptureStarted(this.mCaptureConfigId);
            goto L4
        }

        public /* synthetic */ CaptureCallbackAdapter(int r1, List r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureCompleted(long r1, int r3, CameraCaptureResult r4) {
            this.mCaptureResult = r4;
        }
    }

    public static final enum ProcessorState extends Enum<ProcessorState> {
        private static final /* synthetic */ ProcessorState[] $VALUES = null;
        public static final ProcessorState DE_INITIALIZED = null;
        public static final ProcessorState ON_CAPTURE_SESSION_ENDED = null;
        public static final ProcessorState ON_CAPTURE_SESSION_STARTED = null;
        public static final ProcessorState SESSION_INITIALIZED = null;
        public static final ProcessorState UNINITIALIZED = null;

        private static /* synthetic */ ProcessorState[] $values() {
            return new ProcessorState[]{UNINITIALIZED, SESSION_INITIALIZED, ON_CAPTURE_SESSION_STARTED, ON_CAPTURE_SESSION_ENDED, DE_INITIALIZED};
        }

        static {
            UNINITIALIZED = new ProcessorState("UNINITIALIZED", 0);
            SESSION_INITIALIZED = new ProcessorState("SESSION_INITIALIZED", 1);
            ON_CAPTURE_SESSION_STARTED = new ProcessorState("ON_CAPTURE_SESSION_STARTED", 2);
            ON_CAPTURE_SESSION_ENDED = new ProcessorState("ON_CAPTURE_SESSION_ENDED", 3);
            DE_INITIALIZED = new ProcessorState("DE_INITIALIZED", 4);
            $VALUES = $values();
        }

        public static ProcessorState[] values() {
            return (ProcessorState[]) $VALUES.clone();
        }

        public static ProcessorState valueOf(String r1) {
            return (ProcessorState) r27.a.a(ProcessorState.class, r1);
        }

        private ProcessorState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static class SessionProcessorCaptureCallback implements SessionProcessor.CaptureCallback {
        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureCompleted(long r1, int r3, CameraCaptureResult r4) {
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureFailed(int r1) {
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public final /* synthetic */ void onCaptureProcessProgressed(int r1) {
            SessionProcessor.CaptureCallback.CC.$default$onCaptureProcessProgressed(this, r1);
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureProcessStarted(int r1) {
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureSequenceAborted(int r1) {
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureSequenceCompleted(int r1) {
        }

        @Override // androidx.camera.core.impl.SessionProcessor.CaptureCallback
        public void onCaptureStarted(int r1, long r2) {
        }

        public SessionProcessorCaptureCallback() {
        }
    }

    public static /* synthetic */ void a(ProcessingCaptureSession r0, DeferrableSurface r1) {
        r0.lambda$open$0(r1);
    }

    public static /* synthetic */ ListenableFuture b(ProcessingCaptureSession r0, SessionConfig r1, CameraDevice r2, SynchronizedCaptureSession.Opener r3, List r4) {
        return r0.lambda$open$2(r1, r2, r3, r4);
    }

    public static /* synthetic */ void c(DeferrableSurface r0) {
        lambda$open$1(r0);
    }

    public static /* synthetic */ void d(ProcessingCaptureSession r0) {
        r0.lambda$release$4();
    }

    public static /* synthetic */ Void e(ProcessingCaptureSession r0, Void r1) {
        return r0.lambda$open$3(r1);
    }

    private boolean isTemplateTypeForStillCapture(int r2) {
        if (r2 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r2 == 4) goto L8;
        return false;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void setStreamUseCaseMap(Map<DeferrableSurface, Long> r1) {
    }

    static {
        sHeldProcessorSurfaces = new ArrayList();
        sNextInstanceId = 0;
    }

    private /* synthetic */ void lambda$release$4() {
        Logger.d(TAG, "== deInitSession (id=" + this.mInstanceId + ")");
        this.mSessionProcessor.deInitSession();
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void cancelIssuedCaptureRequests() {
        Logger.d(TAG, "cancelIssuedCaptureRequests (id=" + this.mInstanceId + ")");
        if (this.mPendingCaptureConfigs == null) goto L15;
        Iterator<CaptureConfig> r0 = this.mPendingCaptureConfigs.iterator();
    L6:
        if (r0.hasNext() == false) goto L11;
        CaptureConfig r1 = r0.next();
        Iterator<CameraCaptureCallback> r2 = r1.getCameraCaptureCallbacks().iterator();
    L9:
        if (r2.hasNext() == false) goto L6;
        r2.next().onCaptureCancelled(r1.getId());
        goto L9
    L11:
        this.mPendingCaptureConfigs = null;
        return;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void close() {
        Logger.d(TAG, "close (id=" + this.mInstanceId + ") state=" + this.mProcessorState);
        if (this.mProcessorState != ProcessorState.ON_CAPTURE_SESSION_STARTED) goto L8;
        Logger.d(TAG, "== onCaptureSessionEnd (id = " + this.mInstanceId + ")");
        this.mSessionProcessor.onCaptureSessionEnd();
        Camera2RequestProcessor r0 = this.mRequestProcessor;
        if (r0 == null) goto L7;
        r0.close();
    L7:
        this.mProcessorState = ProcessorState.ON_CAPTURE_SESSION_ENDED;
    L8:
        this.mCaptureSession.close();
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public List<CaptureConfig> getCaptureConfigs() {
        if (this.mPendingCaptureConfigs == null) goto L6;
        return this.mPendingCaptureConfigs;
    L6:
        return Collections.emptyList();
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public boolean isInOpenState() {
        return this.mCaptureSession.isInOpenState();
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public SessionConfig getSessionConfig() {
        return this.mSessionConfig;
    }

    private static void cancelRequests(List<CaptureConfig> r4) {
        Iterator<CaptureConfig> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        CaptureConfig r0 = r5.next();
        Iterator<CameraCaptureCallback> r1 = r0.getCameraCaptureCallbacks().iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        r1.next().onCaptureCancelled(r0.getId());
        goto L7
    }

    private static List<SessionProcessorSurface> getSessionProcessorSurfaceList(List<DeferrableSurface> r4) {
        ArrayList r0 = new ArrayList();
        Iterator<DeferrableSurface> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        DeferrableSurface r1 = r5.next();
        Preconditions.checkArgument(r1 instanceof SessionProcessorSurface, "Surface must be SessionProcessorSurface");
        r0.add((SessionProcessorSurface) r1);
        goto L4
    L6:
        return r0;
    }

    private static boolean hasPreviewSurface(CaptureConfig r2) {
        Iterator<DeferrableSurface> r3 = r2.getSurfaces().iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        DeferrableSurface r0 = r3.next();
        if (isPreview(r0) == true) goto L9;
        if (isStreamSharing(r0) == false) goto L4;
        return true;
    L9:
        return true;
    L11:
        return false;
    }

    private static boolean isImageAnalysis(DeferrableSurface r1) {
        return Objects.equals(r1.getContainerClass(), ImageAnalysis.class);
    }

    private static boolean isImageCapture(DeferrableSurface r1) {
        return Objects.equals(r1.getContainerClass(), ImageCapture.class);
    }

    private static boolean isPreview(DeferrableSurface r1) {
        return Objects.equals(r1.getContainerClass(), Preview.class);
    }

    private static boolean isStreamSharing(DeferrableSurface r1) {
        return Objects.equals(r1.getContainerClass(), StreamSharing.class);
    }

    private /* synthetic */ void lambda$open$0(DeferrableSurface r2) {
        DeferrableSurfaces.decrementAll(this.mOutputSurfaces);
        if (r2 == null) goto L6;
        r2.decrementUseCount();
        return;
    }

    private static /* synthetic */ void lambda$open$1(DeferrableSurface r1) {
        sHeldProcessorSurfaces.remove(r1);
    }

    private /* synthetic */ Void lambda$open$3(Void r1) {
        onConfigured(this.mCaptureSession);
        return null;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void issueCaptureRequests(List<CaptureConfig> r4) {
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        Logger.d(TAG, "issueCaptureRequests (id=" + this.mInstanceId + ") + state =" + this.mProcessorState);
        int r0 = this.mProcessorState.ordinal();
        if (r0 == 0) goto L25;
        if (r0 == 1) goto L25;
        if (r0 != 2) goto L12;
        Iterator<CaptureConfig> r5 = r4.iterator();
    L19:
        if (r5.hasNext() == false) goto L38;
        CaptureConfig r1 = r5.next();
        if (isTemplateTypeForStillCapture(r1.getTemplateType()) == true) goto L22;
        issueTriggerRequest(r1);
        goto L19
    L22:
        issueStillCaptureRequest(r1);
        goto L19
    L38:
        return;
    L12:
        if (r0 != 3) goto L14;
    L16:
        Logger.d(TAG, "Run issueCaptureRequests in wrong state, state = " + this.mProcessorState);
        cancelRequests(r4);
        return;
    L14:
        if (r0 == 4) goto L16;
        return;
    L25:
        if (this.mPendingCaptureConfigs == null) goto L27;
        cancelRequests(r4);
        Logger.d(TAG, "cancel the request because are pending un-submitted request");
        return;
    L27:
        this.mPendingCaptureConfigs = r4;
    }

    public void issueStillCaptureRequest(CaptureConfig r7) {
        CaptureRequestOptions.Builder r0 = CaptureRequestOptions.Builder.from(r7.getImplementationOptions());
        Config r1 = r7.getImplementationOptions();
        Config.Option<Integer> r2 = CaptureConfig.OPTION_ROTATION;
        if (r1.containsOption(r2) == false) goto L5;
        r0.setCaptureRequestOption(CaptureRequest.JPEG_ORIENTATION, (Integer) r7.getImplementationOptions().retrieveOption(r2));
    L5:
        Config r3 = r7.getImplementationOptions();
        Config.Option<Integer> r4 = CaptureConfig.OPTION_JPEG_QUALITY;
        if (r3.containsOption(r4) == false) goto L8;
        r0.setCaptureRequestOption(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer) r7.getImplementationOptions().retrieveOption(r4)).byteValue()));
    L8:
        CaptureRequestOptions r5 = r0.build();
        this.mStillCaptureOptions = r5;
        updateParameters(this.mSessionOptions, r5);
        this.mSessionProcessor.startCapture(r7.isPostviewEnabled(), r7.getTagBundle(), new CaptureCallbackAdapter(r7.getId(), r7.getCameraCaptureCallbacks(), null));
    }

    public void issueTriggerRequest(CaptureConfig r7) {
        Logger.d(TAG, "issueTriggerRequest");
        CaptureRequestOptions r0 = CaptureRequestOptions.Builder.from(r7.getImplementationOptions()).build();
        Iterator r1 = r0.listOptions().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        CaptureRequest.Key r2 = (CaptureRequest.Key) ((Config.Option) r1.next()).getToken();
        if (r2.equals(CaptureRequest.CONTROL_AF_TRIGGER) == true) goto L9;
        if (r2.equals(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER) == false) goto L4;
    L9:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L14;
        cancelRequests(Arrays.asList(new CaptureConfig[]{r7}));
        return;
    L14:
        this.mSessionProcessor.startTrigger(r0, r7.getTagBundle(), new CaptureCallbackAdapter(r7.getId(), r7.getCameraCaptureCallbacks(), null));
        return;
    L10:
        r3 = false;
        goto L11
    }

    public void onConfigured(CaptureSession r3) {
        if (this.mProcessorState == ProcessorState.SESSION_INITIALIZED) goto L5;
        return;
    L5:
        this.mRequestProcessor = new Camera2RequestProcessor(r3, getSessionProcessorSurfaceList(this.mProcessorSessionConfig.getSurfaces()));
        Logger.d(TAG, "== onCaptureSessinStarted (id = " + this.mInstanceId + ")");
        this.mSessionProcessor.onCaptureSessionStart(this.mRequestProcessor);
        this.mProcessorState = ProcessorState.ON_CAPTURE_SESSION_STARTED;
        SessionConfig r4 = this.mSessionConfig;
        if (r4 == null) goto L9;
        setSessionConfig(r4);
    L9:
        if (this.mPendingCaptureConfigs == null) goto L12;
        issueCaptureRequests(this.mPendingCaptureConfigs);
        this.mPendingCaptureConfigs = null;
        return;
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public ListenableFuture<Void> release(boolean r3) {
        Logger.d(TAG, "release (id=" + this.mInstanceId + ") mProcessorState=" + this.mProcessorState);
        ListenableFuture<Void> r4 = this.mCaptureSession.release(r3);
        int r0 = this.mProcessorState.ordinal();
        if (r0 != 1) goto L5;
    L7:
        r4.addListener(new z2(this), CameraXExecutors.directExecutor());
    L8:
        this.mProcessorState = ProcessorState.DE_INITIALIZED;
        return r4;
    L5:
        if (r0 == 3) goto L7;
        goto L7
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public void setSessionConfig(SessionConfig r3) {
        Logger.d(TAG, "setSessionConfig (id=" + this.mInstanceId + ")");
        this.mSessionConfig = r3;
        if (r3 != null) goto L5;
        return;
    L5:
        Camera2RequestProcessor r0 = this.mRequestProcessor;
        if (r0 == null) goto L9;
        r0.updateSessionConfig(r3);
    L9:
        if (this.mProcessorState != ProcessorState.ON_CAPTURE_SESSION_STARTED) goto L15;
        CaptureRequestOptions r1 = CaptureRequestOptions.Builder.from(r3.getImplementationOptions()).build();
        this.mSessionOptions = r1;
        updateParameters(r1, this.mStillCaptureOptions);
        if (hasPreviewSurface(r3.getRepeatingCaptureConfig()) == true) goto L13;
        this.mSessionProcessor.stopRepeating();
        return;
    L13:
        this.mSessionProcessor.startRepeating(r3.getRepeatingCaptureConfig().getTagBundle(), this.mSessionProcessorCaptureCallback);
        return;
    }

    private void updateParameters(CaptureRequestOptions r2, CaptureRequestOptions r3) {
        Camera2ImplConfig.Builder r0 = new Camera2ImplConfig.Builder();
        r0.insertAllOptions(r2);
        r0.insertAllOptions(r3);
        this.mSessionProcessor.setParameters(r0.build());
    }

    @Override // androidx.camera.camera2.internal.CaptureSessionInterface
    public ListenableFuture<Void> open(final SessionConfig r8, final CameraDevice r9, final SynchronizedCaptureSession.Opener r10) {
        if (this.mProcessorState != ProcessorState.UNINITIALIZED) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "Invalid state state:" + this.mProcessorState);
        Preconditions.checkArgument(r8.getSurfaces().isEmpty() ^ true, "SessionConfig contains no surfaces");
        Logger.d(TAG, "open (id=" + this.mInstanceId + ")");
        this.mOutputSurfaces = r8.getSurfaces();
        return FutureChain.from(DeferrableSurfaces.surfaceListWithTimeout(this.mOutputSurfaces, false, TIMEOUT_GET_SURFACE_IN_MS, this.mExecutor, this.mScheduledExecutorService)).transformAsync(new a3(this, r8, r9, r10), this.mExecutor).transform(new b3(this), this.mExecutor);
    L5:
        r0 = false;
        goto L6
    }

    private /* synthetic */ ListenableFuture lambda$open$2(SessionConfig r10, CameraDevice r11, SynchronizedCaptureSession.Opener r12, List r13) throws Exception {
        Logger.d(TAG, "-- getSurfaces done, start init (id=" + this.mInstanceId + ")");
        if (this.mProcessorState == ProcessorState.DE_INITIALIZED) goto L5;
        final DeferrableSurface r0 = null;
        if (r13.contains(null) == true) goto L9;
        OutputSurface r4 = null;
        OutputSurface r5 = null;
        OutputSurface r6 = null;
        int r3 = 0;
    L12:
        if (r3 >= r10.getSurfaces().size()) goto L27;
        DeferrableSurface r7 = (DeferrableSurface) ListProtector.get(r10.getSurfaces(), r3);
        if (isPreview(r7) == false) goto L16;
    L24:
        r4 = OutputSurface.create((Surface) r7.getSurface().get(), r7.getPrescribedSize(), r7.getPrescribedStreamFormat());
    L25:
        r3 = r3 + 1;
        goto L12
    L16:
        if (isStreamSharing(r7) == true) goto L24;
        if (isImageCapture(r7) == false) goto L22;
        r5 = OutputSurface.create((Surface) r7.getSurface().get(), r7.getPrescribedSize(), r7.getPrescribedStreamFormat());
        goto L25
    L22:
        if (isImageAnalysis(r7) == false) goto L25;
        r6 = OutputSurface.create((Surface) r7.getSurface().get(), r7.getPrescribedSize(), r7.getPrescribedStreamFormat());
        goto L25
    L27:
        if (r10.getPostviewOutputConfig() == null) goto L29;
        r0 = r10.getPostviewOutputConfig().getSurface();
        OutputSurface r8 = OutputSurface.create((Surface) r0.getSurface().get(), r0.getPrescribedSize(), r0.getPrescribedStreamFormat());
    L30:
        this.mProcessorState = ProcessorState.SESSION_INITIALIZED;
        ArrayList r9 = new ArrayList(this.mOutputSurfaces);     // Catch: DeferrableSurface.SurfaceClosedException -> L48
        if (r0 == null) goto L34;
        r9.add(r0);     // Catch: DeferrableSurface.SurfaceClosedException -> L48
    L34:
        DeferrableSurfaces.incrementAll(r9);     // Catch: DeferrableSurface.SurfaceClosedException -> L48
        Logger.w(TAG, "== initSession (id=" + this.mInstanceId + ")");
        SessionConfig r1 = this.mSessionProcessor.initSession(this.mCamera2CameraInfoImpl, OutputSurfaceConfiguration.create(r4, r5, r6, r8));     // Catch: Throwable -> L43
        this.mProcessorSessionConfig = r1;     // Catch: Throwable -> L43
        ((DeferrableSurface) ListProtector.get(r1.getSurfaces(), 0)).getTerminationFuture().addListener(new x2(this, r0), CameraXExecutors.directExecutor());
        Iterator<DeferrableSurface> r14 = this.mProcessorSessionConfig.getSurfaces().iterator();
    L39:
        if (r14.hasNext() == false) goto L41;
        final DeferrableSurface r2 = r14.next();
        sHeldProcessorSurfaces.add(r2);
        r2.getTerminationFuture().addListener(new y2(r2), this.mExecutor);
        goto L39
    L41:
        SessionConfig.ValidatingBuilder r15 = new SessionConfig.ValidatingBuilder();
        r15.add(r10);
        r15.clearSurfaces();
        r15.add(this.mProcessorSessionConfig);
        Preconditions.checkArgument(r15.isValid(), "Cannot transform the SessionConfig");
        ListenableFuture<Void> r16 = this.mCaptureSession.open(r15.build(), (CameraDevice) Preconditions.checkNotNull(r11), r12);
        Futures.addCallback(r16, new AnonymousClass1(this), this.mExecutor);
        return r16;
    L43:
        th = move-exception;
        Logger.e(TAG, "initSession failed", th);
        DeferrableSurfaces.decrementAll(this.mOutputSurfaces);
        if (r0 == null) goto L47;
        r0.decrementUseCount();
    L47:
        throw th;
    L48:
        e = move-exception;
        return Futures.immediateFailedFuture(e);
    L29:
        r8 = null;
        goto L30
    L9:
        return Futures.immediateFailedFuture(new DeferrableSurface.SurfaceClosedException("Surface closed", (DeferrableSurface) ListProtector.get(r10.getSurfaces(), r13.indexOf(null))));
    L5:
        return Futures.immediateFailedFuture(new IllegalStateException("SessionProcessorCaptureSession is closed."));
    }

    public ProcessingCaptureSession(SessionProcessor r4, Camera2CameraInfoImpl r5, DynamicRangesCompat r6, Executor r7, ScheduledExecutorService r8) {
        this.mOutputSurfaces = new ArrayList();
        this.mPendingCaptureConfigs = null;
        this.mSessionOptions = new CaptureRequestOptions.Builder().build();
        this.mStillCaptureOptions = new CaptureRequestOptions.Builder().build();
        boolean r0 = false;
        this.mInstanceId = 0;
        if (DeviceQuirks.get(CaptureSessionShouldUseMrirQuirk.class) == null) goto L5;
        r0 = true;
    L5:
        this.mCaptureSession = new CaptureSession(r6, r0);
        this.mSessionProcessor = r4;
        this.mCamera2CameraInfoImpl = r5;
        this.mExecutor = r7;
        this.mScheduledExecutorService = r8;
        this.mProcessorState = ProcessorState.UNINITIALIZED;
        this.mSessionProcessorCaptureCallback = new SessionProcessorCaptureCallback();
        int r9 = sNextInstanceId;
        sNextInstanceId = r9 + 1;
        this.mInstanceId = r9;
        Logger.d(TAG, "New ProcessingCaptureSession (id=" + this.mInstanceId + ")");
    }
}
