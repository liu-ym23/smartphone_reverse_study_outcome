package com.bytedance.ug.sdk.share.impl.network.model;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes22.dex */
public class FetchTokenResponse implements Serializable {

    @SerializedName("data")
    private JsonObject data;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private int status;

    public FetchTokenResponse() {
    }

    public JsonObject getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus() {
        return this.status;
    }

    public void setData(JsonObject r100) {
        this.data = r100;
    }

    public void setMessage(String r100) {
        this.message = r100;
    }

    public void setStatus(int r100) {
        this.status = r100;
    }
}
