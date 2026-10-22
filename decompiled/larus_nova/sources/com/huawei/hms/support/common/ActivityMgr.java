package com.huawei.hms.support.common;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes23.dex */
public final class ActivityMgr implements Application.ActivityLifecycleCallbacks {
    public static final ActivityMgr INST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f277749a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r100) {
    }

    static {
        INST = new ActivityMgr();
    }

    public Activity getCurrentActivity() {
        if (this.f277749a != null) goto L6;
        HMSLog.i("ActivityMgr", "mCurrentActivity is " + this.f277749a);
        return null;
    L6:
        HMSLog.i("ActivityMgr", "mCurrentActivity.get() is " + this.f277749a.get());
        return this.f277749a.get();
    }

    private ActivityMgr() {
    }

    private static String a(Object r100) {
        if (r100 != null) goto L5;
        return "null";
    L5:
        return r100.getClass().getName() + '@' + Integer.toHexString(r100.hashCode());
    }

    public void init(Application r100) {
        HMSLog.d("ActivityMgr", "init");
        if (r100 != null) goto L6;
        HMSLog.w("ActivityMgr", "init failed for app is null");
        return;
    L6:
        ActivityMgr r101 = INST;
        r100.unregisterActivityLifecycleCallbacks(r101);
        r100.registerActivityLifecycleCallbacks(r101);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r100) {
        HMSLog.d("ActivityMgr", "onResumed:" + a(r100));
        this.f277749a = new WeakReference(r100);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r100) {
        HMSLog.d("ActivityMgr", "onStarted:" + a(r100));
        this.f277749a = new WeakReference(r100);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r100, Bundle r101) {
        HMSLog.d("ActivityMgr", "onCreated:" + a(r100));
        this.f277749a = new WeakReference(r100);
    }
}
