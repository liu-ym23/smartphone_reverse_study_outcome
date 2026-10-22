package com.bytedance.ee.bear.wikiv2.wikitreev2.scroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemRootView;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiDividerDecoration extends RecyclerView.ItemDecoration {
    public final Drawable a;
    public final Rect b;

    public WikiDividerDecoration(Context r2) {
        this.b = new Rect();
        this.a = n.k(r2, 2131256614);
    }

    public final void onDraw(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
        if (r11.getLayoutManager() != null) goto L5;
        return;
    L5:
        if (this.a == null) goto L47;
        r10.save();
        if (r11.getClipToPadding() == false) goto L10;
        int r13 = r11.getPaddingLeft();
        int r1 = r11.getWidth() - r11.getPaddingRight();
        r10.clipRect(r13, r11.getPaddingTop(), r1, r11.getHeight() - r11.getPaddingBottom());
    L11:
        int r2 = r11.getChildCount();
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L41;
        View r4 = r11.getChildAt(r3);
        r11.getDecoratedBoundsWithMargins(r4, this.b);
        View r5 = r4.findViewById(2131374270);
        if (r5 == null) goto L16;
        r13 = r4.getLeft() + r5.getPaddingLeft();
    L16:
        int r6 = this.b.bottom + Math.round(r4.getTranslationY());
        int r7 = r6 - this.a.getIntrinsicHeight();
        int r8 = r2 - 1;
        if (r3 != r8) goto L19;
        r7 = r4.getBottom();
        r6 = r4.getBottom() + this.a.getIntrinsicHeight();
    L19:
        this.a.setBounds(r13, r7, r1, r6);
        if (r3 >= r8) goto L22;
        View r9 = r11.getChildAt(r3 + 1);
    L24:
        if ((r4 instanceof WikItemLeafView) == false) goto L28;
        if (((WikItemLeafView) r4).r == false) goto L28;
    L31:
        boolean r14 = false;
    L34:
        if ((r4 instanceof WikItemRootView) == true) goto L36;
    L38:
        if (r14 == false) goto L40;
        this.a.draw(r10);
    L40:
        r3 = r3 + 1;
        goto L12
    L36:
        if (((WikItemRootView) r4).u == false) goto L38;
        r14 = false;
    L28:
        if ((r9 instanceof WikItemLeafView) == true) goto L30;
    L32:
        r14 = true;
        goto L34
    L30:
        if (((WikItemLeafView) r9).r == false) goto L32;
    L22:
        r9 = null;
        goto L24
    L41:
        r10.restore();
        return;
    L10:
        r1 = r11.getWidth();
        r13 = 0;
        goto L11
    }

    public final void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        Drawable r5 = this.a;
        if (r5 != null) goto L6;
        r1.set(0, 0, 0, 0);
        return;
    L6:
        r1.set(0, 0, 0, r5.getIntrinsicHeight());
    }
}
