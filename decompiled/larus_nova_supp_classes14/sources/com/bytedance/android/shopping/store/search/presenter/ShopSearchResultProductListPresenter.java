package com.bytedance.android.shopping.store.search.presenter;

import androidx.fragment.app.Fragment;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.RecyclerViewPerformanceMonitor;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.store.adapter.ShopRecyclerViewWithHeaderAndFooterAdapter;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.search.recyclerview.WrapContentStaggeredGridLayoutManager;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.search.recyclerview.ShopSearchResultAdapter;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchFragmentProductViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopSearchResultProductListPresenter extends QFragmentPresenter {
    public ShopSearchFragmentProductViewModel f;
    public ShopSearchResultAdapter g;
    public boolean h;

    public static final class a<T> implements Observer {
        public final /* synthetic */ ShopSearchResultProductListPresenter a;

        public a(ShopSearchResultProductListPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            rg.a r3 = (rg.a) r2;
            ShopSearchResultAdapter r4 = this.a.g;
            if (r4 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        L5:
            r4.submitList(null);
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ShopSearchResultProductListPresenter a;

        public b(ShopSearchResultProductListPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            PagedList r4 = (PagedList) r3;
            ShopSearchResultAdapter r0 = this.a.g;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        L5:
            r0.submitList(r4);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ RecyclerView a;
        public final /* synthetic */ ShopSearchResultProductListPresenter b;

        public c(RecyclerView r1, ShopSearchResultProductListPresenter r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r6) {
            LoadStatus r7 = (LoadStatus) r6;
            LoadStatus r0 = LoadStatus.InitializeSuccess;
            if (r7 != r0) goto L5;
            this.a.postDelayed(new q(this), 1000);
        L5:
            if (r7 != r0) goto L7;
        L8:
            ShopSearchResultProductListPresenter r8 = this.b;
            if (r8.h == true) goto L16;
            int r1 = com.bytedance.android.ec.store.utils.h.a;
            ShopSearchFragmentProductViewModel r9 = r8.f;
            if (r9 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L13:
            com.bytedance.android.ec.store.utils.h.d(z1.g(r9.getSearchParam().getEntranceInfo()), "othershow", "shop", ShopSearchResultProductListPresenter.e0(this.b).getAdParams(), "search_ad");
            this.b.h = true;
            return;
        L16:
            return;
        L7:
            if (r7 == LoadStatus.InitializeEmpty) goto L8;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ShopSearchResultProductListPresenter a;

        public d(ShopSearchResultProductListPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            if (((rg.a) r1) != null) goto L6;
            return;
        L6:
            if (ShopSearchResultProductListPresenter.e0(this.a).isPlayingVideo() == true) goto L9;
            ShopSearchResultProductListPresenter.d0(this.a);
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ ShopSearchResultProductListPresenter a;

        public e(ShopSearchResultProductListPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            rg.a r3 = (rg.a) r2;
            if (r3 != null) goto L6;
            return;
        L6:
            if (((Boolean) r3.b).booleanValue() == false) goto L8;
            ShopSearchResultProductListPresenter.d0(this.a);
            return;
        L8:
            ShopSearchResultProductListPresenter.e0(this.a).setPlayingVideo(false);
            boolean r4 = ECServiceManager.a;
            s83.f r5 = ((s83.g) ECServiceManager.c(s83.g.class)).p();
            if (r5 == null) goto L13;
            r5.n(ShopSearchResultProductListPresenter.e0(this.a).getSessionId());
            return;
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ ShopSearchResultProductListPresenter a;

        public f(ShopSearchResultProductListPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            LayoutTypes r3 = (LayoutTypes) r2;
            WrapContentStaggeredGridLayoutManager r4 = this.a.Z().b(2131384990).f().getLayoutManager();
            if (r4 == null) goto L9;
            int[] r5 = r4.findFirstVisibleItemPositions(null);
            if (r5 == null) goto L10;
            int r6 = r5[0];
            this.a.h0(r6);
            return;
        L10:
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.store.search.recyclerview.WrapContentStaggeredGridLayoutManager");
        }
    }

    public ShopSearchResultProductListPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }

    public static final void d0(ShopSearchResultProductListPresenter r12) {
        ShopSearchFragmentProductViewModel r0 = r12.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r0.setPlayingVideo(false);
        RecyclerView r1 = r12.Z().b(2131384990).f();
        ShopSearchFragmentProductViewModel r4 = r12.f;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        PagedList r5 = (PagedList) r4.getProducts().getValue();
        if (r5 == null) goto L11;
        int r6 = r5.size();
    L13:
        if (r6 >= 1) goto L15;
        return;
    L15:
        if (r1.getVisibility() != 0) goto L104;
        int[] r7 = new int[2];
        RecyclerView.LayoutManager r8 = r12.Z().b(2131384990).f().getLayoutManager();
        if ((r8 instanceof StaggeredGridLayoutManager) == true) goto L20;
        r8 = null;
    L20:
        StaggeredGridLayoutManager r9 = (StaggeredGridLayoutManager) r8;
        if (r9 == null) goto L23;
        r9.findFirstCompletelyVisibleItemPositions(r7);
    L23:
        Intrinsics.checkNotNullParameter(r7, "$this$getMinOrNull");
        int r10 = r7[0];
        int r11 = ArraysKt.getLastIndex(r7);
        if (1 > r11) goto L31;
        int r13 = 1;
    L26:
        int r14 = r7[r13];
        if (r10 <= r14) goto L29;
        r10 = r14;
    L29:
        if (r13 == r11) goto L31;
        r13 = r13 + 1;
    L31:
        Integer r15 = Integer.valueOf(r10);
        if (r15 != null) goto L40;
        RecyclerView.LayoutManager r16 = r12.Z().b(2131384990).f().getLayoutManager();
        if ((r16 instanceof LinearLayoutManager) == true) goto L36;
        r16 = null;
    L36:
        LinearLayoutManager r17 = (LinearLayoutManager) r16;
        if (r17 == null) goto L39;
        r15 = Integer.valueOf(r17.findFirstCompletelyVisibleItemPosition());
        goto L40
    L39:
        r15 = null;
    L40:
        int r18 = -1;
        if (r15 == null) goto L43;
        int r19 = r15.intValue();
    L44:
        Integer r20 = Integer.valueOf(r19);
        int r21 = r20.intValue();
        if (r21 < 0) goto L49;
        if (r6 <= r21) goto L49;
        boolean r22 = true;
    L50:
        if (r22 == true) goto L53;
        r20 = null;
    L53:
        int[] r2 = new int[2];
        RecyclerView.LayoutManager r23 = r12.Z().b(2131384990).f().getLayoutManager();
        if ((r23 instanceof StaggeredGridLayoutManager) == true) goto L56;
        r23 = null;
    L56:
        StaggeredGridLayoutManager r24 = (StaggeredGridLayoutManager) r23;
        if (r24 == null) goto L59;
        r24.findLastCompletelyVisibleItemPositions(r2);
    L59:
        Intrinsics.checkNotNullParameter(r2, "$this$getMaxOrNull");
        int r3 = r2[0];
        int r25 = ArraysKt.getLastIndex(r2);
        if (1 > r25) goto L67;
        int r26 = 1;
    L62:
        int r110 = r2[r26];
        if (r3 >= r110) goto L65;
        r3 = r110;
    L65:
        if (r26 == r25) goto L67;
        r26 = r26 + 1;
    L67:
        Integer r27 = Integer.valueOf(r3);
        if (r27 != null) goto L76;
        RecyclerView.LayoutManager r28 = r12.Z().b(2131384990).f().getLayoutManager();
        if ((r28 instanceof LinearLayoutManager) == true) goto L72;
        r28 = null;
    L72:
        LinearLayoutManager r29 = (LinearLayoutManager) r28;
        if (r29 == null) goto L75;
        r27 = Integer.valueOf(r29.findLastCompletelyVisibleItemPosition());
        goto L76
    L75:
        r27 = null;
    L76:
        if (r27 == null) goto L78;
        r18 = r27.intValue();
    L78:
        if (r20 == null) goto L101;
        int r30 = r20.intValue();
        if (r30 > r18) goto L102;
    L81:
        ShopSearchFragmentProductViewModel r31 = r12.f;
        if (r31 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L84:
        PagedList r32 = (PagedList) r31.getProducts().getValue();
        if (r32 == null) goto L94;
        en.b r33 = (en.b) r32.get(r30);
        if (r33 == null) goto L94;
        if ((r33 instanceof en.a) == true) goto L92;
        r33 = null;
    L92:
        if (r33 == null) goto L94;
        ((en.a) r33).b.q.g(new StoreV2ProductItemVO.b(1));
        return;
    L94:
        if (r30 == r18) goto L105;
        r30 = r30 + 1;
        goto L81
    L105:
        return;
    L102:
        return;
    L101:
        return;
    L49:
        r22 = false;
        goto L50
    L43:
        r19 = -1;
        goto L44
    L104:
        return;
    L11:
        r6 = 0;
        goto L13
    }

    public static final /* synthetic */ ShopSearchFragmentProductViewModel e0(ShopSearchResultProductListPresenter r1) {
        ShopSearchFragmentProductViewModel r2 = r1.f;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r2;
    }

    public final void b0(QModel r4) {
        this.f = Y().g(ShopSearchFragmentProductViewModel.class);
        h0(0);
        ShopSearchFragmentProductViewModel r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r0.getLayoutType().a(ECQuickUtilKt.a(Y()), new f(this), false);
    }

    public final void h0(int r7) {
        Fragment r0 = Y().a;
        if (r0 == null) goto L51;
        final RecyclerView r1 = Z().b(2131384990).f();
        r1.setLayoutManager(new WrapContentStaggeredGridLayoutManager());
        RecyclerView.ItemAnimator r2 = r1.getItemAnimator();
        if (r2 == null) goto L7;
        r2.setAddDuration(0);
    L7:
        RecyclerView.ItemAnimator r3 = r1.getItemAnimator();
        if (r3 == null) goto L10;
        r3.setChangeDuration(0);
    L10:
        RecyclerView.ItemAnimator r4 = r1.getItemAnimator();
        if (r4 == null) goto L13;
        r4.setMoveDuration(0);
    L13:
        RecyclerView.ItemAnimator r5 = r1.getItemAnimator();
        if (r5 == null) goto L16;
        r5.setRemoveDuration(0);
    L16:
        RecyclerView.ItemAnimator r6 = r1.getItemAnimator();
        if ((r6 instanceof SimpleItemAnimator) == true) goto L19;
        r6 = null;
    L19:
        SimpleItemAnimator r8 = (SimpleItemAnimator) r6;
        if (r8 == null) goto L22;
        r8.setSupportsChangeAnimations(false);
    L22:
        ShopSearchFragmentProductViewModel r9 = this.f;
        if (r9 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        LayoutTypes r10 = (LayoutTypes) r9.getLayoutType().getValue();
        if (r10 != null) goto L28;
        r10 = LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
    L28:
        ShopSearchResultAdapter r11 = new ShopSearchResultAdapter(r0, r10);
        if (true == ((ShopRecyclerViewWithHeaderAndFooterAdapter) r11).a) goto L31;
        ((ShopRecyclerViewWithHeaderAndFooterAdapter) r11).a = true;
    L31:
        r11.registerAdapterDataObserver(new ShopSearchResultProductListPresenter$initRecyclerView$$inlined$let$lambda$1(r1, this));
        Unit r12 = Unit.INSTANCE;
        this.g = r11;
        r1.setAdapter(r11);
        int r13 = com.bytedance.android.ec.store.widget.d.a;
        ShopSearchFragmentProductViewModel r14 = this.f;
        if (r14 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L34:
        com.bytedance.android.ec.store.widget.d.b(r1, r7, (LayoutTypes) r14.getLayoutType().getValue());
        r1.addOnScrollListener(new RecyclerViewPerformanceMonitor(MonitorScenes.EC_SHOP_PRODUCTS));
        r1.addOnScrollListener(new ShopSearchResultProductListPresenter$initRecyclerView$$inlined$let$lambda$2(this));
        ShopSearchFragmentProductViewModel r15 = this.f;
        if (r15 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        r15.getRefreshAction().a(ECQuickUtilKt.a(Y()), new a(this), false);
        ShopSearchFragmentProductViewModel r16 = this.f;
        if (r16 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L40:
        r16.getProducts().observe(ECQuickUtilKt.a(Y()), new b(this));
        ShopSearchFragmentProductViewModel r17 = this.f;
        if (r17 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L43:
        r17.getLoadStatus().b(ECQuickUtilKt.a(Y()), new c(r1, this));
        ShopSearchFragmentProductViewModel r18 = this.f;
        if (r18 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L46:
        r18.getUpdateVideoDataAction().a(ECQuickUtilKt.a(Y()), new d(this), false);
        ShopSearchFragmentProductViewModel r19 = this.f;
        if (r19 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L49:
        r19.getPlayVideoAction().a(ECQuickUtilKt.a(Y()), new e(this), false);
        return;
    }
}
