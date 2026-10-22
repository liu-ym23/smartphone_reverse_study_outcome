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
import com.larus.account.saas.jsb.core.FlowAccountUnbindCore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@XBridgeMethod(name = "doubaoAccount.unbindPlatform", owner = "fengjingzhe")
public final class x extends XCoreIDLBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "doubaoAccount.unbindPlatform")
    public final String f565902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f565903b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "platform", required = true)
        String getPlatform();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "errorCode", required = true)
        Number getErrorCode();

        @XBridgeParamField(isGetter = true, keyPath = "errorMsg", required = true)
        String getErrorMessage();

        @XBridgeParamField(isGetter = true, keyPath = "success", required = true)
        Number getSuccess();

        @XBridgeParamField(isGetter = false, keyPath = "errorCode", required = true)
        void setErrorCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "errorMsg", required = true)
        void setErrorMessage(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "success", required = true)
        void setSuccess(Number r100);
    }

    public x() {
        this.f565902a = "doubaoAccount.unbindPlatform";
        this.f565903b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f565903b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f565902a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        a r103 = (a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r104 = FlowAccountUnbindCore.f286362a;
        String r105 = r103.getPlatform();
        y r106 = new y(r102);
        Intrinsics.checkNotNullParameter(r106, "callback");
        String r107 = "apple";
        if (Intrinsics.areEqual(r105, "douyin") == true) goto L8;
        if (Intrinsics.areEqual(r105, "apple") == true) goto L8;
        FlowAccountUnbindCore.Error r108 = FlowAccountUnbindCore.Error.UNSUPPORTED_PLATFORM;
        r106.a(new x38.a(r108.getCode(), r108.getMessage(), null));
        return;
    L8:
        if (Intrinsics.areEqual(r105, "douyin") == false) goto L10;
        r107 = "aweme_v2";
    L10:
        FlowAccountSdk.a().a(r107, new com.larus.account.saas.jsb.core.g(r106));
    }
}
