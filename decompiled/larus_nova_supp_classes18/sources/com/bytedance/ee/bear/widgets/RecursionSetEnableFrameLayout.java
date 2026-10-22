package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class RecursionSetEnableFrameLayout extends FrameLayout {
    public RecursionSetEnableFrameLayout(Context r1) {
        super(r1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r1) {
        a(this, r1);
    }

    public RecursionSetEnableFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public final void a(View r3, boolean r4) {
        if (r3 != this) goto L4;
        super.setEnabled(r4);
    L6:
        if ((r3 instanceof ViewGroup) == false) goto L11;
        ViewGroup r5 = (ViewGroup) r3;
        int r0 = 0;
    L9:
        if (r0 >= r5.getChildCount()) goto L13;
        a(r5.getChildAt(r0), r4);
        r0 = r0 + 1;
        goto L9
    L13:
        return;
    L11:
        return;
    L4:
        r3.setEnabled(r4);
        goto L6
    }

    public RecursionSetEnableFrameLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
