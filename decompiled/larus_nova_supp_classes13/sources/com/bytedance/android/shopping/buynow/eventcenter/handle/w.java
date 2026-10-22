package com.bytedance.android.shopping.buynow.eventcenter.handle;

import com.bytedance.android.ec.hybrid.list.util.ECHybridGsonUtil;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w extends com.bytedance.kmp.ec.yata.event.common.b {
    public final BuyNowViewModel a;

    public static final class a {
    }

    static {
    }

    public w(BuyNowViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "buyNowViewModel");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        BuyNowLog.d("selfSaveRenderNode", "selfSaveRenderNode starts");
        Object r1 = r5.q();
        if (r1 != null) goto L17;
    L10:
        JSONObject r3 = null;
    L11:
        if (r3 == null) goto L13;
        String r6 = r3.optString("render_node_key");
    L14:
        com.bytedance.android.shopping.buynow.controller.e.a = r6;
        BuyNowLog.d("selfSaveRenderNode", "selfSaveRenderNode finishes");
        int r7 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L13:
        r6 = null;
        goto L14
    L17:
    L9:
        BuyNowLog.d("selfSaveRenderNode", "error transforming fields to json");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.a.getTracker(), "selfSaveRenderNode", "error when transform yata fields to JSON", r5);
        goto L10
    L5:
        if ((r1 instanceof String) == false) goto L7;
        r3 = new JSONObject((String) r1);     // Catch: Exception -> L9
    L16:
        goto L11
    L7:
        r3 = tv5.a.a(ECHybridGsonUtil.a(), r1);     // Catch: Exception -> L9
        goto L16
    }
}
