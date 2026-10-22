package com.obric.miniapp.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/miniapp/aibridge/SetTitleBarMethod;", "Lcom/obric/miniapp/aibridge/AbsSetTitleBarMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsSetTitleBarMethodIDL$SetTitleBarTitleParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsSetTitleBarMethodIDL$SetTitleBarTitleResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetTitleBarMethod extends AbsSetTitleBarMethodIDL {
    public SetTitleBarMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, f3.h r102) {
        AbsSetTitleBarMethodIDL.a r103 = (AbsSetTitleBarMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        k2.j r104 = (k2.j) r100.d(k2.j.class);
        if (r104 == null) goto L29;
        k2.m r105 = r104.getContainerViewService();
        if (r105 == null) goto L7;
        k2.q r106 = r105.h();
    L8:
        if (r106 == null) goto L28;
        LinkedHashMap r107 = new LinkedHashMap();
        Boolean r108 = r103.getHideTitleBar();
        if (r108 == null) goto L12;
        r107.put("hideTitleBar", Boolean.valueOf(r108.booleanValue()));
    L12:
        Boolean r109 = r103.getHideBackButton();
        if (r109 == null) goto L15;
        r107.put("hideTitleBarBackButton", Boolean.valueOf(r109.booleanValue()));
    L15:
        String r110 = r103.getTitle();
        if (r110 == null) goto L18;
        r107.put("setTitleBarTitle", r110);
    L18:
        String r111 = r103.getMode();
        if (r111 == null) goto L21;
        r107.put("setTitleBarMode", r111);
    L21:
        String r112 = r103.getBackgroundColor();
        if (r112 == null) goto L25;
        r107.put("setTitleBarBackgroundColor", r112);
    L25:
        if ((!r107.isEmpty()) == false) goto L27;
        r106.b(r107);
        Intrinsics.checkNotNullParameter(AbsSetTitleBarMethodIDL.b.class, "<this>");
        r102.b((ResultModel) k3.c.a(AbsSetTitleBarMethodIDL.b.class), "");
        return;
    L27:
        f3.h.a.a(r102, "settings is empty", null, null, 14);
        return;
    L28:
        f3.h.a.a(r102, "Failed to get View", null, null, 14);
        return;
    L7:
        r106 = null;
        goto L8
    L29:
        f3.h.a.a(r102, "Failed to get View", null, null, 14);
    }
}
