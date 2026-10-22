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
import com.larus.account.saas.jsb.core.FlowAccountMobileSendCodeCore;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
@XBridgeMethod(name = "doubaoAccount.mobileSendCode", owner = "yangya.yjnull")
public final class l extends XCoreIDLBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "doubaoAccount.mobileSendCode")
    public final String f565885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f565886b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "mobile", required = true)
        String getMobile();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "errorCode", required = false)
        Number getXErrorCode();

        @XBridgeParamField(isGetter = true, keyPath = "errorMessage", required = false)
        String getXErrorMessage();

        @XBridgeParamField(isGetter = false, keyPath = "errorCode", required = false)
        void setXErrorCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "errorMessage", required = false)
        void setXErrorMessage(String r100);
    }

    public l() {
        this.f565885a = "doubaoAccount.mobileSendCode";
        this.f565886b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f565886b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f565885a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        a r103 = (a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getMobile();
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        String r105 = r104;
        if (StringsKt.isBlank(r105) == false) goto L8;
        r102.onFailure(-3, "mobile is empty", (XBaseResultModel) ne7.e.b(b.class));
        return;
    L8:
        int r106 = FlowAccountMobileSendCodeCore.f286343a;
        m r107 = new m(r102);
        Intrinsics.checkNotNullParameter(r105, "mobile");
        Intrinsics.checkNotNullParameter(r107, "callback");
        FlowAccountSdk.c().b(r105, new com.larus.account.saas.jsb.core.e(r107), false, false, true);
    }
}
