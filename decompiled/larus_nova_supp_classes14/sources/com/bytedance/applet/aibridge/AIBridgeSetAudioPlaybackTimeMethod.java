package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.audioplayer.api.news.NewsUrlAudioManagerDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgeSetAudioPlaybackTimeMethod;", "Lcom/bytedance/applet/aibridge/AbsSetAudioPlaybackTimeMethod;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsSetAudioPlaybackTimeMethod$SetAudioPlaybackTimeMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsSetAudioPlaybackTimeMethod$SetAudioPlaybackTimeMethodResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeSetAudioPlaybackTimeMethod extends AbsSetAudioPlaybackTimeMethod {
    public AIBridgeSetAudioPlaybackTimeMethod() {
    }

    public final void handle(e3.d r7, ParamModel r8, f3.h r9) {
        AbsSetAudioPlaybackTimeMethod.a r10 = (AbsSetAudioPlaybackTimeMethod.a) r8;
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        NewsUrlAudioManagerDelegate r0 = NewsUrlAudioManagerDelegate.b;
        String r1 = r10.getUrl();
        String r3 = r10.getVideoModel();
        int r11 = r10.getSourceType();
        int r4 = r10.getPlaybackTime();
        l r5 = new l(r9);
        if (r0.b(r1, Integer.valueOf(r11), r3, r4, r5) == true) goto L6;
        f3.h.a.a(r9, "The target url does not match the current url when onSetAudioPlayTime", null, null, 14);
        return;
    }
}
