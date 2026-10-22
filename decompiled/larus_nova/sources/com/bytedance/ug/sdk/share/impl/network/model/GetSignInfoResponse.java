package com.bytedance.ug.sdk.share.impl.network.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes22.dex */
public class GetSignInfoResponse implements Serializable {

    @SerializedName("data")
    private SignInfo mSignInfo;

    @SerializedName("err_no")
    private int mStatus;

    public GetSignInfoResponse() {
    }

    public SignInfo getSignInfo() {
        return this.mSignInfo;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setSignInfo(SignInfo r100) {
        this.mSignInfo = r100;
    }

    public void setStatus(int r100) {
        this.mStatus = r100;
    }
}
