package j77;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, Object> f497631a = null;

    public b() {
    }

    static {
        f497631a = new ConcurrentHashMap();
    }

    public static <T> T a(Class<T> r100, c r101) {
        ConcurrentHashMap<Class, Object> r102 = f497631a;
        Object r103 = (T) r102.get(r100);
        if (r103 == null) goto L5;
    L17:
        return (T) r103;
    L5:
        monitor-enter(b.class);
        r103 = r102.get(r100);     // Catch: Throwable -> L14
        if (r103 != null) goto L12;
        Object r104 = r101.create(r100);     // Catch: Throwable -> L14
        if (r104 == null) goto L11;
        r102.put(r100, r104);     // Catch: Throwable -> L14
    L11:
        r103 = (T) r104;
    L12:
        monitor-exit(b.class);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }
}
