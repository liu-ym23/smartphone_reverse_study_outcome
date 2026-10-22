package com.lark.kmp.containerization;

import buc.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes43.dex */
public final class Container implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f278579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e<Map<KClass<?>, ServiceEntry>> f278580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e<Map<KClass<?>, List<ServiceEntry.LazyFactory>>> f278581c;

    public static abstract class ServiceEntry {

        public static final class LazyFactory extends ServiceEntry {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Function0<Object> f278582a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Lazy f278583b;

            public LazyFactory(Function0<? extends Object> r100) {
                Intrinsics.checkNotNullParameter(r100, "factory");
                this.f278582a = r100;
                this.f278583b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Container$ServiceEntry$LazyFactory$instance$2(this));
            }
        }

        public static final class a extends ServiceEntry {
        }

        public ServiceEntry() {
        }
    }

    public Container(b r100) {
        this.f278579a = r100;
        this.f278580b = buc.b.d(MapsKt.emptyMap());
        this.f278581c = buc.b.d(MapsKt.emptyMap());
    }

    @Override // com.lark.kmp.containerization.b
    public final <T> T a(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "symbol");
        ServiceEntry r101 = this.f278580b.c().get(r100);
        if (r101 != null) goto L5;
        b r102 = this.f278579a;
        if (r102 != null) goto L16;
        return null;
    L16:
        return (T) r102.a(r100);
    L5:
        if ((r101 instanceof ServiceEntry.a) == false) goto L8;
        ServiceEntry.a r103 = (ServiceEntry.a) r101;
        Intrinsics.checkNotNull(null, "null cannot be cast to non-null type T of com.lark.kmp.containerization.Container.get");
        return null;
    L8:
        if ((r101 instanceof ServiceEntry.LazyFactory) == false) goto L12;
        T r104 = (T) ((ServiceEntry.LazyFactory) r101).f278583b.getValue();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type T of com.lark.kmp.containerization.Container.get");
        return r104;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.lark.kmp.containerization.b
    public final <T> List<T> b(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "symbol");
        List<ServiceEntry.LazyFactory> r101 = this.f278581c.c().get(r100);
        if (r101 == null) goto L8;
        List<ServiceEntry.LazyFactory> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L15;
        Object r105 = ((ServiceEntry.LazyFactory) r104.next()).f278583b.getValue();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type T of com.lark.kmp.containerization.Container.getAll");
        r103.add(r105);
        goto L6
    L15:
        return r103;
    L8:
        b r106 = this.f278579a;
        if (r106 == null) goto L12;
        return r106.b(r100);
    L12:
        return CollectionsKt.emptyList();
    }

    @Override // com.lark.kmp.containerization.b
    public final <T> void c(KClass<T> r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "symbol");
        Intrinsics.checkNotNullParameter(r101, "factory");
        e<Map<KClass<?>, ServiceEntry>> r102 = this.f278580b;
    L3:
        Map<KClass<?>, ServiceEntry> r103 = r102.c();
        if (r102.a(r103, MapsKt.plus(r103, TuplesKt.to(r100, new ServiceEntry.LazyFactory(r101)))) == false) goto L3;
    }
}
