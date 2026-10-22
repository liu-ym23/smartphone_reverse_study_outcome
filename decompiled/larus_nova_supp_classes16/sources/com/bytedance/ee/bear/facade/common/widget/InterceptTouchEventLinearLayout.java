package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class InterceptTouchEventLinearLayout extends LinearLayout {
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return true;
    }

    public InterceptTouchEventLinearLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
