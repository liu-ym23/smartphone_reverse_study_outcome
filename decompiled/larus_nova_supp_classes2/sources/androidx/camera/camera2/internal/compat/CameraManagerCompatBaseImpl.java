package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class CameraManagerCompatBaseImpl implements CameraManagerCompat.CameraManagerCompatImpl {
    final CameraManager mCameraManager;
    final Object mObject;

    public static final class CameraManagerCompatParamsApi21 {
        final Handler mCompatHandler;
        final Map<CameraManager.AvailabilityCallback, CameraManagerCompat.AvailabilityCallbackExecutorWrapper> mWrapperMap;

        public CameraManagerCompatParamsApi21(Handler r2) {
            this.mWrapperMap = new HashMap();
            this.mCompatHandler = r2;
        }
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public String[] getCameraIdList() throws CameraAccessExceptionCompat {
        return this.mCameraManager.getCameraIdList();
    L4:
        e = move-exception;
        throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public Set<Set<String>> getConcurrentCameraIds() throws CameraAccessExceptionCompat {
        return Collections.emptySet();
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public CameraManager getCameraManager() {
        return this.mCameraManager;
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public CameraCharacteristics getCameraCharacteristics(String r2) throws CameraAccessExceptionCompat {
        return this.mCameraManager.getCameraCharacteristics(r2);
    L4:
        e = move-exception;
        throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void unregisterAvailabilityCallback(CameraManager.AvailabilityCallback r3) {
        if (r3 == null) goto L11;
        CameraManagerCompatParamsApi21 r0 = (CameraManagerCompatParamsApi21) this.mObject;
        Map<CameraManager.AvailabilityCallback, CameraManagerCompat.AvailabilityCallbackExecutorWrapper> r1 = r0.mWrapperMap;
        monitor-enter(r1);
        CameraManagerCompat.AvailabilityCallbackExecutorWrapper r4 = r0.mWrapperMap.remove(r3);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
    L12:
        if (r4 == null) goto L14;
        r4.setDisabled();
    L14:
        this.mCameraManager.unregisterAvailabilityCallback(r4);
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        r4 = null;
        goto L12
    }

    public CameraManagerCompatBaseImpl(Context r2, Object r3) {
        this.mCameraManager = (CameraManager) r2.getSystemService("camera");
        this.mObject = r3;
    }

    public static CameraManagerCompatBaseImpl create(Context r2, Handler r3) {
        return new CameraManagerCompatBaseImpl(r2, new CameraManagerCompatParamsApi21(r3));
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void registerAvailabilityCallback(Executor r4, CameraManager.AvailabilityCallback r5) {
        if (r4 == null) goto L19;
        CameraManagerCompatParamsApi21 r0 = (CameraManagerCompatParamsApi21) this.mObject;
        if (r5 == null) goto L15;
        Map<CameraManager.AvailabilityCallback, CameraManagerCompat.AvailabilityCallbackExecutorWrapper> r1 = r0.mWrapperMap;
        monitor-enter(r1);
        CameraManagerCompat.AvailabilityCallbackExecutorWrapper r2 = r0.mWrapperMap.get(r5);     // Catch: Throwable -> L12
        if (r2 != null) goto L10;
        r2 = new CameraManagerCompat.AvailabilityCallbackExecutorWrapper(r4, r5);     // Catch: Throwable -> L12
        r0.mWrapperMap.put(r5, r2);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L12
    L16:
        this.mCameraManager.registerAvailabilityCallback(r2, r0.mCompatHandler);
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        r2 = null;
        goto L16
    L19:
        throw new IllegalArgumentException("executor was null");
    }

    @Override // androidx.camera.camera2.internal.compat.CameraManagerCompat.CameraManagerCompatImpl
    public void openCamera(String r2, Executor r3, CameraDevice.StateCallback r4) throws CameraAccessExceptionCompat {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        CameraDeviceCompat.StateCallbackExecutorWrapper r0 = new CameraDeviceCompat.StateCallbackExecutorWrapper(r3, r4);
        CameraManagerCompatParamsApi21 r5 = (CameraManagerCompatParamsApi21) this.mObject;
        INVOKEVIRTUAL_androidx_camera_camera2_internal_compat_CameraManagerCompatBaseImpl_com_obric_performance_power_monitor_camera_CameraLancet_openCamera(this.mCameraManager, r2, r0, r5.mCompatHandler);     // Catch: CameraAccessException -> L5
        return;
    L5:
        e = move-exception;
        throw CameraAccessExceptionCompat.toCameraAccessExceptionCompat(e);
    }

    public static void INVOKEVIRTUAL_androidx_camera_camera2_internal_compat_CameraManagerCompatBaseImpl_com_obric_performance_power_monitor_camera_CameraLancet_openCamera(CameraManager r1, String r2, CameraDevice.StateCallback r3, Handler r4) throws CameraAccessException {
        if (fna.g.d() == true) goto L6;
        androidx_camera_camera2_internal_compat_CameraManagerCompatBaseImpl_android_hardware_camera2_CameraManager_openCamera(r1, r2, r3, r4);
        return;
    L6:
        androidx_camera_camera2_internal_compat_CameraManagerCompatBaseImpl_android_hardware_camera2_CameraManager_openCamera(r1, r2, r3, r4);
        jna.a.b(r2);
    }

    private static void androidx_camera_camera2_internal_compat_CameraManagerCompatBaseImpl_android_hardware_camera2_CameraManager_openCamera(CameraManager r11, String r12, CameraDevice.StateCallback r13, Handler r14) throws CameraAccessException {
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
