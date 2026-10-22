package v74;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, Object> f553482a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, u74.d> f553483b = null;

    static {
        f553482a = new ConcurrentHashMap();
        f553483b = new ConcurrentHashMap();
    }

    public static <T> T a(Class<T> r100) {
        ConcurrentHashMap<Class, Object> r101 = f553482a;
        Object r102 = (T) r101.get(r100);
        if (r102 != null) goto L18;
        monitor-enter(r101);
        r102 = r101.get(r100);     // Catch: Throwable -> L15
        if (r102 != null) goto L13;
        ConcurrentHashMap<Class, u74.d> r103 = f553483b;     // Catch: Throwable -> L15
        u74.d r104 = r103.get(r100);     // Catch: Throwable -> L15
        if (r104 == null) goto L13;
        r102 = (T) r104.create();
        if (r102 == null) goto L12;
        r101.put(r100, r102);     // Catch: Throwable -> L15
    L12:
        r103.remove(r100);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r101);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L18:
        return (T) r102;
    }
}
