package com.bytedance.ee.bear.drive.core.fragment;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n implements ComponentCallbacks {
    public final /* synthetic */ k a;

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    public n(k r1) {
        this.a = r1;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        this.a.i(r2);
    }
}
