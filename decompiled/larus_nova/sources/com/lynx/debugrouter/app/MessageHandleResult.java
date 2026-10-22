package com.lynx.debugrouter.app;

import com.lynx.debugrouter.log.LLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class MessageHandleResult {
    public static final int CODE_HANDLE_FAILED = -1;
    public static final int CODE_HANDLE_SUCCESSFULLY = 0;
    public static final int CODE_NOT_IMPLEMENTED = -2;
    private static final String TAG = "Result";
    private final Map<String, Object> data;
    private int mCode;
    private String mMessage;

    public MessageHandleResult() {
        this(null);
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("code", this.mCode).put("message", this.mMessage);     // Catch: JSONException -> L8
        Iterator<Map.Entry<String, Object>> r101 = this.data.entrySet().iterator();     // Catch: JSONException -> L8
    L5:
        if (r101.hasNext() == false) goto L10;
        Map.Entry<String, Object> r102 = r101.next();     // Catch: JSONException -> L8
        r100.put(r102.getKey(), r102.getValue());     // Catch: JSONException -> L8
    L10:
        return r100;
    L8:
        e = move-exception;
        LLog.e(TAG, "toJsonString error:" + e.getMessage());
        goto L10
    }

    public String toJsonString() {
        return toJson().toString();
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public MessageHandleResult(Map<String, Object> r100) {
        this(0, "", r100);
    }

    public MessageHandleResult(int r100, String r101) {
        this(r100, r101, null);
    }

    public MessageHandleResult(int r100, String r101, Map<String, Object> r102) {
        this.mCode = -2;
        this.mMessage = "not implemented";
        HashMap r103 = new HashMap();
        this.data = r103;
        this.mCode = r100;
        this.mMessage = r101;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.size() <= 0) goto L9;
        r103.putAll(r102);
        return;
    }
}
