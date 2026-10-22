package defpackage;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import t1a.a;
import t1a.b;
import t1a.c;
import t1a.e;
import t1a.f;

/* JADX INFO: loaded from: classes42.dex */
public final class t0 implements b {
    public t0() {
    }

    @Override // t1a.b
    public final <T extends c> T g(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return null;
    }

    @Override // t1a.b
    public final <T extends f> void h(KClass<T> r100, m1a.c<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "widget");
    }

    @Override // t1a.b
    public final <T extends c> void i(T r100, KClass<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "clazz");
    }

    @Override // t1a.b
    public final <T extends a> void k(T r100, KClass<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        Intrinsics.checkNotNullParameter(r101, "clazz");
    }

    @Override // t1a.b
    public final <T extends a> void l(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
    }

    @Override // t1a.b
    public final <T extends a> T o(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return null;
    }

    @Override // t1a.b
    public final <T extends c> e<T> p(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return null;
    }

    public final <T extends c> void s(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
    }

    @Override // t1a.b
    public final <T extends c> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        g(JvmClassMappingKt.getKotlinClass(r100));
        return null;
    }

    @Override // t1a.b
    public final <T extends a> void b(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        l(JvmClassMappingKt.getKotlinClass(r100));
    }

    @Override // t1a.b
    public final <T extends a> T d(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        q(JvmClassMappingKt.getKotlinClass(r100));
        throw null;
    }

    @Override // t1a.b
    public final <T extends c> e<T> e(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        p(JvmClassMappingKt.getKotlinClass(r100));
        return null;
    }

    @Override // t1a.b
    public final <T extends c> T f(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        r(JvmClassMappingKt.getKotlinClass(r100));
        throw null;
    }

    @Override // t1a.b
    public final <T extends a> T getAbility(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        o(JvmClassMappingKt.getKotlinClass(r100));
        return null;
    }

    @Override // t1a.b
    public final <T extends f> m1a.c<T> j(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        throw new IllegalStateException("getComposeWidget null " + r100.getSimpleName() + ", Check whether still trying to call getComposeWidget() after fragment detached.");
    }

    @Override // t1a.b
    public final <T extends c> void m(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        s(JvmClassMappingKt.getKotlinClass(r100));
    }

    public final <T extends a> T q(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        throw new IllegalStateException("getAbilityNotNull null " + r100.getSimpleName() + ", Check whether still trying to call getAbilityNotNull() after fragment detached.");
    }

    public final <T extends c> T r(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        throw new IllegalStateException("getDataNotNull null " + r100.getSimpleName() + ", Check whether still trying to call getDataNotNull() after fragment detached.");
    }

    @Override // t1a.b
    public final <T extends a> void c(T r100, Class<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        k(r100, JvmClassMappingKt.getKotlinClass(r101));
    }

    @Override // t1a.b
    public final <T extends c> void n(T r100, Class<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        i(r100, JvmClassMappingKt.getKotlinClass(r101));
    }
}
