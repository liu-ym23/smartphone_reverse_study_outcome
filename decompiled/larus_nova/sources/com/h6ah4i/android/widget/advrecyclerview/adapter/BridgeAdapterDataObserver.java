package com.h6ah4i.android.widget.advrecyclerview.adapter;

import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes23.dex */
public class BridgeAdapterDataObserver extends RecyclerView.AdapterDataObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<a> f276011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<RecyclerView.Adapter> f276012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f276013c;

    public interface a {
        void B1(Object r100, int r101, int r102, int r103);

        void M(Object r100);

        void U(Object r100, int r101, int r102);

        void h0(Object r100, int r101, int r102);

        void i0(Object r100, int r101, int r102);

        void w2(Object r100, int r101, int r102, Object r103);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onChanged() {
        a r100 = this.f276011a.get();
        RecyclerView.Adapter r101 = this.f276012b.get();
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        r100.M(this.f276013c);
        return;
    L8:
        return;
    }

    public BridgeAdapterDataObserver(SimpleWrapperAdapter r100, RecyclerView.Adapter r101) {
        this.f276011a = new WeakReference(r100);
        this.f276012b = new WeakReference(r101);
        this.f276013c = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int r100, int r101) {
        a r102 = this.f276011a.get();
        RecyclerView.Adapter r103 = this.f276012b.get();
        if (r102 == null) goto L7;
        if (r103 == null) goto L8;
        r102.i0(this.f276013c, r100, r101);
        return;
    L8:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeInserted(int r100, int r101) {
        a r102 = this.f276011a.get();
        RecyclerView.Adapter r103 = this.f276012b.get();
        if (r102 == null) goto L7;
        if (r103 == null) goto L8;
        r102.U(this.f276013c, r100, r101);
        return;
    L8:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeRemoved(int r100, int r101) {
        a r102 = this.f276011a.get();
        RecyclerView.Adapter r103 = this.f276012b.get();
        if (r102 == null) goto L7;
        if (r103 == null) goto L8;
        r102.h0(this.f276013c, r100, r101);
        return;
    L8:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeChanged(int r100, int r101, Object r102) {
        a r103 = this.f276011a.get();
        RecyclerView.Adapter r104 = this.f276012b.get();
        if (r103 == null) goto L7;
        if (r104 == null) goto L8;
        r103.w2(this.f276013c, r100, r101, r102);
        return;
    L8:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
    public final void onItemRangeMoved(int r100, int r101, int r102) {
        a r103 = this.f276011a.get();
        RecyclerView.Adapter r104 = this.f276012b.get();
        if (r103 == null) goto L7;
        if (r104 == null) goto L8;
        r103.B1(this.f276013c, r100, r101, r102);
        return;
    L8:
        return;
    }
}
