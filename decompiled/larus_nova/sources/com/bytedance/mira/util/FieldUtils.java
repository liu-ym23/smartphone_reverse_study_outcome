package com.bytedance.mira.util;

import android.text.TextUtils;
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
        return readField((Field) Preconditions.checkNotNull(r100, "The field must not be null"), null);
    }

    public static Field getField(Class<?> r100, String r101) {
        Class r102 = (Class) Preconditions.checkNotNull(r100, "The class must not be null");
        Preconditions.checkTrue(!TextUtils.isEmpty(r101), "The field name must not be blank");
        String r103 = getKey(r102, r101);
        Map<String, Field> r104 = sFieldCache;
        monitor-enter(r104);
        Field r105 = sFieldCache.get(r103);     // Catch: Throwable -> L26
        monitor-exit(r104);     // Catch: Throwable -> L26
        if (r105 != null) goto L8;
    L11:
        if (r102 == null) goto L24;
        Field r106 = r102.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L23
        if (r106.isAccessible() == true) goto L15;
        r106.setAccessible(true);     // Catch: NoSuchFieldException -> L23
    L15:
        Map<String, Field> r107 = sFieldCache;     // Catch: NoSuchFieldException -> L23
        monitor-enter(r107);     // Catch: NoSuchFieldException -> L23
        sFieldCache.put(r103, r106);     // Catch: Throwable -> L20
        monitor-exit(r107);     // Catch: Throwable -> L20
    L19:
        return r106;
    L20:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L23
    L23:
        r102 = r102.getSuperclass();
        goto L11
    L24:
        return null;
    L8:
        if (r105.isAccessible() == true) goto L10;
        r105.setAccessible(true);
    L10:
        return r105;
    L26:
        th = move-exception;
        throw th;
    }

    private static String getKey(Class<?> r100, String r101) {
        return r100.toString() + "#" + r101;
    }

    public static Object readField(Field r100, Object r101) throws IllegalAccessException {
        if (r100 == null) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkArgument(r102, "The field must not be null");
        if (r100.isAccessible() == true) goto L10;
        r100.setAccessible(true);
    L10:
        return r100.get(r101);
    L5:
        r102 = false;
        goto L6
    }

    public static Object readStaticField(Class<?> r100, String r101) throws IllegalAccessException {
        Field r102 = getField(r100, r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        return readStaticField(r102);
    }

    public static void writeStaticField(Field r100, Object r101) throws IllegalAccessException {
        writeField((Field) Preconditions.checkNotNull(r100, "The field must not be null"), null, r101);
    }

    public static Object readField(Object r100, String r101) throws IllegalAccessException {
        Object r102 = Preconditions.checkNotNull(r100, "target object must not be null");
        Field r103 = getField(r102.getClass(), r101);
        if (r103 != null) goto L5;
        return null;
    L5:
        return readField(r103, r102);
    }

    public static void writeField(Field r100, Object r101, Object r102) throws IllegalAccessException {
        Field r103 = (Field) Preconditions.checkNotNull(r100, "The field must not be null");
        if (r103.isAccessible() == true) goto L5;
        r103.setAccessible(true);
    L5:
        r103.set(r101, r102);
    }

    public static void writeStaticField(Class<?> r100, String r101, Object r102) throws IllegalAccessException {
        Field r103 = getField(r100, r101);
        if (r103 == null) goto L6;
        writeStaticField(r103, r102);
        return;
    }

    public static void writeField(Object r100, String r101, Object r102) throws IllegalAccessException {
        Object r103 = Preconditions.checkNotNull(r100, "target object must not be null");
        Field r104 = getField(r103.getClass(), r101);
        if (r104 == null) goto L6;
        writeField(r104, r103, r102);
        return;
    }
}
