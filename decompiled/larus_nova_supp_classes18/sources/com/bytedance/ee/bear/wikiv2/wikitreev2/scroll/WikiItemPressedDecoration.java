package com.bytedance.ee.bear.wikiv2.wikitreev2.scroll;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiItemPressedDecoration extends RecyclerView.ItemDecoration {
    public final int a;

    public WikiItemPressedDecoration(Context r2) {
        this.a = r2.getResources().getDimensionPixelOffset(2131168174) * 2;
    }

    public final void onDrawOver(Canvas r5, RecyclerView r6, RecyclerView.State r7) {
        int r8 = r6.getChildCount();
        View r9 = (View) r6.getParent();
        if (r9 != null) goto L6;
        tt5.a.k("WikiItemPressedDecoration", "onDrawOver fail, parent is null");
        return;
    L6:
        WikiTreeView.WikiAdapter r1 = r6.getAdapter();
        if ((r1 instanceof WikiTreeView.WikiAdapter) == true) goto L10;
        tt5.a.k("WikiItemPressedDecoration", "onDrawOver fail, adapter not wikiAdapter");
        return;
    L10:
        int r10 = r9.getScrollX();
        ViewGroup r0 = (ViewGroup) r1.d.findViewById(2131393268);
        int r2 = 0;
        if (r0 == null) goto L13;
        int r3 = r0.getWidth();
    L14:
        int r4 = r3 - this.a;
    L15:
        if (r2 >= r8) goto L20;
        if ((r6.getChildAt(r2) instanceof WikItemLeafView) == false) goto L19;
        WikItemLeafView r11 = (WikItemLeafView) r6.getChildAt(r2);
        r11.getBackgroundView().b(r11, r4, r10);
    L19:
        r2 = r2 + 1;
        goto L15
    L20:
        return;
    L13:
        r3 = 0;
        goto L14
    }
}
