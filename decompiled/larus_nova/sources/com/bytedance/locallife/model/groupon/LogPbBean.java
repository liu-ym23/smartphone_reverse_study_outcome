package com.bytedance.locallife.model.groupon;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public class LogPbBean implements Serializable {

    @SerializedName("impr_id")
    String imprId;

    @SerializedName("log_extra")
    Map<String, Object> logExtra;

    public Map logPbToMap() {
        LinkedTreeMap r100 = new LinkedTreeMap();
        r100.put("impr_id", this.imprId);
        r100.put("log_extra", this.logExtra);
        return r100;
    }

    public LogPbBean() {
    }

    public Map getExtra() {
        return this.logExtra;
    }

    public String getImprId() {
        return this.imprId;
    }

    public void setExtra(Map r100) {
        this.logExtra = r100;
    }

    public void setImprId(String r100) {
        this.imprId = r100;
    }
}
