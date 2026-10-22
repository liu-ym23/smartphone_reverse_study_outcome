package com.bytedance.ee.bear.middleground.comment.audio;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes18.dex */
public class MotionFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f230291a;

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b r100 = this.f230291a;
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    public MotionFrameLayout(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f230291a != null) goto L5;
        return true;
    L5:
        if (isEnabled() == false) goto L10;
        this.f230291a.d(r100);
        return true;
    L10:
        return true;
    }

    public void setMotionCallbackListener(b r100) {
        this.f230291a = r100;
    }

    public MotionFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public MotionFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
