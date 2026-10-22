package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PDFThumbnailItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final boolean c;

    public PDFThumbnailItemDecoration(int r2) {
        this.a = 3;
        this.b = r2;
        this.c = false;
    }

    public final void getItemOffsets(Rect r5, View r6, RecyclerView r7, RecyclerView.State r8) {
        if (this.a <= 0) goto L20;
        GridLayoutManager r9 = r7.getLayoutManager();
        int r10 = r7.getChildAdapterPosition(r6);
        if ((r9 instanceof GridLayoutManager) == false) goto L7;
        GridLayoutManager r11 = r9;
        int r12 = r11.getSpanSizeLookup().getSpanIndex(r10, this.a);
        int r13 = r11.getSpanSizeLookup().getSpanSize(r10);
    L8:
        boolean r1 = this.c;
        if (r1 == true) goto L11;
    L13:
        int r14 = this.b;
        int r3 = this.a;
        r5.left = r14 - ((r12 * r14) / r3);
        r5.right = ((r12 + 1) * r14) / r3;
    L14:
        if (r1 == false) goto L16;
    L18:
        r5.top = 0;
    L19:
        r5.bottom = this.b;
        return;
    L16:
        if (r10 >= this.a) goto L18;
        r5.top = this.b;
        goto L19
    L11:
        if (r13 != this.a) goto L13;
        r5.left = 0;
        r5.right = 0;
        goto L14
    L7:
        r12 = r10 % this.a;
        r13 = 0;
        goto L8
    L20:
        r5.setEmpty();
    }
}
