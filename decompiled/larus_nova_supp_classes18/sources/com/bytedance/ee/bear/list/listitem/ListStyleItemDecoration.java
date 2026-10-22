package com.bytedance.ee.bear.list.listitem;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ListStyleItemDecoration extends RecyclerView.ItemDecoration {
    public boolean a;

    public ListStyleItemDecoration() {
    }

    public final void getItemOffsets(Rect r3, View r4, RecyclerView r5, RecyclerView.State r6) {
        super.getItemOffsets(r3, r4, r5, r6);
        int r7 = r5.getChildAdapterPosition(r4);
        if (r5.getAdapter().getItemViewType(r7) != 273) goto L5;
        return;
    L5:
        Resources r8 = r5.getResources();
        boolean r0 = true;
        int r1 = 0;
        if (r7 == (r5.getAdapter().getItemCount() - 1)) goto L9;
        r0 = false;
    L9:
        int r9 = r8.getDimensionPixelSize(2131167706);
        if (r0 == true) goto L12;
    L14:
        r3.bottom = r1;
        return;
    L12:
        if (this.a == true) goto L14;
        r1 = r9;
        goto L14
    }
}
