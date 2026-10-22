package com.larus.init.task.obric;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.init.task.x0;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Application f351443a;

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
    public final void onActivityResumed(Activity r100) {
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    public a(Application r100) {
        this.f351443a = r100;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        FLogger.f375446a.i("OfficeSdkLazyInitLifecycleRegistrar", "onActivityPreCreated: trigger lazy init, activity=".concat(r100.getClass().getName()));
        x0.b();     // Catch: Throwable -> L12
        AtomicBoolean r102 = b.f351444a;
        this.f351443a.unregisterActivityLifecycleCallbacks(this);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        FLogger.f375446a.e("OfficeSdkLazyInitLifecycleRegistrar", "unregister activity lifecycle callback failed", e);
        if (AppHost.f326268a.isTestChannel() == true) goto L11;
        return;
    L11:
        throw e;
    L12:
        th = move-exception;
        AtomicBoolean r103 = b.f351444a;
        this.f351443a.unregisterActivityLifecycleCallbacks(this);     // Catch: Exception -> L16
    L19:
        throw th;
    L16:
        e = move-exception;
        FLogger.f375446a.e("OfficeSdkLazyInitLifecycleRegistrar", "unregister activity lifecycle callback failed", e);
        if (AppHost.f326268a.isTestChannel() == false) goto L19;
        throw e;
    }
}
