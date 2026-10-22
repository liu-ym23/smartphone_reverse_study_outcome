package com.bytedance.android.shopping.store.hybridproduct.holder;

import android.view.View;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.hybridproduct.module.h;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopMiddleCouponFilterHolder;", "Lcom/bytedance/android/shopping/store/hybridproduct/holder/ECShopBaseHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopMiddleCouponFilterHolder extends ECShopBaseHolder {
    public static final a r = null;
    public final QUIManager q;

    public static final class a {
        public a() {
        }
    }

    static {
        r = new a();
    }

    public final void o() {
        this.q.r(h.class);
        super.o();
    }

    public final void onRelease() {
        this.q.r(h.class);
        super.onRelease();
    }

    @Override // com.bytedance.android.shopping.store.hybridproduct.holder.ECShopBaseHolder
    public final void q4(Object r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "itemId");
        if ((r2 instanceof com.bytedance.android.ec.store.repository.vo.h) == true) goto L5;
        r2 = null;
    L5:
        com.bytedance.android.ec.store.repository.vo.h r4 = (com.bytedance.android.ec.store.repository.vo.h) r2;
        if (r4 != null) goto L8;
        return;
    L8:
        this.q.c(h.class, r4);
    }

    public ECShopMiddleCouponFilterHolder(QUIManager r2, View r3, ECShopHybridProductViewModel r4, ECStoreViewModel r5) {
        Intrinsics.checkNotNullParameter(r2, "uiManager");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        Intrinsics.checkNotNullParameter(r5, "storeViewModel");
        super(r3, r5);
        this.q = r2;
    }
}
