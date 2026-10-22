package ox7;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mx7.c;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, a> f527091a = null;

    public b() {
    }

    static {
        ConcurrentHashMap r100 = new ConcurrentHashMap();
        f527091a = r100;
        ax7.a r101 = new ax7.a();
        String r102 = c.f516265a;
        if (r100.containsKey(ax7.a.class) == true) goto L6;
        r100.clear();
        r100.put(ax7.a.class, r101);
        return;
    }

    public static void a(String r100) {
        Iterator r101 = ((ConcurrentHashMap) f527091a).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((a) ((Map.Entry) r101.next()).getValue()).d(r100);
        goto L4
    }

    public static void c(String r100, String r101) {
        Iterator r102 = ((ConcurrentHashMap) f527091a).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((a) ((Map.Entry) r102.next()).getValue()).i(r100, r101);
        goto L4
    }

    public static void b(String r100, String r101, Throwable r102) {
        Iterator r103 = ((ConcurrentHashMap) f527091a).entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((a) ((Map.Entry) r103.next()).getValue()).e(r100, r101, r102);
        goto L4
    }
}
