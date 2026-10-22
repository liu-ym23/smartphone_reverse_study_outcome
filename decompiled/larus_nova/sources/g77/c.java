package g77;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile c f480245e;

    @Override // g77.e
    public final String c() {
        return "ActivityTaskManagerHooker";
    }

    @Override // g77.e
    public final synchronized boolean b() {
        monitor-enter(this);
    L28:
        th = move-exception;
        com.bytedance.push.utils.f.f(this.f480252a, "error when hook IActivityTaskManager ", th);     // Catch: Throwable -> L32
        return false;
    L32:
        th = move-exception;
        throw th;
    L7:
        if (this.f480255d == false) goto L10;
        monitor-exit(this);
        return true;
    L10:
        Class r100 = d("android.app.ActivityTaskManager");     // Catch: Throwable -> L28
        Field r101 = r100.getDeclaredField("IActivityTaskManagerSingleton");     // Catch: Throwable -> L28
        r101.setAccessible(true);     // Catch: Throwable -> L28
        Object r102 = r101.get(null);     // Catch: Throwable -> L28
        Class r103 = d("android.util.Singleton");     // Catch: Throwable -> L28
        r100.getDeclaredMethod("getService", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L13
    L15:
        Field r104 = r103.getDeclaredField("mInstance");     // Catch: Throwable -> L28
        r104.setAccessible(true);     // Catch: Throwable -> L28
        Object r105 = r104.get(r102);     // Catch: Throwable -> L28
        if (r105 != null) goto L20;
        com.bytedance.push.utils.f.i(this.f480252a, "hook field because rawIActivityManager is null");     // Catch: Throwable -> L28
        monitor-exit(this);
        return false;
    L20:
        Class r106 = d("android.app.IActivityTaskManager");     // Catch: Throwable -> L28
        if ((r105 instanceof c) == false) goto L25;
        com.bytedance.push.utils.f.i(this.f480252a, "not duplicate hook field because rawIActivityManager is ActivityTaskManagerHooker");     // Catch: Throwable -> L28
        monitor-exit(this);
        return true;
    L25:
        this.f480253b = r105;     // Catch: Throwable -> L28
        r104.set(r102, Proxy.newProxyInstance(ThreadMethodProxy.currentThread().getContextClassLoader(), new Class[]{r106}, this));     // Catch: Throwable -> L28
        com.bytedance.push.utils.f.b(this.f480252a, "success hook ActivityTaskManager");     // Catch: Throwable -> L28
        monitor-exit(this);
        return true;
    L13:
        th = move-exception;
        com.bytedance.push.utils.f.e(this.f480252a, "error when invoke ActivityTaskManager#getService:" + th.getLocalizedMessage() + " use IActivityTaskManagerSingleton.get backup");     // Catch: Throwable -> L28
        Method r107 = r103.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[0]);     // Catch: Throwable -> L28
        r107.setAccessible(true);     // Catch: Throwable -> L28
        r107.invoke(r102, new Object[0]);     // Catch: Throwable -> L28
        goto L15
    }

    public c() {
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
