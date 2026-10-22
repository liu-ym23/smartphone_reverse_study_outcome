package com.bytedance.ee.bear.facade.common.widget.recyclerview;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes16.dex */
public class ListItemDecoration extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        RecyclerView.Adapter r104 = r102.getAdapter();
        if (r104 != null) goto L5;
        return;
    L5:
        int r105 = r104.getItemCount();
        int r106 = r102.getChildAdapterPosition(r101);
        if (r105 != 1) goto L8;
        r101.setBackground(null);
        return;
    L8:
        if (r106 != 0) goto L11;
        r101.setBackground(null);
        return;
    L11:
        if (r106 != (r105 - 1)) goto L13;
        r101.setBackground(null);
        return;
    L13:
        r101.setBackground(null);
    }
}
