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
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/applet/aibridge/AbsAIBridgePlayAudioMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/AbsAIBridgePlayAudioMethodIDL$PlayAudioParamModel;", "Lcom/bytedance/applet/aibridge/AbsAIBridgePlayAudioMethodIDL$PlayAudioResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "PlayAudioParamModel", "PlayAudioResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsAIBridgePlayAudioMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "albumArtUrl", required = false)
        String getAlbumArtUrl();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(type = DefaultType.STRING), keyPath = "artist", required = false)
        String getArtist();

        @AIBridgeParamField(keyPath = "extra", required = false)
        JSONObject getExtra();

        @AIBridgeParamField(keyPath = "scene", required = false)
        String getScene();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(type = DefaultType.INT), keyPath = "sourceType", required = false)
        int getSourceType();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(type = DefaultType.STRING), keyPath = "title", required = false)
        String getTitle();

        @AIBridgeParamField(keyPath = "traceInfo", required = false)
        JSONObject getTraceInfo();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(type = DefaultType.STRING), keyPath = "url", required = false)
        String getUrl();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(type = DefaultType.STRING), keyPath = "videoModel", required = false)
        String getVideoModel();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
    }

    public AbsAIBridgePlayAudioMethodIDL() {
        this.a = "applet.playAudio";
    }

    public final String getName() {
        return this.a;
    }
}
