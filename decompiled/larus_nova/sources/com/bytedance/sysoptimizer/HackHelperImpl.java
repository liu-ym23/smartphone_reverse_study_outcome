package com.bytedance.sysoptimizer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes22.dex */
public class HackHelperImpl {
    public HackHelperImpl() {
    }

    public static Constructor getConstructor(Class<?> r100, Class<?>... r101) throws NoSuchMethodException {
        Constructor<?> r102 = r100.getDeclaredConstructor(r101);
        if (r102 != null) goto L5;
    L7:
        return r102;
    L5:
        if (r102.isAccessible() == true) goto L7;
        r102.setAccessible(true);
        goto L7
    }

    public static Field getField(Class<?> r100, String r101) throws NoSuchFieldException {
        Field r102 = r100.getDeclaredField(r101);
        if (r102 != null) goto L5;
    L7:
        return r102;
    L5:
        if (r102.isAccessible() == true) goto L7;
        r102.setAccessible(true);
        goto L7
    }

    public static Method getMethod(Class<?> r100, String r101, Class<?>... r102) throws NoSuchMethodException {
        Method r103 = r100.getDeclaredMethod(r101, r102);
        if (r103 != null) goto L5;
    L7:
        return r103;
    L5:
        if (r103.isAccessible() == true) goto L7;
        r103.setAccessible(true);
        goto L7
    }
}
