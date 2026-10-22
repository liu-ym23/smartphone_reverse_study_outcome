package com.bytedance.mira.compat.q;

import com.bytedance.mira.compat.p.HackHelper;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes21.dex */
public class DoubleReflector {
    private static final String TAG = "DoubleReflector";
    private static Method mForNameMethod;
    private static Method mGetDeclaredConstructorMethod;
    private static Method mGetDeclaredFieldMethod;
    private static Method mGetDeclaredMethod;

    public DoubleReflector() {
    }

    static {
        mGetDeclaredFieldMethod = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});     // Catch: Throwable -> L4
        mGetDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class});     // Catch: Throwable -> L4
        mGetDeclaredConstructorMethod = Class.class.getDeclaredMethod("getDeclaredConstructor", new Class[]{Class[].class});     // Catch: Throwable -> L4
        mForNameMethod = Class.class.getDeclaredMethod("forName", new Class[]{String.class});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_INIT, "DoubleReflectorinit failed", th);
    }

    public static Class<?> getClass(String r100) {
        Preconditions.checkNotNull(r100, "The class name can not be null !!!");
        Method r101 = mForNameMethod;
        Class<?> r102 = null;
        if (r101 != null) goto L13;
    L9:
        if (r102 == null) goto L12;
        return r102;
    L12:
        return HackHelper.getClass(r100);
    L13:
        r102 = (Class) r101.invoke(null, new Object[]{r100});     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        MiraLogger.w(MiraLogger.TAG, TAG + String.format("getClass %s failed !!!", new Object[]{r100}), th);
        goto L9
    }

    public static Constructor getConstructor(Class<?> r100, Class<?>... r101) {
        Preconditions.checkNotNull(r100, "The class must not be null !!!");
        Method r102 = mGetDeclaredConstructorMethod;
        if (r102 == null) goto L12;
        int r103 = 0;
        Constructor r104 = (Constructor) r102.invoke(r100, new Object[]{r101});     // Catch: Throwable -> L7
    L13:
        if (r104 == null) goto L16;
        return r104;
    L16:
        return HackHelper.getConstructor(r100, r101);
    L7:
        th = move-exception;
        StringBuilder r105 = new StringBuilder(TAG);
        Object[] r106 = new Object[2];
        r106[0] = r100.getName();
        if (r101 == null) goto L11;
        r103 = r101.length;
    L11:
        r106[1] = Integer.valueOf(r103);
        r105.append(String.format("getConstructor %s<init>%s failed !!!", r106));
        MiraLogger.w(MiraLogger.TAG, r105.toString(), th);
    L12:
        r104 = null;
        goto L13
    }

    public static Field getField(Class<?> r100, String r101) {
        Preconditions.checkNotNull(r100, "The class must not be null !!!");
        Method r102 = mGetDeclaredFieldMethod;
        if (r102 != null) goto L14;
    L9:
        Field r103 = null;
    L10:
        if (r103 == null) goto L13;
        return r103;
    L13:
        return HackHelper.getField(r100, r101);
    L14:
        r103 = (Field) r102.invoke(r100, new Object[]{r101});     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        MiraLogger.w(MiraLogger.TAG, TAG + String.format("getField %s#%s failed !!!", new Object[]{r100.getName(), r101}), th);
        goto L9
    }

    public static Field getFieldAll(Class<?> r100, String r101) {
        Preconditions.checkNotNull(r100, "The class must not be null !!!");
    L3:
        if (r100 == null) goto L8;
        return (Field) mGetDeclaredFieldMethod.invoke(r100, new Object[]{r101});
    L6:
        r100 = r100.getSuperclass();
        goto L3
    L8:
        return HackHelper.getField(r100, r101);
    }

    public static Method getMethod(Class<?> r100, String r101, Class<?>... r102) {
        Preconditions.checkNotNull(r100, "The class must not be null !!!");
        Method r103 = mGetDeclaredMethod;
        if (r103 != null) goto L14;
    L9:
        Method r104 = null;
    L10:
        if (r104 == null) goto L13;
        return r104;
    L13:
        return HackHelper.getMethod(r100, r101, r102);
    L14:
        r104 = (Method) r103.invoke(r100, new Object[]{r101, r102});     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        MiraLogger.w(MiraLogger.TAG, TAG + String.format("getMethod %s#%s failed !!!", new Object[]{r100.getName(), r101}), th);
        goto L9
    }
}
