package com.bytedance.bdp.bdpbase.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import okhttp3.ConnectionPool;

/* JADX INFO: loaded from: classes11.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f201344a = null;

    public static class a<T> {
    }

    static {
        HashMap r100 = new HashMap();
        f201344a = r100;
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

    public static void a(ConnectionPool r100, Object... r101) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        int r102 = 0;
        Object[] r103 = null;
        if (r101.length <= 0) goto L15;
        Class[] r104 = new Class[r101.length];
        int r105 = 0;
    L6:
        if (r105 >= r101.length) goto L16;
        Object r106 = r101[r105];
        if ((r106 instanceof a) == false) goto L10;
        ((a) r106).getClass();
        r104[r105] = null;
    L14:
        r105 = r105 + 1;
        goto L6
    L10:
        if (r106 != null) goto L12;
        Class<?> r107 = null;
    L13:
        r104[r105] = r107;
        goto L14
    L12:
        r107 = r106.getClass();
    L16:
        Method r108 = b(ConnectionPool.class, r104);
        if (r101.length <= 0) goto L27;
        Object[] r109 = new Object[r101.length];
    L20:
        if (r102 >= r101.length) goto L26;
        Object r110 = r101[r102];
        if ((r110 instanceof a) == false) goto L24;
        ((a) r110).getClass();
        r109[r102] = null;
    L25:
        r102 = r102 + 1;
        goto L20
    L24:
        r109[r102] = r110;
        goto L25
    L26:
        r103 = r109;
    L27:
        r108.invoke(r100, r103);
        return;
    L15:
        r104 = null;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Method b(Class r110, Class... r111) throws NoSuchMethodException, SecurityException {
        Method[] r100 = r110.getDeclaredMethods();
        int r101 = r100.length;
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L35;
        Method r103 = r100[r102];
        if (r103.getName().equals("put") == false) goto L34;
        Class<?>[] r104 = r103.getParameterTypes();
        if (r104 != 0) goto L13;
        if (r111 != null) goto L11;
    L31:
        boolean r105 = true;
    L32:
        if (r105 == false) goto L34;
    L36:
        if (r103 == null) goto L38;
        r103.setAccessible(true);
        return r103;
    L38:
        if (r110.getSuperclass() == null) goto L42;
        return b(r110.getSuperclass(), r111);
    L42:
        throw new NoSuchMethodException();
    L11:
        if (r111.length == 0) goto L31;
    L29:
        r105 = false;
        goto L32
    L13:
        if (r111 != null) goto L18;
        if (r104.length != 0) goto L29;
    L18:
        if (r104.length != r111.length) goto L29;
        int r106 = 0;
    L22:
        if (r106 >= r104.length) goto L31;
        if (r104[r106].isAssignableFrom(r111[r106]) == true) goto L30;
        Map<Class<?>, Class<?>> r107 = f201344a;
        HashMap r108 = (HashMap) r107;
        if (r108.containsKey(r104[r106]) == false) goto L29;
        if (((Class) r108.get(r104[r106])).equals(r108.get(r111[r106])) == false) goto L29;
    L30:
        r106 = r106 + 1;
    L34:
        r102 = r102 + 1;
        goto L4
    L35:
        r103 = null;
        goto L36
    }

    public static <T> T c(Object r100, String r101) throws NoSuchFieldException, IllegalAccessException {
        Class<?> r102 = r100.getClass();
        Field r103 = null;
    L4:
        if (r103 != null) goto L12;
        r103 = r102.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L7
        r103.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L8:
        if (r102 != null) goto L4;
        throw new NoSuchFieldException();
    L7:
        r102 = r102.getSuperclass();
        goto L8
    L12:
        r103.setAccessible(true);
        return (T) r103.get(r100);
    }
}
