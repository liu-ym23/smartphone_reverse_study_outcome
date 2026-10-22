package olc;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f524202b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f524203a;

    static {
        f524202b = new e();
    }

    public e() {
        this.f524203a = new f();
    }

    @Override // olc.a
    public final void a(Bitmap r100) {
        this.f524203a.getClass();
        r100.recycle();
    }

    @Override // olc.a
    public final Bitmap obtain(int r100, int r101, Bitmap.Config r102) {
        this.f524203a.getClass();
        return Bitmap.createBitmap(r100, r101, r102);
    }
}
