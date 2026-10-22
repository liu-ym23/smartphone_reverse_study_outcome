package fx0;

import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@XBridgeMethod(biz = "webcast", name = "updateWalletInfo")
public final class p extends com.bytedance.ies.web.jsbridge2.f<Object, Object> {
    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public p() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().sync(PrefetchTiming.JSB);
    }
}
