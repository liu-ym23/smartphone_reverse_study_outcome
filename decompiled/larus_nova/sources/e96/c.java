package e96;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, Object> f471508a = null;

    static {
        f471508a = new ConcurrentHashMap();
    }

    public static void a(Class r100, Object r101) {
        Map<Class<?>, Object> r102 = f471508a;     // Catch: Exception -> L8
        if (((ConcurrentHashMap) r102).get(r100) != null) goto L6;
        ((ConcurrentHashMap) r102).put(r100, r101);     // Catch: Exception -> L8
        return;
    L6:
        ((ConcurrentHashMap) r102).put(r100, r101);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        int r103 = f96.a.f475971a;
        f96.a.a("interactive_settings", "setSettings error " + e.getMessage(), null);
    }
}
