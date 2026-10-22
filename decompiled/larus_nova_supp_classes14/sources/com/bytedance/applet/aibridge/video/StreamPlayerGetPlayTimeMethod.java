package com.bytedance.applet.aibridge.video;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.utils.g;
import com.larus.audioplayer.api.stream.AudioStreamPlayerDelegate;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/applet/aibridge/video/StreamPlayerGetPlayTimeMethod;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/video/StreamPlayerGetPlayTimeMethod$GetPlayTimeParamModel;", "Lcom/bytedance/applet/aibridge/video/StreamPlayerGetPlayTimeMethod$GetPlayTimeResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "GetPlayTimeParamModel", "GetPlayTimeResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StreamPlayerGetPlayTimeMethod extends CoreAIBridgeMethod<a, b> {

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(type = DefaultType.STRING), keyPath = "uuid", required = false)
        String getUuid();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(type = DefaultType.LONG), keyPath = "playbackTime", required = false)
        void setDuration(long r1);

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(type = DefaultType.STRING), keyPath = "uuid", required = false)
        void setUuid(String r1);
    }

    public final String getName() {
        return "flow.getStreamAudioPlaybackTime";
    }

    public StreamPlayerGetPlayTimeMethod() {
    }

    public final void handle(d r5, ParamModel r6, h r7) {
        a r8 = (a) r6;
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "callback");
        String r9 = r8.getUuid();
        long r0 = AudioStreamPlayerDelegate.b.b(r9);
        g.a.i("flow.getStreamAudioPlaybackTime", "jsb called to get duration time=" + r0);
        Intrinsics.checkNotNullParameter(b.class, "<this>");
        b r10 = c.a(b.class);
        b r2 = r10;
        r2.setUuid(r9);
        r2.setDuration(r0);
        r7.b(r10, "");
    }
}
