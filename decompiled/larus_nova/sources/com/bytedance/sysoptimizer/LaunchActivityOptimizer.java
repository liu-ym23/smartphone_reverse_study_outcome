package com.bytedance.sysoptimizer;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.DeadSystemException;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class LaunchActivityOptimizer {
    private static boolean initialized;
    private static Activity mActivity;
    private static CopyOnWriteArrayList<ExceptionCatcher> sExceptionCatchers;

    public static class DeadException implements ExceptionCatcher {
        public DeadException() {
        }

        @Override // com.bytedance.sysoptimizer.ExceptionCatcher
        public boolean registerCondition() {
            return true;
        }

        @Override // com.bytedance.sysoptimizer.ExceptionCatcher
        public boolean analysis(Throwable r100) {
            if ((r100 instanceof InvocationTargetException) == false) goto L10;
            InvocationTargetException r101 = (InvocationTargetException) r100;
            if ((r101.getTargetException() instanceof DeadObjectException) == false) goto L7;
        L8:
            return true;
        L7:
            if ((r101.getTargetException() instanceof DeadSystemException) == true) goto L8;
            return false;
        L10:
            return false;
        }
    }

    public static class LaunchActivityLifecycleCallback implements Application.ActivityLifecycleCallbacks {
        public LaunchActivityLifecycleCallback() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r100) {
            if (Build.VERSION.SDK_INT <= 28) goto L5;
            return;
        L5:
            LaunchActivityOptimizer.access$002(null);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r100) {
            if (Build.VERSION.SDK_INT <= 28) goto L5;
            return;
        L5:
            LaunchActivityOptimizer.access$002(null);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r100) {
            if (Build.VERSION.SDK_INT <= 28) goto L5;
            return;
        L5:
            LaunchActivityOptimizer.access$002(r100);
            LaunchActivityOptimizer.setStartedActivity(r100);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r100, Bundle r101) {
            if (Build.VERSION.SDK_INT <= 28) goto L5;
            return;
        L5:
            LaunchActivityOptimizer.access$002(r100);
            LaunchActivityOptimizer.hookAMS(true);
        }
    }

    public LaunchActivityOptimizer() {
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        sExceptionCatchers = new CopyOnWriteArrayList();
    }

    public static /* synthetic */ Activity access$000() {
        return mActivity;
    }

    public static /* synthetic */ CopyOnWriteArrayList access$100() {
        return sExceptionCatchers;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_sysoptimizer_LaunchActivityOptimizer_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
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

    public static /* synthetic */ Activity access$002(Activity r100) {
        mActivity = r100;
        return r100;
    }

    public static /* synthetic */ Throwable access$200(Throwable r100) {
        return getSafeThrowable(r100);
    }

    private static Throwable getSafeThrowable(Throwable r100) {
        StackTraceElement[] r101 = r100.getStackTrace();     // Catch: Throwable -> L40
        if ((r100 instanceof InvocationTargetException) == false) goto L9;
        InvocationTargetException r102 = (InvocationTargetException) r100;     // Catch: Throwable -> L40
        if (r102.getTargetException() == null) goto L7;
        r100 = r102.getTargetException();     // Catch: Throwable -> L40
        r101 = r100.getStackTrace();     // Catch: Throwable -> L40
    L15:
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L40
        int r104 = 0;
        int r105 = 0;
    L17:
        if (r105 >= r101.length) goto L33;
        StackTraceElement r106 = r101[r105];     // Catch: Throwable -> L40
        if (r106 == null) goto L31;
        String r107 = r106.getClassName();     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r107) == false) goto L24;
    L30:
        r103.add(r106);     // Catch: Throwable -> L40
        goto L31
    L24:
        if (r107.contains("com.ss.android.ugc.aweme.utils.PreventServerSideCrashes") == true) goto L31;
        if (r107.equals(Proxy.class.getName()) == true) goto L31;
        if (r107.equals(Method.class.getName()) == false) goto L30;
    L31:
        r105 = r105 + 1;     // Catch: Throwable -> L40
        goto L17
    L33:
        if (r103.isEmpty() == false) goto L35;
        return r100;
    L35:
        int r108 = r103.size();     // Catch: Throwable -> L40
        StackTraceElement[] r109 = new StackTraceElement[r108];     // Catch: Throwable -> L40
    L36:
        if (r104 >= r108) goto L38;
        r109[r104] = (StackTraceElement) ListProtector.get(r103, r104);     // Catch: Throwable -> L40
        r104 = r104 + 1;     // Catch: Throwable -> L40
        goto L36
    L38:
        r100.setStackTrace(r109);     // Catch: Throwable -> L40
        goto L39
    L7:
        RuntimeException r110 = new RuntimeException();     // Catch: Throwable -> L40
    L14:
        r100 = r110;
        goto L15
    L9:
        if ((r100 instanceof UndeclaredThrowableException) == false) goto L15;
        UndeclaredThrowableException r111 = (UndeclaredThrowableException) r100;     // Catch: Throwable -> L40
        if (r111.getUndeclaredThrowable() == null) goto L13;
        r100 = r111.getUndeclaredThrowable();     // Catch: Throwable -> L40
        r101 = r100.getStackTrace();     // Catch: Throwable -> L40
        goto L15
    L13:
        r110 = new RuntimeException();     // Catch: Throwable -> L40
    L39:
        return r100;
    }

    public static void hookAMS(boolean r100) {
        if (initialized == false) goto L5;
        return;
    L5:
        initialized = true;
        HackHelper.init();
        int r101 = Build.VERSION.SDK_INT;
        if (r101 <= 28) goto L23;
        return;
    L23:
        if (r101 >= 26) goto L11;
        Field r102 = INVOKESTATIC_com_bytedance_sysoptimizer_LaunchActivityOptimizer_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityManagerNative").getDeclaredField("gDefault");     // Catch: Throwable -> L22
    L12:
        r102.setAccessible(true);     // Catch: Throwable -> L22
        Object r103 = r102.get(null);     // Catch: Throwable -> L22
        Field r104 = INVOKESTATIC_com_bytedance_sysoptimizer_LaunchActivityOptimizer_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.util.Singleton").getDeclaredField("mInstance");     // Catch: Throwable -> L22
        r104.setAccessible(true);     // Catch: Throwable -> L22
        final Object r105 = r104.get(r103);     // Catch: Throwable -> L22
        if (r105 != null) goto L15;
        return;
    L15:
        if (r100 == false) goto L20;
        Class r106 = INVOKESTATIC_com_bytedance_sysoptimizer_LaunchActivityOptimizer_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.IActivityManager");     // Catch: Throwable -> L22
        if (r106 != null) goto L19;
        return;
    L19:
        r104.set(r103, Proxy.newProxyInstance(ThreadMethodProxy.currentThread().getContextClassLoader(), new Class[]{r106}, new AnonymousClass1(r105)));     // Catch: Throwable -> L22
        return;
    L20:
        r104.set(r103, r103);     // Catch: Throwable -> L22
        return;
    L11:
        r102 = INVOKESTATIC_com_bytedance_sysoptimizer_LaunchActivityOptimizer_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");     // Catch: Throwable -> L22
        goto L12
    }

    public static void registerExceptionCatcher(ExceptionCatcher r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.registerCondition() == true) goto L7;
        return;
    L7:
        if (sExceptionCatchers.contains(r100) == true) goto L11;
        sExceptionCatchers.add(r100);
        return;
    }

    public static void setStartedActivity(Activity r100) {
        Field r101 = getDeclaredField(r100, "mStartedActivity");
        if (r101 != null) goto L8;
        return;
    L8:
        r101.setAccessible(true);     // Catch: Exception -> L7
        r101.set(r100, Boolean.TRUE);     // Catch: Exception -> L7
        return;
    }

    public static void unRegisterExceptionCatcher(ExceptionCatcher r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        sExceptionCatchers.remove(r100);
    }

    public static Field getDeclaredField(Object r100, String r101) {
        if (r100 != null) goto L5;
    L14:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        Class<?> r102 = r100.getClass();
    L9:
        if (r102 == Object.class) goto L14;
        Field r103 = HackHelper.getField(r102, r101);
        if (r103 != null) goto L12;
        r102 = r102.getSuperclass();
        goto L9
    L12:
        return r103;
    }
}
