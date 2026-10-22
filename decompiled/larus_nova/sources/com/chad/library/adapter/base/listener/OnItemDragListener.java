package com.chad.library.adapter.base.listener;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes22.dex */
public interface OnItemDragListener {
    void onItemDragEnd(RecyclerView.ViewHolder r100, int r101);

    void onItemDragMoving(RecyclerView.ViewHolder r100, int r101, RecyclerView.ViewHolder r102, int r103);

    void onItemDragStart(RecyclerView.ViewHolder r100, int r101);
}
