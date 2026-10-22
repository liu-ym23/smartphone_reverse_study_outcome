package s26;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import q26.g;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Class<?>, g<?>> f540303a;

    public final Map<Class<?>, Object> b() {
        ConcurrentHashMap r100 = new ConcurrentHashMap();
        Iterator<Map.Entry<Class<?>, g<?>>> r101 = this.f540303a.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<Class<?>, g<?>> r102 = r101.next();
        r100.put(r102.getKey(), r102.getValue().provideInstance());
        goto L4
    L6:
        return r100;
    }

    public b() {
        this.f540303a = new ConcurrentHashMap();
    }

    public final <T> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        g<?> r101 = this.f540303a.get(r100);
        if (r101 == null) goto L13;
        Object r102 = r101.provideInstance();
        if (r102 != null) goto L7;
        return null;
    L7:
        if (r100.isAssignableFrom(r102.getClass()) == true) goto L10;
        r102 = null;
    L10:
        if (r102 != null) goto L12;
        return null;
    L12:
        return (T) r102;
    L13:
        return null;
    }

    public final <T> void c(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (r101 == null) goto L6;
        this.f540303a.put(r100, new c(r101));
        return;
    }
}
