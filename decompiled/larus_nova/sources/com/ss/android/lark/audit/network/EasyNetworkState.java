package com.ss.android.lark.audit.network;

import java.io.Serializable;

/* JADX INFO: loaded from: classes34.dex */
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
