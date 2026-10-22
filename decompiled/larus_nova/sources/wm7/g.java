package wm7;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class, Object> f560360a = null;

    static {
        f560360a = new ConcurrentHashMap();
    }

    public static <T> T a(Class<T> r100) {
        return (T) f560360a.get(r100);
    }

    public static <T> void b(Class<T> r100, T r101) {
        ConcurrentHashMap<Class, Object> r102 = f560360a;
        if (r102.containsKey(r100) == true) goto L6;
        r102.put(r100, r101);
        return;
    }
}
