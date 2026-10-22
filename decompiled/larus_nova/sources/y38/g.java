package y38;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.larus.account.saas.jsb.core.FlowAccountVerifyCore;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
@XBridgeMethod(name = "doubaoAccount.getVerifyDecision", owner = "fengjingzhe")
public final class g extends rc7.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeMethodName(name = "doubaoAccount.getVerifyDecision", params = {""}, results = {"verifyDecision"})
    public final String f565878c;

    public g() {
        this.f565878c = "doubaoAccount.getVerifyDecision";
    }

    @Override // rc7.a, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f565878c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        rc7.a.InterfaceC7459a r103 = (rc7.a.InterfaceC7459a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r104 = FlowAccountVerifyCore.f286367a;
        Number r105 = r103.getAfid();
        f r106 = new f(r102);
        Intrinsics.checkNotNullParameter(r106, "callback");
        if (r105 == null) goto L5;
        int r107 = r105.intValue();
    L6:
        JSONObject r108 = pc7.e.c().b(r107);
        if (r108 == null) goto L11;
        JSONObject r109 = r108.optJSONObject("event_params");
        if (r109 == null) goto L11;
        String r110 = r109.optString("verify_scene");
    L12:
        if (r110 != null) goto L14;
        r110 = "";
    L14:
        if (r108 != null) goto L34;
        FlowAccountVerifyCore.a(r107, r110, 0);
        FlowAccountVerifyCore.Error r111 = FlowAccountVerifyCore.Error.DECISION_NOT_FOUND;
        r106.a(new x38.a(r111.getCode(), r111.getMessage(), null));
        return;
    L34:
        Map<String, Object> r112 = com.larus.account.saas.jsb.core.h.b(r108);     // Catch: Exception -> L31
        LinkedHashMap r113 = new LinkedHashMap();     // Catch: Exception -> L31
        Iterator r114 = ((LinkedHashMap) r112).entrySet().iterator();     // Catch: Exception -> L31
    L17:
        boolean r115 = true;
        if (r114.hasNext() == false) goto L25;
        Map.Entry r116 = (Map.Entry) r114.next();     // Catch: Exception -> L31
        if (r116.getValue() != null) goto L23;
        r115 = false;
    L23:
        if (r115 == false) goto L17;
        r113.put(r116.getKey(), r116.getValue());     // Catch: Exception -> L31
        goto L17
    L25:
        LinkedHashMap r117 = new LinkedHashMap(MapsKt.mapCapacity(r113.size()));     // Catch: Exception -> L31
        Iterator r118 = r113.entrySet().iterator();     // Catch: Exception -> L31
    L27:
        if (r118.hasNext() == false) goto L29;
        Object r119 = r118.next();     // Catch: Exception -> L31
        Object r120 = ((Map.Entry) r119).getKey();     // Catch: Exception -> L31
        Object r121 = ((Map.Entry) r119).getValue();     // Catch: Exception -> L31
        Intrinsics.checkNotNull(r121);     // Catch: Exception -> L31
        r117.put(r120, r121);     // Catch: Exception -> L31
        goto L27
    L29:
        FlowAccountVerifyCore.a(r107, r110, 1);     // Catch: Exception -> L31
        r106.onSuccess(r117);     // Catch: Exception -> L31
        return;
    L31:
        e = move-exception;
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.g("FlowAccountVerifyCore", "catch exception while parsing decisions", e);
        FlowAccountVerifyCore.a(r107, r110, 0);
        FlowAccountVerifyCore.Error r122 = FlowAccountVerifyCore.Error.DECISION_PARSE_FAILED;
        r106.a(new x38.a(r122.getCode(), r122.getMessage(), e));
        return;
    L11:
        r110 = null;
        goto L12
    L5:
        r107 = 0;
        goto L6
    }
}
