package com.obric.sva.sdk.boost;

import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public class DoubleReflector {
    private static final String TAG = "DoubleReflector";
    private static Method mForNameMethod;
    private static Method mGetDeclaredConstructorMethod;
    private static Method mGetDeclaredFieldMethod;
    private static Method mGetDeclaredMethod;

    public DoubleReflector() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        mGetDeclaredFieldMethod = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});     // Catch: Throwable -> L4
        mGetDeclaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class});     // Catch: Throwable -> L4
        mGetDeclaredConstructorMethod = Class.class.getDeclaredMethod("getDeclaredConstructor", new Class[]{Class[].class});     // Catch: Throwable -> L4
        mForNameMethod = Class.class.getDeclaredMethod("forName", new Class[]{String.class});     // Catch: Throwable -> L4
        return;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_sva_sdk_boost_DoubleReflector_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static Class<?> getClass(String r100) throws Exception {
        Class<?> r101 = null;
        if (Build.VERSION.SDK_INT < 29) goto L7;
        Method r102 = mForNameMethod;
        if (r102 == null) goto L7;
        r101 = (Class) r102.invoke(null, new Object[]{r100});
    L7:
        if (r101 == null) goto L9;
        return r101;
    L9:
        return INVOKESTATIC_com_obric_sva_sdk_boost_DoubleReflector_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);
    }

    public static Constructor getConstructor(Class<?> r100, Class<?>... r101) throws Exception {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        Method r102 = mGetDeclaredConstructorMethod;
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

    public static Field getField(Class<?> r100, String r101) throws Exception {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        Method r102 = mGetDeclaredFieldMethod;
        if (r102 == null) goto L7;
        Field r103 = (Field) r102.invoke(r100, new Object[]{r101});
    L8:
        if (r103 == null) goto L10;
        return r103;
    L10:
        return r100.getDeclaredField(r101);
    L7:
        r103 = null;
        goto L8
    }

    public static Object readField(Object r100, String r101) {
        Field r102 = getField(r100.getClass(), r101);     // Catch: Throwable -> L4
        r102.setAccessible(true);     // Catch: Throwable -> L4
        return r102.get(r100);
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static Method getMethod(Class<?> r100, String r101, Class<?>... r102) throws Exception {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        Method r103 = mGetDeclaredMethod;
        if (r103 == null) goto L7;
        Method r104 = (Method) r103.invoke(r100, new Object[]{r101, r102});
    L8:
        if (r104 == null) goto L10;
        return r104;
    L10:
        return r100.getDeclaredMethod(r101, r102);
    L7:
        r104 = null;
        goto L8
    }
}
