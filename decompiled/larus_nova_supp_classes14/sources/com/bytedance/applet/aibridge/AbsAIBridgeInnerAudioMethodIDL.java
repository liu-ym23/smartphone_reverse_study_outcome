package com.bytedance.applet.aibridge;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/applet/aibridge/AbsAIBridgeInnerAudioMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeInnerAudioMethodIDL$InnerAudioParamModel;", "Lcom/bytedance/applet/aibridge/AbsAIBridgeInnerAudioMethodIDL$InnerAudioResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "InnerAudioParamModel", "InnerAudioResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsAIBridgeInnerAudioMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(type = DefaultType.STRING), keyPath = "action", required = false)
        String getAction();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(type = DefaultType.STRING), keyPath = "audioId", required = false)
        String getAudioId();

        @AIBridgeParamField(keyPath = "position", required = false)
        Double getPosition();

        @AIBridgeParamField(keyPath = "state", required = false)
        JSONObject getState();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "appletId", required = false)
        void setAppletId(String r1);

        @AIBridgeParamField(keyPath = "audioId", required = false)
        void setAudioId(String r1);

        @AIBridgeParamField(keyPath = "autoplay", required = false)
        void setAutoplay(Boolean r1);

        @AIBridgeParamField(keyPath = "buffered", required = false)
        void setBuffered(Double r1);

        @AIBridgeParamField(keyPath = "currentTime", required = false)
        void setCurrentTime(Double r1);

        @AIBridgeParamField(keyPath = "duration", required = false)
        void setDuration(Double r1);

        @AIBridgeParamField(keyPath = "errCode", required = false)
        void setErrCode(Integer r1);

        @AIBridgeParamField(keyPath = "errMsg", required = false)
        void setErrMsg(String r1);

        @AIBridgeParamField(keyPath = "loop", required = false)
        void setLoop(Boolean r1);

        @AIBridgeParamField(keyPath = "paused", required = false)
        void setPaused(Boolean r1);

        @AIBridgeParamField(keyPath = "playbackRate", required = false)
        void setPlaybackRate(Double r1);

        @AIBridgeParamField(keyPath = "src", required = false)
        void setSrc(String r1);

        @AIBridgeParamField(keyPath = "startTime", required = false)
        void setStartTime(Double r1);

        @AIBridgeParamField(keyPath = "volume", required = false)
        void setVolume(Double r1);
    }

    public AbsAIBridgeInnerAudioMethodIDL() {
        this.a = "doubao.createInnerAudioContext";
    }

    public final String getName() {
        return this.a;
    }
}
