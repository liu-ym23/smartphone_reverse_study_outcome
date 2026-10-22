package com.bytedance.sysoptimizer.javahook;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.BitmapRecycleOpt;
import com.bytedance.sysoptimizer.FindCatchBlockOpt;
import com.bytedance.sysoptimizer.SysOptimizer;
import com.bytedance.sysoptimizer.perflock.DoubleReflectUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes22.dex */
public class AHook {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "AHook";
    private static Field artMethodField;
    private static Method dummyInvokeMethod;
    private static Method invokeMethod;
    private static Method invokeMethodFast;
    private static volatile ICallback sCallback;
    private static final AtomicBoolean sInit = null;
    public static ConcurrentHashMap<String, Constructor> sOriginConstructor;
    public static ConcurrentHashMap<String, HookItem> sOriginMethod;

    public static class HookItem {
        Method origin;
        Constructor originConst;
        Method proxy;
        Constructor proxyConst;
        boolean unHookVTableWhenInvokeOrigin;

        private HookItem() {
        }

        public /* synthetic */ HookItem(AnonymousClass1 r100) {
            this();
        }
    }

    public interface ICallback {
        int d(String r100, String r101);

        int e(String r100, String r101);

        int e(String r100, String r101, Throwable r102);
    }

    public AHook() {
    }

    private static native Object invoke(long r100, String r101, Object r102, Object r103, Object... r104) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    private static native int nClearTLSIgnoreFlag(long r100, Class r101, boolean r102);

    public static native void nDumpClz(Class r100);

    private static native void nDumpObj(Object r100);

    private static native void nEnsureFastNative(long r100);

    private static native int nSetTLSIgnoreFlag(long r100, Class r101, boolean r102);

    private static native int nStart(long r100, long r101, long[] r102);

    private static native void reservedForJniOffset();

    static {
        sInit = new AtomicBoolean(false);
        sOriginMethod = new ConcurrentHashMap();
        sOriginConstructor = new ConcurrentHashMap();
        sCallback = null;
    }

    public static void assertHookBitmapRecycle() {
        Bitmap r100 = Bitmap.createBitmap(128, 128, Bitmap.Config.ARGB_8888);
        FindCatchBlockOpt.Util.printMethods("android.graphics.Bitmap", r100);     // Catch: Throwable -> L9
        BitmapRecycleOpt.start(null, false);     // Catch: Throwable -> L9
        r100.recycle();     // Catch: Throwable -> L9
        if (r100.isRecycled() == true) goto L8;
        return;
    L8:
        throw new IllegalStateException();
    L9:
        th = move-exception;
        throw new IllegalStateException(th);
    }

    private static void beforeHook() {
        ThreadMethodProxy.start(new PthreadThreadV2(new AnonymousClass4(), "avahook/AHook"));
        SystemClock.sleep(100);
    }

    private static Field getArtMethodField() {
        Field r100 = artMethodField;
        if (r100 != null) goto L6;
        Field r101 = DoubleReflectUtils.getField(Executable.class, "artMethod");
        artMethodField = r101;
        return r101;
    L6:
        return r100;
    }

