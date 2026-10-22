package com.bytedance.android.shopping.card_list.eventcenter.event;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n extends com.bytedance.kmp.ec.yata.event.common.b {
    public final CardListObjectContainer a;

    public n(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r7) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Map r8 = r7.q();
        if (r8 == null) goto L5;
        Object r9 = r8.get("bridge_event_name");
    L7:
        if ((r9 instanceof String) == true) goto L9;
        r9 = null;
    L9:
        String r10 = (String) r9;
        if (r10 != null) goto L12;
    L15:
        boolean r2 = true;
    L16:
        if (r2 == false) goto L19;
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "Empty bridge_event_name", null, null, 57);
    L19:
        ti.j r3 = this.a.e.k.get(r10);
        if (r3 == null) goto L22;
        ECLiveHybridUtil.p(r10, r3);
        ti.j r12 = this.a.e.k.remove(r10);
    L22:
        int r13 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L12:
        if (r10.length() == 0) goto L15;
        r2 = false;
        goto L16
    L5:
        r9 = null;
        goto L7
    }
}
