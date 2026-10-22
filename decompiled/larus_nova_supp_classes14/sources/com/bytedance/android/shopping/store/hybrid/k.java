package com.bytedance.android.shopping.store.hybrid;

import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    public k() {
    }

    public static JSONObject a() {
        return b(0, "key 不能为空", null);
    }

    static {
    }

    public static JSONObject b(int r2, String r3, Map r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L9
        r1.put("code", r2);     // Catch: Throwable -> L9
        if (r3 == null) goto L5;
        r1.put("msg", r3);     // Catch: Throwable -> L9
    L5:
        if (r4 == null) goto L7;
        r1.put("data", new JSONObject(r4));     // Catch: Throwable -> L9
    L7:
        Object r5 = Result.constructor-impl(r1);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r5) == false) goto L15;
        r5 = null;
    L15:
        return (JSONObject) r5;
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
