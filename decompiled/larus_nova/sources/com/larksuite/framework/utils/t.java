package com.larksuite.framework.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes24.dex */
public final class t {
    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.app.HwChangeButtonWindowCtrl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.HwChangeButtonWindowCtrl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.HwChangeButtonWindowCtrl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.app.HwChangeButtonWindowCtrl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.HwChangeButtonWindowCtrl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.HwChangeButtonWindowCtrl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.HwChangeButtonWindowCtrl");
    }

    public static void b(Activity r100) {
    L28:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (Build.VERSION.SDK_INT == 26) goto L5;
        return;
    L5:
        if (RomUtils.g() == false) goto L38;
        Class r101 = a();     // Catch: Exception -> L28
        Field r102 = r101.getDeclaredField("mInstanceMap");     // Catch: Exception -> L28
        r102.setAccessible(true);     // Catch: Exception -> L28
        Object r103 = ((HashMap) r102.get(r101)).get(Integer.valueOf(r100.hashCode()));     // Catch: Exception -> L28
        if (r103 == null) goto L39;
        String r104 = "destoryView";
        Class<?> r105 = r103.getClass();     // Catch: Exception -> L28
    L12:
        if (r105 == Object.class) goto L16;
        Method r106 = r105.getDeclaredMethod(r104, null);     // Catch: Exception -> L15
    L17:
        r106.setAccessible(true);     // Catch: Exception -> L28
        r106.invoke(r103, null);     // Catch: InvocationTargetException -> L20 IllegalAccessException -> L22 IllegalArgumentException -> L24 Exception -> L28
    L42:
        return;
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L28
        return;
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L28
        return;
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L28
        return;
    L15:
        r105 = r105.getSuperclass();     // Catch: Exception -> L28
        goto L12
    L16:
        r106 = null;
        goto L17
    L39:
        return;
    }

    public static void c(Context r100) {
        InputMethodManager r101 = (InputMethodManager) r100.getSystemService("input_method");
        if (r101 != null) goto L5;
        return;
    L5:
        String[] r102 = {"mCurRootView", "mServedView", "mNextServedView"};
        int r103 = 0;
    L7:
        if (r103 >= 3) goto L21;
        String r104 = r102[r103];
        Field r105 = r101.getClass().getDeclaredField(r104);     // Catch: Exception -> L18
        if (r105.isAccessible() == true) goto L12;
        r105.setAccessible(true);     // Catch: Exception -> L18
    L12:
        Object r106 = r105.get(r101);     // Catch: Exception -> L18
        if ((r106 instanceof View) == false) goto L20;
        if (((View) r106).getContext() != r100) goto L29;
        r105.set(r101, null);     // Catch: Exception -> L18
        goto L20
    L29:
        return;
    L20:
        r103 = r103 + 1;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }
}
