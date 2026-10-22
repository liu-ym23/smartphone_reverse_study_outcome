package com.ss.android.lark.lynxkit.bridge;

import com.lynx.react.bridge.Callback;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/lynxkit/bridge/ILynxBridgeMethodDispatcher;", "", "handleMethodInvoke", "", "bridgeContext", "Lcom/ss/android/lark/lynxkit/bridge/ILynxBridgeContext;", "methodName", "", "params", "Lorg/json/JSONObject;", "callback", "Lcom/lynx/react/bridge/Callback;", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILynxBridgeMethodDispatcher {
    void handleMethodInvoke(ILynxBridgeContext r100, String r101, JSONObject r102, Callback r103);
}
