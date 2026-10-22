package com.obric.assistant.interaction.impl.hook.utils;

import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class MethodUtils {
    public static final Class<?>[] EMPTY_CLASS_ARRAY = null;
    public static final Object[] EMPTY_OBJECT_ARRAY = null;
    private static final Map<String, Method> sMethodCache = null;
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
        EMPTY_OBJECT_ARRAY = new Object[0];
        EMPTY_CLASS_ARRAY = new Class[0];
    }

    public static Class<?>[] nullToEmpty(Class<?>[] r100) {
        if (r100 == null) goto L8;
        if (r100.length == 0) goto L8;
        return r100;
    L8:
        return EMPTY_CLASS_ARRAY;
    }

    public static Class<?>[] toClass(Object... r100) {
        if (r100 == null) goto L16;
        if (r100.length == 0) goto L16;
        Class<?>[] r101 = new Class[r100.length];
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L14;
        Object r103 = r100[r102];
        if (r103 != null) goto L12;
        Class<?> r104 = null;
    L13:
        r101[r102] = r104;
        r102 = r102 + 1;
        goto L8
    L12:
        r104 = r103.getClass();
        goto L13
    L14:
        return r101;
    L16:
        return EMPTY_CLASS_ARRAY;
    }

    public static Object[] nullToEmpty(Object[] r100) {
        if (r100 == null) goto L8;
        if (r100.length == 0) goto L8;
        return r100;
    L8:
        return EMPTY_OBJECT_ARRAY;
    }

    public static <T> void checkNotNull(T r100, String r101) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r101);
    }

    public static void checkTrue(boolean r100, String r101) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r101);
    }

    public static boolean isAssignableFrom(Class<?> r100, Class<?> r101) {
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r100 != null) goto L10;
        return !r101.isPrimitive();
    L10:
        if (r100.isPrimitive() == false) goto L15;
        if (r101.isPrimitive() == true) goto L15;
        r100 = sPrimitiveToWrapperMap.get(r100);
    L15:
        if (r101.isPrimitive() == true) goto L17;
    L19:
        if (r101 != null) goto L21;
        return false;
    L21:
        if (r101.isAssignableFrom(r100) == false) goto L25;
        return true;
    L25:
        return false;
    L17:
        if (r100.isPrimitive() == true) goto L19;
        r101 = sPrimitiveToWrapperMap.get(r101);
        goto L19
    }

    public static Method getAccessibleMethod(Class<?> r110, String r111, Class<?>... r112) {
        checkNotNull(r110, "The class must not be null");
        checkTrue(!TextUtils.isEmpty(r111), "The method name must not be blank");
        String r100 = getKey(r110, r111, r112);
        Map<String, Method> r101 = sMethodCache;
        monitor-enter(r101);
        Method r102 = r101.get(r100);     // Catch: Throwable -> L50
        monitor-exit(r101);     // Catch: Throwable -> L50
        if (r102 != null) goto L8;
    L11:
        if (r110 == null) goto L48;
        r102 = r110.getDeclaredMethod(r111, r112);     // Catch: NoSuchMethodException -> L14
    L15:
        if (r102 != null) goto L38;
        Method[] r103 = r110.getDeclaredMethods();
        int r104 = r103.length;
        int r105 = 0;
    L17:
        if (r105 >= r104) goto L38;
        Method r106 = r103[r105];
        if (r106 == null) goto L37;
        if (TextUtils.equals(r106.getName(), r111) == false) goto L37;
        Class<?>[] r107 = r106.getParameterTypes();
        if (r112 == null) goto L37;
        if (r112.length != r107.length) goto L37;
        int r108 = 0;
        boolean r113 = true;
    L30:
        if (r108 >= r112.length) goto L35;
        if (isAssignableFrom(r112[r108], r107[r108]) == true) goto L34;
        r113 = false;
    L34:
        r108 = r108 + 1;
        goto L30
    L35:
        if (r113 == false) goto L37;
        r102 = r106;
    L37:
        r105 = r105 + 1;
    L38:
        if (r102 != null) goto L39;
        r110 = r110.getSuperclass();
        goto L11
    L39:
        r102.setAccessible(true);
        Map<String, Method> r109 = sMethodCache;
        monitor-enter(r109);
        r109.put(r100, r102);     // Catch: Throwable -> L44
        monitor-exit(r109);     // Catch: Throwable -> L44
        return r102;
    L44:
        th = move-exception;
        throw th;
    L48:
        return null;
    L8:
        if (r102.isAccessible() == true) goto L10;
        r102.setAccessible(true);
    L10:
        return r102;
    L50:
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

    public static Object invokeStaticMethod(Class r100, String r101, Object... r102) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] r103 = nullToEmpty(r102);
        return invokeStaticMethod(r100, r101, r103, toClass(r103));
    }

    public static void invokeMethod(Object r100, String r101, Object[] r102, Class<?>[] r103) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?>[] r104 = nullToEmpty(r103);
        Object[] r105 = nullToEmpty(r102);
        Method r106 = getAccessibleMethod(r100.getClass(), r101, r104);
        if (r106 == null) goto L6;
        r106.invoke(r100, r105);
        return;
    }

    public static Object invokeStaticMethod(Class r100, String r101, Object[] r102, Class<?>[] r103) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?>[] r104 = nullToEmpty(r103);
        Object[] r105 = nullToEmpty(r102);
        Method r106 = getAccessibleMethod(r100, r101, r104);
        if (r106 != null) goto L5;
        return null;
    L5:
        return r106.invoke(null, r105);
    }
}
