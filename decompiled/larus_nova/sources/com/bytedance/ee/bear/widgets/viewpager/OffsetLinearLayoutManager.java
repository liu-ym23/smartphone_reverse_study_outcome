package com.bytedance.ee.bear.widgets.viewpager;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes18.dex */
public class OffsetLinearLayoutManager extends LinearLayoutManager {
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollOffset(RecyclerView.State r100) {
        if (getChildCount() != 0) goto L11;
        return 0;
    L11:
        int r101 = findFirstVisibleItemPosition();     // Catch: Exception -> L10
        int r102 = -((int) findViewByPosition(r101).getY());
        if (r101 > 0) goto L9;
        return r102;
    L9:
        throw null;     // Catch: Exception -> L10
    L10:
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutCompleted(RecyclerView.State r100) {
        super.onLayoutCompleted(r100);
        if (getChildCount() > 0) goto L5;
        return;
    L5:
        getChildAt(0).getHeight();
        throw null;
    }
}
