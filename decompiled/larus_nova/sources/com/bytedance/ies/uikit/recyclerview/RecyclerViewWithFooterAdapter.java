package com.bytedance.ies.uikit.recyclerview;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes19.dex */
public abstract class RecyclerViewWithFooterAdapter extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f249106a;

    public abstract int getBasicItemCount();

    public abstract void onBindBasicViewHolder(RecyclerView.ViewHolder r100, int r101);

    public abstract void onBindFooterViewHolder(RecyclerView.ViewHolder r100);

    public abstract RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r100, int r101);

    public abstract RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r100);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.f249106a == false) goto L6;
        return getBasicItemCount() + 1;
    L6:
        return getBasicItemCount();
    }

    public RecyclerViewWithFooterAdapter() {
        this.f249106a = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (this.f249106a == true) goto L5;
        return 0;
    L5:
        if (r100 != getBasicItemCount()) goto L10;
        return Integer.MIN_VALUE;
    L10:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        if (getItemViewType(r101) != Integer.MIN_VALUE) goto L5;
        onBindFooterViewHolder(r100);
        return;
    L5:
        onBindBasicViewHolder(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        if (Integer.MIN_VALUE != r101) goto L7;
        return onCreateFooterViewHolder(r100);
    L7:
        return onCreateBasicViewHolder(r100, r101);
    }
}
