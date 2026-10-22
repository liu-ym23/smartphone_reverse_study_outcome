package com.bytedance.android.shopping.buynow.eventcenter.handle;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.list.util.ECHybridGsonUtil;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f0 extends com.bytedance.kmp.ec.yata.event.common.b {
    public final BuyNowViewModel a;

    public static final class a {
    }

    static {
    }

    public f0(BuyNowViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r10) {
        Intrinsics.checkNotNullParameter(r10, "input");
        BuyNowLog.d("selfTracker", "selfTracker starts");
        Object r1 = r10.q();
        if (r1 != null) goto L42;
    L10:
        JSONObject r3 = null;
    L11:
        if (r3 == null) goto L13;
        String r11 = r3.optString("event_name");
    L14:
        String r12 = com.bytedance.android.shopping.extensions.k.j(r11);
        if (r3 == null) goto L19;
        JSONObject r2 = r3.optJSONObject("params");
        if (r2 == null) goto L19;
        Map<String, ? extends Object> r4 = z1.k(r2);
    L20:
        if (r3 == null) goto L22;
        Boolean r5 = Boolean.valueOf(r3.optBoolean("enterNewPage"));
    L23:
        boolean r6 = com.bytedance.android.shopping.extensions.k.i(r5);
        if (r3 == null) goto L26;
        Boolean r7 = Boolean.valueOf(r3.optBoolean("addBtmChain"));
    L27:
        boolean r8 = com.bytedance.android.shopping.extensions.k.i(r7);
        if (r3 == null) goto L30;
        Object r9 = r3.opt("targetPages");
    L32:
        if ((r9 instanceof List) == true) goto L34;
        r9 = null;
    L34:
        List r13 = (List) r9;
        if (r13 != null) goto L37;
        r13 = CollectionsKt.emptyList();
    L37:
        if (r6 == false) goto L39;
        BuyNowLog.d("selfTracker", "enterNewPage is " + r6 + ", calling BtmSDK");
        BtmSDK r14 = BtmSDK.INSTANCE;
        int r15 = com.bytedance.android.shopping.buynow.utils.c.a;
        r14.willJumpToNextPage(new BtmItemBuilder(com.bytedance.android.shopping.buynow.utils.c.a(this.a.getStaticState().g), null, 2, null).withPageFinder(this.a.getStaticState().d).setTargetPagesBtm(r13).setAddBtmChain(r8).build());
    L39:
        BuyNowLog.d("selfTracker", "calling tracker");
        this.a.getTracker().b(r12, r4);
        BuyNowLog.d("selfTracker", "selfTracker finishes");
        int r16 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L30:
        r9 = null;
        goto L32
    L26:
        r7 = null;
        goto L27
    L22:
        r5 = null;
    L19:
        r4 = MapsKt.emptyMap();
        goto L20
    L13:
        r11 = null;
        goto L14
    L42:
    L9:
        BuyNowLog.d("selfTracker", "error converting fields to JSONObject");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.a.getTracker(), "selfTracker", "error when transform yata fields to JSON", r10);
        goto L10
    L5:
        if ((r1 instanceof String) == false) goto L7;
        r3 = new JSONObject((String) r1);     // Catch: Exception -> L9
    L41:
        goto L11
    L7:
        r3 = tv5.a.a(ECHybridGsonUtil.a(), r1);     // Catch: Exception -> L9
        goto L41
    }
}
