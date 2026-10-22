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
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
@XBridgeMethod(name = "dora.base.openApp")
public final class s extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "dora.base.openApp")
    public final String f332114a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "pkg", required = false)
        String getPkg();

        @XBridgeParamField(isGetter = true, keyPath = "probeScheme", required = false)
        String getProbeScheme();

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

    public s() {
        this.f332114a = "dora.base.openApp";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f332114a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        b r103 = (b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getUrl();
        String r105 = r103.getPkg();
        boolean r106 = false;
        if (r104 != null) goto L5;
    L8:
        boolean r107 = true;
    L10:
        if (r107 == false) goto L12;
        r102.onFailure(-3, "url is required", (XBaseResultModel) ne7.e.b(c.class));
        return;
    L12:
        if (r105 != null) goto L14;
    L15:
        r106 = true;
    L16:
        if (r106 == false) goto L18;
        r102.onFailure(-3, "pkg is required on android", (XBaseResultModel) ne7.e.b(c.class));
        return;
    L18:
        int r108 = t.f332115a;
        Intrinsics.checkNotNullParameter(r104, "url");
        boolean r109 = t.a(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r104)).setPackage(r105), r104);
        FLogger.f375446a.i("DoraOpenAppMethod", "dora.base.openApp pkg=" + r105 + " opened=" + r109);
        c r110 = (c) ne7.e.b(c.class);
        r110.setOpened(Boolean.valueOf(r109));
        CompletionBlock.DefaultImpls.onSuccess$default(r102, r110, null, 2, null);
        return;
    L14:
        if (StringsKt.isBlank(r105) == false) goto L16;
    L5:
        if (StringsKt.isBlank(r104) == true) goto L8;
        r107 = false;
        goto L10
    }
}
