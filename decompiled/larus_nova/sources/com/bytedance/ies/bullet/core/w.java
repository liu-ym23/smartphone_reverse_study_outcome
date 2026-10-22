package com.bytedance.ies.bullet.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class w implements Application.ActivityLifecycleCallbacks {
    public w() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        LinkedList<Activity> r101 = x.f246573c;     // Catch: Throwable -> L8
        if (r101.contains(r100) == false) goto L6;
        r101.remove(r100);     // Catch: Throwable -> L8
    L6:
        ExecutorService r102 = BulletLogger.f247763a;     // Catch: Throwable -> L8
        BulletLogger.k(r100.getClass().getSimpleName().concat(" onActivityDestroyed"), null, null, 6);     // Catch: Throwable -> L8
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        LinkedList<Activity> r101 = x.f246573c;     // Catch: Throwable -> L8
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);     // Catch: Throwable -> L8
    L6:
        ExecutorService r102 = BulletLogger.f247763a;     // Catch: Throwable -> L8
        BulletLogger.k(r100.getClass().getSimpleName().concat(" onActivityPaused"), null, null, 6);     // Catch: Throwable -> L8
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        LinkedList<Activity> r101 = x.f246573c;     // Catch: Throwable -> L8
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);     // Catch: Throwable -> L8
    L6:
        ExecutorService r102 = BulletLogger.f247763a;     // Catch: Throwable -> L8
        BulletLogger.k(r100.getClass().getSimpleName().concat(" onActivityResumed"), null, null, 6);     // Catch: Throwable -> L8
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        LinkedList<Activity> r101 = x.f246573c;     // Catch: Throwable -> L8
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);     // Catch: Throwable -> L8
    L6:
        ExecutorService r102 = BulletLogger.f247763a;     // Catch: Throwable -> L8
        BulletLogger.k(r100.getClass().getSimpleName().concat(" onActivityStarted"), null, null, 6);     // Catch: Throwable -> L8
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        LinkedList<Activity> r101 = x.f246573c;     // Catch: Throwable -> L8
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);     // Catch: Throwable -> L8
    L6:
        ExecutorService r102 = BulletLogger.f247763a;     // Catch: Throwable -> L8
        BulletLogger.k(r100.getClass().getSimpleName().concat(" onActivityStopped"), null, null, 6);     // Catch: Throwable -> L8
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        LinkedList<Activity> r102 = x.f246573c;     // Catch: Throwable -> L9
        if (r102.contains(r100) == false) goto L6;
        r102.remove(r100);     // Catch: Throwable -> L9
    L6:
        r102.add(r100);     // Catch: Throwable -> L9
    L7:
        ExecutorService r103 = BulletLogger.f247763a;
        BulletLogger.k(r100.getClass().getSimpleName().concat(" onActivityCreated"), null, null, 6);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "outState");
        x r102 = x.f246571a;     // Catch: Throwable -> L5
        ExecutorService r103 = BulletLogger.f247763a;     // Catch: Throwable -> L5
        BulletLogger.k(r100.getClass().getSimpleName().concat(" onActivitySaveInstanceState"), null, null, 6);     // Catch: Throwable -> L5
        return;
    }
}
