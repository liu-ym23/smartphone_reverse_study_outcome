package xpc;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f564784d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f564785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f564786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Method f564787c;

    static {
        f564784d = new b();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.vivo.gamewatch.common.GameWatchManager");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.vivo.gamewatch.common.GameWatchManager");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.vivo.gamewatch.common.GameWatchManager");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.vivo.gamewatch.common.GameWatchManager");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.vivo.gamewatch.common.GameWatchManager");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.vivo.gamewatch.common.GameWatchManager");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.vivo.gamewatch.common.GameWatchManager");
    }

    public b() {
        Class<?> r100 = a();     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9 Throwable -> L11
        this.f564785a = r100;     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9 Throwable -> L11
        this.f564786b = r100.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: InvocationTargetException -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9 Throwable -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
    }

    public final Object[] b(String r100, Object... r101) {
        if (this.f564786b == null) goto L21;
        Class<?> r102 = this.f564785a;
        if (r102 == null) goto L22;
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    L7:
        if (this.f564787c != null) goto L9;
        this.f564787c = r102.getMethod("execute", new Class[]{String.class, Object[].class});     // Catch: InvocationTargetException -> L11 IllegalAccessException -> L13 Throwable -> L15
    L9:
        return (Object[]) this.f564787c.invoke(this.f564786b, new Object[]{r100, r101});
    L22:
        return null;
    L21:
        return null;
    }
}
