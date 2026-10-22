package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes16.dex */
public class InterceptTouchEventLinearLayout extends LinearLayout {
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return true;
    }

    public InterceptTouchEventLinearLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
