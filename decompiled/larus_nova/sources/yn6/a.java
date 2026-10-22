package yn6;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f568561a = null;

    public a() {
    }

    static {
        f568561a = new c();
    }

    public static ConcurrentHashMap d() {
        return f568561a.f568563b.f568565b;
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        c r101 = f568561a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "domain");
        if (b.a(r100) == false) goto L7;
        r101.f568562a.remove(r100);
        return;
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "domain");
        c r102 = f568561a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "domain");
        ConcurrentHashMap<String, WeakReference<Object>> r103 = r102.f568562a.get(r101);
        if (r103 == null) goto L6;
        WeakReference<Object> r104 = r103.remove(r100);
        return;
    }

    public static boolean c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "domain");
        c r102 = f568561a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "domain");
        ConcurrentHashMap<String, WeakReference<Object>> r103 = r102.f568562a.get(r101);
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.containsKey(r100);
    }

    public static void i(String r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        Intrinsics.checkNotNullParameter(r101, "callback");
        c r102 = f568561a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "domain");
        Intrinsics.checkNotNullParameter(r101, "callback");
        d r103 = r102.f568563b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "domain");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (b.a(r100) == false) goto L30;
        ConcurrentHashMap<String, ArrayList<f>> r104 = r103.f568564a.get(r100);
        if (r104 == null) goto L27;
        ArrayList<f> r105 = r104.get("");
        if (r105 == null) goto L28;
        Iterator<T> r106 = r105.iterator();
        f r107 = null;
    L11:
        if (r106.hasNext() == false) goto L19;
        f r108 = (f) r106.next();
        WeakReference<e> r109 = r108.a();
        if (r109 == null) goto L15;
        e r110 = r109.get();
    L17:
        if (Intrinsics.areEqual(r110, r101) == false) goto L11;
        r107 = r108;
        goto L11
    L15:
        r110 = null;
        goto L17
    L19:
        if (r107 == null) goto L29;
        TypeIntrinsics.asMutableCollection(r105).remove(r107);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    }

    public static Object e(String r100, Object r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "domain");
        return f568561a.a(r100, r101, r102);
    }

    public static boolean f(String r100, Object r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "domain");
        c r103 = f568561a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "domain");
        if (b.b(r100) == true) goto L6;
        return false;
    L6:
        if (r103.f568562a.containsKey(r102) == true) goto L8;
        r103.f568562a.put(r102, new ConcurrentHashMap());
    L8:
        ConcurrentHashMap<String, WeakReference<Object>> r104 = r103.f568562a.get(r102);
        if (r104 == null) goto L50;
        WeakReference<Object> r105 = r104.get(r100);
        if (r105 == null) goto L13;
        Object r106 = r105.get();
    L14:
        r104.put(r100, new WeakReference(r101));
        d r107 = r103.f568563b;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r102, "domain");
        Intrinsics.checkNotNullParameter(r100, "key");
        ConcurrentHashMap<String, ArrayList<f>> r108 = r107.f568564a.get(r102);
        if (r108 == null) goto L32;
        ArrayList<f> r109 = r108.get("");
        if (r109 == null) goto L32;
        Iterator<T> r110 = r109.iterator();
    L20:
        if (r110.hasNext() == false) goto L32;
        f r111 = (f) r110.next();
        if (r111.b() == false) goto L26;
        if (Intrinsics.areEqual(r101, r106) == true) goto L26;
    L27:
        WeakReference<e> r112 = r111.a();
        if (r112 == null) goto L20;
        e r113 = r112.get();
        if (r113 == null) goto L20;
        r113.a(r102, r100, r101, r106);
    L26:
        if (r111.b() == true) goto L20;
    L32:
        ConcurrentHashMap<String, ArrayList<f>> r114 = r107.f568564a.get(r102);
        if (r114 == null) goto L50;
        ArrayList<f> r115 = r114.get(r100);
        if (r115 == null) goto L50;
        Iterator<T> r116 = r115.iterator();
    L38:
        if (r116.hasNext() == false) goto L50;
        f r117 = (f) r116.next();
        if (r117.b() == false) goto L44;
        if (Intrinsics.areEqual(r101, r106) == true) goto L44;
    L45:
        WeakReference<e> r118 = r117.a();
        if (r118 == null) goto L38;
        e r119 = r118.get();
        if (r119 == null) goto L38;
        r119.a(r102, r100, r101, r106);
    L44:
        if (r117.b() == true) goto L38;
    L13:
        r106 = null;
    L50:
        return true;
    }

    public static boolean g(String r100, e r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "domain");
        Intrinsics.checkNotNullParameter(r101, "callback");
        c r103 = f568561a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "domain");
        Intrinsics.checkNotNullParameter(r101, "callback");
        d r104 = r103.f568563b;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "domain");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (b.a(r100) == false) goto L45;
        ConcurrentHashMap<String, ArrayList<f>> r105 = r104.f568564a.get(r100);
        if (r105 == null) goto L25;
        ArrayList<f> r106 = r105.get("");
        if (r106 == null) goto L25;
        if (r106.isEmpty() == true) goto L22;
        Iterator<T> r107 = r106.iterator();
    L14:
        if (r107.hasNext() == false) goto L22;
        WeakReference<e> r108 = ((f) r107.next()).a();
        if (r108 == null) goto L18;
        e r109 = r108.get();
    L20:
        if (Intrinsics.areEqual(r109, r101) == false) goto L14;
        boolean r110 = true;
    L23:
        if (r110 != true) goto L25;
        boolean r111 = true;
    L26:
        if (r111 == false) goto L29;
        return false;
    L29:
        if (r104.f568564a.containsKey(r100) == true) goto L31;
        r104.f568564a.put(r100, new ConcurrentHashMap());
    L31:
        ConcurrentHashMap<String, ArrayList<f>> r112 = r104.f568564a.get(r100);
        if (r112 != null) goto L34;
        return false;
    L34:
        if (r112.containsKey("") == true) goto L36;
        r112.put("", new ArrayList());
    L36:
        ArrayList<f> r113 = r112.get("");
        if (r113 == null) goto L39;
        f r114 = new f(new WeakReference(r101));
        r114.c(r102);
        r113.add(r114);
    L39:
        return true;
    L18:
        r109 = null;
    L22:
        r110 = false;
    L25:
        r111 = false;
        goto L26
    L45:
        return false;
    }

    public static void j(String r100, e r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "domain");
        c r103 = f568561a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "domain");
        d r104 = r103.f568563b;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r102, "domain");
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (b.b(r100) == false) goto L30;
        ConcurrentHashMap<String, ArrayList<f>> r105 = r104.f568564a.get(r102);
        if (r105 == null) goto L27;
        ArrayList<f> r106 = r105.get(r100);
        if (r106 == null) goto L28;
        Iterator<T> r107 = r106.iterator();
        f r108 = null;
    L11:
        if (r107.hasNext() == false) goto L19;
        f r109 = (f) r107.next();
        WeakReference<e> r110 = r109.a();
        if (r110 == null) goto L15;
        e r111 = r110.get();
    L17:
        if (Intrinsics.areEqual(r111, r101) == false) goto L11;
        r108 = r109;
        goto L11
    L15:
        r111 = null;
        goto L17
    L19:
        if (r108 == null) goto L29;
        TypeIntrinsics.asMutableCollection(r106).remove(r108);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    }

    public static boolean h(String r100, e r101, String r102, boolean r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "domain");
        c r103 = f568561a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "domain");
        d r104 = r103.f568563b;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r102, "domain");
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "callback");
        boolean r105 = false;
        if (b.b(r100) == false) goto L40;
        ConcurrentHashMap<String, ArrayList<f>> r106 = r104.f568564a.get(r102);
        if (r106 == null) goto L25;
        ArrayList<f> r107 = r106.get(r100);
        if (r107 == null) goto L25;
        if (r107.isEmpty() == true) goto L22;
        Iterator<T> r108 = r107.iterator();
    L14:
        if (r108.hasNext() == false) goto L22;
        WeakReference<e> r109 = ((f) r108.next()).a();
        if (r109 == null) goto L18;
        e r112 = r109.get();
    L20:
        if (Intrinsics.areEqual(r112, r101) == false) goto L14;
        boolean r113 = true;
    L23:
        if (r113 != true) goto L25;
        boolean r114 = true;
    L26:
        if (r114 == true) goto L40;
        if (r104.f568564a.containsKey(r102) == true) goto L31;
        r104.f568564a.put(r102, new ConcurrentHashMap());
    L31:
        ConcurrentHashMap<String, ArrayList<f>> r115 = r104.f568564a.get(r102);
        if (r115 == null) goto L40;
        if (r115.containsKey(r100) == true) goto L36;
        r115.put(r100, new ArrayList());
    L36:
        ArrayList<f> r116 = r115.get(r100);
        if (r116 == null) goto L39;
        f r117 = new f(new WeakReference(r101));
        r117.c(r111);
        r116.add(r117);
    L39:
        r105 = true;
        goto L40
    L18:
        r112 = null;
    L22:
        r113 = false;
    L25:
        r114 = false;
    L40:
        if (r110 == false) goto L42;
        r101.a(r102, r100, r103.a(r100, null, r102), null);
    L42:
        return r105;
    }
}
