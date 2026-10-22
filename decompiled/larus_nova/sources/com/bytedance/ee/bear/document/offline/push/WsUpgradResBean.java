package com.bytedance.ee.bear.document.offline.push;

import java.io.Serializable;

/* JADX INFO: loaded from: classes16.dex */
public class WsUpgradResBean implements Serializable {
    private String type;
    private int version;

    public WsUpgradResBean() {
    }

    public String getType() {
        return this.type;
    }

    public int getVersion() {
        return this.version;
    }

    public void setType(String r100) {
        this.type = r100;
    }

    public void setVersion(int r100) {
        this.version = r100;
    }
}
