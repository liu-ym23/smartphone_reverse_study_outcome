package com.bytedance.debugrouter.app;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class MessageHandleResult {
    public static final int CODE_HANDLE_FAILED = -1;
    public static final int CODE_HANDLE_SUCCESSFULLY = 0;
    public static final int CODE_NOT_IMPLEMENTED = -2;
    private int mCode;
    private Map<String, Object> mData;
    private String mMessage;
    private com.lynx.debugrouter.app.MessageHandleResult mMessageHandleResult;

    public Map<String, Object> getData() {
        return this.mMessageHandleResult.getData();
    }

    public JSONObject toJson() {
        return this.mMessageHandleResult.toJson();
    }

    public String toJsonString() {
        return this.mMessageHandleResult.toJsonString();
    }

    public MessageHandleResult() {
        this.mMessageHandleResult = new com.lynx.debugrouter.app.MessageHandleResult();
    }

    public int getCode() {
        return this.mCode;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public MessageHandleResult(Map<String, Object> r100) {
        this.mData = r100;
        this.mMessageHandleResult = new com.lynx.debugrouter.app.MessageHandleResult(r100);
    }

    public MessageHandleResult(int r100, String r101) {
        this.mCode = r100;
        this.mMessage = r101;
        this.mMessageHandleResult = new com.lynx.debugrouter.app.MessageHandleResult(r100, r101);
    }

    public MessageHandleResult(int r100, String r101, Map<String, Object> r102) {
        this.mCode = r100;
        this.mMessage = r101;
        this.mData = r102;
        this.mMessageHandleResult = new com.lynx.debugrouter.app.MessageHandleResult(r100, r101, r102);
    }
}
