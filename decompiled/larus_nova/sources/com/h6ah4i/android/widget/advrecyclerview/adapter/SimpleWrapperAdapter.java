package com.h6ah4i.android.widget.advrecyclerview.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import dw7.b;
import java.util.Collections;
import java.util.List;
import wv7.d;

/* JADX INFO: loaded from: classes23.dex */
public class SimpleWrapperAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements d<VH>, BridgeAdapterDataObserver.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Object> f276014b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.Adapter<VH> f276015a;

    public final boolean y2() {
        if (this.f276015a == null) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        f276014b = Collections.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (y2() == true) goto L7;
        return 0;
    L7:
        return this.f276015a.getItemCount();
    }

    public void z2() {
        notifyDataSetChanged();
    }

    public SimpleWrapperAdapter(RecyclerView.Adapter<VH> r100) {
        this.f276015a = r100;
        r100.registerAdapterDataObserver(new BridgeAdapterDataObserver(this, r100));
        super.setHasStableIds(r100.hasStableIds());
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.a
    public final void M(Object r100) {
        z2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r100) {
        return this.f276015a.getItemId(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r100) {
        return this.f276015a.getItemViewType(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        if (y2() == false) goto L6;
        this.f276015a.onAttachedToRecyclerView(r100);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        if (y2() == false) goto L6;
        this.f276015a.onDetachedFromRecyclerView(r100);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(VH r100) {
        return h1(r100, r100.getItemViewType());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(VH r100) {
        C1(r100, r100.getItemViewType());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(VH r100) {
        C(r100, r100.getItemViewType());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(VH r100) {
        E0(r100, r100.getItemViewType());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean r100) {
        super.setHasStableIds(r100);
        if (y2() == false) goto L6;
        this.f276015a.setHasStableIds(r100);
        return;
    }

    public void A2(int r100, int r101) {
        notifyItemRangeChanged(r100, r101);
    }

    @Override // wv7.c
    public final void C(VH r100, int r101) {
        if (y2() == false) goto L6;
        b.c(this.f276015a, r100, r101);
        return;
    }

    @Override // wv7.c
    public final void C1(VH r100, int r101) {
        if (y2() == false) goto L6;
        b.b(this.f276015a, r100, r101);
        return;
    }

    public void C2(int r100, int r101) {
        notifyItemRangeInserted(r100, r101);
    }

    public void D2(int r100, int r101) {
        notifyItemRangeRemoved(r100, r101);
    }

    public void E0(VH r100, int r101) {
        if (y2() == false) goto L6;
        b.d(this.f276015a, r100, r101);
        return;
    }

    @Override // wv7.c
    public final boolean h1(VH r100, int r101) {
        if (y2() == false) goto L5;
        boolean r102 = b.a(this.f276015a, r100, r101);
    L6:
        if (r102 == false) goto L10;
        return true;
    L10:
        return super.onFailedToRecycleView(r100);
    L5:
        r102 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(VH r100, int r101) {
        onBindViewHolder(r100, r101, f276014b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VH onCreateViewHolder(ViewGroup r100, int r101) {
        return (VH) this.f276015a.onCreateViewHolder(r100, r101);
    }

    @Override // wv7.d
    public void w1(wv7.b r100, int r101) {
        r100.f561598a = this.f276015a;
        r100.f561599b = r101;
    }

    public void B2(int r100, int r101, Object r102) {
        notifyItemRangeChanged(r100, r101, r102);
    }

    public void E2(int r100, int r101, int r102) {
        if (r102 != 1) goto L7;
        notifyItemMoved(r100, r101);
        return;
    L7:
        throw new IllegalStateException("itemCount should be always 1  (actual: " + r102 + ")");
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.a
    public final void U(Object r100, int r101, int r102) {
        C2(r101, r102);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.a
    public final void h0(Object r100, int r101, int r102) {
        D2(r101, r102);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.a
    public final void i0(Object r100, int r101, int r102) {
        A2(r101, r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VH r100, int r101, List<Object> r102) {
        if (y2() == false) goto L6;
        this.f276015a.onBindViewHolder(r100, r101, r102);
        return;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.a
    public final void B1(Object r100, int r101, int r102, int r103) {
        E2(r101, r102, r103);
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver.a
    public final void w2(Object r100, int r101, int r102, Object r103) {
        B2(r101, r102, r103);
    }
}
