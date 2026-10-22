package com.bytedance.android.shopping.store.hybridproduct.holder;

import android.view.View;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopEndHolder;", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopBaseHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopEndHolder extends ECShopBaseHolder {
    public static final a q = null;

    public static final class a {
        public a() {
        }
    }

    @Override // com.bytedance.android.shopping.store.hybridproduct.holder.ECShopBaseHolder
    public final void q4(Object r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
    }

    static {
        q = new a();
    }

    public ECShopEndHolder(View r2, ECStoreViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "storeViewModel");
        super(r2, r3);
    }
}
