package com.bytedance.ee.bear.widgets;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s {
    public final View a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;

    public s(View r4, AttributeSet r5) {
        this.b = -1;
        this.c = -1;
        this.d = true;
        this.e = true;
        this.a = r4;
        if (r5 == null) goto L6;
        TypedArray r6 = r4.getContext().obtainStyledAttributes(r5, new int[]{2130972696, 2130972706});
        this.b = r6.getDimensionPixelSize(1, -1);
        this.c = r6.getDimensionPixelSize(0, -1);
        r6.recycle();
        return;
    }

    public static int a(int r2, boolean r3, int r4) {
        int r0 = View.MeasureSpec.getMode(r2);
        int r1 = View.MeasureSpec.getSize(r2);
        if (r3 == false) goto L15;
        if (r4 >= 0) goto L6;
        return r2;
    L6:
        if (r0 != Integer.MIN_VALUE) goto L10;
        return View.MeasureSpec.makeMeasureSpec(Math.min(r4, r1), Integer.MIN_VALUE);
    L10:
        if (r0 != 1073741824) goto L14;
        return View.MeasureSpec.makeMeasureSpec(Math.min(r4, r1), 1073741824);
    L14:
        return View.MeasureSpec.makeMeasureSpec(r4, Integer.MIN_VALUE);
    L15:
        return r2;
    }
}
