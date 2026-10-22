package com.ss.android.lark.passport.flow.mfa;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes37.dex */
public final class i {
    public static final String a(Uri r100, String r101) {
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
