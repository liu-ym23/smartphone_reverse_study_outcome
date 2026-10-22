package com.bytedance.android.shopping.utils;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u {
    public static final Map<String, String> b(JSONObject r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        if (r4 == null) goto L11;
        Iterator<String> r2 = r4.keys();     // Catch: Throwable -> L14
        if (r2 == null) goto L11;
    L8:
        if (r2.hasNext() == false) goto L10;
        String r3 = r2.next();     // Catch: Throwable -> L14
        r0.put(r3, r4.optString(r3));     // Catch: Throwable -> L14
        goto L8
    L10:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L14
    L16:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L19;
        ECExceptionMonitor.e(r7);
    L19:
        return r0;
    L11:
        r5 = null;
    L14:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }

    public static final String a(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        JSONObject r0 = new JSONObject();
    L10:
        r0.put(r2, r3);
        return r0.toString();
    L4:
        if (com.bytedance.android.shopping.extensions.k.c(r1) == false) goto L6;
        r0 = new JSONObject(r1);     // Catch: Exception -> L8
    L12:
        goto L10
    L6:
        r0 = new JSONObject();     // Catch: Exception -> L8
        goto L12
    }
}
