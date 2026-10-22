package m37;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, Object> f511767a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, Object> f511768b = null;

    static {
        f511767a = new ConcurrentHashMap();
        f511768b = new ConcurrentHashMap();
    }

    public static <T> T a(Class<T> r100, d r101) {
        ConcurrentHashMap<Class, Object> r102 = f511767a;
        T r103 = (T) r102.get(r100);
        if (r103 != null) goto L28;
        ConcurrentHashMap<Class, Object> r104 = f511768b;
        monitor-enter(r104);
    L25:
        th = move-exception;
        throw th;
    L7:
        if (r104.containsKey(r100) == false) goto L9;
        Object r105 = r104.get(r100);     // Catch: Throwable -> L25
    L10:
        if (r105 != null) goto L12;
        r105 = new Object();     // Catch: Throwable -> L25
        r104.put(r100, r105);     // Catch: Throwable -> L25
    L12:
        monitor-exit(r104);     // Catch: Throwable -> L25
        monitor-enter(r105);
        Object r106 = r102.get(r100);     // Catch: Throwable -> L22
        if (r106 != null) goto L19;
        Object r107 = r101.create(r100);     // Catch: Throwable -> L22
        if (r107 == null) goto L20;
        r102.put(r100, r107);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r105);     // Catch: Throwable -> L22
        return (T) r107;
    L19:
        r107 = r106;
    L22:
        th = move-exception;
        throw th;
    L9:
        r105 = null;
        goto L10
    L28:
        ConcurrentHashMap<Class, Object> r108 = f511768b;
        if (r108.containsKey(r100) == false) goto L37;
        r108.remove(r100);
        return r103;
    L37:
        return r103;
    }
}
