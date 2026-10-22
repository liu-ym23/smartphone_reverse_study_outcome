package com.bytedance.applet.task;

import android.content.Context;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppLifecycleCallbacks;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l implements AppLifecycleCallbacks {
    public l() {
    }

    public final void onAppAttached(AppletApplication r2) {
        Intrinsics.checkNotNullParameter(r2, "app");
    }

    public final void onAppDestroyed(AppletApplication r2) {
        Intrinsics.checkNotNullParameter(r2, "app");
    }

    public final void onAppCreated(AppletApplication r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "app");
        Intrinsics.checkNotNullParameter(r3, "context");
    }

    public final void onAppDestroyView(AppletApplication r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "app");
        Intrinsics.checkNotNullParameter(r3, "context");
    }

    public final void onAppResumed(AppletApplication r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "app");
        Intrinsics.checkNotNullParameter(r3, "context");
    }

    public final void onAppStopped(AppletApplication r1, Context r2) {
        AppLifecycleCallbacks.a.a(r1, r2);
    }

    public final void onAppTaskBackground(AppletApplication r3, Context r4) {
        Intrinsics.checkNotNullParameter(r3, "app");
        Intrinsics.checkNotNullParameter(r4, "context");
        BaseMediaControlTask r5 = b.b;
        if (r5 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r5.a, r3.getAppId()) == false) goto L9;
        FLogger.a.i("MediaControlTaskManager", "onAppStopped: appId = " + r5.a);
        r5.g(true);
        return;
    }

    public final void onAppTaskForeground(AppletApplication r3, Context r4) {
        Intrinsics.checkNotNullParameter(r3, "app");
        Intrinsics.checkNotNullParameter(r4, "context");
        BaseMediaControlTask r5 = b.b;
        if (r5 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r5.a, r3.getAppId()) == false) goto L9;
        FLogger.a.i("MediaControlTaskManager", "onAppResumed: appId = " + r5.a);
        r5.g(false);
        return;
    }
}
