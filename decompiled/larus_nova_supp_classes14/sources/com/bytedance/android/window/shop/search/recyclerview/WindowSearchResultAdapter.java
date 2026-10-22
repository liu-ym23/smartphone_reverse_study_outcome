package com.bytedance.android.window.shop.search.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.ec.opt.asyncInflate.c;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.window.base.adapter.WindowRecyclerViewWithHeaderAndFooterAdapterV1;
import com.bytedance.android.ec.window.base.product.holder.WindowLayoutTypes;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ec.window.base.search.recyclerview.vo.WindowSearchResultFooterNoticeVO;
import com.bytedance.android.ec.window.base.search.recyclerview.vo.WindowSearchResultItemType;
import com.bytedance.android.ec.window.base.utils.quick.d;
import com.bytedance.android.window.shop.search.recyclerview.holder.WindowBaseSearchResultViewHolder;
import com.bytedance.android.window.shop.search.recyclerview.holder.WindowRecommendedNoticeHolder;
import com.bytedance.android.window.shop.search.recyclerview.holder.WindowRecommendedResultHolder;
import com.bytedance.android.window.shop.search.recyclerview.holder.WindowSearchProductFooterHolder;
import com.bytedance.android.window.shop.search.recyclerview.holder.WindowSearchResultFooterViewHolder;
import com.bytedance.android.window.shop.search.recyclerview.holder.WindowSearchResultViewHolder;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jp.b;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vq3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/search/recyclerview/WindowSearchResultAdapter;", "Lcom/bytedance/android/ec/window/base/adapter/WindowRecyclerViewWithHeaderAndFooterAdapterV1;", "Ljp/b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowSearchResultAdapter extends WindowRecyclerViewWithHeaderAndFooterAdapterV1<b, RecyclerView.ViewHolder> {
    public static final WindowSearchResultAdapter$Companion$diffCallback$1 h = null;
    public RecyclerView c;
    public boolean d;
    public int e;
    public final Fragment f;
    public final WindowLayoutTypes g;

    public static final class a {
    }

    public final long getItemId(int r3) {
        return r3;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.window.shop.search.recyclerview.WindowSearchResultAdapter$Companion$diffCallback$1] */
    static {
        h = new WindowSearchResultAdapter$Companion$diffCallback$1();
    }

    public final int getBasicItemViewType(int r2) {
        Object r3 = getItem(r2);
        if (r3 == null) goto L7;
        return ((b) r3).a.getTypeValue();
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.window.base.search.recyclerview.vo.WindowBaseViewObject");
    }

    public final void onAttachedToRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onAttachedToRecyclerView(r2);
        this.c = r2;
    }

    public final void onBindFooterViewHolder(RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        if ((r3 instanceof WindowSearchProductFooterHolder) == false) goto L6;
        ((WindowSearchProductFooterHolder) r3).a.c(e.class, null);
        return;
    L6:
        if ((r3 instanceof WindowSearchResultFooterViewHolder) == false) goto L10;
        ((WindowSearchResultFooterViewHolder) r3).T3(new WindowSearchResultFooterNoticeVO());
        return;
    }

    public final RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        RecyclerView r1 = this.c;
        if (r1 == null) goto L9;
        int r2 = WindowSearchProductFooterHolder.b;
        Fragment r3 = this.f;
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r1, "recyclerView");
        QUIManager r0 = new QUIManager();
        ShoppingAsyncInflater.a r4 = ShoppingAsyncInflater.e;
        Context r5 = r10.getContext();
        r4.getClass();
        View r6 = ShoppingAsyncInflater.a.a(r5).aU(2131561058, r10, false);
        LoadMoreStatusView r7 = r6.findViewById(2131387793);
        r7.setPadding(0, vf4.a.b(12), 0, vf4.a.b(12));
        Lazy r8 = ECAppInfoService.a;
        if (we.a.a == false) goto L7;
        r7.f(c.a(ShoppingAsyncInflater.a.a(r10.getContext()), 2131561059, null, 6), null, null);
    L7:
        d.a(r0, new e(r6, r1), r10.getContext(), r3);
        return new WindowSearchProductFooterHolder(r0, r0.p());
    L9:
        int r9 = WindowSearchResultFooterViewHolder.e;
        Context r11 = r10.getContext();
        Intrinsics.checkNotNullParameter(r11, "context");
        return new WindowSearchResultFooterViewHolder(new TextView(r11));
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
        if ((r5 instanceof WindowRecommendedNoticeHolder) == false) goto L5;
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
        if ((r5 instanceof WindowSearchProductFooterHolder) == true) goto L20;
        if ((r5 instanceof WindowSearchResultViewHolder) == true) goto L12;
        if ((r5 instanceof WindowRecommendedResultHolder) == true) goto L12;
        return;
    L12:
        if (this.g != WindowLayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L29;
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
        if (getItemViewType(r2) != WindowSearchResultItemType.RECOMMEND_NOTICE.getTypeValue()) goto L5;
        return true;
    L5:
        return false;
    }

    public WindowSearchResultAdapter(Fragment r2, WindowLayoutTypes r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "layoutType");
        super(h);
        this.f = r2;
        this.g = r3;
        this.d = true;
        setHasStableIds(true);
    }

    public final void onBindBasicViewHolder(RecyclerView.ViewHolder r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        b r0 = (b) getItem(r8);
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof jp.a) == true) goto L7;
        b r1 = null;
    L8:
        jp.a r2 = (jp.a) r1;
        if (r2 == null) goto L19;
        WindowV2ProductItemVO r3 = r2.b;
        if (r3 == null) goto L19;
        if ((r3 instanceof com.bytedance.android.ec.window.base.repository.vo.e) == true) goto L15;
        r3.y = r8;
        goto L19
    L15:
        if (this.e != 0) goto L17;
        this.e = r8;
    L17:
        r3.y = r8 - this.e;
    L19:
        ((WindowBaseSearchResultViewHolder) r7).T3(r0);
        if (this.d == false) goto L42;
        this.d = false;
        Map r9 = wo.a.a;
        wo.a.a("ec_perf_duration_shop_search_result", "render_end", System.currentTimeMillis());
        Intrinsics.checkNotNullParameter("ec_perf_duration_shop_search_result", "business");
        String r10 = (String) ((LinkedHashMap) wo.a.a).get("ec_perf_duration_shop_search_result");
        if (r10 == null) goto L43;
        Map r11 = (Map) ((LinkedHashMap) wo.a.b).get("ec_perf_duration_shop_search_result");
        if (r11 == null) goto L31;
        Iterator r12 = r11.entrySet().iterator();
    L27:
        if (r12.hasNext() == false) goto L31;
        Map.Entry r4 = (Map.Entry) r12.next();
        com.bytedance.android.ec.monitor.duration.d r5 = i.a.get(r10);
        if (r5 == null) goto L27;
        r5.d((String) r4.getKey(), ((Number) r4.getValue()).longValue());
    L31:
        com.bytedance.android.ec.monitor.duration.d r13 = i.a.get(r10);
        if (r13 == null) goto L34;
        r13.report();
    L34:
        wo.a.a.remove("ec_perf_duration_shop_search_result");
        Map r14 = (Map) wo.a.b.remove("ec_perf_duration_shop_search_result");
        return;
    L43:
        return;
    L42:
        return;
    L7:
        r1 = r0;
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parent");
        if (r11 == WindowSearchResultItemType.RECOMMEND_NOTICE.getTypeValue()) goto L22;
        WindowSearchResultItemType r1 = WindowSearchResultItemType.SEARCH_RESULT;
        if (r11 != r1.getTypeValue()) goto L12;
        int r12 = WindowSearchResultViewHolder.d;
        Fragment r13 = this.f;
        WindowLayoutTypes r2 = this.g;
        Intrinsics.checkNotNullParameter(r13, "fragment");
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r2, "layoutType");
        QUIManager r0 = new QUIManager();
        if (wq3.b.a[r2.ordinal()] == 1) goto L10;
        ShoppingAsyncInflater.a r4 = ShoppingAsyncInflater.e;
        Context r6 = r10.getContext();
        r4.getClass();
        View r3 = c.a(ShoppingAsyncInflater.a.a(r6), 2131561025, r10, 4);
    L11:
        r2.getType();
        d.a(r0, new vq3.d(r3), r10.getContext(), r13);
        return new WindowSearchResultViewHolder(r0, r0.p(), r1);
    L10:
        ShoppingAsyncInflater.a r5 = ShoppingAsyncInflater.e;
        Context r7 = r10.getContext();
        r5.getClass();
        r3 = c.a(ShoppingAsyncInflater.a.a(r7), 2131561031, r10, 4);
        goto L11
    L12:
        WindowSearchResultItemType r8 = WindowSearchResultItemType.RECOMMENDED_RESULT;
        if (r11 != r8.getTypeValue()) goto L21;
        int r14 = WindowRecommendedResultHolder.d;
        Fragment r15 = this.f;
        WindowLayoutTypes r9 = this.g;
        Intrinsics.checkNotNullParameter(r15, "fragment");
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r9, "layoutType");
        QUIManager r16 = new QUIManager();
        if (wq3.a.a[r9.ordinal()] == 1) goto L17;
        ShoppingAsyncInflater.a r17 = ShoppingAsyncInflater.e;
        Context r18 = r10.getContext();
        r17.getClass();
        View r19 = c.a(ShoppingAsyncInflater.a.a(r18), 2131561025, r10, 4);
    L18:
        r9.getType();
        d.a(r16, new vq3.d(r19), r10.getContext(), r15);
        return new WindowRecommendedResultHolder(r16, r16.p(), r8);
    L17:
        ShoppingAsyncInflater.a r20 = ShoppingAsyncInflater.e;
        Context r21 = r10.getContext();
        r20.getClass();
        r19 = c.a(ShoppingAsyncInflater.a.a(r21), 2131561031, r10, 4);
        goto L18
    L21:
        throw new IllegalArgumentException("unexpected viewType: " + r11);
    L22:
        return new WindowRecommendedNoticeHolder(r10.getContext());
    }
}
