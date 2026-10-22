package com.ss.android.ainote;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b1 extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f406681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f406682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f406683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f406684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f406685e;

    public b1(int r100, float r101, float r102, float r103, float r104) {
        this.f406681a = r100;
        this.f406682b = r101;
        this.f406683c = r102;
        this.f406684d = r103;
        this.f406685e = r104;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Intrinsics.checkNotNullParameter(r101, "text");
        return (int) r100.measureText(r101, r102, r103);
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, CharSequence r111, int r112, int r113, float r210, int r211, int r212, int r213, Paint r214) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "text");
        Intrinsics.checkNotNullParameter(r214, "paint");
        int r114 = r214.getColor();
        Paint.Style r115 = r214.getStyle();
        float r116 = r214.getStrokeWidth();
        PathEffect r117 = r214.getPathEffect();
        r214.setColor(this.f406681a);
        r110.drawText(r111, r112, r113, r210, r212, r214);
        r214.setStyle(Paint.Style.STROKE);
        r214.setStrokeWidth(this.f406684d);
        r214.setPathEffect(new DashPathEffect(new float[]{this.f406682b, this.f406683c}, 0.0f));
        float r100 = r214.measureText(r111, r112, r113);
        float r101 = r213 - this.f406685e;
        r110.drawLine(r210, r101, r210 + r100, r101, r214);
        r214.setColor(r114);
        r214.setStyle(r115);
        r214.setStrokeWidth(r116);
        r214.setPathEffect(r117);
    }
}
