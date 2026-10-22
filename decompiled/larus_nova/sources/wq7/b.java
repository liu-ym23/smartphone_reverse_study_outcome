package wq7;

import iq7.e;
import iq7.f;
import iq7.g;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f560757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<Class<? extends e>, e> f560758b;

    public b(String r100) {
        this.f560758b = new HashMap();
        this.f560757a = r100;
    }

    public static <T> T b(Class<? extends T> r100) {
        Constructor<?>[] r101 = r100.getDeclaredConstructors();     // Catch: Throwable -> L25
        int r102 = r101.length;     // Catch: Throwable -> L25
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L9;
        Constructor<?> r104 = r101[r103];     // Catch: Throwable -> L25
        if (r104.getParameterTypes().length == 0) goto L10;
        r103 = r103 + 1;
    L10:
        if (r104 == null) goto L24;
        r104.setAccessible(true);     // Catch: InvocationTargetException -> L14 InstantiationException -> L17 IllegalAccessException -> L20 Throwable -> L25
        return (T) r104.newInstance(new Object[0]);
    L14:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L25
    L20:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L25
    L17:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L25
    L24:
        throw new RuntimeException();     // Catch: Throwable -> L25
    L9:
        r104 = null;
    L25:
        Objects.toString(r100);
        kq7.a.a("WebXImpl");
        g.f495392h.getClass();
        throw null;
    }

    @Override // wq7.a
    public final <T extends e> T a(Class<T> r100) {
        T r101 = (T) this.f560758b.get(r100);
        if (r101 == null) goto L5;
    L22:
        return r101;
    L5:
        monitor-enter(f.class);
        r101 = (T) this.f560758b.get(r100);     // Catch: Throwable -> L19
        if (r101 != null) goto L17;
        g r102 = g.a(this.f560757a, r100);     // Catch: Throwable -> L19
        if (r102 == null) goto L16;
        e r103 = (e) b(r102.f495395a);     // Catch: Throwable -> L19
        if ((r103 instanceof pq7.b) == true) goto L13;
        r103 = null;
    L14:
        HashMap<Class<? extends e>, e> r104 = new HashMap(this.f560758b);     // Catch: Throwable -> L19
        r104.put(r100, r103);     // Catch: Throwable -> L19
        this.f560758b = r104;     // Catch: Throwable -> L19
        r101 = (T) r103;
        goto L17
    L13:
        pq7.b r105 = (pq7.b) r103;     // Catch: Throwable -> L19
        r105.b(r102);     // Catch: Throwable -> L19
        r105.getExtendableContext().a(r102.f495396b);     // Catch: Throwable -> L19
        goto L14
    L16:
        throw new Error("nameSpace " + this.f560757a + "& class " + r100.getCanonicalName() + " 's env is null");     // Catch: Throwable -> L19
    L17:
        monitor-exit(f.class);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }
}
