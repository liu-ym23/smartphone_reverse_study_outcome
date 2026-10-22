package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes18.dex */
public class RecursionSetEnableFrameLayout extends FrameLayout {
    public RecursionSetEnableFrameLayout(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        a(this, r100);
    }

    public RecursionSetEnableFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public final void a(View r100, boolean r101) {
        if (r100 != this) goto L4;
        super.setEnabled(r101);
    L6:
        if ((r100 instanceof ViewGroup) == false) goto L11;
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = 0;
    L9:
        if (r103 >= r102.getChildCount()) goto L13;
        a(r102.getChildAt(r103), r101);
        r103 = r103 + 1;
        goto L9
    L13:
        return;
    L11:
        return;
    L4:
        r100.setEnabled(r101);
        goto L6
    }

    public RecursionSetEnableFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
