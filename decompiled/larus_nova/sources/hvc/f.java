package hvc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes42.dex */
public final class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f487393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f487394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class[] f487395c;

    public final Method a(Class<?> r100) {
        String r101 = this.f487394b;
        if (r101 != null) goto L23;
        return null;
    L23:
        Method r102 = r100.getMethod(r101, this.f487395c);     // Catch: NoSuchMethodException -> L11
        if ((r102.getModifiers() & 1) == 0) goto L12;
    L13:
        if (r102 == null) goto L20;
        Class<?> r103 = this.f487393a;
        if (r103 == null) goto L20;
        if (r103.isAssignableFrom(r102.getReturnType()) == true) goto L20;
        return null;
    L20:
        return r102;
    L12:
        r102 = null;
        goto L13
    }

    public final Object b(T r100, Object... r101) throws InvocationTargetException {
        Method r102 = a(r100.getClass());
        if (r102 == null) goto L10;
        return r102.invoke(r100, r101);
    L6:
        e = move-exception;
        AssertionError r103 = new AssertionError("Unexpectedly could not call: " + r102);
        r103.initCause(e);
        throw r103;
    L10:
        throw new AssertionError("Method " + this.f487394b + " not supported for object " + r100);
    }

    public final void c(Object r100, Object... r101) {
        Method r102 = a(r100.getClass());     // Catch: InvocationTargetException -> L7
        if (r102 == null) goto L18;
        r102.invoke(r100, r101);     // Catch: IllegalAccessException -> L14 InvocationTargetException -> L7
        return;
    L19:
        return;
    L18:
        return;
    L7:
        e = move-exception;
        Throwable r103 = e.getTargetException();
        if ((r103 instanceof RuntimeException) == true) goto L11;
        AssertionError r104 = new AssertionError("Unexpected exception");
        r104.initCause(r103);
        throw r104;
    L11:
        throw ((RuntimeException) r103);
    }

    public f(Class<?> r100, String r101, Class... r102) {
        this.f487393a = r100;
        this.f487394b = r101;
        this.f487395c = r102;
    }
}
