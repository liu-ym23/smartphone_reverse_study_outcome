package ssc;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes5.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f543513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f543514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f543515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f543516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f543517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f543518f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f543519g;

    /* JADX INFO: renamed from: ssc.a$a, reason: collision with other inner class name */
    public static class C7651a {
        public C7651a(float r100, float r101) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return true;
    }

    static {
        new C7651a(0.3888889f, 0.6944444f);
        new C7651a(0.8472222f, 0.2638889f);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        if (this.f543519g == false) goto L5;
        Paint.Style r101 = Paint.Style.FILL_AND_STROKE;
        int r102 = this.f543513a;
    L6:
        this.f543515c.setStyle(r101);
        this.f543515c.setColor(r102);
        Rect r103 = getBounds();
        float r104 = (r103.width() - this.f543516d.width()) / 2.0f;
        float r105 = (r103.height() - this.f543516d.height()) / 2.0f;
        float r106 = this.f543516d.width() / 8.0f;
        int r107 = r100.save();
        r100.translate(r104, r105);     // Catch: Throwable -> L12
        r100.drawRoundRect(this.f543516d, r106, r106, this.f543515c);     // Catch: Throwable -> L12
        if (this.f543519g == false) goto L10;
        r100.drawPath(this.f543518f, this.f543517e);     // Catch: Throwable -> L12
    L10:
        r100.restoreToCount(r107);
        return;
    L12:
        th = move-exception;
        r100.restoreToCount(r107);
        throw th;
    L5:
        r101 = Paint.Style.STROKE;
        r102 = this.f543514b;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        float r101 = Math.min(r100.width(), r100.height());
        float r102 = r101 / 8.0f;
        float r103 = r101 - r102;
        this.f543516d.set(0.0f, 0.0f, r103, r103);
        this.f543515c.setStrokeWidth(r102);
        this.f543517e.setStrokeWidth(r102);
        this.f543518f.reset();
        this.f543518f.moveTo(0.15277778f * r103, 0.45833334f * r103);
        this.f543518f.lineTo(0.3888889f * r103, 0.6944444f * r103);
        this.f543518f.lineTo(0.8472222f * r103, r103 * 0.2638889f);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] r100) {
        boolean r101 = false;
        if (r100 == null) goto L5;
        int r102 = r100.length;
    L7:
        if (r102 <= 0) goto L14;
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L14;
        if (16842912 == r100[r103]) goto L12;
        r103 = r103 + 1;
        goto L9
    L12:
        boolean r104 = true;
    L16:
        if (r104 == this.f543519g) goto L18;
        r101 = true;
    L18:
        if (r101 == false) goto L20;
        invalidateSelf();
        this.f543519g = r104;
    L20:
        return r101;
    L14:
        r104 = false;
        goto L16
    L5:
        r102 = 0;
        goto L7
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f543515c.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f543515c.setColorFilter(r100);
    }

    public a(int r100, int r101, int r102) {
        this.f543515c = new Paint(1);
        this.f543516d = new RectF();
        Paint r103 = new Paint(1);
        this.f543517e = r103;
        this.f543518f = new Path();
        this.f543513a = r100;
        this.f543514b = r101;
        r103.setColor(r102);
        r103.setStyle(Paint.Style.STROKE);
    }
}
