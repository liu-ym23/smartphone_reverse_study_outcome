package com.ss.android.lark.chameleon.bridge;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chameleon/bridge/Message;", "Ljava/io/Serializable;", "()V", "apiName", "", "getApiName", "()Ljava/lang/String;", "setApiName", "(Ljava/lang/String;)V", "callbackID", "getCallbackID", "setCallbackID", "data", "getData", "setData", "extra", "getExtra", "setExtra", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Message implements Serializable {

    @SerializedName("apiName")
    private String apiName;

    @SerializedName("callbackID")
    private String callbackID;

    @SerializedName("data")
    private String data;

    @SerializedName("extra")
    private String extra;

    public Message() {
    }

    public final String getApiName() {
        return this.apiName;
    }

    public final String getCallbackID() {
        return this.callbackID;
    }

    public final String getData() {
        return this.data;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final void setApiName(String r100) {
        this.apiName = r100;
    }

    public final void setCallbackID(String r100) {
        this.callbackID = r100;
    }

    public final void setData(String r100) {
        this.data = r100;
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }
}
