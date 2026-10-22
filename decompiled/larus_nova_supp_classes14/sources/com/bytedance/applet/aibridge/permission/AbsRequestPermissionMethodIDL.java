package com.bytedance.applet.aibridge.permission;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/permission/AbsRequestPermissionMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/applet/aibridge/permission/AbsRequestPermissionMethodIDL$RequestPermissionMethodParamModel;", "Lcom/bytedance/applet/aibridge/permission/AbsRequestPermissionMethodIDL$RequestPermissionMethodResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "RequestPermissionMethodParamModel", "RequestPermissionMethodResultModel", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsRequestPermissionMethodIDL extends CoreAIBridgeMethod<b, c> {
    public final String a;

    public static final class a {
    }

    @AIBridgeParamModel
    public interface b extends ParamModel {
        @AIBridgeParamField(keyPath = "extra", required = false)
        JSONObject getExtra();

        @AIBridgeParamField(keyPath = "permission", required = true)
        String getPermission();

        @AIBridgeParamField(keyPath = "requestId", required = true)
        String getRequestId();

        @AIBridgeParamField(keyPath = "traceInfo", required = false)
        JSONObject getTraceInfo();
    }

    @AIBridgeResultModel
    public interface c extends ResultModel {
        @AIBridgeParamField(keyPath = "requestId", required = true)
        void setRequestId(String r1);
    }

    static {
    }

    public AbsRequestPermissionMethodIDL() {
        this.a = "flow.requestPermission";
    }

    public final String getName() {
        return this.a;
    }
}
