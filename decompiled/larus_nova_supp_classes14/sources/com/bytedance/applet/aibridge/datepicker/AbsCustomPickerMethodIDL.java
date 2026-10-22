package com.bytedance.applet.aibridge.datepicker;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/applet/aibridge/datepicker/AbsCustomPickerMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/datepicker/AbsCustomPickerMethodIDL$CustomPickerParamModel;", "Lcom/bytedance/applet/aibridge/datepicker/AbsCustomPickerMethodIDL$CustomPickerResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "CustomPickerParamModel", "CustomPickerResultModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsCustomPickerMethodIDL extends CoreAIBridgeMethod<a, b> {

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "optionList", required = true)
        List<List<String>> getOptionList();

        @AIBridgeParamField(keyPath = "selectedOptionList", required = false)
        List<Number> getSelectedOptionList();

        @AIBridgeParamField(keyPath = "title", required = false)
        String getTitle();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "result", required = true)
        void setResult(List<Integer> r1);
    }

    public final String getName() {
        return "applet.customPicker";
    }

    public AbsCustomPickerMethodIDL() {
    }
}
