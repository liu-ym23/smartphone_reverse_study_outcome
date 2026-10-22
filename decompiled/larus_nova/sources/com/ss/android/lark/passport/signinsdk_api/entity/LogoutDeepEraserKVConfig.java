package com.ss.android.lark.passport.signinsdk_api.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR2\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/entity/LogoutDeepEraserKVConfig;", "Ljava/io/Serializable;", "<init>", "()V", "fileName", "", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "valueList", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/passport/signinsdk_api/entity/LogoutDeepEraserKVItem;", "Lkotlin/collections/ArrayList;", "getValueList", "()Ljava/util/ArrayList;", "setValueList", "(Ljava/util/ArrayList;)V", "toString", "signinsdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LogoutDeepEraserKVConfig implements Serializable {

    @SerializedName("name")
    private String fileName;

    @SerializedName("values")
    private ArrayList<LogoutDeepEraserKVItem> valueList;

    public LogoutDeepEraserKVConfig() {
    }

    public String toString() {
        return "LogoutDeepEraserKVConfig(fileName=" + this.fileName + ", valueList=" + this.valueList + ')';
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final ArrayList<LogoutDeepEraserKVItem> getValueList() {
        return this.valueList;
    }

    public final void setFileName(String r100) {
        this.fileName = r100;
    }

    public final void setValueList(ArrayList<LogoutDeepEraserKVItem> r100) {
        this.valueList = r100;
    }
}
