package qc7;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import kotlin.jvm.internal.Intrinsics;
import pc7.e;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "account.setVerifyStatus")
public final class b extends rc7.b {
    public b() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        rc7.b.a r113 = (rc7.b.a) r111;
        Number r114 = r113.getAfid();
        if (r114 == null) goto L5;
        int r100 = r114.intValue();
    L6:
        Number r115 = r113.getStatus();
        if (Intrinsics.areEqual(r115, 0) == false) goto L10;
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) XBridgeResultModelArguments.INSTANCE.createModel(rc7.b.InterfaceC7460b.class), null, 2, null);
        e.c().e(r100, r113.getVerifyWay(), r113.getVerifyTicket(), r113.getVerifyExtraParams(), r113.getExtraBizParams());
        return;
    L10:
        if (Intrinsics.areEqual(r115, 1) == false) goto L12;
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) XBridgeResultModelArguments.INSTANCE.createModel(rc7.b.InterfaceC7460b.class), null, 2, null);
        e.c().d(r100, 1, "status=1");
        return;
    L12:
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "status error", null, 4, null);
        e.c().d(r100, 1, "status=" + r113.getStatus());
        return;
    L5:
        r100 = 0;
        goto L6
    }
}
