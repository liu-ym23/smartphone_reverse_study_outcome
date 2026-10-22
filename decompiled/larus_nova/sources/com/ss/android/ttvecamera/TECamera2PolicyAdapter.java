package com.ss.android.ttvecamera;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import fna.g;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes38.dex */
public class TECamera2PolicyAdapter {
    private static final String TAG = "TECamera2PolicyAdapter";

    public TECamera2PolicyAdapter() {
    }

    public static /* synthetic */ Object a(AtomicBoolean r100, CameraDevice r101) {
        return lambda$closeCamera$0(r100, r101);
    }

    private static boolean isBpeaCheckPrivacy() {
        zhc.a.a().getClass();
        return true;
    }

    public static void INVOKEVIRTUAL_com_ss_android_ttvecamera_TECamera2PolicyAdapter_com_obric_performance_power_monitor_camera_CameraLancet_close(CameraDevice r100) {
        if (g.d() == true) goto L6;
        com_ss_android_ttvecamera_TECamera2PolicyAdapter_android_hardware_camera2_CameraDevice_close(r100);
        return;
    L6:
        com_ss_android_ttvecamera_TECamera2PolicyAdapter_android_hardware_camera2_CameraDevice_close(r100);
        if ((r100 instanceof CameraDevice) == false) goto L10;
        jna.a.a(r100.getId());
        return;
    }

    private static void com_ss_android_ttvecamera_TECamera2PolicyAdapter_android_hardware_camera2_CameraDevice_close(CameraDevice r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100201, "android/hardware/camera2/CameraDevice", "close", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100201, "android/hardware/camera2/CameraDevice", "close", r110, r101, null, r111, false);
        return;
    L6:
        r110.close();
        r100.a(100201, "android/hardware/camera2/CameraDevice", "close", r110, r101, null, r111, true);
    }

    private static /* synthetic */ Object lambda$closeCamera$0(AtomicBoolean r100, CameraDevice r101) throws Exception {
        if (r100 != null) goto L5;
    L8:
        INVOKEVIRTUAL_com_ss_android_ttvecamera_TECamera2PolicyAdapter_com_obric_performance_power_monitor_camera_CameraLancet_close(r101);
        if (r100 == null) goto L11;
        r100.set(false);
    L11:
        return null;
    L5:
        if (r100.getAndSet(true) == false) goto L8;
        TELogUtils.w(TAG, "Skip close cause by is closing");
        return null;
    }

    private static void psdaCloseCamera(Object r100, CameraDevice r101) {
        if (r100 != null) goto L5;
        TELogUtils.i(TAG, "psda privacy check close camera2 token is null ");
    L6:
        INVOKEVIRTUAL_com_ss_android_ttvecamera_TECamera2PolicyAdapter_com_obric_performance_power_monitor_camera_CameraLancet_close(r101);
        TELogUtils.i(TAG, "psda privacy check close camera2 value is true");
        return;
    L5:
        zhc.a.a().getClass();
        goto L6
    }

    public static void closeCamera(Object r100, final CameraDevice r101, final AtomicBoolean r102) throws Exception {
        TELogUtils.i(TAG, "check privacy, Camera close, cameraDevice:" + r101);
        TETraceUtils.beginSection("TECamera2PolicyAdapter-closeCamera");
        if (isBpeaCheckPrivacy() == true) goto L5;
        psdaCloseCamera(r100, r101);
    L5:
        com.bytedance.bpea.entry.api.ve.c.a((Cert) r100, new b(r102, r101));
        TETraceUtils.endSection();
    }

    public static void INVOKEVIRTUAL_com_ss_android_ttvecamera_TECamera2PolicyAdapter_com_obric_performance_power_monitor_camera_CameraLancet_openCamera(CameraManager r100, String r101, CameraDevice.StateCallback r102, Handler r103) throws CameraAccessException {
        if (g.d() == true) goto L6;
        com_ss_android_ttvecamera_TECamera2PolicyAdapter_android_hardware_camera2_CameraManager_openCamera(r100, r101, r102, r103);
        return;
    L6:
        com_ss_android_ttvecamera_TECamera2PolicyAdapter_android_hardware_camera2_CameraManager_openCamera(r100, r101, r102, r103);
        jna.a.b(r101);
    }

    private static void com_ss_android_ttvecamera_TECamera2PolicyAdapter_android_hardware_camera2_CameraManager_openCamera(CameraManager r110, String r111, CameraDevice.StateCallback r112, Handler r113) throws CameraAccessException {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113};
        f06.b r114 = new f06.b();
        if (r100.b(100206, "android/hardware/camera2/CameraManager", "openCamera", r110, r101, "void", r114).f474982a == false) goto L6;
        r100.a(100206, "android/hardware/camera2/CameraManager", "openCamera", r110, r101, null, r114, false);
        return;
    L6:
        r110.openCamera(r111, r112, r113);
        r100.a(100206, "android/hardware/camera2/CameraManager", "openCamera", r110, r101, null, r114, true);
    }

    public static void openCamera(Object r100, final CameraManager r101, final String r102, final CameraDevice.StateCallback r103, final Handler r104) throws Exception {
        TELogUtils.i(TAG, "check privacy, Camera open");
        TETraceUtils.beginSection("TECamera2PolicyAdapter-openCamera");
        if (isBpeaCheckPrivacy() == true) goto L12;
        psdaOpenCamera(r100, r101, r102, r103, r104);
        return;
    L12:
        com.bytedance.bpea.entry.api.ve.c.b((Cert) r100, new AnonymousClass1(r101, r102, r103, r104));     // Catch: BPEAException -> L8
    L10:
        TETraceUtils.endSection();
        return;
    L8:
        e = move-exception;
        TELogUtils.e(TAG, "Exception occur:", e);
        goto L10
    }

    private static void psdaOpenCamera(Object r100, CameraManager r101, String r102, CameraDevice.StateCallback r103, Handler r104) throws CameraAccessException {
        if (r100 != null) goto L5;
        TELogUtils.i(TAG, "psda privacy check open camera2 token is null ");
    L6:
        INVOKEVIRTUAL_com_ss_android_ttvecamera_TECamera2PolicyAdapter_com_obric_performance_power_monitor_camera_CameraLancet_openCamera(r101, r102, r103, r104);
        TELogUtils.i(TAG, "psda privacy check open camera2 value is true");
        return;
    L5:
        zhc.a.a().getClass();
        goto L6
    }
}
