package ee7;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.updateGecko")
public final class i extends c {
    public i() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        c.b r103 = (c.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getChannel();
        String r105 = r103.getAccessKey();
        boolean r106 = r103.getEnableDownloadAutoRetry();
        XBaseRuntime.f270095a.getClass();
        com.bytedance.sdk.xbridge.cn.runtime.depend.e r107 = XBaseRuntime.f270116v;
        if (r107 != null) goto L6;
        r107 = new qe7.c();
    L6:
        if (r107.a(r105, r104, new h(r102), r106) != null) goto L9;
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, "updateGecko failed, accessKey maybe not register", null, 4, null);
        return;
    }
}
