package qc7;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import org.json.JSONObject;
import pc7.e;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "account.verify")
public final class d extends rc7.c {
    public d() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        JSONObject r103 = new JSONObject(((rc7.c.a) r101).getVerifyDecision());     // Catch: Exception -> L5
    L7:
        if (r103 != null) goto L10;
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, "decision is null or transform fail", null, 4, null);
        return;
    L10:
        if (e.c().i(r103, new c(r102)) == true) goto L16;
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, "start twice verify fail", null, 4, null);
        return;
    L16:
        return;
    L5:
        e = move-exception;
        pc7.d.b(5, "AccountVerifyMethod", "", e);
        r103 = null;
        goto L7
    }
}
