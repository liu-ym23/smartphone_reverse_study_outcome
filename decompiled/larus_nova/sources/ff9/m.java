package ff9;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;

/* JADX INFO: loaded from: classes30.dex */
public final class m {
    public static final String a(int r100) {
        if (r100 != (-1084)) goto L5;
        return "abnormal server status";
    L5:
        if (r100 != (-1080)) goto L7;
        return "over publish stream limit";
    L7:
        if (r100 == (-1070)) goto L36;
        if (r100 != 0) goto L10;
        return "success";
    L10:
        if (r100 != (-1026)) goto L12;
        return "user forbidden";
    L12:
        if (r100 != (-1025)) goto L14;
        return "room forbidden";
    L14:
        if (r100 != (-1014)) goto L16;
        return "different user id";
    L16:
        if (r100 == (-1013)) goto L31;
        switch(r100) {
            case -1011: goto L30;
            case -1010: goto L29;
            case -1009: goto L28;
            default: goto L18;
        };
    L18:
        switch(r100) {
            case -1007: goto L27;
            case -1006: goto L26;
            case -1005: goto L25;
            case -1004: goto L24;
            case -1003: goto L23;
            case -1002: goto L22;
            case -1001: goto L21;
            case -1000: goto L20;
            default: goto L19;
        };
    L19:
        return IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN;
    L20:
        return "invalid token";
    L21:
        return "unknown error on join room";
    L22:
        return "no publish permission";
    L23:
        return "no subscribe permission";
    L24:
        return "duplicate login";
    L25:
        return "app id is null";
    L26:
        return "kicked out";
    L27:
        return "illegal room id";
    L28:
        return "token is expired";
    L29:
        return "update token with invalid token";
    L30:
        return "room dismissed";
    L31:
        return "room already exist";
    L36:
        return "over subscribe limit";
    }
}
