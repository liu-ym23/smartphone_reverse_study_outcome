package com.bytedance.android.livesdk.link.model;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w3 {
    public static final String a(v3 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toParams");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(l97.a.a.toJson(r1));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r2) == false) goto L10;
        r2 = null;
    L10:
        String r3 = (String) r2;
        if (r3 != null) goto L16;
        return "";
    L16:
        return r3;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
