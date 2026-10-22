package com.huawei.hms.framework.common;

import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class ReflectionUtils {
    private static final int DISABLE = 1;
    private static final int ENABLE = 2;
    private static final String TAG = "ReflectionUtils";
    private static final int UNCHECK = 0;
    private static int abtestStatus;

    public ReflectionUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static boolean isAbTestEnable() {
        int r100 = abtestStatus;
        int r101 = 1;
        if (r100 == 0) goto L8;
        if (r100 == 2) goto L13;
        return false;
    L13:
        return true;
    L8:
        boolean r102 = checkCompatible("com.huawei.hms.network.abtest.ABHelper");
        if (r102 == false) goto L11;
        r101 = 2;
    L11:
        abtestStatus = r101;
        return r102;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_huawei_hms_framework_common_ReflectionUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static boolean checkCompatible(String r100) {
        tryLoadClass(r100);     // Catch: Exception -> L5
        return true;
    L5:
        Logger.w(TAG, r100 + "ClassNotFoundException");
        return false;
    }

    private static Class<?> getClass(String r100) {
        if (r100 != null) goto L8;
        return null;
    L8:
        return INVOKESTATIC_com_huawei_hms_framework_common_ReflectionUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);
    L7:
        return null;
    }

    private static void tryLoadClass(String r100) throws ClassNotFoundException {
        ClassLoader r101 = ReflectionUtils.class.getClassLoader();
        if (r101 == null) goto L7;
        INVOKEVIRTUAL_com_huawei_hms_framework_common_ReflectionUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r101, r100);
        return;
    L7:
        throw new ClassNotFoundException("not found classloader");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_huawei_hms_framework_common_ReflectionUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    public static Field getField(Object r100, String r101) {
        if (r100 != null) goto L5;
    L16:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        final Field r102 = r100.getClass().getDeclaredField(r101);     // Catch: SecurityException -> L10 NoSuchFieldException -> L12 IllegalArgumentException -> L14
        AccessController.doPrivileged(new AnonymousClass2(r102));     // Catch: SecurityException -> L10 NoSuchFieldException -> L12 IllegalArgumentException -> L14
        return r102;
    L14:
        e = move-exception;
        Logger.e(TAG, "Exception in getField :: IllegalArgumentException:", e);
    L12:
        e = move-exception;
        Logger.e(TAG, "Exception in getField :: NoSuchFieldException:", e);
    L10:
        e = move-exception;
        Logger.e(TAG, "not security int method getField,SecurityException:", e);
        goto L16
    }

    public static Object getFieldObj(Object r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L19;
        return null;
    L19:
        final Field r102 = r100.getClass().getDeclaredField(r101);     // Catch: SecurityException -> L10 NoSuchFieldException -> L12 IllegalArgumentException -> L14 IllegalAccessException -> L16
        AccessController.doPrivileged(new AnonymousClass1(r102));     // Catch: SecurityException -> L10 NoSuchFieldException -> L12 IllegalArgumentException -> L14 IllegalAccessException -> L16
    L26:
        return r102.get(r100);
    L16:
        e = move-exception;
        Logger.e(TAG, "Exception in getFieldObj :: IllegalAccessException:", e);
        return null;
    L14:
        e = move-exception;
        Logger.e(TAG, "Exception in getFieldObj :: IllegalArgumentException:", e);
        return null;
    L12:
        e = move-exception;
        Logger.e(TAG, "Exception in getFieldObj :: NoSuchFieldException:", e);
        return null;
    L10:
        e = move-exception;
        Logger.e(TAG, "not security int method getFieldObj,SecurityException:", e);
        return null;
    }

    public static Object getStaticFieldObj(String r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Class<?> r102 = getClass(r100);
        if (r102 != null) goto L8;
        return null;
    L8:
        if (TextUtils.isEmpty(r101) == true) goto L27;
        final Field r103 = r102.getDeclaredField(r101);     // Catch: SecurityException -> L12 NoSuchFieldException -> L14 IllegalArgumentException -> L16 IllegalAccessException -> L18
        AccessController.doPrivileged(new AnonymousClass3(r103));     // Catch: SecurityException -> L12 NoSuchFieldException -> L14 IllegalArgumentException -> L16 IllegalAccessException -> L18
    L28:
        return r103.get(r102);
    L18:
        e = move-exception;
        Logger.e(TAG, "Exception in getFieldObj :: IllegalAccessException:", e);
        return null;
    L16:
        e = move-exception;
        Logger.e(TAG, "Exception in getFieldObj :: IllegalArgumentException:", e);
        return null;
    L14:
        e = move-exception;
        Logger.e(TAG, "Exception in getFieldObj :: NoSuchFieldException:", e);
        return null;
    L12:
        e = move-exception;
        Logger.e(TAG, "not security int method getStaticFieldObj,SecurityException:", e);
        return null;
    L27:
        return null;
    }

    public static boolean checkCompatible(String r100, String r101, Class<?>... r102) {
        if (r100 == null) goto L8;
        if (r101 == null) goto L8;
        INVOKESTATIC_com_huawei_hms_framework_common_ReflectionUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100).getDeclaredMethod(r101, r102);     // Catch: Exception -> L10 RuntimeException -> L11
        Logger.v(TAG, "has method : ".concat(r101));     // Catch: Exception -> L10 RuntimeException -> L11
        return true;
    L8:
        Logger.w(TAG, "targetClass is  null or name is null:");     // Catch: Exception -> L10 RuntimeException -> L11
        return false;
    L11:
        Logger.w(TAG, r100 + " RuntimeException");
    L12:
        return false;
    L10:
        Logger.w(TAG, r101 + " NoSuchMethodException");
        goto L12
    }

    public static Method getMethod(Class<?> r100, String r101, Class<?>... r102) {
        if (r100 == null) goto L13;
        if (r101 == null) goto L13;
        return r100.getDeclaredMethod(r101, r102);
    L8:
        e = move-exception;
        Logger.e(TAG, "NoSuchMethodException:", e);
    L12:
        return null;
    L10:
        e = move-exception;
        Logger.e(TAG, "SecurityException:", e);
    L13:
        Logger.w(TAG, "targetClass is  null pr name is null:");
        return null;
    }

    private static Object invoke(Object r100, Method r101, Object... r102) throws UnsupportedOperationException {
        if (r101 != null) goto L12;
        return null;
    L12:
        return r101.invoke(r100, r102);
    L9:
        e = move-exception;
        Logger.e(TAG, "RuntimeException in invoke:", e);
    L11:
        return null;
    L7:
        e = move-exception;
        Logger.e(TAG, "Exception in invoke:", e);
        goto L11
    }

    public static Object invokeStaticMethod(String r100, String r101, Object... r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r102 == null) goto L9;
        int r103 = r102.length;
        Class[] r104 = new Class[r103];
        int r105 = 0;
    L7:
        if (r105 >= r103) goto L10;
        setClassType(r104, r102[r105], r105);
        r105 = r105 + 1;
    L10:
        Method r106 = getMethod(getClass(r100), r101, r104);
        if (r106 != null) goto L14;
        return null;
    L14:
        return invoke(null, r106, r102);
    L9:
        r104 = null;
        goto L10
    }

    private static void setClassType(Class<?>[] r100, Object r101, int r102) {
        if ((r101 instanceof Integer) == false) goto L6;
        r100[r102] = Integer.TYPE;
        return;
    L6:
        if ((r101 instanceof Long) == false) goto L9;
        r100[r102] = Long.TYPE;
        return;
    L9:
        if ((r101 instanceof Double) == false) goto L12;
        r100[r102] = Double.TYPE;
        return;
    L12:
        if ((r101 instanceof Float) == false) goto L15;
        r100[r102] = Float.TYPE;
        return;
    L15:
        if ((r101 instanceof Boolean) == false) goto L18;
        r100[r102] = Boolean.TYPE;
        return;
    L18:
        if ((r101 instanceof Character) == false) goto L21;
        r100[r102] = Character.TYPE;
        return;
    L21:
        if ((r101 instanceof Byte) == false) goto L24;
        r100[r102] = Byte.TYPE;
        return;
    L24:
        if ((r101 instanceof Void) == false) goto L27;
        r100[r102] = Void.TYPE;
        return;
    L27:
        if ((r101 instanceof Short) == false) goto L29;
        r100[r102] = Short.TYPE;
        return;
    L29:
        r100[r102] = r101.getClass();
    }

    public static Object invokeStaticMethod(String r100, String r101, Class<?>[] r102, Object... r103) {
        Method r104 = getMethod(getClass(r100), r101, r102);
        if (r104 != null) goto L6;
        return null;
    L6:
        return invoke(null, r104, r103);
    }
}
