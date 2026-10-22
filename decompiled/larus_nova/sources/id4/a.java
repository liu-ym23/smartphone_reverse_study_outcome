package id4;

import cd4.p;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements c, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Class<?>, d<?>> f489313a;

    @Override // cd4.p, com.android.ttcjpaysdk.base.framework.container.abs.IRelease
    public final void release() {
        Iterator<Map.Entry<Class<?>, d<?>>> r100 = this.f489313a.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        jd4.a r101 = r100.next().getValue().provideInstance();
        if ((r101 instanceof p) == true) goto L7;
        r100.remove();
        goto L4
    L7:
        r101.release();
        goto L4
    L9:
        this.f489313a.clear();
    }

    public a() {
        this.f489313a = new ConcurrentHashMap();
    }

    @Override // id4.c
    public final <T extends jd4.a> T getCtx(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        d<?> r101 = this.f489313a.get(r100);
        if (r101 == null) goto L13;
        jd4.a r102 = r101.provideInstance();
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

    @Override // id4.c
    public final <T extends jd4.a> void removeCtx(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        this.f489313a.remove(r100);
    }

    @Override // id4.c
    public final <T extends jd4.a> void putCtx(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (r101 == null) goto L5;
        this.f489313a.put(r100, new b(r101));
        return;
    L5:
        this.f489313a.put(r100, new b(null));
    }
}
