package com.bytedance.android.shopping.product.flow;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.response.anchorv3.PromotionBottomButtonStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.sdk.helper.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 4, 3})
final class ShortVideoProductFlowCard$bindAbilityBarView$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ PromotionProductStruct $promotionProductStruct;
    final /* synthetic */ ShortVideoProductFlowCard this$0;

    public ShortVideoProductFlowCard$bindAbilityBarView$2(ShortVideoProductFlowCard r1, PromotionProductStruct r2) {
        this.this$0 = r1;
        this.$promotionProductStruct = r2;
        super(1);
    }

    public final void invoke(View r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        p r4 = p.a;
        Context r0 = this.this$0.getContext();
        PromotionProductStruct r1 = this.$promotionProductStruct;
        if (r1 == null) goto L9;
        PromotionProductExtraStruct r2 = r1.getExtraInfo();
        if (r2 == null) goto L9;
        PromotionBottomButtonStruct r5 = r2.getShopEntry();
        if (r5 == null) goto L9;
        String r6 = r5.getSchema();
    L10:
        r4.openSchema(r0, r6);
        return;
    L9:
        r6 = null;
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((View) r1);
        return Unit.INSTANCE;
    }
}
