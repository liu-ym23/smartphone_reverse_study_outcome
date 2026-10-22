package com.bytedance.applet.aibridge.video;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.audioplayer.api.stream.AudioStreamPlayerDelegate;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/video/StreamPlayChangeSpeedMethod;", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgeChangeSpeedMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgeChangeSpeedMethodIDL$StreamChangeSpeedParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgeChangeSpeedMethodIDL$StreamChangeSpeedResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StreamPlayChangeSpeedMethod extends AbsAIBridgeChangeSpeedMethodIDL {
    public StreamPlayChangeSpeedMethod() {
    }

    public final void handle(d r2, ParamModel r3, h r4) {
        AbsAIBridgeChangeSpeedMethodIDL.a r5 = (AbsAIBridgeChangeSpeedMethodIDL.a) r3;
        Intrinsics.checkNotNullParameter(r2, "bridgeContext");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        String r6 = r5.getUuid();
        Float r7 = StringsKt.toFloatOrNull(r5.getSpeed());
        if (r7 == null) goto L5;
        float r8 = r7.floatValue();
    L6:
        AudioStreamPlayerDelegate.b.k(r6, r8);
        Intrinsics.checkNotNullParameter(AbsAIBridgeChangeSpeedMethodIDL.b.class, "<this>");
        r4.b(c.a(AbsAIBridgeChangeSpeedMethodIDL.b.class), "");
        return;
    L5:
        r8 = 1.0f;
        goto L6
    }
}
