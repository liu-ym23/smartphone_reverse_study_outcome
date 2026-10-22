package com.larksuite.component.universe_design.gradient;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.Xfermode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f285033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f285034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Shader f285035c;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public final Shader a() {
        float r100 = Math.min(getBounds().width(), getBounds().height());
        float r101 = (getBounds().left + r100) / 2.0f;
        float r102 = (getBounds().top + r100) / 2.0f;
        Matrix r103 = new Matrix();
        r103.preRotate(-45.0f, r101, r102);
        SweepGradient r104 = new SweepGradient(r101, r102, this.f285033a, null);
        r104.setLocalMatrix(r103);
        return r104;
    }

    public a(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "colors");
        this.f285033a = r100;
        Paint r101 = new Paint();
        r101.setAntiAlias(true);
        this.f285034b = r101;
        this.f285035c = a();
    }

    public final void b(Xfermode r100) {
        this.f285034b.setXfermode(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        float r100 = Math.min(getBounds().width(), getBounds().height());
        this.f285034b.setShader(this.f285035c);
        int r101 = r110.save();
        if (getBounds().width() <= getBounds().height()) goto L5;
        r110.scale(getBounds().width() / getBounds().height(), 1.0f);
    L6:
        r110.drawRect(getBounds().left, getBounds().top, getBounds().left + r100, getBounds().top + r100, this.f285034b);
        r110.restoreToCount(r101);
        return;
    L5:
        r110.scale(1.0f, getBounds().height() / getBounds().width());
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        super.onBoundsChange(r100);
        this.f285035c = a();
    }
}
