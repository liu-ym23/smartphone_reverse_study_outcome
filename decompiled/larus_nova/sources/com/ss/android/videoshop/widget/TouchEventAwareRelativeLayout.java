package com.ss.android.videoshop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes40.dex */
public class TouchEventAwareRelativeLayout extends RelativeLayout {
    public TouchEventAwareRelativeLayout(Context r100) {
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        return super.dispatchTouchEvent(r100);
    L4:
        return false;
    }

    public TouchEventAwareRelativeLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public TouchEventAwareRelativeLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
