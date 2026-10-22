package com.cmic.sso.sdk.e;

import android.content.Context;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;

/* JADX INFO: loaded from: classes3.dex */
public class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static j f273504b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f273505a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f273506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f273507d;

    public String b() {
        int r100 = com.cmic.sso.sdk.b.a.a().b().a();     // Catch: Exception -> L6
        if (r100 < 0) goto L12;
        return Integer.toString(r100);
    L12:
        return "";
    L6:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static j a() {
        return f273504b;
    }

    private j(Context r100) {
        this.f273506c = 0;
        this.f273507d = "";
        this.f273505a = r100;
    }

    private String a(String r100) {
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case 49679470: goto L42;
            case 49679471: goto L38;
            case 49679472: goto L34;
            case 49679473: goto L30;
            case 49679474: goto L26;
            case 49679475: goto L22;
            case 49679476: goto L18;
            case 49679477: goto L14;
            case 49679479: goto L10;
            case 49679502: goto L6;
            default: goto L46;
        };
    L6:
        if (r100.equals("46011") == false) goto L46;
        r101 = 9;
        goto L46
    L10:
        if (r100.equals("46009") == false) goto L46;
        r101 = 8;
        goto L46
    L14:
        if (r100.equals("46007") == false) goto L46;
        r101 = 7;
        goto L46
    L18:
        if (r100.equals("46006") == false) goto L46;
        r101 = 6;
        goto L46
    L22:
        if (r100.equals("46005") == false) goto L46;
        r101 = 5;
        goto L46
    L26:
        if (r100.equals("46004") == false) goto L46;
        r101 = 4;
        goto L46
    L30:
        if (r100.equals("46003") == false) goto L46;
        r101 = 3;
        goto L46
    L34:
        if (r100.equals("46002") == false) goto L46;
        r101 = 2;
        goto L46
    L38:
        if (r100.equals("46001") == false) goto L46;
        r101 = 1;
        goto L46
    L42:
        if (r100.equals("46000") == false) goto L46;
        r101 = 0;
    L46:
        switch(r101) {
            case 0: goto L53;
            case 1: goto L51;
            case 2: goto L53;
            case 3: goto L49;
            case 4: goto L53;
            case 5: goto L49;
            case 6: goto L51;
            case 7: goto L53;
            case 8: goto L51;
            case 9: goto L49;
            default: goto L47;
        };
    L47:
        c.b("SIMUtils", PlayerResolution.NAME.UNKNOWN);
        return "0";
    L49:
        c.b("SIMUtils", "中国电信");
        return "3";
    L51:
        c.b("SIMUtils", "中国联通");
        return "2";
    L53:
        c.b("SIMUtils", "中国移动");
        return "1";
    }

    private static String com_cmic_sso_sdk_e_j_android_telephony_TelephonyManager_getSimOperator(TelephonyManager r110) {
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

    public String a(boolean r100) {
        if (r100 == true) goto L4;
        return "";
    L4:
        if ((SystemClock.elapsedRealtime() - this.f273506c) <= 3000) goto L9;
        this.f273506c = SystemClock.elapsedRealtime();
        TelephonyManager r101 = (TelephonyManager) this.f273505a.getSystemService("phone");
        if (r101 == null) goto L13;
        this.f273507d = com_cmic_sso_sdk_e_j_android_telephony_TelephonyManager_getSimOperator(r101);
        c.b("SIMUtils", "getSimOperator SysOperator= " + this.f273507d);
        return this.f273507d;
    L13:
        return "";
    L9:
        c.b("SIMUtils", "使用缓存operator Operator= " + this.f273507d);
        return this.f273507d;
    }

    public static void a(Context r100) {
        f273504b = new j(r100);
    }

    public String a(String r100, boolean r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = a(r101);
    L6:
        return a(r100);
    }
}
