package com.bytedance.android.livesdk.livecommerce.promotionlist.base;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.livesdk.livecommerce.paging.ECPagedListAdapter;
import com.bytedance.android.livesdk.livecommerce.promotionlist.adapter.LivePromotionItemDiffCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/base/RecyclerViewWithHeaderAndFooterAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Lcom/bytedance/android/livesdk/livecommerce/paging/ECPagedListAdapter;", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class RecyclerViewWithHeaderAndFooterAdapter<T, VH extends RecyclerView.ViewHolder> extends ECPagedListAdapter<T, VH> {
    public static final /* synthetic */ int d = 0;
    public boolean b;
    public boolean c;

    public static final class a {
    }

    static {
    }

    public void A2(VH r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
    }

    public void onBindFooterViewHolder(VH r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
    }

    public abstract VH onCreateBasicViewHolder(ViewGroup r1, int r2);

    public VH onCreateFooterViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return null;
    }

    public VH onCreateHeaderViewHolder(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return null;
    }

    public abstract void z2(VH r1, int r2, List<Object> r3);

    public final int getItemCount() {
        int r0 = super.getItemCount();
        if (this.c == false) goto L6;
        r0 = r0 + 1;
    L6:
        if (this.b == true) goto L8;
        return r0;
    L8:
        return r0 + 1;
    }

    public RecyclerViewWithHeaderAndFooterAdapter(LivePromotionItemDiffCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "diffCallback");
        super(r2);
    }

    public final int getItemViewType(int r2) {
        if (this.c == false) goto L7;
        if (r2 != 0) goto L7;
        return Integer.MIN_VALUE;
    L7:
        if (this.b == true) goto L9;
    L11:
        return 0;
    L9:
        if (r2 < (getItemCount() - 1)) goto L11;
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

    public void onViewAttachedToWindow(VH r5) {
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

    public final void onBindViewHolder(VH r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        int r0 = getItemViewType(r4);
        if (r0 != Integer.MIN_VALUE) goto L5;
        A2(r3);
        return;
    L5:
        if (r0 == Integer.MAX_VALUE) goto L7;
        z2(r3, r4 - (this.c ? 1 : 0), null);
        return;
    L7:
        View r5 = ((RecyclerView.ViewHolder) r3).itemView;
        if (super.getItemCount() <= 0) goto L10;
        int r1 = 0;
    L11:
        r5.setVisibility(r1);
        onBindFooterViewHolder(r3);
        return;
    L10:
        r1 = 8;
        goto L11
    }

    public final VH onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        if (r3 != Integer.MIN_VALUE) goto L5;
        VH r4 = (VH) onCreateHeaderViewHolder(r2);
        Intrinsics.checkNotNull(r4);
        return r4;
    L5:
        if (r3 != Integer.MAX_VALUE) goto L10;
        VH r5 = (VH) onCreateFooterViewHolder(r2);
        Intrinsics.checkNotNull(r5);
        return r5;
    L10:
        return (VH) onCreateBasicViewHolder(r2, r3);
    }

    public final void onBindViewHolder(VH r3, int r4, List<Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r5, "payloads");
        int r0 = getItemViewType(r4);
        if (r0 != Integer.MIN_VALUE) goto L5;
        A2(r3);
        return;
    L5:
        if (r0 == Integer.MAX_VALUE) goto L7;
        z2(r3, r4 - (this.c ? 1 : 0), r5);
        return;
    L7:
        View r6 = ((RecyclerView.ViewHolder) r3).itemView;
        if (super.getItemCount() <= 0) goto L10;
        int r7 = 0;
    L11:
        r6.setVisibility(r7);
        onBindFooterViewHolder(r3);
        return;
    L10:
        r7 = 8;
        goto L11
    }
}
