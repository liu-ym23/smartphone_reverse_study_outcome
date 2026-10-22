package com.bytedance.ee.docsdk.impl.document.plugins.fail;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\nH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/fail/FailEventData;", "Ljava/io/Serializable;", "()V", "result_code", "", "getResult_code", "()I", "setResult_code", "(I)V", "result_key", "", "getResult_key", "()Ljava/lang/String;", "setResult_key", "(Ljava/lang/String;)V", "toString", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FailEventData implements Serializable {

    @SerializedName("result_code")
    private int result_code;

    @SerializedName("result_key")
    private String result_key;

    public String toString() {
        return "FailEventData{result_key='" + this.result_key + "', result_code=" + this.result_code + '}';
    }

    public FailEventData() {
    }

    public final int getResult_code() {
        return this.result_code;
    }

    public final String getResult_key() {
        return this.result_key;
    }

    public final void setResult_code(int r100) {
        this.result_code = r100;
    }

    public final void setResult_key(String r100) {
        this.result_key = r100;
    }
}
