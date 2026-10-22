package com.bytedance.ee.bear.net;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public void setJson(String r1) {
        this.mJson = r1;
    }

    public void setLogId(String r1) {
        this.logId = r1;
    }
}
