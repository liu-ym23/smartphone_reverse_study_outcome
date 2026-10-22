package com.larus.dora.impl.bridge;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.ota.DoraOTAManagement;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@XBridgeMethod(name = "dora.debug.clearSilentOtaCount")
public final class e extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "dora.debug.clearSilentOtaCount")
    public final String f332069a;

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

    public e() {
        this.f332069a = "dora.debug.clearSilentOtaCount";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f332069a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((b) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        DoraDevice r103 = DoraAdapterExtKt.h(kj4.a.g());
        if (r103 == null) goto L5;
        DoraOTAManagement r104 = DoraOTAManagement.f334138a;
        Intrinsics.checkNotNullParameter(r103, "device");
        DoraOTAManagement.p().storeInt(r103.f204389mac + "_dora_ota_todayAutoOtaCount", 0);
        DoraOTAManagement.p().storeLong(r103.f204389mac + "_dora_ota_lastAutoOtaTime", 0);
        FLogger.f375446a.i("DoraClearSilentOtaCountMethod", "dora.debug.clearSilentOtaCount cleared silent OTA count for device: " + r103.f204389mac);
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) ne7.e.b(c.class), null, 2, null);
        return;
    L5:
        FLogger.f375446a.w("DoraClearSilentOtaCountMethod", "dora.debug.clearSilentOtaCount failed: no connected or history device found");
        r102.onFailure(0, "No connected or history device found", null);
    }
}
