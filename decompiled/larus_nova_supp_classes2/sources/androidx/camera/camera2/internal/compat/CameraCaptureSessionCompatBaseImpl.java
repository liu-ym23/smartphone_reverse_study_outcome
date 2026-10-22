package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class CameraCaptureSessionCompatBaseImpl implements CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl {
    final CameraCaptureSession mCameraCaptureSession;
    final Object mObject;

    public static class CameraCaptureSessionCompatParamsApi21 {
        final Handler mCompatHandler;

        public CameraCaptureSessionCompatParamsApi21(Handler r1) {
            this.mCompatHandler = r1;
        }
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public CameraCaptureSession unwrap() {
        return this.mCameraCaptureSession;
    }

    public CameraCaptureSessionCompatBaseImpl(CameraCaptureSession r1, Object r2) {
        this.mCameraCaptureSession = (CameraCaptureSession) Preconditions.checkNotNull(r1);
        this.mObject = r2;
    }

    public static CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl create(CameraCaptureSession r2, Handler r3) {
        return new CameraCaptureSessionCompatBaseImpl(r2, new CameraCaptureSessionCompatParamsApi21(r3));
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int captureBurstRequests(List<CaptureRequest> r2, Executor r3, CameraCaptureSession.CaptureCallback r4) throws CameraAccessException {
        CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper r0 = new CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper(r3, r4);
        CameraCaptureSessionCompatParamsApi21 r5 = (CameraCaptureSessionCompatParamsApi21) this.mObject;
        return this.mCameraCaptureSession.captureBurst(r2, r0, r5.mCompatHandler);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int captureSingleRequest(CaptureRequest r2, Executor r3, CameraCaptureSession.CaptureCallback r4) throws CameraAccessException {
        CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper r0 = new CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper(r3, r4);
        CameraCaptureSessionCompatParamsApi21 r5 = (CameraCaptureSessionCompatParamsApi21) this.mObject;
        return this.mCameraCaptureSession.capture(r2, r0, r5.mCompatHandler);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int setRepeatingBurstRequests(List<CaptureRequest> r2, Executor r3, CameraCaptureSession.CaptureCallback r4) throws CameraAccessException {
        CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper r0 = new CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper(r3, r4);
        CameraCaptureSessionCompatParamsApi21 r5 = (CameraCaptureSessionCompatParamsApi21) this.mObject;
        return this.mCameraCaptureSession.setRepeatingBurst(r2, r0, r5.mCompatHandler);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int setSingleRepeatingRequest(CaptureRequest r2, Executor r3, CameraCaptureSession.CaptureCallback r4) throws CameraAccessException {
        CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper r0 = new CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper(r3, r4);
        CameraCaptureSessionCompatParamsApi21 r5 = (CameraCaptureSessionCompatParamsApi21) this.mObject;
        return this.mCameraCaptureSession.setRepeatingRequest(r2, r0, r5.mCompatHandler);
    }
}
