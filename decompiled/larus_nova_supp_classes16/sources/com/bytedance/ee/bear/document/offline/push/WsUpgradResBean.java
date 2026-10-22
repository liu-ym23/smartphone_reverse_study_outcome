package com.bytedance.ee.bear.document.offline.push;

import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public void setType(String r1) {
        this.type = r1;
    }

    public void setVersion(int r1) {
        this.version = r1;
    }
}
