package com.ss.android.lark.reaction.widget.panel.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes37.dex */
public class ReactionSlideLinearLayout extends LinearLayout {
    public ReactionSlideLinearLayout(Context r100) {
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 == 0) goto L9;
        if (r101 != 1) goto L6;
    L8:
        getParent().requestDisallowInterceptTouchEvent(false);
    L11:
        return super.dispatchTouchEvent(r100);
    L6:
        if (r101 == 3) goto L8;
    L9:
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L11
    }

    public ReactionSlideLinearLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public ReactionSlideLinearLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
