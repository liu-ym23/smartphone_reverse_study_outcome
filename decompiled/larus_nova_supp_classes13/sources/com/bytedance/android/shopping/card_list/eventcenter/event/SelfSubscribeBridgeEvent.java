package com.bytedance.android.shopping.card_list.eventcenter.event;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SelfSubscribeBridgeEvent extends com.bytedance.kmp.ec.yata.event.common.b {
    public final String a;
    public final Lazy b;
    public final CardListObjectContainer c;

    public SelfSubscribeBridgeEvent(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.c = r2;
        CardPassThroughData r3 = r2.e.a;
        if (r3 == null) goto L5;
        String r4 = r3.getMonitorId();
    L6:
        this.a = r4;
        this.b = LazyKt.lazy(new SelfSubscribeBridgeEvent$monitorManager$2(this));
        return;
    L5:
        r4 = null;
        goto L6
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
        if (this.c.e.k.containsKey(r3) == true) goto L26;
        SelfSubscribeBridgeEvent$onExecuteSync$jsSubscribeBridgeEvent$1 r6 = new SelfSubscribeBridgeEvent$onExecuteSync$jsSubscribeBridgeEvent$1(this, r3, r7, r5);
        ECLiveHybridUtil.m(r3, r6);
        this.c.e.k.put(r3, r6);
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
