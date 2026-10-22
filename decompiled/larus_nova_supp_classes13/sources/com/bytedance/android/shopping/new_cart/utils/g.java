package com.bytedance.android.shopping.new_cart.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g {
    public static final String a(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$stackTraceToString");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        StringWriter r1 = new StringWriter();     // Catch: Throwable -> L5
        PrintWriter r3 = new PrintWriter(r1);     // Catch: Throwable -> L5
        r2.printStackTrace(r3);     // Catch: Throwable -> L5
        r3.flush();     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(r1.toString());     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r4) == false) goto L10;
        r4 = null;
    L10:
        String r5 = (String) r4;
        if (r5 != null) goto L16;
        return "";
    L16:
        return r5;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
