package com.bytedance.ee.bear.bizwidget.banner.itemdecoraion;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class MarginDecoration extends RecyclerView.ItemDecoration {
    public final void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        LinearLayoutManager r5 = r3.getLayoutManager();
        if ((r5 instanceof LinearLayoutManager) == false) goto L10;
        if (r5.getOrientation() != 1) goto L7;
        r1.top = 0;
        r1.bottom = 0;
        return;
    L7:
        r1.left = 0;
        r1.right = 0;
        return;
    L10:
        throw new IllegalStateException("The layoutManager must be LinearLayoutManager");
    }
}
