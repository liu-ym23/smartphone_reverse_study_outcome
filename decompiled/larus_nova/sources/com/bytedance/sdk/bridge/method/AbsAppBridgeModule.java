package com.bytedance.sdk.bridge.method;

import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.annotation.BridgeSyncType;
import com.bytedance.sdk.bridge.model.BridgeResult;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JF\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\b2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\rH'J\u0012\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0012\u0010\u0010\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J2\u0010\u0011\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0012\u001a\u00020\b2\b\b\u0001\u0010\u0013\u001a\u00020\b2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\rH'¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/bridge/method/AbsAppBridgeModule;", "", "()V", "alert", "", "bridgeContext", "Lcom/bytedance/sdk/bridge/model/IBridgeContext;", "title", "", "message", "confirmText", "cancelText", "totalParams", "Lorg/json/JSONObject;", "checkLoginSatusSync", "Lcom/bytedance/sdk/bridge/model/BridgeResult;", "login", "toast", "text", "iconType", "bridge_release"}, k = 1, mv = {1, 1, 15})
public abstract class AbsAppBridgeModule {
    public AbsAppBridgeModule() {
    }

    @BridgeMethod("alert")
    public abstract void alert(@BridgeContext IBridgeContext r100, @BridgeParam("title") String r101, @BridgeParam("message") String r102, @BridgeParam("confirm_text") String r103, @BridgeParam("cancel_text") String r104, @BridgeParam("__all_params__") JSONObject r105);

    @BridgeMethod(sync = BridgeSyncType.SYNC, value = "checkLoginSatus")
    public abstract BridgeResult checkLoginSatusSync(@BridgeContext IBridgeContext r100);

    @BridgeMethod("login")
    public abstract void login(@BridgeContext IBridgeContext r100);

    @BridgeMethod("toast")
    public abstract void toast(@BridgeContext IBridgeContext r100, @BridgeParam(required = true, value = "text") String r101, @BridgeParam("icon_type") String r102, @BridgeParam("__all_params__") JSONObject r103);
}
