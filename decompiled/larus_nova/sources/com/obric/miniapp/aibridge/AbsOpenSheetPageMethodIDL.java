package com.obric.miniapp.aibridge;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/obric/miniapp/aibridge/AbsOpenSheetPageMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/obric/miniapp/aibridge/AbsOpenSheetPageMethodIDL$OpenSheetPageParamModel;", "Lcom/obric/miniapp/aibridge/AbsOpenSheetPageMethodIDL$OpenSheetPageResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mustRunInMain", "", "OpenSheetPageParamModel", "OpenSheetPageResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsOpenSheetPageMethodIDL extends CoreAIBridgeMethod<a, b> {

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = PerfLog.PARAM_KEY_CONTEXT_ID, required = true)
        JsonObject getContext();

        @AIBridgeParamField(keyPath = "pageData", required = false)
        String getPageData();

        @AIBridgeParamField(keyPath = "pageId", required = true)
        String getPageId();

        @AIBridgeParamField(keyPath = "pageSettings", required = false)
        JsonObject getPageSettings();

        @AIBridgeParamField(keyPath = "sheetSettings", required = false)
        JsonObject getSheetSettings();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "viewId", required = true)
        void setViewId(String r100);
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public String getName() {
        return "obric.openSheetPage";
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public boolean mustRunInMain() {
        return true;
    }

    public AbsOpenSheetPageMethodIDL() {
    }
}
