package d30;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.model.s0;
import com.bytedance.android.live.browser.jsbridge.base.CommunityCloseAnchorInteractPluginLynxContainerResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.b0;
import w20.i8;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "community.closeAnchorInteractPluginLynxContainer")
public final class a extends b0<i8, CommunityCloseAnchorInteractPluginLynxContainerResultModel> {
    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        i8 r102 = (i8) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        s0 r103 = new s0();
        r103.a(r102.a());
        IBroadcastService r104 = (IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class);
        if (r104 != null) goto L5;
    L7:
        CommunityCloseAnchorInteractPluginLynxContainerResultModel r105 = new CommunityCloseAnchorInteractPluginLynxContainerResultModel();
        r105.a(CommunityCloseAnchorInteractPluginLynxContainerResultModel.Code.Failed);
        Unit r106 = Unit.INSTANCE;
        finishWithResult(r105);
        return;
    L5:
        if (r104.closeLynxPlugin(r103) != true) goto L7;
        CommunityCloseAnchorInteractPluginLynxContainerResultModel r107 = new CommunityCloseAnchorInteractPluginLynxContainerResultModel();
        r107.a(CommunityCloseAnchorInteractPluginLynxContainerResultModel.Code.Success);
        Unit r108 = Unit.INSTANCE;
        finishWithResult(r107);
    }
}
