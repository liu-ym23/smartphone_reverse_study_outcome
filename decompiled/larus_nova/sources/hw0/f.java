package hw0;

import com.bytedance.android.live.recharge.core.RechargeServices;
import com.bytedance.android.live.recharge.deal.n;
import com.bytedance.android.live.recharge.order.j;
import com.bytedance.android.live.recharge.order.k;
import com.bytedance.android.live.recharge.platform.service.IExchangeService;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes47.dex */
public final class f extends b<h, i> {

    public static final class a {
    }

    static {
    }

    public f() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r210, CallContext r211) {
        h r100 = (h) r210;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        Integer r101 = r100.d();
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.intValue();
    L6:
        Integer r104 = r100.e();
        if (r104 == null) goto L9;
        int r105 = r104.intValue();
    L10:
        Integer r106 = r100.f();
        if (r106 == null) goto L13;
        int r107 = r106.intValue();
    L14:
        Integer r108 = r100.a();
        if (r108 == null) goto L17;
        r102 = r108.intValue();
    L17:
        if (r103 > 0) goto L19;
        i r109 = new i();
        r109.a(-1);
        r109.b("input diamond invalid");
        Unit r110 = Unit.INSTANCE;
        finishWithResult(r109);
        return;
    L19:
        new com.bytedance.android.live.revenue.common.g("IncomeExchangeMethod", null).b("exchange jsb buyDiamond begin. params=" + r100);
        n r111 = new n(r103, r102, r107);
        HashMap r112 = new HashMap();
        JsonObject r113 = r100.g();
        if (r113 == null) goto L25;
        Iterator<String> r114 = r113.keySet().iterator();
    L23:
        if (r114.hasNext() == false) goto L25;
        String r115 = r114.next();
        r112.put(r115, String.valueOf(r113.get(r115)));
    L25:
        j r116 = new j(r112);
        String r117 = r100.h();
        String r118 = "";
        if (r117 != null) goto L28;
        r117 = "";
    L28:
        r116.e(r117);
        String r119 = r100.c();
        if (r119 != null) goto L31;
        r119 = "";
    L31:
        r116.d(r119);
        String r120 = r100.b();
        if (r120 == null) goto L35;
        r118 = r120;
    L35:
        r116.c(r118);
        k r121 = new k(r116, null, false, 0, false, false, 0, 0, null, null, null, 8190);
        if (r105 != 0) goto L38;
        IExchangeService.ExchangeApiType r122 = IExchangeService.ExchangeApiType.CASH;
    L45:
        IExchangeService.b r123 = new IExchangeService.b(r111, r122, null, false, 110);
        int r124 = v.f91009a;
        v.e("ttlive_exchange", "exchange from jsb, param=" + r100);
        com.bytedance.android.live.recharge.core.d r125 = RechargeServices.b();
        Intrinsics.checkNotNullParameter(r125, "$this$exchangeService");
        IExchangeService r126 = (IExchangeService) r125.a(Reflection.getOrCreateKotlinClass(IExchangeService.class));
        if (r126 == null) goto L51;
        r126.t1(r123, r121, new g(this, r100, r103, r123, r121));
        return;
    L51:
        return;
    L38:
        if (r105 != 1) goto L40;
        r122 = IExchangeService.ExchangeApiType.GOLD_BALANCE;
        goto L45
    L40:
        if (r105 == 2) goto L42;
        r122 = IExchangeService.ExchangeApiType.CASH;
        goto L45
    L42:
        r122 = IExchangeService.ExchangeApiType.HUOSHAN_FLAME;
        goto L45
    L13:
        r107 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }
}
