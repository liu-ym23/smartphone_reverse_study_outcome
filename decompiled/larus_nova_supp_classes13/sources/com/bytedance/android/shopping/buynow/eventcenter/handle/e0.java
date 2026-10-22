package com.bytedance.android.shopping.buynow.eventcenter.handle;

import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e0 extends com.bytedance.kmp.ec.yata.event.common.b {
    public final BuyNowViewModel a;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        Map r6 = r5.q();
        if (r6 == null) goto L5;
        Object r7 = r6.get("flag");
    L7:
        if ((r7 instanceof Boolean) == true) goto L9;
        r7 = null;
    L9:
        Boolean r8 = (Boolean) r7;
        if (r8 == null) goto L12;
        boolean r9 = r8.booleanValue();
    L13:
        this.a.setSubmitStatusFlag(r9);
        com.bytedance.android.shopping.buynow.tracker.a r1 = this.a.getTracker();
        r1.getClass();
        r1.b("ies_ecommerce_fe_custom_log", MapsKt.mapOf(TuplesKt.to("type", "selfToggleSubmit_" + r9)));
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L12:
        r9 = true;
        goto L13
    L5:
        r7 = null;
        goto L7
    }

    public e0(AndroidYaTaInstance r2, BuyNowViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "yataInstance");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.a = r3;
    }
}
