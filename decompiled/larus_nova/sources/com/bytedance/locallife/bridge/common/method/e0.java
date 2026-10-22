package com.bytedance.locallife.bridge.common.method;

import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e0 extends ko6.x {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final String getName() {
        return "poi_feed_sync_data";
    }

    public e0() {
    }

    @Override // v56.c
    public final void e(XBaseParamModel r100, v56.a r101, XBridgePlatformType r102) {
        ko6.x.b r103 = (ko6.x.b) r100;
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        vn6.b.a(new jy6.a(r103.getData()));
        Intrinsics.checkNotNullParameter(ko6.x.c.class, "<this>");
        r101.onSuccess((XBaseResultModel) com.bytedance.ies.xbridge.utils.g.c(ko6.x.c.class), "");
    }
}
