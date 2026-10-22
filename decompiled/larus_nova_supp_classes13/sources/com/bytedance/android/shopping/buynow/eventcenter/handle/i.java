package com.bytedance.android.shopping.buynow.eventcenter.handle;

import android.content.Context;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends com.bytedance.kmp.ec.yata.event.common.a {

    public static final class a {
    }

    static {
    }

    public i(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "input");
        Intrinsics.checkNotNullParameter(r3, "chainNextCallback");
        Lazy r4 = BuyNowLog.a;
        BuyNowLog.a("selfDouyinVerify", "selfDouyinVerify starts input: " + r2.q());
        Object r5 = r2.p(Reflection.getOrCreateKotlinClass(Map.class), "sdk_params");
        if ((r5 instanceof Map) == true) goto L6;
        r5 = null;
    L6:
        if (((Map) r5) != null) goto L8;
        MapsKt.emptyMap();
    L8:
        boolean r6 = ECServiceManager.a;
        ((s83.g) ECServiceManager.c(s83.g.class)).h0();
    }
}
