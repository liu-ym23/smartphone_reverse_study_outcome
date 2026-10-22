package com.chad.library.adapter.base.listener;

import android.graphics.Canvas;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes22.dex */
public interface IDraggableListener {
    boolean hasToggleView();

    boolean isItemDraggable();

    boolean isItemSwipeEnable();

    void onItemDragEnd(RecyclerView.ViewHolder r100);

    void onItemDragMoving(RecyclerView.ViewHolder r100, RecyclerView.ViewHolder r101);

    void onItemDragStart(RecyclerView.ViewHolder r100);

    void onItemSwipeClear(RecyclerView.ViewHolder r100);

    void onItemSwipeStart(RecyclerView.ViewHolder r100);

    void onItemSwiped(RecyclerView.ViewHolder r100);

    void onItemSwiping(Canvas r100, RecyclerView.ViewHolder r101, float r102, float r103, boolean r104);
}
