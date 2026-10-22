package com.bytedance.android.shopping.card_list.eventcenter.event;

import com.bytedance.android.shopping.card_list.components.s;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SelfRecommendReset extends com.bytedance.kmp.ec.yata.event.common.b {
    public final Lazy a;
    public final CardListObjectContainer b;

    public SelfRecommendReset(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.b = r2;
        this.a = LazyKt.lazy(new SelfRecommendReset$actions$2(this));
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r3) {
        Intrinsics.checkNotNullParameter(r3, "input");
        com.bytedance.kmp.ec.yata.store.node.c r4 = r3.j();
        if (r4 == null) goto L5;
        Map r5 = r4.s();
    L6:
        if (r5 == null) goto L8;
        Object r6 = r5.get("selected_tab_type");
    L10:
        if ((r6 instanceof String) == true) goto L12;
        r6 = null;
    L12:
        String r7 = (String) r6;
        s r1 = (s) this.a.getValue();
        if (r1 == null) goto L17;
        Function1<String, Unit> r2 = r1.c;
        if (r2 == null) goto L17;
        r2.invoke(r7);
    L17:
        int r8 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L8:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }
}
