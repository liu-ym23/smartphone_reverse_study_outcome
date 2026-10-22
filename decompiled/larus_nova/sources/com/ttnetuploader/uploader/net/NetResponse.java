package com.ttnetuploader.uploader.net;

import com.ttnetuploader.uploader.slice_task.SliceConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class NetResponse implements INetResponse {
    private JSONObject mBody;
    private int mCode;
    private String mLog;
    private Map<String, String> mResponseHeaders;
    private SliceConfig mSliceConfig;

    @Override // com.ttnetuploader.uploader.net.INetResponse
    public Map<String, String> getResponseHeaders() {
        Map<String, String> r100 = this.mResponseHeaders;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new HashMap();
    }

    @Override // com.ttnetuploader.uploader.net.INetResponse
    public JSONObject getBodyJson() {
        return this.mBody;
    }

    @Override // com.ttnetuploader.uploader.net.INetResponse
    public int getCode() {
        return this.mCode;
    }

    @Override // com.ttnetuploader.uploader.net.INetResponse
    public String getRequestLog() {
        return this.mLog;
    }

    @Override // com.ttnetuploader.uploader.net.INetResponse
    public SliceConfig getSliceConfig() {
        return this.mSliceConfig;
    }

    public NetResponse(int r100, SliceConfig r101, Map<String, String> r102, JSONObject r103, String r104) {
        this.mCode = -1;
        this.mResponseHeaders = new HashMap();
        this.mSliceConfig = null;
        this.mCode = r100;
        if (r103 != null) goto L5;
        r103 = new JSONObject();
    L5:
        this.mBody = r103;
        this.mLog = r104;
        if (r102 != null) goto L8;
        r102 = new HashMap();
    L8:
        this.mResponseHeaders = r102;
        this.mSliceConfig = r101;
    }
}
