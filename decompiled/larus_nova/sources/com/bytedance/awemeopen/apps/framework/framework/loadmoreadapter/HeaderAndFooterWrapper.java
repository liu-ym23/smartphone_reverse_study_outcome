package com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter;

import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import androidx.exifinterface.media.ExifInterface;
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

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/loadmoreadapter/HeaderAndFooterWrapper;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class HeaderAndFooterWrapper<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.Adapter<T> f196966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<c> f196967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<c> f196968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseArrayCompat<c> f196969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SparseArrayCompat<c> f196970e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f196971f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HeaderAndFooterWrapper$mInnerObserver$1 f196972g;

    public final int y2() {
        return this.f196967b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return (y2() + this.f196968c.size()) + this.f196966a.getItemCount();
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.HeaderAndFooterWrapper$mInnerObserver$1] */
    public HeaderAndFooterWrapper(CommentListAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "innerAdapter");
        this.f196966a = r100;
        this.f196967b = new ArrayList();
        this.f196968c = new ArrayList();
        this.f196969d = new SparseArrayCompat();
        this.f196970e = new SparseArrayCompat();
        this.f196971f = new d();
        this.f196972g = new HeaderAndFooterWrapper$mInnerObserver$1(this);
        setHasStableIds(r100.hasStableIds());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        boolean r101 = true;
        int r102 = 0;
        if (r100 >= y2()) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        ((c) ListProtector.get(this.f196967b, r100)).getClass();
    L16:
        return r102;
    L9:
        if (r100 >= (y2() + this.f196966a.getItemCount())) goto L12;
        r101 = false;
    L12:
        if (r101 == false) goto L14;
        ((c) ListProtector.get(this.f196968c, (r100 - y2()) - this.f196966a.getItemCount())).getClass();
        goto L16
    L14:
        r102 = this.f196966a.getItemViewType(r100 - y2());
        if (z2(r102) == false) goto L16;
        throw new IllegalArgumentException("HeaderAndFooterWrapper use the viewType between 100000 and 110000");
    L5:
        r103 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f196966a.onAttachedToRecyclerView(r100);
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if ((r101 instanceof GridLayoutManager) == false) goto L6;
        final GridLayoutManager r102 = (GridLayoutManager) r101;
        final GridLayoutManager.SpanSizeLookup r103 = r102.getSpanSizeLookup();
        r102.setSpanSizeLookup(new AnonymousClass1(this, r102, r103));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        this.f196966a.onDetachedFromRecyclerView(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (z2(r100.getItemViewType()) == false) goto L6;
        return super.onFailedToRecycleView(r100);
    L6:
        return this.f196966a.onFailedToRecycleView(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (z2(r100.getItemViewType()) == false) goto L7;
        ViewGroup.LayoutParams r101 = r100.itemView.getLayoutParams();
        if ((r101 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L9;
        ((StaggeredGridLayoutManager.LayoutParams) r101).setFullSpan(true);
        return;
    L9:
        return;
    L7:
        this.f196966a.onViewAttachedToWindow(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (z2(r100.getItemViewType()) == false) goto L5;
        super.onViewDetachedFromWindow(r100);
        return;
    L5:
        this.f196966a.onViewDetachedFromWindow(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (z2(r100.getItemViewType()) == false) goto L5;
        super.onViewRecycled(r100);
        return;
    L5:
        this.f196966a.onViewRecycled(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void registerAdapterDataObserver(RecyclerView.AdapterDataObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        super.registerAdapterDataObserver(r100);
        this.f196966a.registerAdapterDataObserver(this.f196972g);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        super.unregisterAdapterDataObserver(r100);
        this.f196966a.unregisterAdapterDataObserver(this.f196972g);
    }

    public final boolean z2(int r100) {
        this.f196971f.getClass();
        if (100000 <= r100) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= 110001) goto L7;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        boolean r102 = true;
        if (r101 >= y2()) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        return;
    L9:
        if (r101 >= (y2() + this.f196966a.getItemCount())) goto L12;
        r102 = false;
    L12:
        if (r102 == false) goto L14;
        return;
    L14:
        this.f196966a.onBindViewHolder(r100, r101 - y2());
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        c r102 = this.f196969d.get(r101);
        if (r102 != null) goto L5;
        r102 = this.f196970e.get(r101);
    L5:
        if (r102 == null) goto L7;
        return r102;
    L7:
        return this.f196966a.onCreateViewHolder(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        boolean r103 = true;
        if (r101 >= y2()) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L9;
        return;
    L9:
        if (r101 >= (y2() + this.f196966a.getItemCount())) goto L12;
        r103 = false;
    L12:
        if (r103 == false) goto L14;
        return;
    L14:
        this.f196966a.onBindViewHolder(r100, r101 - y2(), r102);
        return;
    L5:
        r104 = false;
        goto L6
    }
}
