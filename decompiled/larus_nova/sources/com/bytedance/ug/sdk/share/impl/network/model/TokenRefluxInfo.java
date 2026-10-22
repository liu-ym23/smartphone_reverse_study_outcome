package com.bytedance.ug.sdk.share.impl.network.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes22.dex */
public class TokenRefluxInfo {

    @SerializedName(LocationMonitorConst.IDENTIFIER)
    private String mId;

    @SerializedName("reflex_url")
    private String mReflexUrl;

    @SerializedName("token")
    private String mToken;

    public TokenRefluxInfo() {
    }

    public String getId() {
        return this.mId;
    }

    public String getReflexUrl() {
        return this.mReflexUrl;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setId(String r100) {
        this.mId = r100;
    }

    public void setReflexUrl(String r100) {
        this.mReflexUrl = r100;
    }

    public void setToken(String r100) {
        this.mToken = r100;
    }
}
