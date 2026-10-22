package com.bytedance.ee.larkwebview.bridge;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/larkwebview/bridge/Message;", "Ljava/io/Serializable;", "<init>", "()V", "apiName", "", "getApiName", "()Ljava/lang/String;", "setApiName", "(Ljava/lang/String;)V", "data", "getData", "setData", "callbackID", "getCallbackID", "setCallbackID", "extra", "getExtra", "setExtra", "lark-webview-base_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Message implements Serializable {
    private String apiName;
    private String callbackID;
    private String data;
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
