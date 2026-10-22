package com.larus.audio.call.util;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ouc.d0;

/* JADX INFO: loaded from: classes24.dex */
public final class m {
    public static boolean a(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter("flushed", "key");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L13
        ouc.i r102 = (ouc.i) r100.get("flushed");     // Catch: Throwable -> L13
        if (r102 == null) goto L10;
        String r103 = ouc.k.o(r102).a();     // Catch: Throwable -> L13
        if (r103 == null) goto L10;
        Boolean r104 = StringsKt.toBooleanStrictOrNull(r103);     // Catch: Throwable -> L13
        if (r104 == null) goto L10;
        boolean r105 = r104.booleanValue();     // Catch: Throwable -> L13
    L11:
        Object r106 = Result.m9449constructorimpl(Boolean.valueOf(r105));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r106) == false) goto L18;
        r106 = null;
    L18:
        Boolean r107 = (Boolean) r106;
        if (r107 != null) goto L21;
        return false;
    L21:
        return r107.booleanValue();
    L10:
        r105 = false;
    L13:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public static String b(d0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter("", "default");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        ouc.i r103 = (ouc.i) r100.get(r101);     // Catch: Throwable -> L10
        if (r103 == null) goto L7;
        String r104 = ouc.k.o(r103).a();     // Catch: Throwable -> L10
        if (r104 == null) goto L7;
    L8:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L10
    L13:
        if (Result.m9455isFailureimpl(r105) == false) goto L15;
        r105 = null;
    L15:
        String r106 = (String) r105;
        if (r106 != null) goto L19;
        return "";
    L19:
        return r106;
    L7:
        r104 = "";
    L10:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }
}
