package com.ss.android.lark.widget.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.ss.android.lark.utils.LarkContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes38.dex */
public final class d0 extends ReplacementSpan implements Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f448658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f448659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f448660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f448661d;

    public interface a {
        void a();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "who");
        Intrinsics.checkNotNullParameter(r101, "what");
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "who");
        Intrinsics.checkNotNullParameter(r101, "what");
    }

    public d0() {
        b0 r100 = new b0(h18.d.a(LarkContext.getApplication(), 3.0f));
        r100.setCallback(this);
        r100.setBounds(0, 0, r100.getIntrinsicWidth(), r100.getIntrinsicHeight());
        this.f448658a = r100;
        this.f448659b = h18.d.b(LarkContext.getApplication(), 8);
        this.f448660c = h18.d.b(LarkContext.getApplication(), 12);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        a r101 = this.f448661d;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        return MathKt.roundToInt((this.f448659b + this.f448658a.getIntrinsicWidth()) + this.f448660c);
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
        r100.save();
        r100.translate(this.f448659b + r104, (r105 + ((r107 - r105) / 2)) - (this.f448658a.getIntrinsicHeight() / 2.0f));
        this.f448658a.draw(r100);
        r100.restore();
    }
}
