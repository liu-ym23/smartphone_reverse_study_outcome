package com.bytedance.ee.bear.bitable.homepage.chart.widget.chart;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes15.dex */
public class LynxUIContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f212686a;

    public LynxUIContainer(Context r100) {
        super(r100);
        this.f212686a = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.f212686a == true) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r100);
    }

    public void setEnableDispatchTouchEvent(boolean r100) {
        this.f212686a = r100;
    }

    public LynxUIContainer(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f212686a = true;
    }

    public LynxUIContainer(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f212686a = true;
    }
}
