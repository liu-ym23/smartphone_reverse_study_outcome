package com.bytedance.pia.core.bridge.methods;

import com.bytedance.pia.core.metrics.ErrorType;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes21.dex */
public class b0 {

    @SerializedName("error")
    private String error;

    @SerializedName(ErrorType.WORKER)
    private String worker;

    public b0(String r100, String r101) {
        this.worker = r100;
        this.error = r101;
    }
}
