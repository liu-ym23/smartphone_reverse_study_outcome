package com.bytedance.locallife.bridge.common.method;

import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.model.idl.CompletionBlock;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends ko6.l implements com.bytedance.sdk.xbridge.cn.protocol.h {

    public static final class a {
    }

    static {
    }

    @Override // v56.c, com.bytedance.ies.xbridge.IDLXBridgeMethod, com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    public b() {
    }

    @Override // v56.c
    public final void e(XBaseParamModel r100, v56.a r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter((ko6.l.a) r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        CompletionBlock.a.a(r101, 0, "lightnavi.initNavigation is not supported by current host", null, 4);
    }
}
