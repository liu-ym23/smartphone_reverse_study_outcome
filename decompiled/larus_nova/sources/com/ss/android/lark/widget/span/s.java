package com.ss.android.lark.widget.span;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class s extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f448770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f448771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f448772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BorderProperty f448773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f448774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f448775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RectF f448776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Path f448777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f448778i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f448779j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f448780k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f448781l;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f448770a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f448770a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.f448774e.set(0.0f, 0.0f, this.f448771b, this.f448772c);
        float r101 = (this.f448780k * 1.0f) / 2;
        this.f448776g.set(this.f448774e);
        this.f448776g.inset(r101, r101);
        this.f448775f.set(this.f448774e);
        RectF r102 = this.f448775f;
        float r103 = this.f448780k;
        r102.inset(r103, r103);
        Drawable r104 = this.f448770a;
        if ((r104 instanceof BitmapDrawable) == false) goto L12;
        Bitmap r105 = ((BitmapDrawable) r104).getBitmap();
        if (r105 != null) goto L8;
    L11:
        Log.i("ImageBorderUtils", "bitmap recycled");
        goto L12
    L8:
        if (r105.isRecycled() == true) goto L11;
        this.f448779j.setAntiAlias(true);
        int r106 = r100.getSaveCount();
        r100.save();
        this.f448777h.reset();
        Path r107 = this.f448777h;
        RectF r108 = this.f448775f;
        float r109 = this.f448781l;
        r107.addRoundRect(r108, r109, r109, Path.Direction.CW);
        r100.clipPath(this.f448777h);
        r100.drawBitmap(r105, null, this.f448774e, this.f448778i);
        r100.restoreToCount(r106);
    L12:
        this.f448779j.setAntiAlias(true);
        this.f448779j.setStyle(Paint.Style.STROKE);
        this.f448779j.setColor(this.f448773d.getBorderColor());
        this.f448779j.setStrokeWidth(this.f448773d.getBorderWidthPx());
        this.f448777h.reset();
        Path r110 = this.f448777h;
        RectF r111 = this.f448776g;
        float r112 = this.f448781l;
        r110.addRoundRect(r111, r112, r112, Path.Direction.CW);
        r100.drawPath(this.f448777h, this.f448779j);
    }

    public s(Drawable r100, int r101, int r102, BorderProperty r103) {
        Intrinsics.checkNotNullParameter(r100, "srcDrawable");
        Intrinsics.checkNotNullParameter(r103, "borderProperty");
        this.f448770a = r100;
        this.f448771b = r101;
        this.f448772c = r102;
        this.f448773d = r103;
        this.f448774e = new RectF();
        this.f448775f = new RectF();
        this.f448776g = new RectF();
        this.f448777h = new Path();
        this.f448778i = new Paint(2);
        this.f448779j = new Paint();
        this.f448780k = r103.getBorderWidthPx();
        this.f448781l = r103.getBorderRadiusPx();
    }
}
