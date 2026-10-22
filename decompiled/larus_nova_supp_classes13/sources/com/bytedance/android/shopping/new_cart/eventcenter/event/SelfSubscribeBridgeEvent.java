package com.bytedance.android.shopping.new_cart.eventcenter.event;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SelfSubscribeBridgeEvent extends com.bytedance.kmp.ec.yata.event.common.b {
    public final Lazy a;
    public final CartObjectContainer b;

    public SelfSubscribeBridgeEvent(CartObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.b = r2;
        this.a = LazyKt.lazy(new SelfSubscribeBridgeEvent$cartVM$2(this));
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r7) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Map r0 = r7.q();
        if (r0 == null) goto L5;
        Object r2 = r0.get("bridge_event_name");
    L7:
        if ((r2 instanceof String) == true) goto L9;
        r2 = null;
    L9:
        String r3 = (String) r2;
        if (r3 != null) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == false) goto L19;
        int r8 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "Empty bridge_event_name", null, null, 57);
    L19:
        Object r1 = r0.get("yata_event_name");
        if ((r1 instanceof String) == true) goto L22;
        r1 = null;
    L22:
        String r5 = (String) r1;
        if (this.b.e.o.containsKey(r3) == true) goto L26;
        r r6 = new r(this, r3, r7, r5);
        ECLiveHybridUtil.m(r3, r6);
        this.b.e.o.put(r3, r6);
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L26:
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "bridge_event_name already subscribed", null, null, 57);
    L12:
        if (r3.length() == 0) goto L15;
        r4 = false;
        goto L16
    L5:
        r2 = null;
        goto L7
    }
}
