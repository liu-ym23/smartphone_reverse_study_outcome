package com.bytedance.bdp.appbase.netapi.base;

import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Deprecated(message = "TODO: 2023/02/05 融合 在小程序内早删了，小游戏还有AccountService和UserInfoRequester在用，后续合并好就干掉")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/bdp/appbase/netapi/base/DefCallerErrorCode;", "", "()V", "notLoginError", "Lcom/bytedance/bdp/appbase/netapi/base/ErrorCode;", "notSupportError", "userAuthDenyError", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
public final class DefCallerErrorCode {
    public static final DefCallerErrorCode INSTANCE = null;
    public static final ErrorCode notLoginError = null;
    public static final ErrorCode notSupportError = null;
    public static final ErrorCode userAuthDenyError = null;

    private DefCallerErrorCode() {
    }

    static {
        INSTANCE = new DefCallerErrorCode();
        notSupportError = new ErrorCode(-11000, "not support reason:");
        notLoginError = new ErrorCode(-11001, "not login");
        userAuthDenyError = new ErrorCode(-11002, "auth deny");
    }
}
