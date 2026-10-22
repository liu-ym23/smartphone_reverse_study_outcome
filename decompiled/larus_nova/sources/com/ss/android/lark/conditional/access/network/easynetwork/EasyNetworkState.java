package com.ss.android.lark.conditional.access.network.easynetwork;

import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class EasyNetworkState implements Serializable {
    private EasyNetworkType easyNetworkType;
    private String networkId;

    public String toString() {
        return "EasyNetworkState{easyNetworkType=" + this.easyNetworkType.toString() + ", networkId='" + this.networkId + "'}";
    }

    public EasyNetworkType getEasyNetworkType() {
        return this.easyNetworkType;
    }

    public String getNetworkId() {
        return this.networkId;
    }

    public boolean sameAs(EasyNetworkState r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.easyNetworkType == this.easyNetworkType) goto L8;
        return false;
    L8:
        if (r100.networkId != this.networkId) goto L12;
        return true;
    L12:
        return false;
    }

    public void setEasyNetworkType(EasyNetworkType r100) {
        this.easyNetworkType = r100;
    }

    public void setNetworkId(String r100) {
        this.networkId = r100;
    }

    public EasyNetworkState(EasyNetworkType r100, String r101) {
        this.easyNetworkType = r100;
        this.networkId = r101;
    }
}
