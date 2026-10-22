package com.bytedance.applet.impl;

import android.content.Context;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppLifecycleCallbacks;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class MainlandAppletServiceImpl$registerAppLifecycleCallback$1 implements AppLifecycleCallbacks {
    public MainlandAppletServiceImpl$registerAppLifecycleCallback$1() {
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

    public final void onAppResumed(AppletApplication r7, Context r8) {
        Intrinsics.checkNotNullParameter(r7, "app");
        Intrinsics.checkNotNullParameter(r8, "context");
        String r9 = r7.getAppId();
        FLogger r10 = FLogger.a;
        r10.i("MainlandAppletServiceImpl", "onAppResumed: " + r9);
        if (r9.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r10.e("MainlandAppletServiceImpl", "onAppResumed: appId is empty");
        return;
    L9:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MainlandAppletServiceImpl$registerAppLifecycleCallback$1$onAppResumed$1(r9, null), 3, null);
        return;
    L5:
        r0 = false;
        goto L6
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
