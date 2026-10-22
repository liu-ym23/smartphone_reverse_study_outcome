package com.bytedance.android.shopping.store.tabkit.container;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i {
    public static final void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        dm.a.a("TabKitDialogFragment").i(r1);
    }

    public static final void b(String r5, Type r6, Action r7) {
        Intrinsics.checkNotNullParameter(r6, "type");
        Intrinsics.checkNotNullParameter(r7, "action");
        com.bytedance.android.ec.sdk.helper.g r2 = com.bytedance.android.ec.sdk.helper.g.a;
        JSONObject r3 = new JSONObject();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L8
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        r3.putOpt("session_id", r5);     // Catch: Throwable -> L8
        r3.putOpt("type", r6.name());     // Catch: Throwable -> L8
        Result.constructor-impl(r3.putOpt("action", r7.name()));     // Catch: Throwable -> L8
    L10:
        Unit r8 = Unit.INSTANCE;
        r2.logV3("ec_tabkit_lite_page_state", r3);
        return;
    L8:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
