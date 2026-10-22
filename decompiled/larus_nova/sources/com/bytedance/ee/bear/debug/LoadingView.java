package com.bytedance.ee.bear.debug;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public class LoadingView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f217353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f217354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f217355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f217356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f217357e;

    public LoadingView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        this.f217356d.setColor(Color.argb(100, 255, 255, 255));
        float r101 = this.f217353a;
        r100.drawCircle(r101 / 2.0f, r101 / 2.0f, (r101 / 2.0f) - this.f217354b, this.f217356d);
        this.f217356d.setColor(-1);
        float r102 = this.f217354b;
        float r103 = this.f217353a;
        r100.drawArc(new RectF(r102, r102, r103 - r102, r103 - r102), this.f217355c, 100.0f, false, this.f217356d);
    }

    public LoadingView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (getMeasuredWidth() <= getHeight()) goto L5;
        this.f217353a = getMeasuredHeight();
    L6:
        this.f217354b = 5.0f;
        return;
    L5:
        this.f217353a = getMeasuredWidth();
        goto L6
    }

    public LoadingView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f217353a = 0.0f;
        this.f217354b = 0.0f;
        this.f217355c = 0.0f;
        Paint r103 = new Paint();
        this.f217356d = r103;
        r103.setAntiAlias(true);
        this.f217356d.setStyle(Paint.Style.STROKE);
        this.f217356d.setColor(-1);
        this.f217356d.setStrokeWidth(8.0f);
    }
}
