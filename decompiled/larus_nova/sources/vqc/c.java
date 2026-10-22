package vqc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes41.dex */
public final class c extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f556786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f556787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f556788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f556789d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f556790e;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f556788c;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f556790e;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f556789d;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return this.f556790e;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return this.f556789d;
    }

    public c(Bitmap r100) {
        this.f556786a = new Paint(2);
        this.f556788c = 255;
        this.f556787b = r100;
        if (r100 == null) goto L5;
        this.f556789d = r100.getWidth();
        this.f556790e = this.f556787b.getHeight();
        return;
    L5:
        this.f556790e = 0;
        this.f556789d = 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Bitmap r101 = this.f556787b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isRecycled() == true) goto L9;
        r100.drawBitmap(this.f556787b, null, getBounds(), this.f556786a);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f556788c = r100;
        this.f556786a.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f556786a.setColorFilter(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean r100) {
        this.f556786a.setFilterBitmap(r100);
    }
}
