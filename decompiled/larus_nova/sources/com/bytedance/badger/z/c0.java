package com.bytedance.badger.z;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataULong;
import com.bytedance.badger.module.BadgerModuleBase;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import kotlin.ULong;

/* JADX INFO: loaded from: classes47.dex */
public final class c0 extends u0 {
    public c0() {
    }

    public static String c(TelephonyManager r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, "java.lang.String", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, null, r111, false);
        return (String) r112.f474983b;
    L6:
        String r113 = r110.getSimOperator();
        r100.a(102021, "android/telephony/TelephonyManager", BpeaManager.getSimOperator, r110, r101, r113, r111, true);
        return r113;
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r110, BadgerModuleBase.BadgerRequestData r111) {
        String r112 = Constants.NetworkOperator.OTHERS_OPERATOR;
        if (r110 != null) goto L111;
    L11:
        boolean r100 = false;
    L13:
        if (r100 == true) goto L16;
        r112 = "sim card not ready";
    L86:
        int r113 = r112.hashCode();
        long r101 = 0;
        if (r113 == (-2037477446)) goto L102;
        if (r113 == (-278955830)) goto L99;
        if (r113 == (-50643271)) goto L96;
        if (r113 != 1582678639) goto L106;
        if (r112.equals(Constants.NetworkOperator.TELECOM_OPERATOR) == false) goto L106;
        long r114 = 4;
    L104:
        r101 = ULong.m9623constructorimpl(ULong.m9623constructorimpl(r114) | 0);
    L106:
        return new BadgerResult.Success(new DataULong(r101, null));
    L96:
        if (r112.equals(Constants.NetworkOperator.UNICOM_OPERATOR) == false) goto L106;
        r114 = 2;
        goto L104
    L99:
        if (r112.equals(Constants.NetworkOperator.MOBILE_OPERATOR) == false) goto L106;
        r114 = 1;
        goto L104
    L102:
        if (r112.equals(Constants.NetworkOperator.UNKNOWN_OPERATOR) == false) goto L106;
        r114 = 128;
        goto L104
    L16:
        if (r110 != null) goto L109;
    L23:
        String r115 = "";
    L113:
        int r102 = r115.hashCode();     // Catch: Exception -> L84
        if (r102 == 49679502) goto L59;
        switch(r102) {
            case 49679470: goto L56;
            case 49679471: goto L53;
            case 49679472: goto L50;
            case 49679473: goto L47;
            case 49679474: goto L44;
            case 49679475: goto L41;
            case 49679476: goto L38;
            case 49679477: goto L35;
            case 49679478: goto L32;
            case 49679479: goto L29;
            default: goto L61;
        };     // Catch: Exception -> L84
    L61:
        String r116 = "";
    L62:
        int r103 = r116.hashCode();     // Catch: Exception -> L84
        if (r103 == (-1300183871)) goto L82;
        if (r103 == (-278955830)) goto L79;
        if (r103 == (-50643271)) goto L76;
        if (r103 == 0) goto L73;
        if (r103 != 1582678639) goto L85;
        if (r116.equals(Constants.NetworkOperator.TELECOM_OPERATOR) == false) goto L85;
        r112 = Constants.NetworkOperator.TELECOM_OPERATOR;
        goto L86
    L73:
        if (r116.equals("") == false) goto L85;
        r112 = Constants.NetworkOperator.UNKNOWN_OPERATOR;
        goto L86
    L76:
        if (r116.equals(Constants.NetworkOperator.UNICOM_OPERATOR) == false) goto L85;
        r112 = Constants.NetworkOperator.UNICOM_OPERATOR;
        goto L86
    L79:
        if (r116.equals(Constants.NetworkOperator.MOBILE_OPERATOR) == false) goto L85;
        r112 = Constants.NetworkOperator.MOBILE_OPERATOR;
        goto L86
    L82:
        if (r116.equals(Constants.NetworkOperator.OTHERS_OPERATOR) == false) goto L85;
    L29:
        if (r115.equals("46009") == false) goto L61;
    L54:
        r116 = Constants.NetworkOperator.UNICOM_OPERATOR;
        goto L62
    L32:
        if (r115.equals("46008") == false) goto L61;
    L57:
        r116 = Constants.NetworkOperator.MOBILE_OPERATOR;
        goto L62
    L35:
        if (r115.equals("46007") == false) goto L61;
    L38:
        if (r115.equals("46006") == false) goto L61;
    L41:
        if (r115.equals("46005") == false) goto L61;
    L60:
        r116 = Constants.NetworkOperator.TELECOM_OPERATOR;
        goto L62
    L44:
        if (r115.equals("46004") == false) goto L61;
    L47:
        if (r115.equals("46003") == false) goto L61;
    L50:
        if (r115.equals("46002") == false) goto L61;
    L53:
        if (r115.equals("46001") == false) goto L61;
    L56:
        if (r115.equals("46000") == false) goto L61;
    L59:
        if (r115.equals("46011") == false) goto L61;
    L85:
        r112 = "";
        goto L86
    L109:
        TelephonyManager r117 = (TelephonyManager) r110.getSystemService("phone");     // Catch: Throwable -> L107
        if (r117 == null) goto L23;
        r115 = c(r117);     // Catch: Throwable -> L107
    L111:
        TelephonyManager r104 = (TelephonyManager) r110.getSystemService("phone");     // Catch: Exception -> L108
        if (r104 == null) goto L11;
        if (r104.getSimState() != 5) goto L11;
        r100 = true;
        goto L13
    }
}
