package com.bytedance.mira.util;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class FieldUtils {
    private static Map<String, Field> sFieldCache;

    public FieldUtils() {
    }

    static {
        sFieldCache = new HashMap();
    }

    public static Object readStaticField(Field r1) throws IllegalAccessException {
        return readField((Field) Preconditions.checkNotNull(r1, "The field must not be null"), null);
    }

    public static Field getField(Class<?> r5, String r6) {
        Class r7 = (Class) Preconditions.checkNotNull(r5, "The class must not be null");
        Preconditions.checkTrue(!TextUtils.isEmpty(r6), "The field name must not be blank");
        String r0 = getKey(r7, r6);
        Map<String, Field> r2 = sFieldCache;
        monitor-enter(r2);
        Field r3 = sFieldCache.get(r0);     // Catch: Throwable -> L26
        monitor-exit(r2);     // Catch: Throwable -> L26
        if (r3 != null) goto L8;
    L11:
        if (r7 == null) goto L24;
        Field r4 = r7.getDeclaredField(r6);     // Catch: NoSuchFieldException -> L23
        if (r4.isAccessible() == true) goto L15;
        r4.setAccessible(true);     // Catch: NoSuchFieldException -> L23
    L15:
        Map<String, Field> r8 = sFieldCache;     // Catch: NoSuchFieldException -> L23
        monitor-enter(r8);     // Catch: NoSuchFieldException -> L23
        sFieldCache.put(r0, r4);     // Catch: Throwable -> L20
        monitor-exit(r8);     // Catch: Throwable -> L20
    L19:
        return r4;
    L20:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L23
    L23:
        r7 = r7.getSuperclass();
        goto L11
    L24:
        return null;
    L8:
        if (r3.isAccessible() == true) goto L10;
        r3.setAccessible(true);
    L10:
        return r3;
    L26:
        th = move-exception;
        throw th;
    }

    private static String getKey(Class<?> r1, String r2) {
        return r1.toString() + "#" + r2;
    }

    public static Object readField(Field r3, Object r4) throws IllegalAccessException {
        if (r3 == null) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "The field must not be null");
        if (r3.isAccessible() == true) goto L10;
        r3.setAccessible(true);
    L10:
        return r3.get(r4);
    L5:
        r1 = false;
        goto L6
    }

    public static Object readStaticField(Class<?> r0, String r1) throws IllegalAccessException {
        Field r2 = getField(r0, r1);
        if (r2 != null) goto L5;
        return null;
    L5:
        return readStaticField(r2);
    }

    public static void writeStaticField(Field r1, Object r2) throws IllegalAccessException {
        writeField((Field) Preconditions.checkNotNull(r1, "The field must not be null"), null, r2);
    }

    public static Object readField(Object r1, String r2) throws IllegalAccessException {
        Object r3 = Preconditions.checkNotNull(r1, "target object must not be null");
        Field r4 = getField(r3.getClass(), r2);
        if (r4 != null) goto L5;
        return null;
    L5:
        return readField(r4, r3);
    }

    public static void writeField(Field r1, Object r2, Object r3) throws IllegalAccessException {
        Field r4 = (Field) Preconditions.checkNotNull(r1, "The field must not be null");
        if (r4.isAccessible() == true) goto L5;
        r4.setAccessible(true);
    L5:
        r4.set(r2, r3);
    }

    public static void writeStaticField(Class<?> r0, String r1, Object r2) throws IllegalAccessException {
        Field r3 = getField(r0, r1);
        if (r3 == null) goto L6;
        writeStaticField(r3, r2);
        return;
    }

    public static void writeField(Object r1, String r2, Object r3) throws IllegalAccessException {
        Object r4 = Preconditions.checkNotNull(r1, "target object must not be null");
        Field r5 = getField(r4.getClass(), r2);
        if (r5 == null) goto L6;
        writeField(r5, r4, r3);
        return;
    }
}
