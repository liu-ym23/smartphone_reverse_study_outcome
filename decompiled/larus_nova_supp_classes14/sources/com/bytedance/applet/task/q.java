package com.bytedance.applet.task;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.applet.view.AppletActivity;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q implements Application.ActivityLifecycleCallbacks {
    public q() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        if ((r3 instanceof AppletActivity) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(((AppletActivity) r3).getAppId(), "com.flow.locallife") == false) goto L9;
        FLogger.a.i("NavigationControlTask", "onActivityResumed: appId = com.flow.locallife");
        p.a(false);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        if ((r3 instanceof AppletActivity) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(((AppletActivity) r3).getAppId(), "com.flow.locallife") == false) goto L9;
        FLogger.a.i("NavigationControlTask", "onActivityStopped: appId = com.flow.locallife");
        p.a(true);
        return;
    }
}
