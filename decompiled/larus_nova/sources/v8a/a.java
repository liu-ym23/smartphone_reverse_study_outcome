package v8a;

import android.content.Context;
import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f553744a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f553745b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Class f553746c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Class f553747d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final PathClassLoader f553748e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Constructor<Class> f553749f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f553750g = null;

    static {
        if (Build.VERSION.SDK_INT > 33) goto L5;
        String r100 = "/system/framework/MiuiBooster.jar";
    L6:
        f553744a = null;
        f553745b = null;
        f553747d = null;
        f553749f = null;
        f553750g = null;
        PathClassLoader r101 = new PathClassLoader(r100, ClassLoader.getSystemClassLoader());     // Catch: Exception -> L33
        f553748e = r101;     // Catch: Exception -> L33
        Class r102 = a(r101, "com.miui.performance.MiuiBooster");     // Catch: Exception -> L33
        f553746c = r102;     // Catch: Exception -> L33
        f553749f = r102.getConstructor(new Class[0]);     // Catch: Exception -> L33
        f553744a = r102.getDeclaredMethod("checkPermission", new Class[]{String.class, Integer.TYPE});     // Catch: Exception -> L42
    L80:
        f553747d = a(f553748e, "com.miui.performance.IThermalEventCallBack");     // Catch: Exception -> L43
    L63:
        f553745b = f553746c.getDeclaredMethod("checkPermission", new Class[]{Context.class, String.class, Integer.TYPE, String.class});     // Catch: Exception -> L44
    L82:
        Class<?> r103 = Integer.TYPE;     // Catch: Exception -> L45
        f553746c.getDeclaredMethod("requestCpuHighFreq", new Class[]{r103, r103, r103});     // Catch: Exception -> L45
    L68:
        f553746c.getDeclaredMethod("cancelCpuHighFreq", new Class[]{Integer.TYPE});     // Catch: Exception -> L46
    L88:
        Class<?> r104 = Integer.TYPE;     // Catch: Exception -> L47
        f553746c.getDeclaredMethod("requestThreadPriority", new Class[]{r104, r104, r104});     // Catch: Exception -> L47
    L66:
        Class<?> r105 = Integer.TYPE;     // Catch: Exception -> L48
        f553746c.getDeclaredMethod("cancelThreadPriority", new Class[]{r105, r105});     // Catch: Exception -> L48
    L86:
        Class<?> r106 = Integer.TYPE;     // Catch: Exception -> L49
        f553746c.getDeclaredMethod("requestGpuHighFreq", new Class[]{r106, r106, r106});     // Catch: Exception -> L49
    L74:
        f553746c.getDeclaredMethod("cancelGpuHighFreq", new Class[]{Integer.TYPE});     // Catch: Exception -> L50
    L94:
        Class<?> r107 = Integer.TYPE;     // Catch: Exception -> L51
        f553746c.getDeclaredMethod("requestDdrHighFreq", new Class[]{r107, r107, r107});     // Catch: Exception -> L51
    L96:
        f553746c.getDeclaredMethod("cancelDdrHighFreq", new Class[]{Integer.TYPE});     // Catch: Exception -> L52
    L92:
        Class<?> r108 = Integer.TYPE;     // Catch: Exception -> L53
        f553746c.getDeclaredMethod("requestBindCore", new Class[]{r108, int[].class, r108, r108});     // Catch: Exception -> L53
    L72:
        Class<?> r109 = Integer.TYPE;     // Catch: Exception -> L54
        f553746c.getDeclaredMethod("cancelBindCore", new Class[]{r109, r109});     // Catch: Exception -> L54
    L90:
        f553746c.getDeclaredMethod("requestIOPrefetch", new Class[]{Integer.TYPE, String.class});     // Catch: Exception -> L55
    L61:
        Class<?> r110 = Integer.TYPE;     // Catch: Exception -> L56
        f553746c.getDeclaredMethod("getSystemState", new Class[]{r110, Context.class, r110});     // Catch: Exception -> L56
    L102:
        Class<?> r111 = Integer.TYPE;     // Catch: Exception -> L57
        f553746c.getDeclaredMethod("setDynamicRefreshRateScene", new Class[]{r111, String.class, r111});     // Catch: Exception -> L57
    L78:
        f553746c.getDeclaredMethod("registerThermalEventCallback", new Class[]{Integer.TYPE, f553747d});     // Catch: Exception -> L27
    L70:
        f553746c.getDeclaredMethod("unRegisterThermalEventCallback", new Class[]{Integer.TYPE, f553747d});     // Catch: Exception -> L58
    L84:
        Class<?> r112 = Integer.TYPE;     // Catch: Exception -> L59
        f553746c.getDeclaredMethod("requestThreadLevelPro", new Class[]{r112, int[].class, r112, r112});     // Catch: Exception -> L59
    L76:
        Class<?> r113 = Integer.TYPE;     // Catch: Exception -> L60
        f553746c.getDeclaredMethod("cancelThreadLevelPro", new Class[]{r113, r113});     // Catch: Exception -> L60
    L100:
        Constructor<Class> r114 = f553749f;     // Catch: Exception -> L39
        if (r114 == null) goto L104;
        f553750g = r114.newInstance(new Object[0]);     // Catch: Exception -> L39
        return;
    L104:
        return;
    L39:
        e = move-exception;
        e.toString();
        return;
    L27:
        e = move-exception;
        e.toString();     // Catch: Exception -> L33
    L33:
        e = move-exception;
        e.toString();
        goto L100
    L5:
        r100 = "/system_ext/framework/MiuiBooster.jar";
        goto L6
    }

    public static boolean bindService() {
        return false;
    }

    public static void unbindService() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }
}
