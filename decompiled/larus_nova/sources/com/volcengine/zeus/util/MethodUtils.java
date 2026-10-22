package com.volcengine.zeus.util;

import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MethodUtils {
    public static final Class<?>[] EMPTY_CLASS_ARRAY = null;
    private static Map<String, Method> sMethodCache;
    private static final HashMap<Class<?>, Class<?>> sPrimitiveToWrapperMap = null;

    public MethodUtils() {
    }

    static {
        sMethodCache = new HashMap();
        HashMap<Class<?>, Class<?>> r100 = new HashMap();
        sPrimitiveToWrapperMap = r100;
        r100.put(Boolean.TYPE, Boolean.class);
        r100.put(Byte.TYPE, Byte.class);
        r100.put(Character.TYPE, Character.class);
        r100.put(Short.TYPE, Short.class);
        r100.put(Integer.TYPE, Integer.class);
        r100.put(Long.TYPE, Long.class);
        r100.put(Double.TYPE, Double.class);
        r100.put(Float.TYPE, Float.class);
        r100.put(Void.TYPE, Void.class);
        EMPTY_CLASS_ARRAY = new Class[0];
    }

    public static Class<?>[] toClass(Object... r100) {
        if (r100 == null) goto L15;
        if (r100.length == 0) goto L15;
        Class<?>[] r101 = new Class[r100.length];
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L13;
        Object r103 = r100[r102];
        if (r103 != null) goto L11;
        Class<?> r104 = null;
    L12:
        r101[r102] = r104;
        r102 = r102 + 1;
        goto L7
    L11:
        r104 = r103.getClass();
        goto L12
    L13:
        return r101;
    L15:
        return EMPTY_CLASS_ARRAY;
    }

    public static <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> r100, Class<?>... r101) {
        Constructor<T> r102 = r100.getDeclaredConstructor(r101);     // Catch: NoSuchMethodException -> L6
        if (r102.isAccessible() == true) goto L5;
        r102.setAccessible(true);     // Catch: NoSuchMethodException -> L6
    L5:
        return r102;
    L6:
        return null;
    }

    public static boolean isAssignableFrom(Class<?> r100, Class<?> r101) {
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r100 != null) goto L9;
        return !r101.isPrimitive();
    L9:
        if (r100.isPrimitive() == false) goto L14;
        if (r101.isPrimitive() == true) goto L14;
        r100 = sPrimitiveToWrapperMap.get(r100);
    L14:
        if (r101.isPrimitive() == false) goto L19;
        if (r100.isPrimitive() == true) goto L19;
        r101 = sPrimitiveToWrapperMap.get(r101);
    L19:
        return r101.isAssignableFrom(r100);
    }

    public static Method findMethod(Class<?> r100, String r101, Class<?>... r102) throws NoSuchMethodException {
    L2:
        if (r100 == null) goto L9;
        Method r103 = r100.getDeclaredMethod(r101, r102);     // Catch: NoSuchMethodException -> L7
        if (r103.isAccessible() == true) goto L6;
        r103.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L6:
        return r103;
    L7:
        r100 = r100.getSuperclass();
        goto L2
    L9:
        throw new NoSuchMethodException("Method " + r101 + " with parameters " + Arrays.asList(r102) + " not found in " + r100);
    }

    public static Method getAccessibleMethod(Class<?> r110, String r111, Class<?>... r112) {
        String r100 = getKey(r110, r111, r112);
        Map<String, Method> r101 = sMethodCache;
        monitor-enter(r101);
        Method r102 = sMethodCache.get(r100);     // Catch: Throwable -> L53
        monitor-exit(r101);     // Catch: Throwable -> L53
        if (r102 != null) goto L9;
    L12:
        if (r110 == null) goto L51;
        r102 = r110.getDeclaredMethod(r111, r112);     // Catch: NoSuchMethodException -> L15
    L16:
        if (r102 == null) goto L58;
    L41:
        if (r102 != null) goto L42;
        r110 = r110.getSuperclass();
        goto L12
    L42:
        r102.setAccessible(true);
        Map<String, Method> r103 = sMethodCache;
        monitor-enter(r103);
        sMethodCache.put(r100, r102);     // Catch: Throwable -> L47
        monitor-exit(r103);     // Catch: Throwable -> L47
        return r102;
    L47:
        th = move-exception;
        throw th;
    L58:
        Method[] r104 = r110.getDeclaredMethods();     // Catch: Throwable -> L40
        int r105 = r104.length;     // Catch: Throwable -> L40
        int r106 = 0;
    L18:
        if (r106 >= r105) goto L41;
        Method r107 = r104[r106];     // Catch: Throwable -> L40
        if (r107 == null) goto L39;
        if (TextUtils.equals(r107.getName(), r111) == false) goto L39;
        Class<?>[] r108 = r107.getParameterTypes();     // Catch: Throwable -> L40
        if (r112 == null) goto L39;
        if (r108 == null) goto L39;
        if (r112.length != r108.length) goto L39;
        int r109 = 0;
        boolean r113 = true;
    L32:
        if (r109 >= r112.length) goto L37;
        if (isAssignableFrom(r112[r109], r108[r109]) == true) goto L36;
        r113 = false;
    L36:
        r109 = r109 + 1;
        goto L32
    L37:
        if (r113 == false) goto L39;
        r102 = r107;
    L39:
        r106 = r106 + 1;
        goto L18
    L51:
        return null;
    L9:
        if (r102.isAccessible() == true) goto L11;
        r102.setAccessible(true);
    L11:
        return r102;
    L53:
        th = move-exception;
        throw th;
    }

    private static String getKey(Class<?> r100, String r101, Class<?>... r102) {
        StringBuilder r103 = new StringBuilder();
        r103.append(r100.toString());
        r103.append("#");
        r103.append(r101);
        r103.append("#");
        if (r100.getClassLoader() == null) goto L5;
        Object r104 = Integer.valueOf(r100.getClassLoader().hashCode());
    L6:
        r103.append(r104);
        if (r102 != null) goto L9;
    L13:
        r103.append(Void.class.toString());
    L15:
        return r103.toString();
    L9:
        if (r102.length <= 0) goto L13;
        int r105 = r102.length;
        int r106 = 0;
    L11:
        if (r106 >= r105) goto L15;
        r103.append(r102[r106].toString());
        r103.append("#");
        r106 = r106 + 1;
        goto L11
    L5:
        r104 = "";
        goto L6
    }

    public static <T> T invokeConstructor(Class<T> r100, Object[] r101, Class<?>[] r102) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor r103 = getMatchingAccessibleConstructor(r100, r102);
        if (r103 != null) goto L5;
        return null;
    L5:
        return (T) r103.newInstance(r101);
    }

    public static Object invokeMethod(Object r100, String r101, Object... r102) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeMethod(r100, r101, r102, toClass(r102));
    }

    public static Object invokeStaticMethod(Class r100, String r101, Object... r102) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeStaticMethod(r100, r101, r102, toClass(r102));
    }

    public static Object invokeMethod(Object r100, String r101, Object[] r102, Class<?>[] r103) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method r104 = getAccessibleMethod(r100.getClass(), r101, r103);
        if (r104 == null) goto L7;
        return r104.invoke(r100, r102);
    L7:
        throw new NoSuchMethodException(r101);
    }

    public static Object invokeStaticMethod(Class r100, String r101, Object[] r102, Class<?>[] r103) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method r104 = getAccessibleMethod(r100, r101, r103);
        if (r104 != null) goto L5;
        return null;
    L5:
        return r104.invoke(null, r102);
    }
}
