package y38;

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
import com.larus.account.saas.jsb.core.FlowAccountTrackCore;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
@XBridgeMethod(name = "doubaoAccount.track", owner = "fengjingzhe")
public final class v extends XCoreIDLBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "doubaoAccount.track")
    public final String f565899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f565900b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "event", required = true)
        String getEvent();

        @XBridgeParamField(isGetter = true, keyPath = "params", required = false)
        Map<String, Object> getParams();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
    }

    public v() {
        this.f565899a = "doubaoAccount.track";
        this.f565900b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f565900b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f565899a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        a r103 = (a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r104 = FlowAccountTrackCore.f286360a;
        String r105 = r103.getEvent();
        Map<String, Object> r106 = r103.getParams();
        w r107 = new w(r102);
        Intrinsics.checkNotNullParameter(r107, "callback");
        if (r105 != null) goto L5;
    L8:
        boolean r108 = true;
    L9:
        if (r108 == false) goto L11;
        FlowAccountTrackCore.Error r109 = FlowAccountTrackCore.Error.INVALID_EVENT;
        r107.a(new x38.a(r109.getCode(), r109.getMessage(), null));
        return;
    L11:
        SaasTracking r110 = SaasTracking.f286464a;
        if (r106 != null) goto L14;
        r106 = MapsKt.emptyMap();
    L14:
        r110.reportEvent(r105, new JSONObject(r106));
        r107.onSuccess(Unit.INSTANCE);
        return;
    L5:
        if (StringsKt.isBlank(r105) == true) goto L8;
        r108 = false;
        goto L9
    }
}
