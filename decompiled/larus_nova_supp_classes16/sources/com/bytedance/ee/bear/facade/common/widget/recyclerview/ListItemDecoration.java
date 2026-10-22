package com.bytedance.ee.bear.facade.common.widget.recyclerview;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ListItemDecoration extends RecyclerView.ItemDecoration {
    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        RecyclerView.Adapter r6 = r4.getAdapter();
        if (r6 != null) goto L5;
        return;
    L5:
        int r7 = r6.getItemCount();
        int r8 = r4.getChildAdapterPosition(r3);
        if (r7 != 1) goto L8;
        r3.setBackground(null);
        return;
    L8:
        if (r8 != 0) goto L11;
        r3.setBackground(null);
        return;
    L11:
        if (r8 != (r7 - 1)) goto L13;
        r3.setBackground(null);
        return;
    L13:
        r3.setBackground(null);
    }
}
