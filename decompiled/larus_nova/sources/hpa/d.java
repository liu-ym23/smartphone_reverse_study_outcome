package hpa;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.relax.embedding.LLog;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f486489a;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.relaxdevtool.RelaxDevToolEnv");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.relaxdevtool.RelaxDevToolEnv");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.relaxdevtool.RelaxDevToolEnv");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.relaxdevtool.RelaxDevToolEnv");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.relaxdevtool.RelaxDevToolEnv");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.relaxdevtool.RelaxDevToolEnv");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.relaxdevtool.RelaxDevToolEnv");
    }

    public static synchronized void b() {
        monitor-enter(d.class);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (f486489a == null) goto L26;
        monitor-exit(d.class);
        return;
    L26:
        Object r100 = a().getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: InvocationTargetException -> L12 IllegalAccessException -> L14 Throwable -> L16 ClassNotFoundException -> L18 Throwable -> L22
        if ((r100 instanceof b) == false) goto L20;
        f486489a = (b) r100;     // Catch: InvocationTargetException -> L12 IllegalAccessException -> L14 Throwable -> L16 ClassNotFoundException -> L18 Throwable -> L22
    L20:
        monitor-exit(d.class);
        return;
    L16:
        e = move-exception;
        LLog.e("RelaxDevToolUtils: ensureServiceInitialize failed: " + e);     // Catch: Throwable -> L22
        goto L20
    }
}
