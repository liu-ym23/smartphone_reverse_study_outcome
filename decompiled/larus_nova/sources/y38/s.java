package y38;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.larus.account.saas.jsb.core.FlowAccountVerifyCore;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
@XBridgeMethod(name = "doubaoAccount.setVerifyStatus", owner = "fengjingzhe")
public final class s extends rc7.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @XBridgeMethodName(name = "doubaoAccount.setVerifyStatus", params = {"status", "verifyWay", "verifyTicket", "verifyExtraParams", "extraBizParams"})
    public final String f565895c;

    public s() {
        this.f565895c = "doubaoAccount.setVerifyStatus";
    }

    @Override // rc7.b, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f565895c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        rc7.b.a r100 = (rc7.b.a) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        int r101 = FlowAccountVerifyCore.f286367a;
        Number r102 = r100.getAfid();
        Number r103 = r100.getStatus();
        String r104 = r100.getVerifyWay();
        String r105 = r100.getVerifyTicket();
        Map<String, Object> r106 = r100.getVerifyExtraParams();
        Map<String, Object> r113 = r100.getExtraBizParams();
        r r107 = new r(r112);
        Intrinsics.checkNotNullParameter(r107, "callback");
        int r108 = 0;
        if (r102 == null) goto L5;
        int r109 = r102.intValue();
    L6:
        if (r103 == null) goto L8;
        int r114 = r103.intValue();
    L9:
        JSONObject r115 = pc7.e.c().b(r109);
        if (r115 == null) goto L14;
        JSONObject r116 = r115.optJSONObject("event_params");
        if (r116 == null) goto L14;
        String r117 = r116.optString("verify_scene");
    L15:
        if (r117 != null) goto L17;
        r117 = "";
    L17:
        SaasTracking r118 = SaasTracking.f286464a;
        JSONObject r119 = new JSONObject();
        r119.put("flow_scene", "mfa_explicit_jsb_set_status");
        r119.put("afid", String.valueOf(r109));
        r119.put("verify_scene", r117);
        if (r104 == null) goto L20;
        r119.put("verify_way", r104);
    L20:
        r119.put("status", r114);
        if (r105 != null) goto L23;
    L24:
        r108 = 1;
    L25:
        r119.put("has_token", r108 ^ 1);
        Unit r120 = Unit.INSTANCE;
        r118.reportEvent("doubao_account_mfa_explicit_flow", r119);
        if (r114 == 0) goto L30;
        if (r114 == 1) goto L29;
        FlowAccountVerifyCore.Error r121 = FlowAccountVerifyCore.Error.INVALID_STATUS;
        r107.a(new x38.a(r121.getCode(), r121.getMessage(), null));
        pc7.e.c().d(r109, 1, "status=" + r103);
        return;
    L29:
        r107.onSuccess(Unit.INSTANCE);
        pc7.e.c().d(r109, 1, "status=1");
        return;
    L30:
        r107.onSuccess(Unit.INSTANCE);
        pc7.e.c().e(r109, r104, r105, r106, r113);
        return;
    L23:
        if (r105.length() != 0) goto L25;
    L14:
        r117 = null;
        goto L15
    L8:
        r114 = -1;
        goto L9
    L5:
        r109 = 0;
        goto L6
    }
}
