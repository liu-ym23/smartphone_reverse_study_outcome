package com.bytedance.android.shopping.buynow.eventcenter.handle;

import android.content.Context;
import com.bytedance.android.ec.hybrid.list.util.ECHybridGsonUtil;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.android.shopping.yata.business.function.common.TTPay;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d0 extends com.bytedance.kmp.ec.yata.event.common.a {
    public final Context a;
    public final BuyNowViewModel b;

    public static final class a {
    }

    static {
    }

    public d0(Context r2, BuyNowViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.a = r2;
        this.b = r3;
    }

    public final void c(final com.bytedance.kmp.ec.yata.event.core.a r7, final Function1 r8) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Intrinsics.checkNotNullParameter(r8, "chainNextCallback");
        BuyNowLog.d("selfTTPay", "selfTTPay starts");
        Object r1 = r7.q();
        Boolean r2 = null;
        if (r1 != null) goto L41;
    L10:
        JSONObject r3 = null;
    L11:
        if (r3 == null) goto L18;
        String r4 = r3.optString("tt_pay_params");
        if (r4 == null) goto L18;
        JSONObject r5 = new JSONObject(r4);     // Catch: Exception -> L16
    L19:
        if (r5 != null) goto L21;
    L36:
        BuyNowLog.d("selfTTPay", "tt_pay_params is nullOrEmpty");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.b.getTracker(), "selfTTPay", "tt_pay_params is empty", r7);
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "tt_pay_params is empty", null, null, 57));
        return;
    L21:
        if (r5.length() == 0) goto L36;
        Object r6 = r7.p(Reflection.getOrCreateKotlinClass(List.class), "success_code");
        if ((r6 instanceof List) == true) goto L26;
        r6 = null;
    L26:
        final List r10 = (List) r6;
        if ((r10 instanceof List) == true) goto L29;
        r10 = null;
    L29:
        if (r10 == null) goto L32;
        r2 = Boolean.valueOf(r10.isEmpty());
    L32:
        if (com.bytedance.android.shopping.extensions.k.i(r2) == false) goto L34;
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.b.getTracker(), "selfTTPay", "success_code is empty", r7);
    L34:
        BuyNowLog.d("selfTTPay", "ttPay starts");
        int r0 = TTPay.a;
        TTPay.a(this.a, r5, new SelfTTPayFunction$onExecuteAsync$1(r7, r10, r8));
        return;
    L16:
        BuyNowLog.d("selfTTPay", "error transforming tt_pay_params to JSONObject");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.b.getTracker(), "selfTTPay", "tt_pay_paramserror when transform yata fields to JSON", r7);
        return;
    L18:
        r5 = null;
        goto L19
    L41:
    L9:
        BuyNowLog.d("selfTTPay", "error transforming fields to JSONObject");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.b.getTracker(), "selfTTPay", "fieldserror when transform yata fields to JSON", r7);
        goto L10
    L5:
        if ((r1 instanceof String) == false) goto L7;
        r3 = new JSONObject((String) r1);     // Catch: Exception -> L9
    L40:
        goto L11
    L7:
        r3 = tv5.a.a(ECHybridGsonUtil.a(), r1);     // Catch: Exception -> L9
        goto L40
    }
}
