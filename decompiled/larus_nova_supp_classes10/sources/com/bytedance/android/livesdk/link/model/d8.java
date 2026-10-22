package com.bytedance.android.livesdk.link.model;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d8 {
    public static final c8.c a(c8 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$extra");
        c8.c r0 = new c8.c();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r3 = new JSONObject(r2.getExtraJson());     // Catch: Throwable -> L5
        r0.a = r3.optString("change_status_anchor_name");     // Catch: Throwable -> L5
        r0.b = r3.optString("change_status_anchor_id");     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        return r0;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
