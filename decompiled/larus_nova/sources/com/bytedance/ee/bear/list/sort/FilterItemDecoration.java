package com.bytedance.ee.bear.list.sort;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: classes18.dex */
public class FilterItemDecoration extends RecyclerView.ItemDecoration {
    public FilterItemDecoration() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        super.getItemOffsets(r100, r101, r102, r103);
        if ((r102.getLayoutManager() instanceof GridLayoutManager) == true) goto L5;
        return;
    L5:
        if ((r102.getChildAdapterPosition(r101) % 2) != 0) goto L7;
        r100.set(0, n.d(12), n.d(6), 0);
        return;
    L7:
        r100.set(n.d(6), n.d(12), 0, 0);
    }
}
