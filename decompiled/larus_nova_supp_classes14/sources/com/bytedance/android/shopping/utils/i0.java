package com.bytedance.android.shopping.utils;

import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.google.gson.internal.LinkedTreeMap;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(AnchorV4VM r2) {
        Object r0 = null;
        if (r2 != null) goto L22;
        return null;
    L22:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        LinkedTreeMap r3 = r2.trackMeta();     // Catch: Throwable -> L14
        if (r3 == null) goto L8;
        Object r4 = r3.get("product_type");     // Catch: Throwable -> L14
    L10:
        if ((r4 instanceof String) == true) goto L12;
        r4 = null;
    L12:
        Object r5 = Result.constructor-impl((String) r4);     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r5) == true) goto L21;
        r0 = r5;
    L21:
        return (String) r0;
    L8:
        r4 = null;
    L14:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public static String b(LinkedTreeMap r2) {
        Object r0 = null;
        if (r2 != null) goto L18;
        return null;
    L18:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        Object r3 = r2.get("product_type");     // Catch: Throwable -> L10
        if ((r3 instanceof String) == true) goto L8;
        r3 = null;
    L8:
        Object r4 = Result.constructor-impl((String) r3);     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r4) == true) goto L17;
        r0 = r4;
    L17:
        return (String) r0;
    L10:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }
}
