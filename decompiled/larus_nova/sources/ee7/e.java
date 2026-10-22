package ee7;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.getGeckoInfo")
public final class e extends a {
    public e() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        a.b r103 = (a.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getChannel();
        String r105 = r103.getAccessKey();
        XBaseRuntime.f270095a.getClass();
        com.bytedance.sdk.xbridge.cn.runtime.depend.e r106 = XBaseRuntime.f270116v;
        if (r106 != null) goto L6;
        r106 = new qe7.c();
    L6:
        if (r106.b(r105, r104, new d(r102)) != null) goto L9;
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, "getGeckoInfo ability is not implemented", null, 4, null);
        return;
    }
}
