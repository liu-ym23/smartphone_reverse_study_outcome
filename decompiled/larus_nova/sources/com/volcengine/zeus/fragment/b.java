package com.volcengine.zeus.fragment;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.volcengine.zeus.log.ZeusLogger;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f462702a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
    }

    public b(Fragment r100) {
        this.f462702a = r100;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostSaveInstanceState(Activity r100, Bundle r101) {
        if (this.f462702a.getActivity() == r100) goto L6;
        return;
    L6:
        if (r100.getClassLoader() != this.f462702a.getClass().getClassLoader()) goto L15;
        return;
    L15:
        Object r102 = r101.get("androidx.lifecycle.BundlableSavedStateRegistry.key");     // Catch: Exception -> L14
        if (r102 == null) goto L12;
        ((Bundle) r102).remove("android:support:fragments");     // Catch: Exception -> L14
    L12:
        r101.remove("android:support:fragments");     // Catch: Exception -> L14
        ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "clear fragment, Activity:" + r100);     // Catch: Exception -> L14
        return;
    }
}
