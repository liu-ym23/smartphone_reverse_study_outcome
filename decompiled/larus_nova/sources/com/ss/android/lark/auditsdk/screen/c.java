package com.ss.android.lark.auditsdk.screen;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f409575a;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "outState");
    }

    public c(b r100) {
        this.f409575a = r100;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        h r101 = this.f409575a.f409572g;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "activity");
        r101.b(r100);
        this.f409575a.f409573h.getClass();
        Intrinsics.checkNotNullParameter(r100, "activity");
        WeakReference<Activity> r102 = this.f409575a.f409571f;
        if (r102 == null) goto L5;
        Activity r103 = r102.get();
    L6:
        if (r103 != r100) goto L9;
        this.f409575a.f409571f = null;
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        b r101 = this.f409575a;
        r101.f409571f = new WeakReference(r100);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        b r101 = this.f409575a;
        r101.f409571f = new WeakReference(r100);
        this.f409575a.f409572g.a(r100);
        this.f409575a.f409573h.a(r100);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f409575a.f409572g.b(r100);
        this.f409575a.f409573h.getClass();
        Intrinsics.checkNotNullParameter(r100, "activity");
        WeakReference<Activity> r101 = this.f409575a.f409571f;
        if (r101 == null) goto L5;
        Activity r102 = r101.get();
    L6:
        if (r102 != r100) goto L9;
        this.f409575a.f409571f = null;
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
