package com.bytedance.applet.aibridge.ecommerce.api;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/applet/aibridge/ecommerce/api/AbsUpdateECommercePageInfoMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsUpdateECommercePageInfoMethodIDL$UpdateECommercePageInfoParamModel;", "Lcom/bytedance/applet/aibridge/ecommerce/api/AbsUpdateECommercePageInfoMethodIDL$UpdateECommercePageInfoResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "UpdateECommercePageInfoParamModel", "UpdateECommercePageInfoResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsUpdateECommercePageInfoMethodIDL extends CoreAIBridgeMethod<a, b> {
    public final String a;

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "page_id", required = true)
        String getCurrentPage();

        @AIBridgeParamField(keyPath = "page_action", required = true)
        Integer getPageAction();

        @AIBridgeParamField(keyPath = "source", required = false)
        String getSource();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
    }

    public AbsUpdateECommercePageInfoMethodIDL() {
        this.a = "applet.updateECommercePageInfo";
    }

    public final String getName() {
        return this.a;
    }
}
