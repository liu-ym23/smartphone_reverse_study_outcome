package com.bytedance.applet.aibridge.ecommerce.api;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/applet/aibridge/ecommerce/api/AbsGetBtmInfoMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsGetBtmInfoMethodIDL$AbsGetBtmInfoMethodParamModel;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsGetBtmInfoMethodIDL$AbsGetBtmInfoMethodResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "AbsGetBtmInfoMethodParamModel", "AbsGetBtmInfoMethodResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetBtmInfoMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "bcm", required = false)
        JSONObject getBcm();

        @AIBridgeParamField(keyPath = "btm", required = true)
        String getBtm();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "btmShowId", required = false)
        void setBtmShowId(String r1);

        @AIBridgeParamField(keyPath = "sourceBtmToken", required = false)
        void setSourceBtmToken(String r1);
    }

    public AbsGetBtmInfoMethodIDL() {
        this.a = "applet.getBtmInfo";
    }

    public final String getName() {
        return this.a;
    }
}
