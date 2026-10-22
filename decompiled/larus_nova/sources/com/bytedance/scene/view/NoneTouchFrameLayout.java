package com.bytedance.scene.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes19.dex */
public class NoneTouchFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f268862a;

    public NoneTouchFrameLayout(Context r100) {
        super(r100);
        this.f268862a = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.f268862a == true) goto L7;
        return false;
    L7:
        return super.dispatchTouchEvent(r100);
    }

    public void setTouchEnabled(boolean r100) {
        this.f268862a = r100;
    }

    public NoneTouchFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f268862a = true;
    }

    public NoneTouchFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f268862a = true;
    }
}
