package com.larus.utils;

import android.util.Base64;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class o0 {
    public static final String a(String r1) {
        if (r1 != null) goto L6;
        return "be_null";
    L6:
        if (r1.length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        return "be_empty";
    L12:
        return r1;
    L8:
        r0 = false;
        goto L9
    }

    public static final String b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.m49constructorimpl(new String(Base64.decode(r2, 0), Charsets.UTF_8));     // Catch: Throwable -> L5
    L8:
        if (Result.m55isFailureimpl(r3) == false) goto L11;
        r3 = null;
    L11:
        return (String) r3;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static final int c(String r2) {
        if (r2.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        return r2.codePointCount(0, r2.length());
    L5:
        r0 = false;
        goto L6
    }

    public static final boolean d(String r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.length() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r3 = false;
        goto L8
    }
}
