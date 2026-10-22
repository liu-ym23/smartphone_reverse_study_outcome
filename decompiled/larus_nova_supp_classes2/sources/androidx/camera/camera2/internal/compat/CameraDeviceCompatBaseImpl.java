package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class CameraDeviceCompatBaseImpl implements CameraDeviceCompat.CameraDeviceCompatImpl {
    final CameraDevice mCameraDevice;
    final Object mImplParams;

    public static class CameraDeviceCompatParamsApi21 {
        final Handler mCompatHandler;

        public CameraDeviceCompatParamsApi21(Handler r1) {
            this.mCompatHandler = r1;
        }
    }

    @Override // androidx.camera.camera2.internal.compat.CameraDeviceCompat.CameraDeviceCompatImpl
    public CameraDevice unwrap() {
        return this.mCameraDevice;
    }

    public static List<Surface> unpackSurfaces(List<OutputConfigurationCompat> r2) {
        ArrayList r0 = new ArrayList(r2.size());
        Iterator<OutputConfigurationCompat> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r0.add(r3.next().getSurface());
        goto L4
    L6:
        return r0;
    }

    @Override // androidx.camera.camera2.internal.compat.CameraDeviceCompat.CameraDeviceCompatImpl
    public void createCaptureSession(SessionConfigurationCompat r4) throws CameraAccessExceptionCompat {
        checkPreconditions(this.mCameraDevice, r4);
        if (r4.getInputConfiguration() != null) goto L11;
        if (r4.getSessionType() == 1) goto L9;
        CameraCaptureSessionCompat.StateCallbackExecutorWrapper r0 = new CameraCaptureSessionCompat.StateCallbackExecutorWrapper(r4.getExecutor(), r4.getStateCallback());
        List<Surface> r5 = unpackSurfaces(r4.getOutputConfigurations());
        CameraDeviceCompatParamsApi21 r1 = (CameraDeviceCompatParamsApi21) this.mImplParams;
        createBaseCaptureSession(this.mCameraDevice, r5, r0, r1.mCompatHandler);
        return;
    L9:
        throw new IllegalArgumentException("High speed capture sessions not supported until API 23");
    L11:
        throw new IllegalArgumentException("Reprocessing sessions not supported until API 23");
    }

    public CameraDeviceCompatBaseImpl(CameraDevice r1, Object r2) {
        this.mCameraDevice = (CameraDevice) Preconditions.checkNotNull(r1);
        this.mImplParams = r2;
    }

    private static void checkPhysicalCameraIdValid(CameraDevice r3, List<OutputConfigurationCompat> r4) {
        String r5 = r3.getId();
        Iterator<OutputConfigurationCompat> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        String r0 = r6.next().getPhysicalCameraId();
        if (r0 == null) goto L4;
        if (r0.isEmpty() == true) goto L4;
        Logger.w("CameraDeviceCompat", "Camera " + r5 + ": Camera doesn't support physicalCameraId " + r0 + ". Ignoring.");
        goto L4
    }

    public static void checkPreconditions(CameraDevice r1, SessionConfigurationCompat r2) {
        Preconditions.checkNotNull(r1);
        Preconditions.checkNotNull(r2);
        Preconditions.checkNotNull(r2.getStateCallback());
        List<OutputConfigurationCompat> r0 = r2.getOutputConfigurations();
        if (r0 == null) goto L11;
        if (r2.getExecutor() == null) goto L9;
        checkPhysicalCameraIdValid(r1, r0);
        return;
    L9:
        throw new IllegalArgumentException("Invalid executor");
    L11:
        throw new IllegalArgumentException("Invalid output configurations");
    }

    public static CameraDeviceCompatBaseImpl create(CameraDevice r2, Handler r3) {
        return new CameraDeviceCompatBaseImpl(r2, new CameraDeviceCompatParamsApi21(r3));
    }

    public void createBaseCaptureSession(CameraDevice r1, List<Surface> r2, CameraCaptureSession.StateCallback r3, Handler r4) throws CameraAccessExceptionCompat {
        r1.createCaptureSession(r2, r3, r4);     // Catch: CameraAccessException -> L4
        return;
    L4:
        e = move-exception;
        throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
    }
}
