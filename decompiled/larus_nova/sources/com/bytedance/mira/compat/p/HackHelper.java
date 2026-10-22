package com.bytedance.mira.compat.p;

import android.text.TextUtils;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class HackHelper {
    private static final String TAG = "HackHelper";
    private static Map<String, Class> sClassCache;
    private static Map<String, Constructor> sConstructorCache;
    private static Map<String, Field> sFieldCache;
    private static Map<String, Method> sMethodCache;

    public HackHelper() {
    }

    static {
        sFieldCache = new HashMap();
        sMethodCache = new HashMap();
        sConstructorCache = new HashMap();
        sClassCache = new HashMap();
        FieldUtils.writeField(HackHelperImpl.class, "classLoader", null);     // Catch: Exception -> L5
        MiraLogger.w(MiraLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INIT, "HackHelperinit failed", e);
    }

    public static Class<?> getClass(String r100) {
        Preconditions.checkNotNull(r100, "The class name can not be null !!!");
        Map<String, Class> r101 = sClassCache;
        monitor-enter(r101);
        Class<?> r102 = sClassCache.get(r100);     // Catch: Throwable -> L22
        monitor-exit(r101);     // Catch: Throwable -> L22
        if (r102 == null) goto L27;
        return r102;
    L27:
        Class<?> r103 = HackHelperImpl.getClass(r100);     // Catch: Throwable -> L19
        if (r103 == null) goto L18;
        Map<String, Class> r104 = sClassCache;     // Catch: Throwable -> L19
        monitor-enter(r104);     // Catch: Throwable -> L19
        sClassCache.put(r100, r103);     // Catch: Throwable -> L15
        monitor-exit(r104);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L18:
        return r103;
    L19:
        th = move-exception;
        MiraLogger.w(MiraLogger.TAG, TAG + String.format("getClass %s failed !!!", new Object[]{r100}), th);
        return null;
    L22:
        th = move-exception;
        throw th;
    }

    public static Constructor getConstructor(Class<?> r100, Class<?>... r101) {
        Preconditions.checkNotNull(r100, "The class must not be null !!!");
        String r102 = getMethodKey(r100, "clinit", r101);
        Map<String, Constructor> r103 = sConstructorCache;
        monitor-enter(r103);
        Constructor r104 = sConstructorCache.get(r102);     // Catch: Throwable -> L26
        monitor-exit(r103);     // Catch: Throwable -> L26
        if (r104 != null) goto L9;
        Constructor r105 = HackHelperImpl.getConstructor(r100, r101);     // Catch: Throwable -> L23
        if (r105 == null) goto L22;
        Map<String, Constructor> r106 = sConstructorCache;     // Catch: Throwable -> L23
        monitor-enter(r106);     // Catch: Throwable -> L23
        sConstructorCache.put(r102, r105);     // Catch: Throwable -> L19
        monitor-exit(r106);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L22:
        return r105;
    L23:
        th = move-exception;
        MiraLogger.w(MiraLogger.TAG, TAG + String.format("getConstructor %s failed !!!", new Object[]{r100.getName()}), th);
        return null;
    L9:
        if (r104.isAccessible() == true) goto L11;
        r104.setAccessible(true);
    L11:
        return r104;
    L26:
        th = move-exception;
        throw th;
    }

    public static Field getField(Class<?> r100, String r101) {
        Preconditions.checkNotNull(r100, "The class must not be null !!!");
        Preconditions.checkTrue(!TextUtils.isEmpty(r101), "The field name must not be blank !!!");
        String r102 = getFieldKey(r100, r101);
        Map<String, Field> r103 = sFieldCache;
        monitor-enter(r103);
        Field r104 = sFieldCache.get(r102);     // Catch: Throwable -> L25
        monitor-exit(r103);     // Catch: Throwable -> L25
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
        th = move-exception;
        MiraLogger.w(MiraLogger.TAG, TAG + String.format("getField %s#%s failed !!!", new Object[]{r100.getName(), r101}), th);
        return null;
    L8:
        if (r104.isAccessible() == true) goto L10;
        r104.setAccessible(true);
    L10:
        return r104;
    L25:
        th = move-exception;
        throw th;
    }

    private static String getFieldKey(Class<?> r100, String r101) {
        return r100.getName() + "#" + r101;
    }

    public static Method getMethod(Class<?> r100, String r101, Class<?>... r102) {
        Preconditions.checkNotNull(r100, "The class must not be null !!!");
        Preconditions.checkTrue(!TextUtils.isEmpty(r101), "The method name must not be blank !!!");
        String r103 = getMethodKey(r100, r101, r102);
        Map<String, Method> r104 = sMethodCache;
        monitor-enter(r104);
        Method r105 = sMethodCache.get(r103);     // Catch: Throwable -> L25
        monitor-exit(r104);     // Catch: Throwable -> L25
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
        th = move-exception;
        MiraLogger.w(MiraLogger.TAG, TAG + String.format("getMethod %s#%s failed !!!", new Object[]{r100.getName(), r101}), th);
        return null;
    L8:
        if (r105.isAccessible() == true) goto L10;
        r105.setAccessible(true);
    L10:
        return r105;
    L25:
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
}
