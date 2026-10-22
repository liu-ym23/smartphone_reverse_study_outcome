package iy5;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Method f496490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Method f496491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Method f496492c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Method f496493d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Method f496494e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Method f496495f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Field f496496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Field f496497h;

    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static AccessibleObject a(AccessibleObject r100) {
        if (r100 != 0) goto L6;
        return null;
    L6:
        if ((r100 instanceof Member) == false) goto L13;
        Member r101 = (Member) r100;
        if (Modifier.isPublic(r101.getModifiers()) == false) goto L13;
        if (Modifier.isPublic(r101.getDeclaringClass().getModifiers()) == false) goto L13;
        return r100;
    L13:
        if (r100.isAccessible() == true) goto L15;
        r100.setAccessible(true);
    L15:
        return r100;
    }

    public final Field b(Class<?> r100, String r101, Class<?> r102) {
        int r103 = 0;
    L7:
        e = move-exception;
        e.printStackTrace();
    L9:
        Method r104 = this.f496492c;
        if (r104 != null) goto L12;
        return null;
    L12:
        Class<?> r105 = r100;
    L45:
        return (Field) a((Field) r104.invoke(r105, new Object[]{r101}));
    L15:
        e = move-exception;
        e.printStackTrace();
        r105 = r105.getSuperclass();
        if (r105 != null) goto L45;
    L22:
        e = move-exception;
        e.printStackTrace();
    L24:
        Method r106 = this.f496493d;
        if (r106 != null) goto L41;
        return null;
    L41:
        Field[] r107 = (Field[]) r106.invoke(r100, new Object[0]);     // Catch: Exception -> L36
        int r108 = r107.length;     // Catch: Exception -> L36
    L28:
        if (r103 >= r108) goto L38;
        Field r109 = r107[r103];     // Catch: Exception -> L36
        if (r109.getName().equals(r101) == false) goto L35;
        if (r109.getType().getName().equals(r102.getName()) == false) goto L35;
        return (Field) a(r109);
    L35:
        r103 = r103 + 1;
    L38:
        return null;
    L36:
        e = move-exception;
        e.printStackTrace();
        goto L38
    L19:
        if (this.f496493d != null) goto L24;
        this.f496493d = Class.class.getDeclaredMethod("getDeclaredFields", new Class[0]);     // Catch: Exception -> L22
        goto L24
    L4:
        if (this.f496492c != null) goto L9;
        this.f496492c = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});     // Catch: Exception -> L7
        goto L9
    }

    public final Method c(Class<?> r100, String r101, Class<?>... r110) {
        int r102 = 0;
    L7:
        e = move-exception;
        e.printStackTrace();
    L9:
        Method r103 = this.f496490a;
        if (r103 != null) goto L12;
        return null;
    L12:
        Class<?> r104 = r100;
    L43:
        return (Method) a((Method) r103.invoke(r104, new Object[]{r101, r110}));
    L15:
        e = move-exception;
        e.printStackTrace();
        r104 = r104.getSuperclass();
        if (r104 != null) goto L43;
    L22:
        e = move-exception;
        e.printStackTrace();
    L24:
        Method r105 = this.f496491b;
        if (r105 != null) goto L45;
        return null;
    L45:
        Method[] r106 = (Method[]) r105.invoke(r100, new Object[0]);     // Catch: Exception -> L38
        int r107 = r106.length;     // Catch: Exception -> L38
    L28:
        if (r102 >= r107) goto L40;
        Method r108 = r106[r102];     // Catch: Exception -> L38
        if (r108.getName().equals(r101) == false) goto L37;
        Class<?>[] r109 = r108.getParameterTypes();     // Catch: Exception -> L38
        if (r109 == null) goto L37;
        if (r109.length != r110.length) goto L37;
        return (Method) a(r108);
    L37:
        r102 = r102 + 1;
    L40:
        return null;
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L40
    L19:
        if (this.f496491b != null) goto L24;
        this.f496491b = Class.class.getDeclaredMethod("getDeclaredMethods", new Class[0]);     // Catch: Exception -> L22
        goto L24
    L4:
        if (this.f496490a != null) goto L9;
        this.f496490a = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class});     // Catch: Exception -> L7
        goto L9
    }
}
