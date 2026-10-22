package com.bytedance.common.wschannel;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;

/* JADX INFO: loaded from: classes3.dex */
class LifeCycleMonitor implements Application.ActivityLifecycleCallbacks {
    private static WeakHandler sHandler;
    private boolean mAppAlive;
    private AppStateListener mListener;
    private Runnable mRunnable;

    public interface AppStateListener {
        void onEnterToBackground();

        void onEnterToForeground();
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
        this.mAppAlive = false;
        this.mRunnable = new AnonymousClass2(this);
    }

    public static /* synthetic */ boolean access$000(LifeCycleMonitor r100) {
        return r100.mAppAlive;
    }

    public static /* synthetic */ AppStateListener access$100(LifeCycleMonitor r100) {
        return r100.mListener;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r100) {
        if (this.mAppAlive == false) goto L6;
        sHandler.postDelayed(this.mRunnable, 3000);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r100) {
        if (this.mAppAlive == true) goto L8;
        this.mAppAlive = true;
        AppStateListener r101 = this.mListener;
        if (r101 == null) goto L8;
        r101.onEnterToForeground();
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("WsChannelSdk", "onResume sAppAlive = " + this.mAppAlive);
    L10:
        sHandler.removeCallbacks(this.mRunnable);
    }

    public void setAppStateChangedListener(AppStateListener r100) {
        this.mListener = r100;
    }

    public static /* synthetic */ boolean access$002(LifeCycleMonitor r100, boolean r101) {
        r100.mAppAlive = r101;
        return r101;
    }
}
