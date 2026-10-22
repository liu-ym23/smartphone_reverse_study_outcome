package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class z {
    static {
    }

    public static void a(String r6, SsResponse r7) {
        Intrinsics.checkNotNullParameter(r6, "url");
        Intrinsics.checkNotNullParameter(r7, "ssResponse");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L18
        List r8 = r7.headers();     // Catch: Throwable -> L18
        String r1 = null;
        if (r8 == null) goto L16;
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L18
        Iterator r9 = r8.iterator();     // Catch: Throwable -> L18
    L7:
        if (r9.hasNext() == false) goto L11;
        Object r3 = r9.next();     // Catch: Throwable -> L18
        if (StringsKt.equals("x-tt-logid", ((Header) r3).getName(), true) == false) goto L7;
        r2.add(r3);     // Catch: Throwable -> L18
        goto L7
    L11:
        Header r10 = (Header) CollectionsKt.firstOrNull(r2);     // Catch: Throwable -> L18
        if (r10 == null) goto L16;
        String r11 = r10.getValue();     // Catch: Throwable -> L18
        if (r11 == null) goto L16;
        xh.a r4 = xh.c.a("Live");     // Catch: Throwable -> L18
        Map r12 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("path", r6), TuplesKt.to("log_id", r11)});     // Catch: Throwable -> L18
        xh.b r5 = new xh.b();     // Catch: Throwable -> L18
        r5.c(null);     // Catch: Throwable -> L18
        r5.b("api_request_response");     // Catch: Throwable -> L18
        r5.a(r12);     // Catch: Throwable -> L18
        r4.f(4, r5);     // Catch: Throwable -> L18
        r1 = r11;
    L16:
        Result.constructor-impl(r1);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static void b(String r1, List r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "url");
        Intrinsics.checkNotNullParameter(r2, "paramList");
        Intrinsics.checkNotNullParameter(r3, "method");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        xh.a r5 = xh.c.a("Live");     // Catch: Throwable -> L5
        xh.b.a r0 = new xh.b.a();     // Catch: Throwable -> L5
        r0.b(r1);     // Catch: Throwable -> L5
        r0.a(r3);     // Catch: Throwable -> L5
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L5
        r5.a(null, r0);     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
