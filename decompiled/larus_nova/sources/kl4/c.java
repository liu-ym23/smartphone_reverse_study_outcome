package kl4;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements fl4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<KClass<?>, Object> f503854a;

    public c() {
        this.f503854a = MapsKt.mapOf(new Pair[]{TuplesKt.to(Reflection.getOrCreateKotlinClass(k.class), new f()), TuplesKt.to(Reflection.getOrCreateKotlinClass(h.class), new b()), TuplesKt.to(Reflection.getOrCreateKotlinClass(j.class), new e()), TuplesKt.to(Reflection.getOrCreateKotlinClass(i.class), new d())});
    }

    @Override // fl4.b
    public final <T> T a(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        T r101 = (T) this.f503854a.get(r100);
        if (r101 != null) goto L5;
        r101 = null;
    L5:
        if (r101 == null) goto L8;
        return r101;
    L8:
        throw new IllegalStateException("No provider found for " + r100.getSimpleName());
    }
}
