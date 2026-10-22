package com.bytedance.android.shopping.buynow.eventcenter.handle;

import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.kmp.ec.yata.event.common.b {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r7) {
        Intrinsics.checkNotNullParameter(r7, "input");
        BuyNowLog.d("selfAppletBack", "selfAppletBack starts");
        int r1 = ECSdk.a;
        IECHostService r2 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r2 == null) goto L20;
        IECAIHostService r3 = r2.getECHostAIService();
        if (r3 == null) goto L20;
        Map r8 = r7.q();
        if (r8 == null) goto L18;
        ArrayList r4 = new ArrayList();
        Iterator r9 = r8.entrySet().iterator();
    L10:
        if (r9.hasNext() == false) goto L17;
        Map.Entry r5 = (Map.Entry) r9.next();
        String r6 = (String) r5.getKey();
        Object r10 = r5.getValue();
        if (r10 == null) goto L14;
        Pair r11 = TuplesKt.to(r6, r10.toString());
    L15:
        if (r11 == null) goto L10;
        r4.add(r11);
        goto L10
    L14:
        r11 = null;
        goto L15
    L17:
        Map r12 = MapsKt.toMap(r4);
    L19:
        r3.sendAppletLog("return_last_page_doubao_apps", r12);
        goto L20
    L18:
        r12 = null;
    L20:
        BuyNowLog.d("selfAppletBack", "selfAppletBack finishes");
        int r13 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }
}
