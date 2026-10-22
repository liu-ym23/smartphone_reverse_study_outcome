package com.bytedance.xtrace;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.xtrace.utils.TraceHelper;
import com.bytedance.xtrace.utils.a;
import com.larus.utils.logger.FLogger;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public class XTrace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f272692a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f272693b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f272694c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f272695d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Interceptor f272696e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static DynamicHookCallback f272697f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Context f272698g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static HookMode f272699h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static HookState f272700i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f272701j;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    private static Method f272702m1;

    /* JADX INFO: renamed from: m2, reason: collision with root package name */
    private static Method f272703m2;

    static {
        f272692a = new Object();
        f272693b = new HashMap();
        f272694c = new ConcurrentHashMap();
        f272695d = new ConcurrentHashMap();
        f272699h = HookMode.MODE_REPLACE;
        f272701j = false;
        INVOKESTATIC_com_bytedance_xtrace_XTrace_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("xtrace");
        f272702m1 = TraceHelper.getMethod(XTrace.class, Keys.API_PARAM_KEY_M1, new Object[0]);     // Catch: Throwable -> L9
        f272703m2 = TraceHelper.getMethod(XTrace.class, Keys.API_PARAM_KEY_M2, new Object[0]);     // Catch: Throwable -> L9
        return;
    }

    public XTrace() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private static native long addTrace(Member r100);

    public static Object b(Member r100, Object r101, Object... r102) {
        Map r103 = f272695d;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        DynamicHookCallback r105 = (DynamicHookCallback) r104.get(Long.valueOf(getCurrentMethod()));
        if (r105 != null) goto L5;
        DynamicHookCallback r106 = f272697f;
        if (r106 == null) goto L11;
        return r106.intercept(r100, r101, TraceHelper.parseArgs(r100, r102));
    L11:
        return f272692a;
    L5:
        return r105.intercept(r100, r101, TraceHelper.parseArgs(r100, r102));
    }

    public static Object bridgeCall(Member r100, Object r101, Object... r102) {
        if (r100 == null) goto L7;
        Object r103 = b(r100, r101, r102);
        if (r103 == f272692a) goto L7;
        return r103;
    L7:
        return callOriginMethod(r100, r101, r102);
    }

    public static float bridgeCallReturnDouble(Member r100, Object r101, Object... r102) {
        if (r100 == null) goto L7;
        Object r103 = b(r100, r101, r102);
        if ((r103 instanceof Number) == true) goto L6;
        return 0.0f;
    L6:
        return ((Number) r103).floatValue();
    L7:
        return 0.0f;
    }

    public static long bridgeCallReturnLong(Member r100, Object r101, Object... r102) {
        if (r100 == null) goto L18;
        Object r103 = b(r100, r101, r102);
        if ((r103 instanceof Number) == false) goto L9;
        return ((Number) r103).longValue();
    L9:
        if ((r103 instanceof Character) == false) goto L13;
        return ((Character) r103).charValue();
    L13:
        if ((r103 instanceof Boolean) == true) goto L15;
        return 0;
    L15:
        if (((Boolean) r103).booleanValue() == false) goto L20;
        return 1;
    L20:
        return 0;
    L18:
        return 0;
    }

    public static boolean c(Member r100) {
        if (r100 == null) goto L4;
        return true;
    L4:
        if (TraceHelper.isDebugApk(f272698g) == true) goto L8;
        return false;
    L8:
        throw new IllegalArgumentException("Member is empty, Please check whether the method name and signature are correct!!!");
    }

    public static Object callOriginMethod(Member r100, Object r101, Object... r102) {
        prepareCallOrigin();     // Catch: InstantiationException -> L12 IllegalAccessException -> L14 InvocationTargetException -> L17
        if ((r100 instanceof Constructor) == true) goto L5;
        ((Method) r100).setAccessible(true);     // Catch: InstantiationException -> L12 IllegalAccessException -> L14 InvocationTargetException -> L17
        if (Modifier.isStatic(r100.getModifiers()) == false) goto L11;
        return ((Method) r100).invoke(null, r102);
    L11:
        return ((Method) r100).invoke(r101, r102);
    L5:
        return ((Constructor) r100).newInstance(r102);
    L14:
        e = e;
    L16:
        throw new RuntimeException("Reflection error during callOriginMethod.", e);
    L12:
        e = e;
    L17:
        e = move-exception;
        Throwable r103 = e.getCause();
        if ((r103 instanceof RuntimeException) == true) goto L27;
        if ((r103 instanceof Error) == false) goto L25;
        throw ((Error) r103);
    L25:
        throw new RuntimeException("The original method threw a checked exception.", r103);
    L27:
        throw ((RuntimeException) r103);
    }

    private static boolean dispatch(long r100, Object r101) {
        Map r102 = f272693b;
        HashMap r103 = (HashMap) r102;
        Member r104 = (Member) r103.get(Long.valueOf(r100));
        Interceptor r105 = f272696e;
        if (r105 == null) goto L7;
        if (r104 != null) goto L6;
        return false;
    L6:
        return r105.intercept(r104, r101, null);
    L7:
        return false;
    }

    private static boolean dispatch(long r100, Object r101, Object[] r102) {
        Map r103 = f272693b;
        HashMap r104 = (HashMap) r103;
        Member r105 = (Member) r104.get(Long.valueOf(r100));
        Interceptor r106 = f272696e;
        if (r106 == null) goto L7;
        if (r105 != null) goto L6;
        return false;
    L6:
        return r106.intercept(r105, r101, r102);
    L7:
        return false;
    }

    private static native int doHookForReplaceMode();

    private static native int doHookForTraceMode();

    public static synchronized void dynamicHook(Member r100) {
        monitor-enter(XTrace.class);
        dynamicHook(r100, null);     // Catch: Throwable -> L8
        monitor-exit(XTrace.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void enableGetArgs(boolean r100) {
        f272701j = nEnableGetArgs(r100);
    }

    public static void enableLog(boolean r100) {
        a.f272706a = r100;
        nEnableLog(r100);
    }

    private static native long getCurrentMethod();

    public static Member getCurrentRunningMethod() {
        long r100 = getCurrentMethod();
        Map r101 = f272694c;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        return (Member) r102.get(Long.valueOf(r100));
    }

    public static synchronized boolean init(Context r100) {
        monitor-enter(XTrace.class);
        if (initWithState(r100) != HookState.SUCCESS) goto L7;
        boolean r101 = true;
    L8:
        monitor-exit(XTrace.class);
        return r101;
    L7:
        r101 = false;
    L10:
        th = move-exception;
        throw th;
    }

    private static native void initJvmtiEnv();

    public static void m1() {
    }

    public static void m2() {
    }

    private static native void nEnableDebuggable(boolean r100);

    private static native boolean nEnableGetArgs(boolean r100);

    private static native void nEnableLog(boolean r100);

    private static native void nInit(int r100, int r101, boolean r102);

    private static native long nReplace(Member r100, Member r101);

    private static native void prepareCallOrigin();

    private static native void removeReplace(Member r100);

    private static native void removeTrace(Member r100);

    public static synchronized void replace(Member r100, Member r101) {
        monitor-enter(XTrace.class);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (f272700i == HookState.SUCCESS) goto L9;
        monitor-exit(XTrace.class);
        return;
    L9:
        if (f272699h == HookMode.MODE_REPLACE) goto L15;
        if (f272699h == HookMode.MODE_ALL) goto L15;
        monitor-exit(XTrace.class);
        return;
    L15:
        if (c(r100) == true) goto L17;
    L26:
        monitor-exit(XTrace.class);
        return;
    L17:
        if (c(r101) == false) goto L26;
        Map r102 = f272694c;     // Catch: Throwable -> L28
        if (((ConcurrentHashMap) r102).containsValue(r100) == true) goto L24;
        long r103 = nReplace(r100, r101);     // Catch: Throwable -> L28
        if (r103 == 0) goto L24;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r102;     // Catch: Throwable -> L28
        r104.put(Long.valueOf(r103), r100);     // Catch: Throwable -> L28
    L24:
        monitor-exit(XTrace.class);
    }

    public static void setHookCallback(DynamicHookCallback r100) {
        f272697f = r100;
    }

    public static void setHookMode(HookMode r100) {
        f272699h = r100;
    }

    public static void setInterceptor(Interceptor r100) {
        f272696e = r100;
    }

    public static synchronized void trace(Member r100) {
        monitor-enter(XTrace.class);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (f272700i == HookState.SUCCESS) goto L9;
        monitor-exit(XTrace.class);
        return;
    L9:
        if (c(r100) == true) goto L12;
        monitor-exit(XTrace.class);
        return;
    L12:
        Map r101 = f272693b;     // Catch: Throwable -> L19
        if (((HashMap) r101).containsValue(r100) == true) goto L17;
        long r102 = addTrace(r100);     // Catch: Throwable -> L19
        if (r102 == 0) goto L17;
        HashMap r103 = (HashMap) r101;     // Catch: Throwable -> L19
        r103.put(Long.valueOf(r102), r100);     // Catch: Throwable -> L19
    L17:
        monitor-exit(XTrace.class);
    }

    public static synchronized void unReplace(Member r100) {
        monitor-enter(XTrace.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (c(r100) == true) goto L8;
        monitor-exit(XTrace.class);
        return;
    L8:
        Map r101 = f272694c;     // Catch: Throwable -> L13
        if (((ConcurrentHashMap) r101).containsValue(r100) == false) goto L11;
        ((ConcurrentHashMap) r101).values().remove(r100);     // Catch: Throwable -> L13
        removeReplace(r100);     // Catch: Throwable -> L13
    L11:
        monitor-exit(XTrace.class);
    }

    public static synchronized void unTrace(Member r100) {
        monitor-enter(XTrace.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (c(r100) == true) goto L8;
        monitor-exit(XTrace.class);
        return;
    L8:
        Map r101 = f272693b;     // Catch: Throwable -> L13
        if (((HashMap) r101).containsValue(r100) == false) goto L11;
        ((HashMap) r101).values().remove(r100);     // Catch: Throwable -> L13
        removeTrace(r100);     // Catch: Throwable -> L13
    L11:
        monitor-exit(XTrace.class);
    }

    public static int a() {
        int r100 = doHookForTraceMode();
        HookState r101 = HookState.SUCCESS;
        if (r100 == 0) goto L6;
        return r100;
    L6:
        if (Build.VERSION.SDK_INT != 33) goto L24;
        if (f272701j == true) goto L24;
    L22:
        HookState r102 = HookState.SUCCESS;
        return 0;
    L24:
        Class r103 = Integer.TYPE;     // Catch: Exception -> L16
        boolean r104 = true;
        Method r105 = TraceHelper.getMethodByPassHiddenApi(Debug.class, "startMethodTracingDdms", new Class[]{r103, r103, Boolean.TYPE, r103});     // Catch: Exception -> L16
        if (r105 == null) goto L18;
        r105.invoke(null, new Object[]{0, 0, Boolean.FALSE, 0});     // Catch: Exception -> L16
    L19:
        if (r104 == true) goto L22;
        HookState r106 = HookState.SUCCESS;
        return 3;
    L18:
        r104 = false;
    L16:
        e = move-exception;
        e.toString();
        goto L18
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_xtrace_XTrace_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static synchronized HookState initWithState(Context r100) {
        monitor-enter(XTrace.class);
        f272698g = r100.getApplicationContext();     // Catch: Throwable -> L35
        ShadowHook.access$000();     // Catch: Throwable -> L35
        ShadowHook.access$100();     // Catch: Throwable -> L35
        int r101 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L35
        ShadowHook.b r102 = new ShadowHook.b();     // Catch: Throwable -> L35
        r102.f270294a = r101;     // Catch: Throwable -> L35
        r102.f270295b = true;     // Catch: Throwable -> L35
        r102.f270296c = false;     // Catch: Throwable -> L35
        r102.f270297d = false;     // Catch: Throwable -> L35
        ShadowHook.init(r102);     // Catch: Throwable -> L35
        int r103 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L35
        if (r103 >= 23) goto L7;
    L9:
        boolean r104 = false;
    L10:
        nInit(r103, f272699h.ordinal(), r104);     // Catch: Throwable -> L35
        if (f272699h != HookMode.MODE_TRACE) goto L15;
        HookState r105 = HookState.fromInt(a());     // Catch: Throwable -> L35
    L13:
        f272700i = r105;     // Catch: Throwable -> L35
        HookState r106 = f272700i;     // Catch: Throwable -> L35
        if (f272701j == true) goto L24;
    L33:
        monitor-exit(XTrace.class);
        return r106;
    L24:
        if (r103 < 28) goto L33;
        if (TraceHelper.isDebugApk(f272698g) == true) goto L41;
        nEnableDebuggable(true);     // Catch: Throwable -> L35
    L41:
        Debug.attachJvmtiAgent("fake_path", null, XTrace.class.getClassLoader());     // Catch: IOException -> L38 Throwable -> L35
    L30:
        initJvmtiEnv();     // Catch: Throwable -> L35
        if (TraceHelper.isDebugApk(f272698g) == true) goto L33;
        nEnableDebuggable(false);     // Catch: Throwable -> L35
        goto L33
    L15:
        if (f272699h == HookMode.MODE_REPLACE) goto L20;
        r105 = HookState.fromInt(a());     // Catch: Throwable -> L35
        if (r105 != HookState.SUCCESS) goto L13;
    L20:
        r105 = HookState.fromInt(doHookForReplaceMode());     // Catch: Throwable -> L35
        goto L13
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        r104 = true;
    L35:
        th = move-exception;
        throw th;
    }

    public static synchronized void dynamicHook(Member r100, DynamicHookCallback r101) {
        monitor-enter(XTrace.class);
        Member r102 = TraceHelper.getProxyMethod(r100);     // Catch: Throwable -> L13
        Objects.toString(r102);     // Catch: Throwable -> L13
        boolean r103 = a.f272706a;     // Catch: Throwable -> L13
        Map r104 = f272694c;     // Catch: Throwable -> L13
        if (((ConcurrentHashMap) r104).containsValue(r100) == true) goto L11;
        long r105 = nReplace(r100, r102);     // Catch: Throwable -> L13
        if (r105 == 0) goto L11;
        ConcurrentHashMap r106 = (ConcurrentHashMap) r104;     // Catch: Throwable -> L13
        r106.put(Long.valueOf(r105), r100);     // Catch: Throwable -> L13
        if (r101 == null) goto L11;
        Map r107 = f272695d;     // Catch: Throwable -> L13
        ConcurrentHashMap r108 = (ConcurrentHashMap) r107;     // Catch: Throwable -> L13
        r108.put(Long.valueOf(r105), r101);     // Catch: Throwable -> L13
    L11:
        monitor-exit(XTrace.class);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
