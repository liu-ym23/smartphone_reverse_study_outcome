package com.xiaomi.push.service;

import com.android.ttcjpaysdk.thirdparty.fingerprint.CJPayFingerprintConstants;

/* JADX INFO: loaded from: classes41.dex */
public abstract class an {
    public static String A = "ext_auth_method";
    public static String B = "ext_security";
    public static String C = "ext_kick";
    public static String D = "ext_client_attr";
    public static String E = "ext_cloud_attr";
    public static String F = "ext_pkg_name";
    public static String G = "ext_notify_id";
    public static String H = "ext_clicked_button";
    public static String I = "ext_notify_type";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static String f464235J = "ext_session";
    public static String K = "sig";
    public static String L = "ext_notify_title";
    public static String M = "ext_notify_description";
    public static String N = "ext_messenger";
    public static String O = "title";
    public static String P = "description";
    public static String Q = "notifyId";
    public static String R = "dump";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f464236a = "1";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f464237b = "2";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f464238c = "3";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f464239d = "com.xiaomi.push.OPEN_CHANNEL";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f464240e = "com.xiaomi.push.SEND_MESSAGE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f464241f = "com.xiaomi.push.SEND_IQ";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f464242g = "com.xiaomi.push.BATCH_SEND_MESSAGE";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f464243h = "com.xiaomi.push.SEND_PRES";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f464244i = "com.xiaomi.push.CLOSE_CHANNEL";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f464245j = "com.xiaomi.push.FORCE_RECONN";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f464246k = "com.xiaomi.push.RESET_CONN";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f464247l = "com.xiaomi.push.UPDATE_CHANNEL_INFO";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f464248m = "com.xiaomi.push.SEND_STATS";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static String f464249n = "com.xiaomi.push.HANDLE_FCM_MSG";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static String f464250o = "com.xiaomi.push.APP_NOTIFY_MSG";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static String f464251p = "com.xiaomi.push.CHANGE_HOST";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static String f464252q = "com.xiaomi.push.PING_TIMER";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static String f464253r = "com.xiaomi.push.APP_CHANNEL_SWITCH";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static String f464254s = "ext_user_id";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static String f464255t = "ext_user_server";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static String f464256u = "ext_user_res";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static String f464257v = "ext_chid";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static String f464258w = "ext_receive_time";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static String f464259x = "ext_broadcast_time";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static String f464260y = "ext_sid";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static String f464261z = "ext_token";

    public static String a(int r100) {
        switch(r100) {
            case 0: goto L49;
            case 1: goto L47;
            case 2: goto L45;
            case 3: goto L43;
            case 4: goto L41;
            case 5: goto L39;
            case 6: goto L37;
            case 7: goto L35;
            case 8: goto L33;
            case 9: goto L31;
            case 10: goto L29;
            case 11: goto L27;
            case 12: goto L25;
            case 13: goto L23;
            case 14: goto L21;
            case 15: goto L19;
            case 16: goto L17;
            case 17: goto L15;
            case 18: goto L13;
            case 19: goto L11;
            case 20: goto L9;
            case 21: goto L7;
            case 22: goto L5;
            default: goto L4;
        };
    L5:
        return "ERROR_PING_TIMEOUT";
    L7:
        return "ERROR_BIND_TIMEOUT";
    L9:
        return "ERROR_REDIRECT";
    L11:
        return "ERROR_USER_BLOCKED";
    L13:
        return "ERROR_CONNECTIING_TIMEOUT";
    L15:
        return "ERROR_READ_TIMEOUT";
    L17:
        return "ERROR_SESSION_CHANGED";
    L19:
        return "ERROR_SERVICE_DESTROY";
    L21:
        return "ERROR_THREAD_BLOCK";
    L23:
        return "ERROR_SERVER_STREAM";
    L25:
        return "ERROR_NO_CLIENT";
    L27:
        return "ERROR_RESET";
    L29:
        return "ERROR_SEND_ERROR";
    L31:
        return "ERROR_READ_ERROR";
    L33:
        return "ERROR_RECEIVE_TIMEOUT";
    L35:
        return "ERROR_SERVER_ERROR";
    L37:
        return "ERROR_MULTI_LOGIN";
    L39:
        return CJPayFingerprintConstants.ERROR_AUTH_FAILED_MSG;
    L41:
        return "ERROR_ACCESS_DENIED";
    L43:
        return "ERROR_NETWORK_FAILED";
    L45:
        return "ERROR_NETWORK_NOT_AVAILABLE";
    L47:
        return "ERROR_SERVICE_NOT_INSTALLED";
    L49:
        return "ERROR_OK";
    L4:
        return String.valueOf(r100);
    }
}
