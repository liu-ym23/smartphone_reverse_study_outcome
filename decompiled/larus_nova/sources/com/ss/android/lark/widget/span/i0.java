package com.ss.android.lark.widget.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes38.dex */
public class i0 extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f448690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextPaint f448691b;

    public i0(String r100, int r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f448690a = r100;
        TextPaint r103 = new TextPaint();
        r103.setColor(r101);
        r103.setTextSize(r102);
        this.f448691b = r103;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        return MathKt.roundToInt(this.f448691b.measureText(this.f448690a));
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
        r100.drawText(this.f448690a, r104, r106, this.f448691b);
    }
}
