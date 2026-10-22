package com.bytedance.mira.util;

import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class MethodUtils {
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
    }

    public static <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> r100, Class<?>... r101) {
        Constructor<T> r102 = ((Class) Preconditions.checkNotNull(r100, "class cannot be null")).getDeclaredConstructor(r101);     // Catch: NoSuchMethodException -> L7
        if (r102.isAccessible() == true) goto L6;
        r102.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L6:
        return r102;
    L7:
        return null;
    }

    public static int getParameterTypeIndex(Method r100, Class<?> r101) {
        if (r100 == null) goto L15;
        if (r101 == null) goto L19;
        Class<?>[] r102 = r100.getParameterTypes();
        if (r102 != null) goto L7;
        return -1;
    L7:
        if (r102.length <= 0) goto L21;
        int r103 = 0;
    L10:
        if (r103 >= r102.length) goto L22;
        if (TextUtils.equals(r101.getName(), r102[r103].getName()) == true) goto L13;
        r103 = r103 + 1;
        goto L10
    L13:
        return r103;
    L22:
        return -1;
    L21:
        return -1;
    L19:
        return -1;
    L15:
        return -1;
    }

    public static <T> T invokeConstructor(Class<T> r100, Object... r101) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] r102 = GUtils.nullToEmpty(r101);
        return (T) invokeConstructor(r100, r102, GUtils.toClass(r102));
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

    public static Method getAccessibleMethod(Class<?> r110, String r111, Class<?>... r112) {
        Preconditions.checkNotNull(r110, "The class must not be null");
        Preconditions.checkTrue(!TextUtils.isEmpty(r111), "The method name must not be blank");
        String r100 = getKey(r110, r111, r112);
        Map<String, Method> r101 = sMethodCache;
        monitor-enter(r101);
        Method r102 = sMethodCache.get(r100);     // Catch: Throwable -> L53
        monitor-exit(r101);     // Catch: Throwable -> L53
        if (r102 != null) goto L8;
    L11:
        if (r110 == null) goto L51;
        r102 = r110.getDeclaredMethod(r111, r112);     // Catch: NoSuchMethodException -> L14
    L15:
        if (r102 != null) goto L41;
        Method[] r103 = r110.getDeclaredMethods();
        if (r103 == null) goto L41;
        int r104 = r103.length;
        int r105 = 0;
    L19:
        if (r105 >= r104) goto L41;
        Method r106 = r103[r105];
        if (r106 == null) goto L40;
        if (TextUtils.equals(r106.getName(), r111) == false) goto L40;
        Class<?>[] r107 = r106.getParameterTypes();
        if (r112 == null) goto L40;
        if (r107 == null) goto L40;
        if (r112.length != r107.length) goto L40;
        int r108 = 0;
        boolean r113 = true;
    L33:
        if (r108 >= r112.length) goto L38;
        if (isAssignableFrom(r112[r108], r107[r108]) == true) goto L37;
        r113 = false;
    L37:
        r108 = r108 + 1;
        goto L33
    L38:
        if (r113 == false) goto L40;
        r102 = r106;
    L40:
        r105 = r105 + 1;
    L41:
        if (r102 != null) goto L42;
        r110 = r110.getSuperclass();
        goto L11
    L42:
        r102.setAccessible(true);
        Map<String, Method> r109 = sMethodCache;
        monitor-enter(r109);
        sMethodCache.put(r100, r102);     // Catch: Throwable -> L47
        monitor-exit(r109);     // Catch: Throwable -> L47
        return r102;
    L47:
        th = move-exception;
        throw th;
    L51:
        return null;
    L8:
        if (r102.isAccessible() == true) goto L10;
        r102.setAccessible(true);
    L10:
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
        if (r102 != null) goto L5;
    L9:
        r103.append(Void.class.toString());
    L11:
        return r103.toString();
    L5:
        if (r102.length <= 0) goto L9;
        int r104 = r102.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L11;
        r103.append(r102[r105].toString());
        r103.append("#");
        r105 = r105 + 1;
        goto L7
    }

    public static <T> T invokeConstructor(Class<T> r100, Object[] r101, Class<?>[] r102) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] r103 = GUtils.nullToEmpty(r101);
        Constructor r104 = getMatchingAccessibleConstructor(r100, GUtils.nullToEmpty(r102));
        if (r104 != null) goto L5;
        return null;
    L5:
        return (T) r104.newInstance(r103);
    }

    public static Object invokeMethod(Object r100, String r101, Object... r102) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] r103 = GUtils.nullToEmpty(r102);
        return invokeMethod(r100, r101, r103, GUtils.toClass(r103));
    }

    public static Object invokeStaticMethod(Class r100, String r101, Object... r102) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] r103 = GUtils.nullToEmpty(r102);
        return invokeStaticMethod(r100, r101, r103, GUtils.toClass(r103));
    }

    public static Object invokeMethod(Object r100, String r101, Object[] r102, Class<?>[] r103) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?>[] r104 = GUtils.nullToEmpty(r103);
        Object[] r105 = GUtils.nullToEmpty(r102);
        Method r106 = getAccessibleMethod(r100.getClass(), r101, r104);
        if (r106 != null) goto L5;
        return null;
    L5:
        return r106.invoke(r100, r105);
    }

    public static Object invokeStaticMethod(Class r100, String r101, Object[] r102, Class<?>[] r103) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?>[] r104 = GUtils.nullToEmpty(r103);
        Object[] r105 = GUtils.nullToEmpty(r102);
        Method r106 = getAccessibleMethod(r100, r101, r104);
        if (r106 != null) goto L5;
        return null;
    L5:
        return r106.invoke(null, r105);
    }
}
