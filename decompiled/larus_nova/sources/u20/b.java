package u20;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f548402a = 0;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.android.ec.host.api.version.VersionUtils");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.ec.host.api.version.VersionUtils");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.ec.host.api.version.VersionUtils");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.android.ec.host.api.version.VersionUtils");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.ec.host.api.version.VersionUtils");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.ec.host.api.version.VersionUtils");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.ec.host.api.version.VersionUtils");
    }

    public static int b() {
        Class r100 = a();     // Catch: Throwable -> L9
        Object r101 = r100.getMethod("getVersion", new Class[0]).invoke(r100.newInstance(), new Object[0]);     // Catch: Throwable -> L9
        ALogger.i("getEcomSaaSVersion", "versionClassName com.bytedance.android.ec.host.api.version.VersionUtils version " + r101);     // Catch: Throwable -> L9
        if (r101 == null) goto L8;
        return ((Integer) r101).intValue();
    L8:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        ALogger.e("getEcomSaaSVersion", "failed " + th.getMessage());
        return -1;
    }

    static {
    }
}
