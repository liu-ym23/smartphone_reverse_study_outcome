package com.larus.home.impl.main.side_bar.feed.arch;

import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001\u001b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002>?B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001e0 ¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0 H\u0002J\b\u0010%\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020\u0011H\u0002J\b\u0010(\u001a\u00020\fH\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\fH\u0016J\u0010\u0010,\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fH\u0016J\u0018\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\fH\u0016J\u0018\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\fH\u0016J(\u00103\u001a\u00020\f2\u000e\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00012\u0006\u00105\u001a\u00020\u00022\u0006\u00106\u001a\u00020\fH\u0016J\u0010\u00107\u001a\u00020#2\u0006\u00108\u001a\u00020\u0014H\u0016J\u0010\u00109\u001a\u00020#2\u0006\u00108\u001a\u00020\u0014H\u0016J\u0010\u0010:\u001a\u00020#2\u0006\u00102\u001a\u00020\u0002H\u0016J\u0010\u0010;\u001a\u00020#2\u0006\u00102\u001a\u00020\u0002H\u0016J\u0010\u0010<\u001a\u00020#2\u0006\u00102\u001a\u00020\u0002H\u0016J\u0010\u0010=\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0017\u001a&\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00020\u0002 \u0018*\u0012\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00190\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006@"}, d2 = {"Lcom/larus/home/impl/main/side_bar/feed/arch/TransactionalAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/larus/home/impl/main/side_bar/feed/arch/FlowFeedAdapterWrapper;", "delegate", "Landroidx/recyclerview/widget/ConcatAdapter;", "<init>", "(Landroidx/recyclerview/widget/ConcatAdapter;)V", "wrappedAdapter", "getWrappedAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "transactionDepth", "", "hasPendingUpdate", "", "snapshotPublishPosted", "publishedSnapshot", "Lcom/larus/home/impl/main/side_bar/feed/arch/TransactionalAdapter$AdapterSnapshot;", "attachedRecyclerViews", "", "Landroidx/recyclerview/widget/RecyclerView;", "createdHolderViewTypes", "Ljava/util/WeakHashMap;", "boundHolders", "kotlin.jvm.PlatformType", "", "observer", "com/larus/home/impl/main/side_bar/feed/arch/TransactionalAdapter$observer$1", "Lcom/larus/home/impl/main/side_bar/feed/arch/TransactionalAdapter$observer$1;", "runTransaction", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "dispatchOrDefer", "", "dispatch", "publishPendingSnapshot", "scheduleSnapshotPublishAfterLayout", "captureSnapshot", "getItemCount", "getItemId", "", "position", "getItemViewType", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "findRelativeAdapterPositionIn", "adapter", "viewHolder", "localPosition", "onAttachedToRecyclerView", "recyclerView", "onDetachedFromRecyclerView", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "onFailedToRecycleView", "AdapterSnapshot", "AdapterItem", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransactionalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcatAdapter f344571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f344572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f344573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f344574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f344575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<RecyclerView> f344576f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final WeakHashMap<RecyclerView.ViewHolder, Integer> f344577g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<RecyclerView.ViewHolder> f344578h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView.Adapter<? extends RecyclerView.ViewHolder> f344579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f344580b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f344579a, r101.f344579a) == true) goto L12;
            return false;
        L12:
            if (this.f344580b == r101.f344580b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f344579a.hashCode() * 31) + this.f344580b;
        }

        public final String toString() {
            return "AdapterItem(owner=" + this.f344579a + ", viewType=" + this.f344580b + ')';
        }

        public a(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "owner");
            this.f344579a = r100;
            this.f344580b = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<a> f344581a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f344581a, ((b) r100).f344581a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f344581a.hashCode();
        }

        public final String toString() {
            return "AdapterSnapshot(items=" + this.f344581a + ')';
        }

        public b(List<a> r100) {
            Intrinsics.checkNotNullParameter(r100, "items");
            this.f344581a = r100;
        }
    }

    public final void A2() {
        if (this.f344573c == true) goto L5;
        return;
    L5:
        Set<RecyclerView> r100 = this.f344576f;
        if ((r100 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r101 = r100.iterator();
    L12:
        if (r101.hasNext() == false) goto L16;
        if (((RecyclerView) r101.next()).isComputingLayout() == false) goto L12;
        boolean r102 = true;
    L17:
        if (r102 == false) goto L20;
        C2();
        return;
    L20:
        this.f344573c = false;
        b r103 = z2();
        b r104 = this.f344575e;
        this.f344575e = r103;
        boolean r105 = !Intrinsics.areEqual(r104.f344581a, r103.f344581a);
        notifyDataSetChanged();
        if (r105 == false) goto L26;
        Iterator r106 = CollectionsKt.toList(this.f344576f).iterator();
    L24:
        if (r106.hasNext() == false) goto L31;
        j.a((RecyclerView) r106.next(), "flow_feed_transaction");
        goto L24
    L31:
        return;
    L26:
        return;
    L16:
        r102 = false;
        goto L17
    L8:
        if (r100.isEmpty() == false) goto L10;
        goto L10
    }

    public final void C2() {
        if (this.f344574d == false) goto L5;
        return;
    L5:
        Iterator<T> r100 = this.f344576f.iterator();
    L7:
        if (r100.hasNext() == false) goto L11;
        Object r101 = r100.next();
        if (((RecyclerView) r101).isComputingLayout() == false) goto L7;
    L12:
        RecyclerView r102 = (RecyclerView) r101;
        if (r102 != null) goto L15;
        return;
    L15:
        this.f344574d = true;
        r102.postOnAnimation(new x(this));
        return;
    L11:
        r101 = null;
        goto L12
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f344571a.getItemCount();
    }

    public final b z2() {
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> r100 = this.f344571a.getAdapters();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        RecyclerView.Adapter r103 = (RecyclerView.Adapter) r102.next();
        int r104 = r103.getItemCount();
        ArrayList r105 = new ArrayList(r104);
        int r106 = 0;
    L6:
        if (r106 >= r104) goto L8;
        Intrinsics.checkNotNull(r103);
        r105.add(new a(r103, r103.getItemViewType(r106)));
        r106 = r106 + 1;
        goto L6
    L8:
        CollectionsKt.addAll(r101, r105);
        goto L4
    L10:
        return new b(r101);
    }

    @Override // com.larus.home.impl.main.side_bar.feed.arch.h
    public final RecyclerView.Adapter<?> getWrappedAdapter() {
        return this.f344571a;
    }

    public TransactionalAdapter(ConcatAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f344571a = r100;
        this.f344575e = z2();
        this.f344576f = new LinkedHashSet();
        this.f344577g = new WeakHashMap();
        this.f344578h = Collections.newSetFromMap(new WeakHashMap());
        RecyclerView.AdapterDataObserver r101 = new TransactionalAdapter$observer$1(this);
        setHasStableIds(r100.hasStableIds());
        setStateRestorationPolicy(r100.getStateRestorationPolicy());
        r100.registerAdapterDataObserver(r101);
    }

    public final void B2(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        this.f344572b++;
        r100.invoke();     // Catch: Throwable -> L8
        int r101 = this.f344572b - 1;
        this.f344572b = r101;
        if (r101 != 0) goto L15;
        A2();
        return;
    L15:
        return;
    L8:
        th = move-exception;
        this.f344572b--;
        if (this.f344572b != 0) goto L12;
        A2();
    L12:
        throw th;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return this.f344571a.getItemId(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return this.f344571a.getItemViewType(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        if (this.f344576f.add(r100) == false) goto L6;
        this.f344571a.onAttachedToRecyclerView(r100);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        if (this.f344576f.remove(r100) == false) goto L6;
        this.f344571a.onDetachedFromRecyclerView(r100);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (this.f344578h.contains(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f344571a.onFailedToRecycleView(r100) == false) goto L7;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (this.f344578h.contains(r100) == false) goto L6;
        this.f344571a.onViewAttachedToWindow(r100);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (this.f344578h.contains(r100) == false) goto L6;
        this.f344571a.onViewDetachedFromWindow(r100);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (this.f344578h.remove(r100) == false) goto L6;
        this.f344571a.onViewRecycled(r100);
        return;
    }

    public static final void y2(TransactionalAdapter r100, Function0 r101) {
        if (r100.f344572b > 0) goto L19;
        Set<RecyclerView> r102 = r100.f344576f;
        if ((r102 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L15;
        if (((RecyclerView) r103.next()).isComputingLayout() == false) goto L11;
        boolean r104 = true;
    L16:
        if (r104 == true) goto L19;
        r101.invoke();
        r100.f344575e = r100.z2();
        return;
    L15:
        r104 = false;
        goto L16
    L7:
        if (r102.isEmpty() == false) goto L9;
    L19:
        r100.f344573c = true;
        r100.C2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f344578h.remove(r100);
        if (r101 >= 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        Object r103 = null;
        if (r102 == true) goto L32;
    L19:
        Integer r104 = this.f344577g.get(r100);
        if (r104 == null) goto L27;
        if (r103 == null) goto L27;
        if (Intrinsics.areEqual(r104, r103) == false) goto L27;
        this.f344571a.bindViewHolder(r100, r101);
        this.f344578h.add(r100);
        return;
    L27:
        int r105 = t.f344637a;
        t.a("stale_holder_blocked", "adapter=" + t.e(this) + " holder=" + t.e(r100) + " position=" + r101 + " items=" + this.f344571a.getItemCount() + " createdType=" + r104 + " expectedType=" + r103);
        Iterator r106 = CollectionsKt.toList(this.f344576f).iterator();
    L29:
        if (r106.hasNext() == false) goto L31;
        j.a((RecyclerView) r106.next(), "stale_holder_bind");
        goto L29
    L31:
        return;
    L32:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L12
        Object r108 = Result.m9449constructorimpl(Integer.valueOf(this.f344571a.getItemViewType(r101)));     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r108) == true) goto L18;
        r103 = r108;
    L18:
        r103 = (Integer) r103;
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L5:
        if (r101 >= this.f344571a.getItemCount()) goto L7;
        r102 = true;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        RecyclerView.ViewHolder r102 = this.f344571a.createViewHolder(r100, r101);
        Integer r103 = Integer.valueOf(r101);
        this.f344577g.put(r102, r103);
        return r102;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int findRelativeAdapterPositionIn(RecyclerView.Adapter<? extends RecyclerView.ViewHolder> r100, RecyclerView.ViewHolder r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        if (r100 != this) goto L6;
        return r102;
    L6:
        return this.f344571a.findRelativeAdapterPositionIn(r100, r101, r102);
    }
}
