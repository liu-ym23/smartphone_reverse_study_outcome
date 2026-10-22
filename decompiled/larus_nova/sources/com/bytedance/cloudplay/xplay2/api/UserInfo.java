package com.bytedance.cloudplay.xplay2.api;

import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/UserInfo;", "", "()V", Keys.API_RETURN_KEY_IS_LOGIN, "", "()Z", "isRealNameAuth", "isTempUser", "xplay2-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UserInfo {
    private final boolean isLogin;
    private final boolean isRealNameAuth;
    private final boolean isTempUser;

    public UserInfo() {
    }

    public final boolean isLogin() {
        return this.isLogin;
    }

    public final boolean isRealNameAuth() {
        return this.isRealNameAuth;
    }

    public final boolean isTempUser() {
        return this.isTempUser;
    }
}
