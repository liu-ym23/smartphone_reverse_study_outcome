package m37;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c {
    public static final ConcurrentHashMap<Class, Object> a = null;
    public static final ConcurrentHashMap<Class, Object> b = null;

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
    }

    public static <T> T a(Class<T> r3, d r4) {
        ConcurrentHashMap<Class, Object> r0 = a;
        T r1 = (T) r0.get(r3);
        if (r1 != null) goto L28;
        ConcurrentHashMap<Class, Object> r2 = b;
        monitor-enter(r2);
    L25:
        th = move-exception;
        throw th;
    L7:
        if (r2.containsKey(r3) == false) goto L9;
        Object r5 = r2.get(r3);     // Catch: Throwable -> L25
    L10:
        if (r5 != null) goto L12;
        r5 = new Object();     // Catch: Throwable -> L25
        r2.put(r3, r5);     // Catch: Throwable -> L25
    L12:
        monitor-exit(r2);     // Catch: Throwable -> L25
        monitor-enter(r5);
        Object r6 = r0.get(r3);     // Catch: Throwable -> L22
        if (r6 != null) goto L19;
        Object r7 = r4.create(r3);     // Catch: Throwable -> L22
        if (r7 == null) goto L20;
        r0.put(r3, r7);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r5);     // Catch: Throwable -> L22
        return (T) r7;
    L19:
        r7 = r6;
    L22:
        th = move-exception;
        throw th;
    L9:
        r5 = null;
        goto L10
    L28:
        ConcurrentHashMap<Class, Object> r8 = b;
        if (r8.containsKey(r3) == false) goto L37;
        r8.remove(r3);
        return r1;
    L37:
        return r1;
    }
}
