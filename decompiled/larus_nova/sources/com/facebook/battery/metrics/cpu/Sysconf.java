package com.facebook.battery.metrics.cpu;

import android.system.Os;
import android.system.OsConstants;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.facebook.battery.metrics.core.SystemMetricsLogger;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
class Sysconf {
    private static final String TAG = "Sysconf";

    public Sysconf() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_facebook_battery_metrics_cpu_Sysconf_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static long getScClkTck(long r100) {
        long r101 = Os.sysconf(OsConstants._SC_CLK_TCK);
        if (r101 > 0) goto L5;
        return r100;
    L5:
        return r101;
    }

    public static long getScNProcessorsConf(long r100) {
        return Os.sysconf(OsConstants._SC_NPROCESSORS_CONF);
    }

    private static void logReflectionException(Exception r100) {
        SystemMetricsLogger.wtf(TAG, "Unable to read _SC_CLK_TCK by reflection", r100);
    }

    private static long fromLibcore(String r100, long r101) {
        int r102 = INVOKESTATIC_com_facebook_battery_metrics_cpu_Sysconf_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("libcore.io.OsConstants").getField(r100).getInt(null);     // Catch: ClassNotFoundException -> L4 InvocationTargetException -> L6 IllegalAccessException -> L8 NoSuchFieldException -> L10 NoSuchMethodException -> L12
        Class r103 = INVOKESTATIC_com_facebook_battery_metrics_cpu_Sysconf_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("libcore.io.Libcore");     // Catch: ClassNotFoundException -> L4 InvocationTargetException -> L6 IllegalAccessException -> L8 NoSuchFieldException -> L10 NoSuchMethodException -> L12
        Class r104 = INVOKESTATIC_com_facebook_battery_metrics_cpu_Sysconf_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("libcore.io.Os");     // Catch: ClassNotFoundException -> L4 InvocationTargetException -> L6 IllegalAccessException -> L8 NoSuchFieldException -> L10 NoSuchMethodException -> L12
        Object r105 = r103.getField("os").get(null);     // Catch: ClassNotFoundException -> L4 InvocationTargetException -> L6 IllegalAccessException -> L8 NoSuchFieldException -> L10 NoSuchMethodException -> L12
        return ((Long) r104.getMethod("sysconf", new Class[]{Integer.TYPE}).invoke(r105, new Object[]{Integer.valueOf(r102)})).longValue();
    L4:
        e = move-exception;
        logReflectionException(e);
    L14:
        return r101;
    L8:
        e = move-exception;
        logReflectionException(e);
    L10:
        e = move-exception;
        logReflectionException(e);
    L12:
        e = move-exception;
        logReflectionException(e);
    L6:
        e = move-exception;
        logReflectionException(e);
        goto L14
    }
}
