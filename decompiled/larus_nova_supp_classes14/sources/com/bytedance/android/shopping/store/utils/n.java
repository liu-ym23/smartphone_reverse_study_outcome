package com.bytedance.android.shopping.store.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n {
    public static final String a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$dropRenderCacheParams");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L14
        Uri r1 = UriProtector.parse(r5);     // Catch: Throwable -> L14
        Uri.Builder r2 = r1.buildUpon().clearQuery();     // Catch: Throwable -> L14
        Set r3 = UriProtector.getQueryParameterNames(r1);     // Catch: Throwable -> L14
        if (r3 == null) goto L12;
        Iterator r4 = r3.iterator();     // Catch: Throwable -> L14
    L7:
        if (r4.hasNext() == false) goto L12;
        String r6 = (String) r4.next();     // Catch: Throwable -> L14
        if (Intrinsics.areEqual(r6, "inject_config_channel") == true) goto L7;
        r2.appendQueryParameter(r6, UriProtector.getQueryParameter(r1, r6));     // Catch: Throwable -> L14
    L12:
        return r2.build().toString();
    L14:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return r5;
    }

    public static final String b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$getWithoutQuery");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r1 = Result.constructor-impl(UriProtector.parse(r3).buildUpon().clearQuery().build().toString());     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r1) == false) goto L10;
        r1 = null;
    L10:
        String r2 = (String) r1;
        if (r2 == null) goto L13;
        return r2;
    L13:
        return StringsKt.substringBefore$default(r3, '?', null, 2, null);
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static final Uri c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$safeParse");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(UriProtector.parse(r1));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r2) == false) goto L11;
        r2 = null;
    L11:
        return (Uri) r2;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
