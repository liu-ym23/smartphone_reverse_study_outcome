package com.bytedance.bdp.appbase.approute.contextservice.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/bdp/appbase/approute/contextservice/entity/NavigateToMiniAppError;", "", "UN_SUPPORT_ON_GAME", "CANNOT_JUMP_SELF", "NAVIGATE_APP_ID_NOT_IN_JUMP_LIST", "CANCEL", "bdp-appbase-cpapi_release"}, k = 1, mv = {1, 4, 0})
public final enum NavigateToMiniAppError extends Enum<NavigateToMiniAppError> {
    public static final NavigateToMiniAppError CANCEL = null;
    public static final NavigateToMiniAppError CANNOT_JUMP_SELF = null;
    public static final NavigateToMiniAppError NAVIGATE_APP_ID_NOT_IN_JUMP_LIST = null;
    public static final NavigateToMiniAppError UN_SUPPORT_ON_GAME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NavigateToMiniAppError[] f200399a = null;

    static {
        NavigateToMiniAppError r100 = new NavigateToMiniAppError("UN_SUPPORT_ON_GAME", 0);
        UN_SUPPORT_ON_GAME = r100;
        NavigateToMiniAppError r101 = new NavigateToMiniAppError("CANNOT_JUMP_SELF", 1);
        CANNOT_JUMP_SELF = r101;
        NavigateToMiniAppError r102 = new NavigateToMiniAppError("NAVIGATE_APP_ID_NOT_IN_JUMP_LIST", 2);
        NAVIGATE_APP_ID_NOT_IN_JUMP_LIST = r102;
        NavigateToMiniAppError r103 = new NavigateToMiniAppError("CANCEL", 3);
        CANCEL = r103;
        f200399a = new NavigateToMiniAppError[]{r100, r101, r102, r103};
    }

    public static NavigateToMiniAppError valueOf(String r100) {
        return (NavigateToMiniAppError) a.a(NavigateToMiniAppError.class, r100);
    }

    public static NavigateToMiniAppError[] values() {
        return (NavigateToMiniAppError[]) f200399a.clone();
    }

    public NavigateToMiniAppError(String r100, int r101) {
        super(r100, r101);
    }
}
