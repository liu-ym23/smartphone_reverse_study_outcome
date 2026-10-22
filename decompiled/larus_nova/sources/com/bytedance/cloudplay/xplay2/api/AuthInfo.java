package com.bytedance.cloudplay.xplay2.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u0010X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/AuthInfo;", "", "()V", "agreementConfig", "Lcom/bytedance/cloudplay/xplay2/api/AgreementConfig;", "getAgreementConfig", "()Lcom/bytedance/cloudplay/xplay2/api/AgreementConfig;", "needAuthorized", "", "getNeedAuthorized", "()Z", "needClientLaunchAuth", "getNeedClientLaunchAuth", "needRealNameAuth", "getNeedRealNameAuth", "token", "", "getToken", "()Ljava/lang/String;", "userInfo", "Lcom/bytedance/cloudplay/xplay2/api/UserInfo;", "getUserInfo", "()Lcom/bytedance/cloudplay/xplay2/api/UserInfo;", "xplay2-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AuthInfo {
    private final AgreementConfig agreementConfig;
    private final boolean needAuthorized;
    private final boolean needClientLaunchAuth;
    private final boolean needRealNameAuth;
    private final String token;
    private final UserInfo userInfo;

    public AuthInfo() {
        this.token = "";
        this.agreementConfig = new AgreementConfig();
        this.userInfo = new UserInfo();
        this.needRealNameAuth = true;
        this.needAuthorized = true;
    }

    public final AgreementConfig getAgreementConfig() {
        return this.agreementConfig;
    }

    public final boolean getNeedAuthorized() {
        return this.needAuthorized;
    }

    public final boolean getNeedClientLaunchAuth() {
        return this.needClientLaunchAuth;
    }

    public final boolean getNeedRealNameAuth() {
        return this.needRealNameAuth;
    }

    public final String getToken() {
        return this.token;
    }

    public final UserInfo getUserInfo() {
        return this.userInfo;
    }
}
