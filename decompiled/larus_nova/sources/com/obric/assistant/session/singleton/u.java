package com.obric.assistant.session.singleton;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f391688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f391689b = null;

    static {
        f391688a = true;
        f391689b = LazyKt.lazy(new s());
    }

    public static void b() {
        if (f391688a == true) goto L13;
        FLogger.f375446a.i("SleepModeHelper", "forceExitSleepMode ignored");
        return;
    L13:
        FLogger.f375446a.i("SleepModeHelper", "forceExitSleepMode");     // Catch: Throwable -> L10
        Object r100 = f391689b.getValue();     // Catch: Throwable -> L10
        if (r100 == null) goto L15;
        r100.getClass().getMethod("forceExitSleepMode", new Class[]{String.class, String.class}).invoke(r100, new Object[]{AppHost.f326268a.getApplication().getPackageName(), "active_assist"});     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L10:
        th = move-exception;
        FLogger.f375446a.e("SleepModeHelper", "forceExitSleepMode error!", th);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
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
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
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
