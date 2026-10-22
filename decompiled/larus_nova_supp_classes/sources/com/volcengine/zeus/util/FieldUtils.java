package com.volcengine.zeus.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class FieldUtils {
    private static Map<String, Field> sFieldCache;

    public FieldUtils() {
    }

    static {
        sFieldCache = new HashMap();
    }

    public static Object readStaticField(Field r1) throws IllegalAccessException {
        return readField(r1, null);
    }

    public static Field getField(Class<?> r5, String r6) {
        String r0 = getKey(r5, r6);
        Map<String, Field> r1 = sFieldCache;
        monitor-enter(r1);
        Field r2 = sFieldCache.get(r0);     // Catch: Throwable -> L27
        monitor-exit(r1);     // Catch: Throwable -> L27
        if (r2 != null) goto L9;
    L12:
        if (r5 == null) goto L25;
        Field r3 = r5.getDeclaredField(r6);     // Catch: NoSuchFieldException -> L24
        if (r3.isAccessible() == true) goto L16;
        r3.setAccessible(true);     // Catch: NoSuchFieldException -> L24
    L16:
        Map<String, Field> r4 = sFieldCache;     // Catch: NoSuchFieldException -> L24
        monitor-enter(r4);     // Catch: NoSuchFieldException -> L24
        sFieldCache.put(r0, r3);     // Catch: Throwable -> L21
        monitor-exit(r4);     // Catch: Throwable -> L21
    L20:
        return r3;
    L21:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L24
    L24:
        r5 = r5.getSuperclass();
        goto L12
    L25:
        return null;
    L9:
        if (r2.isAccessible() == true) goto L11;
        r2.setAccessible(true);
    L11:
        return r2;
    L27:
        th = move-exception;
        throw th;
    }

    private static String getKey(Class<?> r2, String r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r2.toString());
        r0.append("#");
        r0.append(r3);
        r0.append("#");
        if (r2.getClassLoader() == null) goto L5;
        Object r4 = Integer.valueOf(r2.getClassLoader().hashCode());
    L6:
        r0.append(r4);
        return r0.toString();
    L5:
        r4 = XmlPullParser.NO_NAMESPACE;
        goto L6
    }

    public static Object readField(Object r1, String r2) throws IllegalAccessException {
        Field r3 = getField(r1.getClass(), r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        return readField(r3, r1);
    }

    public static Object readStaticField(Class<?> r0, String r1) throws IllegalAccessException {
        Field r2 = getField(r0, r1);
        if (r2 != null) goto L5;
        return null;
    L5:
        return readStaticField(r2);
    }

    public static void writeStaticField(Field r1, Object r2) throws IllegalAccessException {
        writeField(r1, null, r2);
    }

    public static Object readField(Field r1, Object r2) throws IllegalAccessException {
        if (r1.isAccessible() == true) goto L6;
        r1.setAccessible(true);
    L6:
        return r1.get(r2);
    }

    public static void writeField(Object r1, String r2, Object r3) throws IllegalAccessException {
        Field r4 = getField(r1.getClass(), r2);
        if (r4 == null) goto L6;
        writeField(r4, r1, r3);
        return;
    }

    public static void writeStaticField(Class<?> r0, String r1, Object r2) throws IllegalAccessException {
        Field r3 = getField(r0, r1);
        if (r3 == null) goto L6;
        writeStaticField(r3, r2);
        return;
    }

    public static void writeField(Field r1, Object r2, Object r3) throws IllegalAccessException {
        if (r1.isAccessible() == true) goto L5;
        r1.setAccessible(true);
    L5:
        r1.set(r2, r3);
    }
}
