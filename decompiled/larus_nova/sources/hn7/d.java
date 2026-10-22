package hn7;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f486120a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f486121b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Class<a>, a> f486122c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<Class<a>, Set<b<a>>> f486123d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<e> f486124e = null;

    static {
        f486120a = new Object();
        f486121b = new Handler(Looper.getMainLooper());
        f486122c = new ConcurrentHashMap();
        f486123d = new HashMap();
        f486124e = new HashSet();
        new HashSet();
    }

    public static <T extends a> T b(Class<T> r100) {
        return (T) ((ConcurrentHashMap) f486122c).get(r100);
    }

    public static void c(b r100) {
        if (r100 == null) goto L14;
        Object r101 = f486120a;
        monitor-enter(r101);
        Iterator r102 = ((HashMap) f486123d).values().iterator();     // Catch: Throwable -> L11
    L7:
        if (r102.hasNext() == false) goto L9;
        ((Set) r102.next()).remove(r100);     // Catch: Throwable -> L11
        goto L7
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static String e(Object r100) {
        if (r100 != null) goto L6;
        return "null";
    L6:
        return r100.getClass().getSimpleName() + "@" + r100.hashCode();
    }

    public static <T extends a> void a(Class<T> r100, b<T> r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        Object r102 = f486120a;
        monitor-enter(r102);
        Map<Class<a>, Set<b<a>>> r103 = f486123d;     // Catch: Throwable -> L12
        Set r104 = (Set) ((HashMap) r103).get(r100);     // Catch: Throwable -> L12
        if (r104 != null) goto L9;
        HashSet r105 = new HashSet();     // Catch: Throwable -> L12
        r105.add(r101);     // Catch: Throwable -> L12
        ((HashMap) r103).put(r100, r105);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L12
        return;
    L9:
        r104.add(r101);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public static <T extends a> void d(Class<T> r100, T r101) {
        Map<Class<a>, a> r102 = f486122c;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        a r104 = (a) r103.get(r100);
        r103.put(r100, r101);
        if (r104 == r101) goto L43;
        new HashMap(r102);
        Object r105 = f486120a;
        monitor-enter(r105);
        Set r106 = (Set) ((HashMap) f486123d).get(r100);     // Catch: Throwable -> L40
        if (r106 != null) goto L9;
    L14:
        HashSet r107 = new HashSet();     // Catch: Throwable -> L40
        Iterator r108 = ((HashSet) f486124e).iterator();     // Catch: Throwable -> L40
    L17:
        if (r108.hasNext() == false) goto L26;
        Object r109 = r108.next();     // Catch: Exception -> L20 Throwable -> L40
    L23:
        if (((e) r109) == null) goto L17;
        throw null;     // Catch: Throwable -> L40
    L20:
        e = move-exception;
        e(null);     // Catch: Throwable -> L40
        e(null);     // Catch: Throwable -> L40
        e.getMessage();     // Catch: Throwable -> L40
        r109 = null;
        goto L23
    L26:
        Iterator r110 = r107.iterator();     // Catch: Throwable -> L40
    L28:
        if (r110.hasNext() == false) goto L38;
        Object r111 = r110.next();     // Catch: Exception -> L31 Throwable -> L40
    L34:
        if (((e) r111) == null) goto L28;
        new HashMap();     // Catch: Throwable -> L40
        throw null;     // Catch: Throwable -> L40
    L31:
        e = move-exception;
        e(null);     // Catch: Throwable -> L40
        e(null);     // Catch: Throwable -> L40
        e.getMessage();     // Catch: Throwable -> L40
        r111 = null;
        goto L34
    L38:
        monitor-exit(r105);     // Catch: Throwable -> L40
        return;
    L9:
        if (r106.isEmpty() == true) goto L14;
        Iterator r112 = r106.iterator();     // Catch: Throwable -> L40
    L12:
        if (r112.hasNext() == false) goto L14;
        f486121b.post(new c(r100, r101, (b) r112.next()));     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        throw th;
    }
}
