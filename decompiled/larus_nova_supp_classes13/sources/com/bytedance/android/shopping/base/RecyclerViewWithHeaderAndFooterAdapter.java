package com.bytedance.android.shopping.base;

import android.view.View;
import android.view.ViewGroup;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.shopping.anchorv3.auction.RecordDiffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/base/RecyclerViewWithHeaderAndFooterAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/paging/PagedListAdapter;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class RecyclerViewWithHeaderAndFooterAdapter<T, VH extends RecyclerView.ViewHolder> extends PagedListAdapter<T, VH> {
    public static final /* synthetic */ int b = 0;
    public boolean a;

    public static final class a {
    }

    static {
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

    public final int getItemCount() {
        int r0 = super.getItemCount();
        if (this.a == true) goto L5;
        return r0;
    L5:
        return r0 + 1;
    }

    public RecyclerViewWithHeaderAndFooterAdapter(RecordDiffer r2) {
        Intrinsics.checkNotNullParameter(r2, "diffCallback");
        super(r2);
    }

    public final int getItemViewType(int r2) {
        if (this.a == true) goto L5;
    L7:
        return 0;
    L5:
        if (r2 < (getItemCount() - 1)) goto L7;
        return Integer.MAX_VALUE;
    }

    public final void onAttachedToRecyclerView(RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onAttachedToRecyclerView(r3);
        final GridLayoutManager r4 = r3.getLayoutManager();
        if ((r4 instanceof GridLayoutManager) == false) goto L6;
        r4.setSpanSizeLookup(new AnonymousClass1(this, r4));
        return;
    }

    public final void onViewAttachedToWindow(VH r5) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewAttachedToWindow(r5);
        int r0 = getItemViewType(r5.getLayoutPosition());
        boolean r2 = false;
        if (r0 != Integer.MIN_VALUE) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        r5.getLayoutPosition();
    L12:
        ViewGroup.LayoutParams r6 = ((RecyclerView.ViewHolder) r5).itemView.getLayoutParams();
        if ((r6 instanceof StaggeredGridLayoutManager.LayoutParams) == true) goto L15;
        r6 = null;
    L15:
        StaggeredGridLayoutManager.LayoutParams r7 = (StaggeredGridLayoutManager.LayoutParams) r6;
        if (r7 == null) goto L19;
        r7.setFullSpan(r2);
        return;
    L19:
        return;
    L11:
        r2 = true;
        goto L12
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
        if (super.getItemCount() <= 0) goto L10;
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
