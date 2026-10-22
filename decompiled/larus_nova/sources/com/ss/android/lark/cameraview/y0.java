package com.ss.android.lark.cameraview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/* JADX INFO: loaded from: classes34.dex */
public final class y0 extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f411054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f411055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f411056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f411057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f411058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f411059f;

    public y0(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        Path r101 = this.f411054a;
        float r102 = this.f411058e;
        r101.moveTo(r102, r102 / 2.0f);
        this.f411054a.lineTo(this.f411056c, this.f411057d - (this.f411058e / 2.0f));
        Path r103 = this.f411054a;
        float r104 = this.f411055b;
        float r105 = this.f411058e;
        r103.lineTo(r104 - r105, r105 / 2.0f);
        r100.drawPath(this.f411054a, this.f411059f);
    }

    public y0(Context r100, int r101) {
        this(r100);
        this.f411055b = r101;
        int r102 = r101 / 2;
        this.f411056c = r102;
        this.f411057d = r102;
        float r103 = r101 / 15.0f;
        this.f411058e = r103;
        Paint r104 = new Paint();
        this.f411059f = r104;
        r104.setAntiAlias(true);
        r104.setColor(-1);
        r104.setStyle(Paint.Style.STROKE);
        r104.setStrokeWidth(r103);
        this.f411054a = new Path();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = this.f411055b;
        setMeasuredDimension(r102, r102 / 2);
    }
}
