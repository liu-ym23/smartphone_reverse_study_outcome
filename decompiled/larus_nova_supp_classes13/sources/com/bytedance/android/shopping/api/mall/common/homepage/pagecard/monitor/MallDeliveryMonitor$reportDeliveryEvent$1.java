package com.bytedance.android.shopping.api.mall.common.homepage.pagecard.monitor;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.g;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class MallDeliveryMonitor$reportDeliveryEvent$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $isSuccess;
    final /* synthetic */ JSONObject $json;
    final /* synthetic */ String $uuid;
    final /* synthetic */ MallDeliveryMonitor this$0;

    public MallDeliveryMonitor$reportDeliveryEvent$1(MallDeliveryMonitor r1, String r2, JSONObject r3, boolean r4) {
        this.this$0 = r1;
        this.$uuid = r2;
        this.$json = r3;
        this.$isSuccess = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m204invoke() {
        Map r0 = (Map) ((LinkedHashMap) this.this$0.a).get(this.$uuid);
        if (r0 == null) goto L8;
        Iterator r1 = r0.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        Map.Entry r2 = (Map.Entry) r1.next();
        this.$json.putOpt((String) r2.getKey(), r2.getValue());
    L8:
        this.$json.putOpt("is_success", Integer.valueOf(this.$isSuccess ? 1 : 0));
        AppLogNewUtils.onEventV3("ec_mall_delivery", this.$json);
        Lazy r3 = ECMallLogUtil.a;
        ECMallLogUtil.c(g.a.b, "report ec_mall_delivery, isSuccess = " + this.$isSuccess + ", json = " + this.$json);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m204invoke();
        return Unit.INSTANCE;
    }
}
