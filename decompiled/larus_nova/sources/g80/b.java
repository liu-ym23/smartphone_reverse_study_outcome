package g80;

import android.hardware.Camera;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {
    static {
    }

    public static void a(Camera r110) {
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

    @JvmStatic
    public static final Camera b(int r110, TokenCert r111) throws BPEAException {
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L5;
        int r100 = com.bytedance.bpea.entry.api.camera.a.f202181a;
        return com.bytedance.bpea.entry.api.camera.a.C2917a.a(r110, r111);
    L5:
        f06.c r112 = new f06.c();
        Object[] r101 = {Integer.valueOf(r110)};
        f06.b r102 = new f06.b();
        f06.d r113 = r112.b(100100, "android/hardware/Camera", "open", Camera.class, r101, "android.hardware.Camera", r102);
        if (r113.f474982a == false) goto L8;
        r112.a(100100, "android/hardware/Camera", "open", Camera.class, r101, null, r102, false);
        return (Camera) r113.f474983b;
    L8:
        Camera r114 = Camera.open(r110);
        r112.a(100100, "android/hardware/Camera", "open", Camera.class, r101, r114, r102, true);
        return r114;
    }

    @JvmStatic
    public static final void c(Camera r100, TokenCert r101) {
        Intrinsics.checkNotNullParameter(r100, "camera");
    L8:
        e = move-exception;
        ALogger.e("CameraUtils", e);
        return;
    L4:
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L6;
        int r102 = com.bytedance.bpea.entry.api.camera.a.f202181a;     // Catch: BPEAException -> L8
        com.bytedance.bpea.entry.api.camera.a.C2917a.c(r100, r101);     // Catch: BPEAException -> L8
    L11:
        return;
    L6:
        a(r100);     // Catch: BPEAException -> L8
        goto L11
    }
}
