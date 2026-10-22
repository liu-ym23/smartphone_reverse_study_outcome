package com.bytedance.ee.bear.widgets.viewpager;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OffsetLinearLayoutManager extends LinearLayoutManager {
    public final int computeVerticalScrollOffset(RecyclerView.State r3) {
        if (getChildCount() != 0) goto L11;
        return 0;
    L11:
        int r4 = findFirstVisibleItemPosition();     // Catch: Exception -> L10
        int r1 = -((int) findViewByPosition(r4).getY());
        if (r4 > 0) goto L9;
        return r1;
    L9:
        throw null;     // Catch: Exception -> L10
    L10:
        return 0;
    }

    public final void onLayoutCompleted(RecyclerView.State r1) {
        super.onLayoutCompleted(r1);
        if (getChildCount() > 0) goto L5;
        return;
    L5:
        getChildAt(0).getHeight();
        throw null;
    }
}
