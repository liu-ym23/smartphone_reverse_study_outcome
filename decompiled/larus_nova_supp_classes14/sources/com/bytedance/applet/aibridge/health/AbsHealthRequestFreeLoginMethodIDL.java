package com.bytedance.applet.aibridge.health;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applet/aibridge/health/AbsHealthRequestFreeLoginMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/health/AbsHealthRequestFreeLoginMethodIDL$HealthRequestFreeLoginParamModel;", "Lcom/bytedance/applet/aibridge/health/AbsHealthRequestFreeLoginMethodIDL$HealthRequestFreeLoginResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "HealthRequestFreeLoginParamModel", "HealthRequestFreeLoginResultModel", "huawei-health-impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsHealthRequestFreeLoginMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "appId", required = true)
        String getAppId();

        @AIBridgeParamField(keyPath = "healthDeviceType", required = true)
        String getHealthDeviceType();

        @AIBridgeParamField(keyPath = "scheme", required = false)
        String getScheme();

        @AIBridgeParamField(keyPath = "scopes", required = true)
        List<String> getScopes();

        @AIBridgeParamField(keyPath = "secretKey", required = false)
        String getSecretKey();

        @AIBridgeParamField(keyPath = "state", required = true)
        String getState();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "code", required = true)
        void setCode(String r1);

        @AIBridgeParamField(keyPath = "state", required = true)
        void setState(String r1);
    }

    public final boolean mustRunInMain() {
        return true;
    }

    public AbsHealthRequestFreeLoginMethodIDL() {
        this.a = "applet.healthRequestFreeLogin";
    }

    public final String getName() {
        return this.a;
    }
}
