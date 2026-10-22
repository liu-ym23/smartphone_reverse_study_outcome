package i8a;

import android.app.Application;
import com.lynx.tasm.service.IServiceProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile n f488720c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f488721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, a> f488722b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IServiceProvider f488723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f488724b;

        public a(IServiceProvider r100) {
            this.f488723a = r100;
            this.f488724b = false;
        }
    }

    public static n c() {
        if (f488720c != null) goto L15;
        monitor-enter(n.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f488720c != null) goto L9;
        f488720c = new n();     // Catch: Throwable -> L11
    L9:
        monitor-exit(n.class);     // Catch: Throwable -> L11
    L15:
        return f488720c;
    }

    public n() {
        this.f488722b = new ConcurrentHashMap();
    }

    public final <T extends IServiceProvider> T a(Class<T> r100) {
        a r101 = (a) ((ConcurrentHashMap) this.f488722b).get(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r101.f488724b == true) goto L10;
        Objects.toString(r100);
        return null;
    L10:
        return (T) r101.f488723a;
    }

    public final void b(Application r100) {
        this.f488721a = r100;
        monitor-enter(a.class);
        Iterator r101 = ((ConcurrentHashMap) this.f488722b).entrySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r101.hasNext() == false) goto L10;
        a r102 = (a) ((Map.Entry) r101.next()).getValue();     // Catch: Throwable -> L12
        if (r102.f488724b == true) goto L6;
        r102.f488724b = true;     // Catch: Throwable -> L12
        r102.f488723a.onInitialize(r100);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(a.class);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final <T extends IServiceProvider> void d(T r100) {
        Class<? extends IServiceProvider> r101 = r100.getServiceClass();
        if (r101.isInstance(r100) == false) goto L10;
        a r102 = new a(r100);
        Application r103 = this.f488721a;
        if (r103 == null) goto L8;
        r102.f488724b = true;
        r100.onInitialize(r103);
    L8:
        ((ConcurrentHashMap) this.f488722b).put(r101, r102);
        return;
    }
}
