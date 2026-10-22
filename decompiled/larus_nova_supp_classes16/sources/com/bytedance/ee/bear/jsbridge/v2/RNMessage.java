package com.bytedance.ee.bear.jsbridge.v2;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/jsbridge/v2/RNMessage;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "apiName", "", "getApiName", "()Ljava/lang/String;", "setApiName", "(Ljava/lang/String;)V", "callbackID", "getCallbackID", "setCallbackID", "data", "", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "plugin-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RNMessage implements NonProguard {
    private String apiName;
    private String callbackID;
    private Object data;

    public RNMessage() {
    }

    public final String getApiName() {
        return this.apiName;
    }

    public final String getCallbackID() {
        return this.callbackID;
    }

    public final Object getData() {
        return this.data;
    }

    public final void setApiName(String r1) {
        this.apiName = r1;
    }

    public final void setCallbackID(String r1) {
        this.callbackID = r1;
    }

    public final void setData(Object r1) {
        this.data = r1;
    }
}
