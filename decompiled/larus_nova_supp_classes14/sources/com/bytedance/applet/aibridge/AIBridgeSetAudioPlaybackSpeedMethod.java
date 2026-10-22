package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.audioplayer.api.news.NewsUrlAudioManagerDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgeSetAudioPlaybackSpeedMethod;", "Lcom/bytedance/applet/aibridge/AbsSetAudioPlaybackSpeedMethod;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsSetAudioPlaybackSpeedMethod$SetAudioPlaybackSpeedMethodParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsSetAudioPlaybackSpeedMethod$SetAudioPlaybackSpeedMethodResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeSetAudioPlaybackSpeedMethod extends AbsSetAudioPlaybackSpeedMethod {
    public AIBridgeSetAudioPlaybackSpeedMethod() {
    }

    public final void handle(e3.d r4, ParamModel r5, f3.h r6) {
        AbsSetAudioPlaybackSpeedMethod.a r7 = (AbsSetAudioPlaybackSpeedMethod.a) r5;
        Intrinsics.checkNotNullParameter(r4, "bridgeContext");
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        if (r7.getSpeed() > 0.0f) goto L6;
        f3.h.a.a(r6, "The speed must be more than 0.", null, null, 14);
        return;
    L6:
        if (NewsUrlAudioManagerDelegate.b.e(r7.getScene(), r7.getSpeed()) == false) goto L8;
        Intrinsics.checkNotNullParameter(AbsSetAudioPlaybackSpeedMethod.b.class, "<this>");
        r6.b(k3.c.a(AbsSetAudioPlaybackSpeedMethod.b.class), "");
        return;
    L8:
        f3.h.a.a(r6, "The target url does not match the current url when on SetAudioPlaybackSpeed", null, null, 14);
    }
}
