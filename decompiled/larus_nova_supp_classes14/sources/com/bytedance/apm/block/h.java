package com.bytedance.apm.block;

import android.os.Build;
import android.view.View;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public static void b() {
        Class r0 = a("android.view.WindowManagerGlobal");     // Catch: Exception -> L11
        Object r1 = r0.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L11
        Field r2 = r0.getDeclaredField("mRoots");     // Catch: Exception -> L11
        r2.setAccessible(true);     // Catch: Exception -> L11
        ArrayList r3 = (ArrayList) r2.get(r1);     // Catch: Exception -> L11
        Field r4 = a("android.view.ViewRootImpl").getDeclaredField("mView");     // Catch: Exception -> L11
        r4.setAccessible(true);     // Catch: Exception -> L11
        Field r5 = View.class.getDeclaredField("mRenderNode");     // Catch: Exception -> L11
        r5.setAccessible(true);     // Catch: Exception -> L11
        if (Build.VERSION.SDK_INT <= 28) goto L5;
        Class r6 = a("android.graphics.RenderNode");     // Catch: Exception -> L11
    L6:
        Method r7 = es3.h.h(r6, new Class[0]);     // Catch: Exception -> L11
        int r8 = 0;
    L7:
        if (r8 >= r3.size()) goto L17;
        r7.invoke(r5.get(r4.get(ListProtector.get(r3, r8))), new Object[0]);     // Catch: Exception -> L11
        r8 = r8 + 1;
        goto L7
    L17:
        return;
    L5:
        r6 = a("android.view.RenderNode");     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }
}
