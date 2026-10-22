package com.bytedance.applet.aibridge.share;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.common.apphost.AppHost;
import com.larus.share.service.IAppletSharePanelService;
import com.larus.share.service.a;
import com.larus.share.service.b;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/share/ShowSharePanelMethod;", "Lcom/bytedance/applet/aibridge/share/AbsShowSharePanelMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/share/AbsShowSharePanelMethodIDL$ShowSharePanelMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/share/AbsShowSharePanelMethodIDL$ShowSharePanelMethodResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowSharePanelMethod extends AbsShowSharePanelMethodIDL {
    public ShowSharePanelMethod() {
    }

    public final void handle(d r20, ParamModel r21, h r22) {
        AbsShowSharePanelMethodIDL.b r1 = (AbsShowSharePanelMethodIDL.b) r21;
        Intrinsics.checkNotNullParameter(r20, "bridgeContext");
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r22, "callback");
        FLogger r2 = FLogger.a;
        r2.i("flow.showSharePanel", "start ShowSharePanelMethod handle: scene=" + r1.getScene());
        FragmentActivity r3 = AppHost.a.a().getCurrentActivity();
        if (r3 != null) goto L6;
        r2.i("flow.showSharePanel", "topActivity is null");
        Intrinsics.checkNotNullParameter(AbsShowSharePanelMethodIDL.c.class, "<this>");
        AbsShowSharePanelMethodIDL.c r4 = c.a(AbsShowSharePanelMethodIDL.c.class);
        r4.setCode(-1);
        r4.setErrorMsg("topActivity is null");
        h.a.a(r22, "topActivity is null", null, r4.toJson(), 6);
        return;
    L6:
        if ((r3 instanceof FragmentActivity) == true) goto L8;
        r2.i("flow.showSharePanel", "topActivity is not FragmentActivity, topActivity(" + r3 + ')');
        Intrinsics.checkNotNullParameter(AbsShowSharePanelMethodIDL.c.class, "<this>");
        AbsShowSharePanelMethodIDL.c r5 = c.a(AbsShowSharePanelMethodIDL.c.class);
        r5.setCode(-1);
        r5.setErrorMsg("topActivity is not FragmentActivity");
        h.a.a(r22, "topActivity is not FragmentActivity", null, r5.toJson(), 6);
        return;
    L8:
        int r9 = com.larus.share.service.c.a;
        a r10 = new a(r3, r1.getScene(), r1.getShareLinkUrl(), r1.getShareTitle(), r1.getShareContent(), r1.getShareCoverUrl(), r1.getEpisodeId(), r1.getTrackInfo());
        Intrinsics.checkNotNullParameter(r10, "request");
        IAppletSharePanelService r6 = (IAppletSharePanelService) ServiceManager.get().getService(IAppletSharePanelService.class);
        if (r6 == null) goto L12;
        b r7 = r6.a(r10);
        if (r7 == null) goto L12;
    L14:
        if (r7.a == false) goto L16;
        Intrinsics.checkNotNullParameter(AbsShowSharePanelMethodIDL.c.class, "<this>");
        AbsShowSharePanelMethodIDL.c r8 = c.a(AbsShowSharePanelMethodIDL.c.class);
        r8.setCode(0);
        r22.b(r8, "");
        return;
    L16:
        String r11 = r7.b;
        if (r11 != null) goto L19;
        r11 = "show share panel failed";
    L19:
        r2.i("flow.showSharePanel", r11);
        Intrinsics.checkNotNullParameter(AbsShowSharePanelMethodIDL.c.class, "<this>");
        AbsShowSharePanelMethodIDL.c r12 = c.a(AbsShowSharePanelMethodIDL.c.class);
        r12.setCode(-1);
        r12.setErrorMsg(r11);
        h.a.a(r22, r11, null, r12.toJson(), 6);
        return;
    L12:
        r7 = new b(false, "share service is null");
        goto L14
    }
}
