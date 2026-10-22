package com.larksuite.framework.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: loaded from: classes24.dex */
public class StableNestedScrollView extends NestedScrollView {
    public StableNestedScrollView(Context r100) {
        super(r100);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return super.onInterceptTouchEvent(r100);
    L4:
        e = move-exception;
        e.getMessage();
        e.printStackTrace();
        return false;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return super.onTouchEvent(r100);
    L4:
        e = move-exception;
        e.getMessage();
        e.printStackTrace();
        return false;
    }

    public StableNestedScrollView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public StableNestedScrollView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
