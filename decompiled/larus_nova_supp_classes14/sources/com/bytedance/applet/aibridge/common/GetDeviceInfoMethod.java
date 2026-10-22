package com.bytedance.applet.aibridge.common;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.platform.api.j2;
import com.larus.platform.service.DoraAudioService;
import com.larus.utils.logger.FLogger;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/common/GetDeviceInfoMethod;", "Lcom/bytedance/applet/aibridge/common/AbsGetDeviceInfoMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/common/AbsGetDeviceInfoMethodIDL$GetDeviceInfoMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/common/AbsGetDeviceInfoMethodIDL$GetDeviceInfoMethodResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetDeviceInfoMethod extends AbsGetDeviceInfoMethodIDL {
    public GetDeviceInfoMethod() {
    }

    public final void handle(d r4, ParamModel r5, h r6) {
        Intrinsics.checkNotNullParameter(r4, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetDeviceInfoMethodIDL.a) r5, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Intrinsics.checkNotNullParameter(AbsGetDeviceInfoMethodIDL.b.class, "<this>");
        AbsGetDeviceInfoMethodIDL.b r7 = c.a(AbsGetDeviceInfoMethodIDL.b.class);
        AbsGetDeviceInfoMethodIDL.b r8 = r7;
        j2 r0 = DoraAudioService.c();
        if (r0 == null) goto L5;
        int r1 = r0.getProductId();
    L6:
        r8.setProductId(Integer.valueOf(r1));
        FLogger.a.i("GetDeviceInfoMethod", "productId is " + r8.getProductId());
        r6.b(r7, "");
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
