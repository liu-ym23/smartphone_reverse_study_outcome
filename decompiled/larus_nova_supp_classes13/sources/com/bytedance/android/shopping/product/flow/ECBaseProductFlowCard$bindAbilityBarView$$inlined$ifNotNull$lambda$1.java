package com.bytedance.android.shopping.product.flow;

import com.bytedance.android.shopping.product.flow.view.bottom.ProductFlowCardSimpleAbilityView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/bytedance/android/shopping/product/flow/ECBaseProductFlowCard$bindAbilityBarView$1$1"}, k = 3, mv = {1, 4, 3})
final class ECBaseProductFlowCard$bindAbilityBarView$$inlined$ifNotNull$lambda$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ ProductFlowCardSimpleAbilityView $productFlowCardSimpleAbilityView;
    final /* synthetic */ ECBaseProductFlowCard this$0;

    public ECBaseProductFlowCard$bindAbilityBarView$$inlined$ifNotNull$lambda$1(ProductFlowCardSimpleAbilityView r1, ECBaseProductFlowCard r2) {
        this.$productFlowCardSimpleAbilityView = r1;
        this.this$0 = r2;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Boolean.valueOf(m2700invoke());
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final boolean m2700invoke() {
        this.this$0.getInteractionHelper();
        return false;
    }
}
