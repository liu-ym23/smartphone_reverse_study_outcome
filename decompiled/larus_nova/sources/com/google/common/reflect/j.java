package com.google.common.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Type> f275702a;

    public void b(Class<?> r100) {
    }

    public void c(GenericArrayType r100) {
    }

    public void d(ParameterizedType r100) {
    }

    public abstract void e(TypeVariable<?> r100);

    public abstract void f(WildcardType r100);

    public j() {
        this.f275702a = new HashSet();
    }

    public final void a(Type... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L30;
        Type r103 = r100[r102];
        if (r103 == null) goto L29;
        if (((HashSet) this.f275702a).add(r103) == false) goto L29;
    L26:
        th = move-exception;
        ((HashSet) this.f275702a).remove(r103);
        throw th;
    L10:
        if ((r103 instanceof TypeVariable) == false) goto L13;
        e((TypeVariable) r103);     // Catch: Throwable -> L26
        goto L29
    L13:
        if ((r103 instanceof WildcardType) == false) goto L16;
        f((WildcardType) r103);     // Catch: Throwable -> L26
        goto L29
    L16:
        if ((r103 instanceof ParameterizedType) == false) goto L19;
        d((ParameterizedType) r103);     // Catch: Throwable -> L26
        goto L29
    L19:
        if ((r103 instanceof Class) == false) goto L22;
        b((Class) r103);     // Catch: Throwable -> L26
        goto L29
    L22:
        if ((r103 instanceof GenericArrayType) == false) goto L25;
        c((GenericArrayType) r103);     // Catch: Throwable -> L26
        goto L29
    L25:
        throw new AssertionError("Unknown type: " + r103);     // Catch: Throwable -> L26
    L29:
        r102 = r102 + 1;
        goto L3
    }
}
