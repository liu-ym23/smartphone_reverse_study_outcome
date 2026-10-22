package vk6;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes19.dex */
public final class j implements a {
    public j() {
    }

    @Override // vk6.a
    public final void a(Bitmap r100) {
        r100.recycle();
    }

    @Override // vk6.a
    public final Bitmap obtain(int r100, int r101, Bitmap.Config r102) {
        return Bitmap.createBitmap(r100, r101, r102);
    }
}
