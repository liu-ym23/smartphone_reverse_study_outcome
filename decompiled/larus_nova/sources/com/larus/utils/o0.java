package com.larus.utils;

import android.util.Base64;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes.dex */
public final class o0 {
    public static final String a(String r100) {
        if (r100 != null) goto L6;
        return "be_null";
    L6:
        if (r100.length() != 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return "be_empty";
    L12:
        return r100;
    L8:
        r101 = false;
        goto L9
    }

    public static final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(new String(Base64.decode(r100, 0), Charsets.UTF_8));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L11;
        r102 = null;
    L11:
        return (String) r102;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static final int c(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return 0;
    L9:
        return r100.codePointCount(0, r100.length());
    L5:
        r101 = false;
        goto L6
    }

    public static final boolean d(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r101 = false;
        goto L8
    }
}
