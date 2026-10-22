package g80;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f {
    static {
    }

    @JvmStatic
    public static final Sensor b(SensorManager r100, TokenCert r101) throws BPEAException {
        Intrinsics.checkNotNullParameter(r100, "manager");
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L6;
        int r102 = com.bytedance.bpea.entry.api.device.info.e.f202188a;
        return com.bytedance.bpea.entry.api.device.info.e.a.a(r100, 1, r101);
    L6:
        return r100.getDefaultSensor(1);
    }

    @JvmStatic
    public static final Sensor a(SensorManager r100, int r101, TokenCert r102) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L10;
        int r103 = com.bytedance.bpea.entry.api.device.info.e.f202188a;
        return com.bytedance.bpea.entry.api.device.info.e.a.a(r100, r101, r102);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    L10:
        return r100.getDefaultSensor(r101);
    }
}
