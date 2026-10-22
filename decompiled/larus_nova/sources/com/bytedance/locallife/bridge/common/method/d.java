package com.bytedance.locallife.bridge.common.method;

import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "localLife.genericPerfAction")
public final class d extends ko6.q {
    public d() {
    }

    @Override // v56.c
    public final void e(XBaseParamModel r100, v56.a r101, XBridgePlatformType r102) {
        ko6.q.b r103 = (ko6.q.b) r100;
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        ut6.b r104 = HostServiceUtilsKt.C();
        if (r104 == null) goto L5;
        r103.getScene();
        r103.getSubScene();
        r103.getPoint();
        r103.getBusinessParams();
        r104.a();
    L5:
        Intrinsics.checkNotNullParameter(ko6.q.c.class, "<this>");
        ko6.q.c r105 = (ko6.q.c) com.bytedance.ies.xbridge.utils.g.c(ko6.q.c.class);
        r105.setCode(0);
        r105.setMsg("");
        r101.onSuccess(r105, "");
    }
}
