package olc;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements a {
    public f() {
    }

    @Override // olc.a
    public final void a(Bitmap r100) {
        r100.recycle();
    }

    @Override // olc.a
    public final Bitmap obtain(int r100, int r101, Bitmap.Config r102) {
        return Bitmap.createBitmap(r100, r101, r102);
    }
}
