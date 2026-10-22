package jt8;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes26.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f500338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f500339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f500340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f500341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f500342e;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f500340c;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f500342e;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f500341d;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return this.f500342e;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return this.f500341d;
    }

    public a(Bitmap r100) {
        this.f500338a = new Paint(2);
        this.f500340c = 255;
        this.f500339b = r100;
        if (r100 == null) goto L5;
        this.f500341d = r100.getWidth();
        this.f500342e = this.f500339b.getHeight();
        return;
    L5:
        this.f500342e = 0;
        this.f500341d = 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Bitmap r101 = this.f500339b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isRecycled() == true) goto L9;
        r100.drawBitmap(this.f500339b, null, getBounds(), this.f500338a);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f500340c = r100;
        this.f500338a.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f500338a.setColorFilter(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean r100) {
        this.f500338a.setFilterBitmap(r100);
    }
}
