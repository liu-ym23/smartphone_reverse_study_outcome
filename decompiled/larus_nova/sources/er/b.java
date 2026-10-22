package er;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes44.dex */
public final class b<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<K, a<K, V>> f473566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a<K, V> f473567b;

    public static final class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a<K, V> f473568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a<K, V> f473569b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final K f473570c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final V f473571d;

        public a() {
            this.f473570c = null;
            this.f473571d = null;
        }
    }

    public b() {
        this.f473566a = new ConcurrentHashMap(20);
        a<K, V> r100 = new a();
        this.f473567b = r100;
        a<K, V> r101 = new a();
        r100.f473569b = r101;
        r101.f473568a = r100;
    }
}
