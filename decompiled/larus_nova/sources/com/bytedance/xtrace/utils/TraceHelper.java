package com.bytedance.xtrace.utils;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.xtrace.bridge.b;
import com.bytedance.xtrace.bridge.c;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class TraceHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f272704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f272705b;

    public TraceHelper() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static Constructor getConstructorByPassHiddenApi(Class r100, Class... r101) {
        return (Constructor) Class.class.getDeclaredMethod("getDeclaredConstructor", new Class[]{Class[].class}).invoke(r100, new Object[]{r101});
    L6:
        e = move-exception;
        e.toString();
        return null;
    }

    public static Constructor getConstructorWithArgs(Class r100, Class... r101) {
        return r100.getConstructor(r101);
    L4:
        e = move-exception;
        e.toString();
        return getConstructorByPassHiddenApi(r100, r101);
    }

    public static Field getFieldByPassHiddenApi(Class r100, String r101) {
    L9:
        th = move-exception;
        th.toString();
        return null;
    L3:
        if (f272705b == null) goto L6;
    L7:
        Field r102 = (Field) f272705b.invoke(r100, new Object[]{r101});     // Catch: Throwable -> L9
        r102.setAccessible(true);     // Catch: Throwable -> L9
        return r102;
    L6:
        f272705b = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});     // Catch: Throwable -> L9
        goto L7
    }

    public static Method getMethod(String r100, String r101, Object... r102) {
        return getMethod(INVOKESTATIC_com_bytedance_xtrace_utils_TraceHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100), r101, r102);
    L4:
        e = move-exception;
        e.toString();
        return null;
    }

    public static Method getMethodByPassHiddenApi(Class r100, String r101, Class... r102) {
    L9:
        return null;
    L3:
        if (f272704a == null) goto L6;
    L7:
        return (Method) f272704a.invoke(r100, new Object[]{r101, r102});
    L6:
        f272704a = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class});     // Catch: Exception -> L9
        goto L7
    }

    public static Constructor getNoArgsConstructor(Class r100) {
        return r100.getDeclaredConstructors()[0];
    }

    public static Constructor getNoArgsConstructor(String r100) {
        return INVOKESTATIC_com_bytedance_xtrace_utils_TraceHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100).getDeclaredConstructors()[0];
    L4:
        e = move-exception;
        e.toString();
        return null;
    }

    public static Member getProxyMethod(Member r100) {
        boolean r101 = isStatic(r100);
        if ((r100 instanceof Method) == false) goto L5;
        Method r102 = (Method) r100;
        Class<?> r103 = r102.getReturnType();
        Class<?>[] r104 = r102.getParameterTypes();
    L6:
        int r105 = 0;
        if (r101 == true) goto L9;
        int r106 = 1;
        Class[] r107 = new Class[r104.length + 1];
        r107[0] = Object.class;
    L10:
        int r108 = r104.length;
    L11:
        if (r105 >= r108) goto L26;
        Class<?> r109 = r104[r105];
        if (r109.isPrimitive() == false) goto L24;
        Class<?> r110 = Float.TYPE;
        if (r109 != r110) goto L17;
        r107[r106] = r110;
    L25:
        r106 = r106 + 1;
        r105 = r105 + 1;
        goto L11
    L17:
        Class<?> r111 = Double.TYPE;
        if (r109 != r111) goto L20;
        r107[r106] = r111;
        goto L25
    L20:
        Class<?> r112 = Long.TYPE;
        if (r109 != r112) goto L23;
        r107[r106] = r112;
        goto L25
    L23:
        r107[r106] = Integer.TYPE;
        goto L25
    L24:
        r107[r106] = Object.class;
        goto L25
    L26:
        if (r103 != null) goto L28;
    L36:
        Class r113 = c.class;
    L38:
        return getMethod(r113, "bridge", r107);
    L28:
        if (r103.isPrimitive() == false) goto L36;
        if (r103 != Float.TYPE) goto L32;
    L35:
        r113 = com.bytedance.xtrace.bridge.a.class;
        goto L38
    L32:
        if (r103 == Double.TYPE) goto L35;
        r113 = b.class;
        goto L38
    L9:
        r107 = new Class[r104.length];
        r106 = 0;
        goto L10
    L5:
        r104 = ((Constructor) r100).getParameterTypes();
        r103 = null;
        goto L6
    }

    public static boolean isDebugApk(Context r100) {
        if ((r100.getApplicationInfo().flags & 2) == 0) goto L11;
        return true;
    L11:
        return false;
    L12:
        return false;
    }

    public static boolean isStatic(Member r100) {
        if ((r100.getModifiers() & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static Object[] parseArgs(Member r100, Object[] r101) {
        if (r101 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Method) == false) goto L8;
        Class<?>[] r102 = ((Method) r100).getParameterTypes();
    L9:
        int r103 = 0;
    L11:
        if (r103 >= r102.length) goto L31;
        if (r102[r103].isPrimitive() == false) goto L30;
        Class<?> r104 = r102[r103];
        if (r104 != Byte.TYPE) goto L18;
        r101[r103] = Byte.valueOf(((Integer) r101[r103]).byteValue());
        goto L30
    L18:
        if (r104 != Character.TYPE) goto L21;
        r101[r103] = Character.valueOf((char) ((Integer) r101[r103]).intValue());
        goto L30
    L21:
        if (r104 != Boolean.TYPE) goto L28;
        boolean r105 = true;
        if (((Integer) r101[r103]).intValue() == 1) goto L26;
        r105 = false;
    L26:
        r101[r103] = Boolean.valueOf(r105);
        goto L30
    L28:
        if (r104 != Short.TYPE) goto L30;
        r101[r103] = Short.valueOf(((Integer) r101[r103]).shortValue());
    L30:
        r103 = r103 + 1;
        goto L11
    L31:
        return r101;
    L8:
        r102 = ((Constructor) r100).getParameterTypes();
        goto L9
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_xtrace_utils_TraceHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public static Method getMethod(Class r100, String r101, Object... r102) {
        if (r102 != null) goto L4;
        Class[] r103 = null;
    L22:
        return getMethodByPassHiddenApi(r100, r101, r103);
    L4:
        Class[] r104 = new Class[r102.length];
        int r105 = 0;
    L6:
        if (r105 >= r102.length) goto L20;
        Object r106 = r102[r105];
        if ((r106 instanceof String) == false) goto L15;
        r104[r105] = INVOKESTATIC_com_bytedance_xtrace_utils_TraceHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName((String) r106);     // Catch: ClassNotFoundException -> L11
    L17:
        r105 = r105 + 1;
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L15:
        if ((r106 instanceof Class) == false) goto L19;
        r104[r105] = (Class) r106;
        goto L17
    L19:
        throw new RuntimeException("not support params type :".concat(r106.getClass().getName()));
    L20:
        r103 = r104;
        goto L22
    }
}
