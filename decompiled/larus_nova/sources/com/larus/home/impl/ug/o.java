package com.larus.home.impl.ug;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class o implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f346335a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
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

    public o(UGReturnWindowManager r100) {
        Intrinsics.checkNotNullParameter(r100, "floatingWindow");
        this.f346335a = r100;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f346335a.a(r100);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f346335a.b(r100);
    }
}
