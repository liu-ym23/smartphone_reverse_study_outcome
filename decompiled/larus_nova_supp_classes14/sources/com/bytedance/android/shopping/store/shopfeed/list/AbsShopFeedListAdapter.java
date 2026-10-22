package com.bytedance.android.shopping.store.shopfeed.list;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.store.adapter.ShopRecyclerViewWithHeaderAndFooterAdapter;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.hybridproduct.holder.e;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/AbsShopFeedListAdapter;", "Lcom/bytedance/android/ec/store/adapter/ShopRecyclerViewWithHeaderAndFooterAdapter;", "Lcom/bytedance/android/shopping/store/shopfeed/list/a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsShopFeedListAdapter extends ShopRecyclerViewWithHeaderAndFooterAdapter<com.bytedance.android.shopping.store.shopfeed.list.a, RecyclerView.ViewHolder> {
    public static final AbsShopFeedListAdapter$Companion$diffCallback$1 h = null;
    public int c;
    public final QLiveData<LoadStatus> d;
    public final LifecycleOwner e;
    public final Fragment f;
    public final ECShopFeedViewModel g;

    public static final class a {
    }

    public abstract RecyclerView.ViewHolder A2(ViewGroup r1);

    public final long getItemId(int r3) {
        return r3;
    }

    public abstract void z2();

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.shopping.store.shopfeed.list.AbsShopFeedListAdapter$Companion$diffCallback$1] */
    static {
        h = new AbsShopFeedListAdapter$Companion$diffCallback$1();
    }

    public final int getBasicItemViewType(int r1) {
        com.bytedance.android.shopping.store.shopfeed.list.a r2 = (com.bytedance.android.shopping.store.shopfeed.list.a) getItem(r1);
        if (r2 == null) goto L7;
        ShopFeedItemType r3 = r2.a;
        if (r3 == null) goto L7;
        return r3.getTypeValue();
    L7:
        return 0;
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(r2);
        if ((r2 instanceof ShopFeedBaseViewHolder) == true) goto L5;
        r2 = null;
    L5:
        ShopFeedBaseViewHolder r3 = (ShopFeedBaseViewHolder) r2;
        if (r3 == null) goto L9;
        r3.o();
        return;
    }

    public final void onBindBasicViewHolder(RecyclerView.ViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        com.bytedance.android.shopping.store.shopfeed.list.a r0 = (com.bytedance.android.shopping.store.shopfeed.list.a) getItem(r7);
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof b) == true) goto L7;
        com.bytedance.android.shopping.store.shopfeed.list.a r1 = null;
    L8:
        b r2 = (b) r1;
        if (r2 == null) goto L18;
        if ((r6 instanceof ShopFeedBaseViewHolder) == true) goto L13;
        RecyclerView.ViewHolder r3 = null;
    L14:
        ShopFeedBaseViewHolder r4 = (ShopFeedBaseViewHolder) r3;
        if (r4 == null) goto L18;
        r4.T3(r2, r7, this.c);
        goto L18
    L13:
        r3 = r6;
    L18:
        if ((r0 instanceof c) == true) goto L20;
        r0 = null;
    L20:
        c r5 = (c) r0;
        if (r5 != null) goto L23;
        return;
    L23:
        if ((r6 instanceof ShopFlowSliceCardViewHolder) == true) goto L25;
        r6 = null;
    L25:
        ShopFlowSliceCardViewHolder r8 = (ShopFlowSliceCardViewHolder) r6;
        if (r8 == null) goto L31;
        r8.T3(r5, r7, this.c);
        return;
    L31:
        return;
    L7:
        r1 = r0;
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "parent");
        if (r7 != ShopFeedItemType.LYNX_CARD.getTypeValue()) goto L7;
        return A2(r6);
    L7:
        if (r7 != ShopFeedItemType.SLICE_CARD.getTypeValue()) goto L11;
        int r8 = ShopFlowSliceCardViewHolder.e;
        QLiveData<LoadStatus> r9 = this.d;
        ECShopFeedViewModel r1 = this.g;
        Fragment r2 = this.f;
        Intrinsics.checkNotNullParameter(r6, "parent");
        Intrinsics.checkNotNullParameter(r9, "loadStatus");
        Intrinsics.checkNotNullParameter(r1, "feedViewModel");
        Intrinsics.checkNotNullParameter(r2, "fragment");
        QUIManager r10 = new QUIManager();
        FrameLayout r0 = new FrameLayout(r6.getContext());
        e r3 = new e();
        pn.b.a(r10, new ek3.b(r2, r0, r3), r6.getContext(), r2);
        return new ShopFlowSliceCardViewHolder(r10, r0, r1, r3);
    L11:
        throw new IllegalArgumentException("unexpected viewType: " + r7);
    }

    public AbsShopFeedListAdapter(QLiveData<LoadStatus> r2, LifecycleOwner r3, Fragment r4, ECShopFeedViewModel r5) {
        Intrinsics.checkNotNullParameter(r2, "loadStatus");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r5, "shopFeedViewModel");
        super(h);
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        setHasStableIds(true);
        z2();
        if (true == ((ShopRecyclerViewWithHeaderAndFooterAdapter) this).a) goto L6;
        ((ShopRecyclerViewWithHeaderAndFooterAdapter) this).a = true;
        return;
    }
}
