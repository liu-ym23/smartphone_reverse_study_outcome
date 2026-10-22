package com.bytedance.android.shopping.store.utils;

import com.bytedance.android.ec.core.utils.z1;
import java.util.Iterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public static final String b(Map<String, ? extends Object> r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toJSONString");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(new JSONObject(r1).toString());     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r2) == false) goto L11;
        r2 = null;
    L11:
        return (String) r2;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static final Map<String, Object> c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toMap");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(z1.k(new JSONObject(r1)));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r2) == false) goto L11;
        r2 = null;
    L11:
        return (Map) r2;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static final void a(JSONObject r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "$this$safePutAll");
        if (r4 != null) goto L14;
        return;
    L14:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        Iterator<String> r1 = r4.keys();     // Catch: Throwable -> L11
    L7:
        if (r1.hasNext() == false) goto L9;
        String r2 = r1.next();     // Catch: Throwable -> L11
        r3.putOpt(r2, r4.opt(r2));     // Catch: Throwable -> L11
        goto L7
    L9:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
