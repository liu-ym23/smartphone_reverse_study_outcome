package com.lynx.debugrouter.app;

import com.alipay.sdk.m.p.e;
import com.lynx.debugrouter.DebugRouter;
import com.lynx.debugrouter.log.LLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class DebugRouterEventSender {
    private static final String TAG = "MessageHandleCallback.Sender";

    public DebugRouterEventSender() {
    }

    public static void send(String r100, MessageHandleResult r101) {
        JSONObject r102 = new JSONObject();
        r102.put(e.f25671s, r100);     // Catch: JSONException -> L5
        r102.put("params", r101.toJson());     // Catch: JSONException -> L5
        DebugRouter.getInstance().sendDataAsync("CDP", -1, r102.toString());     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        LLog.e(TAG, "send failed:" + e.getMessage());
    }
}
