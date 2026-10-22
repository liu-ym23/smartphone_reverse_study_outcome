package com.ss.android.lark.base.embedded;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.os.Bundle;
import androidx.window.embedding.ActivityRule;
import androidx.window.embedding.EmbeddingRule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ComponentName f409747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EmbeddingRule f409748b;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r100, Bundle r101) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r100) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r100) {
        if (r100.getComponentName().equals(this.f409747a) == false) goto L10;
        LKSplitController r101 = LKSplitController.b();
        EmbeddingRule r102 = this.f409748b;
        Intrinsics.checkNotNullParameter(r102, com.heytap.mcssdk.constant.b.f276366p);
        if (LKSplitController.f409741d == false) goto L8;
        r101.c().unregisterRule(r102);
    L8:
        r100.getApplication().unregisterActivityLifecycleCallbacks(this);
        return;
    }

    public c(ComponentName r100, ActivityRule r101) {
        this.f409747a = r100;
        this.f409748b = r101;
    }
}
