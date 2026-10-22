package com.larus.dora.impl.bridge;

import android.content.Intent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
@XBridgeMethod(name = "dora.base.openWeb")
public final class u extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "dora.base.openWeb")
    public final String f332116a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "url", required = true)
        String getUrl();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "opened", required = false)
        Boolean getOpened();

        @XBridgeParamField(isGetter = false, keyPath = "opened", required = false)
        void setOpened(Boolean r100);
    }

    static {
    }

    public u() {
        this.f332116a = "dora.base.openWeb";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f332116a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        b r103 = (b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getUrl();
        boolean r105 = false;
        if (r104 != null) goto L5;
    L8:
        boolean r106 = true;
    L9:
        if (r106 == false) goto L11;
    L18:
        r102.onFailure(-3, "url must be http/https", (XBaseResultModel) ne7.e.b(c.class));
        return;
    L11:
        if (StringsKt.startsWith(r104, "https://", true) == false) goto L13;
    L14:
        r105 = true;
    L15:
        if (r105 == false) goto L18;
        int r107 = t.f332115a;
        Intrinsics.checkNotNullParameter(r104, "url");
        boolean r108 = t.a(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r104)), r104);
        FLogger.f375446a.i("DoraOpenWebMethod", "dora.base.openWeb opened=" + r108);
        XBaseModel r109 = ne7.e.b(c.class);
        ((c) r109).setOpened(Boolean.valueOf(r108));
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) r109, null, 2, null);
        return;
    L13:
        if (StringsKt.startsWith(r104, "http://", true) == false) goto L15;
    L5:
        if (StringsKt.isBlank(r104) == true) goto L8;
        r106 = false;
        goto L9
    }
}
