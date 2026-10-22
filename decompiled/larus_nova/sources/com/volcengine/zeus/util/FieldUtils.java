package com.volcengine.zeus.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class FieldUtils {
    private static Map<String, Field> sFieldCache;

    public FieldUtils() {
    }

    static {
        sFieldCache = new HashMap();
    }

    public static Object readStaticField(Field r100) throws IllegalAccessException {
        return readField(r100, null);
    }

    public static Field getField(Class<?> r100, String r101) {
        String r102 = getKey(r100, r101);
        Map<String, Field> r103 = sFieldCache;
        monitor-enter(r103);
        Field r104 = sFieldCache.get(r102);     // Catch: Throwable -> L27
        monitor-exit(r103);     // Catch: Throwable -> L27
        if (r104 != null) goto L9;
    L12:
        if (r100 == null) goto L25;
        Field r105 = r100.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L24
        if (r105.isAccessible() == true) goto L16;
        r105.setAccessible(true);     // Catch: NoSuchFieldException -> L24
    L16:
        Map<String, Field> r106 = sFieldCache;     // Catch: NoSuchFieldException -> L24
        monitor-enter(r106);     // Catch: NoSuchFieldException -> L24
        sFieldCache.put(r102, r105);     // Catch: Throwable -> L21
        monitor-exit(r106);     // Catch: Throwable -> L21
    L20:
        return r105;
    L21:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L24
    L24:
        r100 = r100.getSuperclass();
        goto L12
    L25:
        return null;
    L9:
        if (r104.isAccessible() == true) goto L11;
        r104.setAccessible(true);
    L11:
        return r104;
    L27:
        th = move-exception;
        throw th;
    }

    private static String getKey(Class<?> r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        r102.append(r100.toString());
        r102.append("#");
        r102.append(r101);
        r102.append("#");
        if (r100.getClassLoader() == null) goto L5;
        Object r103 = Integer.valueOf(r100.getClassLoader().hashCode());
    L6:
        r102.append(r103);
        return r102.toString();
    L5:
        r103 = "";
        goto L6
    }

    public static Object readField(Object r100, String r101) throws IllegalAccessException {
        Field r102 = getField(r100.getClass(), r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        return readField(r102, r100);
    }

    public static Object readStaticField(Class<?> r100, String r101) throws IllegalAccessException {
        Field r102 = getField(r100, r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        return readStaticField(r102);
    }

    public static void writeStaticField(Field r100, Object r101) throws IllegalAccessException {
        writeField(r100, null, r101);
    }

    public static Object readField(Field r100, Object r101) throws IllegalAccessException {
        if (r100.isAccessible() == true) goto L6;
        r100.setAccessible(true);
    L6:
        return r100.get(r101);
    }

    public static void writeField(Object r100, String r101, Object r102) throws IllegalAccessException {
        Field r103 = getField(r100.getClass(), r101);
        if (r103 == null) goto L6;
        writeField(r103, r100, r102);
        return;
    }

    public static void writeStaticField(Class<?> r100, String r101, Object r102) throws IllegalAccessException {
        Field r103 = getField(r100, r101);
        if (r103 == null) goto L6;
        writeStaticField(r103, r102);
        return;
    }

    public static void writeField(Field r100, Object r101, Object r102) throws IllegalAccessException {
        if (r100.isAccessible() == true) goto L5;
        r100.setAccessible(true);
    L5:
        r100.set(r101, r102);
    }
}
