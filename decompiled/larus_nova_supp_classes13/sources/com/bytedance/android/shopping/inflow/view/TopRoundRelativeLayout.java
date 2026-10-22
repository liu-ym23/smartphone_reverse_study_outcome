package com.bytedance.android.shopping.inflow.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class TopRoundRelativeLayout extends RelativeLayout {
    public int a;
    public g b;

    public TopRoundRelativeLayout(Context r2) {
        this(r2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r2) {
        int r0 = this.a;
        super.dispatchDraw(r2);
    }

    public void setBorderRadius(int r3) {
        a(getWidth(), getHeight());
        this.a = r3;
        invalidate();
    }

    public TopRoundRelativeLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void a(int r3, int r4) {
        if (this.a > 0) goto L5;
        return;
    L5:
        if (this.b != null) goto L7;
        this.b = new g();
    L7:
        setClipToOutline(true);
        this.b.update(this.a, r3, r4);
        setOutlineProvider(this.b);
    }

    public TopRoundRelativeLayout(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.a = 0;
        this.b = null;
        TypedArray r6 = r3.getTheme().obtainStyledAttributes(r4, new int[]{2130972522, 2130973851}, r5, 0);
        if (r6.hasValue(1) == false) goto L5;
        this.a = r6.getDimensionPixelOffset(1, 0);
    L5:
        r6.recycle();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        int r5 = this.a;
        a(r1, r2);
    }
}
