package fj6;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import li6.c;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements li6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f477479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ei6.a f477480b;

    /* JADX INFO: renamed from: fj6.a$a, reason: collision with other inner class name */
    public static final class C5917a {
    }

    static {
    }

    @Override // li6.a
    public final void release() {
        this.f477479a.clear();
    }

    public a(ei6.a r100) {
        this.f477480b = r100;
        this.f477479a = new ConcurrentHashMap();
    }

    @Override // li6.a
    public final c b(String r100) {
        return hj6.a.a(r100);
    }

    @Override // li6.a
    public final <T> T a(String r100, KClass<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        T r102 = (T) this.f477479a.get(r100);
        if (r101 != null) goto L5;
    L9:
        if (r102 == null) goto L12;
        return r102;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type T");
    L5:
        if (r101.isInstance(r102) == true) goto L9;
        return null;
    }

    @Override // li6.a
    public Object update(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "updateValue");
        int r102 = ej6.a.f472874a;
        ej6.a.c("ParamsManager", "update " + r100 + " with " + r101);
        return this.f477479a.put(r100, r101);
    }
}
