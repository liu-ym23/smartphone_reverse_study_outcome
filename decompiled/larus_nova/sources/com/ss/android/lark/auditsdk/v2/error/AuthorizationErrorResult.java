package com.ss.android.lark.auditsdk.v2.error;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/auditsdk/v2/error/AuthorizationErrorResult;", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "errorCode", "", "<init>", "(I)V", "validateResult", "Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResult;", "getValidateResult", "()Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResult;", "setValidateResult", "(Lcom/ss/android/lark/security/compliance/api/model/filepolicy/ValidateResult;)V", "audit-wrapper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthorizationErrorResult extends ErrorResult {
    private ValidateResult validateResult;

    public final ValidateResult getValidateResult() {
        return this.validateResult;
    }

    public AuthorizationErrorResult(int r100) {
        super(r100);
    }

    public final void setValidateResult(ValidateResult r100) {
        this.validateResult = r100;
    }
}
