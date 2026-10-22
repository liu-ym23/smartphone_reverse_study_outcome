package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.FlashAvailabilityChecker;
import androidx.camera.camera2.internal.compat.workaround.OverrideAeModeForStillCapture;
import androidx.camera.camera2.internal.compat.workaround.UseFlashModeTorchFor3aUpdate;
import androidx.camera.camera2.internal.compat.workaround.UseTorchAsFlash;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.imagecapture.CameraCapturePipeline;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraCaptureResults;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.ConvergenceUtils;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class Camera2CapturePipeline {
    private static final String TAG = "Camera2CapturePipeline";
    private final Camera2CameraControlImpl mCameraControl;
    private final Quirks mCameraQuirk;
    private final Executor mExecutor;
    private final boolean mHasFlashUnit;
    private final boolean mIsLegacyDevice;
    private final ScheduledExecutorService mScheduler;
    private int mTemplate;
    private final UseTorchAsFlash mUseTorchAsFlash;

    public static class AePreCaptureTask implements PipelineTask {
        private final Camera2CameraControlImpl mCameraControl;
        private final int mFlashMode;
        private boolean mIsExecuted;
        private final OverrideAeModeForStillCapture mOverrideAeModeForStillCapture;

        public static /* synthetic */ Object a(AePreCaptureTask r0, CallbackToFutureAdapter.Completer r1) {
            return r0.lambda$preCapture$0(r1);
        }

        public static /* synthetic */ Boolean b(Void r0) {
            return lambda$preCapture$1(r0);
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public boolean isCaptureResultNeeded() {
            if (this.mFlashMode != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public void postCapture() {
            if (this.mIsExecuted == false) goto L6;
            Logger.d(Camera2CapturePipeline.TAG, "cancel TriggerAePreCapture");
            this.mCameraControl.getFocusMeteringControl().cancelAfAeTrigger(false, true);
            this.mOverrideAeModeForStillCapture.onAePrecaptureFinished();
            return;
        }

        private /* synthetic */ Object lambda$preCapture$0(CallbackToFutureAdapter.Completer r2) throws Exception {
            this.mCameraControl.getFocusMeteringControl().triggerAePrecapture(r2);
            this.mOverrideAeModeForStillCapture.onAePrecaptureStarted();
            return "AePreCapture";
        }

        private static /* synthetic */ Boolean lambda$preCapture$1(Void r0) {
            return Boolean.TRUE;
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public ListenableFuture<Boolean> preCapture(TotalCaptureResult r3) {
            if (Camera2CapturePipeline.isFlashRequired(this.mFlashMode, r3) == false) goto L7;
            Logger.d(Camera2CapturePipeline.TAG, "Trigger AE");
            this.mIsExecuted = true;
            return FutureChain.from(CallbackToFutureAdapter.getFuture(new s0(this))).transform(new t0(), CameraXExecutors.directExecutor());
        L7:
            return Futures.immediateFuture(Boolean.FALSE);
        }

        public AePreCaptureTask(Camera2CameraControlImpl r2, int r3, OverrideAeModeForStillCapture r4) {
            this.mIsExecuted = false;
            this.mCameraControl = r2;
            this.mFlashMode = r3;
            this.mOverrideAeModeForStillCapture = r4;
        }
    }

    public static class AfTask implements PipelineTask {
        private final Camera2CameraControlImpl mCameraControl;
        private boolean mIsExecuted;

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public boolean isCaptureResultNeeded() {
            return true;
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public void postCapture() {
            if (this.mIsExecuted == false) goto L6;
            Logger.d(Camera2CapturePipeline.TAG, "cancel TriggerAF");
            this.mCameraControl.getFocusMeteringControl().cancelAfAeTrigger(true, false);
            return;
        }

        public AfTask(Camera2CameraControlImpl r2) {
            this.mIsExecuted = false;
            this.mCameraControl = r2;
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public ListenableFuture<Boolean> preCapture(TotalCaptureResult r5) {
            ListenableFuture<Boolean> r0 = Futures.immediateFuture(Boolean.TRUE);
            if (r5 != null) goto L5;
            return r0;
        L5:
            Integer r1 = (Integer) r5.get(CaptureResult.CONTROL_AF_MODE);
            if (r1 != null) goto L8;
            return r0;
        L8:
            int r2 = r1.intValue();
            if (r2 != 1) goto L11;
        L13:
            Logger.d(Camera2CapturePipeline.TAG, "TriggerAf? AF mode auto");
            Integer r6 = (Integer) r5.get(CaptureResult.CONTROL_AF_STATE);
            if (r6 != null) goto L16;
        L18:
            return r0;
        L16:
            if (r6.intValue() != 0) goto L18;
            Logger.d(Camera2CapturePipeline.TAG, "Trigger AF");
            this.mIsExecuted = true;
            this.mCameraControl.getFocusMeteringControl().triggerAf(null, false);
            goto L18
        L11:
            if (r2 == 2) goto L13;
            goto L13
        }
    }

    public static class CameraCapturePipelineImpl implements CameraCapturePipeline {
        private final Executor mExecutor;
        private int mFlashMode;
        private final Pipeline mPipelineDelegate;

        public static /* synthetic */ Void a(TotalCaptureResult r0) {
            return lambda$invokePreCapture$0(r0);
        }

        public static /* synthetic */ Object b(CameraCapturePipelineImpl r0, CallbackToFutureAdapter.Completer r1) {
            return r0.lambda$invokePostCapture$1(r1);
        }

        private static /* synthetic */ Void lambda$invokePreCapture$0(TotalCaptureResult r0) {
            return null;
        }

        @Override // androidx.camera.core.imagecapture.CameraCapturePipeline
        public ListenableFuture<Void> invokePostCapture() {
            return CallbackToFutureAdapter.getFuture(new u0(this));
        }

        @Override // androidx.camera.core.imagecapture.CameraCapturePipeline
        public ListenableFuture<Void> invokePreCapture() {
            Logger.d(Camera2CapturePipeline.TAG, "invokePreCapture");
            return FutureChain.from(this.mPipelineDelegate.executePreCapture(this.mFlashMode)).transform(new v0(), this.mExecutor);
        }

        private /* synthetic */ Object lambda$invokePostCapture$1(CallbackToFutureAdapter.Completer r2) throws Exception {
            this.mPipelineDelegate.executePostCapture();
            r2.set(null);
            return "invokePostCaptureFuture";
        }

        public CameraCapturePipelineImpl(Pipeline r1, Executor r2, int r3) {
            this.mPipelineDelegate = r1;
            this.mExecutor = r2;
            this.mFlashMode = r3;
        }
    }

    public static class Pipeline {
        private static final long CHECK_3A_TIMEOUT_IN_NS = 0;
        private static final long CHECK_3A_WITH_FLASH_TIMEOUT_IN_NS = 0;
        private final Camera2CameraControlImpl mCameraControl;
        private final Executor mExecutor;
        private final boolean mIsLegacyDevice;
        private final OverrideAeModeForStillCapture mOverrideAeModeForStillCapture;
        private final PipelineTask mPipelineSubTask;
        private final ScheduledExecutorService mScheduler;
        final List<PipelineTask> mTasks;
        private final int mTemplate;
        private long mTimeout3A;

        /* JADX INFO: renamed from: androidx.camera.camera2.internal.Camera2CapturePipeline$Pipeline$1, reason: invalid class name */
        public class AnonymousClass1 implements PipelineTask {
            final /* synthetic */ Pipeline this$0;

            public static /* synthetic */ Boolean a(List r0) {
                return lambda$preCapture$0(r0);
            }

            @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
            public boolean isCaptureResultNeeded() {
                Iterator<PipelineTask> r0 = this.this$0.mTasks.iterator();
            L4:
                if (r0.hasNext() == false) goto L9;
                if (r0.next().isCaptureResultNeeded() == false) goto L4;
                return true;
            L9:
                return false;
            }

            @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
            public void postCapture() {
                Iterator<PipelineTask> r0 = this.this$0.mTasks.iterator();
            L4:
                if (r0.hasNext() == false) goto L6;
                r0.next().postCapture();
                goto L4
            }

            public AnonymousClass1(Pipeline r1) {
                this.this$0 = r1;
            }

            private static /* synthetic */ Boolean lambda$preCapture$0(List r1) {
                return Boolean.valueOf(r1.contains(Boolean.TRUE));
            }

            @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
            public ListenableFuture<Boolean> preCapture(TotalCaptureResult r4) {
                ArrayList r0 = new ArrayList();
                Iterator<PipelineTask> r1 = this.this$0.mTasks.iterator();
            L4:
                if (r1.hasNext() == false) goto L7;
                r0.add(r1.next().preCapture(r4));
                goto L4
            L7:
                return Futures.transform(Futures.allAsList(r0), new c1(), CameraXExecutors.directExecutor());
            }
        }

        public static /* synthetic */ Object a(Pipeline r0, CaptureConfig.Builder r1, CallbackToFutureAdapter.Completer r2) {
            return r0.lambda$submitConfigsInternal$4(r1, r2);
        }

        public static /* synthetic */ boolean b(TotalCaptureResult r0) {
            return lambda$executePreCapture$2(r0);
        }

        public static /* synthetic */ ListenableFuture c(Pipeline r0, int r1, TotalCaptureResult r2) {
            return r0.lambda$executePreCapture$1(r1, r2);
        }

        public static /* synthetic */ ListenableFuture d(Pipeline r0, Boolean r1) {
            return r0.lambda$executePreCapture$3(r1);
        }

        public static /* synthetic */ ListenableFuture e(Pipeline r0, List r1, int r2, TotalCaptureResult r3) {
            return r0.lambda$executeCapture$0(r1, r2, r3);
        }

        static {
            TimeUnit r0 = TimeUnit.SECONDS;
            CHECK_3A_TIMEOUT_IN_NS = r0.toNanos(1);
            CHECK_3A_WITH_FLASH_TIMEOUT_IN_NS = r0.toNanos(5);
        }

        public void executePostCapture() {
            this.mPipelineSubTask.postCapture();
        }

        private void applyAeModeQuirk(CaptureConfig.Builder r4) {
            Camera2ImplConfig.Builder r0 = new Camera2ImplConfig.Builder();
            r0.setCaptureRequestOption(CaptureRequest.CONTROL_AE_MODE, 3);
            r4.addImplementationOptions(r0.build());
        }

        private static /* synthetic */ boolean lambda$executePreCapture$2(TotalCaptureResult r1) {
            return Camera2CapturePipeline.is3AConverged(r1, false);
        }

        private /* synthetic */ ListenableFuture lambda$executePreCapture$3(Boolean r5) throws Exception {
            if (Boolean.TRUE.equals(r5) == false) goto L7;
            return Camera2CapturePipeline.waitForResult(this.mTimeout3A, this.mScheduler, this.mCameraControl, new b1());
        L7:
            return Futures.immediateFuture(null);
        }

        private void setTimeout3A(long r1) {
            this.mTimeout3A = r1;
        }

        public void addTask(PipelineTask r2) {
            this.mTasks.add(r2);
        }

        public ListenableFuture<TotalCaptureResult> executePreCapture(final int r4) {
            ListenableFuture<TotalCaptureResult> r1 = Futures.immediateFuture(null);
            if (this.mTasks.isEmpty() == false) goto L5;
            return r1;
        L5:
            if (this.mPipelineSubTask.isCaptureResultNeeded() == false) goto L7;
            ListenableFuture<TotalCaptureResult> r0 = Camera2CapturePipeline.waitForResult(this.mCameraControl, null);
        L9:
            return FutureChain.from(r0).transformAsync(new x0(this, r4), this.mExecutor).transformAsync(new y0(this), this.mExecutor);
        L7:
            r0 = Futures.immediateFuture(null);
            goto L9
        }

        private void applyStillCaptureTemplate(CaptureConfig.Builder r4, CaptureConfig r5) {
            if (this.mTemplate != 3) goto L8;
            if (this.mIsLegacyDevice == true) goto L8;
            int r6 = 4;
        L14:
            if (r6 == (-1)) goto L17;
            r4.setTemplateType(r6);
            return;
        L17:
            return;
        L8:
            if (r5.getTemplateType() != (-1)) goto L10;
        L13:
            r6 = 2;
            goto L14
        L10:
            if (r5.getTemplateType() == 5) goto L13;
            r6 = -1;
            goto L14
        }

        private /* synthetic */ ListenableFuture lambda$executePreCapture$1(int r3, TotalCaptureResult r4) throws Exception {
            if (Camera2CapturePipeline.isFlashRequired(r3, r4) == false) goto L6;
            setTimeout3A(CHECK_3A_WITH_FLASH_TIMEOUT_IN_NS);
        L6:
            return this.mPipelineSubTask.preCapture(r4);
        }

        private /* synthetic */ Object lambda$submitConfigsInternal$4(CaptureConfig.Builder r2, final CallbackToFutureAdapter.Completer r3) throws Exception {
            r2.addCameraCaptureCallback(new AnonymousClass2(this, r3));
            return "submitStillCapture";
        }

        public ListenableFuture<List<Void>> executeCapture(final List<CaptureConfig> r3, final int r4) {
            FutureChain r5 = FutureChain.from(executePreCapture(r4)).transformAsync(new z0(this, r3, r4), this.mExecutor);
            r5.addListener(new a1(this), this.mExecutor);
            return r5;
        }

        public ListenableFuture<List<Void>> submitConfigsInternal(List<CaptureConfig> r7, int r8) {
            ArrayList r0 = new ArrayList();
            ArrayList r1 = new ArrayList();
            Iterator<CaptureConfig> r9 = r7.iterator();
        L4:
            if (r9.hasNext() == false) goto L27;
            CaptureConfig r2 = r9.next();
            final CaptureConfig.Builder r3 = CaptureConfig.Builder.from(r2);
            if (r2.getTemplateType() == 5) goto L8;
        L19:
            CameraCaptureResult r4 = null;
        L20:
            if (r4 == null) goto L22;
            r3.setCameraCaptureResult(r4);
        L24:
            if (this.mOverrideAeModeForStillCapture.shouldSetAeModeAlwaysFlash(r8) == false) goto L26;
            applyAeModeQuirk(r3);
        L26:
            r0.add(CallbackToFutureAdapter.getFuture(new w0(this, r3)));
            r1.add(r3.build());
            goto L4
        L22:
            applyStillCaptureTemplate(r3, r2);
            goto L24
        L8:
            if (this.mCameraControl.getZslControl().isZslDisabledByFlashMode() == true) goto L19;
            if (this.mCameraControl.getZslControl().isZslDisabledByUserCaseConfig() == true) goto L19;
            ImageProxy r5 = this.mCameraControl.getZslControl().dequeueImageFromBuffer();
            if (r5 != null) goto L14;
        L16:
            boolean r6 = false;
        L17:
            if (r6 == false) goto L19;
            r4 = CameraCaptureResults.retrieveCameraCaptureResult(r5.getImageInfo());
            goto L20
        L14:
            if (this.mCameraControl.getZslControl().enqueueImageToImageWriter(r5) == false) goto L16;
            r6 = true;
            goto L17
        L27:
            this.mCameraControl.submitCaptureRequestsInternal(r1);
            return Futures.allAsList(r0);
        }

        private /* synthetic */ ListenableFuture lambda$executeCapture$0(List r1, int r2, TotalCaptureResult r3) throws Exception {
            return submitConfigsInternal(r1, r2);
        }

        public Pipeline(int r3, Executor r4, ScheduledExecutorService r5, Camera2CameraControlImpl r6, boolean r7, OverrideAeModeForStillCapture r8) {
            this.mTimeout3A = CHECK_3A_TIMEOUT_IN_NS;
            this.mTasks = new ArrayList();
            this.mPipelineSubTask = new AnonymousClass1(this);
            this.mTemplate = r3;
            this.mExecutor = r4;
            this.mScheduler = r5;
            this.mCameraControl = r6;
            this.mIsLegacyDevice = r7;
            this.mOverrideAeModeForStillCapture = r8;
        }
    }

    public interface PipelineTask {
        boolean isCaptureResultNeeded();

        void postCapture();

        ListenableFuture<Boolean> preCapture(TotalCaptureResult r1);
    }

    public static class ResultListener implements Camera2CameraControlImpl.CaptureResultListener {
        private final Checker mChecker;
        private CallbackToFutureAdapter.Completer<TotalCaptureResult> mCompleter;
        private final ListenableFuture<TotalCaptureResult> mFuture;

        public interface Checker {
            boolean check(TotalCaptureResult r1);
        }

        public static /* synthetic */ Object a(ResultListener r0, CallbackToFutureAdapter.Completer r1) {
            return r0.lambda$new$0(r1);
        }

        public ListenableFuture<TotalCaptureResult> getFuture() {
            return this.mFuture;
        }

        public ResultListener(Checker r2) {
            this.mFuture = CallbackToFutureAdapter.getFuture(new d1(this));
            this.mChecker = r2;
        }

        private /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.Completer r1) throws Exception {
            this.mCompleter = r1;
            return "waitFor3AResult";
        }

        @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
        public boolean onCaptureResult(TotalCaptureResult r2) {
            Checker r0 = this.mChecker;
            if (r0 != null) goto L5;
        L8:
            this.mCompleter.set(r2);
            return true;
        L5:
            if (r0.check(r2) == true) goto L8;
            return false;
        }
    }

    public static class ScreenFlashTask implements PipelineTask {
        private static final long CHECK_3A_WITH_SCREEN_FLASH_TIMEOUT_IN_NS = 0;
        private final Camera2CameraControlImpl mCameraControl;
        private final Executor mExecutor;
        private final ScheduledExecutorService mScheduler;
        private final ImageCapture.ScreenFlash mScreenFlash;
        private final UseFlashModeTorchFor3aUpdate mUseFlashModeTorchFor3aUpdate;

        public static /* synthetic */ ListenableFuture a(ScreenFlashTask r0, ListenableFuture r1, Object r2) {
            return r0.lambda$preCapture$7(r1, r2);
        }

        public static /* synthetic */ Boolean b(TotalCaptureResult r0) {
            return lambda$preCapture$11(r0);
        }

        public static /* synthetic */ void c(CallbackToFutureAdapter.Completer r0) {
            lambda$preCapture$0(r0);
        }

        public static /* synthetic */ boolean d(TotalCaptureResult r0) {
            return lambda$preCapture$9(r0);
        }

        public static /* synthetic */ Object e(ScreenFlashTask r0, AtomicReference r1, CallbackToFutureAdapter.Completer r2) {
            return r0.lambda$preCapture$3(r1, r2);
        }

        public static /* synthetic */ ListenableFuture f(ScreenFlashTask r0, Void r1) {
            return r0.lambda$preCapture$4(r1);
        }

        public static /* synthetic */ void g(ScreenFlashTask r0, AtomicReference r1, CallbackToFutureAdapter.Completer r2) {
            r0.lambda$preCapture$2(r1, r2);
        }

        public static /* synthetic */ Object h(ScreenFlashTask r0, CallbackToFutureAdapter.Completer r1) {
            return r0.lambda$preCapture$5(r1);
        }

        public static /* synthetic */ ListenableFuture i(ScreenFlashTask r0, Void r1) {
            return r0.lambda$preCapture$8(r1);
        }

        public static /* synthetic */ ListenableFuture j(ScreenFlashTask r0, Void r1) {
            return r0.lambda$preCapture$10(r1);
        }

        public static /* synthetic */ Object k(AtomicReference r0, CallbackToFutureAdapter.Completer r1) {
            return lambda$preCapture$1(r0, r1);
        }

        public static /* synthetic */ ListenableFuture l(ScreenFlashTask r0, Void r1) {
            return r0.lambda$preCapture$6(r1);
        }

        private static /* synthetic */ void lambda$postCapture$12() {
        }

        public static /* synthetic */ void m() {
            lambda$postCapture$12();
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public boolean isCaptureResultNeeded() {
            return false;
        }

        static {
            CHECK_3A_WITH_SCREEN_FLASH_TIMEOUT_IN_NS = TimeUnit.SECONDS.toNanos(2);
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public void postCapture() {
            Logger.d(Camera2CapturePipeline.TAG, "ScreenFlashTask#postCapture");
            if (this.mUseFlashModeTorchFor3aUpdate.shouldUseFlashModeTorch() == false) goto L5;
            this.mCameraControl.enableTorchInternal(false);
        L5:
            this.mCameraControl.getFocusMeteringControl().enableExternalFlashAeMode(false).addListener(new l1(), this.mExecutor);
            this.mCameraControl.getFocusMeteringControl().cancelAfAeTrigger(false, true);
            ScheduledExecutorService r0 = CameraXExecutors.mainThreadExecutor();
            final ImageCapture.ScreenFlash r1 = this.mScreenFlash;
            Objects.requireNonNull(r1);
            r0.execute(new m1(r1));
        }

        private static /* synthetic */ void lambda$preCapture$0(CallbackToFutureAdapter.Completer r2) {
            Logger.d(Camera2CapturePipeline.TAG, "ScreenFlashTask#preCapture: UI change applied");
            r2.set(null);
        }

        private /* synthetic */ ListenableFuture lambda$preCapture$10(Void r5) throws Exception {
            return Camera2CapturePipeline.waitForResult(CHECK_3A_WITH_SCREEN_FLASH_TIMEOUT_IN_NS, this.mScheduler, this.mCameraControl, new n1());
        }

        private static /* synthetic */ Boolean lambda$preCapture$11(TotalCaptureResult r0) {
            return Boolean.FALSE;
        }

        private /* synthetic */ ListenableFuture lambda$preCapture$4(Void r2) throws Exception {
            return this.mCameraControl.getFocusMeteringControl().enableExternalFlashAeMode(true);
        }

        private /* synthetic */ Object lambda$preCapture$5(CallbackToFutureAdapter.Completer r5) throws Exception {
            if (this.mUseFlashModeTorchFor3aUpdate.shouldUseFlashModeTorch() == true) goto L6;
            r5.set(null);
            return "EnableTorchInternal";
        L6:
            Logger.d(Camera2CapturePipeline.TAG, "ScreenFlashTask#preCapture: enable torch");
            this.mCameraControl.enableTorchInternal(true);
            r5.set(null);
            return "EnableTorchInternal";
        }

        private /* synthetic */ ListenableFuture lambda$preCapture$6(Void r1) throws Exception {
            return CallbackToFutureAdapter.getFuture(new j1(this));
        }

        private /* synthetic */ ListenableFuture lambda$preCapture$8(Void r1) throws Exception {
            return this.mCameraControl.getFocusMeteringControl().triggerAePrecapture();
        }

        private static /* synthetic */ boolean lambda$preCapture$9(TotalCaptureResult r1) {
            return Camera2CapturePipeline.is3AConverged(r1, false);
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public ListenableFuture<Boolean> preCapture(TotalCaptureResult r4) {
            Logger.d(Camera2CapturePipeline.TAG, "ScreenFlashTask#preCapture");
            final AtomicReference r5 = new AtomicReference();
            final ListenableFuture r0 = CallbackToFutureAdapter.getFuture(new o1(r5));
            return FutureChain.from(CallbackToFutureAdapter.getFuture(new p1(this, r5))).transformAsync(new q1(this), this.mExecutor).transformAsync(new r1(this), this.mExecutor).transformAsync(new f1(this, r0), this.mExecutor).transformAsync(new g1(this), this.mExecutor).transformAsync(new h1(this), this.mExecutor).transform(new i1(), CameraXExecutors.directExecutor());
        }

        private static /* synthetic */ Object lambda$preCapture$1(AtomicReference r1, final CallbackToFutureAdapter.Completer r2) throws Exception {
            r1.set(new e1(r2));
            return "OnScreenFlashUiApplied";
        }

        private /* synthetic */ void lambda$preCapture$2(AtomicReference r7, CallbackToFutureAdapter.Completer r8) {
            Logger.d(Camera2CapturePipeline.TAG, "ScreenFlashTask#preCapture: invoking applyScreenFlashUi");
            this.mScreenFlash.apply(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(3), (ImageCapture.ScreenFlashListener) r7.get());
            r8.set(null);
        }

        private /* synthetic */ Object lambda$preCapture$3(final AtomicReference r3, final CallbackToFutureAdapter.Completer r4) throws Exception {
            CameraXExecutors.mainThreadExecutor().execute(new k1(this, r3, r4));
            return "OnScreenFlashStart";
        }

        private /* synthetic */ ListenableFuture lambda$preCapture$7(ListenableFuture r9, Object r10) throws Exception {
            return Futures.makeTimeoutFuture(TimeUnit.SECONDS.toMillis(3), this.mScheduler, null, true, r9);
        }

        public ScreenFlashTask(Camera2CameraControlImpl r1, Executor r2, ScheduledExecutorService r3, UseFlashModeTorchFor3aUpdate r4) {
            this.mCameraControl = r1;
            this.mExecutor = r2;
            this.mScheduler = r3;
            this.mUseFlashModeTorchFor3aUpdate = r4;
            ImageCapture.ScreenFlash r5 = r1.getScreenFlash();
            Objects.requireNonNull(r5);
            this.mScreenFlash = r5;
        }
    }

    public static class TorchTask implements PipelineTask {
        private static final long CHECK_3A_WITH_TORCH_TIMEOUT_IN_NS = 0;
        private final Camera2CameraControlImpl mCameraControl;
        private final Executor mExecutor;
        private final int mFlashMode;
        private boolean mIsExecuted;
        private final ScheduledExecutorService mScheduler;
        private final boolean mTriggerAePrecapture;

        public static /* synthetic */ boolean a(TotalCaptureResult r0) {
            return lambda$preCapture$2(r0);
        }

        public static /* synthetic */ Object b(TorchTask r0, CallbackToFutureAdapter.Completer r1) {
            return r0.lambda$preCapture$0(r1);
        }

        public static /* synthetic */ Boolean c(TotalCaptureResult r0) {
            return lambda$preCapture$4(r0);
        }

        public static /* synthetic */ ListenableFuture d(TorchTask r0, Void r1) {
            return r0.lambda$preCapture$1(r1);
        }

        public static /* synthetic */ ListenableFuture e(TorchTask r0, Void r1) {
            return r0.lambda$preCapture$3(r1);
        }

        static {
            CHECK_3A_WITH_TORCH_TIMEOUT_IN_NS = TimeUnit.SECONDS.toNanos(2);
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public boolean isCaptureResultNeeded() {
            if (this.mFlashMode != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public void postCapture() {
            if (this.mIsExecuted == false) goto L8;
            this.mCameraControl.getTorchControl().enableTorchInternal(null, false);
            Logger.d(Camera2CapturePipeline.TAG, "Turning off torch");
            if (this.mTriggerAePrecapture == false) goto L9;
            this.mCameraControl.getFocusMeteringControl().cancelAfAeTrigger(false, true);
            return;
        L9:
            return;
        }

        private /* synthetic */ Object lambda$preCapture$0(CallbackToFutureAdapter.Completer r3) throws Exception {
            this.mCameraControl.getTorchControl().enableTorchInternal(r3, true);
            return "TorchOn";
        }

        private /* synthetic */ ListenableFuture lambda$preCapture$1(Void r1) throws Exception {
            if (this.mTriggerAePrecapture == false) goto L7;
            return this.mCameraControl.getFocusMeteringControl().triggerAePrecapture();
        L7:
            return Futures.immediateFuture(null);
        }

        private static /* synthetic */ boolean lambda$preCapture$2(TotalCaptureResult r1) {
            return Camera2CapturePipeline.is3AConverged(r1, true);
        }

        private /* synthetic */ ListenableFuture lambda$preCapture$3(Void r5) throws Exception {
            return Camera2CapturePipeline.waitForResult(CHECK_3A_WITH_TORCH_TIMEOUT_IN_NS, this.mScheduler, this.mCameraControl, new s1());
        }

        private static /* synthetic */ Boolean lambda$preCapture$4(TotalCaptureResult r0) {
            return Boolean.FALSE;
        }

        @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.PipelineTask
        public ListenableFuture<Boolean> preCapture(TotalCaptureResult r4) {
            Logger.d(Camera2CapturePipeline.TAG, "TorchTask#preCapture: isFlashRequired = " + Camera2CapturePipeline.isFlashRequired(this.mFlashMode, r4));
            if (Camera2CapturePipeline.isFlashRequired(this.mFlashMode, r4) == false) goto L10;
            if (this.mCameraControl.isTorchOn() == false) goto L7;
            Logger.d(Camera2CapturePipeline.TAG, "Torch already on, not turn on");
            goto L10
        L7:
            Logger.d(Camera2CapturePipeline.TAG, "Turn on torch");
            this.mIsExecuted = true;
            return FutureChain.from(CallbackToFutureAdapter.getFuture(new t1(this))).transformAsync(new u1(this), this.mExecutor).transformAsync(new v1(this), this.mExecutor).transform(new w1(), CameraXExecutors.directExecutor());
        L10:
            return Futures.immediateFuture(Boolean.FALSE);
        }

        public TorchTask(Camera2CameraControlImpl r2, int r3, Executor r4, ScheduledExecutorService r5, boolean r6) {
            this.mIsExecuted = false;
            this.mCameraControl = r2;
            this.mFlashMode = r3;
            this.mExecutor = r4;
            this.mScheduler = r5;
            this.mTriggerAePrecapture = r6;
        }
    }

    public static /* synthetic */ void a(Camera2CameraControlImpl r0, ResultListener r1) {
        lambda$waitForResult$0(r0, r1);
    }

    private boolean isTorchAsFlash(int r4) {
        if (this.mUseTorchAsFlash.shouldUseTorchAsFlash() == false) goto L5;
        return true;
    L5:
        if (this.mTemplate == 3) goto L11;
        if (r4 == 1) goto L12;
        return false;
    L12:
        return true;
    L11:
        return true;
    }

    public void setTemplate(int r1) {
        this.mTemplate = r1;
    }

    public static boolean is3AConverged(TotalCaptureResult r1, boolean r2) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return ConvergenceUtils.is3AConverged(new Camera2CameraCaptureResult(r1), r2);
    }

    public static boolean isFlashRequired(int r4, TotalCaptureResult r5) {
        Logger.d(TAG, "isFlashRequired: flashMode = " + r4);
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L6;
    L13:
        return true;
    L6:
        if (r4 != 2) goto L8;
        return false;
    L8:
        if (r4 == 3) goto L13;
        throw new AssertionError(r4);
    L14:
        if (r5 == null) goto L16;
        Integer r6 = (Integer) r5.get(CaptureResult.CONTROL_AE_STATE);
    L17:
        Logger.d(TAG, "isFlashRequired: aeState = " + r6);
        if (r6 != null) goto L20;
        return false;
    L20:
        if (r6.intValue() != 4) goto L24;
        return true;
    L24:
        return false;
    L16:
        r6 = null;
        goto L17
    }

    private static /* synthetic */ void lambda$waitForResult$0(Camera2CameraControlImpl r0, ResultListener r1) {
        r0.removeCaptureResultListener(r1);
    }

    public static ListenableFuture<TotalCaptureResult> waitForResult(final Camera2CameraControlImpl r2, ResultListener.Checker r3) {
        final ResultListener r0 = new ResultListener(r3);
        r2.addCaptureResultListener(r0);
        ListenableFuture<TotalCaptureResult> r4 = r0.getFuture();
        r4.addListener(new r0(r2, r0), r2.mExecutor);
        return r4;
    }

    public Pipeline createPipeline(int r10, int r11, int r12) {
        OverrideAeModeForStillCapture r7 = new OverrideAeModeForStillCapture(this.mCameraQuirk);
        Pipeline r8 = new Pipeline(this.mTemplate, this.mExecutor, this.mScheduler, this.mCameraControl, this.mIsLegacyDevice, r7);
        if (r10 != 0) goto L6;
        r8.addTask(new AfTask(this.mCameraControl));
    L6:
        if (r11 != 3) goto L9;
        r8.addTask(new ScreenFlashTask(this.mCameraControl, this.mExecutor, this.mScheduler, new UseFlashModeTorchFor3aUpdate(this.mCameraQuirk)));
    L20:
        Logger.d(TAG, "createPipeline: captureMode = " + r10 + ", flashMode = " + r11 + ", flashType = " + r12 + ", pipeline tasks = " + r8.mTasks);
        return r8;
    L9:
        if (this.mHasFlashUnit == false) goto L20;
        if (isTorchAsFlash(r12) == true) goto L13;
        r8.addTask(new AePreCaptureTask(this.mCameraControl, r11, r7));
        goto L20
    L13:
        if (this.mUseTorchAsFlash.shouldUseTorchAsFlash() == false) goto L15;
    L17:
        boolean r6 = false;
    L18:
        r8.addTask(new TorchTask(this.mCameraControl, r11, this.mExecutor, this.mScheduler, r6));
        goto L20
    L15:
        if (this.mCameraControl.isInVideoUsage() == true) goto L17;
        r6 = true;
        goto L18
    }

    public CameraCapturePipeline getCameraCapturePipeline(int r2, int r3, int r4) {
        return new CameraCapturePipelineImpl(createPipeline(r2, r3, r4), this.mExecutor, r3);
    }

    public static ListenableFuture<TotalCaptureResult> waitForResult(long r7, ScheduledExecutorService r9, Camera2CameraControlImpl r10, ResultListener.Checker r11) {
        return Futures.makeTimeoutFuture(TimeUnit.NANOSECONDS.toMillis(r7), r9, null, true, waitForResult(r10, r11));
    }

    public ListenableFuture<List<Void>> submitStillCaptures(List<CaptureConfig> r1, int r2, int r3, int r4) {
        return Futures.nonCancellationPropagating(createPipeline(r2, r3, r4).executeCapture(r1, r3));
    }

    public Camera2CapturePipeline(Camera2CameraControlImpl r3, CameraCharacteristicsCompat r4, Quirks r5, Executor r6, ScheduledExecutorService r7) {
        boolean r0 = true;
        this.mTemplate = 1;
        this.mCameraControl = r3;
        Integer r8 = (Integer) r4.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (r8 != null) goto L5;
    L7:
        r0 = false;
    L8:
        this.mIsLegacyDevice = r0;
        this.mExecutor = r6;
        this.mScheduler = r7;
        this.mCameraQuirk = r5;
        this.mUseTorchAsFlash = new UseTorchAsFlash(r5);
        this.mHasFlashUnit = FlashAvailabilityChecker.isFlashAvailable(new p0(r4));
        return;
    L5:
        if (r8.intValue() != 2) goto L7;
        goto L7
    }
}
