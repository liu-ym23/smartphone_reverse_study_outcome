package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ProductDetailInfoComponent$onDetach$1 extends MutablePropertyReference0Impl {
    public ProductDetailInfoComponent$onDetach$1(ProductDetailInfoComponent r7) {
        super(r7, ProductDetailInfoComponent.class, "mainFeedInitializer", "getMainFeedInitializer()Lcom/bytedance/android/shopping/prepurchase/business/pdp/components/layer/product/MainFeedInitializer;", 0);
    }

    public Object get() {
        d r0 = ((ProductDetailInfoComponent) ((CallableReference) this).receiver).p;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mainFeedInitializer");
    L5:
        return r0;
    }

    public void set(Object r2) {
        d r3 = (d) r2;
        ((ProductDetailInfoComponent) ((CallableReference) this).receiver).p = r3;
    }
}
