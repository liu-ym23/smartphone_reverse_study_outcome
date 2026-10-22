package com.bytedance.android.shopping.buynow.eventcenter.handle;

import android.content.Context;
import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class o extends com.bytedance.kmp.ec.yata.event.common.b {
    public final Context a;

    public static final class a {
    }

    static {
    }

    public o(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r7) {
        Intrinsics.checkNotNullParameter(r7, "input");
        BuyNowLog.d("selfOpenMore", "selfOpenMore starts");
        int r1 = ECSdk.a;
        IECHostService r2 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r2 == null) goto L5;
        IECAIHostService r3 = r2.getECHostAIService();
    L6:
        if (r3 == null) goto L21;
        Map r8 = r7.q();
        if (r8 == null) goto L19;
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
    L20:
        r3.sendAppletLog("tobsdk_livesdk_click_doubao_apps_more", r12);
        goto L21
    L19:
        r12 = null;
    L21:
        if (r3 == null) goto L23;
        r3.showAppletPanel(this.a, "buy_now", CollectionsKt.emptyList(), null);
    L23:
        BuyNowLog.d("selfOpenMore", "selfOpenMore finishes");
        int r13 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L5:
        r3 = null;
        goto L6
    }
}
