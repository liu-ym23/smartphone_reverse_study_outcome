package com.obric.sva.framework.wrapper;

import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class WindowManagerGlobalWrapper {
    public WindowManagerGlobalWrapper() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public void dismissKeyguard() {
        Class r100 = INVOKESTATIC_com_obric_sva_framework_wrapper_WindowManagerGlobalWrapper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.WindowManagerGlobal");     // Catch: InvocationTargetException -> L14 IllegalArgumentException -> L16 IllegalAccessException -> L18 SecurityException -> L20 NoSuchMethodException -> L22 ClassNotFoundException -> L24
        Object r101 = r100.getMethod("getWindowManagerService", new Class[0]).invoke(r100, new Object[0]);     // Catch: InvocationTargetException -> L14 IllegalArgumentException -> L16 IllegalAccessException -> L18 SecurityException -> L20 NoSuchMethodException -> L22 ClassNotFoundException -> L24
        if (r101 == null) goto L27;
        Class r102 = INVOKESTATIC_com_obric_sva_framework_wrapper_WindowManagerGlobalWrapper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.IWindowManager");     // Catch: InvocationTargetException -> L14 IllegalArgumentException -> L16 IllegalAccessException -> L18 SecurityException -> L20 NoSuchMethodException -> L22 ClassNotFoundException -> L24
        int r103 = Build.VERSION.SDK_INT;     // Catch: InvocationTargetException -> L14 IllegalArgumentException -> L16 IllegalAccessException -> L18 SecurityException -> L20 NoSuchMethodException -> L22 ClassNotFoundException -> L24
        if (r103 >= 26) goto L10;
        r102.getMethod("dismissKeyguard", new Class[0]).invoke(r101, new Object[0]);     // Catch: InvocationTargetException -> L14 IllegalArgumentException -> L16 IllegalAccessException -> L18 SecurityException -> L20 NoSuchMethodException -> L22 ClassNotFoundException -> L24
        goto L27
    L10:
        if (r103 >= 28) goto L12;
        r102.getMethod("dismissKeyguard", new Class[]{INVOKESTATIC_com_obric_sva_framework_wrapper_WindowManagerGlobalWrapper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.internal.policy.IKeyguardDismissCallback")}).invoke(r101, new Object[]{null});     // Catch: InvocationTargetException -> L14 IllegalArgumentException -> L16 IllegalAccessException -> L18 SecurityException -> L20 NoSuchMethodException -> L22 ClassNotFoundException -> L24
        goto L27
    L12:
        r102.getMethod("dismissKeyguard", new Class[]{INVOKESTATIC_com_obric_sva_framework_wrapper_WindowManagerGlobalWrapper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.internal.policy.IKeyguardDismissCallback"), CharSequence.class}).invoke(r101, new Object[]{null, null});     // Catch: InvocationTargetException -> L14 IllegalArgumentException -> L16 IllegalAccessException -> L18 SecurityException -> L20 NoSuchMethodException -> L22 ClassNotFoundException -> L24
    L27:
        return;
    L24:
        e = move-exception;
        e.printStackTrace();
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L22:
        e = move-exception;
        e.printStackTrace();
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_sva_framework_wrapper_WindowManagerGlobalWrapper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
}
