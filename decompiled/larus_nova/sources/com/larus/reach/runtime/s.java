package com.larus.reach.runtime;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class s implements Application.ActivityLifecycleCallbacks {
    public s() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        WeakReference<Activity> r101 = t.f367350b;
        if (r101 == null) goto L5;
        Activity r102 = r101.get();
    L6:
        if (r102 != r100) goto L9;
        AtomicBoolean r103 = t.f367349a;
        t.f367350b = null;
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        WeakReference<Activity> r101 = t.f367350b;
        if (r101 == null) goto L5;
        Activity r102 = r101.get();
    L6:
        if (r102 != r100) goto L9;
        AtomicBoolean r103 = t.f367349a;
        t.f367350b = null;
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        AtomicBoolean r101 = t.f367349a;
        t.f367350b = new WeakReference(r100);
    }
}
