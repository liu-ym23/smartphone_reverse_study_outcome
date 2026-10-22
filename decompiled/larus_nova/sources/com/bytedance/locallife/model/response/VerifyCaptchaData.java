package com.bytedance.locallife.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes21.dex */
public class VerifyCaptchaData implements Serializable {

    @SerializedName("captcha")
    public String captcha;

    @SerializedName("desc_url")
    public String desc_url;

    @SerializedName("description")
    public String description;

    @SerializedName("error_code")
    public int error_code;

    @SerializedName("verify_center_decision_conf")
    public String verify_center_decision_conf;

    public VerifyCaptchaData() {
    }
}
