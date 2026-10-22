package com.bytedance.android.shopping.orderlist.common.controller;

import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements h.b {
    public final /* synthetic */ hg3.b a;
    public final /* synthetic */ com.bytedance.kmp.ec.yata.event.common.e b;

    @Override // com.bytedance.android.shopping.orderlist.common.controller.h.b
    public final void a(List r8) {
        hg3.b r0 = this.a;
        if (r0 == null) goto L30;
        hg3.a r1 = new hg3.a("custom_event_fields_error");
        com.bytedance.kmp.ec.yata.event.common.e r2 = this.b;
        if (r2 == null) goto L28;
        r1.a.put("event_name", r2.r());
        r1.a.put("render_node_key", r2.k());
    L28:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L10
        Object r4 = Result.constructor-impl(com.bytedance.android.shopping.orderlist.common.utils.i.a().toJson(r8));     // Catch: Throwable -> L10
    L12:
        Object r5 = null;
        if (Result.isFailure-impl(r4) == false) goto L15;
        r4 = null;
    L15:
        Intrinsics.checkNotNullParameter("preload_tasks", "key");
        r1.a.put("preload_tasks", (String) r4);
        Object r9 = Result.constructor-impl(com.bytedance.android.shopping.orderlist.common.utils.i.a().toJson(r8));     // Catch: Throwable -> L18
    L21:
        if (Result.isFailure-impl(r9) == true) goto L24;
        r5 = r9;
    L24:
        Intrinsics.checkNotNullParameter("preload_biz_scene_priority", "key");
        r1.a.put("preload_biz_scene_priority", (String) r5);
        r0.a(r1);
        return;
    L18:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L10:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // com.bytedance.android.shopping.orderlist.common.controller.h.b
    public final void b(String r7) {
        hg3.b r0 = this.a;
        if (r0 == null) goto L12;
        hg3.a r1 = new hg3.a("forest_preload");
        com.bytedance.kmp.ec.yata.event.common.e r2 = this.b;
        if (r2 == null) goto L8;
        r1.a.put("event_name", r2.r());
        r1.a.put("render_node_key", r2.k());
    L8:
        if (r7 != null) goto L10;
        r7 = "";
    L10:
        Intrinsics.checkNotNullParameter("bundle_id", "key");
        r1.a.put("bundle_id", r7);
        r0.a(r1);
        return;
    }

    public g(hg3.b r1, com.bytedance.kmp.ec.yata.event.core.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
