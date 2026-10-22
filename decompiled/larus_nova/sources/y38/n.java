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
import com.larus.account.saas.FlowAccountSdk;
import com.larus.account.saas.jsb.core.FlowAccountMobileSmsLoginCore;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
@XBridgeMethod(name = "doubaoAccount.mobileSmsLogin", owner = "yangya.yjnull")
public final class n extends XCoreIDLBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "doubaoAccount.mobileSmsLogin")
    public final String f565888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f565889b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "captcha", required = true)
        String getCaptcha();

        @XBridgeParamField(isGetter = true, keyPath = "mobile", required = true)
        String getMobile();

        @XBridgeParamField(isGetter = true, keyPath = "smsCode", required = true)
        String getSmsCode();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
    }

    public n() {
        this.f565888a = "doubaoAccount.mobileSmsLogin";
        this.f565889b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f565889b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f565888a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        a r103 = (a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getMobile();
        String r105 = "";
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        String r106 = r103.getSmsCode();
        if (r106 == null) goto L10;
        r105 = r106;
    L10:
        if (StringsKt.isBlank(r104) == false) goto L13;
        r102.onFailure(-3, "mobile is empty", (XBaseResultModel) ne7.e.b(b.class));
        return;
    L13:
        if (StringsKt.isBlank(r105) == false) goto L15;
        r102.onFailure(-3, "smsCode is empty", (XBaseResultModel) ne7.e.b(b.class));
        return;
    L15:
        int r107 = FlowAccountMobileSmsLoginCore.f286345a;
        String r108 = r103.getCaptcha();
        o r109 = new o(r102);
        Intrinsics.checkNotNullParameter(r104, "mobile");
        Intrinsics.checkNotNullParameter(r105, "smsCode");
        Intrinsics.checkNotNullParameter(r109, "callback");
        FlowAccountSdk.c().a(r104, r105, r108, new com.larus.account.saas.jsb.core.f(r109));
    }
}
