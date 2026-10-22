package com.bytedance.android.shopping.buynow.eventcenter.handle;

import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class s extends com.bytedance.kmp.ec.yata.event.common.b {

    public static final class a {
    }

    static {
    }

    public s() {
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r7) {
        Intrinsics.checkNotNullParameter(r7, "input");
        BuyNowLog.d("selfQuitApplet", "selfQuitApplet starts");
        int r1 = ECSdk.a;
        IECHostService r2 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r2 == null) goto L5;
        IECAIHostService r3 = r2.getECHostAIService();
    L6:
        if (r3 == null) goto L24;
        Map r8 = r7.q();
        if (r8 == null) goto L22;
        ArrayList r4 = new ArrayList();
        Iterator r9 = r8.entrySet().iterator();
    L11:
        if (r9.hasNext() == false) goto L18;
        Map.Entry r5 = (Map.Entry) r9.next();
        String r6 = (String) r5.getKey();
        Object r10 = r5.getValue();
        if (r10 == null) goto L15;
        Pair r11 = TuplesKt.to(r6, r10.toString());
    L16:
        if (r11 == null) goto L11;
        r4.add(r11);
        goto L11
    L15:
        r11 = null;
        goto L16
    L18:
        Map r12 = MapsKt.toMap(r4);
        if (r12 == null) goto L22;
        Map r13 = MapsKt.toMutableMap(r12);
        if (r13 == null) goto L22;
    L23:
        r13.put("exit_method", "click_exit_apps_btn");
        r3.sendAppletLog("tobsdk_livesdk_exit_doubao_apps", r13);
    L22:
        r13 = new LinkedHashMap();
    L24:
        if (r3 == null) goto L26;
        r3.closeApplet("buy_now");
    L26:
        BuyNowLog.d("selfQuitApplet", "selfQuitApplet finishes");
        int r14 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L5:
        r3 = null;
        goto L6
    }
}
