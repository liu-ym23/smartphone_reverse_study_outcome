package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SwipeMenuLayout extends com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout {
    public SwipeMenuLayout(Context r1) {
        super(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r4) {
        int r0 = r4.getAction();
        if (r0 != 1) goto L5;
    L10:
        getParent().requestDisallowInterceptTouchEvent(false);
    L12:
        return super/*android.view.ViewGroup*/.onTouchEvent(r4);
    L5:
        if (r0 != 2) goto L7;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L12
    L7:
        if (r0 == 3) goto L10;
        goto L10
    }

    public SwipeMenuLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void scrollTo(int r2, int r3) {
        int r0 = com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a.f;
        WikItemLeafView r1 = com.bytedance.ee.bear.wikiv2.wikitreev2.scroll.a.C0214a.a(this);
        if (r1 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        super/*android.view.ViewGroup*/.scrollTo(r2, r3);
        if (r4 == false) goto L12;
        requestLayout();
        return;
    L12:
        return;
    L5:
        if (r1.r == false) goto L7;
        r4 = true;
        goto L8
    }

    public SwipeMenuLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
