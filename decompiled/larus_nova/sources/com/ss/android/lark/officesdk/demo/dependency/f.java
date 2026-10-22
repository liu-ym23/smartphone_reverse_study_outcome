package com.ss.android.lark.officesdk.demo.dependency;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class f {
    public static final Uri a(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(UriProtector.parse(r100));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r102) == false) goto L9;
        r102 = null;
    L9:
        Uri r103 = (Uri) r102;
        if (r103 == null) goto L24;
        String r104 = r103.getScheme();
        if (r104 != null) goto L14;
    L17:
        boolean r105 = true;
    L19:
        if ((!r105) == true) goto L21;
        return null;
    L21:
        return r103;
    L14:
        if (StringsKt.isBlank(r104) == true) goto L17;
        r105 = false;
        goto L19
    L24:
        return null;
    L4:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
