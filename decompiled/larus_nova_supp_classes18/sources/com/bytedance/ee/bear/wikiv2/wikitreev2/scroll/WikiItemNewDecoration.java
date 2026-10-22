package com.bytedance.ee.bear.wikiv2.wikitreev2.scroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiItemNewDecoration extends RecyclerView.ItemDecoration {
    public final Drawable a;
    public final Drawable b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final a h;

    public interface a {
        boolean a(WikItemLeafView r1, int r2);
    }

    public WikiItemNewDecoration(Context r4, Rect r5, a r6) {
        this.c = 20;
        this.d = 8;
        this.e = 8;
        this.f = 14;
        this.g = 14;
        this.a = l.a(r4, 2131253548, 2131102419);
        this.b = new ColorDrawable(r4.getResources().getColor(2131100548));
        this.h = r6;
        if (r5 == null) goto L5;
        this.e = r5.left;
        this.f = r5.top;
        this.d = r5.right;
        this.g = r5.bottom;
    L5:
        this.c = 20;
    }

    public final void onDrawOver(Canvas r11, RecyclerView r12, RecyclerView.State r13) {
        r11.save();
        int r14 = r12.getChildCount();
        int r0 = 0;
    L3:
        if (r0 >= r14) goto L10;
        View r1 = r12.getChildAt(r0);
        int r2 = r12.getChildAdapterPosition(r1);
        if ((r1 instanceof WikItemLeafView) == false) goto L9;
        if (this.h.a((WikItemLeafView) r1, r2) == false) goto L9;
        SwipeMenuLayout r3 = r1.findViewById(2131387820);
        View r4 = (View) r12.getParent();
        int r5 = r4.getRight();
        int r6 = r4.getScrollX();
        this.b.setBounds((((r5 - r3.getScrollX()) + r6) - n.d(this.c)) - n.d(this.e), r1.getTop(), (r5 - r3.getScrollX()) + r6, r1.getBottom());
        this.a.setBounds((((r5 - r3.getScrollX()) + r6) - n.d(this.c)) - n.d(this.d), r1.getTop() + n.d(this.f), ((r5 - r3.getScrollX()) + r6) - n.d(this.d), r1.getBottom() - n.d(this.g));
        this.b.draw(r11);
        this.a.draw(r11);
    L9:
        r0 = r0 + 1;
        goto L3
    L10:
        r11.restore();
    }
}
