package com.ss.ugc.effectplatform;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.ss.android.ugc.effectmanager.common.ErrorConstants;

/* JADX INFO: loaded from: classes5.dex */
public final class i {
    public static String a(int r100) {
        if (r100 != 1) goto L5;
        return IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN;
    L5:
        if (r100 != 10014) goto L7;
        return "Invalid effect id";
    L7:
        if (r100 != 10016) goto L9;
        return ErrorConstants.EXCEPTION_CONTEXT_NULL;
    L9:
        if (r100 != 10019) goto L11;
        return ErrorConstants.EXCEPTION_PAUSE_DOWNLOAD;
    L11:
        if (r100 != 1100) goto L13;
        return "The current application is not a test application";
    L13:
        if (r100 == 1101) goto L45;
        switch(r100) {
            case 1000: goto L27;
            case 1001: goto L26;
            case 1002: goto L25;
            case 1003: goto L24;
            case 1004: goto L23;
            case 1005: goto L22;
            case 1006: goto L21;
            case 1007: goto L20;
            case 1008: goto L19;
            default: goto L15;
        };
    L15:
        switch(r100) {
            case 2001: goto L33;
            case 2002: goto L32;
            case 2003: goto L31;
            case 2004: goto L30;
            case 2005: goto L29;
            case 2006: goto L28;
            default: goto L16;
        };
    L16:
        switch(r100) {
            case 10001: goto L40;
            case 10002: goto L39;
            case 10003: goto L38;
            case 10004: goto L37;
            case 10005: goto L36;
            case 10006: goto L35;
            case 10007: goto L34;
            default: goto L17;
        };
    L17:
        switch(r100) {
            case 10009: goto L44;
            case 10010: goto L43;
            case 10011: goto L42;
            case 10012: goto L41;
            default: goto L18;
        };
    L18:
        return "Unkown error";
    L41:
        return "io error";
    L42:
        return "No network";
    L43:
        return ErrorConstants.EXCEPTION_MD5_ERROR;
    L44:
        return "No local TAG cache";
    L34:
        return ErrorConstants.EXCEPTION_PANEL_NULL;
    L35:
        return ErrorConstants.EXCEPTION_NO_DOWNLOADED_EFFECTS;
    L36:
        return ErrorConstants.EXCEPTION_SDK_ERROR;
    L37:
        return ErrorConstants.EXCEPTION_INVALID_EFFECT_CACHE;
    L38:
        return ErrorConstants.EXCEPTION_EFFECT_NULL;
    L39:
        return ErrorConstants.EXCEPTION_DOWNLOAD_ERROR;
    L40:
        return ErrorConstants.EXCEPTION_CANCEL_DOWNLOAD;
    L28:
        return "App needs to be updated";
    L29:
        return "Not on allowed list";
    L30:
        return "The current effect id does not exist";
    L31:
        return "Does not support the current device";
    L32:
        return "Effect is offline";
    L33:
        return "no change in content";
    L19:
        return "app_channel is invalid";
    L20:
        return "channel is invalid";
    L21:
        return "device_type is invalid";
    L22:
        return "device_platform is invalid";
    L23:
        return "device_id is invalid";
    L24:
        return "sdk_version is invalid";
    L25:
        return "app_version is invalid";
    L26:
        return "access_key is invalid";
    L27:
        return "Illegal params (missing or wrong params)";
    L45:
        return "access_key does not exist";
    }

    static {
    }
}
