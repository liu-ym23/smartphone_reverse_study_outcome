package tta;

import android.graphics.Bitmap;
import android.util.LruCache;

/* JADX INFO: loaded from: classes34.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f547587a;

    public static final class a extends LruCache<String, Bitmap> {
        public a(int r100) {
            super(r100);
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r100, Bitmap r101) {
            return r101.getByteCount() / 1024;
        }
    }

    public h() {
        this.f547587a = new a(((int) (Runtime.getRuntime().maxMemory() / ((long) 1024))) / 8);
    }
}
