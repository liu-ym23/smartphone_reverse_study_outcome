package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class CameraCaptureSessionCompat {
    private final CameraCaptureSessionCompatImpl mImpl;

    public interface CameraCaptureSessionCompatImpl {
        int captureBurstRequests(List<CaptureRequest> r1, Executor r2, CameraCaptureSession.CaptureCallback r3) throws CameraAccessException;

        int captureSingleRequest(CaptureRequest r1, Executor r2, CameraCaptureSession.CaptureCallback r3) throws CameraAccessException;

        int setRepeatingBurstRequests(List<CaptureRequest> r1, Executor r2, CameraCaptureSession.CaptureCallback r3) throws CameraAccessException;

        int setSingleRepeatingRequest(CaptureRequest r1, Executor r2, CameraCaptureSession.CaptureCallback r3) throws CameraAccessException;

        CameraCaptureSession unwrap();
    }

    public static final class CaptureCallbackExecutorWrapper extends CameraCaptureSession.CaptureCallback {
        private final Executor mExecutor;
        final CameraCaptureSession.CaptureCallback mWrappedCallback;

        public static /* synthetic */ void a(CaptureCallbackExecutorWrapper r0, CameraCaptureSession r1, CaptureRequest r2, Surface r3, long r4) {
            r0.lambda$onCaptureBufferLost$6(r1, r2, r3, r4);
        }

        public static /* synthetic */ void b(CaptureCallbackExecutorWrapper r0, CameraCaptureSession r1, CaptureRequest r2, CaptureResult r3) {
            r0.lambda$onCaptureProgressed$1(r1, r2, r3);
        }

        public static /* synthetic */ void c(CaptureCallbackExecutorWrapper r0, CameraCaptureSession r1, int r2) {
            r0.lambda$onCaptureSequenceAborted$5(r1, r2);
        }

        public static /* synthetic */ void d(CaptureCallbackExecutorWrapper r0, CameraCaptureSession r1, CaptureRequest r2, long r3, long r5) {
            r0.lambda$onCaptureStarted$0(r1, r2, r3, r5);
        }

        public static /* synthetic */ void e(CaptureCallbackExecutorWrapper r0, CameraCaptureSession r1, int r2, long r3) {
            r0.lambda$onCaptureSequenceCompleted$4(r1, r2, r3);
        }

        public static /* synthetic */ void f(CaptureCallbackExecutorWrapper r0, CameraCaptureSession r1, CaptureRequest r2, TotalCaptureResult r3) {
            r0.lambda$onCaptureCompleted$2(r1, r2, r3);
        }

        public static /* synthetic */ void g(CaptureCallbackExecutorWrapper r0, CameraCaptureSession r1, CaptureRequest r2, CaptureFailure r3) {
            r0.lambda$onCaptureFailed$3(r1, r2, r3);
        }

        public CaptureCallbackExecutorWrapper(Executor r1, CameraCaptureSession.CaptureCallback r2) {
            this.mExecutor = r1;
            this.mWrappedCallback = r2;
        }

        private /* synthetic */ void lambda$onCaptureSequenceAborted$5(CameraCaptureSession r2, int r3) {
            this.mWrappedCallback.onCaptureSequenceAborted(r2, r3);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(final CameraCaptureSession r3, final int r4) {
            this.mExecutor.execute(new a(this, r3, r4));
        }

        private /* synthetic */ void lambda$onCaptureCompleted$2(CameraCaptureSession r2, CaptureRequest r3, TotalCaptureResult r4) {
            this.mWrappedCallback.onCaptureCompleted(r2, r3, r4);
        }

        private /* synthetic */ void lambda$onCaptureFailed$3(CameraCaptureSession r2, CaptureRequest r3, CaptureFailure r4) {
            this.mWrappedCallback.onCaptureFailed(r2, r3, r4);
        }

        private /* synthetic */ void lambda$onCaptureProgressed$1(CameraCaptureSession r2, CaptureRequest r3, CaptureResult r4) {
            this.mWrappedCallback.onCaptureProgressed(r2, r3, r4);
        }

        private /* synthetic */ void lambda$onCaptureSequenceCompleted$4(CameraCaptureSession r2, int r3, long r4) {
            this.mWrappedCallback.onCaptureSequenceCompleted(r2, r3, r4);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(final CameraCaptureSession r3, final CaptureRequest r4, final TotalCaptureResult r5) {
            this.mExecutor.execute(new e(this, r3, r4, r5));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(final CameraCaptureSession r3, final CaptureRequest r4, final CaptureFailure r5) {
            this.mExecutor.execute(new g(this, r3, r4, r5));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(final CameraCaptureSession r3, final CaptureRequest r4, final CaptureResult r5) {
            this.mExecutor.execute(new d(this, r3, r4, r5));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceCompleted(final CameraCaptureSession r9, final int r10, final long r11) {
            this.mExecutor.execute(new c(this, r9, r10, r11));
        }

        private /* synthetic */ void lambda$onCaptureBufferLost$6(CameraCaptureSession r7, CaptureRequest r8, Surface r9, long r10) {
            ApiCompat.Api24Impl.onCaptureBufferLost(this.mWrappedCallback, r7, r8, r9, r10);
        }

        private /* synthetic */ void lambda$onCaptureStarted$0(CameraCaptureSession r8, CaptureRequest r9, long r10, long r12) {
            this.mWrappedCallback.onCaptureStarted(r8, r9, r10, r12);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureBufferLost(final CameraCaptureSession r10, final CaptureRequest r11, final Surface r12, final long r13) {
            this.mExecutor.execute(new b(this, r10, r11, r12, r13));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(final CameraCaptureSession r12, final CaptureRequest r13, final long r14, final long r16) {
            this.mExecutor.execute(new f(this, r12, r13, r14, r16));
        }
    }

    public static final class StateCallbackExecutorWrapper extends CameraCaptureSession.StateCallback {
        private final Executor mExecutor;
        final CameraCaptureSession.StateCallback mWrappedCallback;

        public static /* synthetic */ void a(StateCallbackExecutorWrapper r0, CameraCaptureSession r1, Surface r2) {
            r0.lambda$onSurfacePrepared$6(r1, r2);
        }

        public static /* synthetic */ void b(StateCallbackExecutorWrapper r0, CameraCaptureSession r1) {
            r0.lambda$onActive$3(r1);
        }

        public static /* synthetic */ void c(StateCallbackExecutorWrapper r0, CameraCaptureSession r1) {
            r0.lambda$onClosed$5(r1);
        }

        public static /* synthetic */ void d(StateCallbackExecutorWrapper r0, CameraCaptureSession r1) {
            r0.lambda$onCaptureQueueEmpty$4(r1);
        }

        public static /* synthetic */ void e(StateCallbackExecutorWrapper r0, CameraCaptureSession r1) {
            r0.lambda$onConfigured$0(r1);
        }

        public static /* synthetic */ void f(StateCallbackExecutorWrapper r0, CameraCaptureSession r1) {
            r0.lambda$onConfigureFailed$1(r1);
        }

        public static /* synthetic */ void g(StateCallbackExecutorWrapper r0, CameraCaptureSession r1) {
            r0.lambda$onReady$2(r1);
        }

        private /* synthetic */ void lambda$onActive$3(CameraCaptureSession r2) {
            this.mWrappedCallback.onActive(r2);
        }

        private /* synthetic */ void lambda$onCaptureQueueEmpty$4(CameraCaptureSession r2) {
            ApiCompat.Api26Impl.onCaptureQueueEmpty(this.mWrappedCallback, r2);
        }

        private /* synthetic */ void lambda$onClosed$5(CameraCaptureSession r2) {
            this.mWrappedCallback.onClosed(r2);
        }

        private /* synthetic */ void lambda$onConfigureFailed$1(CameraCaptureSession r2) {
            this.mWrappedCallback.onConfigureFailed(r2);
        }

        private /* synthetic */ void lambda$onConfigured$0(CameraCaptureSession r2) {
            this.mWrappedCallback.onConfigured(r2);
        }

        private /* synthetic */ void lambda$onReady$2(CameraCaptureSession r2) {
            this.mWrappedCallback.onReady(r2);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onActive(final CameraCaptureSession r3) {
            this.mExecutor.execute(new k(this, r3));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onCaptureQueueEmpty(final CameraCaptureSession r3) {
            this.mExecutor.execute(new j(this, r3));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(final CameraCaptureSession r3) {
            this.mExecutor.execute(new i(this, r3));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(final CameraCaptureSession r3) {
            this.mExecutor.execute(new l(this, r3));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(final CameraCaptureSession r3) {
            this.mExecutor.execute(new h(this, r3));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(final CameraCaptureSession r3) {
            this.mExecutor.execute(new m(this, r3));
        }

        public StateCallbackExecutorWrapper(Executor r1, CameraCaptureSession.StateCallback r2) {
            this.mExecutor = r1;
            this.mWrappedCallback = r2;
        }

        private /* synthetic */ void lambda$onSurfacePrepared$6(CameraCaptureSession r2, Surface r3) {
            ApiCompat.Api23Impl.onSurfacePrepared(this.mWrappedCallback, r2, r3);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onSurfacePrepared(final CameraCaptureSession r3, final Surface r4) {
            this.mExecutor.execute(new n(this, r3, r4));
        }
    }

    public CameraCaptureSession toCameraCaptureSession() {
        return this.mImpl.unwrap();
    }

    public static CameraCaptureSessionCompat toCameraCaptureSessionCompat(CameraCaptureSession r1) {
        return toCameraCaptureSessionCompat(r1, MainThreadAsyncHandler.getInstance());
    }

    private CameraCaptureSessionCompat(CameraCaptureSession r3, Handler r4) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.mImpl = new CameraCaptureSessionCompatApi28Impl(r3);
        return;
    L5:
        this.mImpl = CameraCaptureSessionCompatBaseImpl.create(r3, r4);
    }

    public static CameraCaptureSessionCompat toCameraCaptureSessionCompat(CameraCaptureSession r1, Handler r2) {
        return new CameraCaptureSessionCompat(r1, r2);
    }

    public int captureBurstRequests(List<CaptureRequest> r2, Executor r3, CameraCaptureSession.CaptureCallback r4) throws CameraAccessException {
        return this.mImpl.captureBurstRequests(r2, r3, r4);
    }

    public int captureSingleRequest(CaptureRequest r2, Executor r3, CameraCaptureSession.CaptureCallback r4) throws CameraAccessException {
        return this.mImpl.captureSingleRequest(r2, r3, r4);
    }

    public int setRepeatingBurstRequests(List<CaptureRequest> r2, Executor r3, CameraCaptureSession.CaptureCallback r4) throws CameraAccessException {
        return this.mImpl.setRepeatingBurstRequests(r2, r3, r4);
    }

    public int setSingleRepeatingRequest(CaptureRequest r2, Executor r3, CameraCaptureSession.CaptureCallback r4) throws CameraAccessException {
        return this.mImpl.setSingleRepeatingRequest(r2, r3, r4);
    }
}
