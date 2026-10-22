package com.bytedance.ee.bear.bitable.common.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes15.dex */
public class SwipeMenuLayout extends com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout {
    public SwipeMenuLayout(Context r100) {
        super(r100);
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        boolean r101 = super.dispatchTouchEvent(r100);
        if (getSwipeEnable() == true) goto L5;
    L7:
        int r102 = r100.getAction();
        if (r102 == 1) goto L19;
        if (r102 == 2) goto L15;
        if (r102 == 3) goto L19;
    L22:
        return r101;
    L15:
        if (this.f226695h == false) goto L22;
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L19:
        if (this.f226695h == false) goto L22;
        getParent().requestDisallowInterceptTouchEvent(false);
        return true;
    L5:
        if (r100.getAction() != 0) goto L7;
        this.f226696i = false;
        goto L7
    }

    public SwipeMenuLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public SwipeMenuLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
