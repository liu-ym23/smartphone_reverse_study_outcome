package uo6;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "localLife.poiWarmUp")
public final class a extends to6.b {
    public a() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        to6.b.InterfaceC7753b r103 = (to6.b.InterfaceC7753b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getBizCode();
        HostServiceUtilsKt.Z().f(r103.getLevel(), r104, r103.getEnterFrom());
    }
}
