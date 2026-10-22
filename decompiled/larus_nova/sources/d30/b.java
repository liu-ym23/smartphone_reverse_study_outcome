package d30;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.model.s0;
import com.bytedance.android.live.browser.jsbridge.base.CommunityOpenAnchorInteractPluginLynxContainerResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.f0;
import w20.l8;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "community.openAnchorInteractPluginLynxContainer")
public final class b extends f0<l8, CommunityOpenAnchorInteractPluginLynxContainerResultModel> {
    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        l8 r102 = (l8) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        s0 r103 = new s0();
        r103.a(r102.a());
        r103.e(r102.e());
        r103.d(r102.d());
        r103.c(r102.c());
        r103.b(r102.b());
        IBroadcastService r104 = (IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class);
        if (r104 != null) goto L5;
    L7:
        CommunityOpenAnchorInteractPluginLynxContainerResultModel r105 = new CommunityOpenAnchorInteractPluginLynxContainerResultModel();
        r105.a(CommunityOpenAnchorInteractPluginLynxContainerResultModel.Code.Failed);
        Unit r106 = Unit.INSTANCE;
        finishWithResult(r105);
        return;
    L5:
        if (r104.startLynxPlugin(r103) != true) goto L7;
        CommunityOpenAnchorInteractPluginLynxContainerResultModel r107 = new CommunityOpenAnchorInteractPluginLynxContainerResultModel();
        r107.a(CommunityOpenAnchorInteractPluginLynxContainerResultModel.Code.Success);
        Unit r108 = Unit.INSTANCE;
        finishWithResult(r107);
    }
}
