package com.bytedance.android.shopping.store.shopfeed.presenter;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.store.shopfeed.list.ShopFeedListSnapHelper;
import com.bytedance.android.shopping.store.shopfeed.list.ShopMomentFlowListAdapter;
import com.bytedance.android.shopping.store.shopfeed.list.ShopMomentFlowLynxCardView;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopMomentFlowListPresenter extends QPresenter {
    public static final /* synthetic */ int m = 0;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public ShopMomentFlowLynxCardView h;
    public ShopMomentFlowLynxCardView i;
    public ShopMomentFlowLynxCardView j;
    public final ECShopMomentFlowListPresenter$onScrollListener$1 k;
    public final Fragment l;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.android.shopping.store.shopfeed.presenter.ECShopMomentFlowListPresenter$onScrollListener$1] */
    public ECShopMomentFlowListPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.l = r2;
        this.e = LazyKt.lazy(new ECShopMomentFlowListPresenter$viewModel$2(this));
        this.f = LazyKt.lazy(new ECShopMomentFlowListPresenter$snapHelper$2(this));
        this.g = LazyKt.lazy(new ECShopMomentFlowListPresenter$listAdapter$2(this));
        this.k = new ECShopMomentFlowListPresenter$onScrollListener$1(this);
    }

    public final void A(QModel r8) {
        RecyclerView r0 = com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131386237));
        if (r0 == null) goto L5;
        int r9 = k.a;
        k.a(r0, u().c(), "ECShopMomentFlowListPresenter", this.k, (ShopMomentFlowListAdapter) this.g.getValue(), (ShopFeedListSnapHelper) this.f.getValue(), null);
    L5:
        LiveData<PagedList<com.bytedance.android.shopping.store.shopfeed.list.a>> r10 = ((ECShopFeedViewModel) this.e.getValue()).getCardList();
        if (r10 == null) goto L9;
        r10.observe(ECQuickUtilKt.a(u()), new h(this));
        return;
    }
}
