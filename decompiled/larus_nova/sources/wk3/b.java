package wk3;

import android.app.Application;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes14.dex */
public final class b {
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

    public static Application b() {
        Class r100 = a();     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 IllegalAccessException -> L13 NoSuchMethodException -> L15
        Object r101 = r100.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 IllegalAccessException -> L13 NoSuchMethodException -> L15
        Object r102 = r100.getMethod("getApplication", new Class[0]).invoke(r101, new Object[0]);     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 IllegalAccessException -> L13 NoSuchMethodException -> L15
        if (r102 == null) goto L8;
        return (Application) r102;
    L8:
        throw new NullPointerException("you should init first");     // Catch: ClassNotFoundException -> L9 InvocationTargetException -> L11 IllegalAccessException -> L13 NoSuchMethodException -> L15
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L18:
        throw new NullPointerException("you should init first");
    L13:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L11:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L18
    }

    static {
    }
}
