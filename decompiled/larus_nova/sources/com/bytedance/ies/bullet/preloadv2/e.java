package com.bytedance.ies.bullet.preloadv2;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements ComponentCallbacks {
    public e() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        boolean r100 = PreloadV2.f247628a;
        PreloadV2.e(true, "onLowMemory");
    }
}
