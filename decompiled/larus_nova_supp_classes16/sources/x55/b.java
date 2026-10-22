package x55;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements a {
    public b() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class f() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.bytedance.mira.Mira");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.mira.Mira");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.mira.Mira");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.bytedance.mira.Mira");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.mira.Mira");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.mira.Mira");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.mira.Mira");
    }

    @Override // x55.a
    public final boolean a() {
        return ((Boolean) f().getMethod("isPluginInstalled", new Class[]{String.class}).invoke(null, new Object[]{"com.bytedance.ee.plugin.ttoffice"})).booleanValue();
    L5:
        th = move-exception;
        tt5.a.f("MiraPluginManager", th, false);
        return false;
    }

    @Override // x55.a
    public final boolean b() {
        return ((Boolean) f().getMethod("isPluginLoaded", new Class[]{String.class}).invoke(null, new Object[]{"com.bytedance.ee.plugin.ttoffice"})).booleanValue();
    L5:
        th = move-exception;
        tt5.a.f("MiraPluginManager", th, false);
        return false;
    }

    @Override // x55.a
    public final boolean c() {
        return ((Boolean) f().getMethod("unInstallPlugin", new Class[]{String.class}).invoke(null, new Object[]{"com.bytedance.ee.plugin.ttoffice"})).booleanValue();
    L5:
        th = move-exception;
        tt5.a.f("MiraPluginManager", th, false);
        return false;
    }

    @Override // x55.a
    public final Object d() {
        return f().getMethod("getPlugin", new Class[]{String.class}).invoke(null, new Object[]{"com.bytedance.ee.plugin.ttoffice"});
    L5:
        th = move-exception;
        tt5.a.f("MiraPluginManager", th, false);
        return null;
    }

    @Override // x55.a
    public final ClassLoader e() {
        return (ClassLoader) f().getMethod("getPluginClassLoader", new Class[]{String.class}).invoke(null, new Object[]{"com.bytedance.ee.plugin.ttoffice"});
    L5:
        th = move-exception;
        tt5.a.f("MiraPluginManager", th, false);
        return null;
    }

    @Override // x55.a
    public final boolean loadPlugin() {
        return ((Boolean) f().getMethod("loadPlugin", new Class[]{String.class}).invoke(null, new Object[]{"com.bytedance.ee.plugin.ttoffice"})).booleanValue();
    L5:
        th = move-exception;
        tt5.a.f("MiraPluginManager", th, false);
        return false;
    }
}
