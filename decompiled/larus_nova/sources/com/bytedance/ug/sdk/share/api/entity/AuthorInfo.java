package com.bytedance.ug.sdk.share.api.entity;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes22.dex */
public class AuthorInfo implements Serializable {

    @SerializedName("avatar_url")
    private String mAvatarUrl;

    @SerializedName("extra")
    private JsonObject mExtra;

    @SerializedName("name")
    private String mName;

    public AuthorInfo() {
    }

    public String getAvatarUrl() {
        return this.mAvatarUrl;
    }

    public JsonObject getExtra() {
        return this.mExtra;
    }

    public String getName() {
        return this.mName;
    }

    public void setAvatarUrl(String r100) {
        this.mAvatarUrl = r100;
    }

    public void setExtra(JsonObject r100) {
        this.mExtra = r100;
    }

    public void setName(String r100) {
        this.mName = r100;
    }
}
