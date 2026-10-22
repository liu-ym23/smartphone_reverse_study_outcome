package z16;

import android.util.LruCache;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends LruCache<String, byte[]> {
    public b(int r100) {
        super(r100);
    }

    @Override // android.util.LruCache
    public final int sizeOf(String r100, byte[] r101) {
        byte[] r102 = r101;
        if (r102 != null) goto L7;
        return 0;
    L7:
        return r102.length;
    }
}
