package com.bytedance.android.shopping.card_list.eventcenter.event;

import com.bytedance.android.shopping.card_list.components.CardListQueryFetchComponent;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListRefresh extends com.bytedance.kmp.ec.yata.event.common.a {
    public final Lazy a;
    public final CardListObjectContainer b;

    public CardListRefresh(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.b = r2;
        this.a = LazyKt.lazy(new CardListRefresh$queryFetchComponent$2(this));
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r4, final Function1 r5) {
        Intrinsics.checkNotNullParameter(r4, "input");
        Intrinsics.checkNotNullParameter(r5, "chainNextCallback");
        Map r0 = r4.q();
        Object r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.get("query_scene");
    L7:
        if ((r2 instanceof String) == false) goto L10;
        r1 = r2;
    L10:
        String r3 = "search";
        if (Intrinsics.areEqual((String) r1, "search") == true) goto L14;
        r3 = "reload";
    L14:
        final Map r6 = MapsKt.mapOf(TuplesKt.to("event_name", ((com.bytedance.kmp.ec.yata.chain.trigger.a) r4.e).a.get("event_name")));
        CardListQueryFetchComponent r7 = (CardListQueryFetchComponent) this.a.getValue();
        if (r7 == null) goto L18;
        r7.i(false, r3, new CardListRefresh$onExecuteAsync$1(r5, r6));
        return;
    L18:
        return;
    L5:
        r2 = null;
        goto L7
    }
}
