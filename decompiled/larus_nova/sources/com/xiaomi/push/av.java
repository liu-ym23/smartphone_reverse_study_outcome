package com.xiaomi.push;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes41.dex */
public class av {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f463158a = null;

    public static class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<? extends T> f463159a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final T f253a;
    }

    static {
        HashMap r100 = new HashMap();
        f463158a = r100;
        Class r101 = Boolean.TYPE;
        r100.put(Boolean.class, r101);
        r100.put(Byte.class, Byte.TYPE);
        r100.put(Character.class, Character.TYPE);
        r100.put(Short.class, Short.TYPE);
        Class r102 = Integer.TYPE;
        r100.put(Integer.class, r102);
        Class r103 = Float.TYPE;
        r100.put(Float.class, r103);
        Class r104 = Long.TYPE;
        r100.put(Long.class, r104);
        r100.put(Double.class, Double.TYPE);
        r100.put(r101, r101);
        Class r105 = Byte.TYPE;
        r100.put(r105, r105);
        Class r106 = Character.TYPE;
        r100.put(r106, r106);
        Class r107 = Short.TYPE;
        r100.put(r107, r107);
        r100.put(r102, r102);
        r100.put(r103, r103);
        r100.put(r104, r104);
        Class r108 = Double.TYPE;
        r100.put(r108, r108);
    }

    private static Class<?>[] a(Object... r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.length <= 0) goto L25;
        Class<?>[] r101 = new Class[r100.length];
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L20;
        Object r103 = r100[r102];
        if (r103 != null) goto L12;
    L14:
        if (r103 != null) goto L16;
        Class<?> r104 = null;
    L17:
        r101[r102] = r104;
    L18:
        r102 = r102 + 1;
        goto L8
    L16:
        r104 = r103.getClass();
        goto L17
    L12:
        if ((r103 instanceof a) == false) goto L14;
        r101[r102] = ((a) r103).f463159a;
        goto L18
    L20:
        return r101;
    L25:
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static Object[] m8825a(Object... r100) {
        if (r100 != null) goto L4;
    L15:
        return null;
    L4:
        if (r100.length <= 0) goto L15;
        Object[] r101 = new Object[r100.length];
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L20;
        Object r103 = r100[r102];
        if (r103 != null) goto L11;
    L13:
        r101[r102] = r103;
    L14:
        r102 = r102 + 1;
        goto L7
    L11:
        if ((r103 instanceof a) == false) goto L13;
        r101[r102] = ((a) r103).f253a;
        goto L14
    L20:
        return r101;
    }

    private static boolean a(Class<?>[] r100, Class<?>[] r101) {
        if (r100 != null) goto L10;
        if (r101 != null) goto L6;
        return true;
    L6:
        if (r101.length == 0) goto L40;
        return false;
    L40:
        return true;
    L10:
        if (r101 != null) goto L17;
        if (r100.length == 0) goto L41;
        return false;
    L41:
        return true;
    L17:
        if (r100.length == r101.length) goto L19;
        return false;
    L19:
        int r102 = 0;
    L21:
        if (r102 >= r100.length) goto L32;
        Class<?> r103 = r101[r102];
        if (r103 == null) goto L31;
        if (r100[r102].isAssignableFrom(r103) == true) goto L31;
        Map<Class<?>, Class<?>> r104 = f463158a;
        if (r104.containsKey(r100[r102]) == false) goto L30;
        if (r104.get(r100[r102]).equals(r104.get(r101[r102])) == true) goto L31;
    L30:
        return false;
    L31:
        r102 = r102 + 1;
        goto L21
    L32:
        return true;
    }

    public static <T> T a(Object r100, String r101) {
        return (T) a(r100.getClass(), r100, r101);
    L4:
        e = move-exception;
        Objects.toString(r100);
        e.toString();
        return null;
    }

    public static <T> T a(String r100, String r101) {
        return (T) a(q.a(null, r100), null, r101);
    L5:
        e = move-exception;
        e.toString();
        return null;
    }

    public static <T> T a(Class<? extends Object> r100, String r101) {
        return (T) a(r100, null, r101);
    L5:
        e = move-exception;
        e.toString();
        return null;
    }

    private static Method a(Method[] r100, String r101, Class<?>[] r102) {
        if (r101 == null) goto L14;
        int r103 = r100.length;
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L11;
        Method r105 = r100[r104];
        if (r105.getName().equals(r101) == false) goto L10;
        if (a(r105.getParameterTypes(), r102) == false) goto L10;
        return r105;
    L10:
        r104 = r104 + 1;
        goto L4
    L11:
        return null;
    L14:
        throw new NullPointerException("Method name must not be null.");
    }

    public static void b(Object r100, String r101, Object r102) {
        Class<?> r103 = r100.getClass();
        Field r104 = null;
    L3:
        if (r104 != null) goto L11;
        r104 = r103.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L6
    L7:
        if (r103 != null) goto L3;
        throw new NoSuchFieldException();
    L6:
        r103 = r103.getSuperclass();
        goto L7
    L11:
        r104.setAccessible(true);
        r104.set(r100, r102);
    }

    private static Method a(Class<?> r100, String r101, Class<?>... r102) {
        Method r103 = a(r100.getDeclaredMethods(), r101, r102);
        if (r103 == null) goto L5;
        r103.setAccessible(true);
        return r103;
    L5:
        if (r100.getSuperclass() == null) goto L9;
        return a(r100.getSuperclass(), r101, r102);
    L9:
        throw new NoSuchMethodException();
    }

    public static <T> T b(Object r100, String r101, Object... r102) {
        return (T) a(r100.getClass(), r101, a(r102)).invoke(r100, m8825a(r102));
    }

    public static <T> T a(Class<? extends Object> r100, Object r101, String r102) {
        Field r103 = null;
    L4:
        if (r103 != null) goto L12;
        r103 = r100.getDeclaredField(r102);     // Catch: NoSuchFieldException -> L7
        r103.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L8:
        if (r100 != null) goto L4;
        throw new NoSuchFieldException();
    L7:
        r100 = r100.getSuperclass();
        goto L8
    L12:
        r103.setAccessible(true);
        return (T) r103.get(r101);
    }

    public static <T> T a(Class<?> r100, String r101, Object... r102) {
        return (T) a(r100, r101, a(r102)).invoke(null, m8825a(r102));
    }

    public static <T> T a(String r100, String r101, Object... r102) {
        return (T) a(q.a(null, r100), r101, r102);
    L5:
        e = move-exception;
        e.toString();
        return null;
    }

    public static <T> T a(Object r100, String r101, Object... r102) {
        return (T) b(r100, r101, r102);
    L4:
        e = move-exception;
        Objects.toString(r100);
        e.toString();
        return null;
    }

    public static void a(Object r100, String r101, Object r102) {
        b(r100, r101, r102);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Objects.toString(r100);
        e.toString();
    }
}
