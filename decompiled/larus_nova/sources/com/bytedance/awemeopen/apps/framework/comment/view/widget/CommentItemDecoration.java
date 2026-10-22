package com.bytedance.awemeopen.apps.framework.comment.view.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes14.dex */
public class CommentItemDecoration extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        r100.save();
        if (r101.getClipToPadding() == false) goto L5;
        r100.clipRect(r101.getPaddingLeft() + 0, r101.getPaddingTop(), (r101.getWidth() - r101.getPaddingRight()) - 0, r101.getHeight() - r101.getPaddingBottom());
    L7:
        if ((r101.getChildCount() - 1) > 0) goto L10;
        r100.restore();
        return;
    L10:
        r101.getDecoratedBoundsWithMargins(r101.getChildAt(0), null);
        throw null;
    L5:
        r101.getWidth();
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        throw null;
    }
}
