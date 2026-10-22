package com.bytedance.mira.util;

import com.bytedance.mira.log.MiraLogger;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class ReflectUtils {
    private static final String TAG = "ReflectUtils";

    public ReflectUtils() {
    }

    public static Constructor<?> findDeclaredConstructor(Class<?> r100, Class<?>... r101) {
        Constructor<?> r102 = r100.getDeclaredConstructor(r101);     // Catch: Throwable -> L4
        r102.setAccessible(true);     // Catch: Throwable -> L4
        return r102;
    L4:
        return null;
    }

    public static Field findDeclaredField(Class<?> r100, String r101) {
        Field r102 = r100.getDeclaredField(r101);     // Catch: Throwable -> L4
        r102.setAccessible(true);     // Catch: Throwable -> L4
        return r102;
    L4:
        return null;
    }

    public static Object readDeclaredField(Field r100, Object r101) {
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.get(r101);
    L7:
        return null;
    }

    public static void updateClassLoaderParent(ClassLoader r100, ClassLoader r101) {
        Field r102 = FieldUtils.getField(ClassLoader.class, "parent");     // Catch: Exception -> L6
        if (r102 == null) goto L11;
        r102.set(r100, r101);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INIT, "ReflectUtils classloader=" + r100 + ",updateClassLoaderParent fail!!!", e);
    }

    public static Method findDeclaredMethod(Class<?> r100, String r101, Class<?>... r102) {
        Method r103 = r100.getDeclaredMethod(r101, r102);     // Catch: Throwable -> L4
        r103.setAccessible(true);     // Catch: Throwable -> L4
        return r103;
    L4:
        return null;
    }
}
