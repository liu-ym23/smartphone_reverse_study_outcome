package v7a;

import android.graphics.Bitmap;
import com.lynx.tasm.utils.BlurUtils;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f553498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f553499b;

    @Override // v7a.b
    public final String getName() {
        return c.class.getSimpleName();
    }

    @Override // v7a.b
    public final String getPostprocessorCacheKey() {
        if (this.f553499b != null) goto L6;
        this.f553499b = String.valueOf(this.f553498a);
    L6:
        return this.f553499b;
    }

    public c(int r100) {
        this.f553498a = r100;
    }

    @Override // v7a.b
    public final void a(Bitmap r100) {
        BlurUtils.iterativeBoxBlur(r100, this.f553498a);
    }
}
