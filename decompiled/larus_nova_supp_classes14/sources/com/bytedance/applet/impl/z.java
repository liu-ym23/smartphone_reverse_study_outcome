package com.bytedance.applet.impl;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class z implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ String a;
    public final /* synthetic */ Ref.ObjectRef<String> b;
    public final /* synthetic */ Ref.ObjectRef<Application.ActivityLifecycleCallbacks> c;
    public final /* synthetic */ Application d;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        if (Intrinsics.areEqual(r3.getClass().getName(), this.a) == false) goto L6;
        AppletHostMessageServiceImpl.n(this.c, this.b, this.d);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        if (Intrinsics.areEqual(r5.getClass().getName(), this.a) == true) goto L5;
        return;
    L5:
        Ref.ObjectRef<String> r0 = this.b;
        String r1 = (String) r0.element;
        if (r1 != null) goto L9;
        AppletHostMessageServiceImpl.n(this.c, r0, this.d);
        return;
    L9:
        AppletHostMessageServiceImpl.n(this.c, r0, this.d);
        FLogger.a.i("AppletHostMessageServiceImpl", "openChatAfterMainActivityResumed");
        SmartRouter.buildRoute(r5, r1).d();
    }

    public z(String r1, Ref.ObjectRef<String> r2, Ref.ObjectRef<Application.ActivityLifecycleCallbacks> r3, Application r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
