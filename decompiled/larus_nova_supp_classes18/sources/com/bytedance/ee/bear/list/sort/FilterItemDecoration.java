package com.bytedance.ee.bear.list.sort;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FilterItemDecoration extends RecyclerView.ItemDecoration {
    public FilterItemDecoration() {
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        super.getItemOffsets(r2, r3, r4, r5);
        if ((r4.getLayoutManager() instanceof GridLayoutManager) == true) goto L5;
        return;
    L5:
        if ((r4.getChildAdapterPosition(r3) % 2) != 0) goto L7;
        r2.set(0, n.d(12), n.d(6), 0);
        return;
    L7:
        r2.set(n.d(6), n.d(12), 0, 0);
    }
}
