package com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter;

import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.awemeopen.apps.framework.comment.view.CommentListAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import e04.c;
import e04.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/loadmoreadapter/HeaderAndFooterWrapper;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class HeaderAndFooterWrapper<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final RecyclerView.Adapter<T> a;
    public final ArrayList<c> b;
    public final ArrayList<c> c;
    public final SparseArrayCompat<c> d;
    public final SparseArrayCompat<c> e;
    public final d f;
    public final HeaderAndFooterWrapper$mInnerObserver$1 g;

    public final int y2() {
        return this.b.size();
    }

    public final int getItemCount() {
        return (y2() + this.c.size()) + this.a.getItemCount();
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.HeaderAndFooterWrapper$mInnerObserver$1] */
    public HeaderAndFooterWrapper(CommentListAdapter r2) {
        Intrinsics.checkNotNullParameter(r2, "innerAdapter");
        this.a = r2;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new SparseArrayCompat();
        this.e = new SparseArrayCompat();
        this.f = new d();
        this.g = new HeaderAndFooterWrapper$mInnerObserver$1(this);
        setHasStableIds(r2.hasStableIds());
    }

    public final int getItemViewType(int r5) {
        boolean r1 = true;
        int r2 = 0;
        if (r5 >= y2()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        ((c) ListProtector.get(this.b, r5)).getClass();
    L16:
        return r2;
    L9:
        if (r5 >= (y2() + this.a.getItemCount())) goto L12;
        r1 = false;
    L12:
        if (r1 == false) goto L14;
        ((c) ListProtector.get(this.c, (r5 - y2()) - this.a.getItemCount())).getClass();
        goto L16
    L14:
        r2 = this.a.getItemViewType(r5 - y2());
        if (z2(r2) == false) goto L16;
        throw new IllegalArgumentException("HeaderAndFooterWrapper use the viewType between 100000 and 110000");
    L5:
        r0 = false;
        goto L6
    }

    public final void onAttachedToRecyclerView(RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        this.a.onAttachedToRecyclerView(r3);
        GridLayoutManager r4 = r3.getLayoutManager();
        if ((r4 instanceof GridLayoutManager) == false) goto L6;
        final GridLayoutManager r5 = r4;
        final GridLayoutManager.SpanSizeLookup r0 = r5.getSpanSizeLookup();
        r5.setSpanSizeLookup(new AnonymousClass1(this, r5, r0));
        return;
    }

    public final void onDetachedFromRecyclerView(RecyclerView r2) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        this.a.onDetachedFromRecyclerView(r2);
    }

    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        if (z2(r2.getItemViewType()) == false) goto L6;
        return super.onFailedToRecycleView(r2);
    L6:
        return this.a.onFailedToRecycleView(r2);
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        if (z2(r2.getItemViewType()) == false) goto L7;
        StaggeredGridLayoutManager.LayoutParams r3 = r2.itemView.getLayoutParams();
        if ((r3 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L9;
        r3.setFullSpan(true);
        return;
    L9:
        return;
    L7:
        this.a.onViewAttachedToWindow(r2);
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        if (z2(r2.getItemViewType()) == false) goto L5;
        super.onViewDetachedFromWindow(r2);
        return;
    L5:
        this.a.onViewDetachedFromWindow(r2);
    }

    public final void onViewRecycled(RecyclerView.ViewHolder r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        if (z2(r2.getItemViewType()) == false) goto L5;
        super.onViewRecycled(r2);
        return;
    L5:
        this.a.onViewRecycled(r2);
    }

    public final void registerAdapterDataObserver(RecyclerView.AdapterDataObserver r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        super.registerAdapterDataObserver(r2);
        this.a.registerAdapterDataObserver(this.g);
    }

    public final void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        super.unregisterAdapterDataObserver(r2);
        this.a.unregisterAdapterDataObserver(this.g);
    }

    public final boolean z2(int r2) {
        this.f.getClass();
        if (100000 <= r2) goto L5;
    L7:
        return false;
    L5:
        if (r2 >= 110001) goto L7;
        return true;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        boolean r1 = true;
        if (r6 >= y2()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        if (r6 >= (y2() + this.a.getItemCount())) goto L12;
        r1 = false;
    L12:
        if (r1 == false) goto L14;
        return;
    L14:
        this.a.onBindViewHolder(r5, r6 - y2());
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        c r0 = (c) this.d.get(r3);
        if (r0 != null) goto L5;
        r0 = (c) this.e.get(r3);
    L5:
        if (r0 == null) goto L7;
        return r0;
    L7:
        return this.a.onCreateViewHolder(r2, r3);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6, List<Object> r7) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r7, "payloads");
        boolean r1 = true;
        if (r6 >= y2()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        if (r6 >= (y2() + this.a.getItemCount())) goto L12;
        r1 = false;
    L12:
        if (r1 == false) goto L14;
        return;
    L14:
        this.a.onBindViewHolder(r5, r6 - y2(), r7);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
