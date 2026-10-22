package com.bytedance.crypto.cloudsync.network;

import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public class NetworkRequest {
    private List<String> appList;
    private String certChain;
    private String challenge;
    private String publicKey;
    private String requestType;
    private String requestUrl;
    private String rootKeyName;

    public NetworkRequest() {
    }

    public List<String> getAppList() {
        return this.appList;
    }

    public String getCertChain() {
        return this.certChain;
    }

    public String getChallenge() {
        return this.challenge;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public String getRequestType() {
        return this.requestType;
    }

    public String getRequestUrl() {
        return this.requestUrl;
    }

    public String getRootKeyName() {
        return this.rootKeyName;
    }

    public void setAppList(List<String> r100) {
        this.appList = r100;
    }

    public void setCertChain(String r100) {
        this.certChain = r100;
    }

    public void setChallenge(String r100) {
        this.challenge = r100;
    }

    public void setPublicKey(String r100) {
        this.publicKey = r100;
    }

    public void setRequestType(String r100) {
        this.requestType = r100;
    }

    public void setRequestUrl(String r100) {
        this.requestUrl = r100;
    }

    public void setRootKeyName(String r100) {
        this.rootKeyName = r100;
    }
}
