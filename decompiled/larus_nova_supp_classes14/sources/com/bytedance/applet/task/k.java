package com.bytedance.applet.task;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.applet.view.AppletActivity;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k implements Application.ActivityLifecycleCallbacks {
    public k() {
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
    public final void onActivityResumed(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        BaseMediaControlTask r0 = b.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r4 instanceof AppletActivity) == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(((AppletActivity) r4).getAppId(), r0.a) == false) goto L12;
        FLogger.a.i("MediaControlTaskManager", "onActivityResumed: appId = " + r0.a);
        r0.g(false);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        BaseMediaControlTask r0 = b.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r4 instanceof AppletActivity) == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(((AppletActivity) r4).getAppId(), r0.a) == false) goto L12;
        FLogger.a.i("MediaControlTaskManager", "onActivityStopped: appId = " + r0.a);
        r0.g(true);
        return;
    }
}
