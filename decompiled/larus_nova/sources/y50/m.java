package y50;

import com.bytedance.android.live.core.cache.LruCache;

/* JADX INFO: loaded from: classes45.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile m f566221b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<Object, String> f566222a;

    public static m a() {
        if (f566221b != null) goto L15;
        monitor-enter(m.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f566221b != null) goto L9;
        f566221b = new m();     // Catch: Throwable -> L11
    L9:
        monitor-exit(m.class);     // Catch: Throwable -> L11
    L15:
        return f566221b;
    }

    public m() {
        this.f566222a = new LruCache(50);
    }
}
