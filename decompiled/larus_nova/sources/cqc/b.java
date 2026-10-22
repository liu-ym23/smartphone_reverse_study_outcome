package cqc;

import android.util.Log;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements c {
    public b() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("dalvik.system.VMRuntime");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("dalvik.system.VMRuntime");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("dalvik.system.VMRuntime");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("dalvik.system.VMRuntime");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("dalvik.system.VMRuntime");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("dalvik.system.VMRuntime");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("dalvik.system.VMRuntime");
    }

    @Override // cqc.c
    public final void invokeHiddenApiRestrictions() {
        Method r100 = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class});     // Catch: Exception -> L4
        Class r101 = a();     // Catch: Exception -> L4
        Method r102 = (Method) r100.invoke(r101, new Object[]{"getRuntime", new Class[0]});     // Catch: Exception -> L4
        r102.setAccessible(true);     // Catch: Exception -> L4
        Object r103 = r102.invoke(null, new Object[0]);     // Catch: Exception -> L4
        Method r104 = (Method) r100.invoke(r101, new Object[]{"setHiddenApiExemptions", new Class[]{String[].class}});     // Catch: Exception -> L4
        r104.setAccessible(true);     // Catch: Exception -> L4
        r104.invoke(r103, new Object[]{new String[]{"L"}});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.getStackTraceString(e);
    }
}
