package com.bytedance.android.shopping.store.aggregate.presenter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.store.status.DefaultStoreTadLoadingStatusView;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.bytedance.android.shopping.store.aggregate.AggregatePageTypes;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateProductListFragment;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductListPresenter;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/aggregate/presenter/ShopAggregatePageProductGroupPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QFragmentPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopAggregatePageProductGroupPresenter extends QFragmentPresenter implements LifecycleObserver {
    public final Lazy f;
    public boolean g;

    public final ShopAggregatePageProductViewModel d0() {
        return (ShopAggregatePageProductViewModel) this.f.getValue();
    }

    public ShopAggregatePageProductGroupPresenter(final ShopAggregateProductListFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.f = LazyKt.lazy(new ShopAggregatePageProductGroupPresenter$viewModel$2(this, r2));
    }

    public final void b0(QModel r12) {
        Context r5 = th.a.e(Y().c(), true);
        final ViewGroup r3 = (ViewGroup) Z().b(2131391851).f();
        List r13 = null;
        LazyStatusView r4 = new LazyStatusView(r5, null);
        r3.addView(r4);
        int r7 = 0;
        r4.setCreators(MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.store.status.b.a.a, new com.bytedance.android.ec.store.status.c(new ShopAggregatePageProductGroupPresenter$initOptStatusView$1(this, r3), null, 6)), TuplesKt.to(com.bytedance.android.ec.store.status.b.b.a, new com.bytedance.android.ec.store.status.c(new ShopAggregatePageProductGroupPresenter$initOptStatusView$2(this, r3), null, 6))}));
        r4.a(new DefaultStoreTadLoadingStatusView(r5).a());
        Ref.ObjectRef r6 = new Ref.ObjectRef();
        r6.element = Z().b(2131391853).f();
        d0().getLoadStatus().b(ECQuickUtilKt.a(Y()), new i(this, r3, r4, r5, r6));
        String r1 = d0().getStoreParam().getTagData();
        if (r1 != null) goto L23;
    L8:
        if (r13 == null) goto L16;
        if (Intrinsics.areEqual(d0().getStoreParam().getPageType(), AggregatePageTypes.FULL_DISCOUNT.getType()) == false) goto L16;
        if (r13.size() <= 1) goto L16;
        wg.a.f(Z().b(2131387426).f(), 0, 0, 0, 0);
    L16:
        if (Intrinsics.areEqual(d0().getStoreParam().getPageType(), AggregatePageTypes.CLASSIFICATION.getType()) == true) goto L18;
        return;
    L18:
        if (d0().getStoreParam().getShowCategoryTab() == true) goto L21;
        r7 = 16;
    L21:
        RelativeLayout r14 = (RelativeLayout) Z().b(2131384670).f();
        int r0 = ECShopHybridProductListPresenter.O;
        GradientDrawable r2 = ECShopHybridProductListPresenter.a.a(r7);
        Intrinsics.checkNotNullParameter(r14, "$this$setBackgroundCompat");
        r14.setBackground(r2);
        return;
    L23:
        r13 = (List) new Gson().fromJson(r1, new h().getType());     // Catch: Exception -> L7
        goto L8
    }
}
