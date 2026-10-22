package com.bytedance.ee.bear.middleground.permission.secret;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/UpdateSecretLevelResult;", "Ljava/io/Serializable;", "success", "", "error", "", "sessionCode", "", "<init>", "(ZLjava/lang/Throwable;Ljava/lang/String;)V", "getSuccess", "()Z", "getError", "()Ljava/lang/Throwable;", "getSessionCode", "()Ljava/lang/String;", "setSessionCode", "(Ljava/lang/String;)V", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateSecretLevelResult implements Serializable {
    private final Throwable error;
    private String sessionCode;
    private final boolean success;

    public final Throwable getError() {
        return this.error;
    }

    public final String getSessionCode() {
        return this.sessionCode;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final void setSessionCode(String r1) {
        this.sessionCode = r1;
    }

    public UpdateSecretLevelResult(boolean r1, Throwable r2, String r3) {
        this.success = r1;
        this.error = r2;
        this.sessionCode = r3;
    }
}