    public static synchronized ICallback getCallback() {
        monitor-enter(AHook.class);
        ICallback r100 = sCallback;     // Catch: Throwable -> L9
        if (r100 != null) goto L7;
        r100 = new AnonymousClass1();     // Catch: Throwable -> L9
        updateCallback(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(AHook.class);
        return r100;
    L9:
        th = move-exception;
        throw th;
    }

    private static Method getDummyInvokeMethod() {
        Method r100 = dummyInvokeMethod;
        if (r100 != null) goto L12;
        dummyInvokeMethod = DoubleReflectUtils.getMethodInner(AHook.class, "dummyInvoke", new Class[0]);     // Catch: Throwable -> L6
    L9:
        return dummyInvokeMethod;
    L6:
        th = move-exception;
        getCallback().e(TAG, "getDummyInvokeMethod", th);
        goto L9
    L12:
        return r100;
    }

    private static Method getMethodInvoke() {
        Method r100 = invokeMethod;
        if (r100 != null) goto L12;
        invokeMethod = DoubleReflectUtils.getMethodInner(Method.class, AbsMethodDelegate.TAG_INVOKE, new Class[]{Object.class, Object[].class});     // Catch: Throwable -> L6
    L9:
        return invokeMethod;
    L6:
        th = move-exception;
        getCallback().e(TAG, "getMethodInvoke", th);
        goto L9
    L12:
        return r100;
    }

    private static Method getMethodInvokeFast() {
        Method r100 = invokeMethodFast;
        if (r100 != null) goto L12;
        invokeMethodFast = DoubleReflectUtils.getMethodInner(AHook.class, AbsMethodDelegate.TAG_INVOKE, new Class[]{Long.TYPE, String.class, Object.class, Object.class, Object[].class});     // Catch: Throwable -> L6
    L9:
        return invokeMethodFast;
    L6:
        th = move-exception;
        getCallback().e(TAG, "getMethodInvokeFast", th);
        goto L9
    L12:
        return r100;
    }

    public final void dummyInvoke() {
        Object.class.hashCode();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public static void assertHookMessageQueue() {
        MessageQueue r100 = Looper.myQueue();     // Catch: Throwable -> L4
        FindCatchBlockOpt.Util.printMethods("java.lang.Class", r100.getClass());     // Catch: Throwable -> L4
        FindCatchBlockOpt.Util.printMethods("android.os.MessageQueue", r100);     // Catch: Throwable -> L4
        callOrigin(OriginMethodKey.KEY_REMOVE_SYNC_BARRIER, r100, new Object[]{0});     // Catch: Throwable -> L4
        return;
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

    private static long artMethodOf(Executable r100) {
        Field r101 = getArtMethodField();
        r101.setAccessible(true);
        return ((Long) r101.get(r100)).longValue();
    L5:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static void assertHookMessageQueue(boolean r100) {
        if (r100 == false) goto L5;
        new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass3(), 1000);
        return;
    }

    private static long[] getArtMethods(Method[] r100) {
        int r101 = 0;
        if (r100 == null) goto L11;
        if (r100.length == 0) goto L11;
        int r102 = r100.length;
        long[] r103 = new long[r102];
    L8:
        if (r101 >= r102) goto L13;
        r103[r101] = artMethodOf(r100[r101]);
        r101 = r101 + 1;
        goto L8
    L13:
        return r103;
    L11:
        return new long[0];
    }

    private static String getKey(Method r100) {
        return r100.getDeclaringClass().getName() + "." + r100.getName() + FindCatchBlockOpt.Util.getMethodSignature(r100.getParameterTypes(), r100.getReturnType());
    }

    private static char getShorty(Class r100) {
        if (r100.isPrimitive() == true) goto L5;
        return Matrix.MATRIX_TYPE_RANDOM_LT;
    L5:
        if (r100 != Integer.TYPE) goto L8;
        return 'I';
    L8:
        if (r100 != Byte.TYPE) goto L11;
        return 'B';
    L11:
        if (r100 != Long.TYPE) goto L14;
        return 'J';
    L14:
        if (r100 != Float.TYPE) goto L17;
        return 'F';
    L17:
        if (r100 != Double.TYPE) goto L20;
        return 'D';
    L20:
        if (r100 != Short.TYPE) goto L23;
        return 'S';
    L23:
        if (r100 != Character.TYPE) goto L26;
        return 'C';
    L26:
        if (r100 != Boolean.TYPE) goto L29;
        return Matrix.MATRIX_TYPE_ZERO;
    L29:
        if (r100 != Void.TYPE) goto L32;
        return 'V';
    L32:
        throw new InternalError();
    }

    public static void mockMessageQueueCrash(boolean r100) {
        if (r100 == false) goto L5;
        new Handler(Looper.getMainLooper()).postDelayed(new AnonymousClass2(), 2000);
        return;
    }

    private static synchronized void updateCallback(ICallback r100) {
        monitor-enter(AHook.class);
        sCallback = r100;     // Catch: Throwable -> L7
        monitor-exit(AHook.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static String getKey(Constructor r100) {
        return r100.getName() + FindCatchBlockOpt.Util.getMethodSignature(r100.getParameterTypes(), Void.TYPE);
    }

    private static char[] getShorty(Executable r100) {
        Class<?>[] r101 = r100.getParameterTypes();
        char[] r102 = new char[r101.length + 1];
        int r103 = 0;
        if ((r100 instanceof Method) == false) goto L5;
        r102[0] = getShorty(((Method) r100).getReturnType());
    L7:
        if (r103 >= r101.length) goto L9;
        Class<?> r104 = r101[r103];
        r103 = r103 + 1;
        r102[r103] = getShorty(r104);
        goto L7
    L9:
        return r102;
    L5:
        r102[0] = 'V';
        goto L7
    }

    public static void addHookConstructor(Constructor r100, Executable r101) throws IllegalAccessException {
        if (sInit.get() == true) goto L7;
        getCallback().e(TAG, "addHookConstructor() not init");
        return;
    L7:
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        String r102 = getKey(r100);
        getCallback().d(TAG, "addHookConstructor() key=[" + r102 + "]");
        sOriginConstructor.put(r102, r100);
        hookConstructor(r100, r101, new Method[0]);
        getCallback().d(TAG, "addHookConstructor() end");
        return;
    L12:
        getCallback().e(TAG, "addHookConstructor() origin=[" + r100 + "], proxy=[" + r101 + "]");
    }

    public static Object callOrigin(String r110, Object r111, Object... r112) throws Throwable {
        HookItem r100 = sOriginMethod.get(r110);
        if (r100 == null) goto L5;
        Method r101 = r100.origin;
    L6:
        if (r101 != null) goto L8;
        Constructor r102 = sOriginConstructor.get(r110);
    L9:
        if (r101 == null) goto L11;
        Class<?> r113 = r101.getDeclaringClass();
    L12:
        if (r101 == null) goto L14;
        Executable r114 = r101;
    L15:
        long r115 = artMethodOf(r114);
        if (r100 != null) goto L18;
    L20:
        boolean r103 = false;
    L50:
        nSetTLSIgnoreFlag(r115, r113, r103);     // Catch: Throwable -> L38
        if (r101 == null) goto L35;
        r101.setAccessible(true);     // Catch: Throwable -> L38
        char[] r104 = getShorty(r101);     // Catch: Throwable -> L38
        getCallback().e(TAG, "callOrigin method=" + r101 + ", obj=" + r111 + ", args=" + Arrays.toString(r112) + ", shorty=" + Arrays.toString(r104));     // Catch: Throwable -> L38
        if (Modifier.isStatic(r101.getModifiers()) == false) goto L27;
    L32:
        getCallback().e(TAG, "callOrigin by reflect " + r101);     // Catch: Throwable -> L38
        Object r105 = r101.invoke(r111, r112);     // Catch: Throwable -> L38
        nClearTLSIgnoreFlag(r115, r113, r103);
        return r105;
    L27:
        if (Modifier.isFinal(r101.getDeclaringClass().getModifiers()) == true) goto L32;
        Object r106 = getDummyInvokeMethod().invoke(new Object[]{r101, r111, new String(r104)}, r112);     // Catch: Throwable -> L38
        nClearTLSIgnoreFlag(r115, r113, r103);
        return r106;
    L35:
        r102.setAccessible(true);     // Catch: Throwable -> L38
        getCallback().e(TAG, "callOrigin c=" + r102 + ", args=" + Arrays.toString(r112));     // Catch: Throwable -> L38
        Object r107 = getDummyInvokeMethod().invoke(new Object[]{r102, r111}, r112);     // Catch: Throwable -> L38
        nClearTLSIgnoreFlag(r115, r113, r103);
        return r107;
    L38:
        th = move-exception;
        getCallback().e(TAG, "callOrigin e", th);     // Catch: Throwable -> L45
        Throwable r108 = th.getCause();     // Catch: Throwable -> L45
        getCallback().e(TAG, "callOrigin t", r108);     // Catch: Throwable -> L45
        nClearTLSIgnoreFlag(r115, r113, r103);
        if (r108 != null) goto L44;
        return null;
    L44:
        throw r108;
    L45:
        th = move-exception;
        nClearTLSIgnoreFlag(r115, r113, r103);
        throw th;
    L18:
        if (r100.unHookVTableWhenInvokeOrigin == false) goto L20;
        r103 = true;
        goto L50
    L14:
        r114 = r102;
        goto L15
    L11:
        r113 = r102.getDeclaringClass();
        goto L12
    L8:
        r102 = null;
        goto L9
    L5:
        r101 = null;
        goto L6
    }

    private static void hook1(Method r100, Method r101, Method... r102) throws IllegalAccessException {
        getCallback().d(TAG, "hook1() called with: origin = [" + r100 + "], proxy = [" + r101 + "]");
        if (SysOptimizer.loadOptimizerLibrary(null) == false) goto L10;
        ShadowHook.access$000();
        ShadowHook.access$100();
        int r103 = ShadowHook.Mode.SHARED.getValue();
        ShadowHook.b r104 = new ShadowHook.b();
        r104.f270294a = r103;
        r104.f270295b = true;
        r104.f270296c = false;
        r104.f270297d = false;
        ShadowHook.init(r104);
        if (getArtMethodField() != null) goto L8;
        getCallback().e(TAG, "getArtMethodField() == null");
        return;
    L8:
        long r105 = artMethodOf(r100);
        long r106 = artMethodOf(r101);
        getCallback().d(TAG, "hook1() called with: originArtMethod = [" + Long.toHexString(r105) + "], proxyArtMethod = [" + Long.toHexString(r106) + "]");
        reservedForJniOffset();
        nStart(r105, r106, getArtMethods(r102));
        return;
    }

    private static void hookConstructor(Constructor r100, Executable r101, Method... r102) throws IllegalAccessException {
        getCallback().d(TAG, "hookConstructor() called with: origin = [" + r100 + "], proxy = [" + r101 + "]");
        if (SysOptimizer.loadOptimizerLibrary(null) == false) goto L10;
        ShadowHook.access$000();
        ShadowHook.access$100();
        int r103 = ShadowHook.Mode.SHARED.getValue();
        ShadowHook.b r104 = new ShadowHook.b();
        r104.f270294a = r103;
        r104.f270295b = true;
        r104.f270296c = false;
        r104.f270297d = false;
        ShadowHook.init(r104);
        if (getArtMethodField() != null) goto L8;
        getCallback().e(TAG, "getArtMethodField() == null");
        return;
    L8:
        long r105 = artMethodOf(r100);
        long r106 = artMethodOf(r101);
        getCallback().d(TAG, "hookConstructor() called with: originArtMethod = [" + Long.toHexString(r105) + "], proxyArtMethod = [" + Long.toHexString(r106) + "]");
        reservedForJniOffset();
        nStart(r105, r106, getArtMethods(r102));
        return;
    }

    public static void addHook(Method r100, Method r101, boolean r102, Method... r103) throws IllegalAccessException {
        if (sInit.get() == true) goto L7;
        getCallback().e(TAG, "addHook() not init");
        return;
    L7:
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        String r104 = getKey(r100);
        getCallback().d(TAG, "addHook() key=[" + r104 + "]");
        HookItem r105 = new HookItem(null);
        r105.origin = r100;
        r105.proxy = r101;
        r105.unHookVTableWhenInvokeOrigin = r102;
        sOriginMethod.put(r104, r105);
        hook1(r100, r101, r103);
        getCallback().d(TAG, "addHook() end");
        return;
    L12:
        getCallback().e(TAG, "addHook() origin=[" + r100 + "], proxy=[" + r101 + "]");
    }

    public static void init(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, ICallback r105) throws NoSuchMethodException, IllegalAccessException {
        throw new RuntimeException("AHook not support In Doubao");
    }
}
