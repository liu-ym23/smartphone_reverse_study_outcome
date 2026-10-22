package com.ss.android.ugc.aweme.discover.model.commodity.select;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/DeleteRenderInfo;", "Ljava/io/Serializable;", "()V", "deleteKey", "", "getDeleteKey", "()Ljava/lang/String;", "setDeleteKey", "(Ljava/lang/String;)V", "deleteValue", "getDeleteValue", "setDeleteValue", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeleteRenderInfo implements Serializable {

    @SerializedName("delete_key")
    private String deleteKey;

    @SerializedName("delete_value")
    private String deleteValue;

    public DeleteRenderInfo() {
    }

    public final String getDeleteKey() {
        return this.deleteKey;
    }

    public final String getDeleteValue() {
        return this.deleteValue;
    }

    public final void setDeleteKey(String r100) {
        this.deleteKey = r100;
    }

    public final void setDeleteValue(String r100) {
        this.deleteValue = r100;
    }
}
