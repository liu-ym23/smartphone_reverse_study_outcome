package com.ss.android.lark.passport.signinsdk_api.entity;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/entity/AgreementUrl;", "Ljava/io/Serializable;", "<init>", "()V", "clauseUrl", "", "getClauseUrl", "()Ljava/lang/String;", "setClauseUrl", "(Ljava/lang/String;)V", "privacyPolicyUrl", "getPrivacyPolicyUrl", "setPrivacyPolicyUrl", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AgreementUrl implements Serializable {

    @JSONField(name = "clause_url")
    private String clauseUrl;

    @JSONField(name = "privacy_policy_url")
    private String privacyPolicyUrl;

    public AgreementUrl() {
    }

    public final String getClauseUrl() {
        return this.clauseUrl;
    }

    public final String getPrivacyPolicyUrl() {
        return this.privacyPolicyUrl;
    }

    public final void setClauseUrl(String r100) {
        this.clauseUrl = r100;
    }

    public final void setPrivacyPolicyUrl(String r100) {
        this.privacyPolicyUrl = r100;
    }
}
