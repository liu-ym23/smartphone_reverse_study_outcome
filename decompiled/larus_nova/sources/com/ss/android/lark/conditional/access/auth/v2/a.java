package com.ss.android.lark.conditional.access.auth.v2;

import android.util.Pair;
import com.ss.android.lark.audit.AuditManager;
import com.ss.android.lark.security.compliance.api.model.filepolicy.AuthEntity;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ResultType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateConfig;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResultSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {
    public a() {
    }

    public final ValidateResult a(com.ss.android.lark.security.compliance.api.model.filepolicy.e r100, ValidateConfig r101) {
        AuthEntity r102 = (AuthEntity) r100;
        Intrinsics.checkNotNullParameter(r102, "p");
        Pair<Integer, Integer> r103 = AuditManager.getInstance().checkAuthorityWithErrorType(r102.getPermType(), r102.getEntityType(), r102.getEntityId());
        Intrinsics.checkNotNull(r103);
        Integer r104 = (Integer) r103.first;
        Integer r105 = (Integer) r103.second;
        Intrinsics.checkNotNull(r104);
        int r106 = r104.intValue();
        boolean r107 = true;
        if (r106 == 0) goto L16;
        if (r106 != 1) goto L6;
        ResultType r108 = ResultType.DENY;
    L17:
        ValidateResult r109 = new ValidateResult(r108);
        r109.setResultPolicy(FileAuthResultFrom.COME_FROM_AUTHZ);
        Intrinsics.checkNotNull(r105);
        r109.setErrorReason(r105.intValue());
        r109.setPolicyMethod(ValidateResultSource.OTHERS);
        if (r108 != ResultType.ERROR) goto L21;
        r107 = false;
    L21:
        r109.setCredible(r107);
        return r109;
    L6:
        if (r106 != 2) goto L8;
        r108 = ResultType.ALLOW;
        goto L17
    L8:
        if (r106 != 3) goto L10;
        r108 = ResultType.NULL;
        goto L17
    L10:
        if (r106 == 4) goto L12;
        r108 = ResultType.UNKNOWN;
        goto L17
    L12:
        r108 = ResultType.ERROR;
        goto L17
    L16:
        r108 = ResultType.UNKNOWN;
        goto L17
    }
}
