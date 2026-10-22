package com.bytedance.android.livesdk.livecommerce.promotion.card.presenter;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements View.OnLongClickListener {
    public final /* synthetic */ ListItemGroupPresenter a;

    public f(ListItemGroupPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r5) {
        ListItemGroupPresenter r6 = this.a;
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r0 = r6.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L5:
        ECUIPromotion r1 = r0.a.a;
        jf.d r2 = r6.j.g;
        Context r3 = r6.u().c();
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r7 = r6.f;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L8:
        r2.b(r3, r7.a.b);
        xh.c.a("Live").g(MapsKt.mapOf(new Pair[]{TuplesKt.to("promotion_id", r1.getPromotionId()), TuplesKt.to("product_id", r1.getProductId())}));
        return true;
    }
}
