package com.ss.android.lark.seccache.impl;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Field;
import java.security.KeyStore;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f440388a = true;

    public a() {
    }

    public static boolean b() {
        Class r100 = a();     // Catch: Exception -> L5
        Object r101 = r100.getDeclaredMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L5
        Field r102 = r100.getDeclaredField("mInitialApplication");     // Catch: Exception -> L5
        r102.setAccessible(true);     // Catch: Exception -> L5
        r102.set(r101, com.larksuite.framework.utils.b.f285948a);     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        e.printStackTrace();
        Log.e("KeyStoreHelper", "fixAndroidKeyStore failed", e);
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.ActivityThread");
    }

    public static void c() {
        if (f440388a == true) goto L5;
    L24:
        Log.i("KeyStoreHelper", "android key store don't need fix");
        return;
    L5:
        monitor-enter(a.class);
        KeyStore.getInstance("AndroidKeyStore").load(null);     // Catch: Throwable -> L9
        boolean r100 = false;
    L11:
        f440388a = r100;     // Catch: Throwable -> L21
        if (f440388a == false) goto L19;
        boolean r101 = b();     // Catch: Throwable -> L21
        if (r101 == false) goto L16;
        f440388a = false;     // Catch: Throwable -> L21
    L16:
        Log.i("KeyStoreHelper", "fix android key store, result: " + r101);     // Catch: Throwable -> L21
        monitor-exit(a.class);     // Catch: Throwable -> L21
        return;
    L19:
        monitor-exit(a.class);     // Catch: Throwable -> L21
        goto L24
    L21:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        Log.w("KeyStoreHelper", "load android key store failed", th);     // Catch: Throwable -> L21
        r100 = true;
        goto L11
    }
}
