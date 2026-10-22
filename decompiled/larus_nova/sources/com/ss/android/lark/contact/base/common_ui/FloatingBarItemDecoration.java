package com.ss.android.lark.contact.base.common_ui;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes35.dex */
public class FloatingBarItemDecoration extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        super.onDraw(r100, r101, r102);
        r101.getPaddingLeft();
        r101.getWidth();
        r101.getPaddingRight();
        if (r101.getChildCount() > 0) goto L5;
        return;
    L5:
        ((RecyclerView.LayoutParams) r101.getChildAt(0).getLayoutParams()).getViewAdapterPosition();
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        super.onDrawOver(r100, r101, r102);
        int r103 = ((LinearLayoutManager) r101.getLayoutManager()).findFirstVisibleItemPosition();
        if (r103 != (-1)) goto L5;
        return;
    L5:
        View r104 = r101.findViewHolderForAdapterPosition(r103).itemView;
        if (r103 >= 0) goto L9;
        return;
    L9:
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        super.getItemOffsets(r100, r101, r102, r103);
        ((RecyclerView.LayoutParams) r101.getLayoutParams()).getViewAdapterPosition();
        throw null;
    }
}
