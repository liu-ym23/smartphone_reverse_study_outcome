package com.larus.dora.impl.bridge;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@XBridgeMethod(name = "dora.debug.downloadEarbudsTrace")
public final class i extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "dora.debug.downloadEarbudsTrace")
    public final String f332097a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
    }

    static {
    }

    public i() {
        this.f332097a = "dora.debug.downloadEarbudsTrace";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f332097a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter((b) r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        IDoraService r113 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r113 != null) goto L5;
        FLogger.f375446a.w("DoraDeviceDownloadEarbudsTraceMethod", "dora.debug.downloadEarbudsTrace IDoraService is null");
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "dora service not found", null, 4, null);
        return;
    L5:
        j r100 = new j(r113, new k());
        IDoraService.c.a(r113, 2, r100, false, false, false, 20);
        IDoraService.c.a(r113, 3, r100, false, false, true, 4);
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) ne7.e.b(c.class), null, 2, null);
    }
}
