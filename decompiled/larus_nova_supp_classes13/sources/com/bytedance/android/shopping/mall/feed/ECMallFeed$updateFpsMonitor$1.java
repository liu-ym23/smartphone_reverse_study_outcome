package com.bytedance.android.shopping.mall.feed;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECMallFeed$updateFpsMonitor$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Integer $tabId;
    final /* synthetic */ ECMallFeed this$0;

    public ECMallFeed$updateFpsMonitor$1(ECMallFeed r1, Integer r2) {
        this.this$0 = r1;
        this.$tabId = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1057invoke() {
        StringBuilder r0 = new StringBuilder("ec_mall_feed_");
        r0.append(this.this$0.B1.c);
        Integer r1 = this.$tabId;
        if (r1 != null) goto L5;
    L8:
        String r2 = "";
    L9:
        r0.append(r2);
        String r3 = r0.toString();
        if (Intrinsics.areEqual(r3, this.this$0.g) == false) goto L12;
        return;
    L12:
        ECHybridListEngine r4 = this.this$0.J;
        if (r4 == null) goto L19;
        ECHybridRecyclerView r5 = r4.b;
        if (r5 == null) goto L19;
        IHybridHostService r6 = com.bytedance.android.ec.hybrid.a.h();
        if (r6 == null) goto L19;
        r6.attachDropFrameMonitorTo(r3, r5);
    L19:
        Lazy r7 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.a.b, "ECMallFeed#updateFpsMonitor, target = " + this.this$0 + ", current = " + r3 + ", last = " + this.this$0.g);
        this.this$0.g = r3;
        return;
    L5:
        if (r1.intValue() == 0) goto L8;
        r2 = "_" + this.$tabId;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1057invoke();
        return Unit.INSTANCE;
    }
}
