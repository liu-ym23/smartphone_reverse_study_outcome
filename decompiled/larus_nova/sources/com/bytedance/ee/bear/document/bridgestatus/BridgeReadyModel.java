package com.bytedance.ee.bear.document.bridgestatus;

import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
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

    public void setData(String r100) {
        this.data = r100;
    }

    public void setType(String r100) {
        this.type = r100;
    }
}
