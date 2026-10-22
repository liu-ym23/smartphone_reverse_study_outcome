package com.bytedance.salamander.anniex;

import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class t2 {
    public static final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        EventCenter.unregisterJsEventSubscriber(r100, (JsEventSubscriber) r101);     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter("Success", "msg");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        String r102 = e.getMessage();
        if (r102 != null) goto L9;
        r102 = CheckStatus.FAIL;
    L9:
        Intrinsics.checkNotNullParameter(r102, "msg");
    }
}
