package com.bytedance.awemeopen.bizmodels.profile;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes44.dex */
public class ProfileUrlModel implements Serializable {

    @SerializedName("dark_cover_color")
    String darkCoverColor;

    @SerializedName("light_cover_color")
    String lightCoverColor;

    @SerializedName("cover_url")
    t14.a urlStruct;

    public ProfileUrlModel() {
    }

    public String getDarkCoverColor() {
        return this.darkCoverColor;
    }

    public String getLightCoverColor() {
        return this.lightCoverColor;
    }

    public t14.a getUrlStruct() {
        return this.urlStruct;
    }

    public void setDarkCoverColor(String r100) {
        this.darkCoverColor = r100;
    }

    public void setLightCoverColor(String r100) {
        this.lightCoverColor = r100;
    }

    public void setUrlStruct(t14.a r100) {
        this.urlStruct = r100;
    }
}
