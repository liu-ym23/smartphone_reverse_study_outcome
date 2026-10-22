package com.bytedance.applet.aibridge.baidunavi;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.apm.constant.UploadTypeInf;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000 \n2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/baidunavi/AbsStartBaiduNavigationIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/baidunavi/AbsStartBaiduNavigationIDL$StartNavigationParam;", "Lcom/bytedance/applet/aibridge/baidunavi/AbsStartBaiduNavigationIDL$StartNavigationResult;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "Companion", "StartNavigationParam", "StartNavigationResult", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsStartBaiduNavigationIDL extends CoreAIBridgeMethod<b, c> {
    public final String a;

    public static final class a {
    }

    @AIBridgeParamModel
    public interface b extends ParamModel {
        @AIBridgeParamField(keyPath = "botId", required = false)
        String getBotId();

        @AIBridgeParamField(keyPath = "conversationId", required = false)
        String getConversationId();

        @AIBridgeParamField(keyPath = "drivingPolicy", required = false)
        Integer getDrivingRoutePrefer();

        @AIBridgeParamField(keyPath = "end", required = false)
        dv3.e getEnd();

        @AIBridgeParamField(keyPath = "navigateUniqueId", required = true)
        String getNavigateUniqueId();

        @AIBridgeParamField(keyPath = "ridingPrefer", required = false)
        Integer getRidingRoutePrefer();

        @AIBridgeParamField(keyPath = "ridingType", required = false)
        Integer getRidingType();

        @AIBridgeParamField(keyPath = "routeId", required = false)
        String getRouteId();

        @AIBridgeParamField(keyPath = "naviType", required = false)
        Float getRoutePlanType();

        @AIBridgeParamField(keyPath = "sessionId", required = false)
        String getSessionId();

        @AIBridgeParamField(keyPath = UploadTypeInf.START, required = false)
        dv3.e getStart();

        @AIBridgeParamField(keyPath = "styleId", required = false)
        String getStyleId();

        @AIBridgeParamField(keyPath = "verbalMode", required = false)
        Integer getVerbalMode();

        @AIBridgeParamField(keyPath = "isQuickRestart", required = false)
        Boolean isQuickRestart();
    }

    @AIBridgeResultModel
    public interface c extends ResultModel {
        @AIBridgeParamField(keyPath = "message", required = false)
        void setMessage(String r1);

        @AIBridgeParamField(keyPath = "result", required = false)
        void setResult(dv3.c r1);

        @AIBridgeParamField(keyPath = "status", required = true)
        void setStatus(int r1);

        @AIBridgeParamField(keyPath = "statusType", required = false)
        void setStatusType(String r1);
    }

    static {
    }

    public AbsStartBaiduNavigationIDL() {
        this.a = "flow.startNavigation";
    }

    public final String getName() {
        return this.a;
    }
}
