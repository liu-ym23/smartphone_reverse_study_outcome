package com.bytedance.android.shopping.store.hybridproduct.holder;

import android.view.View;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/holder/BaseViewHolderWithPriceUpdateAnimation;", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopBaseHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseViewHolderWithPriceUpdateAnimation extends ECShopBaseHolder {
    public final View q;

    public BaseViewHolderWithPriceUpdateAnimation(View r2, ECStoreViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "childItemView");
        Intrinsics.checkNotNullParameter(r3, "storeViewModel");
        super(r2, r3);
        this.q = r2;
    }
}
