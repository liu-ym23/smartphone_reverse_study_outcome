package com.bytedance.applet.impl;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.larus.bmhome.chat.j4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ r4.f.a a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public v(com.bytedance.ai.applet.login.d r1) {
        this.a = r1;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        if ((r2 instanceof j4) == false) goto L6;
        this.a.a(r2);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        if ((r2 instanceof j4) == false) goto L6;
        this.a.onPaused(r2);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        if ((r2 instanceof j4) == false) goto L6;
        this.a.onResumed(r2);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        if ((r2 instanceof j4) == false) goto L6;
        this.a.onStopped(r2);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        if ((r1 instanceof j4) == false) goto L6;
        this.a.onCreated(r1);
        return;
    }
}
