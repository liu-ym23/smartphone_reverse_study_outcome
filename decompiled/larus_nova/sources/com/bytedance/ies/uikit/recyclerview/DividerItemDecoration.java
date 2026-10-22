package com.bytedance.ies.uikit.recyclerview;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes19.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        r101.getPaddingTop();
        r101.getHeight();
        r101.getPaddingBottom();
        if ((r101.getChildCount() - 1) > 0) goto L5;
        return;
    L5:
        View r103 = r101.getChildAt(0);
        RecyclerView.LayoutParams r104 = (RecyclerView.LayoutParams) r103.getLayoutParams();
        r103.getRight();
        int r105 = ((ViewGroup.MarginLayoutParams) r104).rightMargin;
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        r102.getChildAdapterPosition(r101);
        throw null;
    }
}
