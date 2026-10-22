package com.bytedance.upc.common.activity;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.upc.common.thread.ThreadPlus;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ActivityLifeObserver implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f272458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f272459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f272460c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f272461d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ActivityLifeObserver f272462e = null;

    public ActivityLifeObserver() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    static {
        f272462e = new ActivityLifeObserver();
        f272459b = true;
        f272460c = LazyKt.lazy(ActivityLifeObserver$mAppEnterBackgroundObList$2.INSTANCE);
        f272461d = LazyKt.lazy(ActivityLifeObserver$mActivityRecord$2.INSTANCE);
    }

    public final WeakReference<Activity> getActivity(String r100) {
        return (WeakReference) ((Map) f272461d.getValue()).get(r100);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        ((Map) f272461d.getValue()).remove(r100.getPackageName() + "_" + r100.getClass().getName());     // Catch: Throwable -> L4
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        new WeakReference(r100);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        ((Map) f272461d.getValue()).put(r100.getPackageName() + "_" + r100.getClass().getName(), new WeakReference(r100));     // Catch: Throwable -> L4
    L5:
        f272458a++;
        if (f272459b == true) goto L11;
        f272459b = true;
        Lazy r101 = ThreadPlus.f272474a;
        ThreadPlus.a(ActivityLifeObserver$onAppEnterBackgroundOb$1.INSTANCE);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        int r101 = f272458a - 1;
        f272458a = r101;
        if (r101 > 0) goto L6;
        f272459b = false;
        Lazy r102 = ThreadPlus.f272474a;
        ThreadPlus.a(ActivityLifeObserver$onAppEnterBackgroundOb$1.INSTANCE);
        return;
    }
}
