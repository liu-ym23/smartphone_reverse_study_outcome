package yvc;

import android.util.Log;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import me.ele.lancet.base.annotations.Skip;
import org.greenrobot.eventbus.g;

/* JADX INFO: loaded from: classes42.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f569331a = false;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class c() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.util.Log");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.util.Log");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.util.Log");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.util.Log");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.util.Log");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.util.Log");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.util.Log");
    }

    static {
        if (c() == null) goto L5;
        boolean r100 = true;
    L6:
        f569331a = r100;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public a() {
    }

    @Override // org.greenrobot.eventbus.g
    public final void b(Level r100, String r101) {
        if (r100 == Level.OFF) goto L6;
        r100.intValue();
        return;
    }

    @Override // org.greenrobot.eventbus.g
    public final void a(Level r100, String r101, Throwable r102) {
        if (r100 == Level.OFF) goto L6;
        r100.intValue();
        Log.getStackTraceString(r102);
        return;
    }
}
