package com.bytedance.ee.bear.document.toolbar.selectcolor.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectColorDecoration extends RecyclerView.ItemDecoration {
    public View a;
    public final Bitmap b;
    public final int c;
    public final int d;

    public SelectColorDecoration(Context r3) {
        Resources r4 = r3.getResources();
        int r0 = r4.getDimensionPixelSize(2131168462);
        this.c = r4.getDimensionPixelSize(2131168461);
        this.d = r4.getDimensionPixelSize(2131168464);
        Bitmap r5 = BitmapFactory.decodeResource(r4, 2131247808);
        this.b = r5;
        this.b = Bitmap.createScaledBitmap(r5, r0, r0, true);
    }

    public final void onDraw(Canvas r3, RecyclerView r4, RecyclerView.State r5) {
        View r6 = this.a;
        if (r6 == null) goto L6;
        int r7 = r6.getLeft();
        int r8 = this.a.getTop();
        r3.drawBitmap(this.b, r7 - ((this.b.getWidth() - this.a.getWidth()) / 2), r8 - ((this.b.getHeight() - this.a.getHeight()) / 2), null);
        return;
    }

    public final void getItemOffsets(Rect r3, View r4, RecyclerView r5, RecyclerView.State r6) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getLayoutParams() == null) goto L29;
        int r7 = r5.getChildAdapterPosition(r4);
        int r8 = r5.getLayoutManager().getSpanCount();
        boolean r0 = true;
        int r1 = 0;
        if ((r7 % r8) != 0) goto L9;
        boolean r9 = true;
    L10:
        if (r9 == false) goto L12;
        int r10 = this.c;
    L13:
        r3.left = r10;
        if ((r7 / r8) != 0) goto L16;
        boolean r11 = true;
    L17:
        if (r11 == false) goto L19;
        int r12 = this.d;
    L20:
        r3.top = r12;
        if (((r7 + 1) % r8) == 0) goto L24;
        r0 = false;
    L24:
        if (r0 == false) goto L26;
        r1 = this.c;
    L26:
        r3.right = r1;
        r3.bottom = this.d;
        return;
    L19:
        r12 = 0;
        goto L20
    L16:
        r11 = false;
        goto L17
    L12:
        r10 = 0;
        goto L13
    L9:
        r9 = false;
        goto L10
    }
}
