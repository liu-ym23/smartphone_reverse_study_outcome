package com.lynx.debugrouter;

import com.lynx.debugrouter.app.MessageHandleResult;
import com.lynx.debugrouter.app.MessageHandler;
import com.lynx.debugrouter.log.LLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class MessageHandlerDelegate implements MessageHandler {
    private static final String TAG = "MessageHandlerDelegate";
    private MessageHandler handler;

    @Override // com.lynx.debugrouter.app.MessageHandler
    public String getName() {
        return this.handler.getName();
    }

    public MessageHandlerDelegate(MessageHandler r100) {
        this.handler = r100;
    }

    @Override // com.lynx.debugrouter.app.MessageHandler
    public MessageHandleResult handle(Map<String, String> r100) {
        LLog.i(TAG, "handle: " + r100);
        return this.handler.handle(r100);
    }

    public String handleAppAction(String r100) {
        HashMap r101 = new HashMap();
        JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L14
        Iterator<String> r103 = r102.keys();     // Catch: JSONException -> L14
    L5:
        if (r103.hasNext() == false) goto L8;
        String r104 = r103.next();     // Catch: JSONException -> L14
        r101.put(r104, r102.optString(r104));     // Catch: JSONException -> L14
        goto L5
    L8:
        MessageHandleResult r105 = handle(r101);
        if (r105 != null) goto L13;
        return new MessageHandleResult().toJsonString();
    L13:
        return r105.toJsonString();
    L14:
        LLog.e(TAG, "params resolve error:" + r100);
        return new MessageHandleResult(-1, "params resolve error").toJsonString();
    }
}
