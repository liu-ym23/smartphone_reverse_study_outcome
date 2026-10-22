package com.bytedance.applet.aibridge.auth;

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
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/applet/aibridge/auth/AbsGetHostDouyinOpenAuthTokenMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/auth/AbsGetHostDouyinOpenAuthTokenMethodIDL$GetHostDouyinOpenAuthTokenParamModel;", "Lcom/bytedance/applet/aibridge/auth/AbsGetHostDouyinOpenAuthTokenMethodIDL$GetHostDouyinOpenAuthTokenResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "GetHostDouyinOpenAuthTokenParamModel", "GetHostDouyinOpenAuthTokenResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetHostDouyinOpenAuthTokenMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "setCookieConfig", required = false)
        JSONObject getSetCookieConfig();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(stringValue = "", type = DefaultType.STRING), keyPath = "accessToken", required = true)
        void setAccessToken(String r1);

        @AIBridgeParamField(keyPath = "accessTokenStatus", required = true)
        void setAccessTokenStatus(Integer r1);

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(stringValue = "", type = DefaultType.STRING), keyPath = "openId", required = true)
        void setOpenId(String r1);

        @AIBridgeParamField(defaultValue = @AIBridgeDefaultValue(stringValue = "", type = DefaultType.STRING), keyPath = "scopes", required = true)
        void setScopes(String r1);

        @AIBridgeParamField(keyPath = "setCookieResult", required = false)
        void setSetCookieResult(Integer r1);
    }

    public AbsGetHostDouyinOpenAuthTokenMethodIDL() {
        this.a = "applet.getHostDouyinOpenAuthToken";
    }

    public final String getName() {
        return this.a;
    }
}
