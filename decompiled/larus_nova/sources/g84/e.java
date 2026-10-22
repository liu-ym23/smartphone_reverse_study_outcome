package g84;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, e> f480381b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Class, Object> f480382a;

    static {
        f480381b = new ConcurrentHashMap();
    }

    public e() {
        this.f480382a = new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    public static <T> T a(Class<T> r100, String r101) {
        e r102 = f480381b.get(r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        return (T) r102.f480382a.get(r100);
    }

    public static <T> void b(Class<T> r100, T r101, String r102) {
        ConcurrentHashMap<String, e> r103 = f480381b;
        e r104 = r103.get(r102);
        if (r104 != null) goto L5;
        r104 = new e();
        r103.put(r102, r104);
    L5:
        r104.f480382a.put(r100, r101);
    }
}
