package com.obric.miniapp.aibridge;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/obric/miniapp/aibridge/AbsDatePickerMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/obric/miniapp/aibridge/AbsDatePickerMethodIDL$DatePickerParamModel;", "Lcom/obric/miniapp/aibridge/AbsDatePickerMethodIDL$DatePickerResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "DatePickerParamModel", "DatePickerResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsDatePickerMethodIDL extends CoreAIBridgeMethod<a, b> {

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "defaultTime", required = false)
        Long getDefaultTime();

        @AIBridgeParamField(keyPath = "type", required = false)
        Integer getType();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "result", required = true)
        void setTime(long r100);
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return "applet.datePicker";
    }

    public AbsDatePickerMethodIDL() {
    }
}
