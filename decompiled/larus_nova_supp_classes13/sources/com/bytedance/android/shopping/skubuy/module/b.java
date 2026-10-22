package com.bytedance.android.shopping.skubuy.module;

import com.bytedance.android.shopping.abscontainer.common_biz.constant.PageStartupStatus;
import com.bytedance.android.shopping.abscontainer.common_biz.constant.track.TradeCheckPoint;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b<DATA> implements w33.c {
    public final /* synthetic */ d a;

    public b(d r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        x43.a r7 = (x43.a) r6;
        if (r7 == null) goto L24;
        d r0 = this.a;
        r0.getClass();
        if (r7.a == false) goto L25;
        ((s33.b) r0).a.a.M(PageStartupStatus.PAGE_ERROR);
        com.bytedance.android.shopping.abscontainer.arch.core.ability.impl.c r1 = ((s33.b) r0).a.d.a();
        Pair[] r2 = new Pair[6];
        r2[0] = TuplesKt.to("type", TradeCheckPoint.Node.ERROR_PAGE_SHOW.getRawValue());
        String r3 = r7.d;
        String r4 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r2[1] = TuplesKt.to("title", r3);
        String r5 = r7.e;
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        r2[2] = TuplesKt.to("desc", r5);
        String r8 = r7.c;
        if (r8 != null) goto L15;
        r8 = "";
    L15:
        r2[3] = TuplesKt.to("icon", r8);
        String r9 = r7.f;
        if (r9 != null) goto L18;
        r9 = "";
    L18:
        r2[4] = TuplesKt.to("button_name", r9);
        String r10 = r7.g;
        if (r10 == null) goto L22;
        r4 = r10;
    L22:
        r2[5] = TuplesKt.to("button_action", r4);
        r1.a("trade_checkpoint", MapsKt.mapOf(r2));
        return;
    L25:
        return;
    }
}
