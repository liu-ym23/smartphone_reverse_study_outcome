package so6;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends ro6.a {
    public a() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        ro6.a.b r103 = (ro6.a.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getKey();
        String r105 = r103.getDomain();
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        ro6.a.c r106 = (ro6.a.c) ne7.e.b(ro6.a.c.class);
        yn6.c r107 = yn6.a.f568561a;
        r106.setValue(yn6.a.e(r104, null, r105));
        r106.setExist(Boolean.valueOf(yn6.a.c(r104, r105)));
        CompletionBlock.DefaultImpls.onSuccess$default(r102, r106, null, 2, null);
    }
}
