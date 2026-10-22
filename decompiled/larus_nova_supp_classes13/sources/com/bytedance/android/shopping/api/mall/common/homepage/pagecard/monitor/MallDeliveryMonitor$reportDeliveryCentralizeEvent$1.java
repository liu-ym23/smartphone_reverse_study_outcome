package com.bytedance.android.shopping.api.mall.common.homepage.pagecard.monitor;

import com.ss.android.common.lib.AppLogNewUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class MallDeliveryMonitor$reportDeliveryCentralizeEvent$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Map $params;

    public MallDeliveryMonitor$reportDeliveryCentralizeEvent$1(Map r1) {
        this.$params = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m202invoke() {
        JSONObject r0 = new JSONObject();
        Iterator r1 = this.$params.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) r1.next();
        r0.putOpt((String) r2.getKey(), r2.getValue());
        goto L4
    L6:
        AppLogNewUtils.onEventV3("ec_mall_delivery_centralized", r0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m202invoke();
        return Unit.INSTANCE;
    }
}
