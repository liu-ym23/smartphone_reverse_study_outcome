package com.bytedance.ug.sdk.share.impl.network.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class GetShareInfoResponse implements Serializable {

    @SerializedName("share_info_list")
    List<ShareInfo> mShareInfoList;

    @SerializedName("share_policy")
    private int mSharePolicy;

    @SerializedName("err_no")
    private int mStatus;

    @SerializedName("err_tips")
    private String mTips;

    public GetShareInfoResponse() {
    }

    public List<ShareInfo> getShareInfoList() {
        return this.mShareInfoList;
    }

    public int getSharePolicy() {
        return this.mSharePolicy;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getTips() {
        return this.mTips;
    }

    public void setShareInfoList(List<ShareInfo> r100) {
        this.mShareInfoList = r100;
    }

    public void setSharePolicy(int r100) {
        this.mSharePolicy = r100;
    }

    public void setStatus(int r100) {
        this.mStatus = r100;
    }

    public void setTips(String r100) {
        this.mTips = r100;
    }
}
