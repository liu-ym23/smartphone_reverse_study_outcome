package o95;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements c<Bitmap> {
    public final Bitmap a;
    public final com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.b b;

    @Override // o95.c
    public final void recycle() {
        if (this.b.put(this.a) == true) goto L6;
        this.a.recycle();
        return;
    }

    @Override // o95.c
    public final Bitmap get() {
        return this.a;
    }

    public a(Bitmap r1, com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.b r2) {
        if (r2 == null) goto L7;
        this.a = r1;
        this.b = r2;
        return;
    L7:
        throw new NullPointerException("BitmapPool must not be null");
    }
}
