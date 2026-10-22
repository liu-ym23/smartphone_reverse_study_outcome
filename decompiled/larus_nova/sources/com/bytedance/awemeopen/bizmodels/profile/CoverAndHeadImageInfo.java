package com.bytedance.awemeopen.bizmodels.profile;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public class CoverAndHeadImageInfo implements Serializable {

    @SerializedName("profile_cover_list")
    List<ProfileUrlModel> coverList;

    public CoverAndHeadImageInfo() {
    }

    public List<ProfileUrlModel> getCoverList() {
        return this.coverList;
    }

    public void setCoverList(List<ProfileUrlModel> r100) {
        this.coverList = r100;
    }
}
