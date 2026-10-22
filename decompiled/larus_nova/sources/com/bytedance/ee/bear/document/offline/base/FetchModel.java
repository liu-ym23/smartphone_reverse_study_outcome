package com.bytedance.ee.bear.document.offline.base;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public class FetchModel implements Serializable {
    public String body;
    public boolean checkResponseDataJSONValid;
    public Map<String, String> headers;
    public String iframeJsbCheck;
    public boolean isProxy;
    public String key;
    public String method;
    public int priority;
    public int retryCount;
    public String url;

    public String toString() {
        return "{key='" + this.key + "', url='" + this.url + "'isProxy='" + this.isProxy + "', method='" + this.method + "', headers=" + this.headers + ", body='" + this.body + "', priority='" + this.priority + "', iframeJsbCheck='" + this.iframeJsbCheck + "', retryCount=" + this.retryCount + "', checkResponseDataJSONValid=" + this.checkResponseDataJSONValid + "'}";
    }

    public FetchModel() {
        this.retryCount = 3;
    }
}
