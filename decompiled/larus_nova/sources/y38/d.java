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
import com.larus.account.saas.FlowAccountSdk;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
@XBridgeMethod(name = "doubaoAccount.getNetworkInfo", owner = "fengjingzhe")
public final class d extends XCoreIDLBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "doubaoAccount.getNetworkInfo")
    public final String f565873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f565874b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "domain", required = true)
        String getDomain();

        @XBridgeParamField(isGetter = true, keyPath = "sdkParams", required = true)
        Map<String, String> getSdkParams();

        @XBridgeParamField(isGetter = false, keyPath = "domain", required = true)
        void setDomain(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "sdkParams", required = true)
        void setSdkParams(Map<String, String> r100);
    }

    public d() {
        this.f565873a = "doubaoAccount.getNetworkInfo";
        this.f565874b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f565874b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f565873a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((a) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r103 = com.larus.account.saas.jsb.core.b.f286389a;
        b48.d r104 = FlowAccountSdk.g().getConfig();
        if (r104 == null) goto L12;
        b48.a r105 = r104.f17609a;
        if (r105 == null) goto L12;
        String r106 = r105.f17589b;
        if (r106 == null) goto L12;
        if (StringsKt.startsWith$default(r106, "https://", false, 2, null) == true) goto L13;
        r106 = "https://".concat(r106);
    L13:
        Map<String, String> r107 = FlowAccountSdk.f().getCommonParams();
        XBaseModel r108 = ne7.e.b(b.class);
        b r109 = (b) r108;
        r109.setDomain(r106);
        r109.setSdkParams(r107);
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) r108, null, 2, null);
        return;
    L12:
        r106 = null;
        goto L13
    }
}
