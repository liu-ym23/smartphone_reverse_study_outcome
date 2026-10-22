package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes19.dex */
public class LifeCycleMonitor implements Application.ActivityLifecycleCallbacks {
    private static final int ENTER_BACKGROUND_DELAY_TIME = 30000;
    private static boolean mAppAlive;
    private static WeakHandler sHandler;
    private AppStateListener mListener;
    private Runnable mRunnable;

    public interface AppStateListener {
        void onEnterToBackground();

        void onEnterToForeground();
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static Activity getActivity() {
        Class r100 = INVOKESTATIC_com_bytedance_frameworks_baselib_network_http_ok3_impl_httpdns_util_LifeCycleMonitor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread");     // Catch: Throwable -> L14
        Object r101 = r100.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L14
        Field r102 = r100.getDeclaredField("mActivities");     // Catch: Throwable -> L14
        r102.setAccessible(true);     // Catch: Throwable -> L14
        Map r103 = (Map) r102.get(r101);     // Catch: Throwable -> L14
        if (r103 != null) goto L6;
        return null;
    L6:
        Iterator r104 = r103.values().iterator();     // Catch: Throwable -> L14
    L8:
        if (r104.hasNext() == false) goto L13;
        Object r105 = r104.next();     // Catch: Throwable -> L14
        Class<?> r106 = r105.getClass();     // Catch: Throwable -> L14
        Field r107 = r106.getDeclaredField("paused");     // Catch: Throwable -> L14
        r107.setAccessible(true);     // Catch: Throwable -> L14
        if (r107.getBoolean(r105) == true) goto L8;
        Field r108 = r106.getDeclaredField("activity");     // Catch: Throwable -> L14
        r108.setAccessible(true);     // Catch: Throwable -> L14
        return (Activity) r108.get(r105);
    L13:
        return null;
    L14:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r100) {
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

    static {
        sHandler = new WeakHandler(Looper.getMainLooper(), new AnonymousClass1());
    }

    public LifeCycleMonitor() {
        this.mRunnable = new AnonymousClass2(this);
        if (getActivity() == null) goto L6;
        mAppAlive = true;
        return;
    }

    public static /* synthetic */ boolean access$000() {
        return mAppAlive;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_frameworks_baselib_network_http_ok3_impl_httpdns_util_LifeCycleMonitor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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

    public static /* synthetic */ boolean access$002(boolean r100) {
        mAppAlive = r100;
        return r100;
    }

    public static /* synthetic */ AppStateListener access$100(LifeCycleMonitor r100) {
        return r100.mListener;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r100) {
        if (mAppAlive == false) goto L6;
        sHandler.postDelayed(this.mRunnable, 30000);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r100) {
        if (mAppAlive == true) goto L7;
        mAppAlive = true;
        AppStateListener r101 = this.mListener;
        if (r101 == null) goto L7;
        r101.onEnterToForeground();
    L7:
        sHandler.removeCallbacks(this.mRunnable);
    }

    public void setAppStateChangedListener(AppStateListener r100) {
        this.mListener = r100;
    }
}
