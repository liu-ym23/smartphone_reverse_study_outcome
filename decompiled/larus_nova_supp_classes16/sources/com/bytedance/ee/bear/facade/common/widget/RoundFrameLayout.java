package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RoundFrameLayout extends FrameLayout {
    public final float[] a;
    public final Path b;
    public final RectF c;
    public final int d;
    public boolean e;
    public boolean f;

    public RoundFrameLayout(Context r2) {
        this(r2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r2) {
        if (this.e == false) goto L5;
        r2.save();
        r2.clipPath(this.b);
    L5:
        super.dispatchDraw(r2);
        if (this.e == false) goto L9;
        r2.restore();
        return;
    }

    @Override // android.view.View
    public final void draw(Canvas r2) {
        if (this.f == false) goto L5;
        r2.save();
        r2.clipPath(this.b);
    L5:
        super.draw(r2);
        if (this.f == false) goto L9;
        r2.restore();
        return;
    }

    public RoundFrameLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public RoundFrameLayout(Context r13, AttributeSet r14, int r16) {
        super(r13, r14, r16);
        this.a = new float[8];
        this.b = new Path();
        this.c = new RectF();
        int r17 = com.bytedance.ee.util.ui.n.d(8);
        this.d = r17;
        this.e = false;
        this.f = true;
        TypedArray r18 = r13.obtainStyledAttributes(r14, new int[]{2130969006, 2130969007, 2130969008, 2130969009, 2130969010, 2130969011, 2130969012, 2130969013, 2130969018, 2130969020, 2130969022, 2130969033, 2130969035, 2130969056, 2130969057, 2130973712, 2130973919, 2130974626, 2130974627});
        boolean r2 = r18.hasValue(15);
        boolean r4 = r18.hasValue(17);
        boolean r6 = r18.hasValue(18);
        boolean r8 = r18.hasValue(13);
        boolean r10 = r18.hasValue(14);
        if (r2 == false) goto L5;
        r17 = r18.getDimensionPixelOffset(15, r17);
    L5:
        float r19 = r17;
        int r110 = 0;
    L6:
        float[] r3 = this.a;
        if (r110 >= r3.length) goto L9;
        r3[r110] = r19;
        r110 = r110 + 1;
        goto L6
    L9:
        if (r4 == false) goto L11;
        r3[0] = r18.getDimensionPixelSize(17, this.d);
        this.a[1] = r18.getDimensionPixelSize(17, this.d);
    L11:
        if (r6 == false) goto L13;
        this.a[2] = r18.getDimensionPixelSize(18, this.d);
        this.a[3] = r18.getDimensionPixelSize(18, this.d);
    L13:
        if (r10 == false) goto L15;
        this.a[4] = r18.getDimensionPixelSize(14, this.d);
        this.a[5] = r18.getDimensionPixelSize(14, this.d);
    L15:
        if (r8 == false) goto L17;
        this.a[6] = r18.getDimensionPixelSize(13, this.d);
        this.a[7] = r18.getDimensionPixelSize(13, this.d);
    L17:
        r18.recycle();
    }

    public final void a(int r3, int r4, int r5, int r6) {
        float[] r0 = this.a;
        float r7 = r3;
        r0[0] = r7;
        r0[1] = r7;
        float r8 = r4;
        r0[2] = r8;
        r0[3] = r8;
        float r9 = r5;
        r0[4] = r9;
        r0[5] = r9;
        float r10 = r6;
        r0[6] = r10;
        r0[7] = r10;
        invalidate();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        RectF r6 = this.c;
        r6.left = 0.0f;
        r6.top = 0.0f;
        r6.right = getWidth();
        this.c.bottom = getHeight();
        this.b.rewind();
        this.b.addRoundRect(this.c, this.a, Path.Direction.CW);
    }
}
