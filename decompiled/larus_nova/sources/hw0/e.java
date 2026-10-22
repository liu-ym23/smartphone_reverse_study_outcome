package hw0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.recharge.exchange.jsbridge.GetMemAutoExchangeStatusResultModel;
import com.bytedance.android.live.recharge.platform.business.IExchangeStatusService;
import com.bytedance.android.live.recharge.utils.RechargeFacadeUtilsKt;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e extends a<JsonObject, GetMemAutoExchangeStatusResultModel> {
    public e() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        RechargeFacadeUtilsKt.a().getClass();
        IExchangeStatusService r102 = (IExchangeStatusService) ((dy0.d) com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), IExchangeStatusService.class));
        if (r102 == null) goto L5;
        Integer r103 = Integer.valueOf(r102.getAutoExchangeStatus());
    L6:
        GetMemAutoExchangeStatusResultModel r104 = new GetMemAutoExchangeStatusResultModel();
        GetMemAutoExchangeStatusResultModel.a r105 = new GetMemAutoExchangeStatusResultModel.a();
        r105.a(r103);
        Unit r106 = Unit.INSTANCE;
        r104.b(r105);
        r104.a(GetMemAutoExchangeStatusResultModel.Code.Success);
        finishWithResult(r104);
        ALogger.i("GetAutoExchangeStatusMethod", "return autoExchangeStatus: " + r103);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
