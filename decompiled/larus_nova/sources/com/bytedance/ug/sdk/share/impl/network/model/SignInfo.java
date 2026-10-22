package com.bytedance.ug.sdk.share.impl.network.model;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes22.dex */
public class SignInfo implements Serializable {
    private static final int CONTINUE_SHARE = 0;
    private static final int DISCONTINUE_SHARE = 1;

    @SerializedName("log_id")
    private String mLogId;

    @SerializedName("signature")
    private String mSignature;

    @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    private int mStrategy;

    public boolean continueShare() {
        if (this.mStrategy != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public SignInfo() {
        this.mStrategy = 0;
    }

    public String getLogId() {
        return this.mLogId;
    }

    public String getSignature() {
        return this.mSignature;
    }

    public int getStrategy() {
        return this.mStrategy;
    }

    public void setLogId(String r100) {
        this.mLogId = r100;
    }

    public void setSignature(String r100) {
        this.mSignature = r100;
    }

    public void setStrategy(int r100) {
        this.mStrategy = r100;
    }
}
