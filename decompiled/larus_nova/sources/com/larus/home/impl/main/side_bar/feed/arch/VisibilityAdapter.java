package com.larus.home.impl.main.side_bar.feed.arch;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0001\u0015\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001f\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001cH\u0016J\u0018\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J(\u0010'\u001a\u00020\u001c2\u000e\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00012\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u001cH\u0016J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0010H\u0016J\u0010\u0010-\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0010H\u0016J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0002H\u0016J\u0010\u0010/\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0002H\u0016J\u0010\u00100\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0002H\u0016J\u0010\u00101\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0002H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016¨\u00062"}, d2 = {"Lcom/larus/home/impl/main/side_bar/feed/arch/VisibilityAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/home/impl/main/side_bar/feed/arch/FlowFeedAdapterWrapper;", "delegate", "visible", "", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Z)V", "getDelegate$annotations", "()V", "wrappedAdapter", "getWrappedAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "attachedRecyclerViews", "", "Landroidx/recyclerview/widget/RecyclerView;", "value", "isVisible", "()Z", "observer", "com/larus/home/impl/main/side_bar/feed/arch/VisibilityAdapter$observer$1", "Lcom/larus/home/impl/main/side_bar/feed/arch/VisibilityAdapter$observer$1;", "setVisible", "dispose", "", "updateStateRestorationPolicy", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "findRelativeAdapterPositionIn", "adapter", "viewHolder", "localPosition", "onAttachedToRecyclerView", "recyclerView", "onDetachedFromRecyclerView", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "onFailedToRecycleView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VisibilityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> f344583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<RecyclerView> f344584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f344585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final VisibilityAdapter$observer$1 f344586d;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (this.f344585c == true) goto L7;
        return 0;
    L7:
        return this.f344583a.getItemCount();
    }

    public final void z2() {
        if (this.f344585c == false) goto L5;
        RecyclerView.Adapter.StateRestorationPolicy r100 = this.f344583a.getStateRestorationPolicy();
    L6:
        setStateRestorationPolicy(r100);
        return;
    L5:
        r100 = RecyclerView.Adapter.StateRestorationPolicy.ALLOW;
        goto L6
    }

    @Override // com.larus.home.impl.main.side_bar.feed.arch.h
    public final RecyclerView.Adapter<?> getWrappedAdapter() {
        return this.f344583a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return this.f344583a.getItemId(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return this.f344583a.getItemViewType(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        if (this.f344584b.add(r100) == true) goto L5;
        return;
    L5:
        if (this.f344585c == false) goto L9;
        this.f344583a.onAttachedToRecyclerView(r100);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        if (this.f344584b.remove(r100) == true) goto L5;
        return;
    L5:
        if (this.f344585c == false) goto L9;
        this.f344583a.onDetachedFromRecyclerView(r100);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        return this.f344583a.onFailedToRecycleView(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f344583a.onViewAttachedToWindow(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f344583a.onViewDetachedFromWindow(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f344583a.onViewRecycled(r100);
    }

    public final boolean y2(boolean r100) {
        if (this.f344585c != r100) goto L6;
        return false;
    L6:
        if (r100 == false) goto L11;
        Set<RecyclerView> r101 = this.f344584b;
        RecyclerView.Adapter<RecyclerView.ViewHolder> r102 = this.f344583a;
        Iterator<T> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        r102.onAttachedToRecyclerView((RecyclerView) r103.next());
    L11:
        this.f344585c = r100;
        z2();
        notifyDataSetChanged();
        if (r100 == true) goto L17;
        Set<RecyclerView> r104 = this.f344584b;
        RecyclerView.Adapter<RecyclerView.ViewHolder> r105 = this.f344583a;
        Iterator<T> r106 = r104.iterator();
    L15:
        if (r106.hasNext() == false) goto L21;
        r105.onDetachedFromRecyclerView((RecyclerView) r106.next());
        goto L15
    L21:
        return true;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.recyclerview.widget.RecyclerView$AdapterDataObserver, com.larus.home.impl.main.side_bar.feed.arch.VisibilityAdapter$observer$1] */
    public VisibilityAdapter(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f344583a = r100;
        this.f344584b = new LinkedHashSet();
        this.f344585c = r101;
        ?? r102 = new VisibilityAdapter$observer$1(this);
        this.f344586d = r102;
        setHasStableIds(r100.hasStableIds());
        z2();
        r100.registerAdapterDataObserver(r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f344583a.bindViewHolder(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return this.f344583a.createViewHolder(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int findRelativeAdapterPositionIn(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r100, RecyclerView.ViewHolder r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        if (r100 != this) goto L6;
        return r102;
    L6:
        return this.f344583a.findRelativeAdapterPositionIn(r100, r101, r102);
    }
}
