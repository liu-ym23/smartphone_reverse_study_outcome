package u4a;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: loaded from: classes32.dex */
public final class f implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CloseableReference<Bitmap> f548734a;

    @Override // u4a.j
    public final void close() {
        this.f548734a.close();
    }

    @Override // u4a.j
    public final Bitmap get() {
        if (this.f548734a.isValid() == true) goto L5;
        return null;
    L5:
        return this.f548734a.get();
    }

    @Override // u4a.j
    public final boolean isValid() {
        return this.f548734a.isValid();
    }

    public f(CloseableReference<Bitmap> r100) {
        this.f548734a = r100.clone();
    }
}
