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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class BDLocationReflectUtils {
    private static final Method AWEME_INIT_LOCATION_METHOD = null;
    private static final Object COMPANION_OBJECT_IN_AWEME = null;
    public static final String TAG = "passive-init";

    public BDLocationReflectUtils() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    static {
        Method r5 = null;
        Class r6 = INVOKESTATIC_com_bytedance_bdlocation_utils_BDLocationReflectUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.android.ugc.aweme.location.SimpleLocationHelper");     // Catch: Throwable -> L8
        Logger.i(TAG, "reflectInvokeAwemeLocationInit: SimpleLocationHelperClass: " + r6);     // Catch: Throwable -> L8
        Field r4 = r6.getDeclaredField("Companion");     // Catch: Throwable -> L8
        r4.setAccessible(true);     // Catch: Throwable -> L8
        Logger.i(TAG, "reflectInvokeAwemeLocationInit: CompanionField: " + r4);     // Catch: Throwable -> L8
        Object r3 = r4.get(null);     // Catch: Throwable -> L8
        Class<?> r7 = r3.getClass();     // Catch: Throwable -> L6
        Logger.i(TAG, "reflectInvokeAwemeLocationInit: CompanionClass: " + r7);     // Catch: Throwable -> L6
        r5 = r7.getDeclaredMethod("weakEnsureLocationInitialized", new Class[0]);     // Catch: Throwable -> L6
        r5.setAccessible(true);     // Catch: Throwable -> L6
        Logger.i(TAG, "reflectInvokeAwemeLocationInit: initLocationMethod: " + r5);     // Catch: Throwable -> L6
    L11:
        AWEME_INIT_LOCATION_METHOD = r5;
        COMPANION_OBJECT_IN_AWEME = r3;
        return;
    L6:
        th = th;
    L10:
        th.printStackTrace();
        Logger.e(TAG, "reflectInvokeAwemeLocationInit: error", th);
    L8:
        th = th;
        r3 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v10 */
    public static void weakEnsureAwemeLocationInit() {
        String r0 = TAG;
        long r2 = SystemClock.uptimeMillis();
        String r6 = null;
        StringBuilder r7 = new StringBuilder("sdk weakEnsureAwemeLocationInit, mainThread: ");     // Catch: Throwable -> L14
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        boolean r1 = true;
    L7:
        r7.append(r1);     // Catch: Throwable -> L14
        r7.append(", threadName: ");     // Catch: Throwable -> L14
        r7.append(ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L14
        r7.append(", AWEME_INIT_LOCATION_METHOD: ");     // Catch: Throwable -> L14
        Method r3 = AWEME_INIT_LOCATION_METHOD;     // Catch: Throwable -> L14
        r7.append(r3);     // Catch: Throwable -> L14
        r7.append(", COMPANION_OBJECT_IN_AWEME_ILT: ");     // Catch: Throwable -> L14
        Object r8 = COMPANION_OBJECT_IN_AWEME;     // Catch: Throwable -> L14
        r7.append(r8);     // Catch: Throwable -> L14
        Logger.i(TAG, r7.toString());     // Catch: Throwable -> L14
        if (r3 == null) goto L11;
        if (r8 == null) goto L11;
        String r4 = (String) r3.invoke(r8, new Object[0]);     // Catch: Throwable -> L14
        boolean r5 = true;
        r0 = 1;
    L13:
        boolean r13 = r5;
        Throwable r15 = null;
        r6 = r4;
    L17:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L19;
        boolean r9 = true;
    L20:
        long r10 = SystemClock.uptimeMillis() - r2;
        if (AWEME_INIT_LOCATION_METHOD == null) goto L23;
        boolean r11 = true;
    L25:
        if (COMPANION_OBJECT_IN_AWEME == null) goto L27;
        boolean r12 = true;
    L28:
        if (r6 != null) goto L30;
        String r14 = "error_result_null";
    L31:
        LocationMonitor.monitorPassiveInit(r9, r10, r11, r12, r13, r14, r15);
        return;
    L30:
        r14 = r6;
        goto L31
    L27:
        r12 = false;
        goto L28
    L23:
        r11 = false;
        goto L25
    L19:
        r9 = false;
    L11:
        r4 = "reflect_method_not_found";
        r5 = false;
        goto L13
    L6:
        r1 = false;
    L14:
        th = move-exception;
        th.printStackTrace();
        Logger.e(r0, "weakEnsureAwemeLocationInit: error", th);
        r15 = th;
        r13 = false;
        goto L17
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_bdlocation_utils_BDLocationReflectUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }
}
