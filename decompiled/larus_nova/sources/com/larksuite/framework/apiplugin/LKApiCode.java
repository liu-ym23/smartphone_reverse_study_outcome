package com.larksuite.framework.apiplugin;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
public final enum LKApiCode extends Enum<LKApiCode> {
    public static final LKApiCode GENERAL_PARAM = null;
    public static final LKApiCode GENERAL_UNKONW_ERROR = null;
    public static final LKApiCode GENERAL_USER_AUTH_DENIED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LKApiCode[] f285487a = null;
    public int code;
    public String msg;

    static {
        LKApiCode r100 = new LKApiCode("GENERAL_PARAM", 0, 10001, "invalid parameter");
        GENERAL_PARAM = r100;
        LKApiCode r101 = new LKApiCode("GENERAL_USER_AUTH_DENIED", 1, 10006, "user auth denied");
        GENERAL_USER_AUTH_DENIED = r101;
        LKApiCode r102 = new LKApiCode("GENERAL_UNKONW_ERROR", 2, 10010, IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        GENERAL_UNKONW_ERROR = r102;
        f285487a = new LKApiCode[]{r100, r101, r102};
    }

    public static LKApiCode[] values() {
        return (LKApiCode[]) f285487a.clone();
    }

    public static LKApiCode valueOf(String r100) {
        return (LKApiCode) a.a(LKApiCode.class, r100);
    }

    public LKApiCode(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.code = r102;
        this.msg = r103;
    }
}
