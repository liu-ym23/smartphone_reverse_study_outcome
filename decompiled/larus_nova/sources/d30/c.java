package d30;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.model.s0;
import com.bytedance.android.live.browser.jsbridge.base.CommunityUpdateAnchorInteractPluginLynxContainerResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.g0;
import w20.m8;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "community.updateAnchorInteractPluginLynxContainer")
public final class c extends g0<m8, CommunityUpdateAnchorInteractPluginLynxContainerResultModel> {
    public c() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        m8 r102 = (m8) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        s0 r103 = new s0();
        r103.a(r102.a());
        r103.c(r102.b());
        IBroadcastService r104 = (IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class);
        if (r104 != null) goto L5;
    L7:
        CommunityUpdateAnchorInteractPluginLynxContainerResultModel r105 = new CommunityUpdateAnchorInteractPluginLynxContainerResultModel();
        r105.a(CommunityUpdateAnchorInteractPluginLynxContainerResultModel.Code.Failed);
        Unit r106 = Unit.INSTANCE;
        finishWithResult(r105);
        return;
    L5:
        if (r104.updateLynxPlugin(r103) != true) goto L7;
        CommunityUpdateAnchorInteractPluginLynxContainerResultModel r107 = new CommunityUpdateAnchorInteractPluginLynxContainerResultModel();
        r107.a(CommunityUpdateAnchorInteractPluginLynxContainerResultModel.Code.Success);
        Unit r108 = Unit.INSTANCE;
        finishWithResult(r107);
    }
}
