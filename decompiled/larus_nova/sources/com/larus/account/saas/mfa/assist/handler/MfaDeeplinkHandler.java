package com.larus.account.saas.mfa.assist.handler;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.account.saas.coreapi.IAccountDeeplinkHandler;
import com.larus.account.saas.mfa.assist.MfaAssistManager;
import com.larus.account.saas.mfa.assist.bean.MfaMessage;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/larus/account/saas/mfa/assist/handler/MfaDeeplinkHandler;", "Lcom/larus/account/saas/coreapi/IAccountDeeplinkHandler;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "account-saas-mfa_release"}, k = 1, mv = {1, 7, 1})
public final class MfaDeeplinkHandler implements IAccountDeeplinkHandler {

    public static final class a {
    }

    static {
    }

    public MfaDeeplinkHandler() {
    }

    @Override // com.larus.account.saas.coreapi.IAccountDeeplinkHandler
    public final boolean a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        if (StringsKt.equals(r100.getHost(), "doubaoaccountsdk", true) == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
        return false;
    L10:
        String r102 = b(r100, "user_code");
        a48.a.b r103 = null;
        if (r102 != null) goto L13;
    L19:
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.a("MfaDeeplinkHandler", "handle mfa deeplink failed, reason = payload_token_empty");
    L20:
        if (r103 == null) goto L22;
        MfaAssistManager.f286395a.getClass();
        MfaAssistManager.b(r103);
    L22:
        return true;
    L13:
        if ((!StringsKt.isBlank(r102)) == true) goto L16;
        r102 = null;
    L16:
        if (r102 == null) goto L19;
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.d("MfaDeeplinkHandler", "handle mfa push code deeplink, token = ".concat(r102));
        r103 = new a48.a.b(r102, new MfaMessage(b(r100, "scene"), r102), true);
        goto L20
    L5:
        if (Intrinsics.areEqual(r100.getPath(), "/mfa_push_code") == false) goto L7;
        r101 = true;
        goto L8
    }

    public static String b(Uri r100, String r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(UriProtector.getQueryParameter(r100, r101));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        return (String) r103;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
