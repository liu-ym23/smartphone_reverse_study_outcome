package com.bytedance.crash.dumper;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public final class i {
    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.view.WindowManagerGlobal");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.view.WindowManagerGlobal");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.view.WindowManagerGlobal");
    }

    public static void b(File r100) {
        PolarisFileOutputStreamWrapper r101 = null;
        Class r102 = a();     // Catch: Throwable -> L9
        Object r103 = r102.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L9
        Method r104 = r102.getDeclaredMethod("dumpGfxInfo", new Class[]{FileDescriptor.class, String[].class});     // Catch: Throwable -> L9
        r104.setAccessible(true);     // Catch: Throwable -> L9
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r100, "gfxinfo.txt"));     // Catch: Throwable -> L9
        r104.invoke(r103, new Object[]{r105.getFD(), new String[0]});     // Catch: Throwable -> L6
        com.bytedance.crash.util.g.a(r105);
        return;
    L6:
        r101 = r105;
    L7:
        com.bytedance.crash.util.g.a(r101);
    }
}
