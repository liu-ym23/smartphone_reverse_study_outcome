package com.bytedance.applet.impl;

import android.app.Activity;
import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.service.OnPermissionCallback;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i0 implements r4.i {
    public i0() {
    }

    public final boolean isPermissionAllGranted(Context r6, String... r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "permission");
        int r0 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if ((-1) == ContextCompat.checkSelfPermission(r6, r7[r2])) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public final void a(Activity r2, e3.d r3, String r4, String[] r5, final OnPermissionCallback r6) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "bridgeName");
        Intrinsics.checkNotNullParameter(r5, "permission");
        Intrinsics.checkNotNullParameter(r6, "callback");
        com.larus.platform.service.i2.b.m((FragmentActivity) r2, ArraysKt.toList(r5), new h0(r6));
    }
}
