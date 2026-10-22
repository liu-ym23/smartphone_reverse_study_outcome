package com.bytedance.android.shopping.store.hybridproduct;

import android.view.ViewGroup;
import com.bytedance.android.ec.hybrid.list.holder.ECLoadMoreViewHolder;
import com.bytedance.android.shopping.store.hybridproduct.holder.ECShopHybridProductLoadMoreViewHolder;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k extends com.bytedance.android.ec.hybrid.list.ability.l0 {
    public final /* synthetic */ ECShopHybridProductListPresenter a;

    public k(ECShopHybridProductListPresenter r1) {
        this.a = r1;
    }

    public final ECLoadMoreViewHolder a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        int r0 = ECShopHybridProductLoadMoreViewHolder.q;
        return ECShopHybridProductLoadMoreViewHolder.a.a(r2, ((QFragmentPresenter) this.a).e);
    }
}
