package com.bytedance.ies.uikit.layout;

import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes19.dex */
public class SafeViewLayout extends FrameLayout {
    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        Looper.getMainLooper();
        Looper.myLooper();
        super.requestLayout();
    }

    public SafeViewLayout(Context r100) {
        super(r100);
    }

    public SafeViewLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ViewParent invalidateChildInParent(int[] r100, Rect r101) {
        Looper.getMainLooper();
        Looper.myLooper();
        return super.invalidateChildInParent(r100, r101);
    }

    public SafeViewLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
