package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiBottomDecoration extends RecyclerView.ItemDecoration {
    public final int a;

    public WikiBottomDecoration(int r1) {
        this.a = r1;
    }

    public final void getItemOffsets(Rect r3, View r4, RecyclerView r5, RecyclerView.State r6) {
        super.getItemOffsets(r3, r4, r5, r6);
        BaseQuickAdapter r7 = r5.getAdapter();
        if (r7 != null) goto L6;
        return;
    L6:
        if (r4 != r7.getHeaderLayout()) goto L8;
        return;
    L8:
        boolean r0 = true;
        if (r5.getChildAdapterPosition(r4) == (r7.getItemCount() - 1)) goto L12;
        r0 = false;
    L12:
        if (r0 == false) goto L14;
        r3.bottom = r5.getResources().getDimensionPixelSize(this.a);
        return;
    L14:
        r3.bottom = 0;
    }
}
