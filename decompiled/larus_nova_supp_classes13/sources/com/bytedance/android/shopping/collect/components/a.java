package com.bytedance.android.shopping.collect.components;

import android.view.View;
import com.bytedance.android.shopping.card_list.components.CardListQueryFetchComponent;
import com.bytedance.android.shopping.card_list.components.CardListTrackerComponent;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ CardListCollectErrorComponent a;

    public a(CardListCollectErrorComponent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        CardListTrackerComponent r7 = (CardListTrackerComponent) this.a.f.getValue();
        if (r7 == null) goto L5;
        CardListTrackerComponent.h(r7, this.a.k.f.getStandardClickEventName(), MapsKt.mapOf(new Pair[]{TuplesKt.to("click_type", "retry"), TuplesKt.to("tab_name", "error_view")}), 4);
    L5:
        CardListQueryFetchComponent r8 = (CardListQueryFetchComponent) this.a.g.getValue();
        if (r8 == null) goto L9;
        int r1 = CardListQueryFetchComponent.x;
        r8.i(true, "reload", null);
        return;
    }
}
