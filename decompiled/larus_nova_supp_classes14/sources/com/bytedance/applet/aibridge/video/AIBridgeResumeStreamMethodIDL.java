package com.bytedance.applet.aibridge.video;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.larus.audioplayer.api.stream.AudioStreamPlayerDelegate;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/applet/aibridge/video/AIBridgeResumeStreamMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/video/AIBridgeResumeStreamMethodIDL$StreamPauseParamModel;", "Lcom/bytedance/applet/aibridge/video/AIBridgeResumeStreamMethodIDL$StreamPauseResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "StreamPauseParamModel", "StreamPauseResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBridgeResumeStreamMethodIDL extends CoreAIBridgeMethod<a, b> {

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(type = DefaultType.STRING), keyPath = "uuid", required = false)
        String getUuid();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
    }

    public final String getName() {
        return "flow.resumeStreamAudio";
    }

    public AIBridgeResumeStreamMethodIDL() {
    }

    public final void handle(d r3, ParamModel r4, h r5) {
        a r6 = (a) r4;
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "callback");
        String r7 = r6.getUuid();
        int r8 = c68.b.a;
        c68.b.d("AudioStream:JSB", "AIBridgeResumeStreamMethodIDL called: uuid=" + r7);
        AudioStreamPlayerDelegate.b.e(r7, "bridge_call");
        c68.b.d("AudioStream:JSB", "AudioStreamPlayerDelegate.resume called");
        Intrinsics.checkNotNullParameter(b.class, "<this>");
        r5.b(c.a(b.class), "");
    }
}
