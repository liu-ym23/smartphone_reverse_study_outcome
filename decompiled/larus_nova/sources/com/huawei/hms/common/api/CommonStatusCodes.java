package com.huawei.hms.common.api;

/* JADX INFO: loaded from: classes23.dex */
public class CommonStatusCodes {
    public static final int API_NOT_CONNECTED = 17;
    public static final int CANCELED = 16;
    public static final int DEVELOPER_ERROR = 10;
    public static final int ERROR = 13;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 14;
    public static final int INVALID_ACCOUNT = 5;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int SUCCESS_CACHE = -1;
    public static final int TIMEOUT = 15;

    public CommonStatusCodes() {
    }

    public static String getStatusCodeString(int r100) {
        if (r100 == (-1)) goto L43;
        if (r100 != 0) goto L6;
        return "SUCCESS";
    L6:
        if (r100 != 10) goto L8;
        return "DEVELOPER_ERROR";
    L8:
        if (r100 == 9004) goto L37;
        switch(r100) {
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L13;
            default: goto L10;
        };
    L10:
        switch(r100) {
            case 13: goto L35;
            case 14: goto L33;
            case 15: goto L31;
            case 16: goto L29;
            case 17: goto L27;
            default: goto L12;
        };
    L27:
        return "API_NOT_CONNECTED";
    L29:
        return "CANCELED";
    L31:
        return "TIMEOUT";
    L33:
        return "INTERRUPTED";
    L35:
        return "ERROR";
    L12:
        return "unknown status code: " + r100;
    L13:
        return "INTERNAL_ERROR";
    L15:
        return "NETWORK_ERROR";
    L17:
        return "RESOLUTION_REQUIRED";
    L19:
        return "INVALID_ACCOUNT";
    L21:
        return "SIGN_IN_REQUIRED";
    L23:
        return "SERVICE_DISABLED";
    L25:
        return "SERVICE_VERSION_UPDATE_REQUIRED";
    L37:
        return "DEAD_CLIENT";
    L43:
        return "SUCCESS_CACHE";
    }
}
