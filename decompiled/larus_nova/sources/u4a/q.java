package u4a;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes32.dex */
public final class q implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f548743a;

    @Override // u4a.j
    public final void close() {
        this.f548743a.recycle();
    }

    @Override // u4a.j
    public final boolean isValid() {
        return !this.f548743a.isRecycled();
    }

    @Override // u4a.j
    public final Bitmap get() {
        if (isValid() == true) goto L5;
        return null;
    L5:
        return this.f548743a;
    }

    public q(Bitmap r100) {
        this.f548743a = r100;
    }
}
