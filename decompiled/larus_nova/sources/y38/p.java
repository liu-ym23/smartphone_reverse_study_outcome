package y38;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.account.saas.FlowAccountSdk;
import com.larus.account.saas.jsb.core.FlowAccountPostLoginEventCore;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
@XBridgeMethod(name = "doubaoAccount.postLoginEvent", owner = "yangya.yjnull")
public final class p extends XCoreIDLBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "doubaoAccount.postLoginEvent")
    public final String f565891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f565892b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "event", required = true)
        String getEvent();

        @XBridgeParamField(isGetter = true, keyPath = WsConstants.KEY_PAYLOAD, required = false)
        Map<String, Object> getPayload();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
    }

    public p() {
        this.f565891a = "doubaoAccount.postLoginEvent";
        this.f565892b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f565892b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f565891a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        a r103 = (a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r104 = FlowAccountPostLoginEventCore.f286347a;
        String r105 = r103.getEvent();
        Map<String, Object> r106 = r103.getPayload();
        q r107 = new q(r102);
        Intrinsics.checkNotNullParameter(r107, "callback");
        if (r105 != null) goto L5;
    L7:
        r105 = null;
    L8:
        if (r105 != null) goto L10;
        FlowAccountPostLoginEventCore.Error r108 = FlowAccountPostLoginEventCore.Error.INVALID_EVENT;
        r107.a(new x38.a(r108.getCode(), r108.getMessage(), null));
        return;
    L10:
        SaasTracking r109 = SaasTracking.f286464a;
        if (r106 != null) goto L13;
        r106 = MapsKt.emptyMap();
    L13:
        r109.reportEvent(r105, new JSONObject(r106));
        if (Intrinsics.areEqual(r105, "profile_updated") == false) goto L16;
        FlowAccountSdk.e().a();
    L16:
        r107.onSuccess(Unit.INSTANCE);
        return;
    L5:
        if ((!StringsKt.isBlank(r105)) == false) goto L7;
        goto L7
    }
}
