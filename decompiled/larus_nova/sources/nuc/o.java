package nuc;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes42.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f520743a = false;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static void a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class.forName("java.lang.ClassValue");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
        FastClassNotFoundHandler.a("java.lang.ClassValue");     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("java.lang.ClassValue");
    L12:
        throw th;
    L34:
        Class.forName("java.lang.ClassValue");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
        FastClassNotFoundHandler.a("java.lang.ClassValue");     // Catch: Throwable -> L17
        return;
    L37:
        return;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("java.lang.ClassValue");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == false) goto L26;
    L29:
        MiraPluginFix.forName("java.lang.ClassValue");
        return;
    L26:
        if ((th instanceof NoClassDefFoundError) == true) goto L29;
        throw th;
    }

    static {
        a();     // Catch: Throwable -> L4
        boolean r100 = true;
    L5:
        f520743a = r100;
        return;
    L4:
        r100 = false;
        goto L5
    }
}
