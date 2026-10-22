package com.bytedance.mira.compat.p;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class HackHelperImpl {
    public HackHelperImpl() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_compat_p_HackHelperImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static Class<?> getClass(String r100) throws ClassNotFoundException {
        return INVOKESTATIC_com_bytedance_mira_compat_p_HackHelperImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);
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
