package nz2;

import com.bytedance.android.monitorV2.util.f;
import com.bytedance.android.monitorV2.util.o;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Method> f521373a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f521374b;

    static {
        f521373a = new HashMap();
        f521374b = false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.ss.android.agilelogger.ALog");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.ss.android.agilelogger.ALog");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.ss.android.agilelogger.ALog");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.ss.android.agilelogger.ALog");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.ss.android.agilelogger.ALog");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.ss.android.agilelogger.ALog");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.ss.android.agilelogger.ALog");
    }

    public static Method b(String r100) {
        HashMap<String, Method> r101 = f521373a;
        if (r101.containsKey(r100) == true) goto L5;
        Method r102 = o.a(a(), r100, new Class[]{String.class, String.class});     // Catch: ClassNotFoundException -> L8
    L10:
        f521373a.put(r100, r102);
        return r102;
    L8:
        e = move-exception;
        f.b(e);
        r102 = null;
        goto L10
    L5:
        return r101.get(r100);
    }

    public static boolean c(Method r100, String r101, String r102) {
        if (f521374b == false) goto L26;
        boolean r103 = true;
    L15:
        if (r103 == true) goto L17;
        return false;
    L17:
        if (r100 != null) goto L24;
    L23:
        return false;
    L24:
        r100.invoke(null, new Object[]{r101, r102});     // Catch: Throwable -> L21
        return true;
    L21:
        th = move-exception;
        f.b(th);
        goto L23
    L26:
        Method r104 = o.a(a(), "isInitSuccess", null);     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 ClassNotFoundException -> L11
        r104.setAccessible(true);     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 ClassNotFoundException -> L11
        f521374b = ((Boolean) r104.invoke(null, null)).booleanValue();     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9 ClassNotFoundException -> L11
    L13:
        r103 = f521374b;
        goto L15
    L11:
        e = move-exception;
        f.b(e);
    L9:
        e = move-exception;
        e.printStackTrace();
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }
}
