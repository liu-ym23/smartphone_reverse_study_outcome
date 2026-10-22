package com.ss.android.lark.desktopmode.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes35.dex */
public class DrawerContainerView extends FrameLayout {
    public DrawerContainerView(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent r100) {
        if ((r100.getSource() & 2) == 0) goto L12;
        if (r100.getButtonState() != 2) goto L7;
    L10:
        return true;
    L7:
        if (r100.getAction() == 8) goto L10;
        return super.onGenericMotionEvent(r100);
    L12:
        return super.onGenericMotionEvent(r100);
    }

    public DrawerContainerView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public DrawerContainerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
