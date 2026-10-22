package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import vg3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class e implements d {
    public e() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.d
    public final void a(Map<String, ? extends Object> r6, Function1<? super com.bytedance.kmp.ec.yata.chain.event.b, Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "completion");
        com.bytedance.android.shopping.prepurchase.business.pdp.services.sku.b r1 = (com.bytedance.android.shopping.prepurchase.business.pdp.services.sku.b) this;
        Intrinsics.checkNotNullParameter(r6, "params");
        Object r8 = r6.get("refresh_req_params");     // Catch: Throwable -> L12
        if ((r8 instanceof Map) == true) goto L6;
        r8 = null;
    L6:
        Map<String, ? extends Object> r9 = (Map) r8;     // Catch: Throwable -> L12
        if (r9 == null) goto L14;
        x r2 = (x) r1.a.N1(x.class);     // Catch: Throwable -> L12
        if (r2 == null) goto L14;
        r2.c1(r9);     // Catch: Throwable -> L12
    L14:
        x r10 = r1.a.c2();
        if (r10 == null) goto L17;
        x.a.a(r10, false, "jsb_trigger_refresh", MapsKt.mapOf(TuplesKt.to("jsb_name", "updateGoodsDetail")), 24);
    L17:
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r7.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L12:
        th = move-exception;
        ECExceptionMonitor.e(th);
        goto L14
    }
}
