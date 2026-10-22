package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes21.dex */
public class ShareInfo implements Serializable {

    @SerializedName("life_share_ext")
    String lifeShareExt;

    public ShareInfo() {
    }

    public String getLifeShareExt() {
        return this.lifeShareExt;
    }

    public void setLifeShareExt(String r100) {
        this.lifeShareExt = r100;
    }
}
