package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.SessionConfiguration;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class CameraDeviceCompatApi28Impl extends CameraDeviceCompatApi24Impl {
    public CameraDeviceCompatApi28Impl(CameraDevice r2) {
        super((CameraDevice) Preconditions.checkNotNull(r2), null);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraDeviceCompatApi24Impl, androidx.camera.camera2.internal.compat.CameraDeviceCompatApi23Impl, androidx.camera.camera2.internal.compat.CameraDeviceCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraDeviceCompat.CameraDeviceCompatImpl
    public void createCaptureSession(SessionConfigurationCompat r2) throws CameraAccessExceptionCompat {
        SessionConfiguration r3 = (SessionConfiguration) r2.unwrap();
        Preconditions.checkNotNull(r3);
        this.mCameraDevice.createCaptureSession(r3);     // Catch: CameraAccessException -> L5
        return;
    L5:
        e = move-exception;
        throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
    }
}
