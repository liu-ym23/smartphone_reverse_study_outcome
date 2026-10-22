package com.bytedance.android.shopping.orderlist.common.utils;

import java.net.URLDecoder;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o {
    public static final String a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$safeDecode");
        if (StringsKt.isBlank(r1) == true) goto L19;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl(URLDecoder.decode(r1, Charsets.UTF_8.name()));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r2) == false) goto L12;
        r2 = null;
    L12:
        String r3 = (String) r2;
        if (r3 != null) goto L18;
        return "";
    L18:
        return r3;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L19:
        return r1;
    }
}
