package com.ss.android.ugc.effectmanager.common;

/* JADX INFO: loaded from: classes40.dex */
public class ErrorConstants {
    public static final int APP_NEED_UPGRADE = 2006;
    public static final int CODE_CANCEL_DOWNLOAD = 10001;
    public static final int CODE_DOWNLOAD_ERROR = 10002;
    public static final int CODE_EFFECT_NULL = 10003;
    public static final int CODE_INVALID_EFFECT_CACHE = 10004;
    public static final int CODE_INVALID_EFFECT_ID = 10014;
    public static final int CODE_IO_FAIL = 10012;
    public static final int CODE_JSON_CONVERT_ERROR = 10008;
    public static final int CODE_LINK_CONTEXT_NULL = 10016;
    public static final int CODE_MD5_ERROR = 10010;
    public static final int CODE_MODEL_FETCH_FAIL = 10018;
    public static final int CODE_NO_DOWNLOADED_EFFECTS = 10006;
    public static final int CODE_NO_LOCAL_TAG = 10009;
    public static final int CODE_NO_NETWORK = 10011;
    public static final int CODE_PANEL_NULL = 10007;
    public static final int CODE_PAUSE_DOWNLOAD = 10019;
    public static final int CODE_SDK_ERROR = 10005;
    public static final int CODE_UNKNOW = 1;
    public static final int CODE_UNZIP_FAIL = 10013;
    public static final int CODE_URL_NOT_EXIST = 10015;
    public static final int EFFECT_NOT_FOUND = 2004;
    public static final int EFFECT_NOT_IN_ALLOW_LIST = 2005;
    public static final int EFFECT_NOT_SUPPORT = 2003;
    public static final int EFFECT_UNAVAILABLE = 2002;
    public static final String EXCEPTION_CANCEL_DOWNLOAD = "Cancel download";
    public static final String EXCEPTION_CONTEXT_NULL = "link-selector context is null";
    public static final String EXCEPTION_DOWNLOAD_ERROR = "Download error";
    public static final String EXCEPTION_DOWNLOAD_URL_ERROR = "File url is empty";
    public static final String EXCEPTION_EFFECT_NULL = "Sticker is null";
    public static final String EXCEPTION_INVALID_EFFECT_CACHE = "Invalid effect list cache !!!";
    public static final String EXCEPTION_JSON_CONVERT = "Json convert fail";
    public static final String EXCEPTION_MD5_ERROR = "MD5 error";
    public static final String EXCEPTION_NO_DOWNLOADED_EFFECTS = "No Downloaded Effects";
    public static final String EXCEPTION_NO_NETWORK = "network unavailable";
    public static final String EXCEPTION_PANEL_NULL = "panel is null";
    public static final String EXCEPTION_PAUSE_DOWNLOAD = "Pause download";
    public static final String EXCEPTION_SDK_ERROR = "SDK error";
    public static final String LOG_CACHE_DIR_NOT_SET = "Cache directory error";
    public static final String LOG_CONFIGURATION_NOT_SET = "Not set configuration";
    public static final String LOG_CONTEXT_NOT_SET = "Not set net context";
    public static final String LOG_HOST_NOT_SET = "Not set host !!!";
    public static final String LOG_JSON_CONCERT_NOT_SET = "Not set json convert";
    public static final String LOG_NET_WORKER_NOT_SET = "Not set net worker";

    public ErrorConstants() {
    }

    public static String APIErrorHandle(int r100) {
        if (r100 != 1) goto L5;
        return "Unknown error";
    L5:
        if (r100 != 10014) goto L7;
        return "Effect id is invalid";
    L7:
        if (r100 != 10016) goto L9;
        return EXCEPTION_CONTEXT_NULL;
    L9:
        if (r100 != 10019) goto L11;
        return EXCEPTION_PAUSE_DOWNLOAD;
    L11:
        if (r100 != 1100) goto L13;
        return "The current application is not a test application";
    L13:
        if (r100 == 1101) goto L45;
        switch(r100) {
            case 1000: goto L44;
            case 1001: goto L43;
            case 1002: goto L42;
            case 1003: goto L41;
            case 1004: goto L40;
            case 1005: goto L39;
            case 1006: goto L38;
            case 1007: goto L37;
            case 1008: goto L36;
            default: goto L15;
        };
    L15:
        switch(r100) {
            case 2001: goto L35;
            case 2002: goto L34;
            case 2003: goto L33;
            case 2004: goto L32;
            case 2005: goto L31;
            case 2006: goto L30;
            default: goto L16;
        };
    L16:
        switch(r100) {
            case 10001: goto L29;
            case 10002: goto L28;
            case 10003: goto L27;
            case 10004: goto L26;
            case 10005: goto L25;
            case 10006: goto L24;
            case 10007: goto L23;
            default: goto L17;
        };
    L17:
        switch(r100) {
            case 10009: goto L22;
            case 10010: goto L21;
            case 10011: goto L20;
            case 10012: goto L19;
            default: goto L82;
        };
    L19:
        return "IO error";
    L20:
        return "no network";
    L21:
        return EXCEPTION_MD5_ERROR;
    L22:
        return "no local TAG cache";
    L82:
        return "Unknown error";
    L23:
        return EXCEPTION_PANEL_NULL;
    L24:
        return EXCEPTION_NO_DOWNLOADED_EFFECTS;
    L25:
        return EXCEPTION_SDK_ERROR;
    L26:
        return EXCEPTION_INVALID_EFFECT_CACHE;
    L27:
        return EXCEPTION_EFFECT_NULL;
    L28:
        return EXCEPTION_DOWNLOAD_ERROR;
    L29:
        return EXCEPTION_CANCEL_DOWNLOAD;
    L30:
        return "The app needs updating";
    L31:
        return "is not in the allow-list";
    L32:
        return "Effect is not existed";
    L33:
        return "The current device is not supported";
    L34:
        return "Effect is offline";
    L35:
        return "No content updating";
    L36:
        return "app_channel is illegal";
    L37:
        return "channel is illegal";
    L38:
        return "device_type is illegal";
    L39:
        return "device_platform is illegal";
    L40:
        return "device_id is illegal";
    L41:
        return "sdk_version is illegal";
    L42:
        return "app_version is illegal";
    L43:
        return "access_key is illegal";
    L44:
        return "Arguments is illegal";
    L45:
        return "access_key not existed";
    }
}
