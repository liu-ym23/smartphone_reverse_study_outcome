package so6;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends ro6.b {
    public b() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        ro6.b.InterfaceC7510b r103 = (ro6.b.InterfaceC7510b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getKey();
        String r105 = r103.getDomain();
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        Object r106 = r103.getValue();
        if (r105.length() != 0) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == true) goto L11;
        yn6.c r108 = yn6.a.f568561a;
        yn6.a.f(r104, r106, r105);
    L12:
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) ne7.e.b(ro6.b.c.class), null, 2, null);
        return;
    L11:
        yn6.c r109 = yn6.a.f568561a;
        yn6.a.f(r104, r106, "");
        goto L12
    L8:
        r107 = false;
        goto L9
    }
}
