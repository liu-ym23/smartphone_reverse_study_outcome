package g56;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f480051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f480052b;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f480051a.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f480051a.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return this.f480051a.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return this.f480051a.getWidth();
    }

    public a(Bitmap r100) {
        this.f480051a = r100;
        Paint r101 = new Paint();
        this.f480052b = r101;
        r101.setDither(true);
        r101.setFilterBitmap(true);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        r100.drawBitmap(this.f480051a, 0.0f, 0.0f, this.f480052b);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f480052b.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f480052b.setColorFilter(r100);
    }
}
