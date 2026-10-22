package com.bytedance.ee.bear.drive.module.nativepreview.component.embed;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class EmbedComponentInnerFrameLayout extends FrameLayout {
    public Path a;
    public RectF b;
    public float c;

    public final void a() {
        setWillNotDraw(false);
        this.a = new Path();
        this.b = new RectF();
    }

    public EmbedComponentInnerFrameLayout(Context r1) {
        super(r1);
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r3) {
        if (this.c <= 0.0f) goto L6;
        if (r3 == null) goto L6;
        r3.clipPath(this.a);
    L6:
        super.onDraw(r3);
    }

    public void setRoundPath(float r4) {
        this.c = r4;
        this.a.addRoundRect(this.b, r4, r4, Path.Direction.CW);
        postInvalidate();
    }

    public EmbedComponentInnerFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        a();
    }

    public EmbedComponentInnerFrameLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        this.b.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        Path r6 = this.a;
        RectF r7 = this.b;
        float r8 = this.c;
        r6.addRoundRect(r7, r8, r8, Path.Direction.CW);
    }
}
