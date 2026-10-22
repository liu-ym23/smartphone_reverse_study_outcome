package na6;

import android.util.LruCache;

/* JADX INFO: loaded from: classes19.dex */
public final class c<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<K, V> f518469a;

    public c() {
        this.f518469a = new LruCache(1000);
    }
}
