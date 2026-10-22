package com.bytedance.ee.bear.drive.common.mvpframeworks.app.recyclerview;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: loaded from: classes16.dex */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        int r104 = r102.getChildAdapterPosition(r101);
        RecyclerView.LayoutManager r105 = r102.getLayoutManager();
        if ((r105 instanceof GridLayoutManager) == false) goto L6;
        int r106 = ((GridLayoutManager) r105).getSpanCount();
    L9:
        int r107 = r104 % r106;
        RecyclerView.LayoutManager r108 = r102.getLayoutManager();
        if ((r108 instanceof GridLayoutManager) == false) goto L13;
        int r109 = ((GridLayoutManager) r108).getOrientation();
    L17:
        if (r109 != 1) goto L21;
        r100.left = (r107 * 0) / r106;
        r100.right = 0 - (((r107 + 1) * 0) / r106);
        if (r104 < r106) goto L25;
        r100.top = 0;
        return;
    L25:
        return;
    L21:
        r100.top = (r107 * 0) / r106;
        r100.bottom = 0 - (((r107 + 1) * 0) / r106);
        if (r104 < r106) goto L27;
        r100.left = 0;
        return;
    L27:
        return;
    L13:
        if ((r108 instanceof StaggeredGridLayoutManager) == false) goto L15;
        r109 = ((StaggeredGridLayoutManager) r108).getOrientation();
        goto L17
    L15:
        r109 = 1;
        goto L17
    L6:
        if ((r105 instanceof StaggeredGridLayoutManager) == false) goto L8;
        r106 = ((StaggeredGridLayoutManager) r105).getSpanCount();
        goto L9
    L8:
        r106 = -1;
        goto L9
    }
}
