package com.bytedance.sysoptimizer.suppress;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.alipay.sdk.m.u.i;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.SysOptimizer;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class JniExceptionSuppression {
    private static final String TAG = "JniExceptionSuppression";
    private static final AtomicBoolean initFlag = null;
    private static final Object jniExceptionCallbackListMutex = null;
    private static final HashMap<String, JniExceptionCallback> jniExceptionCallbackMap = null;
    private static final AtomicBoolean loadedFlag = null;
    private static final AtomicBoolean protectAllUnsatisfiedLinkErrorFlag = null;
    private static final JniExceptionCallback sDefaultCallback = null;

    public JniExceptionSuppression() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static native boolean applyNative(Method r100, JniExceptionCallback r101);

    private static native boolean initNative(Method r100, Method r101, Method r102);

    private static native void notExistJni();

    static {
        loadedFlag = new AtomicBoolean(false);
        initFlag = new AtomicBoolean(false);
        protectAllUnsatisfiedLinkErrorFlag = new AtomicBoolean(false);
        sDefaultCallback = new AnonymousClass1();
        jniExceptionCallbackMap = new HashMap();
        jniExceptionCallbackListMutex = new Object();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_sysoptimizer_suppress_JniExceptionSuppression_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private static synchronized boolean ensureLoaded(Context r100) {
        monitor-enter(JniExceptionSuppression.class);
        AtomicBoolean r101 = loadedFlag;     // Catch: Throwable -> L24
        if (r101.get() == false) goto L10;
        monitor-exit(JniExceptionSuppression.class);
        return true;
    L10:
        if (Build.VERSION.SDK_INT >= 23) goto L15;
        monitor-exit(JniExceptionSuppression.class);
        return false;
    L15:
        if (Process.is64Bit() == true) goto L28;
        monitor-exit(JniExceptionSuppression.class);
        return false;
    L28:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L21;
        ShadowHook.access$000();     // Catch: Throwable -> L27
        ShadowHook.access$100();     // Catch: Throwable -> L27
        int r102 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L27
        ShadowHook.b r103 = new ShadowHook.b();     // Catch: Throwable -> L27
        r103.f270294a = r102;     // Catch: Throwable -> L27
        r103.f270295b = true;     // Catch: Throwable -> L27
        r103.f270296c = false;     // Catch: Throwable -> L27
        r103.f270297d = false;     // Catch: Throwable -> L27
        ShadowHook.init(r103);     // Catch: Throwable -> L27
        r101.set(true);     // Catch: Throwable -> L27
    L21:
        boolean r104 = loadedFlag.get();     // Catch: Throwable -> L24
        monitor-exit(JniExceptionSuppression.class);
        return r104;
    L24:
        th = move-exception;
        throw th;
    }

    public static boolean onUnsatisfiedLinkErrorCallback(Throwable r100) {
        StackTraceElement[] r101 = r100.getStackTrace();
        if (r101.length <= 0) goto L20;
        String r102 = r101[0].getClassName() + "." + r101[0].getMethodName();
        Object r103 = jniExceptionCallbackListMutex;
        monitor-enter(r103);
        Iterator<Map.Entry<String, JniExceptionCallback>> r104 = jniExceptionCallbackMap.entrySet().iterator();     // Catch: Throwable -> L16
    L8:
        if (r104.hasNext() == false) goto L14;
        Map.Entry<String, JniExceptionCallback> r105 = r104.next();     // Catch: Throwable -> L16
        if (r102.equals(r105.getKey()) == false) goto L8;
        boolean r106 = r105.getValue().onUnsatisfiedLinkError(r100);     // Catch: Throwable -> L16
        monitor-exit(r103);     // Catch: Throwable -> L16
        return r106;
    L14:
        monitor-exit(r103);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L20:
        return protectAllUnsatisfiedLinkErrorFlag.get();
    }

    private static void addJniMethodCallback(String r100, JniExceptionCallback r101) {
        Object r102 = jniExceptionCallbackListMutex;
        monitor-enter(r102);
        jniExceptionCallbackMap.put(r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean applyWithList(Context r110, String r111) {
        monitor-enter(JniExceptionSuppression.class);
        if (r111 != null) goto L52;
    L47:
        monitor-exit(JniExceptionSuppression.class);
        return false;
    L52:
    L44:
        th = move-exception;
        throw th;
    L7:
        if (r111.trim().length() == 0) goto L47;
        if (ensureLoaded(r110) == true) goto L14;
        monitor-exit(JniExceptionSuppression.class);
        return false;
    L14:
        if (init(r110, false) == true) goto L17;
        monitor-exit(JniExceptionSuppression.class);
        return false;
    L17:
        String[] r112 = r111.split(i.f25853b);     // Catch: Throwable -> L44
        int r100 = r112.length;     // Catch: Throwable -> L44
        int r101 = 0;
    L18:
        if (r101 >= r112.length) goto L42;
        String[] r102 = r112[r101].split("#");     // Catch: Throwable -> L44
        if (r102.length == 2) goto L50;
        String r103 = r112[r101];     // Catch: Throwable -> L44
    L41:
        r101 = r101 + 1;
        goto L18
    L50:
        Method[] r104 = INVOKESTATIC_com_bytedance_sysoptimizer_suppress_JniExceptionSuppression_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r102[0]).getDeclaredMethods();     // Catch: Throwable -> L37
        int r105 = 0;
        boolean r106 = false;
    L54:
        if (r105 >= r104.length) goto L39;
        if (r104[r105].getName().equals(r102[1]) == false) goto L36;
        if (Modifier.isNative(r104[r105].getModifiers()) == false) goto L36;
        if (apply(r110, r104[r105], sDefaultCallback) == false) goto L35;
        String r107 = r112[r101];     // Catch: Throwable -> L49
        r106 = true;
        goto L36
    L35:
        String r108 = r112[r101];     // Catch: Throwable -> L49
    L36:
        r105 = r105 + 1;
    L39:
        if (r106 == true) goto L41;
        StringBuilder r109 = new StringBuilder();     // Catch: Throwable -> L44
        r109.append(r102[0]);     // Catch: Throwable -> L44
        r109.append(".");     // Catch: Throwable -> L44
        r109.append(r102[1]);     // Catch: Throwable -> L44
        addJniMethodCallback(r102[0] + "." + r102[1], sDefaultCallback);     // Catch: Throwable -> L44
    L38:
        String r113 = r112[r101];     // Catch: Throwable -> L44
    L37:
        r106 = false;
        goto L38
    L42:
        monitor-exit(JniExceptionSuppression.class);
        return true;
    }

    public static synchronized boolean init(Context r100, boolean r101) {
        monitor-enter(JniExceptionSuppression.class);
        AtomicBoolean r102 = protectAllUnsatisfiedLinkErrorFlag;     // Catch: Throwable -> L23
        if (r102.get() == true) goto L7;
        r102.set(r101);     // Catch: Throwable -> L23
    L7:
        AtomicBoolean r103 = initFlag;     // Catch: Throwable -> L23
        if (r103.get() == false) goto L14;
        monitor-exit(JniExceptionSuppression.class);
        return true;
    L14:
        if (ensureLoaded(r100) == true) goto L27;
        monitor-exit(JniExceptionSuppression.class);
        return false;
    L27:
        if (initNative(JniExceptionSuppression.class.getDeclaredMethod("notExistJni", new Class[0]), JniExceptionCallback.class.getDeclaredMethod("onJavaException", new Class[]{Throwable.class}), JniExceptionSuppression.class.getDeclaredMethod("onUnsatisfiedLinkErrorCallback", new Class[]{Throwable.class})) == false) goto L20;
        r103.set(true);     // Catch: Throwable -> L26
    L20:
        boolean r104 = initFlag.get();     // Catch: Throwable -> L23
        monitor-exit(JniExceptionSuppression.class);
        return r104;
    L23:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean apply(Context r100, Method r101, JniExceptionCallback r102) {
        monitor-enter(JniExceptionSuppression.class);
        if (r101 == null) goto L23;
        if (r102 == null) goto L23;
        if (ensureLoaded(r100) == true) goto L13;
        monitor-exit(JniExceptionSuppression.class);
        return false;
    L13:
        if (init(r100, false) == true) goto L28;
        monitor-exit(JniExceptionSuppression.class);
        return false;
    L28:
        addJniMethodCallback(r101.getDeclaringClass().getName() + "." + r101.getName(), r102);     // Catch: Throwable -> L19
        boolean r103 = applyNative(r101, r102);     // Catch: Throwable -> L19
        monitor-exit(JniExceptionSuppression.class);
        return r103;
    L20:
        return false;
    L23:
        new Throwable();     // Catch: Throwable -> L21
        monitor-exit(JniExceptionSuppression.class);
        return false;
    L21:
        th = move-exception;
        throw th;
    }
}
