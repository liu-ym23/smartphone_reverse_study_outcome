package com.larus.navigation.impl;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class p {
    public static final e37.j b(com.larus.navigation.api.x r100) {
        Object r101 = null;
        if (r100 == null) goto L23;
        String r102 = c(r100.f359715a);
        if (r102 == null) goto L24;
        String r103 = c(r100.f359716b);
        if (r103 == null) goto L25;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L13
        Object r105 = Result.m9449constructorimpl(new e37.j(r102, r103, c(r100.f359717c), c(r100.f359718d)));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r105) == true) goto L20;
        r101 = r105;
    L20:
        return (e37.j) r101;
    L13:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L25:
        return null;
    L24:
        return null;
    L23:
        return null;
    }

    public static final String c(String r100) {
        if (r100 == null) goto L13;
        String r101 = StringsKt.trim(r100).toString();
        if (r101 != null) goto L7;
        return null;
    L7:
        if (r101.length() <= 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == true) goto L12;
        return null;
    L12:
        return r101;
    L9:
        r102 = false;
        goto L10
    L13:
        return null;
    }

    public static final String a(JSONObject r100, String r101) {
        if (r100.isNull(r101) == true) goto L10;
        String r102 = r100.optString(r101);
        if (r102.length() != 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L10;
        return r102;
    L8:
        r103 = false;
    L10:
        return null;
    }
}
