package lc;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f508392a = null;

    static {
    L13:
        th = move-exception;
        th.getMessage();
    L15:
        d r100 = a.f508390a;
    L16:
        f508392a = r100;
        return;
    L18:
        Constructor r101 = a().getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L10
        r101.setAccessible(true);     // Catch: Throwable -> L10
        Object r102 = r101.newInstance(new Object[0]);     // Catch: Throwable -> L10
        if (r102 == null) goto L9;
        r100 = (d) r102;     // Catch: Throwable -> L10
        goto L16
    L9:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.bcm.api2.IScopedBcmService");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.getMessage();     // Catch: Throwable -> L13
        goto L15
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.android.bcm.impl2.ScopedBcmServiceImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.bcm.impl2.ScopedBcmServiceImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.bcm.impl2.ScopedBcmServiceImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.android.bcm.impl2.ScopedBcmServiceImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.bcm.impl2.ScopedBcmServiceImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.bcm.impl2.ScopedBcmServiceImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.bcm.impl2.ScopedBcmServiceImpl");
    }
}
