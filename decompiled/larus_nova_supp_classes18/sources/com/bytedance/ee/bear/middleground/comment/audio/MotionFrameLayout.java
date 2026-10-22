package com.bytedance.ee.bear.middleground.comment.audio;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MotionFrameLayout extends FrameLayout {
    public b a;

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b r0 = this.a;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    public MotionFrameLayout(Context r1) {
        super(r1);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        if (this.a != null) goto L5;
        return true;
    L5:
        if (isEnabled() == false) goto L10;
        this.a.d(r2);
        return true;
    L10:
        return true;
    }

    public void setMotionCallbackListener(b r1) {
        this.a = r1;
    }

    public MotionFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public MotionFrameLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
