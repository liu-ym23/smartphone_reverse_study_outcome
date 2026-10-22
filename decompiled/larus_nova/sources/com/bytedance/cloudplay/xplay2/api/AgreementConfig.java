package com.bytedance.cloudplay.xplay2.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/AgreementConfig;", "", "()V", "privacyAgreementText", "", "getPrivacyAgreementText", "()Ljava/lang/String;", "privacyAgreementUrl", "getPrivacyAgreementUrl", "realNameAgreementText", "getRealNameAgreementText", "realNameAgreementUrl", "getRealNameAgreementUrl", "userAgreementText", "getUserAgreementText", "userAgreementUrl", "getUserAgreementUrl", "xplay2-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AgreementConfig {
    private final String privacyAgreementText;
    private final String privacyAgreementUrl;
    private final String realNameAgreementText;
    private final String realNameAgreementUrl;
    private final String userAgreementText;
    private final String userAgreementUrl;

    public AgreementConfig() {
        this.privacyAgreementUrl = "";
        this.privacyAgreementText = "";
        this.userAgreementUrl = "";
        this.userAgreementText = "";
        this.realNameAgreementUrl = "";
        this.realNameAgreementText = "";
    }

    public final String getPrivacyAgreementText() {
        return this.privacyAgreementText;
    }

    public final String getPrivacyAgreementUrl() {
        return this.privacyAgreementUrl;
    }

    public final String getRealNameAgreementText() {
        return this.realNameAgreementText;
    }

    public final String getRealNameAgreementUrl() {
        return this.realNameAgreementUrl;
    }

    public final String getUserAgreementText() {
        return this.userAgreementText;
    }

    public final String getUserAgreementUrl() {
        return this.userAgreementUrl;
    }
}
