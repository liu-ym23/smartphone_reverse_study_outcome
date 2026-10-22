package rgc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class, a> f537758a = null;

    static {
        f537758a = new ConcurrentHashMap();
    }

    public static <T extends a> T a(Class<T> r100) {
        return (T) ((ConcurrentHashMap) f537758a).get(r100);
    }

    public static <T extends a> void b(Class<T> r100, a r101) {
        if (r101 == null) goto L5;
        ((ConcurrentHashMap) f537758a).put(r100, r101);
        return;
    }
}
