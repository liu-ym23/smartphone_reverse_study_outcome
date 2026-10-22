package com.google.common.reflect;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class a<T, R> implements AnnotatedElement, Member {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccessibleObject f275686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Member f275687b;

    /* JADX INFO: renamed from: com.google.common.reflect.a$a, reason: collision with other inner class name */
    public static class C3860a<T> extends a<T, T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Constructor<?> f275688c;

        public C3860a(Constructor<?> r100) {
            super(r100);
            this.f275688c = r100;
        }
    }

    public static class b<T> extends a<T, Object> {
        public b(Method r100) {
            super(r100);
        }
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static void a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class.forName("java.lang.reflect.AnnotatedType");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a("java.lang.reflect.AnnotatedType");     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("java.lang.reflect.AnnotatedType");
    L12:
        throw th;
    L34:
        Class.forName("java.lang.reflect.AnnotatedType");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a("java.lang.reflect.AnnotatedType");     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("java.lang.reflect.AnnotatedType");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.forName("java.lang.reflect.AnnotatedType");
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.f275686a.getAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.f275686a.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) this.f275687b.getDeclaringClass();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.f275687b.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.f275687b.getName();
    }

    public final int hashCode() {
        return this.f275687b.hashCode();
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.f275687b.isSynthetic();
    }

    public String toString() {
        return this.f275687b.toString();
    }

    public TypeToken<T> b() {
        return TypeToken.of(getDeclaringClass());
    }

    static {
        a();     // Catch: ClassNotFoundException -> L4
        return;
    }

    public <M extends AccessibleObject & Member> a(M r100) {
        r100.getClass();
        this.f275686a = r100;
        this.f275687b = r100;
    }

    public final boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (b().equals(r101.b()) == true) goto L7;
        return false;
    L7:
        if (this.f275687b.equals(r101.f275687b) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // java.lang.reflect.AnnotatedElement
    @CheckForNull
    public final <A extends Annotation> A getAnnotation(Class<A> r100) {
        return (A) this.f275686a.getAnnotation(r100);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> r100) {
        return this.f275686a.isAnnotationPresent(r100);
    }
}
