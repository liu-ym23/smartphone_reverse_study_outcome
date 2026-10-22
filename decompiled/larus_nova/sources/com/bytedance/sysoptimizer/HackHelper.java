package com.bytedance.sysoptimizer;

import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class HackHelper {
    private static final String TAG = "HackHelper";
    private static Map<String, Constructor> sConstructorCache;
    private static Map<String, Field> sFieldCache;
    private static boolean sInited;
    private static Map<String, Method> sMethodCache;

    static {
        sFieldCache = new HashMap();
        sMethodCache = new HashMap();
        sConstructorCache = new HashMap();
        sInited = false;
    }

    public static void init() {
        if (sInited == true) goto L10;
        writeField(HackHelperImpl.class, "classLoader", null);     // Catch: Exception -> L7
    L5:
        sInited = true;
        return;
    }

    public HackHelper() {
    }

    private static <T> void checkNotNull(T r100, String r101) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r101);
    }

    private static void checkTrue(boolean r100, String r101) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r101);
    }

    public static Constructor getConstructor(Class<?> r100, Class<?>... r101) {
        checkNotNull(r100, "The class must not be null !!!");
        String r102 = getMethodKey(r100, "clinit", r101);
        Map<String, Constructor> r103 = sConstructorCache;
        monitor-enter(r103);
        Constructor r104 = sConstructorCache.get(r102);     // Catch: Throwable -> L24
        monitor-exit(r103);     // Catch: Throwable -> L24
        if (r104 != null) goto L8;
        Constructor r105 = HackHelperImpl.getConstructor(r100, r101);     // Catch: Throwable -> L22
        if (r105 == null) goto L21;
        Map<String, Constructor> r106 = sConstructorCache;     // Catch: Throwable -> L22
        monitor-enter(r106);     // Catch: Throwable -> L22
        sConstructorCache.put(r102, r105);     // Catch: Throwable -> L18
        monitor-exit(r106);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L21:
        return r105;
    L22:
        return null;
    L8:
        if (r104.isAccessible() == true) goto L10;
        r104.setAccessible(true);
    L10:
        return r104;
    L24:
        th = move-exception;
        throw th;
    }

    public static Field getField(Class<?> r100, String r101) {
        checkNotNull(r100, "The class must not be null !!!");
        checkTrue(!TextUtils.isEmpty(r101), "The field name must not be blank !!!");
        String r102 = getFieldKey(r100, r101);
        Map<String, Field> r103 = sFieldCache;
        monitor-enter(r103);
        Field r104 = sFieldCache.get(r102);     // Catch: Throwable -> L24
        monitor-exit(r103);     // Catch: Throwable -> L24
        if (r104 != null) goto L8;
        Field r105 = HackHelperImpl.getField(r100, r101);     // Catch: Throwable -> L22
        if (r105 == null) goto L21;
        Map<String, Field> r106 = sFieldCache;     // Catch: Throwable -> L22
        monitor-enter(r106);     // Catch: Throwable -> L22
        sFieldCache.put(r102, r105);     // Catch: Throwable -> L18
        monitor-exit(r106);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L21:
        return r105;
    L22:
        return null;
    L8:
        if (r104.isAccessible() == true) goto L10;
        r104.setAccessible(true);
    L10:
        return r104;
    L24:
        th = move-exception;
        throw th;
    }

    private static String getFieldKey(Class<?> r100, String r101) {
        return r100.getName() + "#" + r101;
    }

    public static Method getMethod(Class<?> r100, String r101, Class<?>... r102) {
        checkNotNull(r100, "The class must not be null !!!");
        checkTrue(!TextUtils.isEmpty(r101), "The method name must not be blank !!!");
        String r103 = getMethodKey(r100, r101, r102);
        Map<String, Method> r104 = sMethodCache;
        monitor-enter(r104);
        Method r105 = sMethodCache.get(r103);     // Catch: Throwable -> L24
        monitor-exit(r104);     // Catch: Throwable -> L24
        if (r105 != null) goto L8;
        Method r106 = HackHelperImpl.getMethod(r100, r101, r102);     // Catch: Throwable -> L22
        if (r106 == null) goto L21;
        Map<String, Method> r107 = sMethodCache;     // Catch: Throwable -> L22
        monitor-enter(r107);     // Catch: Throwable -> L22
        sMethodCache.put(r103, r106);     // Catch: Throwable -> L18
        monitor-exit(r107);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L21:
        return r106;
    L22:
        return null;
    L8:
        if (r105.isAccessible() == true) goto L10;
        r105.setAccessible(true);
    L10:
        return r105;
    L24:
        th = move-exception;
        throw th;
    }

    private static String getMethodKey(Class<?> r100, String r101, Class<?>... r102) {
        StringBuilder r103 = new StringBuilder();
        r103.append(r100.getName());
        r103.append("#");
        r103.append(r101);
        if (r102 != null) goto L5;
    L9:
        r103.append(Void.class.getName());
    L11:
        return r103.toString();
    L5:
        if (r102.length <= 0) goto L9;
        int r104 = r102.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L11;
        r103.append(r102[r105].getName());
        r103.append("#");
        r105 = r105 + 1;
        goto L7
    }

    private static void writeField(Object r100, String r101, Object r102) throws IllegalAccessException {
        checkNotNull(r100, "target object must not be null");
        Field r103 = getField(r100.getClass(), r101);
        if (r103 == null) goto L6;
        writeField(r103, r100, r102);
        return;
    }

    private static void writeField(Field r100, Object r101, Object r102) throws IllegalAccessException {
        checkNotNull(r100, "The field must not be null");
        if (r100.isAccessible() == true) goto L5;
        r100.setAccessible(true);
    L5:
        r100.set(r101, r102);
    }
}
