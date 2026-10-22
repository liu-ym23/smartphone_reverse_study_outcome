package com.bytedance.applet.impl;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.service.IHostLocationPermissionDepend;
import com.bytedance.ai.bridge.service.OnPermissionGrantCallback;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t implements IHostLocationPermissionDepend {
    public t() {
    }

    public final void requestPermission(Activity r2, e3.d r3, String r4, final OnPermissionGrantCallback r5) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "bridgeName");
        Intrinsics.checkNotNullParameter(r5, "callback");
        com.larus.platform.service.i2 r6 = com.larus.platform.service.i2.b;
        if ((r2 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r7 = (FragmentActivity) r2;
    L6:
        r6.a(r7, CollectionsKt.listOf(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}), new s(r5));
        return;
    L5:
        r7 = null;
        goto L6
    }
}
