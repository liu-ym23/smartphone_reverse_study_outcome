package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class CameraCaptureSessionCompatApi28Impl extends CameraCaptureSessionCompatBaseImpl {
    public CameraCaptureSessionCompatApi28Impl(CameraCaptureSession r2) {
        super(r2, null);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int captureBurstRequests(List<CaptureRequest> r2, Executor r3, CameraCaptureSession.CaptureCallback r4) throws CameraAccessException {
        return this.mCameraCaptureSession.captureBurstRequests(r2, r3, r4);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int captureSingleRequest(CaptureRequest r2, Executor r3, CameraCaptureSession.CaptureCallback r4) throws CameraAccessException {
        return this.mCameraCaptureSession.captureSingleRequest(r2, r3, r4);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int setRepeatingBurstRequests(List<CaptureRequest> r2, Executor r3, CameraCaptureSession.CaptureCallback r4) throws CameraAccessException {
        return this.mCameraCaptureSession.setRepeatingBurstRequests(r2, r3, r4);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraCaptureSessionCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat.CameraCaptureSessionCompatImpl
    public int setSingleRepeatingRequest(CaptureRequest r2, Executor r3, CameraCaptureSession.CaptureCallback r4) throws CameraAccessException {
        return this.mCameraCaptureSession.setSingleRepeatingRequest(r2, r3, r4);
    }
}
