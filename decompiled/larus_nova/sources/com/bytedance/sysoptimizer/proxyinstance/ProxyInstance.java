package com.bytedance.sysoptimizer.proxyinstance;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.FindCatchBlockOpt;
import com.bytedance.sysoptimizer.SysOptimizer;
import com.bytedance.sysoptimizer.perflock.DoubleReflectUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class ProxyInstance {
    private static final String TAG = "ProxyInstance";
    private static volatile ICallback sCallback;

    public interface ICallback {
        int d(String r100, String r101);

        int e(String r100, String r101);

        int e(String r100, String r101, Throwable r102);
    }

    public ProxyInstance() {
    }

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    private static native void nAdd(String r100, String r101, Class r102, Class r103);

    private static native void nRemoveFinal(Method r100);

    public static native void nSetSynchronized(Method r100);

    public static synchronized ICallback getCallback() {
        monitor-enter(ProxyInstance.class);
        ICallback r100 = sCallback;     // Catch: Throwable -> L9
        if (r100 != null) goto L7;
        r100 = new AnonymousClass1();     // Catch: Throwable -> L9
        updateCallback(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(ProxyInstance.class);
        return r100;
    L9:
        th = move-exception;
        throw th;
    }

    public static boolean isEnable() {
        ICallback r100 = getCallback();
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 27) goto L5;
    L23:
        r100.e(TAG, "NOT SUPPORT API LEVEL " + r101);
        return false;
    L5:
        if (r101 > 34) goto L23;
        if (Process.is64Bit() == true) goto L11;
        r100.e(TAG, "NOT SUPPORT 32Bit");
        return false;
    L11:
        String[] r102 = Build.SUPPORTED_ABIS;
        int r103 = r102.length;
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L21;
        String r105 = r102[r104];
        if (TextUtils.isEmpty(r105) == true) goto L20;
        if (r105.startsWith("x86") == false) goto L20;
        r100.e(TAG, "ONLY SUPPORT arm64-v8a.But current are " + TextUtils.join(",", Build.SUPPORTED_ABIS));
        return false;
    L20:
        r104 = r104 + 1;
        goto L12
    L21:
        return true;
    }

    public static void logStackTrace() {
        getCallback().e(TAG, "logStackTrace", new Throwable());
    }

    private static void updateAccessFlag(Class r100) {
        Field r101 = DoubleReflectUtils.getField(Class.class, "objectSizeAllocFastPath");     // Catch: Throwable -> L12
        r101.setAccessible(true);     // Catch: Throwable -> L12
        r101.set(r100, 2147483632);     // Catch: Throwable -> L12
        Field r102 = DoubleReflectUtils.getField(Class.class, "accessFlags");     // Catch: Throwable -> L12
        r102.setAccessible(true);     // Catch: Throwable -> L12
        int r103 = ((Integer) r102.get(r100)).intValue();     // Catch: Throwable -> L12
        if ((r103 & Integer.MIN_VALUE) == 0) goto L6;
        getCallback().e(TAG, "isFinalizable Class 1 " + r100);     // Catch: Throwable -> L12
    L6:
        r102.set(r100, Integer.valueOf(((r103 | Integer.MIN_VALUE) | 1) & (-17)));     // Catch: Throwable -> L12
        Method[] r104 = r100.getDeclaredMethods();     // Catch: Throwable -> L12
        int r105 = r104.length;     // Catch: Throwable -> L12
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L20;
        Method r107 = r104[r106];     // Catch: Throwable -> L12
        r107.setAccessible(true);     // Catch: Throwable -> L12
        getCallback().d(TAG, "add() called method = [" + r107 + "]");     // Catch: Throwable -> L12
        if (Modifier.isFinal(r107.getModifiers()) == false) goto L11;
        r107.setAccessible(true);     // Catch: Throwable -> L12
        getCallback().d(TAG, "add() called RemoveFinal method = [" + r107 + "]");     // Catch: Throwable -> L12
        nRemoveFinal(r107);     // Catch: Throwable -> L12
    L11:
        r106 = r106 + 1;
        goto L7
    L20:
        return;
    L12:
        th = move-exception;
        getCallback().e(TAG, "updateAccessFlag() called", th);
    }

    public static synchronized void updateCallback(ICallback r100) {
        monitor-enter(ProxyInstance.class);
        sCallback = r100;     // Catch: Throwable -> L7
        monitor-exit(ProxyInstance.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void add(Class r100, Class r101) {
        getCallback().d(TAG, "add() called with: originClass = [" + r100 + "], proxyClass = [" + r101 + "]");
        INVOKESTATIC_com_bytedance_sysoptimizer_proxyinstance_ProxyInstance_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101.getName(), true, r101.getClassLoader());     // Catch: Throwable -> L5
        String r102 = FindCatchBlockOpt.Util.getClassSignature(r100);     // Catch: Throwable -> L5
        String r103 = r101.getName().replace('.', '/');     // Catch: Throwable -> L5
        getCallback().d(TAG, "add() called with: originClass = [" + r102 + "], proxyClass = [" + r103 + "]");     // Catch: Throwable -> L5
        nAdd(r102, r103, r100, r101);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        getCallback().e(TAG, "add() called", th);
    }

    public static void add(String r100, String r101) {
        add(r100, true, ProxyInstance.class.getClassLoader(), r101, true, ProxyInstance.class.getClassLoader());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_sysoptimizer_proxyinstance_ProxyInstance_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    public static void add(String r100, boolean r101, ClassLoader r102, String r103, boolean r104, ClassLoader r105) {
        if (isEnable() == true) goto L12;
        return;
    L12:
        getCallback().d(TAG, "add() called with: originClass = [" + r100 + "], proxyClass = [" + r103 + "]");     // Catch: Throwable -> L9
        if (SysOptimizer.loadOptimizerLibrary(null) == false) goto L14;
        ShadowHook.access$000();     // Catch: Throwable -> L9
        ShadowHook.access$100();     // Catch: Throwable -> L9
        int r106 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L9
        ShadowHook.b r107 = new ShadowHook.b();     // Catch: Throwable -> L9
        r107.f270294a = r106;     // Catch: Throwable -> L9
        r107.f270295b = true;     // Catch: Throwable -> L9
        r107.f270296c = false;     // Catch: Throwable -> L9
        r107.f270297d = false;     // Catch: Throwable -> L9
        ShadowHook.init(r107);     // Catch: Throwable -> L9
        Class r108 = INVOKESTATIC_com_bytedance_sysoptimizer_proxyinstance_ProxyInstance_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100, r101, r102);     // Catch: Throwable -> L9
        updateAccessFlag(r108);     // Catch: Throwable -> L9
        add(r108, INVOKESTATIC_com_bytedance_sysoptimizer_proxyinstance_ProxyInstance_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r103, r104, r105));     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        getCallback().e(TAG, "add() called", th);
    }
}
