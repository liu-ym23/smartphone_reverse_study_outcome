package com.bytedance.applet.aibridge.navigation;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.JsonArray;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/applet/aibridge/navigation/AbsStartMapNavigationIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/navigation/AbsStartMapNavigationIDL$StartMapNavParam;", "Lcom/bytedance/applet/aibridge/navigation/AbsStartMapNavigationIDL$StartMapNavResult;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "StartMapNavParam", "StartMapNavResult", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsStartMapNavigationIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "botId", required = false)
        String getBotId();

        @AIBridgeParamField(keyPath = "businessId", required = false)
        String getBusinessId();

        @AIBridgeParamField(keyPath = "conversationId", required = false)
        String getConversationId();

        @AIBridgeParamField(keyPath = "coordType", required = false)
        Integer getCoordType();

        @AIBridgeParamField(keyPath = "enableForegroundService", required = false)
        Boolean getEnableForegroundService();

        @AIBridgeParamField(keyPath = "endPoint", required = false)
        d getEndPoint();

        @AIBridgeParamField(keyPath = "navigateUniqueId", required = false)
        String getNavigateUniqueId();

        @AIBridgeParamField(keyPath = "poiId", required = false)
        String getPoiId();

        @AIBridgeParamField(keyPath = "poiType", required = false)
        String getPoiType();

        @AIBridgeParamField(keyPath = "prefer", required = false)
        Integer getPrefer();

        @AIBridgeParamField(keyPath = "ridingType", required = false)
        Integer getRidingType();

        @AIBridgeParamField(keyPath = "rotationChangeMinInterval", required = false)
        Integer getRotationChangeMinInterval();

        @AIBridgeParamField(keyPath = "routePlanType", required = true)
        Integer getRoutePlanType();

        @AIBridgeParamField(keyPath = "startPoint", required = false)
        d getStartPoint();

        @AIBridgeParamField(keyPath = "traceContext", required = false)
        yv3.b getTraceContext();

        @AIBridgeParamField(keyPath = "verbalMode", required = false)
        Integer getVerbalMode();

        @AIBridgeParamField(keyPath = "waypoints", required = false)
        JsonArray getWaypoints();

        @AIBridgeParamField(keyPath = "isQuickRestart", required = false)
        Boolean isQuickRestart();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "navigationId", required = false)
        void setNavigationId(String r1);
    }

    public AbsStartMapNavigationIDL() {
        this.a = "flow.startMapNavigation";
    }

    public final String getName() {
        return this.a;
    }
}
