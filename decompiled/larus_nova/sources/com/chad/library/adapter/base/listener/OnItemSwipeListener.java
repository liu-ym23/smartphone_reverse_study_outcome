package com.chad.library.adapter.base.listener;

import android.graphics.Canvas;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes22.dex */
public interface OnItemSwipeListener {
    void clearView(RecyclerView.ViewHolder r100, int r101);

    void onItemSwipeMoving(Canvas r100, RecyclerView.ViewHolder r101, float r102, float r103, boolean r104);

    void onItemSwipeStart(RecyclerView.ViewHolder r100, int r101);

    void onItemSwiped(RecyclerView.ViewHolder r100, int r101);
}
