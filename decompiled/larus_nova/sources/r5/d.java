package r5;

import android.util.LruCache;

/* JADX INFO: loaded from: classes43.dex */
public final class d extends LruCache<String, a> {
    public d() {
        super(5242880);
    }

    @Override // android.util.LruCache
    public final int sizeOf(String r100, a r101) {
        a r102 = r101;
        if (r102 == null) goto L9;
        p5.b r103 = r102.f536118a;
        if (r103 == null) goto L9;
        byte[] r104 = r103.f527736a;
        if (r104 == null) goto L9;
        return r104.length;
    L9:
        return 0;
    }
}
