package com.bytedance.ee.bear.drive.common.mvpframeworks.app.recyclerview;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    public final void getItemOffsets(Rect r4, View r5, RecyclerView r6, RecyclerView.State r7) {
        int r8 = r6.getChildAdapterPosition(r5);
        GridLayoutManager r9 = r6.getLayoutManager();
        if ((r9 instanceof GridLayoutManager) == false) goto L6;
        int r10 = r9.getSpanCount();
    L9:
        int r0 = r8 % r10;
        GridLayoutManager r11 = r6.getLayoutManager();
        if ((r11 instanceof GridLayoutManager) == false) goto L13;
        int r12 = r11.getOrientation();
    L17:
        if (r12 != 1) goto L21;
        r4.left = (r0 * 0) / r10;
        r4.right = 0 - (((r0 + 1) * 0) / r10);
        if (r8 < r10) goto L25;
        r4.top = 0;
        return;
    L25:
        return;
    L21:
        r4.top = (r0 * 0) / r10;
        r4.bottom = 0 - (((r0 + 1) * 0) / r10);
        if (r8 < r10) goto L27;
        r4.left = 0;
        return;
    L27:
        return;
    L13:
        if ((r11 instanceof StaggeredGridLayoutManager) == false) goto L15;
        r12 = ((StaggeredGridLayoutManager) r11).getOrientation();
        goto L17
    L15:
        r12 = 1;
        goto L17
    L6:
        if ((r9 instanceof StaggeredGridLayoutManager) == false) goto L8;
        r10 = ((StaggeredGridLayoutManager) r9).getSpanCount();
        goto L9
    L8:
        r10 = -1;
        goto L9
    }
}
