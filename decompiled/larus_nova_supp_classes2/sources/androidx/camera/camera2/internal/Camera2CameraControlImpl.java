package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Rational;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.AeFpsRange;
import androidx.camera.camera2.internal.compat.workaround.AutoFlashAEModeDisabler;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.CameraControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.imagecapture.CameraCapturePipeline;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class Camera2CameraControlImpl implements CameraControlInternal {
    private static final int DEFAULT_TEMPLATE = 1;
    private static final String TAG = "Camera2CameraControlImp";
    static final String TAG_SESSION_UPDATE_ID = "CameraControlSessionUpdateId";
    private final AeFpsRange mAeFpsRange;
    private final AutoFlashAEModeDisabler mAutoFlashAEModeDisabler;
    private final Camera2CameraControl mCamera2CameraControl;
    private final Camera2CapturePipeline mCamera2CapturePipeline;
    private final CameraCaptureCallbackSet mCameraCaptureCallbackSet;
    private final CameraCharacteristicsCompat mCameraCharacteristics;
    private final CameraControlInternal.ControlUpdateCallback mControlUpdateCallback;
    private long mCurrentSessionUpdateId;
    final Executor mExecutor;
    private final ExposureControl mExposureControl;
    private volatile int mFlashMode;
    private volatile ListenableFuture<Void> mFlashModeChangeSessionUpdateFuture;
    private final FocusMeteringControl mFocusMeteringControl;
    private volatile boolean mIsTorchOn;
    private final Object mLock;
    private final AtomicLong mNextSessionUpdateId;
    private ImageCapture.ScreenFlash mScreenFlash;
    final CameraControlSessionCallback mSessionCallback;
    private final SessionConfig.Builder mSessionConfigBuilder;
    private int mTemplate;
    private final TorchControl mTorchControl;
    private int mUseCount;
    private final VideoUsageControl mVideoUsageControl;
    private final ZoomControl mZoomControl;
    ZslControl mZslControl;

    public static final class CameraCaptureCallbackSet extends CameraCaptureCallback {
        Map<CameraCaptureCallback, Executor> mCallbackExecutors;
        Set<CameraCaptureCallback> mCallbacks;

        public static /* synthetic */ void a(CameraCaptureCallback r0, int r1, CameraCaptureFailure r2) {
            lambda$onCaptureFailed$1(r0, r1, r2);
        }

        public static /* synthetic */ void b(CameraCaptureCallback r0, int r1, CameraCaptureResult r2) {
            lambda$onCaptureCompleted$0(r0, r1, r2);
        }

        public static /* synthetic */ void c(CameraCaptureCallback r0, int r1) {
            lambda$onCaptureCancelled$2(r0, r1);
        }

        public CameraCaptureCallbackSet() {
            this.mCallbacks = new HashSet();
            this.mCallbackExecutors = new ArrayMap();
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCancelled(final int r5) {
            Iterator<CameraCaptureCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L10;
            final CameraCaptureCallback r1 = r0.next();
            this.mCallbackExecutors.get(r1).execute(new m(r1, r5));     // Catch: RejectedExecutionException -> L8
        L8:
            e = move-exception;
            Logger.e(Camera2CameraControlImpl.TAG, "Executor rejected to invoke onCaptureCancelled.", e);
            goto L4
        }

        public void removeCaptureCallback(CameraCaptureCallback r2) {
            this.mCallbacks.remove(r2);
            this.mCallbackExecutors.remove(r2);
        }

        private static /* synthetic */ void lambda$onCaptureCancelled$2(CameraCaptureCallback r0, int r1) {
            r0.onCaptureCancelled(r1);
        }

        public void addCaptureCallback(Executor r2, CameraCaptureCallback r3) {
            this.mCallbacks.add(r3);
            this.mCallbackExecutors.put(r3, r2);
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCompleted(final int r5, final CameraCaptureResult r6) {
            Iterator<CameraCaptureCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L10;
            final CameraCaptureCallback r1 = r0.next();
            this.mCallbackExecutors.get(r1).execute(new n(r1, r5, r6));     // Catch: RejectedExecutionException -> L8
        L8:
            e = move-exception;
            Logger.e(Camera2CameraControlImpl.TAG, "Executor rejected to invoke onCaptureCompleted.", e);
            goto L4
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureFailed(final int r5, final CameraCaptureFailure r6) {
            Iterator<CameraCaptureCallback> r0 = this.mCallbacks.iterator();
        L4:
            if (r0.hasNext() == false) goto L10;
            final CameraCaptureCallback r1 = r0.next();
            this.mCallbackExecutors.get(r1).execute(new l(r1, r5, r6));     // Catch: RejectedExecutionException -> L8
        L8:
            e = move-exception;
            Logger.e(Camera2CameraControlImpl.TAG, "Executor rejected to invoke onCaptureFailed.", e);
            goto L4
        }

        private static /* synthetic */ void lambda$onCaptureCompleted$0(CameraCaptureCallback r0, int r1, CameraCaptureResult r2) {
            r0.onCaptureCompleted(r1, r2);
        }

        private static /* synthetic */ void lambda$onCaptureFailed$1(CameraCaptureCallback r0, int r1, CameraCaptureFailure r2) {
            r0.onCaptureFailed(r1, r2);
        }
    }

    public static final class CameraControlSessionCallback extends CameraCaptureSession.CaptureCallback {
        private final Executor mExecutor;
        final Set<CaptureResultListener> mResultListeners;

        public static /* synthetic */ void a(CameraControlSessionCallback r0, TotalCaptureResult r1) {
            r0.lambda$onCaptureCompleted$0(r1);
        }

        public CameraControlSessionCallback(Executor r2) {
            this.mResultListeners = new HashSet();
            this.mExecutor = r2;
        }

        private /* synthetic */ void lambda$onCaptureCompleted$0(TotalCaptureResult r5) {
            HashSet r0 = new HashSet();
            Iterator<CaptureResultListener> r1 = this.mResultListeners.iterator();
        L4:
            if (r1.hasNext() == false) goto L9;
            CaptureResultListener r2 = r1.next();
            if (r2.onCaptureResult(r5) == false) goto L4;
            r0.add(r2);
            goto L4
        L9:
            if (r0.isEmpty() == true) goto L17;
            this.mResultListeners.removeAll(r0);
            return;
        }

        public void addListener(CaptureResultListener r2) {
            this.mResultListeners.add(r2);
        }

        public void removeListener(CaptureResultListener r2) {
            this.mResultListeners.remove(r2);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession r1, CaptureRequest r2, final TotalCaptureResult r3) {
            this.mExecutor.execute(new o(this, r3));
        }
    }

    public interface CaptureResultListener {
        boolean onCaptureResult(TotalCaptureResult r1);
    }

    public static /* synthetic */ void a(Camera2CameraControlImpl r0, CallbackToFutureAdapter.Completer r1) {
        r0.lambda$updateSessionConfigAsync$6(r1);
    }

    public static /* synthetic */ ListenableFuture b(Camera2CameraControlImpl r0, int r1, int r2, int r3, Void r4) {
        return r0.lambda$getCameraCapturePipelineAsync$5(r1, r2, r3, r4);
    }

    public static /* synthetic */ void c() {
        lambda$addInteropConfig$0();
    }

    public static /* synthetic */ void d(Camera2CameraControlImpl r0, CameraCaptureCallback r1) {
        r0.lambda$removeSessionCameraCaptureCallback$9(r1);
    }

    public static /* synthetic */ Object e(Camera2CameraControlImpl r0, CallbackToFutureAdapter.Completer r1) {
        return r0.lambda$updateSessionConfigAsync$7(r1);
    }

    public static /* synthetic */ void f(Camera2CameraControlImpl r0, Executor r1, CameraCaptureCallback r2) {
        r0.lambda$addSessionCameraCaptureCallback$8(r1, r2);
    }

    public static /* synthetic */ void g() {
        lambda$clearInteropConfig$1();
    }

    public static /* synthetic */ Object h(Camera2CameraControlImpl r0, long r1, CallbackToFutureAdapter.Completer r3) {
        return r0.lambda$waitForSessionUpdateId$3(r1, r3);
    }

    public static /* synthetic */ ListenableFuture i(Camera2CameraControlImpl r0, List r1, int r2, int r3, int r4, Void r5) {
        return r0.lambda$submitStillCaptureRequests$4(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ boolean j(long r0, CallbackToFutureAdapter.Completer r2, TotalCaptureResult r3) {
        return lambda$waitForSessionUpdateId$2(r0, r2, r3);
    }

    private static /* synthetic */ void lambda$addInteropConfig$0() {
    }

    private static /* synthetic */ void lambda$clearInteropConfig$1() {
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public final /* synthetic */ CameraControlInternal getImplementation() {
        return CameraControlInternal.CC.$default$getImplementation(this);
    }

    public void resetTemplate() {
        setTemplate(1);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void clearInteropConfig() {
        this.mCamera2CameraControl.clearCaptureRequestOptions().addListener(new g(), CameraXExecutors.directExecutor());
    }

    public void decrementUseCount() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mUseCount;     // Catch: Throwable -> L11
        if (r1 == 0) goto L10;
        this.mUseCount = r1 - 1;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IllegalStateException("Decrementing use count occurs more times than incrementing");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void decrementVideoUsage() {
        this.mVideoUsageControl.decrementUsage();
    }

    public Rect getCropSensorRegion() {
        return this.mZoomControl.getCropSensorRegion();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public Config getInteropConfig() {
        return this.mCamera2CameraControl.getCamera2ImplConfig();
    }

    public int getMaxAeRegionCount() {
        Integer r0 = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }

    public int getMaxAfRegionCount() {
        Integer r0 = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }

    public int getMaxAwbRegionCount() {
        Integer r0 = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public Rect getSensorRect() {
        Rect r0 = (Rect) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if ("robolectric".equals(Build.FINGERPRINT) == false) goto L8;
        if (r0 != null) goto L8;
        return new Rect(0, 0, 4000, 3000);
    L8:
        return (Rect) Preconditions.checkNotNull(r0);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public SessionConfig getSessionConfig() {
        this.mSessionConfigBuilder.setTemplateType(this.mTemplate);
        this.mSessionConfigBuilder.setImplementationOptions(getSessionOptions());
        this.mSessionConfigBuilder.addTag(TAG_SESSION_UPDATE_ID, Long.valueOf(this.mCurrentSessionUpdateId));
        return this.mSessionConfigBuilder.build();
    }

    public Config getSessionOptions() {
        Camera2ImplConfig.Builder r0 = new Camera2ImplConfig.Builder();
        CaptureRequest.Key r1 = CaptureRequest.CONTROL_MODE;
        Config.OptionPriority r4 = Config.OptionPriority.REQUIRED;
        r0.setCaptureRequestOptionWithPriority(r1, 1, r4);
        this.mFocusMeteringControl.addFocusMeteringOptions(r0);
        this.mAeFpsRange.addAeFpsRangeOptions(r0);
        this.mZoomControl.addZoomOption(r0);
        if (this.mFocusMeteringControl.isExternalFlashAeModeEnabled() == false) goto L5;
        int r2 = 5;
    L7:
        if (this.mIsTorchOn == false) goto L9;
        r0.setCaptureRequestOptionWithPriority(CaptureRequest.FLASH_MODE, 2, r4);
    L17:
        r0.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(getSupportedAeMode(r2)), r4);
        r0.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(getSupportedAwbMode(1)), r4);
        this.mExposureControl.setCaptureRequestOption(r0);
        this.mCamera2CameraControl.applyOptionsToBuilder(r0);
        return r0.build();
    L9:
        int r3 = this.mFlashMode;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L17;
        r2 = 1;
        goto L17
    L15:
        r2 = 3;
        goto L17
    L16:
        r2 = this.mAutoFlashAEModeDisabler.getCorrectedAeMode(2);
        goto L17
    L5:
        r2 = 1;
        goto L7
    }

    public int getUseCount() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mUseCount;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void incrementUseCount() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUseCount++;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void incrementVideoUsage() {
        this.mVideoUsageControl.incrementUsage();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public boolean isInVideoUsage() {
        int r0 = this.mVideoUsageControl.getUsage();
        Logger.d(TAG, "isInVideoUsage: mVideoUsageControl value = " + r0);
        if (r0 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public boolean isZslDisabledByByUserCaseConfig() {
        return this.mZslControl.isZslDisabledByUserCaseConfig();
    }

    public void updateSessionConfig() {
        this.mExecutor.execute(new c(this));
    }

    public ListenableFuture<Void> updateSessionConfigAsync() {
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new d(this)));
    }

    public long updateSessionConfigSynchronous() {
        this.mCurrentSessionUpdateId = this.mNextSessionUpdateId.getAndIncrement();
        this.mControlUpdateCallback.onCameraControlUpdateSessionConfig();
        return this.mCurrentSessionUpdateId;
    }

    private boolean isControlInUse() {
        if (getUseCount() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.camera.core.CameraControl
    public ListenableFuture<Void> cancelFocusAndMetering() {
        if (isControlInUse() == true) goto L7;
        return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
    L7:
        return Futures.nonCancellationPropagating(this.mFocusMeteringControl.cancelFocusAndMetering());
    }

    public Camera2CameraControl getCamera2CameraControl() {
        return this.mCamera2CameraControl;
    }

    public long getCurrentSessionUpdateId() {
        return this.mCurrentSessionUpdateId;
    }

    public ExposureControl getExposureControl() {
        return this.mExposureControl;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public int getFlashMode() {
        return this.mFlashMode;
    }

    public FocusMeteringControl getFocusMeteringControl() {
        return this.mFocusMeteringControl;
    }

    public ImageCapture.ScreenFlash getScreenFlash() {
        return this.mScreenFlash;
    }

    public TorchControl getTorchControl() {
        return this.mTorchControl;
    }

    public ZoomControl getZoomControl() {
        return this.mZoomControl;
    }

    public ZslControl getZslControl() {
        return this.mZslControl;
    }

    public boolean isTorchOn() {
        return this.mIsTorchOn;
    }

    private int getSupportedAwbMode(int r4) {
        int[] r0 = (int[]) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (isModeInList(r4, r0) == false) goto L9;
        return r4;
    L9:
        if (isModeInList(1, r0) == false) goto L11;
        return 1;
    L11:
        return 0;
    }

    private /* synthetic */ void lambda$removeSessionCameraCaptureCallback$9(CameraCaptureCallback r2) {
        this.mCameraCaptureCallbackSet.removeCaptureCallback(r2);
    }

    private /* synthetic */ void lambda$updateSessionConfigAsync$6(CallbackToFutureAdapter.Completer r3) {
        Futures.propagate(waitForSessionUpdateId(updateSessionConfigSynchronous()), r3);
    }

    private /* synthetic */ Object lambda$updateSessionConfigAsync$7(final CallbackToFutureAdapter.Completer r3) throws Exception {
        this.mExecutor.execute(new k(this, r3));
        return "updateSessionConfigAsync";
    }

    private ListenableFuture<Void> waitForSessionUpdateId(final long r2) {
        return CallbackToFutureAdapter.getFuture(new i(this, r2));
    }

    public void addCaptureResultListener(CaptureResultListener r2) {
        this.mSessionCallback.addListener(r2);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void addInteropConfig(Config r3) {
        this.mCamera2CameraControl.addCaptureRequestOptions(CaptureRequestOptions.Builder.from(r3).build()).addListener(new b(), CameraXExecutors.directExecutor());
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void addZslConfig(SessionConfig.Builder r2) {
        this.mZslControl.addZslConfig(r2);
    }

    @Override // androidx.camera.core.CameraControl
    public ListenableFuture<Void> enableTorch(boolean r2) {
        if (isControlInUse() == true) goto L7;
        return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
    L7:
        return Futures.nonCancellationPropagating(this.mTorchControl.enableTorch(r2));
    }

    public void enableTorchInternal(boolean r4) {
        this.mIsTorchOn = r4;
        if (r4 == true) goto L5;
        CaptureConfig.Builder r5 = new CaptureConfig.Builder();
        r5.setTemplateType(this.mTemplate);
        r5.setUseRepeatingSurface(true);
        Camera2ImplConfig.Builder r1 = new Camera2ImplConfig.Builder();
        r1.setCaptureRequestOption(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(getSupportedAeMode(1)));
        r1.setCaptureRequestOption(CaptureRequest.FLASH_MODE, 0);
        r5.addImplementationOptions(r1.build());
        submitCaptureRequestsInternal(Collections.singletonList(r5.build()));
    L5:
        updateSessionConfigSynchronous();
    }

    public int getSupportedAeMode(int r2) {
        return getSupportedAeMode(this.mCameraCharacteristics, r2);
    }

    public int getSupportedAfMode(int r4) {
        int[] r0 = (int[]) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (isModeInList(r4, r0) == false) goto L9;
        return r4;
    L9:
        if (isModeInList(4, r0) == false) goto L12;
        return 4;
    L12:
        if (isModeInList(1, r0) == false) goto L14;
        return 1;
    L14:
        return 0;
    }

    public void removeCaptureResultListener(CaptureResultListener r2) {
        this.mSessionCallback.removeListener(r2);
    }

    public void removeSessionCameraCaptureCallback(final CameraCaptureCallback r3) {
        this.mExecutor.execute(new a(this, r3));
    }

    public void setActive(boolean r3) {
        Logger.d(TAG, "setActive: isActive = " + r3);
        this.mFocusMeteringControl.setActive(r3);
        this.mZoomControl.setActive(r3);
        this.mTorchControl.setActive(r3);
        this.mExposureControl.setActive(r3);
        this.mCamera2CameraControl.setActive(r3);
        if (r3 == true) goto L6;
        this.mScreenFlash = null;
        this.mVideoUsageControl.resetDirectly();
        return;
    }

    @Override // androidx.camera.core.CameraControl
    public ListenableFuture<Integer> setExposureCompensationIndex(int r2) {
        if (isControlInUse() == true) goto L7;
        return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
    L7:
        return this.mExposureControl.setExposureCompensationIndex(r2);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setFlashMode(int r3) {
        if (isControlInUse() == true) goto L6;
        Logger.w(TAG, "Camera is not active.");
        return;
    L6:
        this.mFlashMode = r3;
        Logger.d(TAG, "setFlashMode: mFlashMode = " + this.mFlashMode);
        ZslControl r4 = this.mZslControl;
        boolean r1 = true;
        if (this.mFlashMode != 1) goto L9;
    L12:
        r4.setZslDisabledByFlashMode(r1);
        this.mFlashModeChangeSessionUpdateFuture = updateSessionConfigAsync();
        return;
    L9:
        if (this.mFlashMode == 0) goto L12;
        r1 = false;
        goto L12
    }

    @Override // androidx.camera.core.CameraControl
    public ListenableFuture<Void> setLinearZoom(float r2) {
        if (isControlInUse() == true) goto L7;
        return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
    L7:
        return Futures.nonCancellationPropagating(this.mZoomControl.setLinearZoom(r2));
    }

    public void setPreviewAspectRatio(Rational r2) {
        this.mFocusMeteringControl.setPreviewAspectRatio(r2);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setScreenFlash(ImageCapture.ScreenFlash r1) {
        this.mScreenFlash = r1;
    }

    public void setTemplate(int r2) {
        this.mTemplate = r2;
        this.mFocusMeteringControl.setTemplate(r2);
        this.mCamera2CapturePipeline.setTemplate(this.mTemplate);
    }

    @Override // androidx.camera.core.CameraControl
    public ListenableFuture<Void> setZoomRatio(float r2) {
        if (isControlInUse() == true) goto L7;
        return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
    L7:
        return Futures.nonCancellationPropagating(this.mZoomControl.setZoomRatio(r2));
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setZslDisabledByUserCaseConfig(boolean r2) {
        this.mZslControl.setZslDisabledByUserCaseConfig(r2);
    }

    @Override // androidx.camera.core.CameraControl
    public ListenableFuture<FocusMeteringResult> startFocusAndMetering(FocusMeteringAction r2) {
        if (isControlInUse() == true) goto L7;
        return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
    L7:
        return Futures.nonCancellationPropagating(this.mFocusMeteringControl.startFocusAndMetering(r2));
    }

    public void submitCaptureRequestsInternal(List<CaptureConfig> r2) {
        this.mControlUpdateCallback.onCameraControlCaptureRequests(r2);
    }

    public static int getSupportedAeMode(CameraCharacteristicsCompat r2, int r3) {
        int[] r4 = (int[]) r2.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        if (r4 != null) goto L6;
        return 0;
    L6:
        if (isModeInList(r3, r4) == false) goto L9;
        return r3;
    L9:
        if (isModeInList(1, r4) == false) goto L11;
        return 1;
    L11:
        return 0;
    }

    private static boolean isModeInList(int r4, int[] r5) {
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r4 == r5[r2]) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static boolean isSessionUpdated(TotalCaptureResult r4, long r5) {
        if (r4.getRequest() != null) goto L5;
        return false;
    L5:
        Object r6 = r4.getRequest().getTag();
        if ((r6 instanceof TagBundle) == false) goto L14;
        Long r7 = (Long) ((TagBundle) r6).getTag(TAG_SESSION_UPDATE_ID);
        if (r7 != null) goto L11;
        return false;
    L11:
        if (r7.longValue() < r5) goto L14;
        return true;
    L14:
        return false;
    }

    private /* synthetic */ void lambda$addSessionCameraCaptureCallback$8(Executor r2, CameraCaptureCallback r3) {
        this.mCameraCaptureCallbackSet.addCaptureCallback(r2, r3);
    }

    private /* synthetic */ Object lambda$waitForSessionUpdateId$3(final long r2, final CallbackToFutureAdapter.Completer r4) throws Exception {
        addCaptureResultListener(new e(r2, r4));
        return "waitForSessionUpdateId:" + r2;
    }

    public void addSessionCameraCaptureCallback(final Executor r3, final CameraCaptureCallback r4) {
        this.mExecutor.execute(new h(this, r3, r4));
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public ListenableFuture<CameraCapturePipeline> getCameraCapturePipelineAsync(final int r4, final int r5) {
        if (isControlInUse() == true) goto L6;
        Logger.w(TAG, "Camera is not active.");
        return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
    L6:
        final int r0 = getFlashMode();
        return FutureChain.from(Futures.nonCancellationPropagating(this.mFlashModeChangeSessionUpdateFuture)).transformAsync(new f(this, r4, r0, r5), this.mExecutor);
    }

    private static /* synthetic */ boolean lambda$waitForSessionUpdateId$2(long r0, CallbackToFutureAdapter.Completer r2, TotalCaptureResult r3) {
        if (isSessionUpdated(r3, r0) == false) goto L6;
        r2.set(null);
        return true;
    L6:
        return false;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public ListenableFuture<List<Void>> submitStillCaptureRequests(final List<CaptureConfig> r9, final int r10, final int r11) {
        if (isControlInUse() == true) goto L6;
        Logger.w(TAG, "Camera is not active.");
        return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
    L6:
        final int r4 = getFlashMode();
        return FutureChain.from(Futures.nonCancellationPropagating(this.mFlashModeChangeSessionUpdateFuture)).transformAsync(new j(this, r9, r10, r4, r11), this.mExecutor);
    }

    public Camera2CameraControlImpl(CameraCharacteristicsCompat r7, ScheduledExecutorService r8, Executor r9, CameraControlInternal.ControlUpdateCallback r10) {
        this(r7, r8, r9, r10, new Quirks(new ArrayList()));
    }

    private /* synthetic */ ListenableFuture lambda$getCameraCapturePipelineAsync$5(int r1, int r2, int r3, Void r4) throws Exception {
        return Futures.immediateFuture(this.mCamera2CapturePipeline.getCameraCapturePipeline(r1, r2, r3));
    }

    public Camera2CameraControlImpl(CameraCharacteristicsCompat r7, ScheduledExecutorService r8, Executor r9, CameraControlInternal.ControlUpdateCallback r10, Quirks r11) {
        this.mLock = new Object();
        SessionConfig.Builder r0 = new SessionConfig.Builder();
        this.mSessionConfigBuilder = r0;
        this.mUseCount = 0;
        this.mIsTorchOn = false;
        this.mFlashMode = 2;
        this.mNextSessionUpdateId = new AtomicLong(0);
        this.mFlashModeChangeSessionUpdateFuture = Futures.immediateFuture(null);
        this.mTemplate = 1;
        this.mCurrentSessionUpdateId = 0;
        CameraCaptureCallbackSet r1 = new CameraCaptureCallbackSet();
        this.mCameraCaptureCallbackSet = r1;
        this.mCameraCharacteristics = r7;
        this.mControlUpdateCallback = r10;
        this.mExecutor = r9;
        this.mVideoUsageControl = new VideoUsageControl(r9);
        CameraControlSessionCallback r12 = new CameraControlSessionCallback(r9);
        this.mSessionCallback = r12;
        r0.setTemplateType(this.mTemplate);
        r0.addRepeatingCameraCaptureCallback(CaptureCallbackContainer.create(r12));
        r0.addRepeatingCameraCaptureCallback(r1);
        this.mExposureControl = new ExposureControl(this, r7, r9);
        this.mFocusMeteringControl = new FocusMeteringControl(this, r8, r9, r11);
        this.mZoomControl = new ZoomControl(this, r7, r9);
        this.mTorchControl = new TorchControl(this, r7, r9);
        if (Build.VERSION.SDK_INT < 23) goto L5;
        this.mZslControl = new ZslControlImpl(r7);
    L6:
        this.mAeFpsRange = new AeFpsRange(r11);
        this.mAutoFlashAEModeDisabler = new AutoFlashAEModeDisabler(r11);
        this.mCamera2CameraControl = new Camera2CameraControl(this, r9);
        this.mCamera2CapturePipeline = new Camera2CapturePipeline(this, r7, r11, r9, r8);
        return;
    L5:
        this.mZslControl = new ZslControlNoOpImpl();
        goto L6
    }

    private /* synthetic */ ListenableFuture lambda$submitStillCaptureRequests$4(List r1, int r2, int r3, int r4, Void r5) throws Exception {
        return this.mCamera2CapturePipeline.submitStillCaptures(r1, r2, r3, r4);
    }
}
