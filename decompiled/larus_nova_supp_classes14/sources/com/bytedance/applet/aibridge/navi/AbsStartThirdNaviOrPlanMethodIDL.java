package com.bytedance.applet.aibridge.navi;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/applet/aibridge/navi/AbsStartThirdNaviOrPlanMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/navi/AbsStartThirdNaviOrPlanMethodIDL$StartThirdNaviOrPlanMethodParamModel;", "Lcom/bytedance/applet/aibridge/navi/AbsStartThirdNaviOrPlanMethodIDL$StartThirdNaviOrPlanMethodResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "StartThirdNaviOrPlanMethodParamModel", "StartThirdNaviOrPlanMethodResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsStartThirdNaviOrPlanMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "appName", required = false)
        String getAppName();

        @AIBridgeParamField(keyPath = "backupApp", required = false)
        JsonObject getBackupApp();

        @AIBridgeParamField(keyPath = "destination", required = true)
        String getDestination();

        @AIBridgeParamField(keyPath = "dialogAppList", required = false)
        JsonArray getDialogAppList();

        @AIBridgeParamField(keyPath = "dlat", required = true)
        float getDlat();

        @AIBridgeParamField(keyPath = "dlon", required = true)
        float getDlon();

        @AIBridgeParamField(keyPath = "olat", required = true)
        float getOlat();

        @AIBridgeParamField(keyPath = "olon", required = true)
        float getOlon();

        @AIBridgeParamField(keyPath = "origin", required = true)
        String getOrigin();

        @AIBridgeParamField(keyPath = "rideType", required = false)
        String getRideType();

        @AIBridgeParamField(keyPath = "showDialog", required = false)
        Boolean getShowDialog();

        @AIBridgeParamField(keyPath = "startNaviDirectly", required = false)
        Boolean getStartNaviDirectly();

        @AIBridgeParamField(keyPath = "type", required = false)
        String getType();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "appName", required = false)
        void setAppName(String r1);

        @AIBridgeParamField(keyPath = "availableApps", required = true)
        void setAvailableApps(String r1);

        @AIBridgeParamField(keyPath = "isBackground", required = true)
        void setBackground(int r1);

        @AIBridgeParamField(keyPath = "result", required = true)
        void setResult(int r1);

        @AIBridgeParamField(keyPath = "selectedApp", required = false)
        void setSelectedApp(String r1);
    }

    public AbsStartThirdNaviOrPlanMethodIDL() {
        this.a = "flow.startThirdNaviOrPlan";
    }

    public final String getName() {
        return this.a;
    }
}
