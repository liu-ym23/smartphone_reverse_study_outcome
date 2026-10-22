package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ability.DataResolver;
import com.bytedance.android.shopping.api.mall.common.feed.help.MallMitaClickDataReportKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i0 implements com.bytedance.android.ec.hybrid.card.event.e {
    public final /* synthetic */ ECMallFeed a;

    public i0(ECMallFeed r1) {
        this.a = r1;
    }

    public final void a(com.bytedance.android.ec.hybrid.card.event.d r4) {
        Intrinsics.checkNotNullParameter(r4, "jsEvent");
        Map r0 = r4.b;
        Object r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.get("card_id");
    L7:
        if ((r2 instanceof String) == true) goto L9;
        r2 = null;
    L9:
        String r3 = (String) r2;
        if (r3 != null) goto L12;
        return;
    L12:
        Map r5 = r4.b;
        if (r5 == null) goto L15;
        Object r6 = r5.get("click_area");
    L17:
        if ((r6 instanceof String) == false) goto L20;
        r1 = r6;
    L20:
        String r7 = (String) r1;
        if (r7 != null) goto L23;
        r7 = "";
    L23:
        ECMallFeed r8 = this.a;
        ECHybridListEngine r9 = r8.J;
        if (r9 == null) goto L30;
        DataResolver r10 = r9.c;
        if (r10 == null) goto L31;
        MallMitaClickDataReportKt.a(r10, r8.j0, r3, r7);
        return;
    L31:
        return;
    L30:
        return;
    L15:
        r6 = null;
        goto L17
    L5:
        r2 = null;
        goto L7
    }
}
