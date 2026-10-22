package com.bytedance.applet.impl;

import android.content.Context;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppLifecycleCallbacks;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x1 implements AppLifecycleCallbacks {
    public x1() {
    }

    public final void onAppAttached(AppletApplication r2) {
        Intrinsics.checkNotNullParameter(r2, "app");
    }

    public final void onAppDestroyed(AppletApplication r3) {
        Intrinsics.checkNotNullParameter(r3, "app");
        String r4 = r3.getAppId();
        aw3.w r0 = aw3.w.a;
        aw3.w.w(r4, "app_destroyed");
        bw3.v.a.getClass();
        bw3.v.i(r4, "app_destroyed");
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

    public final void onAppTaskBackground(AppletApplication r2, Context r3) {
        Intrinsics.checkNotNullParameter(r2, "app");
        Intrinsics.checkNotNullParameter(r3, "context");
    }

    public final void onAppTaskForeground(AppletApplication r1, Context r2) {
        AppLifecycleCallbacks.a.b(r1, r2);
    }
}
