package g80;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.api.device.info.TelephonyManagerEntry;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g {
    static {
    }

    @JvmStatic
    public static final Integer a(Cert r100) {
        Object r101 = jc1.a.b().getSystemService("phone");
        if (r101 == null) goto L10;
        TelephonyManager r102 = (TelephonyManager) r101;
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L8;
        TelephonyManagerEntry.Companion.getClass();
        return TelephonyManagerEntry.Companion.b(r102, r100);
    L8:
        return Integer.valueOf(r102.getNetworkType());
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    @JvmStatic
    public static final String b(TokenCert r110) {
        Object r100 = jc1.a.b().getSystemService("phone");
        if (r100 == null) goto L13;
        TelephonyManager r101 = (TelephonyManager) r100;
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L7;
        TelephonyManagerEntry.Companion.getClass();
        return TelephonyManagerEntry.Companion.e(r101, r110);
    L7:
        f06.c r111 = new f06.c();
        Object[] r102 = new Object[0];
        f06.b r112 = new f06.b();
        f06.d r113 = r111.b(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r101, r102, "java.lang.String", r112);
        if (r113.f474982a == false) goto L10;
        r111.a(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r101, r102, null, r112, false);
        return (String) r113.f474983b;
    L10:
        String r114 = r101.getSimOperator();
        r111.a(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r101, r102, r114, r112, true);
        return r114;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    @JvmStatic
    public static final void c(PhoneStateListener r100, int r101, TokenCert r102) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Object r103 = jc1.a.b().getSystemService("phone");
        if (r103 == null) goto L10;
        TelephonyManager r104 = (TelephonyManager) r103;
        if (LiveInfraSettingKeys.LIVE_BPEA_SWITCH.getValue().booleanValue() == false) goto L7;
        TelephonyManagerEntry.Companion.getClass();
        TelephonyManagerEntry.Companion.l(r104, r100, r101, r102);
        return;
    L7:
        r104.listen(r100, r101);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }
}
