package com.bytedance.android.window.shop.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/widget/WindowRecyclerViewWithHeaderAndFooterAdapterV2;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class WindowRecyclerViewWithHeaderAndFooterAdapterV2<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    public static final /* synthetic */ int b = 0;
    public boolean a;

    public static final class a {
    }

    static {
    }

    public abstract int getBasicItemCount();

    public int getBasicItemViewType(int r1) {
        return 0;
    }

    public abstract void onBindBasicViewHolder(VH r1, int r2);

    public void onBindFooterViewHolder(VH r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
    }

    public abstract VH onCreateBasicViewHolder(ViewGroup r1, int r2);

    public VH onCreateFooterViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return null;
    }

    public boolean y2(VH r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        return false;
    }

    public final int getItemCount() {
        int r0 = getBasicItemCount();
        if (this.a == true) goto L5;
        return r0;
    L5:
        return r0 + 1;
    }

    public WindowRecyclerViewWithHeaderAndFooterAdapterV2() {
    }

    public final int getItemViewType(int r2) {
        if (this.a == false) goto L8;
        if (r2 < (getItemCount() - 1)) goto L8;
        return Integer.MAX_VALUE;
    L8:
        return getBasicItemViewType(r2);
    }

    public void onAttachedToRecyclerView(RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        super.onAttachedToRecyclerView(r3);
        final GridLayoutManager r4 = r3.getLayoutManager();
        if ((r4 instanceof GridLayoutManager) == false) goto L6;
        r4.setSpanSizeLookup(new AnonymousClass1(this, r4));
        return;
    }

    public final void onViewAttachedToWindow(VH r5) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        super.onViewAttachedToWindow(r5);
        int r0 = getItemViewType(r5.getLayoutPosition());
        boolean r2 = false;
        if (r0 != Integer.MIN_VALUE) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        r5.getLayoutPosition();
        if (y2(r5) == true) goto L12;
    L13:
        ViewGroup.LayoutParams r6 = ((RecyclerView.ViewHolder) r5).itemView.getLayoutParams();
        if ((r6 instanceof StaggeredGridLayoutManager.LayoutParams) == true) goto L16;
        r6 = null;
    L16:
        StaggeredGridLayoutManager.LayoutParams r7 = (StaggeredGridLayoutManager.LayoutParams) r6;
        if (r7 == null) goto L20;
        r7.setFullSpan(r2);
        return;
    L20:
        return;
    L12:
        r2 = true;
        goto L13
    L5:
        if (r0 == Integer.MAX_VALUE) goto L8;
        r1 = false;
        goto L9
    }

    public final void onBindViewHolder(VH r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        int r1 = getItemViewType(r5);
        if (r1 != Integer.MIN_VALUE) goto L5;
        Intrinsics.checkNotNullParameter(r4, "holder");
        return;
    L5:
        if (r1 == Integer.MAX_VALUE) goto L7;
        onBindBasicViewHolder(r4, r5);
        return;
    L7:
        View r6 = ((RecyclerView.ViewHolder) r4).itemView;
        if (getBasicItemCount() <= 0) goto L10;
        int r0 = 0;
    L11:
        r6.setVisibility(r0);
        onBindFooterViewHolder(r4);
        return;
    L10:
        r0 = 8;
        goto L11
    }

    public final VH onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 != Integer.MIN_VALUE) goto L5;
        Intrinsics.checkNotNullParameter(r3, "parent");
        Intrinsics.checkNotNull(null);
        return null;
    L5:
        if (r4 != Integer.MAX_VALUE) goto L10;
        VH r5 = (VH) onCreateFooterViewHolder(r3);
        Intrinsics.checkNotNull(r5);
        return r5;
    L10:
        return (VH) onCreateBasicViewHolder(r3, r4);
    }
}
