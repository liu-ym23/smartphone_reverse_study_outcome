package com.ss.android.ttvecamera;

import android.hardware.Camera;
import com.bytedance.bpea.basics.Cert;

/* JADX INFO: loaded from: classes38.dex */
public class TECamera1PolicyAdapter {
    private static final String TAG = "TECamera1PolicyAdapter";

    public TECamera1PolicyAdapter() {
    }

    public static /* synthetic */ Object a(Camera r100) {
        return lambda$closeCamera$0(r100);
    }

    private static Camera com_ss_android_ttvecamera_TECamera1PolicyAdapter_android_hardware_Camera_open() {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r110 = new f06.b();
        f06.d r111 = r100.b(100100, "android/hardware/Camera", "open", Camera.class, r101, "android.hardware.Camera", r110);
        if (r111.f474982a == false) goto L6;
        r100.a(100100, "android/hardware/Camera", "open", Camera.class, r101, null, r110, false);
        return (Camera) r111.f474983b;
    L6:
        Camera r112 = Camera.open();
        r100.a(100100, "android/hardware/Camera", "open", Camera.class, r101, r112, r110, true);
        return r112;
    }

    private static boolean isBpeaCheckPrivacy() {
        zhc.a.a().getClass();
        return true;
    }

    private static Camera com_ss_android_ttvecamera_TECamera1PolicyAdapter_android_hardware_Camera_open(int r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = {Integer.valueOf(r110)};
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(100100, "android/hardware/Camera", "open", Camera.class, r101, "android.hardware.Camera", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(100100, "android/hardware/Camera", "open", Camera.class, r101, null, r111, false);
        return (Camera) r112.f474983b;
    L6:
        Camera r113 = Camera.open(r110);
        r100.a(100100, "android/hardware/Camera", "open", Camera.class, r101, r113, r111, true);
        return r113;
    }

    private static void com_ss_android_ttvecamera_TECamera1PolicyAdapter_android_hardware_Camera_release(Camera r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100101, "android/hardware/Camera", "release", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100101, "android/hardware/Camera", "release", r110, r101, null, r111, false);
        return;
    L6:
        r110.release();
        r100.a(100101, "android/hardware/Camera", "release", r110, r101, null, r111, true);
    }

    private static /* synthetic */ Object lambda$closeCamera$0(Camera r100) throws Exception {
        com_ss_android_ttvecamera_TECamera1PolicyAdapter_android_hardware_Camera_release(r100);
        return null;
    }

    public static void closeCamera(Object r100, final Camera r101) {
        TELogUtils.i(TAG, "check privacy, Camera close");
        if (isBpeaCheckPrivacy() == true) goto L11;
        psdaCloseCamera(r100, r101);
        return;
    L11:
        com.bytedance.bpea.entry.api.ve.c.a((Cert) r100, new a(r101));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static Camera openCamera(Object r100, final int r101) {
        TELogUtils.i(TAG, "check privacy, Camera open");
        if (isBpeaCheckPrivacy() == false) goto L5;
        return (Camera) com.bytedance.bpea.entry.api.ve.c.b((Cert) r100, new AnonymousClass1(r101));
    L8:
        e = move-exception;
        TELogUtils.e(TAG, "Exception occur:", e);
        return null;
    L5:
        return psdaOpenCamera(r100, r101);
    }

    private static void psdaCloseCamera(Object r100, Camera r101) {
        if (r100 != null) goto L5;
        TELogUtils.i(TAG, "psda privacy check close camera1 token is null ");
    L6:
        com_ss_android_ttvecamera_TECamera1PolicyAdapter_android_hardware_Camera_release(r101);
        TELogUtils.i(TAG, "psda privacy check close camera1 value is true");
        return;
    L5:
        zhc.a.a().getClass();
        goto L6
    }

    private static Camera psdaOpenCamera(Object r100, int r101) {
        if (r100 != null) goto L4;
        TELogUtils.i(TAG, "psda privacy check open camera token is null ");
    L5:
        if (r101 < 0) goto L9;
        return com_ss_android_ttvecamera_TECamera1PolicyAdapter_android_hardware_Camera_open(r101);
    L9:
        return com_ss_android_ttvecamera_TECamera1PolicyAdapter_android_hardware_Camera_open();
    L4:
        zhc.a.a().getClass();
        goto L5
    }
}
