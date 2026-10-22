package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\n¢\u0006\u0002\b\f"}, d2 = {"<anonymous>", "", "stageName", "", "schema", "sessionId", "timestamp", "", "triggerSource", "extraData", "", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECDeliverySessionStageHandler$defaultAction$1 extends Lambda implements Function6<String, String, String, Double, String, Map<String, ? extends Object>, Unit> {
    final /* synthetic */ b this$0;

    public ECDeliverySessionStageHandler$defaultAction$1(b r1) {
        super(6);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r9, Object r10, Object r11, Object r12, Object r13, Object r14) {
        invoke((String) r9, (String) r10, (String) r11, ((Number) r12).doubleValue(), (String) r13, (Map) r14);
        return Unit.INSTANCE;
    }

    public final void invoke(String r1, String r2, String r3, double r4, String r6, Map<String, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r1, "stageName");
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter(r3, "sessionId");
        Intrinsics.checkNotNullParameter(r6, "triggerSource");
        throw null;
    }
}
