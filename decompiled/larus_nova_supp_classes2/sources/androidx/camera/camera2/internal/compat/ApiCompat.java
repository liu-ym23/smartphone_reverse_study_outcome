package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.OutputConfiguration;
import android.util.Size;
import android.view.Surface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ApiCompat {

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static void INVOKEVIRTUAL_androidx_camera_camera2_internal_compat_ApiCompat$Api21Impl_com_obric_performance_power_monitor_camera_CameraLancet_close(CameraDevice r1) {
            if (fna.g.d() == true) goto L6;
            androidx_camera_camera2_internal_compat_ApiCompat$Api21Impl_android_hardware_camera2_CameraDevice_close(r1);
            return;
        L6:
            androidx_camera_camera2_internal_compat_ApiCompat$Api21Impl_android_hardware_camera2_CameraDevice_close(r1);
            if ((r1 instanceof CameraDevice) == false) goto L10;
            jna.a.a(r1.getId());
            return;
        }

        private static void androidx_camera_camera2_internal_compat_ApiCompat$Api21Impl_android_hardware_camera2_CameraDevice_close(CameraDevice r12) {
            f06.c r8 = new f06.c();
            Object[] r9 = new Object[0];
            f06.b r10 = new f06.b();
            if (r8.b(100201, "android/hardware/camera2/CameraDevice", "close", r12, r9, "void", r10).a == false) goto L6;
            r8.a(100201, "android/hardware/camera2/CameraDevice", "close", r12, r9, null, r10, false);
            return;
        L6:
            r12.close();
            r8.a(100201, "android/hardware/camera2/CameraDevice", "close", r12, r9, null, r10, true);
        }

        public static void close(CameraDevice r0) {
            INVOKEVIRTUAL_androidx_camera_camera2_internal_compat_ApiCompat$Api21Impl_com_obric_performance_power_monitor_camera_CameraLancet_close(r0);
        }
    }

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static void onSurfacePrepared(CameraCaptureSession.StateCallback r0, CameraCaptureSession r1, Surface r2) {
            r0.onSurfacePrepared(r1, r2);
        }
    }

    public static class Api24Impl {
        private Api24Impl() {
        }

        public static void onCaptureBufferLost(CameraCaptureSession.CaptureCallback r0, CameraCaptureSession r1, CaptureRequest r2, Surface r3, long r4) {
            r0.onCaptureBufferLost(r1, r2, r3, r4);
        }
    }

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static <T> OutputConfiguration newOutputConfiguration(Size r1, Class<T> r2) {
            return new OutputConfiguration(r1, r2);
        }

        public static void onCaptureQueueEmpty(CameraCaptureSession.StateCallback r0, CameraCaptureSession r1) {
            r0.onCaptureQueueEmpty(r1);
        }
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static void onCameraAccessPrioritiesChanged(CameraManager.AvailabilityCallback r0) {
            r0.onCameraAccessPrioritiesChanged();
        }
    }

    private ApiCompat() {
    }
}
