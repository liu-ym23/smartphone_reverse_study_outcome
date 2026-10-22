package com.bytedance.locallife.photo.photopage.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes21.dex */
public abstract class RecyclerViewWithFooterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public abstract int getBasicItemCount();

    public int getBasicItemViewType(int r100) {
        return 0;
    }

    public abstract void onBindBasicViewHolder(RecyclerView.ViewHolder r100, int r101);

    public abstract RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r100, int r101);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return getBasicItemCount() + 0;
    }

    public RecyclerViewWithFooterAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return getBasicItemViewType(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        if (r101 >= getBasicItemCount()) goto L6;
        onBindBasicViewHolder(r100, r101);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        if (r101 != 1) goto L7;
        return null;
    L7:
        return onCreateBasicViewHolder(r100, r101);
    }
}
