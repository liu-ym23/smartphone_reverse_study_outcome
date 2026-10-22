package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes18.dex */
public class SwipeMenuLayout extends com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout {
    public SwipeMenuLayout(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 != 1) goto L5;
    L10:
        getParent().requestDisallowInterceptTouchEvent(false);
    L12:
        return super.onTouchEvent(r100);
    L5:
        if (r101 != 2) goto L7;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L12
    L7:
        if (r101 == 3) goto L10;
        goto L10
    }

    public SwipeMenuLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
        int r102 = com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a.f241670f;
        WikItemLeafView r103 = com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a.C3461a.a(this);
        if (r103 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        super.scrollTo(r100, r101);
        if (r104 == false) goto L12;
        requestLayout();
        return;
    L12:
        return;
    L5:
        if (r103.f242239r == false) goto L7;
        r104 = true;
        goto L8
    }

    public SwipeMenuLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
