package com.bytedance.ee.bear.widget.statusbar;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class StatusBarView extends View {
    public final int a;

    public StatusBarView(Context r2) {
        this(r2, null);
    }

    public StatusBarView(Context r3, AttributeSet r4) {
        super(r3, r4);
        Resources r5 = r3.getResources();
        int r6 = r5.getIdentifier("status_bar_height", "dimen", "android");
        if (r6 <= 0) goto L5;
        int r7 = r5.getDimensionPixelSize(r6);
    L6:
        this.a = r7;
        return;
    L5:
        r7 = 0;
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        setMeasuredDimension(View.MeasureSpec.getSize(r1), this.a);
    }
}
