package fh;

import am3.c;
import am3.g;
import android.util.Base64;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Function0<Map<Class<?>, c<?>>>> f476909a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f476910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<?>, c<?>> f476911c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C5903a f476912d = null;

    /* JADX INFO: renamed from: fh.a$a, reason: collision with other inner class name */
    public static final class C5903a {
        public static final ConcurrentHashMap a() {
            C5903a r100 = a.f476912d;
            if (a.f476910b == true) goto L18;
            monitor-enter(r100);
        L14:
            th = move-exception;
            throw th;
        L6:
            if (a.f476910b == true) goto L12;
            Iterator r101 = ((ArrayList) a.f476909a).iterator();     // Catch: Throwable -> L14
        L9:
            if (r101.hasNext() == false) goto L11;
            Function0 r102 = (Function0) r101.next();     // Catch: Throwable -> L14
            a.f476911c.putAll((Map) r102.invoke());     // Catch: Throwable -> L14
            goto L9
        L11:
            hh.a.a(a.f476911c);     // Catch: Throwable -> L14
            a.f476910b = true;     // Catch: Throwable -> L14
        L12:
            monitor-exit(r100);
        L18:
            return a.f476911c;
        }

        public C5903a() {
        }
    }

    public static final class b<T> implements c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Constructor<T> f476913a;

        public b(Constructor<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "constructor");
            this.f476913a = r100;
        }

        @Override // am3.c
        public final T decode(g r100) throws Exception {
            Intrinsics.checkNotNullParameter(r100, "reader");
            return this.f476913a.newInstance(new Object[]{r100});
        }
    }

    static {
        f476912d = new C5903a();
        f476909a = new ArrayList();
        f476911c = new ConcurrentHashMap();
    }

    public static Object a(Class r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Object r102 = C5903a.a().get(r100);
        if ((r102 instanceof c) == true) goto L5;
        r102 = null;
    L5:
        c r103 = (c) r102;
        if (r103 == null) goto L9;
    L18:
        g r104 = new g();
        r104.k(new am3.b(Base64.decode(r101, 0)));     // Catch: Exception -> L23
        if (r103 == null) goto L30;
        return r103.decode(r104);
    L30:
        return null;
    L23:
        e = move-exception;
        e.toString();
        return null;
    L9:
        if (h.class.isAssignableFrom(r100) == true) goto L28;
    L14:
        r103 = null;
    L15:
        if (r103 != null) goto L18;
        r103 = null;
        goto L18
    L28:
        b r105 = new b(r100.getConstructor(new Class[]{g.class}));     // Catch: NoSuchMethodException -> L13
        C5903a.a().put(r100, r105);     // Catch: NoSuchMethodException -> L13
        r103 = r105;
        goto L15
    }
}
