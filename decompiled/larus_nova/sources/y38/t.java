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
import com.larus.account.saas.FlowAccountSdk;
import com.larus.account.saas.jsb.core.FlowAccountThirdPartyAuthCore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@XBridgeMethod(name = "doubaoAccount.thirdPartyAuth", owner = "fengjingzhe")
public final class t extends XCoreIDLBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "doubaoAccount.thirdPartyAuth")
    public final String f565896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f565897b;

    @XBridgeParamModel
    public interface a extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "needRawData", required = false)
        Boolean getNeedRawData();

        @XBridgeParamField(isGetter = true, keyPath = "platform", required = true)
        String getPlatform();
    }

    @XBridgeResultModel
    public interface b extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "accessToken", required = false)
        String getAccessToken();

        @XBridgeParamField(isGetter = true, keyPath = "accessTokenSecret", required = false)
        String getAccessTokenSecret();

        @XBridgeParamField(isGetter = true, keyPath = "code", required = false)
        String getCode();

        @XBridgeParamField(isGetter = true, keyPath = "errorCode", required = false)
        Number getErrorCode();

        @XBridgeParamField(isGetter = true, keyPath = "expiresIn", required = false)
        String getExpiresIn();

        @XBridgeParamField(isGetter = true, keyPath = "openId", required = false)
        String getOpenId();

        @XBridgeParamField(isGetter = true, keyPath = "platform", required = false)
        String getPlatform();

        @XBridgeParamField(isGetter = true, keyPath = "platformAppId", required = false)
        String getPlatformAppId();

        @XBridgeParamField(isGetter = true, keyPath = "rawData", required = false)
        String getRawData();

        @XBridgeParamField(isGetter = false, keyPath = "accessToken", required = false)
        void setAccessToken(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "accessTokenSecret", required = false)
        void setAccessTokenSecret(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "code", required = false)
        void setCode(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "errorCode", required = false)
        void setErrorCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "expiresIn", required = false)
        void setExpiresIn(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "openId", required = false)
        void setOpenId(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "platform", required = false)
        void setPlatform(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "platformAppId", required = false)
        void setPlatformAppId(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "rawData", required = false)
        void setRawData(String r100);
    }

    public t() {
        this.f565896a = "doubaoAccount.thirdPartyAuth";
        this.f565897b = IDLXBridgeMethod.Access.SECURE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f565897b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f565896a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        a r103 = (a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r104 = FlowAccountThirdPartyAuthCore.f286349a;
        Activity r105 = r100.getOwnerActivity();
        String r106 = r103.getPlatform();
        u r107 = new u(r102);
        Intrinsics.checkNotNullParameter(r107, "callback");
        if (r105 != null) goto L5;
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.a("FlowAccountThirdPartyAuthCore", "owner activity is null, abort third party auth.");
        FlowAccountThirdPartyAuthCore.Error r108 = FlowAccountThirdPartyAuthCore.Error.ACTIVITY_NULL;
        r107.a(new x38.a(r108.getCode(), r108.getMessage(), null));
        return;
    L5:
        b48.d r109 = FlowAccountSdk.g().getConfig();
        if (r109 == null) goto L8;
        b48.i r110 = r109.f17610b;
    L9:
        if (r106 != null) goto L11;
    L52:
        FlowAccountThirdPartyAuthCore.Error r111 = FlowAccountThirdPartyAuthCore.Error.UNSUPPORTED_PLATFORM;
        r107.a(new x38.a(r111.getCode(), r111.getMessage(), null));
        return;
    L11:
        switch(r106.hashCode()) {
            case -1325936172: goto L41;
            case -1240244679: goto L32;
            case 3321844: goto L23;
            case 497130182: goto L14;
            default: goto L52;
        };
    L14:
        if (r106.equals("facebook") == false) goto L52;
        if (r110 == null) goto L18;
        b48.i.b r112 = r110.f17628c;
    L19:
        if (r112 != null) goto L21;
        FlowAccountThirdPartyAuthCore.Error r113 = FlowAccountThirdPartyAuthCore.Error.CONFIG_MISSING;
        r107.a(new x38.a(r113.getCode(), r113.getMessage(), null));
        return;
    L21:
        com.larus.account.saas.jsb.core.auth.d.a(r105, r112, r107);
        return;
    L18:
        r112 = null;
        goto L19
    L23:
        if (r106.equals("line") == false) goto L52;
        if (r110 == null) goto L27;
        b48.i.b r114 = r110.f17629d;
    L28:
        if (r114 != null) goto L30;
        FlowAccountThirdPartyAuthCore.Error r115 = FlowAccountThirdPartyAuthCore.Error.CONFIG_MISSING;
        r107.a(new x38.a(r115.getCode(), r115.getMessage(), null));
        return;
    L30:
        com.larus.account.saas.jsb.core.auth.g.a(r105, r114, r107);
        return;
    L27:
        r114 = null;
        goto L28
    L32:
        if (r106.equals("google") == false) goto L52;
        if (r110 == null) goto L36;
        b48.i.b r116 = r110.f17627b;
    L37:
        if (r116 != null) goto L39;
        FlowAccountThirdPartyAuthCore.Error r117 = FlowAccountThirdPartyAuthCore.Error.CONFIG_MISSING;
        r107.a(new x38.a(r117.getCode(), r117.getMessage(), null));
        return;
    L39:
        com.larus.account.saas.jsb.core.auth.f.a(r105, r116, r107);
        return;
    L36:
        r116 = null;
        goto L37
    L41:
        if (r106.equals("douyin") == false) goto L52;
        if (r110 == null) goto L45;
        b48.i.a r118 = r110.f17626a;
    L46:
        if (r118 != null) goto L54;
        FlowAccountThirdPartyAuthCore.Error r119 = FlowAccountThirdPartyAuthCore.Error.CONFIG_MISSING;
        r107.a(new x38.a(r119.getCode(), r119.getMessage(), null));
        return;
    L54:
        com.larus.account.saas.jsb.core.auth.c.a(r105, r118, r107);     // Catch: LinkageError -> L50
        return;
    L50:
        e = move-exception;
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.b("FlowAccountThirdPartyAuthCore", "douyin authorize service dependency is unavailable.", e);
        FlowAccountThirdPartyAuthCore.Error r120 = FlowAccountThirdPartyAuthCore.Error.SERVICE_UNAVAILABLE;
        r107.a(new x38.a(r120.getCode(), r120.getMessage(), e));
        return;
    L45:
        r118 = null;
        goto L46
    L8:
        r110 = null;
        goto L9
    }
}
