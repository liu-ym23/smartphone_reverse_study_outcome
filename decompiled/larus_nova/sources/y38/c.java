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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
@XBridgeMethod(name = "doubaoAccount.getLoginContext", owner = "yangya.yjnull")
public final class c extends XCoreIDLBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "doubaoAccount.getLoginContext")
    public final String f565871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f565872b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "clientAppName", required = true)
        String getClientAppName();

        @XBridgeParamField(isGetter = true, keyPath = "privacyPolicyUrl", required = true)
        String getPrivacyPolicyUrl();

        @XBridgeParamField(isGetter = true, keyPath = "serviceAgreementUrl", required = true)
        String getServiceAgreementUrl();

        @XBridgeParamField(isGetter = false, keyPath = "clientAppName", required = true)
        void setClientAppName(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "privacyPolicyUrl", required = true)
        void setPrivacyPolicyUrl(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "serviceAgreementUrl", required = true)
        void setServiceAgreementUrl(String r100);
    }

    public c() {
        this.f565871a = "doubaoAccount.getLoginContext";
        this.f565872b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f565872b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f565871a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((a) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r103 = com.larus.account.saas.jsb.core.a.f286369a;
        com.larus.account.saas.runtime.internal.delegate.b r104 = com.larus.account.saas.runtime.internal.delegate.c.f286470a;
        com.larus.account.saas.runtime.internal.delegate.b r105 = com.larus.account.saas.runtime.internal.delegate.c.f286470a;
        if (r105 != null) goto L24;
        d48.d r106 = c48.a.f22412a;
        d48.d r107 = c48.a.f22412a;
        if (r107 == null) goto L8;
        r107.a();
        String r108 = Integer.valueOf(com.larus.init.task.accountsdk.a.f351133a.a()).toString();
    L10:
        if (Intrinsics.areEqual(r108, "401734") == false) goto L22;
        d48.d r109 = c48.a.f22412a;
        if (r109 == null) goto L15;
        r109.f();
        d48.f.b r110 = com.larus.init.task.accountsdk.d.f351138b.a("account_saas_login_context");
    L16:
        String r111 = r110.getString("app_name");
        String r112 = r110.getString("service_agreement_url");
        String r113 = r110.getString("privacy_policy_url");
        if (StringsKt.isBlank(r111) == true) goto L19;
    L23:
        com.larus.account.saas.runtime.internal.delegate.b r114 = new com.larus.account.saas.runtime.internal.delegate.b(r111, new com.larus.account.saas.runtime.internal.delegate.d("服务协议", r112), new com.larus.account.saas.runtime.internal.delegate.d("隐私政策", r113));
        com.larus.account.saas.runtime.internal.delegate.c.f286470a = r114;
        r105 = r114;
        goto L24
    L19:
        if (StringsKt.isBlank(r112) == false) goto L23;
        if (StringsKt.isBlank(r113) == false) goto L23;
    L15:
        d48.f.f466833a.getClass();
        d48.f.a r115 = d48.f.a.f466834a;
        Intrinsics.checkNotNullParameter("account_saas_login_context", "repoName");
        r110 = d48.f.a.b.f466835a;
    L22:
        r105 = null;
        goto L24
    L8:
        r108 = null;
    L24:
        String r116 = "";
        if (r105 == null) goto L33;
        String r117 = r105.f286467a;
        if (r117 == null) goto L33;
        if ((!StringsKt.isBlank(r117)) == true) goto L32;
        r117 = null;
    L32:
        if (r117 == null) goto L33;
    L41:
        if (r105 == null) goto L46;
        com.larus.account.saas.runtime.internal.delegate.d r118 = r105.f286468b;
        if (r118 == null) goto L46;
        String r119 = r118.f286472b;
        if (r119 == null) goto L46;
    L47:
        if (r105 == null) goto L54;
        com.larus.account.saas.runtime.internal.delegate.d r120 = r105.f286469c;
        if (r120 == null) goto L54;
        String r121 = r120.f286472b;
        if (r121 == null) goto L54;
        r116 = r121;
    L54:
        Intrinsics.checkNotNullParameter(r117, "clientAppName");
        Intrinsics.checkNotNullParameter(r119, "serviceAgreementUrl");
        Intrinsics.checkNotNullParameter(r116, "privacyPolicyUrl");
        XBaseModel r122 = ne7.e.b(b.class);
        b r123 = (b) r122;
        r123.setClientAppName(r117);
        r123.setServiceAgreementUrl(r119);
        r123.setPrivacyPolicyUrl(r116);
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) r122, null, 2, null);
        return;
    L46:
        r119 = "";
    L33:
        b48.d r124 = FlowAccountSdk.g().getConfig();
        if (r124 == null) goto L38;
        b48.a r125 = r124.f17609a;
        if (r125 == null) goto L38;
        r117 = r125.f17588a;
    L39:
        if (r117 != null) goto L41;
        r117 = "";
    L38:
        r117 = null;
        goto L39
    }
}
