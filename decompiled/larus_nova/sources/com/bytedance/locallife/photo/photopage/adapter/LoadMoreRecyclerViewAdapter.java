package com.bytedance.locallife.photo.photopage.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes21.dex */
public abstract class LoadMoreRecyclerViewAdapter extends RecyclerViewWithFooterAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f262153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GridLayoutManager.SpanSizeLookup f262154b;

    @Override // com.bytedance.locallife.photo.photopage.adapter.RecyclerViewWithFooterAdapter
    public int getBasicItemCount() {
        return 0;
    }

    @Override // com.bytedance.locallife.photo.photopage.adapter.RecyclerViewWithFooterAdapter
    public void onBindBasicViewHolder(RecyclerView.ViewHolder r100, int r101) {
    }

    @Override // com.bytedance.locallife.photo.photopage.adapter.RecyclerViewWithFooterAdapter
    public RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup r100, int r101) {
        return null;
    }

    public LoadMoreRecyclerViewAdapter() {
        this.f262153a = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        super.onAttachedToRecyclerView(r100);
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if ((r101 instanceof GridLayoutManager) == false) goto L8;
        GridLayoutManager.SpanSizeLookup r102 = this.f262154b;
        if (r102 == null) goto L9;
        ((GridLayoutManager) r101).setSpanSizeLookup(r102);
        return;
    L9:
        return;
    }
}
