package com.bytedance.ee.bear.document.render.preload;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class BridgeReadyModel implements Serializable {
    private String data;
    private String type;

    public String toString() {
        return "BridgeReadyModel{type='" + this.type + "', data='" + this.data + "'}";
    }

    public BridgeReadyModel() {
    }

    public String getData() {
        return this.data;
    }

    public String getType() {
        return this.type;
    }

    public void setData(String r1) {
        this.data = r1;
    }

    public void setType(String r1) {
        this.type = r1;
    }
}
