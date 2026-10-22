package com.bytedance.android.shopping.store.tabkit.cache;

import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public static final String a(String r2) {
        Object r1 = null;
        if (StringsKt.isBlank(r2) == true) goto L17;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r3 = Result.constructor-impl(UriProtector.parse(r2).buildUpon().clearQuery().toString());     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r3) == true) goto L14;
        r1 = r3;
    L14:
        return (String) r1;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L17:
        return null;
    }
}
