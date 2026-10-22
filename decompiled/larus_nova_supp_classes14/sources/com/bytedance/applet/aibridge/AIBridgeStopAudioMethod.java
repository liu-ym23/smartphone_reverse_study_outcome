package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.audioplayer.api.news.NewsUrlAudioManagerDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgeStopAudioMethod;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeStopAudioMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsAIBridgeStopAudioMethodIDL$StopAudioParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeStopAudioMethodIDL$StopAudioResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeStopAudioMethod extends AbsAIBridgeStopAudioMethodIDL {
    public AIBridgeStopAudioMethod() {
    }

    public final void handle(e3.d r3, ParamModel r4, f3.h r5) {
        AbsAIBridgeStopAudioMethodIDL.a r6 = (AbsAIBridgeStopAudioMethodIDL.a) r4;
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        if (NewsUrlAudioManagerDelegate.b.d(r6.getUrl(), Integer.valueOf(r6.getSourceType()), r6.getVideoModel()) == false) goto L5;
        Intrinsics.checkNotNullParameter(AbsAIBridgeStopAudioMethodIDL.b.class, "<this>");
        r5.b(k3.c.a(AbsAIBridgeStopAudioMethodIDL.b.class), "");
        return;
    L5:
        f3.h.a.a(r5, "The target url does not match the current url  when onStop", null, null, 14);
    }
}
