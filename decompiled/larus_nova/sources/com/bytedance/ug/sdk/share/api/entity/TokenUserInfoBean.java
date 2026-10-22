package com.bytedance.ug.sdk.share.api.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes22.dex */
public class TokenUserInfoBean implements Serializable {

    @SerializedName("avatar_url")
    private String mAvatarUrl;

    @SerializedName("name")
    private String mName;

    @SerializedName("source_open_url")
    private String mSourceOpenUrl;

    @SerializedName("user_id")
    private long mUserId;

    public TokenUserInfoBean() {
    }

    public String getAvatarUrl() {
        return this.mAvatarUrl;
    }

    public String getName() {
        return this.mName;
    }

    public String getSourceOpenUrl() {
        return this.mSourceOpenUrl;
    }

    public long getUserId() {
        return this.mUserId;
    }

    public void setAvatarUrl(String r100) {
        this.mAvatarUrl = r100;
    }

    public void setName(String r100) {
        this.mName = r100;
    }

    public void setSourceOpenUrl(String r100) {
        this.mSourceOpenUrl = r100;
    }

    public void setUserId(long r100) {
        this.mUserId = r100;
    }
}
