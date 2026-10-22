package so7;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ro7.a f542734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f542735b;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.ug.sdk.tools.check.keep.CheckToolImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.ug.sdk.tools.check.keep.CheckToolImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.ug.sdk.tools.check.keep.CheckToolImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.ug.sdk.tools.check.keep.CheckToolImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.ug.sdk.tools.check.keep.CheckToolImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.ug.sdk.tools.check.keep.CheckToolImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.ug.sdk.tools.check.keep.CheckToolImpl");
    }

    public static synchronized ro7.a b() {
        monitor-enter(a.class);
        ro7.a r100 = f542734a;     // Catch: Throwable -> L20
        if (r100 == null) goto L9;
        monitor-exit(a.class);
        return r100;
    L9:
        if (f542735b == false) goto L23;
        monitor-exit(a.class);
        return null;
    L23:
        f542734a = (ro7.a) a().newInstance();     // Catch: Throwable -> L15
        f542735b = true;     // Catch: Throwable -> L15
    L17:
        ro7.a r101 = f542734a;     // Catch: Throwable -> L20
        monitor-exit(a.class);
        return r101;
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }
}
