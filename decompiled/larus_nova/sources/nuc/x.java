package nuc;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes42.dex */
public final class x<T> implements r2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<KClass<?>, juc.d<T>> f520797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<Class<?>, m<T>> f520798b;

    /* JADX WARN: Multi-variable type inference failed */
    public x(Function1<? super KClass<?>, ? extends juc.d<T>> r100) {
        Intrinsics.checkNotNullParameter(r100, "compute");
        this.f520797a = r100;
        this.f520798b = new ConcurrentHashMap();
    }

    @Override // nuc.r2
    public final juc.d<T> a(KClass<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ConcurrentHashMap<Class<?>, m<T>> r101 = this.f520798b;
        Class<?> r102 = JvmClassMappingKt.getJavaClass(r100);
        m<T> r103 = r101.get(r102);
        if (r103 != null) goto L9;
        r103 = new m(this.f520797a.invoke(r100));
        m<T> r104 = r101.putIfAbsent(r102, r103);
        if (r104 == null) goto L9;
        r103 = r104;
    L9:
        return r103.f520735a;
    }
}
