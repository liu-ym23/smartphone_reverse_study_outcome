package com.ss.android.ugc.aweme.search.common.list.base;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes40.dex */
public abstract class RecyclerViewWithFooterAdapter extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f451687a;

    public abstract int getBasicItemCount();

    public int getBasicItemViewType(int r100) {
        return 0;
    }

    public abstract void onBindBasicViewHolder(RecyclerView.ViewHolder r100, int r101);

    public abstract void onBindFooterViewHolder(RecyclerView.ViewHolder r100);

    public abstract RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r100, int r101);

    public abstract RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup r100);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.f451687a == false) goto L6;
        return getBasicItemCount() + 1;
    L6:
        return getBasicItemCount();
    }

    public RecyclerViewWithFooterAdapter() {
        this.f451687a = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (this.f451687a == false) goto L9;
        if (r100 != getBasicItemCount()) goto L9;
        return Integer.MIN_VALUE;
    L9:
        return getBasicItemViewType(r100);
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
