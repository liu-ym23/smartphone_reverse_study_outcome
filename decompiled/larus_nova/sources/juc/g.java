package juc;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes42.dex */
public final class g<T> extends nuc.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClass<T> f500517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<? extends Annotation> f500518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f500519c;

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return (luc.f) this.f500519c.getValue();
    }

    public final String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + this.f500517a + ')';
    }

    @Override // nuc.b
    public final KClass<T> c() {
        return this.f500517a;
    }

    public g(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "baseClass");
        this.f500517a = r100;
        this.f500518b = CollectionsKt.emptyList();
        this.f500519c = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new e(this));
    }

    public g(KClass<T> r100, Annotation[] r101) {
        Intrinsics.checkNotNullParameter(r100, "baseClass");
        Intrinsics.checkNotNullParameter(r101, "classAnnotations");
        this(r100);
        this.f500518b = ArraysKt.asList(r101);
    }
}
