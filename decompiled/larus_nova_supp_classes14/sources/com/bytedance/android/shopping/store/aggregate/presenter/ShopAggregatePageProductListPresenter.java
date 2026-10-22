package com.bytedance.android.shopping.store.aggregate.presenter;

import android.animation.Animator;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.RecyclerViewPerformanceMonitor;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.widget.NoneSymmetryDecoration;
import com.bytedance.android.ec.store.adapter.ShopRecyclerViewWithHeaderAndFooterAdapter;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.shopping.store.aggregate.AggregatePageTypes;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateProductListFragment;
import com.bytedance.android.shopping.store.aggregate.adapter.ShopAggregatePageProductListAdapter;
import com.bytedance.android.shopping.store.aggregate.adapter.WrapContentStaggeredGridLayoutManager;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopAggregatePageProductListPresenter extends QFragmentPresenter {
    public ShopAggregatePageProductViewModel f;
    public ShopAggregatePageViewModel g;
    public ShopAggregatePageProductListAdapter h;
    public View i;
    public Animator j;

    public static final class a<T> implements Observer {
        public final /* synthetic */ ShopAggregatePageProductListPresenter a;

        public a(ShopAggregatePageProductListPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            rg.a r3 = (rg.a) r2;
            ShopAggregatePageProductListAdapter r4 = this.a.h;
            if (r4 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        L5:
            r4.submitList(null);
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ShopAggregatePageProductListPresenter a;

        public b(ShopAggregatePageProductListPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            PagedList r4 = (PagedList) r3;
            ShopAggregatePageProductListAdapter r0 = this.a.h;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        L5:
            r0.submitList(r4);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ ShopAggregatePageProductListPresenter a;

        public c(ShopAggregatePageProductListPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            LayoutTypes r5 = (LayoutTypes) r4;
            dm.a.a("ShopAggregatePageProductListPresenter").a("viewModel.layoutType: " + r5.name());
            ShopAggregatePageViewModel r0 = this.a.g;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("activityViewModel");
        L5:
            r0.setLayoutType(r5);
            ShopAggregatePageProductListPresenter r6 = this.a;
            WrapContentStaggeredGridLayoutManager r1 = r6.Z().b(2131391853).f().getLayoutManager();
            if (r1 == null) goto L12;
            int[] r2 = r1.findFirstVisibleItemPositions(null);
            if (r2 == null) goto L13;
            r6.d0(r2[0]);
            return;
        L13:
            return;
        L12:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.aggregate.adapter.WrapContentStaggeredGridLayoutManager");
        }
    }

    public ShopAggregatePageProductListPresenter(ShopAggregateProductListFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }

    public final void b0(QModel r5) {
        QContext r6 = Y();
        Fragment r1 = ((QFragmentPresenter) this).e;
        r6.getClass();
        this.f = QContext.h(ShopAggregatePageProductViewModel.class, r1);
        QContext r7 = Y();
        Fragment r2 = ((QFragmentPresenter) this).e.requireParentFragment();
        r7.getClass();
        this.g = QContext.h(ShopAggregatePageViewModel.class, r2);
        ShopAggregatePageProductViewModel r8 = this.f;
        if (r8 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L6:
        if (r8.getStoreParam().getShowAddCart() == false) goto L15;
        this.i = Z().b(2131371058).f();
        ShopAggregatePageProductViewModel r9 = this.f;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        r9.setDestView(new WeakReference(this.i));
        ShopAggregatePageProductViewModel r10 = this.f;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        r10.getCartsInfo().a(ECQuickUtilKt.a(Y()), new k(this), false);
    L15:
        d0(0);
        ShopAggregatePageProductViewModel r11 = this.f;
        if (r11 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L18:
        r11.getLayoutType().a(ECQuickUtilKt.a(Y()), new c(this), false);
    }

    public final void d0(int r14) {
        Fragment r0 = ((QFragmentPresenter) this).e;
        final RecyclerView r1 = Z().b(2131391853).f();
        r1.setHasFixedSize(true);
        r1.setLayoutManager(new WrapContentStaggeredGridLayoutManager());
        RecyclerView.ItemAnimator r3 = r1.getItemAnimator();
        if (r3 == null) goto L5;
        r3.setAddDuration(0);
    L5:
        RecyclerView.ItemAnimator r4 = r1.getItemAnimator();
        if (r4 == null) goto L8;
        r4.setChangeDuration(0);
    L8:
        RecyclerView.ItemAnimator r5 = r1.getItemAnimator();
        if (r5 == null) goto L11;
        r5.setMoveDuration(0);
    L11:
        RecyclerView.ItemAnimator r6 = r1.getItemAnimator();
        if (r6 == null) goto L14;
        r6.setRemoveDuration(0);
    L14:
        RecyclerView.ItemAnimator r7 = r1.getItemAnimator();
        if ((r7 instanceof SimpleItemAnimator) == true) goto L17;
        r7 = null;
    L17:
        SimpleItemAnimator r8 = (SimpleItemAnimator) r7;
        if (r8 == null) goto L20;
        r8.setSupportsChangeAnimations(false);
    L20:
        ShopAggregatePageProductViewModel r9 = this.f;
        if (r9 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L23:
        ShopAggregatePageProductListAdapter r10 = new ShopAggregatePageProductListAdapter(r0, r9, r1);
        if (true == ((ShopRecyclerViewWithHeaderAndFooterAdapter) r10).a) goto L26;
        ((ShopRecyclerViewWithHeaderAndFooterAdapter) r10).a = true;
    L26:
        r10.registerAdapterDataObserver(new ShopAggregatePageProductListPresenter$initRecyclerView$$inlined$let$lambda$1(r1, this));
        Unit r2 = Unit.INSTANCE;
        this.h = r10;
        r1.setAdapter(r10);
        ShopAggregatePageProductViewModel r11 = this.f;
        if (r11 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L30:
        if (Intrinsics.areEqual(r11.getStoreParam().getPageType(), AggregatePageTypes.CLASSIFICATION.getType()) == false) goto L35;
        int r12 = com.bytedance.android.ec.store.widget.d.a;
        ShopAggregatePageProductViewModel r13 = this.f;
        if (r13 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L34:
        com.bytedance.android.ec.store.widget.d.b(r1, r14, (LayoutTypes) r13.getLayoutType().getValue());
    L36:
        r1.addOnScrollListener(new RecyclerViewPerformanceMonitor(MonitorScenes.EC_AGGREGATE_PRODUCTS_FPS));
        r1.addOnScrollListener(new ShopAggregatePageProductListPresenter$initRecyclerView$$inlined$let$lambda$2(this));
        ShopAggregatePageProductViewModel r15 = this.f;
        if (r15 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L39:
        r15.getRefreshAction().a(ECQuickUtilKt.a(Y()), new a(this), false);
        ShopAggregatePageProductViewModel r16 = this.f;
        if (r16 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L42:
        r16.getProducts().observe(ECQuickUtilKt.a(Y()), new b(this));
        return;
    L35:
        int r17 = com.bytedance.android.ec.store.widget.d.a;
        com.bytedance.android.ec.store.widget.d.a(r1);
        r1.addItemDecoration(new NoneSymmetryDecoration(r1.getContext(), 4.5f, 4.5f, 9.0f, ShopAggregatePageProductListPresenter$initRecyclerView$1$1$2.INSTANCE));
        r1.setPadding(com.bytedance.android.shopping.extensions.b.b(Double.valueOf(7.5d)), 0, com.bytedance.android.shopping.extensions.b.b(Double.valueOf(7.5d)), 0);
        goto L36
    }
}
