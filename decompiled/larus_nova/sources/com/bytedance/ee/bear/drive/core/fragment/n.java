package com.bytedance.ee.bear.drive.core.fragment;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class n implements ComponentCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f224253a;

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    public n(k r100) {
        this.f224253a = r100;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        this.f224253a.i(r100);
    }
}
