package qc7;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;
import pc7.e;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "account.getVerifyDecision")
public final class a extends rc7.a {
    public a() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        Number r100 = ((rc7.a.InterfaceC7459a) r111).getAfid();
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L6:
        JSONObject r102 = e.c().b(r101);
        if (r102 != null) goto L23;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "decision is null, or not in twice verify flow", null, 4, null);
        return;
    L23:
        Map<String, Object> r103 = ConvertUtils.INSTANCE.jsonToMap(r102);     // Catch: Exception -> L19
        LinkedHashMap r104 = new LinkedHashMap();     // Catch: Exception -> L19
        Iterator<Map.Entry<String, Object>> r105 = r103.entrySet().iterator();     // Catch: Exception -> L19
    L10:
        if (r105.hasNext() == false) goto L17;
        Map.Entry<String, Object> r106 = r105.next();     // Catch: Exception -> L19
        if (r106.getValue() == null) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == false) goto L10;
        r104.put(r106.getKey(), r106.getValue());     // Catch: Exception -> L19
        goto L10
    L14:
        r107 = false;
        goto L15
    L17:
        XBaseModel r108 = XBridgeResultModelArguments.INSTANCE.createModel(rc7.a.b.class);     // Catch: Exception -> L19
        ((rc7.a.b) r108).setVerifyDecision(r104);     // Catch: Exception -> L19
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (rc7.a.b) r108, null, 2, null);     // Catch: Exception -> L19
        return;
    L19:
        e = move-exception;
        pc7.d.b(5, "AccountGetVerifyDecisionMethod", "", e);
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "crash while parsing decisions", null, 4, null);
        return;
    L5:
        r101 = 0;
        goto L6
    }
}
