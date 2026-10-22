package com.bytedance.ee.bear.bizwidget.banner.itemdecoraion;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes16.dex */
public class MarginDecoration extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        RecyclerView.LayoutManager r104 = r102.getLayoutManager();
        if ((r104 instanceof LinearLayoutManager) == false) goto L10;
        if (((LinearLayoutManager) r104).getOrientation() != 1) goto L7;
        r100.top = 0;
        r100.bottom = 0;
        return;
    L7:
        r100.left = 0;
        r100.right = 0;
        return;
    L10:
        throw new IllegalStateException("The layoutManager must be LinearLayoutManager");
    }
}
