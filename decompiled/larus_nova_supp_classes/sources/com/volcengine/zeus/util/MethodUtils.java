package com.volcengine.zeus.util;

import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class MethodUtils {
    public static final Class<?>[] EMPTY_CLASS_ARRAY = null;
    private static Map<String, Method> sMethodCache;
    private static final HashMap<Class<?>, Class<?>> sPrimitiveToWrapperMap = null;

    public MethodUtils() {
    }

    static {
        sMethodCache = new HashMap();
        HashMap<Class<?>, Class<?>> r0 = new HashMap();
        sPrimitiveToWrapperMap = r0;
        r0.put(Boolean.TYPE, Boolean.class);
        r0.put(Byte.TYPE, Byte.class);
        r0.put(Character.TYPE, Character.class);
        r0.put(Short.TYPE, Short.class);
        r0.put(Integer.TYPE, Integer.class);
        r0.put(Long.TYPE, Long.class);
        r0.put(Double.TYPE, Double.class);
        r0.put(Float.TYPE, Float.class);
        r0.put(Void.TYPE, Void.class);
        EMPTY_CLASS_ARRAY = new Class[0];
    }

    public static Class<?>[] toClass(Object... r3) {
        if (r3 == null) goto L15;
        if (r3.length == 0) goto L15;
        Class<?>[] r0 = new Class[r3.length];
        int r1 = 0;
    L7:
        if (r1 >= r3.length) goto L13;
        Object r2 = r3[r1];
        if (r2 != null) goto L11;
        Class<?> r4 = null;
    L12:
        r0[r1] = r4;
        r1 = r1 + 1;
        goto L7
    L11:
        r4 = r2.getClass();
        goto L12
    L13:
        return r0;
    L15:
        return EMPTY_CLASS_ARRAY;
    }

    public static <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> r0, Class<?>... r1) {
        Constructor<T> r2 = r0.getDeclaredConstructor(r1);     // Catch: NoSuchMethodException -> L6
        if (r2.isAccessible() == true) goto L5;
        r2.setAccessible(true);     // Catch: NoSuchMethodException -> L6
    L5:
        return r2;
    L6:
        return null;
    }

    public static boolean isAssignableFrom(Class<?> r1, Class<?> r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r1 != null) goto L9;
        return !r2.isPrimitive();
    L9:
        if (r1.isPrimitive() == false) goto L14;
        if (r2.isPrimitive() == true) goto L14;
        r1 = sPrimitiveToWrapperMap.get(r1);
    L14:
        if (r2.isPrimitive() == false) goto L19;
        if (r1.isPrimitive() == true) goto L19;
        r2 = sPrimitiveToWrapperMap.get(r2);
    L19:
        return r2.isAssignableFrom(r1);
    }

    public static Method findMethod(Class<?> r3, String r4, Class<?>... r5) throws NoSuchMethodException {
    L2:
        if (r3 == null) goto L9;
        Method r0 = r3.getDeclaredMethod(r4, r5);     // Catch: NoSuchMethodException -> L7
        if (r0.isAccessible() == true) goto L6;
        r0.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L6:
        return r0;
    L7:
        r3 = r3.getSuperclass();
        goto L2
    L9:
        throw new NoSuchMethodException("Method " + r4 + " with parameters " + Arrays.asList(r5) + " not found in " + r3);
    }

    public static Method getAccessibleMethod(Class<?> r13, String r14, Class<?>... r15) {
        String r0 = getKey(r13, r14, r15);
        Map<String, Method> r1 = sMethodCache;
        monitor-enter(r1);
        Method r2 = sMethodCache.get(r0);     // Catch: Throwable -> L53
        monitor-exit(r1);     // Catch: Throwable -> L53
        if (r2 != null) goto L9;
    L12:
        if (r13 == null) goto L51;
        r2 = r13.getDeclaredMethod(r14, r15);     // Catch: NoSuchMethodException -> L15
    L16:
        if (r2 == null) goto L58;
    L41:
        if (r2 != null) goto L42;
        r13 = r13.getSuperclass();
        goto L12
    L42:
        r2.setAccessible(true);
        Map<String, Method> r3 = sMethodCache;
        monitor-enter(r3);
        sMethodCache.put(r0, r2);     // Catch: Throwable -> L47
        monitor-exit(r3);     // Catch: Throwable -> L47
        return r2;
    L47:
        th = move-exception;
        throw th;
    L58:
        Method[] r4 = r13.getDeclaredMethods();     // Catch: Throwable -> L40
        int r5 = r4.length;     // Catch: Throwable -> L40
        int r6 = 0;
    L18:
        if (r6 >= r5) goto L41;
        Method r7 = r4[r6];     // Catch: Throwable -> L40
        if (r7 == null) goto L39;
        if (TextUtils.equals(r7.getName(), r14) == false) goto L39;
        Class<?>[] r8 = r7.getParameterTypes();     // Catch: Throwable -> L40
        if (r15 == null) goto L39;
        if (r8 == null) goto L39;
        if (r15.length != r8.length) goto L39;
        int r9 = 0;
        boolean r10 = true;
    L32:
        if (r9 >= r15.length) goto L37;
        if (isAssignableFrom(r15[r9], r8[r9]) == true) goto L36;
        r10 = false;
    L36:
        r9 = r9 + 1;
        goto L32
    L37:
        if (r10 == false) goto L39;
        r2 = r7;
    L39:
        r6 = r6 + 1;
        goto L18
    L51:
        return null;
    L9:
        if (r2.isAccessible() == true) goto L11;
        r2.setAccessible(true);
    L11:
        return r2;
    L53:
        th = move-exception;
        throw th;
    }

    private static String getKey(Class<?> r3, String r4, Class<?>... r5) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r3.toString());
        r0.append("#");
        r0.append(r4);
        r0.append("#");
        if (r3.getClassLoader() == null) goto L5;
        Object r6 = Integer.valueOf(r3.getClassLoader().hashCode());
    L6:
        r0.append(r6);
        if (r5 != null) goto L9;
    L13:
        r0.append(Void.class.toString());
    L15:
        return r0.toString();
    L9:
        if (r5.length <= 0) goto L13;
        int r7 = r5.length;
        int r8 = 0;
    L11:
        if (r8 >= r7) goto L15;
        r0.append(r5[r8].toString());
        r0.append("#");
        r8 = r8 + 1;
        goto L11
    L5:
        r6 = XmlPullParser.NO_NAMESPACE;
        goto L6
    }

    public static <T> T invokeConstructor(Class<T> r0, Object[] r1, Class<?>[] r2) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor r3 = getMatchingAccessibleConstructor(r0, r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        return (T) r3.newInstance(r1);
    }

    public static Object invokeMethod(Object r1, String r2, Object... r3) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeMethod(r1, r2, r3, toClass(r3));
    }

    public static Object invokeStaticMethod(Class r1, String r2, Object... r3) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return invokeStaticMethod(r1, r2, r3, toClass(r3));
    }

    public static Object invokeMethod(Object r1, String r2, Object[] r3, Class<?>[] r4) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method r5 = getAccessibleMethod(r1.getClass(), r2, r4);
        if (r5 == null) goto L7;
        return r5.invoke(r1, r3);
    L7:
        throw new NoSuchMethodException(r2);
    }

    public static Object invokeStaticMethod(Class r0, String r1, Object[] r2, Class<?>[] r3) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method r4 = getAccessibleMethod(r0, r1, r3);
        if (r4 != null) goto L5;
        return null;
    L5:
        return r4.invoke(null, r2);
    }
}
