package com.cmic.ida.sdk;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;

/* JADX INFO: loaded from: classes22.dex */
public class k0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static k0 f273139d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f273140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f273141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f273142c;

    public String a() {
        int r100 = w0.a().b().a();     // Catch: Exception -> L6
        if (r100 < 0) goto L12;
        return Integer.toString(r100);
    L12:
        return "";
    L6:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static k0 b() {
        return f273139d;
    }

    private k0(Context r100) {
        this.f273141b = 0;
        this.f273142c = "";
        this.f273140a = r100;
    }

    private String a(String r100) {
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case 49653556: goto L46;
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
            default: goto L50;
        };
    L6:
        if (r100.equals("46011") == false) goto L50;
        r101 = 10;
        goto L50
    L10:
        if (r100.equals("46009") == false) goto L50;
        r101 = 9;
        goto L50
    L14:
        if (r100.equals("46007") == false) goto L50;
        r101 = 8;
        goto L50
    L18:
        if (r100.equals("46006") == false) goto L50;
        r101 = 7;
        goto L50
    L22:
        if (r100.equals("46005") == false) goto L50;
        r101 = 6;
        goto L50
    L26:
        if (r100.equals("46004") == false) goto L50;
        r101 = 5;
        goto L50
    L30:
        if (r100.equals("46003") == false) goto L50;
        r101 = 4;
        goto L50
    L34:
        if (r100.equals("46002") == false) goto L50;
        r101 = 3;
        goto L50
    L38:
        if (r100.equals("46001") == false) goto L50;
        r101 = 2;
        goto L50
    L42:
        if (r100.equals("46000") == false) goto L50;
        r101 = 1;
        goto L50
    L46:
        if (r100.equals("45412") == false) goto L50;
        r101 = 0;
    L50:
        switch(r101) {
            case 0: goto L59;
            case 1: goto L57;
            case 2: goto L55;
            case 3: goto L57;
            case 4: goto L53;
            case 5: goto L57;
            case 6: goto L53;
            case 7: goto L55;
            case 8: goto L57;
            case 9: goto L55;
            case 10: goto L53;
            default: goto L51;
        };
    L51:
        return "0";
    L53:
        u.b("SIMUtils", "中国电信");
        return "3";
    L55:
        u.b("SIMUtils", "中国联通");
        return "2";
    L57:
        u.b("SIMUtils", "中国移动");
        return "1";
    L59:
        u.a("SIMUtils", "香港移动");
        return "4";
    }

    private static String com_cmic_ida_sdk_k0_android_telephony_TelephonyManager_getSimOperator(TelephonyManager r110) {
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
        if ((System.currentTimeMillis() - this.f273141b) <= 3000) goto L9;
        this.f273141b = System.currentTimeMillis();
        TelephonyManager r101 = (TelephonyManager) this.f273140a.getSystemService("phone");
        if (r101 == null) goto L13;
        this.f273142c = com_cmic_ida_sdk_k0_android_telephony_TelephonyManager_getSimOperator(r101);
        u.a("SIMUtils", "getSimOperator SysOperator= " + this.f273142c);
        return this.f273142c;
    L13:
        return "";
    L9:
        u.a("SIMUtils", "使用缓存operator Operator= " + this.f273142c);
        return this.f273142c;
    }

    public static void a(Context r100) {
        f273139d = new k0(r100);
    }

    public String a(String r100, boolean r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = a(r101);
    L6:
        return a(r100);
    }
}
