package com.bytedance.ee.bear.net;

/* JADX INFO: loaded from: classes18.dex */
public class RawServerResult extends ServerResult {
    private String logId;
    private String mJson;

    public RawServerResult() {
    }

    public String getJson() {
        return this.mJson;
    }

    public String getLogId() {
        return this.logId;
    }

    public void setJson(String r100) {
        this.mJson = r100;
    }

    public void setLogId(String r100) {
        this.logId = r100;
    }
}
