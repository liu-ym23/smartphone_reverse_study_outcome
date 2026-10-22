package com.ss.android.lark.widget.photopicker.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes38.dex */
public class HoverEventDisallowConstraintLayout extends ConstraintLayout {
    @Override // android.view.ViewGroup
    public final boolean onInterceptHoverEvent(MotionEvent r100) {
        return true;
    }

    public HoverEventDisallowConstraintLayout(Context r100) {
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchHoverEvent(MotionEvent r100) {
        return super.dispatchHoverEvent(r100);
    }

    public HoverEventDisallowConstraintLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public HoverEventDisallowConstraintLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
