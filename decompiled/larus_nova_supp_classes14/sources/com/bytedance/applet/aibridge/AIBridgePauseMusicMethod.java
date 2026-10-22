package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.audioplayer.api.music.MusicPlayManagerDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/AIBridgePauseMusicMethod;", "Lcom/bytedance/applet/aibridge/AbsAIBridgePauseMusicMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/AbsAIBridgePauseMusicMethodIDL$PauseMusicParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/AbsAIBridgePauseMusicMethodIDL$PauseMusicResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgePauseMusicMethod extends AbsAIBridgePauseMusicMethodIDL {
    public AIBridgePauseMusicMethod() {
    }

    public final void handle(e3.d r6, ParamModel r7, f3.h r8) {
        Intrinsics.checkNotNullParameter(r6, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsAIBridgePauseMusicMethodIDL.a) r7, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        String r9 = i.b;
        if (r9 == null) goto L15;
        MusicPlayManagerDelegate r1 = MusicPlayManagerDelegate.b;
        a88.e r2 = r1.a();
        if (r2 == null) goto L8;
        String r3 = r2.a;
        if (r3 == null) goto L8;
    L10:
        if (Intrinsics.areEqual(r9, r3) == true) goto L12;
    L14:
        f3.h.a.a(r8, "Failed to pause music: current_music_id = " + r3 + ", latest_music_id = " + r9, null, null, 14);
        return;
    L12:
        if (r1.j(r9) == false) goto L14;
        Intrinsics.checkNotNullParameter(AbsAIBridgePauseMusicMethodIDL.b.class, "<this>");
        r8.b(k3.c.a(AbsAIBridgePauseMusicMethodIDL.b.class), "");
        return;
    L8:
        r3 = "";
        goto L10
    L15:
        f3.h.a.a(r8, "Failed to pause music : latest_music_id is null", null, null, 14);
    }
}
