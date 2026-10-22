package com.oplus.ocs.base.common.constant;

/* JADX INFO: loaded from: classes34.dex */
public class CommonStatusCodes {
    public static final int API_NOT_CONNECTED = 11;
    public static final int APP_DISABLE_EXCEPTION = 1011;
    public static final int AUTHCODE_EXPECTED = 1004;
    public static final int AUTHCODE_INVALID = 1007;
    public static final int AUTHCODE_RECYCLE = 1006;
    public static final int AUTHENTICATE_FAIL = 1002;
    public static final int AUTHENTICATE_SUCCESS = 1001;
    public static final int CANCELED = 6;
    public static final int CAPABILITY_EXCEPTION = 1008;
    public static final int CLIENT_UNKNOWN = 12;
    public static final int CONNECTED = 1;
    public static final int CONNECTED_SUCCESS_UNBIND = 5;
    public static final int CONNECTING = 2;
    public static final int CONNECT_FAILED = 3;
    public static final int DISCONNECT = 4;
    public static final int INTERNAL_ERROR = 7;
    public static final int INTERNAL_EXCEPTION = 1010;
    public static final int INTERRUPTED = 9;
    public static final int RECONNECTING = 14;
    public static final int SERVICE_ABNORMAL_EXIT = 13;
    public static final int STATUS_EXCEPTION = 1009;
    public static final int SUCCESS = 0;
    public static final int SUCCESS_CACHE = -1;
    public static final int TASK_NULL = 8;
    public static final int TIMEOUT = 10;
    public static final int TIME_EXPIRED = 1003;
    public static final int VERSION_INCOMPATIBLE = 1005;

    public CommonStatusCodes() {
    }

    public static String getStatusCodeString(int r100) {
        switch(r100) {
            case -1: goto L58;
            case 0: goto L56;
            case 1: goto L54;
            case 2: goto L52;
            case 3: goto L50;
            case 4: goto L48;
            case 5: goto L46;
            case 6: goto L44;
            case 7: goto L42;
            case 8: goto L40;
            case 9: goto L38;
            case 10: goto L36;
            case 11: goto L34;
            case 12: goto L32;
            case 13: goto L30;
            case 14: goto L28;
            default: goto L3;
        };
    L3:
        switch(r100) {
            case 1001: goto L26;
            case 1002: goto L24;
            case 1003: goto L22;
            case 1004: goto L20;
            case 1005: goto L18;
            case 1006: goto L16;
            case 1007: goto L14;
            case 1008: goto L12;
            case 1009: goto L10;
            case 1010: goto L8;
            case 1011: goto L6;
            default: goto L4;
        };
    L4:
        StringBuilder r101 = new StringBuilder(32);
        r101.append("unknown status code: ");
        r101.append(r100);
        return r101.toString();
    L6:
        return "APP_DISABLE_EXCEPTION";
    L8:
        return "INTERNAL_EXCEPTION";
    L10:
        return "STATUS_EXCEPTION";
    L12:
        return "CAPABILITY_EXCEPTION";
    L14:
        return "AUTHCODE_INVALID";
    L16:
        return "AUTHCODE_RECYCLE";
    L18:
        return "VERSION_INCOMPATIBLE";
    L20:
        return "AUTHCODE_EXPECTED";
    L22:
        return "TIME_EXPIRED";
    L24:
        return "AUTHENTICATE_FAIL";
    L26:
        return "AUTHENTICATE_SUCCESS";
    L28:
        return "RECONNECTING";
    L30:
        return "SERVICE_ABNORMAL_EXIT";
    L32:
        return "CLIENT_UNKNOWN";
    L34:
        return "API_NOT_CONNECTED";
    L36:
        return "TIMEOUT";
    L38:
        return "INTERRUPTED";
    L40:
        return "TASK_NULL";
    L42:
        return "INTERNAL_ERROR";
    L44:
        return "CANCELED";
    L46:
        return "SUCCESS_UNBIND";
    L48:
        return "DISCONNECT";
    L50:
        return "CONNECT_FAILED";
    L52:
        return "CONNECTING";
    L54:
        return "CONNECTED";
    L56:
        return "SUCCESS";
    L58:
        return "SUCCESS_CACHE";
    }
}
