package com.bytedance.bdlocation.utils;

import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import el9.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes10.dex */
public class BDLocationReflectUtils {
    private static final Method AWEME_INIT_LOCATION_METHOD = null;
    private static final Object COMPANION_OBJECT_IN_AWEME = null;
    public static final String TAG = "passive-init";

    public BDLocationReflectUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        Method r100 = null;
        Class r101 = INVOKESTATIC_com_bytedance_bdlocation_utils_BDLocationReflectUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.android.ugc.aweme.location.SimpleLocationHelper");     // Catch: Throwable -> L8
        Logger.i(TAG, "reflectInvokeAwemeLocationInit: SimpleLocationHelperClass: " + r101);     // Catch: Throwable -> L8
        Field r102 = r101.getDeclaredField("Companion");     // Catch: Throwable -> L8
        r102.setAccessible(true);     // Catch: Throwable -> L8
        Logger.i(TAG, "reflectInvokeAwemeLocationInit: CompanionField: " + r102);     // Catch: Throwable -> L8
        Object r103 = r102.get(null);     // Catch: Throwable -> L8
        Class<?> r104 = r103.getClass();     // Catch: Throwable -> L6
        Logger.i(TAG, "reflectInvokeAwemeLocationInit: CompanionClass: " + r104);     // Catch: Throwable -> L6
        r100 = r104.getDeclaredMethod("weakEnsureLocationInitialized", new Class[0]);     // Catch: Throwable -> L6
        r100.setAccessible(true);     // Catch: Throwable -> L6
        Logger.i(TAG, "reflectInvokeAwemeLocationInit: initLocationMethod: " + r100);     // Catch: Throwable -> L6
    L11:
        AWEME_INIT_LOCATION_METHOD = r100;
        COMPANION_OBJECT_IN_AWEME = r103;
        return;
    L6:
        th = th;
    L10:
        th.printStackTrace();
        Logger.e(TAG, "reflectInvokeAwemeLocationInit: error", th);
    L8:
        th = th;
        r103 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v10 */
    public static void weakEnsureAwemeLocationInit() {
        String r100 = TAG;
        long r101 = SystemClock.uptimeMillis();
        String r102 = null;
        StringBuilder r103 = new StringBuilder("sdk weakEnsureAwemeLocationInit, mainThread: ");     // Catch: Throwable -> L14
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        boolean r104 = true;
    L7:
        r103.append(r104);     // Catch: Throwable -> L14
        r103.append(", threadName: ");     // Catch: Throwable -> L14
        r103.append(ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L14
        r103.append(", AWEME_INIT_LOCATION_METHOD: ");     // Catch: Throwable -> L14
        Method r105 = AWEME_INIT_LOCATION_METHOD;     // Catch: Throwable -> L14
        r103.append(r105);     // Catch: Throwable -> L14
        r103.append(", COMPANION_OBJECT_IN_AWEME_ILT: ");     // Catch: Throwable -> L14
        Object r106 = COMPANION_OBJECT_IN_AWEME;     // Catch: Throwable -> L14
        r103.append(r106);     // Catch: Throwable -> L14
        Logger.i(TAG, r103.toString());     // Catch: Throwable -> L14
        if (r105 == null) goto L11;
        if (r106 == null) goto L11;
        String r107 = (String) r105.invoke(r106, new Object[0]);     // Catch: Throwable -> L14
        boolean r108 = true;
        r100 = 1;
    L13:
        boolean r110 = r108;
        Throwable r111 = null;
        r102 = r107;
    L17:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L19;
        boolean r109 = true;
    L20:
        long r112 = SystemClock.uptimeMillis() - r101;
        if (AWEME_INIT_LOCATION_METHOD == null) goto L23;
        boolean r113 = true;
    L25:
        if (COMPANION_OBJECT_IN_AWEME == null) goto L27;
        boolean r114 = true;
    L28:
        if (r102 != null) goto L30;
        String r115 = "error_result_null";
    L31:
        LocationMonitor.monitorPassiveInit(r109, r112, r113, r114, r110, r115, r111);
        return;
    L30:
        r115 = r102;
        goto L31
    L27:
        r114 = false;
        goto L28
    L23:
        r113 = false;
        goto L25
    L19:
        r109 = false;
    L11:
        r107 = "reflect_method_not_found";
        r108 = false;
        goto L13
    L6:
        r104 = false;
    L14:
        th = move-exception;
        th.printStackTrace();
        Logger.e(r100, "weakEnsureAwemeLocationInit: error", th);
        r111 = th;
        r110 = false;
        goto L17
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_bdlocation_utils_BDLocationReflectUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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
}
