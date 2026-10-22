package com.bytedance.sysoptimizer.perflock;

import android.os.Build;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public final class DoubleReflectUtils {
    private static final Map<String, Field> FIELD_CACHE = null;

    static {
        FIELD_CACHE = new HashMap();
    }

    public static boolean isAndroidPHigher() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 28) goto L5;
    L10:
        return true;
    L5:
        if (r100 == 27) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    private DoubleReflectUtils() {
    }

    public static Constructor getConstructor(Class<?> r100, Class<?>... r101) throws Exception {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        Method r102 = Class.class.getDeclaredMethod("getDeclaredConstructor", new Class[]{Class[].class});
        if (r102 == null) goto L7;
        Constructor r103 = (Constructor) r102.invoke(r100, new Object[]{r101});
    L8:
        if (r103 == null) goto L10;
        return r103;
    L10:
        return r100.getDeclaredConstructor(r101);
    L7:
        r103 = null;
        goto L8
    }

    public static Field getField(Class<?> r100, String r101) {
        if (isAndroidPHigher() == false) goto L9;
        return getFieldInner(r100, r101);
    L6:
        return null;
    L9:
        return getRealField(r100, r101);
    }

    public static Field getFieldInner(Class<?> r100, String r101) {
        Field r102 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r100, new Object[]{r101});     // Catch: Throwable -> L4
        r102.setAccessible(true);     // Catch: Throwable -> L4
        return r102;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static String getKey(Class<?> r100, String r101) {
        return r100.toString() + "#" + r101;
    }

    public static Field getRealField(Class<?> r100, String r101) {
        String r102 = getKey(r100, r101);
        Map<String, Field> r103 = FIELD_CACHE;
        monitor-enter(r103);
        Field r104 = r103.get(r102);     // Catch: Throwable -> L27
        monitor-exit(r103);     // Catch: Throwable -> L27
        if (r104 != null) goto L9;
    L12:
        if (r100 == null) goto L25;
        Field r105 = r100.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L24
        if (r105.isAccessible() == true) goto L16;
        r105.setAccessible(true);     // Catch: NoSuchFieldException -> L24
    L16:
        Map<String, Field> r106 = FIELD_CACHE;     // Catch: NoSuchFieldException -> L24
        monitor-enter(r106);     // Catch: NoSuchFieldException -> L24
        r106.put(r102, r105);     // Catch: Throwable -> L21
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

    public static Object readField(Object r100, String r101) {
        return getField(r100.getClass(), r101).get(r100);
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static Method getMethodInner(Class<?> r100, String r101, Class<?>... r102) throws NoSuchMethodException {
        Method r103 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r100, new Object[]{r101, r102});     // Catch: Throwable -> L4
        r103.setAccessible(true);     // Catch: Throwable -> L4
        return r103;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }
}
