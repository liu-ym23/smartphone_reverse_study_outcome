package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes23.dex */
public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private static final BackgroundDetector f274471zza = null;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    private final AtomicBoolean f274472zzb;
    private final AtomicBoolean zzc;
    private final ArrayList zzd;
    private boolean zze;

    public interface BackgroundStateChangeListener {
        void onBackgroundStateChanged(boolean r100);
    }

    public static BackgroundDetector getInstance() {
        return f274471zza;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
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

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    static {
        f274471zza = new BackgroundDetector();
    }

    public boolean isInBackground() {
        return this.f274472zzb.get();
    }

    private BackgroundDetector() {
        this.f274472zzb = new AtomicBoolean();
        this.zzc = new AtomicBoolean();
        this.zzd = new ArrayList();
        this.zze = false;
    }

    public static void initialize(Application r100) {
        BackgroundDetector r101 = f274471zza;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (r101.zze == true) goto L7;
        r100.registerActivityLifecycleCallbacks(r101);     // Catch: Throwable -> L9
        r100.registerComponentCallbacks(r101);     // Catch: Throwable -> L9
        r101.zze = true;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    private final void zza(boolean r100) {
        BackgroundDetector r101 = f274471zza;
        monitor-enter(r101);
        Iterator r102 = this.zzd.iterator();     // Catch: Throwable -> L10
    L6:
        if (r102.hasNext() == false) goto L8;
        ((BackgroundStateChangeListener) r102.next()).onBackgroundStateChanged(r100);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void addListener(BackgroundStateChangeListener r100) {
        BackgroundDetector r101 = f274471zza;
        monitor-enter(r101);
        this.zzd.add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        AtomicBoolean r101 = this.zzc;
        boolean r102 = this.f274472zzb.compareAndSet(true, false);
        r101.set(true);
        if (r102 == false) goto L6;
        zza(false);
        return;
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int r100) {
        if (r100 == 20) goto L5;
        return;
    L5:
        if (this.f274472zzb.compareAndSet(false, true) == false) goto L9;
        this.zzc.set(true);
        zza(true);
        return;
    }

    public boolean readCurrentStateIfPossible(boolean r100) {
        if (this.zzc.get() == true) goto L13;
        if (PlatformVersion.isAtLeastJellyBean() == false) goto L11;
        ActivityManager.RunningAppProcessInfo r101 = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(r101);
        if (this.zzc.getAndSet(true) == true) goto L13;
        if (r101.importance <= 100) goto L13;
        this.f274472zzb.set(true);
        goto L13
    L11:
        return r100;
    L13:
        return isInBackground();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        AtomicBoolean r102 = this.zzc;
        boolean r103 = this.f274472zzb.compareAndSet(true, false);
        r102.set(true);
        if (r103 == false) goto L6;
        zza(false);
        return;
    }
}
