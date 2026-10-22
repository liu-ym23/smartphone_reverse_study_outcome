package com.bytedance.android.shopping.sku.inner.function.business;

import android.os.SystemClock;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.sku.inner.container.p;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g extends com.bytedance.kmp.ec.yata.event.common.a {
    public final com.bytedance.android.shopping.sku.inner.container.b a;

    public g(com.bytedance.android.shopping.sku.inner.container.b r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r11, Function1 r12) {
        Intrinsics.checkNotNullParameter(r11, "input");
        Intrinsics.checkNotNullParameter(r12, "chainNextCallback");
        SkuCommonLog.c("SkuYataClickLoadingButtonFunction", "SkuYataClickLoadingButtonFunction");
        Map r0 = ((com.bytedance.kmp.ec.yata.chain.trigger.a) r11.e).a;
        if (r0 == null) goto L5;
        Object r2 = r0.get("tap_action_name");
    L7:
        if ((r2 instanceof String) == true) goto L9;
        r2 = null;
    L9:
        String r6 = (String) r2;
        if (r0 == null) goto L14;
        Object r1 = r0.get("button_type");
        if (r1 == null) goto L14;
        String r7 = r1.toString();
    L15:
        com.bytedance.kmp.ec.yata.store.node.c r13 = r11.j();
        if (r13 == null) goto L18;
        String r5 = r13.getKey();
    L19:
        this.a.qn().getStaticState().d = new p(this.a.bV(), r5, r6, r7, SystemClock.elapsedRealtime());
        int r14 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r12.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L18:
        r5 = null;
    L14:
        r7 = null;
        goto L15
    L5:
        r2 = null;
        goto L7
    }
}
