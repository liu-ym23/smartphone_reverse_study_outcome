package pl.droidsonroids.gif;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.getkeepsafe.relinker.ReLinker;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f529744a;

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("pl_droidsonroids_gif", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> pl_droidsonroids_gif");
        com.bytedance.librarian.a.c("pl_droidsonroids_gif");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> pl_droidsonroids_gif");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class b() throws ClassNotFoundException {
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

    private static Context getContext() {
        if (f529744a != null) goto L10;
        f529744a = (Context) b().getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", e);
    L10:
        return f529744a;
    }

    public static void c() {
        a();     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        ReLinker.loadLibrary(getContext(), "pl_droidsonroids_gif");
    }
}
