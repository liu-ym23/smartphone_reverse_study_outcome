package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class CameraManagerCompatApi28Impl extends CameraManagerCompatBaseImpl {
    public CameraManagerCompatApi28Impl(Context r2) {
        super(r2, null);
    }

    public static CameraManagerCompatApi28Impl create(Context r1) {
        return new CameraManagerCompatApi28Impl(r1);
    }

    private boolean isDndFailCase(Throwable r3) {
        if (Build.VERSION.SDK_INT == 28) goto L5;
    L7:
        return false;
    L5:
        if (isDndRuntimeException(r3) == false) goto L7;
        return true;
    }

    private static boolean isDndRuntimeException(Throwable r2) {
        if (r2.getClass().equals(RuntimeException.class) == false) goto L11;
        StackTraceElement[] r3 = r2.getStackTrace();
        if (r3 == null) goto L11;
        if (r3.length < 0) goto L11;
        return "_enableShutterSound".equals(r3[0].getMethodName());
    L11:
        return false;
    }

    private void throwDndException(Throwable r3) throws CameraAccessExceptionCompat {
        throw new CameraAccessExceptionCompat(CameraAccessExceptionCompat.CAMERA_UNAVAILABLE_DO_NOT_DISTURB, r3);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public CameraCharacteristics getCameraCharacteristics(String r2) throws CameraAccessExceptionCompat {
        return super.getCameraCharacteristics(r2);
    L4:
        e = move-exception;
        if (isDndFailCase(e) == false) goto L8;
        throwDndException(e);
    L8:
        throw e;
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback r2) {
        this.mCameraManager.unregisterAvailabilityCallback(r2);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void registerAvailabilityCallback(Executor r2, CameraManager.AvailabilityCallback r3) {
        this.mCameraManager.registerAvailabilityCallback(r2, r3);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void openCamera(String r2, Executor r3, CameraDevice.StateCallback r4) throws CameraAccessExceptionCompat {
        INVOKEVIRTUAL_androidx_camera_camera2_internal_compat_CameraManagerCompatApi28Impl_com_obric_performance_power_monitor_camera_CameraLancet_openCamera(this.mCameraManager, r2, r3, r4);     // Catch: RuntimeException -> L4 SecurityException -> L9 IllegalArgumentException -> L11 CameraAccessException -> L13
        return;
    L13:
        e = move-exception;
        throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
    L11:
        e = move-exception;
        throw e;
    L9:
        e = move-exception;
        throw e;
    L4:
        e = move-exception;
        if (isDndFailCase(e) == false) goto L8;
        throwDndException(e);
    L8:
        throw e;
    }

    public static void INVOKEVIRTUAL_androidx_camera_camera2_internal_compat_CameraManagerCompatApi28Impl_com_obric_performance_power_monitor_camera_CameraLancet_openCamera(CameraManager r1, String r2, Executor r3, CameraDevice.StateCallback r4) throws CameraAccessException {
        if (fna.g.d() == true) goto L6;
        androidx_camera_camera2_internal_compat_CameraManagerCompatApi28Impl_android_hardware_camera2_CameraManager_openCamera(r1, r2, r3, r4);
        return;
    L6:
        androidx_camera_camera2_internal_compat_CameraManagerCompatApi28Impl_android_hardware_camera2_CameraManager_openCamera(r1, r2, r3, r4);
        jna.a.b(r2);
    }

    private static void androidx_camera_camera2_internal_compat_CameraManagerCompatApi28Impl_android_hardware_camera2_CameraManager_openCamera(CameraManager r11, String r12, Executor r13, CameraDevice.StateCallback r14) throws CameraAccessException {
        f06.c r8 = new f06.c();
        Object[] r9 = {r12, r13, r14};
        f06.b r10 = new f06.b();
        if (r8.b(100206, "android/hardware/camera2/CameraManager", "openCamera", r11, r9, "void", r10).a == false) goto L6;
        r8.a(100206, "android/hardware/camera2/CameraManager", "openCamera", r11, r9, null, r10, false);
        return;
    L6:
        r11.openCamera(r12, r13, r14);
        r8.a(100206, "android/hardware/camera2/CameraManager", "openCamera", r11, r9, null, r10, true);
    }
}
