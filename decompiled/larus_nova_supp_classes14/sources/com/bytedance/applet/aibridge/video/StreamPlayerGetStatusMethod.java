package com.bytedance.applet.aibridge.video;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.utils.g;
import com.larus.audioplayer.api.stream.AudioStreamPlayerDelegate;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/video/StreamPlayerGetStatusMethod;", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgeGetStatusMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgeGetStatusMethodIDL$GetStatusParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgeGetStatusMethodIDL$GetStatusResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StreamPlayerGetStatusMethod extends AbsAIBridgeGetStatusMethodIDL {
    public StreamPlayerGetStatusMethod() {
    }

    public final void handle(d r5, ParamModel r6, h r7) {
        AbsAIBridgeGetStatusMethodIDL.a r8 = (AbsAIBridgeGetStatusMethodIDL.a) r6;
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "callback");
        AudioStreamPlayerDelegate r9 = AudioStreamPlayerDelegate.b;
        Pair r0 = r9.h();
        if (r0 == null) goto L5;
        String r1 = (String) r0.getSecond();
    L7:
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        String r10 = r9.d(r8.getUuid());
        g.a.i("flow.getStreamAudioPlayStatus", "StreamPlayerGetStatusMethod was called. result = " + r10);
        Intrinsics.checkNotNullParameter(AbsAIBridgeGetStatusMethodIDL.b.class, "<this>");
        AbsAIBridgeGetStatusMethodIDL.b r11 = c.a(AbsAIBridgeGetStatusMethodIDL.b.class);
        r11.setUuid(r1);
        r11.setCurStatus(r10);
        r7.b(r11, "");
        return;
    L5:
        r1 = null;
        goto L7
    }
}
