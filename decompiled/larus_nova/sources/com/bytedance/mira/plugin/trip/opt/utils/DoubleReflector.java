package com.bytedance.mira.plugin.trip.opt.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes21.dex */
public class DoubleReflector {
    private static Method mGetDeclaredConstructorMethod;
    private static Method mGetDeclaredFieldMethod;
    private static Method mGetDeclaredMethod;

    public DoubleReflector() {
    }

    static {
        mGetDeclaredFieldMethod = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});     // Catch: Throwable -> L4
        mGetDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class});     // Catch: Throwable -> L4
        mGetDeclaredConstructorMethod = Class.class.getDeclaredMethod("getDeclaredConstructor", new Class[]{Class[].class});     // Catch: Throwable -> L4
        return;
    }

    public static Constructor getConstructor(Class<?> r100, Class<?>... r101) {
        Method r102 = mGetDeclaredConstructorMethod;
        if (r102 != null) goto L10;
    L7:
        return null;
    L10:
        return (Constructor) r102.invoke(r100, new Object[]{r101});
    }

    public static Field getField(Class<?> r100, String r101) {
        Method r102 = mGetDeclaredFieldMethod;
        if (r102 != null) goto L10;
    L7:
        return null;
    L10:
        return (Field) r102.invoke(r100, new Object[]{r101});
    }

    public static Method getMethod(Class<?> r100, String r101, Class<?>... r102) {
        Method r103 = mGetDeclaredMethod;
        if (r103 != null) goto L10;
    L7:
        return null;
    L10:
        return (Method) r103.invoke(r100, new Object[]{r101, r102});
    }
}
