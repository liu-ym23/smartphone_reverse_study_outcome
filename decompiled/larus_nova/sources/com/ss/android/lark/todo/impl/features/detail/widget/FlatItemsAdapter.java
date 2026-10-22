package com.ss.android.lark.todo.impl.features.detail.widget;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002-.B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00002\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001J\u0012\u0010\u0007\u001a\u00020\u00002\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0001J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0016J\u0014\u0010'\u001a\u00020\u00112\n\u0010(\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0002J\u0014\u0010)\u001a\u00020\u000e2\n\u0010(\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0002J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010\u0013\u001a\u00020\u001eH\u0002R\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/widget/FlatItemsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/todo/impl/features/detail/widget/FlatItemsAdapter$WrapHolder;", "<init>", "()V", "insertHead", "adapter", "pushBack", "adapterList", "Ljava/util/LinkedList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "getItemId", "", "onViewDetachedFromWindow", "onViewAttachedToWindow", "onViewRecycled", "getItemViewType", "maskOriginType", "adapterPos", "type", "unmaskOriginType", "", "maskType", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "registerAdapterDataObserver", "observer", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onDetachedFromRecyclerView", "wrapAndSetDataObserver", "targetAdapter", "computeItemOffset", "mapPositionToRealPosition", "validPosition", "", "Companion", "WrapHolder", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlatItemsAdapter extends RecyclerView.Adapter<WrapHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<RecyclerView.Adapter<?>> f443909a;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/widget/FlatItemsAdapter$WrapHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "containerHolder", "originAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "getContainerHolder", "()Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getOriginAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "onViewDetachedFromWindow", "", "onViewAttachedToWindow", "onViewRecycled", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WrapHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView.ViewHolder f443910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RecyclerView.Adapter<RecyclerView.ViewHolder> f443911b;

        public WrapHolder(RecyclerView.ViewHolder r100, RecyclerView.Adapter<RecyclerView.ViewHolder> r101) {
            Intrinsics.checkNotNullParameter(r100, "containerHolder");
            Intrinsics.checkNotNullParameter(r101, "originAdapter");
            super(r100.itemView);
            this.f443910a = r100;
            this.f443911b = r101;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        Iterator<T> r100 = this.f443909a.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + ((RecyclerView.Adapter) r100.next()).getItemCount();
        goto L4
    L6:
        return r101;
    }

    public FlatItemsAdapter() {
        this.f443909a = new LinkedList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        int[] r101 = y2(r100);
        return this.f443909a.get(r101[0]).getItemId(r101[1]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        int[] r101 = y2(r100);
        if (r101[0] != (-1)) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        return -1;
    L10:
        int[] r103 = y2(r100);
        int r104 = r103[0];
        int r105 = r103[1];
        return r104 << (this.f443909a.get(r104).getItemViewType(r105) + 28);
    L5:
        if (r101[1] == (-1)) goto L7;
        r102 = true;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        Iterator<T> r101 = this.f443909a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((RecyclerView.Adapter) r101.next()).onAttachedToRecyclerView(r100);
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onDetachedFromRecyclerView(r100);
        Iterator<T> r101 = this.f443909a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((RecyclerView.Adapter) r101.next()).onDetachedFromRecyclerView(r100);
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        WrapHolder r101 = (WrapHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewAttachedToWindow(r101);
        r101.f443911b.onViewAttachedToWindow(r101.f443910a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        WrapHolder r101 = (WrapHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewDetachedFromWindow(r101);
        r101.f443911b.onViewDetachedFromWindow(r101.f443910a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        WrapHolder r101 = (WrapHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewRecycled(r101);
        r101.f443911b.onViewRecycled(r101.f443910a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void registerAdapterDataObserver(RecyclerView.AdapterDataObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        boolean r101 = hasStableIds();
        Iterator<T> r102 = this.f443909a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101 = r101 | ((RecyclerView.Adapter) r102.next()).hasStableIds();
        goto L4
    L6:
        setHasStableIds(r101);
        Iterator<T> r103 = this.f443909a.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        final RecyclerView.Adapter r104 = (RecyclerView.Adapter) r103.next();
        r104.registerAdapterDataObserver(new FlatItemsAdapter$wrapAndSetDataObserver$observer$1(this, this, r104));
        goto L8
    L10:
        super.registerAdapterDataObserver(r100);
    }

    public final int[] y2(int r100) {
        if (r100 >= getItemCount()) goto L17;
        if (r100 < 0) goto L17;
        Iterator<T> r101 = this.f443909a.iterator();
        int r102 = 0;
    L8:
        if (r101.hasNext() == false) goto L15;
        int r103 = ((RecyclerView.Adapter) r101.next()).getItemCount();
        if (r103 > r100) goto L12;
        r100 = r100 - r103;
        r102 = r102 + 1;
        goto L8
    L12:
        return new int[]{r102, r100};
    L15:
        return new int[]{r102, r100};
    L17:
        return new int[]{-1, -1};
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        WrapHolder r102 = (WrapHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        RecyclerView.ViewHolder r103 = r102.f443910a;
        r102.f443911b.onBindViewHolder(r103, y2(r101)[1]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        int r102 = ((-268435456) & r101) >>> 28;
        int[] r103 = {r102, r101 & 268435455};
        RecyclerView.Adapter<?> r104 = this.f443909a.get(r102);
        return new WrapHolder(r104.onCreateViewHolder(r100, r103[1]), r104);
    }
}
