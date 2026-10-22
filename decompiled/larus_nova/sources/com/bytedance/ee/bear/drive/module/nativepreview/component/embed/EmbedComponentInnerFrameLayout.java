package com.bytedance.ee.bear.drive.module.nativepreview.component.embed;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes16.dex */
public class EmbedComponentInnerFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Path f224503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f224504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f224505c;

    public final void a() {
        setWillNotDraw(false);
        this.f224503a = new Path();
        this.f224504b = new RectF();
    }

    public EmbedComponentInnerFrameLayout(Context r100) {
        super(r100);
        a();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        if (this.f224505c <= 0.0f) goto L6;
        if (r100 == null) goto L6;
        r100.clipPath(this.f224503a);
    L6:
        super.onDraw(r100);
    }

    public void setRoundPath(float r100) {
        this.f224505c = r100;
        this.f224503a.addRoundRect(this.f224504b, r100, r100, Path.Direction.CW);
        postInvalidate();
    }

    public EmbedComponentInnerFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        a();
    }

    public EmbedComponentInnerFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        this.f224504b.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        Path r105 = this.f224503a;
        RectF r106 = this.f224504b;
        float r107 = this.f224505c;
        r105.addRoundRect(r106, r107, r107, Path.Direction.CW);
    }
}
