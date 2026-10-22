package iq7;

import android.content.Context;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class g {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Context f495391g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static b f495392h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map<String, List<Pair<Class<? extends e>, d>>> f495393i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Map<String, Map<Class<? extends e>, g>> f495394j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<? extends e> f495395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<Class<? extends iq7.a>> f495396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet<Class<? extends iq7.a>> f495397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinkedHashSet<c> f495398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap<Class<? extends iq7.a>, LinkedHashSet<c>> f495399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HashSet<jq7.a.b> f495400f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedHashSet<Class<? extends iq7.a>> f495401a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinkedHashSet<Class<? extends iq7.a>> f495402b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LinkedHashSet<c> f495403c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final HashMap<Class<? extends iq7.a>, LinkedHashSet<c>> f495404d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final HashSet<jq7.a.b> f495405e;

        public <T extends e> a() {
            this.f495401a = new LinkedHashSet();
            this.f495402b = new LinkedHashSet();
            this.f495403c = new LinkedHashSet();
            this.f495404d = new HashMap();
            this.f495405e = new HashSet();
        }
    }

    public static class b {
        public b() {
        }
    }

    public interface c {
        void a();
    }

    public static abstract class d {
        public d() {
        }

        public abstract void a(a r100);
    }

    public g() {
        throw null;
    }

    static {
        f495393i = new HashMap();
        f495394j = new HashMap();
    }

    public static void c() {
        f495392h.getClass();
    }

    public static g a(String r100, Class<? extends e> r101) {
        Map<String, Map<Class<? extends e>, g>> r102 = f495394j;
        Map r103 = (Map) ((HashMap) r102).get(r100);
        if (r103 == null) goto L5;
    L14:
        g r104 = (g) r103.get(r101);
        if (r104 == null) goto L18;
        return r104;
    L18:
        monitor-enter(g.class);
        g r105 = (g) r103.get(r101);     // Catch: Throwable -> L38
        if (r105 == null) goto L23;
        monitor-exit(g.class);     // Catch: Throwable -> L38
        return r105;
    L23:
        a r106 = new a();     // Catch: Throwable -> L38
        List r107 = (List) ((HashMap) f495393i).get(r100);     // Catch: Throwable -> L38
        if (r107 != null) goto L28;
        monitor-exit(g.class);     // Catch: Throwable -> L38
        return null;
    L28:
        Iterator r108 = r107.iterator();     // Catch: Throwable -> L38
    L30:
        if (r108.hasNext() == false) goto L35;
        Pair r109 = (Pair) r108.next();     // Catch: Throwable -> L38
        if (((Class) r109.first).equals(r101) == false) goto L30;
        d r110 = (d) r109.second;     // Catch: Throwable -> L38
        r110.getClass();     // Catch: Throwable -> L38
        r110.a(r106);     // Catch: Throwable -> L38
        goto L30
    L35:
        g r111 = new g(r101, r106.f495401a, r106.f495402b);     // Catch: Throwable -> L38
        r111.f495398d = r106.f495403c;     // Catch: Throwable -> L38
        r111.f495399e = r106.f495404d;     // Catch: Throwable -> L38
        r111.f495400f = r106.f495405e;     // Catch: Throwable -> L38
        r103.put(r101, r111);     // Catch: Throwable -> L38
        monitor-exit(g.class);     // Catch: Throwable -> L38
        return r111;
    L38:
        th = move-exception;
        throw th;
    L5:
        monitor-enter(g.class);
        r103 = (Map) ((HashMap) r102).get(r100);     // Catch: Throwable -> L11
        if (r103 != null) goto L9;
        r103 = new Hashtable();     // Catch: Throwable -> L11
        ((HashMap) r102).put(r100, r103);     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public g(Class r100, LinkedHashSet r101, LinkedHashSet r102) {
        this.f495395a = r100;
        this.f495396b = r101;
        this.f495397c = r102;
    }

    public static <T extends e> void b(String r100, Class<T> r101, d r102) {
        Map<String, List<Pair<Class<? extends e>, d>>> r103 = f495393i;
        List r104 = (List) ((HashMap) r103).get(r100);
        if (r104 == null) goto L5;
    L14:
        Pair r105 = new Pair(r101, r102);
        monitor-enter(g.class);
        r104.add(r105);     // Catch: Throwable -> L19
        monitor-exit(g.class);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    L5:
        monitor-enter(g.class);
        r104 = (List) ((HashMap) r103).get(r100);     // Catch: Throwable -> L11
        if (r104 != null) goto L9;
        r104 = new ArrayList();     // Catch: Throwable -> L11
        ((HashMap) r103).put(r100, r104);     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
