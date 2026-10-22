package com.bytedance.applet.aibridge.video;

import c68.b;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.utils.g;
import com.larus.audioplayer.api.stream.AudioStreamPlayerDelegate;
import com.larus.common.apphost.AppHost;
import d3.a0;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/video/StreamPlayStartMethod;", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgePlayStreamMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgePlayStreamMethodIDL$PlayStreamParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgePlayStreamMethodIDL$PlayStreamResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StreamPlayStartMethod extends AbsAIBridgePlayStreamMethodIDL {
    public StreamPlayStartMethod() {
    }

    public final void handle(d r17, ParamModel r18, h r19) {
        AbsAIBridgePlayStreamMethodIDL.a r1 = (AbsAIBridgePlayStreamMethodIDL.a) r18;
        Intrinsics.checkNotNullParameter(r17, "bridgeContext");
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r19, "callback");
        String r2 = r1.getTitle();
        if (r2 != null) goto L5;
        r2 = AppHost.a.getApplication().getString(2131899674);
    L5:
        String r5 = r2;
        String r3 = r1.getArtist();
        if (r3 != null) goto L8;
        r3 = AppHost.a.getApplication().getString(2131899908);
    L8:
        String r6 = r3;
        String r7 = r1.getAlbumArtUrl();
        String r9 = r1.getUuid();
        String r8 = r1.getUrl();
        JSONObject r4 = r1.getExtra();
        if (r4 != null) goto L11;
        r4 = new JSONObject();
    L11:
        JSONObject r12 = r4;
        g.a.e("flow.playStreamAudio", "stream play url=" + r1.getUrl() + ", uuid=" + r1.getUuid() + ", title=" + r5 + ", albumArtUrl=" + r7 + ", extra=" + r12);
        int r10 = b.a;
        b.d("AudioStream:JSB", "StreamPlayStartMethod called: url=" + r1.getUrl() + ", uuid=" + r1.getUuid() + ", title=" + r5 + ", albumArtUrl=" + r7 + ", extra=" + r12);
        AudioStreamPlayerDelegate r11 = AudioStreamPlayerDelegate.b;
        a0 r13 = r17.getContainerContext();
        if (r13 == null) goto L14;
        String r14 = r13.getAppletId();
    L16:
        if (r14 != null) goto L18;
        String r15 = "";
    L19:
        com.bytedance.applet.utils.b r16 = com.bytedance.applet.utils.b.a;
        r11.c(r15, r5, r6, r7, r8, r9, r1.getTimeOffset(), "stream_player", r12);
        b.d("AudioStream:JSB", "AudioStreamPlayerDelegate.start called successfully");
        Intrinsics.checkNotNullParameter(AbsAIBridgePlayStreamMethodIDL.b.class, "<this>");
        r19.b(c.a(AbsAIBridgePlayStreamMethodIDL.b.class), "");
        return;
    L18:
        r15 = r14;
        goto L19
    L14:
        r14 = null;
        goto L16
    }
}
