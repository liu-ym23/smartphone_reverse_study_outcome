package com.larus.account.saas.mfa.assist.handler;

import com.bytedance.common.wschannel.WsConstants;
import com.larus.account.saas.coreapi.IAccountFrontierMessageHandler;
import com.larus.account.saas.mfa.assist.MfaAssistManager;
import com.larus.account.saas.mfa.assist.bean.MfaMessage;
import com.larus.account.saas.runtime.internal.util.GsonHolder;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/larus/account/saas/mfa/assist/handler/MfaFrontierMessageHandler;", "Lcom/larus/account/saas/coreapi/IAccountFrontierMessageHandler;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "account-saas-mfa_release"}, k = 1, mv = {1, 7, 1})
public final class MfaFrontierMessageHandler implements IAccountFrontierMessageHandler {

    public static final class a {
    }

    static {
    }

    public MfaFrontierMessageHandler() {
    }

    @Override // com.larus.account.saas.coreapi.IAccountFrontierMessageHandler
    public final IAccountFrontierMessageHandler.Priority priority() {
        return IAccountFrontierMessageHandler.Priority.DEFAULT;
    }

    @Override // com.larus.account.saas.coreapi.IAccountFrontierMessageHandler
    public final boolean a(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        a48.a r102 = null;
        if (r100 != 1002) goto L5;
        Lazy r103 = GsonHolder.f286473a;
        MfaMessage r104 = (MfaMessage) GsonHolder.a(r101, MfaMessage.class);
        if (r104 != null) goto L28;
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.a("MfaFrontierMessageHandler", "handle mfa token receive frontier message failed, reason = parse_payload_failed");
    L38:
        if (r102 == null) goto L40;
        MfaAssistManager.f286395a.getClass();
        MfaAssistManager.b(r102);
    L40:
        return true;
    L28:
        String r105 = r104.b();
        if (r105 != null) goto L31;
    L37:
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.a("MfaFrontierMessageHandler", "handle mfa token receive frontier message failed, reason = payload_token_empty");
        goto L38
    L31:
        if ((!StringsKt.isBlank(r105)) == true) goto L34;
        r105 = null;
    L34:
        if (r105 == null) goto L37;
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.d("MfaFrontierMessageHandler", "handle mfa token receive frontier message, token = ".concat(r105));
        r102 = new a48.a.b(r105, r104, false);
        goto L38
    L5:
        if (r100 != 1003) goto L42;
        Lazy r106 = GsonHolder.f286473a;
        z38.a r107 = (z38.a) GsonHolder.a(r101, z38.a.class);
        if (r107 != null) goto L10;
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.a("MfaFrontierMessageHandler", "handle mfa token invalid frontier message failed, reason = parse_payload_failed");
    L23:
        if (r102 == null) goto L40;
        MfaAssistManager.f286395a.getClass();
        MfaAssistManager.b(r102);
        goto L40
    L10:
        String r108 = r107.d();
        if (r108 != null) goto L13;
    L22:
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.a("MfaFrontierMessageHandler", "handle mfa token invalid frontier message failed, reason = payload_token_empty");
        goto L23
    L13:
        if ((!StringsKt.isBlank(r108)) == true) goto L16;
        r108 = null;
    L16:
        if (r108 == null) goto L22;
        if (Intrinsics.areEqual(r107.a(), "success") == true) goto L21;
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.a("MfaFrontierMessageHandler", "handle mfa token invalid frontier message failed, reason = check_result_failed");
        goto L23
    L21:
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.d("MfaFrontierMessageHandler", "handle mfa token invalid frontier message, token = ".concat(r108));
        r102 = new a48.a.C0012a(r108, r107);
        goto L23
    L42:
        return false;
    }
}
