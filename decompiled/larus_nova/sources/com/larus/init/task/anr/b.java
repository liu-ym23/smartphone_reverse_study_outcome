package com.larus.init.task.anr;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Process;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InitAnrOptTask f351172a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    public b(InitAnrOptTask r100) {
        this.f351172a = r100;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        FLogger.f375446a.i(this.f351172a.f351155a, "onActivityResumed");
        int r101 = f.f351176a;
        Application r102 = AppHost.f326268a.getApplication();
        Intrinsics.checkNotNullParameter(r102, "base");
        ht9.a.f487150a.getClass();
        if ((ht9.a.b(r102) & 4) == 0) goto L11;
        Process.setThreadPriority(Process.myPid(), -20);     // Catch: Throwable -> L6
        Process.getThreadPriority(Process.myPid());     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.toString();
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        FLogger.f375446a.i(this.f351172a.f351155a, "onActivityStopped");
        int r101 = f.f351176a;
        Application r102 = AppHost.f326268a.getApplication();
        Intrinsics.checkNotNullParameter(r102, "base");
        ht9.a.f487150a.getClass();
        if ((ht9.a.b(r102) & 8) == 0) goto L11;
        Process.setThreadPriority(Process.myPid(), -20);     // Catch: Throwable -> L6
        Process.getThreadPriority(Process.myPid());     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.toString();
        return;
    }
}
