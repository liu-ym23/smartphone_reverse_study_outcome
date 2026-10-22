package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kk.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallDeliveryLifecycleGeneralCallback implements Application.ActivityLifecycleCallbacks {
    public Integer a;
    public boolean b;
    public boolean c;
    public final MallDeliveryLifecycleGeneralCallback$unregisterRunnable$1 d;
    public final String e;

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

    public MallDeliveryLifecycleGeneralCallback(String r4) {
        Intrinsics.checkNotNullParameter(r4, "schema");
        this.e = r4;
        MallDeliveryLifecycleGeneralCallback$unregisterRunnable$1 r5 = new MallDeliveryLifecycleGeneralCallback$unregisterRunnable$1(this);
        this.d = r5;
        t93.a.b().postDelayed(r5, 10000);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Integer r0 = this.a;
        int r3 = r2.hashCode();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.intValue() != r3) goto L9;
        this.d.run();
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(final Activity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Integer r0 = this.a;
        int r1 = r3.hashCode();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.intValue() != r1) goto L9;
        d.c(new AnonymousClass1(this, r3));
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        if (this.a != null) goto L6;
        this.a = Integer.valueOf(r1.hashCode());
        return;
    }
}
