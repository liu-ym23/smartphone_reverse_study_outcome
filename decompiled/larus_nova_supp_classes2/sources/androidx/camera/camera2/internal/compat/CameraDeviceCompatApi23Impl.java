package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.core.util.Preconditions;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class CameraDeviceCompatApi23Impl extends CameraDeviceCompatBaseImpl {
    @Override // androidx.camera.camera2.internal.compat.CameraDeviceCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraDeviceCompat.CameraDeviceCompatImpl
    public void createCaptureSession(SessionConfigurationCompat r5) throws CameraAccessExceptionCompat {
        CameraDeviceCompatBaseImpl.checkPreconditions(this.mCameraDevice, r5);
        CameraCaptureSessionCompat.StateCallbackExecutorWrapper r0 = new CameraCaptureSessionCompat.StateCallbackExecutorWrapper(r5.getExecutor(), r5.getStateCallback());
        List<Surface> r1 = CameraDeviceCompatBaseImpl.unpackSurfaces(r5.getOutputConfigurations());
        Handler r2 = ((CameraDeviceCompatBaseImpl.CameraDeviceCompatParamsApi21) Preconditions.checkNotNull((CameraDeviceCompatBaseImpl.CameraDeviceCompatParamsApi21) this.mImplParams)).mCompatHandler;
        InputConfigurationCompat r3 = r5.getInputConfiguration();
        if (r3 == null) goto L6;
        InputConfiguration r6 = (InputConfiguration) r3.unwrap();     // Catch: CameraAccessException -> L10
        Preconditions.checkNotNull(r6);     // Catch: CameraAccessException -> L10
        this.mCameraDevice.createReprocessableCaptureSession(r6, r1, r0, r2);     // Catch: CameraAccessException -> L10
    L13:
        return;
    L6:
        if (r5.getSessionType() != 1) goto L8;
        this.mCameraDevice.createConstrainedHighSpeedCaptureSession(r1, r0, r2);     // Catch: CameraAccessException -> L10
        goto L13
    L8:
        createBaseCaptureSession(this.mCameraDevice, r1, r0, r2);     // Catch: CameraAccessException -> L10
    L10:
        e = move-exception;
        throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
    }

    public CameraDeviceCompatApi23Impl(CameraDevice r1, Object r2) {
        super(r1, r2);
    }

    public static CameraDeviceCompatApi23Impl create(CameraDevice r2, Handler r3) {
        return new CameraDeviceCompatApi23Impl(r2, new CameraDeviceCompatBaseImpl.CameraDeviceCompatParamsApi21(r3));
    }
}
