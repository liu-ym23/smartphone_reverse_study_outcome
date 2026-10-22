package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MaxSizeFrameLayout extends FrameLayout {
    public s a;

    public int getMaxHeight() {
        return this.a.c;
    }

    public int getMaxWidth() {
        return this.a.b;
    }

    public MaxSizeFrameLayout(Context r2) {
        super(r2);
        this.a = new s(this, null);
    }

    public void setEnableMaxHeight(boolean r3) {
        s r0 = this.a;
        if (r0.e == r3) goto L6;
        r0.e = r3;
        r0.a.requestLayout();
        return;
    }

    public void setEnableMaxWidth(boolean r3) {
        s r0 = this.a;
        if (r0.d == r3) goto L6;
        r0.d = r3;
        r0.a.requestLayout();
        return;
    }

    public void setMaxHeight(int r3) {
        s r0 = this.a;
        if (r0.c == r3) goto L6;
        r0.c = r3;
        r0.a.requestLayout();
        return;
    }

    public void setMaxWidth(int r3) {
        s r0 = this.a;
        if (r0.b == r3) goto L6;
        r0.b = r3;
        r0.a.requestLayout();
        return;
    }

    public MaxSizeFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = new s(this, r2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r3, int r4) {
        s r0 = this.a;
        int r5 = s.a(r3, r0.d, r0.b);
        s r1 = this.a;
        super.onMeasure(r5, s.a(r4, r1.e, r1.c));
    }

    public MaxSizeFrameLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new s(this, r2);
    }
}
