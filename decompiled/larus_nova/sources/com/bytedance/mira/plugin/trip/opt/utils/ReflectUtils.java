package com.bytedance.mira.plugin.trip.opt.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes21.dex */
public class ReflectUtils {
    private static final String TAG = "ReflectUtils";

    public ReflectUtils() {
    }

    public static Constructor<?> findDeclaredConstructor(Class r100, Class<?>... r101) {
        Constructor<?> r102 = r100.getDeclaredConstructor(r101);     // Catch: Throwable -> L7
        r102.setAccessible(true);     // Catch: Throwable -> L6
    L8:
        if (r102 == null) goto L13;
        return r102;
    L13:
        r102 = DoubleReflector.getConstructor(r100, r101);     // Catch: Throwable -> L12
        r102.setAccessible(true);     // Catch: Throwable -> L12
        return r102;
    L19:
        return r102;
    L7:
        r102 = null;
        goto L8
    }

    public static Field findDeclaredField(Class r100, String r101) {
        Field r102 = r100.getDeclaredField(r101);     // Catch: Throwable -> L7
        r102.setAccessible(true);     // Catch: Throwable -> L6
        return r102;
    L8:
        Objects.toString(r100);
        if (r102 == null) goto L16;
        return r102;
    L16:
        r102 = DoubleReflector.getField(r100, r101);     // Catch: Throwable -> L13
        r102.setAccessible(true);     // Catch: Throwable -> L13
        return r102;
    L20:
        return r102;
    L7:
        r102 = null;
        goto L8
    }

    public static Object readDeclaredField(Field r100, Object r101) {
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.get(r101);
    L7:
        return null;
    }

    public static Method findDeclaredMethod(Class r100, String r101, Class<?>... r102) {
        Method r103 = r100.getDeclaredMethod(r101, r102);     // Catch: Throwable -> L7
        r103.setAccessible(true);     // Catch: Throwable -> L6
    L8:
        if (r103 == null) goto L14;
        return r103;
    L14:
        r103 = DoubleReflector.getMethod(r100, r101, r102);     // Catch: Throwable -> L12
        r103.setAccessible(true);     // Catch: Throwable -> L12
        return r103;
    L12:
        Objects.toString(r100);
        return r103;
    L7:
        r103 = null;
        goto L8
    }

    public static Object invokeDeclaredMethod(Method r100, Object r101, Object... r102) {
        return r100.invoke(r101, r102);
    L4:
        return null;
    }
}
