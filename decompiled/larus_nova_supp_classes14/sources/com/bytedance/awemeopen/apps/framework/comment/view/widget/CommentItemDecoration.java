package com.bytedance.awemeopen.apps.framework.comment.view.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class CommentItemDecoration extends RecyclerView.ItemDecoration {
    public final void onDraw(Canvas r6, RecyclerView r7, RecyclerView.State r8) {
        r6.save();
        if (r7.getClipToPadding() == false) goto L5;
        r6.clipRect(r7.getPaddingLeft() + 0, r7.getPaddingTop(), (r7.getWidth() - r7.getPaddingRight()) - 0, r7.getHeight() - r7.getPaddingBottom());
    L7:
        if ((r7.getChildCount() - 1) > 0) goto L10;
        r6.restore();
        return;
    L10:
        r7.getDecoratedBoundsWithMargins(r7.getChildAt(0), null);
        throw null;
    L5:
        r7.getWidth();
        goto L7
    }

    public final void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        throw null;
    }
}
