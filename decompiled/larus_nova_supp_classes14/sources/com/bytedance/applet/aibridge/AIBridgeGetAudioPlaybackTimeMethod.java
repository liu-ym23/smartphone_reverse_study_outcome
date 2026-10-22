package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.audioplayer.api.news.NewsUrlAudioManagerDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgeGetAudioPlaybackTimeMethod;", "Lcom/bytedance/applet/aibridge/AbsGetAudioPlaybackTimeMethod;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsGetAudioPlaybackTimeMethod$GetAudioPlaybackTimeMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsGetAudioPlaybackTimeMethod$GetAudioPlaybackTimeMethodResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeGetAudioPlaybackTimeMethod extends AbsGetAudioPlaybackTimeMethod {
    public final String getName() {
        return "applet.getAudioPlaybackTime";
    }

    public AIBridgeGetAudioPlaybackTimeMethod() {
    }

    public final void handle(e3.d r2, ParamModel r3, f3.h r4) {
        Intrinsics.checkNotNullParameter(r2, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetAudioPlaybackTimeMethod.a) r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(AbsGetAudioPlaybackTimeMethod.b.class, "<this>");
        AbsGetAudioPlaybackTimeMethod.b r5 = k3.c.a(AbsGetAudioPlaybackTimeMethod.b.class);
        r5.setPlaybackTime(NewsUrlAudioManagerDelegate.b.f());
        r4.b(r5, "");
    }
}
