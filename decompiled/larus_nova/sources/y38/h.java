package y38;

import android.app.Activity;
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
import com.larus.account.saas.jsb.core.FlowAccountLoadingCore;
import com.larus.account.saas.ui.IAccountLoadingUiService;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
@XBridgeMethod(name = "doubaoAccount.loading", owner = "fengjingzhe")
public final class h extends XCoreIDLBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "doubaoAccount.loading")
    public final String f565879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f565880b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "show", required = true)
        Number getShow();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
    }

    public h() {
        this.f565879a = "doubaoAccount.loading";
        this.f565880b = IDLXBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f565880b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f565879a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        a r103 = (a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r104 = FlowAccountLoadingCore.f286339a;
        Activity r105 = r100.getOwnerActivity();
        boolean r106 = false;
        boolean r107 = true;
        if (r103.getShow().intValue() == 1) goto L6;
        r107 = false;
    L6:
        i r108 = new i(r102);
        Intrinsics.checkNotNullParameter(r108, "callback");
        if (r105 == null) goto L12;
        if (r107 == false) goto L11;
        r106 = IAccountLoadingUiService.f286553c.showLoading(r105);
        goto L12
    L11:
        r106 = IAccountLoadingUiService.f286553c.d(r105);
    L12:
        if (r106 == false) goto L14;
        r108.onSuccess(Unit.INSTANCE);
        return;
    L14:
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.a("FlowAccountLoadingCore", "current activity " + r105 + " is illegal, Abort.");
        FlowAccountLoadingCore.Error r109 = FlowAccountLoadingCore.Error.NOT_HANDLED;
        int r110 = r109.getCode();
        c48.a.a().a();
        String r111 = com.larus.init.task.accountsdk.a.f351133a.getApplication().getString(R.string.larus_accountsdk_auth_screen_error_desc);
        if (StringsKt.isBlank(r111) == false) goto L17;
        r111 = r109.getMessage();
    L17:
        r108.a(new x38.a(r110, r111, null));
    }
}
