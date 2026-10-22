package com.bytedance.applet.aibridge.video;

import c68.b;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.audioplayer.api.stream.AudioStreamPlayerDelegate;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/video/StreamPlayStopMethod;", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgeStopStreamMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgeStopStreamMethodIDL$StreamStopParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgeStopStreamMethodIDL$StreamStopResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StreamPlayStopMethod extends AbsAIBridgeStopStreamMethodIDL {
    public StreamPlayStopMethod() {
    }

    public final void handle(d r3, ParamModel r4, h r5) {
        AbsAIBridgeStopStreamMethodIDL.a r6 = (AbsAIBridgeStopStreamMethodIDL.a) r4;
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        String r7 = r6.getUuid();
        int r8 = b.a;
        b.d("AudioStream:JSB", "StreamPlayStopMethod called: uuid=" + r7);
        AudioStreamPlayerDelegate.b.a(r7, "bridge_call");
        b.d("AudioStream:JSB", "AudioStreamPlayerDelegate.stop called");
        Intrinsics.checkNotNullParameter(AbsAIBridgeStopStreamMethodIDL.b.class, "<this>");
        r5.b(c.a(AbsAIBridgeStopStreamMethodIDL.b.class), "");
    }
}
