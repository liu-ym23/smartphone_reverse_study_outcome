package com.bytedance.sysoptimizer.java;

import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.SysOptimizer;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class ReflectionUtils {
    private static final String TAG = "ReflectionUtils";
    private static HashMap<String, Field> sCacheFiled;
    private static HashMap<String, Method> sCacheMethod;
    private static Method sGetDeclaredField;
    private static Method sGetDeclaredMethod;
    private static boolean sIsInit;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static native boolean changeTargetSuperClassToSpecificClassOnDalvik(Class<?> r100, Class<?> r101, String r102);

    private static native boolean setModifiersForDalvik(Class<?> r100, int r101, int r102, int r103, String r104);

    static {
        sCacheFiled = new HashMap();
        sCacheMethod = new HashMap();
        sGetDeclaredField = null;
        sGetDeclaredMethod = null;
        Method r100 = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class});     // Catch: Throwable -> L6
        sGetDeclaredMethod = r100;     // Catch: Throwable -> L6
        r100.setAccessible(true);     // Catch: Throwable -> L6
    L8:
        Method r101 = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});     // Catch: Throwable -> L7
        sGetDeclaredField = r101;     // Catch: Throwable -> L7
        r101.setAccessible(true);     // Catch: Throwable -> L7
        return;
    }

    public static boolean isArt() {
        String r100 = System.getProperty("java.vm.version");
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.startsWith("2") == false) goto L7;
        return true;
    }

    private ReflectionUtils() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_sysoptimizer_java_ReflectionUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private static String getSuperClassNameInDescriptor(Class<?> r100) {
        Class<? super Object> r101 = r100.getSuperclass();
        if (r101 != null) goto L7;
        return "";
    L7:
        return "L" + r101.getName().replaceAll("[.]", HTTP.URL_DEFAULT) + i.f25853b;
    }

    public static void removeFinal(Field r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.getModifiers();
        if (Build.VERSION.SDK_INT > 22) goto L7;
        changeAccessFlagsBelowLForArt(r100, r101 & (-17));
        return;
    L7:
        changeAccessFlagsAboveL(r100, r101 & (-17));
    }

    private static void changeAccessFlagsAboveL(Field r100, int r101) {
        Field r102 = Field.class.getDeclaredField("accessFlags");     // Catch: Throwable -> L4
        r102.setAccessible(true);     // Catch: Throwable -> L4
        r102.setInt(r100, r101);     // Catch: Throwable -> L4
        return;
    }

    private static void changeAccessFlagsBelowLForArt(Field r100, int r101) {
        Field r102 = Field.class.getDeclaredField("artField");     // Catch: Throwable -> L4
        r102.setAccessible(true);     // Catch: Throwable -> L4
        Object r103 = r102.get(r100);     // Catch: Throwable -> L4
        Field r104 = r103.getClass().getDeclaredField("accessFlags");     // Catch: Throwable -> L4
        r104.setAccessible(true);     // Catch: Throwable -> L4
        r104.setInt(r103, r101);     // Catch: Throwable -> L4
        return;
    }

    private static void changeAccessFlagsBelowLForDalvik(Field r100, int r101) {
        if (sIsInit == true) goto L6;
        sIsInit = SysOptimizer.loadOptimizerLibrary(null);
    L6:
        if (sIsInit == false) goto L12;
        Field r102 = Field.class.getDeclaredField("slot");     // Catch: Throwable -> L9
        r102.setAccessible(true);     // Catch: Throwable -> L9
        int r103 = r102.getInt(r100);     // Catch: Throwable -> L9
        Field r104 = Field.class.getDeclaredField("declaringClass");     // Catch: Throwable -> L9
        r104.setAccessible(true);     // Catch: Throwable -> L9
        Class r105 = (Class) r104.get(r100);     // Catch: Throwable -> L9
        r100.getModifiers();     // Catch: Throwable -> L9
        setModifiersForDalvik(r105, r103, r101, r100.getModifiers(), r105.getName());     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }

    public static void changeIfTableFrom(Object r100, Object r101) {
        if (r101 == null) goto L12;
        if (r100 == null) goto L14;
        Class<?> r102 = r101.getClass();     // Catch: Throwable -> L9
        Class<?> r103 = r100.getClass();     // Catch: Throwable -> L9
        Field r104 = Class.class.getDeclaredField("ifTable");     // Catch: Throwable -> L9
        r104.setAccessible(true);     // Catch: Throwable -> L9
        Object[] r105 = (Object[]) r104.get(r102);     // Catch: Throwable -> L9
        if (Arrays.equals(r105, (Object[]) r104.get(r103)) == true) goto L13;
        r104.set(r103, r105);     // Catch: Throwable -> L9
        return;
    L13:
        return;
    L15:
        return;
    L14:
        return;
    }

    private static void changeSuperClass(Class<?> r100, Class<?> r101) throws NoSuchFieldException, IllegalAccessException {
        Field r102 = Class.class.getDeclaredField("superClass");
        r102.setAccessible(true);
        r102.set(r100, r101);
    }

    public static Field getClassField(Class r100, String r101) {
        String r102 = r100.getName() + "." + r101;
        if (sCacheFiled.containsKey(r102) == true) goto L5;
        Field r103 = null;
    L7:
        if (r100 == null) goto L21;
        if (r100 == Object.class) goto L21;
        Method r104 = sGetDeclaredField;     // Catch: Throwable -> L16
        if (r104 == null) goto L13;
        r103 = (Field) r104.invoke(r100, new Object[]{r101});     // Catch: Throwable -> L16
    L14:
        r103.setAccessible(true);     // Catch: Throwable -> L16
        goto L17
    L13:
        r103 = r100.getDeclaredField(r101);     // Catch: Throwable -> L16
    L17:
        if (r103 != null) goto L18;
        r100 = r100.getSuperclass();
        goto L7
    L18:
        sCacheFiled.put(r102, r103);
        return r103;
    L21:
        sCacheFiled.put(r102, null);
        return null;
    L5:
        return sCacheFiled.get(r102);
    }

    public static Method getClassMethod(Class r100, String r101) {
        return getClassMethod(r100, r101, null);
    }

    public static Object getFieldObject(String r100, Object r101) {
        Field r102 = getClassField(r101.getClass(), r100);
        if (r102 == null) goto L12;
        return r102.get(r101);
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    public static Object getStaticFieldObject(String r100, Class r101) {
        Field r102 = getClassField(r101, r100);
        if (r102 != null) goto L9;
    L8:
        return null;
    L9:
        return r102.get(null);
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public static Object invokeStaticMethod(String r100, String r101) {
        return invokeStaticMethod(INVOKESTATIC_com_bytedance_sysoptimizer_java_ReflectionUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100), r101);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Object invokeStaticMethod(Class<?> r100, String r101) {
        return invokeStaticMethod(r100, r101, null, null);
    }

    public static Method getClassMethod(Class r100, String r101, Class<?>... r102) {
        if (r100 == null) goto L26;
        if (r101 == null) goto L26;
        String r103 = r100.getName() + "." + r101;
        if (sCacheMethod.containsKey(r103) == true) goto L9;
        Method r104 = null;
    L11:
        if (r100 == null) goto L25;
        if (r100 == Object.class) goto L25;
        Method r105 = sGetDeclaredMethod;     // Catch: Throwable -> L20
        if (r105 == null) goto L17;
        r104 = (Method) r105.invoke(r100, new Object[]{r101, r102});     // Catch: Throwable -> L20
    L18:
        r104.setAccessible(true);     // Catch: Throwable -> L20
        goto L21
    L17:
        r104 = r100.getDeclaredMethod(r101, r102);     // Catch: Throwable -> L20
    L21:
        if (r104 != null) goto L22;
        r100 = r100.getSuperclass();
        goto L11
    L22:
        sCacheMethod.put(r103, r104);
        return r104;
    L25:
        sCacheMethod.put(r103, null);
        goto L26
    L9:
        return sCacheMethod.get(r103);
    L26:
        return null;
    }

    public static Object getFieldObject(String r100, String r101, Object r102) {
        Field r103 = getClassField(INVOKESTATIC_com_bytedance_sysoptimizer_java_ReflectionUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100), r101);     // Catch: ClassNotFoundException -> L9
        if (r103 == null) goto L17;
        return r103.get(r102);
    L6:
        e = move-exception;
        e.printStackTrace();     // Catch: ClassNotFoundException -> L9
        return null;
    L17:
        return null;
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Object invokeVoidMethod(Class<?> r100, String r101, Object r102) {
        return invokeMethod(r100, r101, null, null, r102);
    }

    public static void setFieldObject(Object r100, String r101, Object r102) {
        Field r103 = getClassField(r100.getClass(), r101);
        if (r103 == null) goto L11;
        r103.set(r100, r102);     // Catch: IllegalAccessException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static Object getFieldObject(Class r100, String r101, Object r102) {
        Field r103 = getClassField(r100, r101);
        if (r103 == null) goto L12;
        return r103.get(r102);
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    public static void changeField2Target(Object r100, Field r101, Object r102, Object r103) {
        if (r101 == null) goto L15;
        if (r100 == null) goto L16;
        if (r102 == null) goto L17;
        if (r103 == null) goto L18;
        Class<?> r104 = r103.getClass();     // Catch: Throwable -> L12
        Class<?> r105 = r102.getClass();     // Catch: Throwable -> L12
        if (r105.equals(r104) == true) goto L10;
        changeSuperClass(r104, r105);     // Catch: Throwable -> L12
    L10:
        r101.set(r100, r103);     // Catch: Throwable -> L12
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public static Object invokeStaticMethod(Class<?> r100, String r101, Class<?>[] r102, Object[] r103) {
        if (r100 != null) goto L5;
    L19:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L19;
        if (r102 != null) goto L10;
        r102 = new Class[0];
    L10:
        if (r103 != null) goto L20;
        r103 = new Object[0];
    L20:
        Method r104 = getClassMethod(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != null) goto L15;
        return null;
    L15:
        r104.setAccessible(true);     // Catch: Throwable -> L17
        return r104.invoke(null, r103);
    L17:
        th = move-exception;
        th.toString();
        goto L19
    }

    public static void setFieldObject(Class r100, String r101, Object r102, Object r103) {
        Field r104 = getClassField(r100, r101);
        if (r104 == null) goto L11;
        r104.set(r102, r103);     // Catch: IllegalAccessException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static Object invokeMethod(Class<?> r100, String r101, Class<?>[] r102, Object[] r103, Object r104) {
        if (r100 != null) goto L5;
    L19:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L19;
        if (r102 != null) goto L10;
        r102 = new Class[0];
    L10:
        if (r103 != null) goto L20;
        r103 = new Object[0];
    L20:
        Method r105 = getClassMethod(r100, r101, r102);     // Catch: Throwable -> L17
        if (r105 != null) goto L15;
        return null;
    L15:
        r105.setAccessible(true);     // Catch: Throwable -> L17
        return r105.invoke(r104, r103);
    L17:
        th = move-exception;
        th.toString();
        goto L19
    }
}
