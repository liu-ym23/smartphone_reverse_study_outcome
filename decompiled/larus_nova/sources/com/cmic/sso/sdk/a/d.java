package com.cmic.sso.sdk.a;

import android.text.TextUtils;
import com.cmic.sso.sdk.e.k;

/* JADX INFO: loaded from: classes22.dex */
class d {
    public static boolean a() {
        if (System.currentTimeMillis() < k.a("sso_config_xf", "client_valid", 0)) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(boolean r100) {
        if (r100 == true) goto L5;
        String r101 = "0";
    L7:
        return "1".equals(k.a("sso_config_xf", "CLOSE_IPV4_LIST", r101));
    L5:
        r101 = "1";
        goto L7
    }

    public static boolean b(boolean r100) {
        if (r100 == true) goto L5;
        String r101 = "0";
    L7:
        return "1".equals(k.a("sso_config_xf", "CLOSE_IPV6_LIST", r101));
    L5:
        r101 = "1";
        goto L7
    }

    public static boolean c(boolean r100) {
        if (r100 == true) goto L5;
        String r101 = "0";
    L7:
        if ("1".equals(k.a("sso_config_xf", "CLOSE_M008_APPID_LIST", r101)) == false) goto L9;
    L12:
        return true;
    L9:
        if ("1".equals(k.a("sso_config_xf", "CLOSE_M008_SDKVERSION_LIST", r101)) == true) goto L12;
        return false;
    L5:
        r101 = "1";
        goto L7
    }

    public static boolean d(boolean r100) {
        if (r100 == false) goto L5;
        String r101 = "CU";
    L7:
        return k.a("sso_config_xf", "CLOSE_FRIEND_WAPKS", r101).contains("CU");
    L5:
        r101 = "";
        goto L7
    }

    public static boolean e(boolean r100) {
        if (r100 == false) goto L5;
        String r101 = "CT";
    L7:
        return k.a("sso_config_xf", "CLOSE_FRIEND_WAPKS", r101).contains("CT");
    L5:
        r101 = "";
        goto L7
    }

    public static boolean f(boolean r100) {
        if (r100 == false) goto L5;
        String r101 = "1";
    L7:
        return "1".equals(k.a("sso_config_xf", "CLOSE_LOGS_VERSION", r101));
    L5:
        r101 = "0";
        goto L7
    }

    public static String a(String r100) {
        String r101 = k.a("sso_config_xf", "config_host", null);
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return r100;
    L6:
        return r101;
    }

    public static String b(String r100) {
        String r101 = k.a("sso_config_xf", "https_get_phone_scrip_host", null);
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return r100;
    L6:
        return r101;
    }

    public static String c(String r100) {
        String r101 = k.a("sso_config_xf", "logHost", "");
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return r100;
    L6:
        return r101;
    }

    public static int a(int r100) {
        return k.a("sso_config_xf", "maxFailedLogTimes", r100);
    }

    public static int b(int r100) {
        return k.a("sso_config_xf", "pauseTime", r100);
    }
}
