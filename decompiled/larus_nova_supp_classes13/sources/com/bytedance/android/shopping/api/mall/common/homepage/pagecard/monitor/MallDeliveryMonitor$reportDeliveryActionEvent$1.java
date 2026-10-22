package com.bytedance.android.shopping.api.mall.common.homepage.pagecard.monitor;

import android.net.Uri;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.g;
import com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.SessionSettingUtil;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class MallDeliveryMonitor$reportDeliveryActionEvent$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ JSONObject $json;
    final /* synthetic */ String $process;
    final /* synthetic */ String $uuid;
    final /* synthetic */ MallDeliveryMonitor this$0;

    public MallDeliveryMonitor$reportDeliveryActionEvent$1(MallDeliveryMonitor r1, String r2, String r3, JSONObject r4) {
        this.this$0 = r1;
        this.$uuid = r2;
        this.$process = r3;
        this.$json = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m201invoke() {
        Set<String> r0 = (Set) ((LinkedHashMap) this.this$0.d).get(this.$uuid);
        if (r0 != null) goto L6;
        r0 = new LinkedHashSet();
        this.this$0.d.put(this.$uuid, r0);
    L6:
        if (r0.contains(this.$process) == false) goto L8;
        return;
    L8:
        r0.add(this.$process);
        if (Intrinsics.areEqual(this.$process, "view_appeared") == false) goto L11;
    L14:
        Integer r1 = (Integer) ((LinkedHashMap) this.this$0.f).get(this.$uuid);
        if (r1 != null) goto L18;
    L20:
        String r2 = "1";
    L21:
        this.$json.putOpt("mall_visible", r2);
        JSONObject r3 = this.$json;
        MallDeliveryMonitor r4 = this.this$0;
        String r5 = this.$uuid;
        if (r4.j.length() <= 0) goto L24;
        boolean r6 = true;
    L25:
        if (r6 == false) goto L27;
        String r7 = r4.j;
    L42:
        r3.putOpt("origin_schema", r7);
    L44:
        if ((!Intrinsics.areEqual(this.$process, "delivery_identify")) == false) goto L51;
        String r8 = (String) ((LinkedHashMap) this.this$0.i).get(this.$uuid);
        if (r8 != null) goto L49;
        r8 = "-1";
    L49:
        if ((true ^ Intrinsics.areEqual(r8, "-1")) == false) goto L51;
        this.$json.putOpt("res_version", r8);
    L51:
        AppLogNewUtils.onEventV3("ec_mall_delivery_action_full", this.$json);
        if (((List) SessionSettingUtil.f.getValue()).contains(this.$process) == false) goto L54;
        AppLogNewUtils.onEventV3("ec_mall_delivery_action", this.$json);
    L54:
        Lazy r9 = ECMallLogUtil.a;
        ECMallLogUtil.c(g.a.b, "report ec_mall_delivery_action, uuid = " + this.$uuid + ", process = " + this.$process + ", json = " + this.$json);
        return;
    L27:
        Map r10 = (Map) ((LinkedHashMap) r4.a).get(r5);
        Object r11 = null;
        if (r10 == null) goto L30;
        Object r12 = r10.get("delivery_value");
    L32:
        if ((r12 instanceof String) == false) goto L35;
        r11 = r12;
    L35:
        String r13 = (String) r11;
        if (r13 != null) goto L56;
        r13 = "";
    L56:
        String r14 = Uri.decode(r13);     // Catch: Exception -> L40
    L41:
        r4.j = r14;
        r7 = r14;
    L40:
        r14 = r13;
        goto L41
    L30:
        r12 = null;
        goto L32
    L24:
        r6 = false;
        goto L25
    L18:
        if (r1.intValue() != 1) goto L20;
        r2 = "2";
        goto L21
    L11:
        if (Intrinsics.areEqual(this.$process, "tti") == true) goto L14;
        if (Intrinsics.areEqual(this.$process, "router") == false) goto L44;
        goto L14
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m201invoke();
        return Unit.INSTANCE;
    }
}
