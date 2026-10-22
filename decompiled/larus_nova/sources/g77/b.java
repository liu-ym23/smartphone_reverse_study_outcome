package g77;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile b f480244e;

    @Override // g77.e
    public final synchronized boolean b() {
        monitor-enter(this);
    L22:
        th = move-exception;
        com.bytedance.push.utils.f.f(this.f480252a, "error when hook IActivityManager ", th);     // Catch: Throwable -> L26
        return false;
    L26:
        th = move-exception;
        throw th;
    L6:
        if (this.f480255d == false) goto L9;
        monitor-exit(this);
        return true;
    L9:
        Field r100 = d("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");     // Catch: Throwable -> L22
        r100.setAccessible(true);     // Catch: Throwable -> L22
        Object r101 = r100.get(null);     // Catch: Throwable -> L22
        Field r102 = d("android.util.Singleton").getDeclaredField("mInstance");     // Catch: Throwable -> L22
        r102.setAccessible(true);     // Catch: Throwable -> L22
        Object r103 = r102.get(r101);     // Catch: Throwable -> L22
        if (r103 != null) goto L15;
        com.bytedance.push.utils.f.i(this.f480252a, "hook field because rawIActivityManager is null");     // Catch: Throwable -> L22
        monitor-exit(this);
        return false;
    L15:
        if ((r103 instanceof b) == false) goto L19;
        com.bytedance.push.utils.f.i(this.f480252a, "not duplicate hook field because rawIActivityManager is ActivityTaskManagerHooker");     // Catch: Throwable -> L22
        monitor-exit(this);
        return true;
    L19:
        this.f480253b = r103;     // Catch: Throwable -> L22
        Class r104 = d("android.app.IActivityManager");     // Catch: Throwable -> L22
        r102.set(r101, Proxy.newProxyInstance(ThreadMethodProxy.currentThread().getContextClassLoader(), new Class[]{r104}, this));     // Catch: Throwable -> L22
        com.bytedance.push.utils.f.b(this.f480252a, "success hook IActivityManager");     // Catch: Throwable -> L22
        monitor-exit(this);
        return true;
    }

    @Override // g77.e
    public final String c() {
        return "ActivityManagerHooker";
    }

    public b() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class d(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }
}
