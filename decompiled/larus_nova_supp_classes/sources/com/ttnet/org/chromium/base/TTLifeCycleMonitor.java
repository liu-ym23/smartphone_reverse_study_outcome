package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import com.bytedance.keva.KevaPreloadHolder;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class TTLifeCycleMonitor implements Application.ActivityLifecycleCallbacks {
    private static final int ENTER_BACKGROUND_DELAY_TIME = 30000;
    private static final String TAG = null;
    private static boolean mAppAlive;
    private static TTWeakHandler sHandler;
    private int mActivityCount;
    private final boolean mInitialAppInBackground;
    private AppStateListener mListener;
    private Runnable mRunnable;

    public static /* synthetic */ Class access$001(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static Activity getActivity() {
        Class r1 = INVOKESTATIC_com_ttnet_org_chromium_base_TTLifeCycleMonitor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread");     // Catch: Throwable -> L14
        Object r2 = r1.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L14
        Field r3 = r1.getDeclaredField("mActivities");     // Catch: Throwable -> L14
        r3.setAccessible(true);     // Catch: Throwable -> L14
        Map r4 = (Map) r3.get(r2);     // Catch: Throwable -> L14
        if (r4 != null) goto L6;
        return null;
    L6:
        Iterator r5 = r4.values().iterator();     // Catch: Throwable -> L14
    L8:
        if (r5.hasNext() == false) goto L13;
        Object r6 = r5.next();     // Catch: Throwable -> L14
        Class<?> r7 = r6.getClass();     // Catch: Throwable -> L14
        Field r8 = r7.getDeclaredField("paused");     // Catch: Throwable -> L14
        r8.setAccessible(true);     // Catch: Throwable -> L14
        if (r8.getBoolean(r6) == true) goto L8;
        Field r9 = r7.getDeclaredField("activity");     // Catch: Throwable -> L14
        r9.setAccessible(true);     // Catch: Throwable -> L14
        return (Activity) r9.get(r6);
    L13:
        return null;
    L14:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
    }

    static {
        TAG = "TTLifeCycleMonitor";
        sHandler = new TTWeakHandler(Looper.getMainLooper(), new AnonymousClass1());
    }

    private static List<Activity> getAllActivities() {
        ArrayList r0 = new ArrayList();
        Class r2 = INVOKESTATIC_com_ttnet_org_chromium_base_TTLifeCycleMonitor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread");     // Catch: Exception -> L12
        Method r3 = r2.getDeclaredMethod("currentActivityThread", new Class[0]);     // Catch: Exception -> L12
        r3.setAccessible(true);     // Catch: Exception -> L12
        Object r4 = r3.invoke(null, new Object[0]);     // Catch: Exception -> L12
        Field r5 = r2.getDeclaredField("mActivities");     // Catch: Exception -> L12
        r5.setAccessible(true);     // Catch: Exception -> L12
        Map r6 = (Map) r5.get(r4);     // Catch: Exception -> L12
        if (r6 != null) goto L6;
        return null;
    L6:
        Iterator r7 = r6.entrySet().iterator();     // Catch: Exception -> L12
    L8:
        if (r7.hasNext() == false) goto L11;
        Object r8 = ((Map.Entry) r7.next()).getValue();     // Catch: Exception -> L12
        Field r9 = r8.getClass().getDeclaredField("activity");     // Catch: Exception -> L12
        r9.setAccessible(true);     // Catch: Exception -> L12
        r0.add((Activity) r9.get(r8));     // Catch: Exception -> L12
        goto L8
    L11:
        return r0;
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public TTLifeCycleMonitor() {
        this.mRunnable = new AnonymousClass2(this);
        Activity r0 = getActivity();
        if (r0 != null) goto L5;
        boolean r3 = true;
    L6:
        this.mInitialAppInBackground = r3;
        if (r0 == null) goto L9;
        mAppAlive = true;
    L9:
        this.mActivityCount = 0;
        List<Activity> r1 = getAllActivities();
        if (r1 == null) goto L13;
        this.mActivityCount = r1.size();
        return;
    L13:
        return;
    L5:
        r3 = false;
        goto L6
    }

    public static /* synthetic */ boolean access$000() {
        return mAppAlive;
    }

    public boolean getInitialAppInBackground() {
        return this.mInitialAppInBackground;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ttnet_org_chromium_base_TTLifeCycleMonitor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$001(r3);     // Catch: Throwable -> L8
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
        Class r4 = access$001(r3);     // Catch: Throwable -> L17
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

    public static /* synthetic */ boolean access$002(boolean r0) {
        mAppAlive = r0;
        return r0;
    }

    public static /* synthetic */ AppStateListener access$100(TTLifeCycleMonitor r0) {
        return r0.mListener;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r4) {
        if (mAppAlive == false) goto L6;
        sHandler.postDelayed(this.mRunnable, KevaPreloadHolder.FIRST_FRAME_DELAYED_TIME);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r2) {
        if (mAppAlive == true) goto L7;
        mAppAlive = true;
        AppStateListener r3 = this.mListener;
        if (r3 == null) goto L7;
        r3.onEnterToForeground();
    L7:
        sHandler.removeCallbacks(this.mRunnable);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r1) {
        if (this.mActivityCount != 0) goto L7;
        AppStateListener r2 = this.mListener;
        if (r2 == null) goto L7;
        r2.onInstantEnterToForeground();
    L7:
        this.mActivityCount++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r1) {
        int r2 = this.mActivityCount - 1;
        this.mActivityCount = r2;
        if (r2 != 0) goto L8;
        AppStateListener r3 = this.mListener;
        if (r3 == null) goto L9;
        r3.onInstantEnterToBackground();
        return;
    L9:
        return;
    }

    public void setAppStateChangedListener(AppStateListener r1) {
        this.mListener = r1;
    }
}
