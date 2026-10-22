package com.bytedance.ee.bear.drive.common.mvpframeworks.app.recyclerview;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    public final void onDraw(Canvas r1, RecyclerView r2, RecyclerView.State r3) {
        r2.getPaddingTop();
        r2.getHeight();
        r2.getPaddingBottom();
        if (r2.getChildCount() > 0) goto L5;
        return;
    L5:
        View r4 = r2.getChildAt(0);
        RecyclerView.LayoutParams r5 = r4.getLayoutParams();
        r4.getRight();
        int r6 = ((ViewGroup.MarginLayoutParams) r5).rightMargin;
        throw null;
    }

    public final void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        r1.set(0, 0, 0, 0);
    }
}
