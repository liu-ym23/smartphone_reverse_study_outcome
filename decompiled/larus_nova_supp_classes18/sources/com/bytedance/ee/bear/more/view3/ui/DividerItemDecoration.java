package com.bytedance.ee.bear.more.view3.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;
    public final Paint d;

    public DividerItemDecoration(int r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = 0;
        Paint r4 = new Paint();
        this.d = r4;
        r4.setColor(r3);
    }

    public final void onDrawOver(Canvas r13, RecyclerView r14, RecyclerView.State r15) {
        int r16 = r14.getChildCount();
        int r0 = 0;
    L4:
        if (r0 >= (r16 - 1)) goto L6;
        View r1 = r14.getChildAt(r0);
        int r2 = r1.getBottom() - this.a;
        int r3 = r1.getBottom();
        int r4 = r1.getLeft() + this.b;
        int r5 = r1.getRight() - this.c;
        int r6 = (int) (r1.getTranslationY() + 0.5f);
        r13.save();
        r13.drawRect(r4, r2 + r6, r5, r3 + r6, this.d);
        r13.restore();
        r0 = r0 + 1;
        goto L4
    }
}
