package com.bytedance.android.shopping.buynow.eventcenter.handle;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.hybrid.list.util.ECHybridGsonUtil;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r extends com.bytedance.kmp.ec.yata.event.common.a {
    public final BuyNowViewModel a;

    public static final class a {
    }

    static {
    }

    public r(BuyNowViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r7, Function1 r8) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Intrinsics.checkNotNullParameter(r8, "chainNextCallback");
        Object r0 = r7.p(Reflection.getOrCreateKotlinClass(String.class), "event_name");
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        String r1 = (String) r0;
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        if (r1.length() != 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L15;
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "event_name is null", null, null, 57));
        return;
    L15:
        Map r3 = r7.q();
        if (r3 == null) goto L26;
        Object r4 = r3.get("params");
        if (r4 == null) goto L26;
    L24:
        BuyNowLog.d("selfPublishEvent", "error transforming fields to json");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.a.getTracker(), "selfPublishEvent", "error when transform yata fields to JSON", r7);
        JSONObject r5 = null;
    L25:
        if (r5 == null) goto L26;
    L27:
        ECLiveHybridUtil.f(r1, r5);
        int r10 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L20:
        if ((r4 instanceof String) == false) goto L22;
        r5 = new JSONObject((String) r4);     // Catch: Exception -> L24
    L29:
        goto L25
    L22:
        r5 = tv5.a.a(ECHybridGsonUtil.a(), r4);     // Catch: Exception -> L24
    L26:
        r5 = new JSONObject();
        goto L27
    L11:
        r2 = false;
        goto L12
    }
}
