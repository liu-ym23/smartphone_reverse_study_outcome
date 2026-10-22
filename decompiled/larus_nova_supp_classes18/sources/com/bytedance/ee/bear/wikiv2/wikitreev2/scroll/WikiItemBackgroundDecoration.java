package com.bytedance.ee.bear.wikiv2.wikitreev2.scroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiItemBackgroundDecoration extends RecyclerView.ItemDecoration {
    public final Drawable a;

    public WikiItemBackgroundDecoration(Context r2) {
        this.a = n.k(r2, 2131256610);
        n.k(r2, 2131256611);
    }

    public final void onDrawOver(Canvas r9, RecyclerView r10, RecyclerView.State r11) {
        r9.save();
        int r12 = r10.getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r12) goto L13;
        View r1 = r10.getChildAt(r0);
        if ((r1 instanceof WikItemLeafView) == false) goto L12;
        SwipeMenuLayout r2 = r1.findViewById(2131387820);
        View r3 = (View) r10.getParent();
        int r4 = r3.getRight();
        int r5 = r3.getScrollX();
        if (((WikItemLeafView) r1).r == false) goto L12;
        if (r2.getScrollX() <= 0) goto L11;
        this.a.setBounds(r1.getLeft() + r5, r1.getTop(), ((r4 - r2.getScrollX()) + r5) - n.d(8), r1.getBottom());
        this.a.draw(r9);
        goto L12
    L11:
        this.a.setBounds(r1.getLeft() + r5, r1.getTop(), (r4 - r2.getScrollX()) + r5, r1.getBottom());
        this.a.draw(r9);
    L12:
        r0 = r0 + 1;
        goto L3
    L13:
        r9.restore();
    }
}
