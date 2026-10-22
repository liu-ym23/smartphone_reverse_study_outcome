package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "new", "Landroid/graphics/Rect;", "old", "invoke"}, k = 3, mv = {1, 4, 3})
final class ProductDetailInfoComponent$watchBottomBarHeightChange$1 extends Lambda implements Function2<Rect, Rect, Unit> {
    final /* synthetic */ vg3.e $navigationAbility;
    final /* synthetic */ ProductDetailInfoComponent this$0;

    public ProductDetailInfoComponent$watchBottomBarHeightChange$1(ProductDetailInfoComponent r1, vg3.e r2) {
        this.this$0 = r1;
        this.$navigationAbility = r2;
        super(2);
    }

    public final void invoke(Rect r2, Rect r3) {
        Intrinsics.checkNotNullParameter(r2, "new");
        Intrinsics.checkNotNullParameter(r3, "old");
        ProductDetailInfoComponent r4 = this.this$0;
        vg3.e r5 = this.$navigationAbility;
        int r0 = ProductDetailInfoComponent.A;
        r4.m2(r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Rect) r1, (Rect) r2);
        return Unit.INSTANCE;
    }
}
