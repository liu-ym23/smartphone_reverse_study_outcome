package com.bytedance.salamander.anniex;

import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import com.bytedance.ies.xbridge.event.EventCenter;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class s2 {
    public static com.bytedance.salamander.bridge.a a(k4 r100, Function2 r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        com.bytedance.salamander.bridge.r r102 = new com.bytedance.salamander.bridge.r(r101);     // Catch: Exception -> L5
        EventCenter.registerJsEventSubscriber(r100.f268174a, r102, (long) r100.f268175b);     // Catch: Exception -> L5
        return new com.bytedance.salamander.bridge.a("Success", r102);
    L5:
        e = move-exception;
        String r103 = e.getMessage();
        if (r103 != null) goto L10;
        r103 = CheckStatus.FAIL;
    L10:
        return new com.bytedance.salamander.bridge.a(r103, null);
    }
}
