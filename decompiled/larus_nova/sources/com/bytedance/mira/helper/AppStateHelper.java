package com.bytedance.mira.helper;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class AppStateHelper implements Application.ActivityLifecycleCallbacks {
    private static List<AppStateListener> appStateListeners;
    private static AppStateHelper sAppStateHelper;
    private int sActivityCount;

    public interface AppStateListener {
        void onBackground();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    static {
        appStateListeners = new ArrayList();
    }

    public static AppStateHelper getsInstance() {
        if (sAppStateHelper != null) goto L15;
        monitor-enter(AppStateHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sAppStateHelper != null) goto L9;
        sAppStateHelper = new AppStateHelper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AppStateHelper.class);     // Catch: Throwable -> L11
    L15:
        return sAppStateHelper;
    }

    public boolean isAppBackground() {
        if (this.sActivityCount != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private AppStateHelper() {
        this.sActivityCount = 0;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r100) {
        this.sActivityCount++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r100) {
        this.sActivityCount--;
        if (isAppBackground() == false) goto L14;
        List<AppStateListener> r101 = appStateListeners;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.size() <= 0) goto L21;
        Iterator<AppStateListener> r102 = appStateListeners.iterator();
    L10:
        if (r102.hasNext() == false) goto L22;
        AppStateListener r103 = r102.next();
        if (r103 == null) goto L10;
        r103.onBackground();
        goto L10
    L22:
        return;
    L21:
        return;
    }

    public void registerListener(AppStateListener r100) {
        appStateListeners.add(r100);
    }

    public void unregisterListener(AppStateListener r100) {
        appStateListeners.remove(r100);
    }
}
