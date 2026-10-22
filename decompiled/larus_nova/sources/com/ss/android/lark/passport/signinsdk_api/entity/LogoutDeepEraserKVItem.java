package com.ss.android.lark.passport.signinsdk_api.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u0005H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/entity/LogoutDeepEraserKVItem;", "Ljava/io/Serializable;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "valueType", "getValueType", "setValueType", "toString", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LogoutDeepEraserKVItem implements Serializable {

    @SerializedName("key")
    private String key;

    @SerializedName("value_type")
    private String valueType;

    public String toString() {
        return "LogoutDeepEraserKVItem(key=" + this.key + ", valueType=" + this.valueType + ')';
    }

    public LogoutDeepEraserKVItem() {
        this.key = "";
        this.valueType = "";
    }

    public final String getKey() {
        return this.key;
    }

    public final String getValueType() {
        return this.valueType;
    }

    public final void setKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.key = r100;
    }

    public final void setValueType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.valueType = r100;
    }
}
