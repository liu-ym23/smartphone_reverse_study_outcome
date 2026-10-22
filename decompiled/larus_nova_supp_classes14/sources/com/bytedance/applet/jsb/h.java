package com.bytedance.applet.jsb;

import com.google.gson.Gson;
import com.larus.platform.api.l1;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public static final h a = null;
    public static int b;
    public static final Gson c = null;

    public h() {
    }

    static {
        a = new h();
        b = 2;
        c = new Gson();
    }

    public final String toString() {
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L26
        Pair[] r3 = new Pair[4];     // Catch: Throwable -> L26
        r3[0] = TuplesKt.to("inSubscribeEvent", Boolean.FALSE);     // Catch: Throwable -> L26
        a.getClass();     // Catch: Throwable -> L26
        l1 r5 = com.larus.platform.service.b.a();     // Catch: Throwable -> L26
        if (r5 != null) goto L6;
    L8:
        boolean r6 = false;
    L10:
        if (r6 == false) goto L12;
        int r7 = b;     // Catch: Throwable -> L26
    L13:
        r3[1] = TuplesKt.to("statusCode", Integer.valueOf(r7));     // Catch: Throwable -> L26
        r3[2] = TuplesKt.to("resultCode", 0);     // Catch: Throwable -> L26
        Object r4 = Result.constructor-impl(c.toJson(null).toString());     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r4) == false) goto L21;
        r4 = null;
    L21:
        String r8 = (String) r4;     // Catch: Throwable -> L26
        if (r8 != null) goto L24;
        r8 = "";
    L24:
        r3[3] = TuplesKt.to("navInfo", r8);     // Catch: Throwable -> L26
        Object r9 = Result.constructor-impl(c.toJson(MapsKt.mapOf(r3)).toString());     // Catch: Throwable -> L26
    L29:
        if (Result.isFailure-impl(r9) == true) goto L32;
        r1 = r9;
    L32:
        String r10 = (String) r1;
        if (r10 != null) goto L36;
        return "";
    L36:
        return r10;
    L16:
        th = move-exception;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L26
        r4 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L26
        goto L19
    L12:
        b = 2;     // Catch: Throwable -> L26
        r7 = 2;
        goto L13
    L6:
        if (r5.a() != true) goto L8;
        r6 = true;
    L26:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }
}
