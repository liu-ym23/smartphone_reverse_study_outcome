package com.bytedance.locallife.bridge.common.method;

import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class j extends ko6.b {
    public j() {
    }

    @Override // v56.c
    public final void e(XBaseParamModel r100, v56.a r101, XBridgePlatformType r102) {
        ko6.b.InterfaceC6583b r103 = (ko6.b.InterfaceC6583b) r100;
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(ko6.b.c.class, "<this>");
        ko6.b.c r104 = (ko6.b.c) com.bytedance.ies.xbridge.utils.g.c(ko6.b.c.class);
        r104.setResult(kn6.a.b(r103.getSrcStr(), r103.getEncrypt()));
        r101.onSuccess(r104, "");
    }
}
