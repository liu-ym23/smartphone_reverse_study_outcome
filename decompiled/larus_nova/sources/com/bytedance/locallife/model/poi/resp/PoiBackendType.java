package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes21.dex */
public class PoiBackendType implements Serializable {

    @SerializedName("code")
    String code;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    public String desc;

    @SerializedName("name")
    String name;

    public PoiBackendType() {
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public PoiBackendType(String r100, String r101) {
        this.code = r100;
        this.name = r101;
    }
}
