package com.bytedance.android.shopping.store.aggregate.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.store.adapter.ShopRecyclerViewWithHeaderAndFooterAdapter;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.ec.store.product.holder.ECProductCardHolder;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.shopping.store.aggregate.AggregatePageTypes;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import com.bytedance.android.shopping.store.holder.ShopAggregatePageFooterHolder;
import com.bytedance.android.shopping.store.home.module.r;
import com.bytedance.android.shopping.store.product.holder.ECStoreAggregatePageProductCardHolder;
import com.bytedance.android.shopping.store.recommend.holder.ShopAggregateDividerHolder;
import com.bytedance.android.shopping.store.recommend.holder.ShopClassificationEmptyStatusHolder;
import com.bytedance.android.shopping.store.status.ECShopEmptyPageType;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pj3.b;
import pj3.c;
import pj3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/aggregate/adapter/ShopAggregatePageProductListAdapter;", "Lcom/bytedance/android/ec/store/adapter/ShopRecyclerViewWithHeaderAndFooterAdapter;", "Lcom/bytedance/android/ec/store/repository/vo/StoreV2ProductItemVO;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopAggregatePageProductListAdapter extends ShopRecyclerViewWithHeaderAndFooterAdapter<StoreV2ProductItemVO, RecyclerView.ViewHolder> {
    public static final ShopAggregatePageProductListAdapter$Companion$diffCallback$1 g = null;
    public boolean c;
    public final Fragment d;
    public final ShopAggregatePageProductViewModel e;
    public final RecyclerView f;

    public static final class a {
    }

    public final long getItemId(int r3) {
        return r3;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.shopping.store.aggregate.adapter.ShopAggregatePageProductListAdapter$Companion$diffCallback$1] */
    static {
        g = new ShopAggregatePageProductListAdapter$Companion$diffCallback$1();
    }

    public final int getBasicItemViewType(int r2) {
        QModel r3 = (QModel) getItem(r2);
        if ((r3 instanceof c) == true) goto L11;
        if ((r3 instanceof b) == true) goto L11;
        if ((r3 instanceof d) == true) goto L11;
        return 0;
    L11:
        return r3.modelType();
    }

    public final void onBindFooterViewHolder(RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        if ((r3 instanceof ShopAggregatePageFooterHolder) == true) goto L5;
        r3 = null;
    L5:
        ShopAggregatePageFooterHolder r4 = (ShopAggregatePageFooterHolder) r3;
        if (r4 == null) goto L9;
        r4.a.c(r.class, null);
        return;
    }

    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        int r1 = ShopAggregatePageFooterHolder.b;
        Fragment r2 = this.d;
        RecyclerView r3 = this.f;
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        QUIManager r0 = new QUIManager();
        ShoppingAsyncInflater.a r4 = ShoppingAsyncInflater.e;
        Context r5 = r10.getContext();
        r4.getClass();
        View r6 = ShoppingAsyncInflater.a.a(r5).aU(2131564810, r10, false);
        LoadMoreStatusView r7 = r6.findViewById(2131387793);
        r7.setPadding(0, vf4.a.b(12), 0, vf4.a.b(12));
        Lazy r8 = ECAppInfoService.a;
        if (we.a.a == false) goto L5;
        r7.f(com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r10.getContext()), 2131564847, null, 6), null, null);
    L5:
        pn.b.a(r0, new r(r6, r3), r10.getContext(), r2);
        return new ShopAggregatePageFooterHolder(r0, r0.p());
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r6) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        super.onViewAttachedToWindow(r6);
        boolean r0 = r6 instanceof ShopAggregatePageFooterHolder;
        ViewGroup.LayoutParams r2 = null;
        if (r0 == false) goto L19;
        if (r0 == true) goto L6;
        r6 = null;
    L6:
        ShopAggregatePageFooterHolder r7 = (ShopAggregatePageFooterHolder) r6;
        if (r7 == null) goto L11;
        View r8 = ((RecyclerView.ViewHolder) r7).itemView;
        if (r8 == null) goto L11;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
    L13:
        if ((r9 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L16;
        r2 = r9;
    L16:
        StaggeredGridLayoutManager.LayoutParams r3 = (StaggeredGridLayoutManager.LayoutParams) r2;
        if (r3 == null) goto L75;
        r3.setFullSpan(true);
        return;
    L75:
        return;
    L11:
        r9 = null;
        goto L13
    L19:
        boolean r1 = r6 instanceof ShopAggregateDividerHolder;
        if (r1 == false) goto L36;
        if (r1 == true) goto L23;
        r6 = null;
    L23:
        ShopAggregateDividerHolder r10 = (ShopAggregateDividerHolder) r6;
        if (r10 == null) goto L28;
        View r11 = ((RecyclerView.ViewHolder) r10).itemView;
        if (r11 == null) goto L28;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
    L30:
        if ((r12 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L33;
        r2 = r12;
    L33:
        StaggeredGridLayoutManager.LayoutParams r4 = (StaggeredGridLayoutManager.LayoutParams) r2;
        if (r4 == null) goto L77;
        r4.setFullSpan(true);
        return;
    L77:
        return;
    L28:
        r12 = null;
        goto L30
    L36:
        boolean r5 = r6 instanceof ShopClassificationEmptyStatusHolder;
        if (r5 == false) goto L53;
        if (r5 == true) goto L40;
        r6 = null;
    L40:
        ShopClassificationEmptyStatusHolder r13 = (ShopClassificationEmptyStatusHolder) r6;
        if (r13 == null) goto L45;
        View r14 = ((RecyclerView.ViewHolder) r13).itemView;
        if (r14 == null) goto L45;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
    L47:
        if ((r15 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L50;
        r2 = r15;
    L50:
        StaggeredGridLayoutManager.LayoutParams r16 = (StaggeredGridLayoutManager.LayoutParams) r2;
        if (r16 == null) goto L79;
        r16.setFullSpan(true);
        return;
    L79:
        return;
    L45:
        r15 = null;
        goto L47
    L53:
        boolean r17 = r6 instanceof ECStoreAggregatePageProductCardHolder;
        if (r17 == true) goto L56;
        return;
    L56:
        if (((LayoutTypes) this.e.getLayoutType().getValue()) == LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L58;
        return;
    L58:
        if (Intrinsics.areEqual(this.e.getStoreParam().getPageType(), AggregatePageTypes.CLASSIFICATION.getType()) == false) goto L83;
        if (r17 == true) goto L61;
        r6 = null;
    L61:
        ECStoreAggregatePageProductCardHolder r18 = (ECStoreAggregatePageProductCardHolder) r6;
        if (r18 == null) goto L66;
        View r19 = ((RecyclerView.ViewHolder) r18).itemView;
        if (r19 == null) goto L66;
        ViewGroup.LayoutParams r20 = r19.getLayoutParams();
    L68:
        if ((r20 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L71;
        r2 = r20;
    L71:
        StaggeredGridLayoutManager.LayoutParams r21 = (StaggeredGridLayoutManager.LayoutParams) r2;
        if (r21 == null) goto L84;
        r21.setFullSpan(true);
        return;
    L84:
        return;
    L66:
        r20 = null;
        goto L68
    }

    public final void onBindBasicViewHolder(RecyclerView.ViewHolder r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        StoreV2ProductItemVO r0 = (StoreV2ProductItemVO) getItem(r6);
        if ((r0 instanceof b) == false) goto L9;
        ShopAggregateDividerHolder r7 = (ShopAggregateDividerHolder) r5;
        b r1 = (b) r0;
        if (r1 != null) goto L7;
        r7.getClass();
    L32:
        if (this.c == false) goto L37;
        this.c = false;
        if (Intrinsics.areEqual(this.e.getStoreParam().getPageType(), AggregatePageTypes.CLASSIFICATION.getType()) == false) goto L38;
        Map r8 = qm.a.a;
        qm.a.a("ec_perf_duration_shop_classification", "render_end", System.currentTimeMillis());
        qm.a.c("ec_perf_duration_shop_classification");
        return;
    L38:
        return;
    L37:
        return;
    L7:
        r7.a.c(nj3.a.class, r1);
        goto L32
    L9:
        if ((r0 instanceof d) == true) goto L11;
        if (r0 == null) goto L24;
        r0.v = r6 + 1;
    L24:
        if ((r5 instanceof ECStoreAggregatePageProductCardHolder) == true) goto L26;
        r5 = null;
    L26:
        ECStoreAggregatePageProductCardHolder r9 = (ECStoreAggregatePageProductCardHolder) r5;
        if (r9 == null) goto L32;
        if (r0 == null) goto L32;
        ((ECProductCardHolder) r9).a.c(mj3.a.class, r0);
        goto L32
    L11:
        if ((r5 instanceof ShopClassificationEmptyStatusHolder) == true) goto L13;
        r5 = null;
    L13:
        ShopClassificationEmptyStatusHolder r10 = (ShopClassificationEmptyStatusHolder) r5;
        if (r10 == null) goto L32;
        d r2 = (d) r0;
        if (r2 == null) goto L32;
        com.bytedance.android.shopping.store.status.b r11 = r10.a;
        r11.e = r2.R;
        r11.a();
        if (r2.R == true) goto L32;
        r10.a.setPadding(0, ExtensionsKt.a(40), 0, ExtensionsKt.a(24));
        goto L32
    }

    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        if (r9 != 2) goto L5;
        int r10 = ShopAggregateDividerHolder.b;
        Intrinsics.checkNotNullParameter(r8, "parent");
        QUIManager r11 = new QUIManager();
        r11.l(new nj3.a(new qj3.a(r8.getContext())), r8.getContext(), false);
        View r0 = r11.p();
        if (r0 == null) goto L20;
        return new ShopAggregateDividerHolder(r11, (qj3.a) r0);
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.recommend.widget.ShopAggregateDividerView");
    L5:
        if (r9 == 3) goto L14;
        int r1 = ECStoreAggregatePageProductCardHolder.b;
        Fragment r2 = this.d;
        String r3 = this.e.getStoreParam().getPageType();
        Object r4 = this.e.getLayoutType().getValue();
        Intrinsics.checkNotNull(r4);
        LayoutTypes r5 = (LayoutTypes) r4;
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r8, "parent");
        Intrinsics.checkNotNullParameter(r5, "layoutType");
        QUIManager r6 = new QUIManager();
        if (Intrinsics.areEqual(r3, AggregatePageTypes.CLASSIFICATION.getType()) == true) goto L9;
        ShoppingAsyncInflater.a r7 = ShoppingAsyncInflater.e;
        Context r12 = r8.getContext();
        r7.getClass();
        View r13 = ShoppingAsyncInflater.a.a(r12).aU(2131564703, r8, false);
    L13:
        pn.b.a(r6, new mj3.a(r13, r3, r5, r9), r8.getContext(), r2);
        return new ECStoreAggregatePageProductCardHolder(r6, r6.p());
    L9:
        if (lj3.a.a[r5.ordinal()] == 1) goto L11;
        ShoppingAsyncInflater.a r14 = ShoppingAsyncInflater.e;
        Context r15 = r8.getContext();
        r14.getClass();
        r13 = com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r15), 2131564802, r8, 4);
        goto L13
    L11:
        ShoppingAsyncInflater.a r16 = ShoppingAsyncInflater.e;
        Context r17 = r8.getContext();
        r16.getClass();
        r13 = com.bytedance.android.ec.opt.asyncInflate.c.a(ShoppingAsyncInflater.a.a(r17), 2131564804, r8, 4);
        goto L13
    L14:
        int r18 = ShopClassificationEmptyStatusHolder.b;
        Intrinsics.checkNotNullParameter(r8, "parent");
        return new ShopClassificationEmptyStatusHolder(new com.bytedance.android.shopping.store.status.b(r8.getContext(), ECShopEmptyPageType.CLASSIFICATION, false));
    }

    public ShopAggregatePageProductListAdapter(Fragment r2, ShopAggregatePageProductViewModel r3, RecyclerView r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        super(g);
        this.d = r2;
        this.e = r3;
        this.f = r4;
        setHasStableIds(true);
        this.c = true;
    }
}
