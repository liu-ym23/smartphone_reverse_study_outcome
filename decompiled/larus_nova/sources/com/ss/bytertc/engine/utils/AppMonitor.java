package com.ss.bytertc.engine.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes40.dex */
public class AppMonitor implements Application.ActivityLifecycleCallbacks {
    public static final int BACKGROUND = 0;
    public static final int FOREGROUND = 1;
    private static volatile AppMonitor INSTANCE;
    private List<Callback> mCallbacks;

    public interface Callback {
        void callback(int r100);
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

    private AppMonitor(Context r100) {
        this.mCallbacks = new CopyOnWriteArrayList();
        registerLifecycle(r100);
    }

    public static AppMonitor get(Context r100) {
        if (INSTANCE != null) goto L15;
        monitor-enter(AppMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (INSTANCE != null) goto L9;
        INSTANCE = new AppMonitor(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(AppMonitor.class);     // Catch: Throwable -> L11
    L15:
        return INSTANCE;
    }

    private void registerLifecycle(Context r100) {
        ((Application) r100.getApplicationContext()).registerActivityLifecycleCallbacks(this);
    }

    public void notifyCallback(int r100) {
        Iterator<Callback> r101 = this.mCallbacks.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().callback(r100);
        goto L4
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r100) {
        notifyCallback(0);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r100) {
        notifyCallback(1);
    }

    public boolean release(Context r100) {
        if (r100 == null) goto L5;
        ((Application) r100.getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
        this.mCallbacks.clear();
        INSTANCE = null;
        return true;
    L5:
        return false;
    }

    public AppMonitor unRegister(Callback r100) {
        if (this.mCallbacks.contains(r100) == true) goto L5;
        return this;
    L5:
        this.mCallbacks.remove(r100);
        return this;
    }

    public AppMonitor register(Context r100, Callback r101) {
        if (this.mCallbacks.contains(r101) == true) goto L5;
        this.mCallbacks.add(r101);
    L5:
        notifyCallback(CommonUtils.isInForeground(r100) ? 1 : 0);
        return this;
    }
}
