package com.bytedance.android.shopping.new_cart.eventcenter.event;

import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.kmp.ec.yata.event.common.a {
    public final CartViewModel a;

    public c(CartViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "cartViewModel");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r4, final Function1 r5) {
        Intrinsics.checkNotNullParameter(r4, "input");
        Intrinsics.checkNotNullParameter(r5, "chainNextCallback");
        Map r0 = r4.q();
        Object r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.get("query_scene");
    L7:
        if ((r2 instanceof String) == true) goto L9;
        r2 = null;
    L9:
        String r3 = (String) r2;
        if (r3 != null) goto L12;
        r3 = "reload";
    L12:
        Map r6 = ((com.bytedance.kmp.ec.yata.chain.trigger.a) r4.e).a;
        if (r6 == null) goto L15;
        r1 = r6.get("event_name");
    L15:
        final Map r7 = MapsKt.mapOf(TuplesKt.to("event_name", r1));
        this.a.doQuery(false, r3, new CartRefresh$onExecuteAsync$1(r5, r7));
        return;
    L5:
        r2 = null;
        goto L7
    }
}
