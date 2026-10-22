package o95;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements c<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f522470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.b f522471b;

    @Override // o95.c
    public final void recycle() {
        if (this.f522471b.put(this.f522470a) == true) goto L6;
        this.f522470a.recycle();
        return;
    }

    @Override // o95.c
    public final Bitmap get() {
        return this.f522470a;
    }

    public a(Bitmap r100, com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.bitmap_recycle.b r101) {
        if (r101 == null) goto L7;
        this.f522470a = r100;
        this.f522471b = r101;
        return;
    L7:
        throw new NullPointerException("BitmapPool must not be null");
    }
}
