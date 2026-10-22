package oka;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.volcengine.zeus.PluginClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Runnable> f523742a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f523743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f523744c;

    public b() {
    }

    static {
        f523742a = new ArrayList();
        f523743b = false;
        f523744c = false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(PluginClassLoader r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = r100.loadClass("com.obric.memorydata.recommend.tile.ScreenObservationTilePluginBootstrap");     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.obric.memorydata.recommend.tile.ScreenObservationTilePluginBootstrap");     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.obric.memorydata.recommend.tile.ScreenObservationTilePluginBootstrap");
    L12:
        throw th;
    L34:
        Class<?> r104 = r100.loadClass("com.obric.memorydata.recommend.tile.ScreenObservationTilePluginBootstrap");     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.obric.memorydata.recommend.tile.ScreenObservationTilePluginBootstrap");     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.obric.memorydata.recommend.tile.ScreenObservationTilePluginBootstrap");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass("com.obric.memorydata.recommend.tile.ScreenObservationTilePluginBootstrap");
    }
}
