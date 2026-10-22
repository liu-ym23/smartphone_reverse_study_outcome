package com.bytedance.android.shopping.store.search.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import ck3.e;
import ck3.f;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.ec.opt.asyncInflate.c;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.store.adapter.ShopRecyclerViewWithHeaderAndFooterAdapter;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.repository.vo.o;
import com.bytedance.android.ec.store.search.recyclerview.vo.SearchResultFooterNoticeVO;
import com.bytedance.android.ec.store.search.recyclerview.vo.SearchResultItemType;
import com.bytedance.android.shopping.store.search.recyclerview.holder.ShopBaseSearchResultViewHolder;
import com.bytedance.android.shopping.store.search.recyclerview.holder.ShopRecommendedNoticeHolder;
import com.bytedance.android.shopping.store.search.recyclerview.holder.ShopRecommendedResultHolder;
import com.bytedance.android.shopping.store.search.recyclerview.holder.ShopSearchProductFooterHolder;
import com.bytedance.android.shopping.store.search.recyclerview.holder.ShopSearchResultFooterViewHolder;
import com.bytedance.android.shopping.store.search.recyclerview.holder.ShopSearchResultViewHolder;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import en.b;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/search/recyclerview/ShopSearchResultAdapter;", "Lcom/bytedance/android/ec/store/adapter/ShopRecyclerViewWithHeaderAndFooterAdapter;", "Len/b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchResultAdapter extends ShopRecyclerViewWithHeaderAndFooterAdapter<b, RecyclerView.ViewHolder> {
    public static final ShopSearchResultAdapter$Companion$diffCallback$1 h = null;
    public RecyclerView c;
    public boolean d;
    public int e;
    public final Fragment f;
    public final LayoutTypes g;

    public static final class a {
    }

    public final long getItemId(int r3) {
        return r3;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.shopping.store.search.recyclerview.ShopSearchResultAdapter$Companion$diffCallback$1] */
    static {
        h = new ShopSearchResultAdapter$Companion$diffCallback$1();
    }

    public final int getBasicItemViewType(int r2) {
        Object r3 = getItem(r2);
        if (r3 == null) goto L7;
        return ((b) r3).a.getTypeValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.store.search.recyclerview.vo.BaseViewObject");
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onAttachedToRecyclerView(r2);
        this.c = r2;
    }

    public final void onBindFooterViewHolder(RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        if ((r3 instanceof ShopSearchProductFooterHolder) == false) goto L6;
        ((ShopSearchProductFooterHolder) r3).a.c(f.class, null);
        return;
    L6:
        if ((r3 instanceof ShopSearchResultFooterViewHolder) == false) goto L10;
        ((ShopSearchResultFooterViewHolder) r3).T3(new SearchResultFooterNoticeVO());
        return;
    }

    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        RecyclerView r1 = this.c;
        if (r1 == null) goto L9;
        int r2 = ShopSearchProductFooterHolder.b;
        Fragment r3 = this.f;
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r1, "recyclerView");
        QUIManager r0 = new QUIManager();
        ShoppingAsyncInflater.a r4 = ShoppingAsyncInflater.e;
        Context r5 = r10.getContext();
        r4.getClass();
        View r6 = ShoppingAsyncInflater.a.a(r5).aU(2131564810, r10, false);
        LoadMoreStatusView r7 = r6.findViewById(2131387793);
        r7.setPadding(0, vf4.a.b(12), 0, vf4.a.b(12));
        Lazy r8 = ECAppInfoService.a;
        if (we.a.a == false) goto L7;
        r7.f(c.a(ShoppingAsyncInflater.a.a(r10.getContext()), 2131564847, null, 6), null, null);
    L7:
        pn.b.a(r0, new f(r6, r1), r10.getContext(), r3);
        return new ShopSearchProductFooterHolder(r0, r0.p());
    L9:
        int r9 = ShopSearchResultFooterViewHolder.e;
        Context r11 = r10.getContext();
        Intrinsics.checkNotNullParameter(r11, "context");
        return new ShopSearchResultFooterViewHolder(new TextView(r11));
    }

    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onDetachedFromRecyclerView(r2);
        this.c = null;
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r5) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        super.onViewAttachedToWindow(r5);
        StaggeredGridLayoutManager.LayoutParams r2 = null;
        if ((r5 instanceof ShopRecommendedNoticeHolder) == false) goto L5;
    L20:
        StaggeredGridLayoutManager.LayoutParams r6 = r5.itemView.getLayoutParams();
        if ((r6 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L24;
        r2 = r6;
    L24:
        StaggeredGridLayoutManager.LayoutParams r3 = r2;
        if (r3 == null) goto L32;
        r3.setFullSpan(true);
        return;
    L32:
        return;
    L5:
        if ((r5 instanceof ShopSearchProductFooterHolder) == true) goto L20;
        if ((r5 instanceof ShopSearchResultViewHolder) == true) goto L12;
        if ((r5 instanceof ShopRecommendedResultHolder) == true) goto L12;
        return;
    L12:
        if (this.g != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L29;
        StaggeredGridLayoutManager.LayoutParams r7 = r5.itemView.getLayoutParams();
        if ((r7 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L17;
        r2 = r7;
    L17:
        StaggeredGridLayoutManager.LayoutParams r4 = r2;
        if (r4 == null) goto L30;
        r4.setFullSpan(true);
        return;
    L30:
        return;
    }

    public final boolean y2(int r2) {
        if (getItemViewType(r2) != SearchResultItemType.RECOMMEND_NOTICE.getTypeValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public ShopSearchResultAdapter(Fragment r2, LayoutTypes r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "layoutType");
        super(h);
        this.f = r2;
        this.g = r3;
        this.d = true;
        setHasStableIds(true);
    }

    public final void onBindBasicViewHolder(RecyclerView.ViewHolder r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        b r0 = (b) getItem(r5);
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof en.a) == true) goto L7;
        b r1 = null;
    L8:
        en.a r2 = (en.a) r1;
        if (r2 == null) goto L19;
        StoreV2ProductItemVO r3 = r2.b;
        if (r3 == null) goto L19;
        if ((r3 instanceof o) == true) goto L15;
        r3.v = r5;
        goto L19
    L15:
        if (this.e != 0) goto L17;
        this.e = r5;
    L17:
        r3.v = r5 - this.e;
    L19:
        ((ShopBaseSearchResultViewHolder) r4).T3(r0);
        if (this.d == false) goto L24;
        this.d = false;
        Map r6 = qm.a.a;
        qm.a.a("ec_perf_duration_shop_search_result", "render_end", System.currentTimeMillis());
        qm.a.c("ec_perf_duration_shop_search_result");
        return;
    L24:
        return;
    L7:
        r1 = r0;
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        if (r11 == SearchResultItemType.RECOMMEND_NOTICE.getTypeValue()) goto L22;
        SearchResultItemType r1 = SearchResultItemType.SEARCH_RESULT;
        if (r11 != r1.getTypeValue()) goto L12;
        int r12 = ShopSearchResultViewHolder.d;
        Fragment r13 = this.f;
        LayoutTypes r2 = this.g;
        Intrinsics.checkNotNullParameter(r13, "fragment");
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r2, "layoutType");
        QUIManager r0 = new QUIManager();
        if (dk3.b.a[r2.ordinal()] == 1) goto L10;
        ShoppingAsyncInflater.a r3 = ShoppingAsyncInflater.e;
        Context r4 = r10.getContext();
        r3.getClass();
        View r5 = c.a(ShoppingAsyncInflater.a.a(r4), 2131564802, r10, 4);
    L11:
        pn.b.a(r0, new e(r5), r10.getContext(), r13);
        return new ShopSearchResultViewHolder(r0, r0.p(), r1);
    L10:
        ShoppingAsyncInflater.a r6 = ShoppingAsyncInflater.e;
        Context r7 = r10.getContext();
        r6.getClass();
        r5 = c.a(ShoppingAsyncInflater.a.a(r7), 2131564804, r10, 4);
        goto L11
    L12:
        SearchResultItemType r8 = SearchResultItemType.RECOMMENDED_RESULT;
        if (r11 != r8.getTypeValue()) goto L21;
        int r14 = ShopRecommendedResultHolder.d;
        Fragment r15 = this.f;
        LayoutTypes r9 = this.g;
        Intrinsics.checkNotNullParameter(r15, "fragment");
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r9, "layoutType");
        QUIManager r16 = new QUIManager();
        if (dk3.a.a[r9.ordinal()] == 1) goto L17;
        ShoppingAsyncInflater.a r17 = ShoppingAsyncInflater.e;
        Context r18 = r10.getContext();
        r17.getClass();
        View r19 = c.a(ShoppingAsyncInflater.a.a(r18), 2131564802, r10, 4);
    L18:
        pn.b.a(r16, new e(r19), r10.getContext(), r15);
        return new ShopRecommendedResultHolder(r16, r16.p(), r8);
    L17:
        ShoppingAsyncInflater.a r20 = ShoppingAsyncInflater.e;
        Context r21 = r10.getContext();
        r20.getClass();
        r19 = c.a(ShoppingAsyncInflater.a.a(r21), 2131564804, r10, 4);
        goto L18
    L21:
        throw new IllegalArgumentException("unexpected viewType: " + r11);
    L22:
        return new ShopRecommendedNoticeHolder(r10.getContext());
    }
}
