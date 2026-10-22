package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class CameraManagerCompatApi29Impl extends CameraManagerCompatApi28Impl {
    public CameraManagerCompatApi29Impl(Context r1) {
        super(r1);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatApi28Impl, androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public CameraCharacteristics getCameraCharacteristics(String r2) throws CameraAccessExceptionCompat {
        return this.mCameraManager.getCameraCharacteristics(r2);
    L4:
        e = move-exception;
        throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompatApi28Impl, androidx.camera.camera2.internal.compat.CameraManagerCompatBaseImpl, androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void openCamera(String r2, Executor r3, CameraDevice.StateCallback r4) throws CameraAccessExceptionCompat {
        INVOKEVIRTUAL_androidx_camera_camera2_internal_compat_CameraManagerCompatApi29Impl_com_obric_performance_power_monitor_camera_CameraLancet_openCamera(this.mCameraManager, r2, r3, r4);     // Catch: CameraAccessException -> L4
        return;
    L4:
        e = move-exception;
        throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
    }

    public static void INVOKEVIRTUAL_androidx_camera_camera2_internal_compat_CameraManagerCompatApi29Impl_com_obric_performance_power_monitor_camera_CameraLancet_openCamera(CameraManager r1, String r2, Executor r3, CameraDevice.StateCallback r4) throws CameraAccessException {
        if (fna.g.d() == true) goto L6;
        androidx_camera_camera2_internal_compat_CameraManagerCompatApi29Impl_android_hardware_camera2_CameraManager_openCamera(r1, r2, r3, r4);
        return;
    L6:
        androidx_camera_camera2_internal_compat_CameraManagerCompatApi29Impl_android_hardware_camera2_CameraManager_openCamera(r1, r2, r3, r4);
        jna.a.b(r2);
    }

    private static void androidx_camera_camera2_internal_compat_CameraManagerCompatApi29Impl_android_hardware_camera2_CameraManager_openCamera(CameraManager r11, String r12, Executor r13, CameraDevice.StateCallback r14) throws CameraAccessException {
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
