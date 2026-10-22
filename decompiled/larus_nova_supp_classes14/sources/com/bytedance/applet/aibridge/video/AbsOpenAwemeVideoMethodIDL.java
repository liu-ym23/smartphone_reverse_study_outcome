package com.bytedance.applet.aibridge.video;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeDefaultValue;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.annotation.DefaultType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.JsonArray;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/applet/aibridge/video/AbsOpenAwemeVideoMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/video/AbsOpenAwemeVideoMethodIDL$OpenAwemeVideoMethodParamModel;", "Lcom/bytedance/applet/aibridge/video/AbsOpenAwemeVideoMethodIDL$OpenAwemeVideoMethodResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "OpenAwemeVideoMethodParamModel", "OpenAwemeVideoMethodResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsOpenAwemeVideoMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "botId", required = false)
        String getBotId();

        @AIBridgeParamField(keyPath = "conversationId", required = false)
        String getConversationId();

        @AIBridgeParamField(keyPath = "enterTraceInfo", required = false)
        JSONObject getEnterTraceInfo();

        @AIBridgeParamField(keyPath = "enterVideoType", required = true)
        String getEnterVideoType();

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(type = DefaultType.BOOL), keyPath = "hasMore", required = false)
        boolean getHasMore();

        @AIBridgeParamField(keyPath = "index", required = true)
        int getIndex();

        @AIBridgeParamField(keyPath = "leaveTraceInfo", required = false)
        JSONObject getLeaveTraceInfo();

        @AIBridgeParamField(keyPath = "messageId", required = false)
        String getMessageId();

        @AIBridgeParamField(keyPath = "queryParams", required = false)
        JSONObject getQueryParams();

        @AIBridgeParamField(keyPath = "reqId", required = false)
        String getReqId();

        @AIBridgeParamField(keyPath = "sceneId", required = false)
        String getSceneId();

        @AIBridgeParamField(keyPath = "sectionId", required = false)
        String getSectionId();

        @AIBridgeParamField(keyPath = "videoList", required = true)
        JsonArray getVideoList();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "msg", required = false)
        void setMsg(String r1);

        @AIBridgeParamField(keyPath = "result", required = true)
        void setResult(boolean r1);
    }

    public AbsOpenAwemeVideoMethodIDL() {
        this.a = "flow.openAwemeVideo";
    }

    public final String getName() {
        return this.a;
    }
}
