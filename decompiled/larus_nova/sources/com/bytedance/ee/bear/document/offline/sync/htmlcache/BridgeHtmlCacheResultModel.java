package com.bytedance.ee.bear.document.offline.sync.htmlcache;

import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class BridgeHtmlCacheResultModel implements Serializable {
    private boolean success;
    private String token;
    private String type;

    public String toString() {
        return "BridgeHtmlCacheResultModel{type='" + this.type + "', token='', success=" + this.success + '}';
    }

    public BridgeHtmlCacheResultModel() {
    }

    public String getToken() {
        return this.token;
    }

    public String getType() {
        return this.type;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean r100) {
        this.success = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setType(String r100) {
        this.type = r100;
    }
}
