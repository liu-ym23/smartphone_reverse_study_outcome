package jf7;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f498901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f498902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f498903c;

    /* JADX INFO: renamed from: jf7.a$a, reason: collision with other inner class name */
    public static class C6433a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f498904a = null;

        static {
            f498904a = new a();
        }
    }

    public a() {
        Class.class.getDeclaredMethod("getDeclaredConstructor", new Class[]{Class[].class});     // Catch: Exception -> L5
        this.f498901a = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class});     // Catch: Exception -> L5
        this.f498902b = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});     // Catch: Exception -> L5
        this.f498903c = Class.class.getDeclaredMethod("forName", new Class[]{String.class});     // Catch: Exception -> L5
        return;
    }

    @Override // jf7.b, if7.a
    public final Class<?> b(String r100) throws ClassNotFoundException {
        Method r101 = this.f498903c;
        Class<?> r102 = null;
        if (r101 != null) goto L12;
    L8:
        if (r102 == null) goto L11;
        return r102;
    L11:
        return super.b(r100);
    L12:
        r102 = (Class) r101.invoke(null, new Object[]{r100});     // Catch: Exception -> L7
        goto L8
    }

    @Override // jf7.b, if7.a
    public final Field c(Class r100) throws NoSuchFieldException {
        Method r101 = this.f498902b;
        if (r101 != null) goto L13;
    L7:
        Field r102 = null;
    L8:
        if (r102 == null) goto L11;
        return r102;
    L11:
        return r100.getDeclaredField("mService");
    L13:
        r102 = (Field) r101.invoke(r100, new Object[]{"mService"});     // Catch: Exception -> L12
        goto L8
    }

    @Override // jf7.b, if7.a
    public final Method a(Class<?> r100, String r101, Class<?>... r102) throws NoSuchMethodException {
        Method r103 = this.f498901a;
        if (r103 != null) goto L13;
    L7:
        Method r104 = null;
    L8:
        if (r104 == null) goto L11;
        return r104;
    L11:
        return r100.getDeclaredMethod(r101, r102);
    L13:
        r104 = (Method) r103.invoke(r100, new Object[]{r101, r102});     // Catch: Exception -> L12
        goto L8
    }
}
