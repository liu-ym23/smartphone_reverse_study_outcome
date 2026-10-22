package com.larus.im.internal.utils;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes4.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f350548a = null;

    static {
        f350548a = LazyKt.lazy(new k0());
    }

    public static final Pair<String, String> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L21
        MatchResult r102 = ((Regex) f350548a.getValue()).matchEntire(r100);     // Catch: Throwable -> L21
        if (r102 == null) goto L20;
        boolean r103 = true;
        String r104 = (String) ListProtector.get(r102.getGroupValues(), 1);     // Catch: Throwable -> L21
        String r105 = (String) ListProtector.get(r102.getGroupValues(), 2);     // Catch: Throwable -> L21
        String r106 = (String) ListProtector.get(r102.getGroupValues(), 3);     // Catch: Throwable -> L21
        String r107 = (String) ListProtector.get(r102.getGroupValues(), 4);     // Catch: Throwable -> L21
        StringBuilder r108 = new StringBuilder(r104 + "://" + r105);     // Catch: Throwable -> L21
        if (r106.length() <= 0) goto L8;
        boolean r109 = true;
    L9:
        if (r109 == false) goto L12;
        r108.append(":" + r106);     // Catch: Throwable -> L21
    L12:
        if (r107.length() == 0) goto L15;
        r103 = false;
    L15:
        if (r103 == false) goto L18;
        r107 = HTTP.URL_DEFAULT;
    L18:
        return TuplesKt.to(r108.toString(), r107);
    L8:
        r109 = false;
        goto L9
    L20:
        return TuplesKt.to("", r100);
    L21:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Object r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L25;
        com.larus.im.internal.delegate.a.f348188b.e("ParseStringToUrl", "split url and path failed", r112);
    L25:
        Pair r113 = TuplesKt.to("", r100);
        if (Result.m9455isFailureimpl(r111) == false) goto L29;
        r111 = r113;
    L29:
        return (Pair) r111;
    }
}
