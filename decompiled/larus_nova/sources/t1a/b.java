package t1a;

import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes31.dex */
public interface b {
    <T extends c> T a(Class<T> r100);

    <T extends a> void b(Class<T> r100);

    <T extends a> void c(T r100, Class<? extends T> r101);

    <T extends a> T d(Class<T> r100);

    <T extends c> e<T> e(Class<T> r100);

    <T extends c> T f(Class<T> r100);

    <T extends c> T g(KClass<T> r100);

    <T extends a> T getAbility(Class<T> r100);

    <T extends f> void h(KClass<T> r100, m1a.c<?> r101);

    <T extends c> void i(T r100, KClass<? extends T> r101);

    <T extends f> m1a.c<T> j(KClass<T> r100);

    <T extends a> void k(T r100, KClass<? extends T> r101);

    <T extends a> void l(KClass<T> r100);

    <T extends c> void m(Class<T> r100);

    <T extends c> void n(T r100, Class<? extends T> r101);

    <T extends a> T o(KClass<T> r100);

    <T extends c> e<T> p(KClass<T> r100);
}
