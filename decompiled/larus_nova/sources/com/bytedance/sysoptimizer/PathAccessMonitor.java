package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Process;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.perflock.DoubleReflectUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class PathAccessMonitor {
    private static final String TAG = "PathAccessMonitor";
    private static boolean sInit;

    public PathAccessMonitor() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_sysoptimizer_PathAccessMonitor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
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

    public static void start(Context r100, String r101) {
        if (sInit == false) goto L5;
        return;
    L5:
        sInit = true;
        tryHookBlockGuard(r100, r101);
    }

    private static void tryHookBlockGuard(Context r110, String r111) {
        Method r100 = DoubleReflectUtils.getMethodInner(INVOKESTATIC_com_bytedance_sysoptimizer_PathAccessMonitor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("dalvik.system.BlockGuard"), "setVmPolicy", new Class[]{INVOKESTATIC_com_bytedance_sysoptimizer_PathAccessMonitor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("dalvik.system.BlockGuard$VmPolicy")});     // Catch: Throwable -> L5
        r100.setAccessible(true);     // Catch: Throwable -> L5
        PolarisFileWrapper r101 = new PolarisFileWrapper(r111);     // Catch: Throwable -> L5
        r101.mkdirs();     // Catch: Throwable -> L5
        final PolarisFileOutputStreamWrapper r112 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r101, "onPathAccess_" + Process.myPid() + "_" + System.currentTimeMillis()));     // Catch: Throwable -> L5
        r100.invoke(null, new Object[]{Proxy.newProxyInstance(r110.getClassLoader(), new Class[]{INVOKESTATIC_com_bytedance_sysoptimizer_PathAccessMonitor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("dalvik.system.BlockGuard$VmPolicy")}, new AnonymousClass1(r112))});     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }
}
