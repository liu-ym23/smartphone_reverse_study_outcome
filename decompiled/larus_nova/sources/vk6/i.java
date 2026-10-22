package vk6;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes19.dex */
public final class i implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f555531b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f555532a;

    static {
        f555531b = new i();
    }

    public i() {
        this.f555532a = new j();
    }

    @Override // vk6.a
    public final void a(Bitmap r100) {
        this.f555532a.getClass();
        r100.recycle();
    }

    @Override // vk6.a
    public final Bitmap obtain(int r100, int r101, Bitmap.Config r102) {
        this.f555532a.getClass();
        return Bitmap.createBitmap(r100, r101, r102);
    }
}
