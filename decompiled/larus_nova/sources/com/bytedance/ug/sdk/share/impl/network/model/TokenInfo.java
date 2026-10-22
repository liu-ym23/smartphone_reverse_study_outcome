package com.bytedance.ug.sdk.share.impl.network.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes22.dex */
public class TokenInfo implements Serializable {

    @SerializedName("description")
    private String mDescription;

    @SerializedName("tips")
    private String mTips;

    @SerializedName("title")
    private String mTitle;

    public TokenInfo() {
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getTips() {
        return this.mTips;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setDescription(String r100) {
        this.mDescription = r100;
    }

    public void setTips(String r100) {
        this.mTips = r100;
    }

    public void setmTitle(String r100) {
        this.mTitle = r100;
    }
}
