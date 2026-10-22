package com.bytedance.android.shopping.collect.function.base;

import com.bytedance.android.shopping.collect.container.CollectYataFragment;
import com.bytedance.android.shopping.collect.util.CollectCommonLog;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends com.bytedance.kmp.ec.yata.event.common.b {
    public final CollectYataFragment a;

    public d(CollectYataFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r6) {
        Intrinsics.checkNotNullParameter(r6, "input");
        CollectCommonLog.c("CollectSelfFun-selfOpenOrCloseSortPanel", "selfOpenOrCloseSortPanel");
        Map r7 = r6.q();
        if (r7 == null) goto L5;
        Object r8 = r7.get("state");
    L7:
        if (Intrinsics.areEqual(r8, "open") == false) goto L9;
        this.a.T90().setVisibility(0);
    L10:
        int r2 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, MapsKt.mapOf(TuplesKt.to("state", r8)), null, 5);
    L9:
        this.a.T90().setVisibility(8);
        goto L10
    L5:
        r8 = null;
        goto L7
    }
}
