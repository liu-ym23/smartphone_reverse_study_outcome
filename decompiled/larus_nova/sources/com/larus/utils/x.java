package com.larus.utils;

import android.R;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class x extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f375486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f375487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f375488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f375489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f375490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f375491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f375492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f375493h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f375494i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f375495j;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        if (this.f375491f == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f375495j.getColor() == 0) goto L5;
        r100.drawPath(this.f375492g, this.f375495j);
    L5:
        r100.drawPath(this.f375492g, this.f375494i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r110) {
        Intrinsics.checkNotNullParameter(r110, "bounds");
        super.onBoundsChange(r110);
        this.f375494i.setShader(new LinearGradient(0.0f, 0.0f, r110.width(), 0.0f, this.f375487b, null, Shader.TileMode.CLAMP));
        this.f375494i.setAlpha((int) (255 * this.f375489d));
        this.f375492g.reset();
        this.f375493h.set(r110);
        RectF r111 = this.f375493h;
        float r100 = this.f375486a;
        float r101 = 2;
        r111.inset(r100 / r101, r100 / r101);
        Path r112 = this.f375492g;
        RectF r102 = this.f375493h;
        float r103 = this.f375488c;
        r112.addRoundRect(r102, r103, r103, Path.Direction.CW);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (this.f375491f != null) goto L6;
        return false;
    L6:
        if (ArraysKt.contains(r100, R.attr.state_pressed) == false) goto L8;
        int r101 = this.f375491f.intValue();
    L10:
        if (this.f375495j.getColor() == r101) goto L13;
        this.f375495j.setColor(r101);
        invalidateSelf();
        return true;
    L13:
        return false;
    L8:
        r101 = this.f375490e;
        goto L10
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f375494i.setAlpha(r100);
        this.f375495j.setAlpha(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f375494i.setColorFilter(r100);
        this.f375495j.setColorFilter(r100);
        invalidateSelf();
    }

    public x(float r100, int[] r101, float r102, float r103, int r104, Integer r105) {
        Intrinsics.checkNotNullParameter(r101, "colors");
        this.f375486a = r100;
        this.f375487b = r101;
        this.f375488c = r102;
        this.f375489d = r103;
        this.f375490e = r104;
        this.f375491f = r105;
        this.f375492g = new Path();
        this.f375493h = new RectF();
        Paint r106 = new Paint(1);
        r106.setStyle(Paint.Style.STROKE);
        r106.setStrokeWidth(r100);
        this.f375494i = r106;
        Paint r107 = new Paint(1);
        r107.setStyle(Paint.Style.FILL);
        r107.setColor(r104);
        this.f375495j = r107;
    }
}
