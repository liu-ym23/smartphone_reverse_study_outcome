package com.bytedance.scene.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes19.dex */
public final class AnimationContainerLayout extends FrameLayout {
    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        return false;
    }

    public AnimationContainerLayout(Context r100) {
        super(r100);
    }

    public AnimationContainerLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public AnimationContainerLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
