package com.bytedance.android.shopping.card_list.eventcenter.event;

import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SelfHandleEventWhenAppearFunction extends com.bytedance.kmp.ec.yata.event.common.a {
    public final Lazy a;
    public final CardListObjectContainer b;

    public SelfHandleEventWhenAppearFunction(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.b = r2;
        this.a = LazyKt.lazy(new SelfHandleEventWhenAppearFunction$eventHandleComponent$2(this));
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "input");
        Intrinsics.checkNotNullParameter(r4, "chainNextCallback");
        if (((com.bytedance.android.shopping.card_list.components.h) this.a.getValue()) != null) goto L6;
        int r5 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r4.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L6:
        com.bytedance.android.shopping.card_list.components.h.g(r3);
        throw null;
    }
}
