package qu3;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, Object> f534840a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, a<?>> f534841b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, b> f534842c = null;

    public c() {
    }

    static {
        f534840a = new ConcurrentHashMap();
        f534841b = new ConcurrentHashMap();
        f534842c = new ConcurrentHashMap();
    }

    public static <T> T a(Class<T> r100) {
        ConcurrentHashMap<Class, Object> r101 = f534840a;
        T r102 = (T) r101.get(r100);
        if (r102 == null) goto L5;
    L20:
        return r102;
    L5:
        monitor-enter(c.class);
        ConcurrentHashMap<Class, a<?>> r103 = f534841b;     // Catch: Throwable -> L17
        a<?> r104 = r103.get(r100);     // Catch: Throwable -> L17
        if (r104 == null) goto L15;
        r102 = (T) r104.create();
        r103.remove(r100);     // Catch: Throwable -> L17
        if (r102 == null) goto L15;
        r101.put(r100, r102);     // Catch: Throwable -> L17
        ConcurrentHashMap<Class, b> r105 = f534842c;     // Catch: Throwable -> L17
        b r106 = r105.get(r100);     // Catch: Throwable -> L17
        if (r106 == null) goto L13;
        r106.a();     // Catch: Throwable -> L17
        r105.remove(r100);     // Catch: Throwable -> L17
    L13:
        monitor-exit(c.class);     // Catch: Throwable -> L17
        return r102;
    L15:
        monitor-exit(c.class);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public static <T> void b(Class<T> r100, a<T> r101) {
        f534841b.put(r100, r101);
    }
}
