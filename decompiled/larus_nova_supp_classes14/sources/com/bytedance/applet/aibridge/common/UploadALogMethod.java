package com.bytedance.applet.aibridge.common;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.utils.logger.FLogger;
import e3.d;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/common/UploadALogMethod;", "Lcom/bytedance/applet/aibridge/common/AbsUploadALogMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/common/AbsUploadALogMethodIDL$UploadALogMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/common/AbsUploadALogMethodIDL$UploadALogMethodResultModel;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UploadALogMethod extends AbsUploadALogMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public UploadALogMethod() {
    }

    public final void handle(d r8, ParamModel r9, final h r10) {
        final AbsUploadALogMethodIDL.a r11 = (AbsUploadALogMethodIDL.a) r9;
        Intrinsics.checkNotNullParameter(r8, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        FLogger r0 = FLogger.a;
        r0.i("UploadALogMethod", "uploadALog triggered, scene: " + r11.getScene() + ", duration: " + (r11.getEndTime() - r11.getStartTime()) + ", startTime: " + r11.getStartTime() + ", endTime: " + r11.getEndTime());
        r0.k(r11.getScene(), r11.getStartTime(), r11.getEndTime(), new gv3.a(r10, r11));
    }
}
