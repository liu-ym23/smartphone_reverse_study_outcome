package dma;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f469237d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f469238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f469239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bitmap[] f469240c;

    public static final class a {
    }

    static {
        Intrinsics.checkNotNullParameter("#", "letter");
        f469237d = new b(0, "#");
    }

    public final int getType() {
        return this.f469238a;
    }

    public b(int r100, String r101) {
        this.f469238a = r100;
        this.f469239b = r101;
        this.f469240c = null;
        if (r100 == 2) goto L6;
        return;
    L6:
        throw new IllegalStateException("symbol must have 3 bitmaps!".toString());
    }
}
