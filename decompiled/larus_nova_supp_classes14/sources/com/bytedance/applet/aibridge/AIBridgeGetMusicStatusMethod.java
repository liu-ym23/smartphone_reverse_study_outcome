package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgeGetMusicStatusMethod;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeGetMusicStatusMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsAIBridgeGetMusicStatusMethodIDL$GetMusicStatusParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeGetMusicStatusMethodIDL$GetMusicStatusResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeGetMusicStatusMethod extends AbsAIBridgeGetMusicStatusMethodIDL {
    public AIBridgeGetMusicStatusMethod() {
    }

    public final void handle(e3.d r5, ParamModel r6, f3.h r7) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsAIBridgeGetMusicStatusMethodIDL.a) r6, "params");
        Intrinsics.checkNotNullParameter(r7, "callback");
        MusicPlayManagerDelegate r8 = MusicPlayManagerDelegate.b;
        a88.e r9 = r8.a();
        if (r9 == null) goto L9;
        String r10 = r9.a;
        if (r10 == null) goto L9;
        if (Intrinsics.areEqual(r10, i.b) == false) goto L9;
        String r1 = i.c;
    L10:
        String r11 = r8.h(r10);
        Intrinsics.checkNotNullParameter(AbsAIBridgeGetMusicStatusMethodIDL.b.class, "<this>");
        AbsAIBridgeGetMusicStatusMethodIDL.b r2 = k3.c.a(AbsAIBridgeGetMusicStatusMethodIDL.b.class);
        AbsAIBridgeGetMusicStatusMethodIDL.b r3 = r2;
        r3.setMusicId(r10);
        r3.setStatus(r1);
        r3.setPausedReason(r11);
        r7.b(r2, "");
        return;
    L9:
        r1 = "stopped";
        r10 = "";
        goto L10
    }
}
