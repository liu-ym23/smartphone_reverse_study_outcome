package com.bytedance.pia.core.bridge.methods;

import com.bytedance.pia.core.metrics.ErrorType;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes21.dex */
public class c0 {

    @SerializedName("message")
    private JsonObject message;

    @SerializedName(ErrorType.WORKER)
    private String worker;

    public c0(String r100, JsonObject r101) {
        this.worker = r100;
        this.message = r101;
    }
}
