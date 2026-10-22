package com.bytedance.android.shopping.store.product.presenter.aggregate;

import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class BaseAggregateDoubleCardViewModelAdapter extends e {
    public BaseAggregateDoubleCardViewModelAdapter(ShopAggregatePageProductViewModel r3) {
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        super(r3, "ec_shop_aggregate_product_card", AnonymousClass1.INSTANCE);
    }
}
