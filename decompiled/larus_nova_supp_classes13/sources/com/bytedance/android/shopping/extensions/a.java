package com.bytedance.android.shopping.extensions;

import android.graphics.Color;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final int a(String r1, int r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r3 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r1)));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r3) == false) goto L9;
        r3 = null;
    L9:
        Integer r4 = (Integer) r3;
        if (r4 != null) goto L12;
        return r2;
    L12:
        return r4.intValue();
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
