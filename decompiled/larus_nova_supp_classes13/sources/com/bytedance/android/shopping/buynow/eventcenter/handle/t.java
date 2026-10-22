package com.bytedance.android.shopping.buynow.eventcenter.handle;

import com.bytedance.android.ec.hybrid.list.util.ECHybridGsonUtil;
import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t extends com.bytedance.kmp.ec.yata.event.common.b {
    public final BuyNowFragment a;

    public static final class a {
    }

    static {
    }

    public t(BuyNowFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r9) {
        Intrinsics.checkNotNullParameter(r9, "input");
        BuyNowLog.d("selfQuitPage", "selfQuitPage starts");
        Object r1 = r9.q();
        if (r1 != null) goto L26;
        JSONObject r3 = null;
    L13:
        if (r3 == null) goto L15;
        String r2 = r3.optString("close_method");
    L16:
        String r4 = com.bytedance.android.shopping.extensions.k.j(r2);
        if (r4.length() != 0) goto L19;
        boolean r5 = true;
    L20:
        if (r5 == false) goto L23;
        BuyNowLog.d("selfQuitPage", "close_method is empty");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.a.W90().getTracker(), "selfQuitPage", "close_method is empty", r9);
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "close_method is empty", null, null, 57);
    L23:
        com.bytedance.android.shopping.buynow.controller.f.b(this.a.getContext(), r4, this.a);
        BuyNowLog.d("selfQuitPage", "selfQuitPage finishes");
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L19:
        r5 = false;
        goto L20
    L15:
        r2 = null;
        goto L16
    L26:
    L9:
        e = move-exception;
        BuyNowLog.d("selfQuitPage", "error transforming fields to JSONObject");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.a.W90().getTracker(), "selfQuitPage", "error when transform yata fields to JSON", r9);
        int r12 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "json exception", e, null, 49);
    L5:
        if ((r1 instanceof String) == false) goto L7;
        r3 = new JSONObject((String) r1);     // Catch: Exception -> L9
    L25:
        goto L13
    L7:
        r3 = tv5.a.a(ECHybridGsonUtil.a(), r1);     // Catch: Exception -> L9
        goto L25
    }
}
