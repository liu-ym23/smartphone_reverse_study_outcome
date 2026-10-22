package com.bytedance.android.shopping.utils;

import java.util.HashMap;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q {
    public static final HashMap<String, Object> a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$asMap");
        HashMap<String, Object> r0 = new HashMap();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl(com.bytedance.commerce.base.json.b.a(r5));     // Catch: Throwable -> L5
    L7:
        JSONObject r2 = new JSONObject();
        if (Result.isFailure-impl(r6) == false) goto L10;
        r6 = r2;
    L10:
        JSONObject r7 = (JSONObject) r6;
        Iterator<String> r3 = r7.keys();
    L12:
        if (r3.hasNext() == false) goto L19;
        String r4 = r3.next();
        Object r8 = r7.get(r4);
        if ((r8 instanceof JSONArray) == true) goto L12;
        if ((r8 instanceof JSONObject) == true) goto L12;
        r0.put(r4, r8);
        goto L12
    L19:
        return r0;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
