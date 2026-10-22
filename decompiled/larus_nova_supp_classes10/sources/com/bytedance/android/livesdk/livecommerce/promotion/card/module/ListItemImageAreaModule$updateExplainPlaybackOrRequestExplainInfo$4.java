package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import android.view.View;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.promotion.card.i;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.PromotionListEventActionImpl;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final class ListItemImageAreaModule$updateExplainPlaybackOrRequestExplainInfo$4 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ ECUIPromotion $promotion;
    final /* synthetic */ i $promotionCardItem;
    final /* synthetic */ ListItemImageAreaModule this$0;

    public ListItemImageAreaModule$updateExplainPlaybackOrRequestExplainInfo$4(ListItemImageAreaModule r1, i r2, ECUIPromotion r3) {
        this.this$0 = r1;
        this.$promotionCardItem = r2;
        this.$promotion = r3;
        super(1);
    }

    public final void invoke(View r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        ListItemImageAreaModule r5 = this.this$0;
        LivePromotionCardArgs r0 = r5.a;
        if (r0 == null) goto L7;
        jf.d r1 = r0.g;
        if (r1 == null) goto L7;
        r1.f(r5.getContext(), this.$promotionCardItem.a.b, new ListItemImageAreaModule$updateExplainPlaybackOrRequestExplainInfo$4$$special$$inlined$also$lambda$1(this));
    L7:
        LivePromotionCardArgs r6 = this.this$0.a;
        if (r6 == null) goto L12;
        PromotionListEventActionImpl r7 = r6.h;
        if (r7 == null) goto L12;
        g r2 = this.$promotionCardItem.a.b;
        Intrinsics.checkNotNullParameter(r2, "promotionParams");
        oh.a.c("ECAskExplainEntranceEvent", new h(r7, r2));
    L12:
        ListItemImageAreaModule.a(this.this$0, true);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }
}
