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
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.account.saas.runtime.internal.delegate.SaasSettings;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
@XBridgeMethod(name = "doubaoAccount.getSdkSettings", owner = "fengjingzhe")
public final class e extends XCoreIDLBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "doubaoAccount.getSdkSettings")
    public final String f565875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f565876b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "settingKey", required = true)
        String getSettingsKey();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "value", required = true)
        Object getValue();

        @XBridgeParamField(isGetter = false, keyPath = "value", required = true)
        void setValue(Object r100);
    }

    public e() {
        this.f565875a = "doubaoAccount.getSdkSettings";
        this.f565876b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f565876b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f565875a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        a r102 = (a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        XBaseModel r103 = ne7.e.b(b.class);
        b r104 = (b) r103;
        int r105 = com.larus.account.saas.jsb.core.c.f286390a;
        String r106 = r102.getSettingsKey();
        Intrinsics.checkNotNullParameter(r106, "settingsKey");
        SaasSettings r107 = SaasSettings.f286462a;
        Lazy r108 = SaasSettings.f286463b;
        Object r109 = ((d48.e) r108.getValue()).a("sdk_key_flow_account", new JSONObject()).optJSONObject(r106);
        if (r109 != null) goto L5;
        r109 = "";
    L5:
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.d("FlowAccountGetSettingsCore", "[doubaoAccount.getSdkSettings] params.settingsKey=" + r106 + ", value=" + r109 + ", SaasSettings.getSdkSettings()=" + ((d48.e) r108.getValue()).a("sdk_key_flow_account", new JSONObject()));
        r104.setValue(r109);
        CompletionBlock.DefaultImpls.onSuccess$default(r110, (XBaseResultModel) r103, null, 2, null);
    }
}
