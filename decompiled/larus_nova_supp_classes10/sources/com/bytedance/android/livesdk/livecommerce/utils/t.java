package com.bytedance.android.livesdk.livecommerce.utils;

import android.content.Context;
import android.content.res.Resources;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Context r2, int r3) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        if (r2 == null) goto L8;
        Resources r4 = th.a.f(r2);     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        String r5 = r4.getString(r3);     // Catch: Throwable -> L11
    L9:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L11
    L14:
        if (Result.exceptionOrNull-impl(r6) == null) goto L17;
        dm.a.a("ECLiveResourceUtils").i("safeGetResourceText error!!!");
    L17:
        if (Result.isFailure-impl(r6) == true) goto L21;
        r0 = r6;
    L21:
        return (String) r0;
    L8:
        r5 = null;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
