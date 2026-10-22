package com.bytedance.applet.aibridge.video;

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
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/applet/aibridge/video/AbsAIBridgePlayStreamMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgePlayStreamMethodIDL$PlayStreamParamModel;", "Lcom/bytedance/applet/aibridge/video/AbsAIBridgePlayStreamMethodIDL$PlayStreamResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "PlayStreamParamModel", "PlayStreamResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsAIBridgePlayStreamMethodIDL extends CoreAIBridgeMethod<a, b> {

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(type = DefaultType.STRING), keyPath = "albumArtUrl", required = false)
        String getAlbumArtUrl();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(type = DefaultType.STRING), keyPath = "artist", required = false)
        String getArtist();

        @AIBridgeParamField(keyPath = "extra", required = false)
        JSONObject getExtra();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(type = DefaultType.INT), keyPath = "cursor", required = false)
        int getTimeOffset();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(type = DefaultType.STRING), keyPath = "title", required = false)
        String getTitle();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(type = DefaultType.STRING), keyPath = "url", required = false)
        String getUrl();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(type = DefaultType.STRING), keyPath = "uuid", required = false)
        String getUuid();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
    }

    public final String getName() {
        return "flow.playStreamAudio";
    }

    public AbsAIBridgePlayStreamMethodIDL() {
    }
}
