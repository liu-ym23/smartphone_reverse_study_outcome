package com.bytedance.android.shopping.card_list.eventcenter.event;

import android.view.View;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k extends com.bytedance.kmp.ec.yata.event.common.b {
    public final CardListObjectContainer a;

    public k(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r6) {
        Intrinsics.checkNotNullParameter(r6, "input");
        View r0 = this.a.d(2131365197);
        Map r7 = r6.q();
        if (r7 == null) goto L5;
        Object r8 = r7.get("state");
    L7:
        if (Intrinsics.areEqual(r8, "open") == false) goto L10;
        if (r0 == null) goto L12;
        r0.setVisibility(0);
    L12:
        int r1 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, MapsKt.mapOf(TuplesKt.to("state", r8)), null, 5);
    L10:
        if (r0 == null) goto L12;
        r0.setVisibility(8);
        goto L12
    L5:
        r8 = null;
        goto L7
    }
}
