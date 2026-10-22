package com.bytedance.locallife.bridge.common.method;

import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class p extends ko6.h {
    public p() {
    }

    @Override // v56.c
    public final void e(XBaseParamModel r100, v56.a r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter((ko6.h.b) r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(ko6.h.c.class, "<this>");
        ko6.h.c r103 = (ko6.h.c) com.bytedance.ies.xbridge.utils.g.c(ko6.h.c.class);
        r103.setCode(-1);
        r103.setParams_str("");
        r101.onSuccess(r103, "");
    }
}
