package com.ss.android.ugc.aweme.search.common.result.sug.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/sug/model/EcomSearchLynxData;", "Ljava/io/Serializable;", "()V", "jumpSchema", "", "getJumpSchema", "()Ljava/lang/String;", "setJumpSchema", "(Ljava/lang/String;)V", "jumpType", "getJumpType", "setJumpType", "rawData", "getRawData", "setRawData", "sugType", "getSugType", "setSugType", "uiType", "getUiType", "setUiType", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EcomSearchLynxData implements Serializable {

    @SerializedName("jump_schema")
    private String jumpSchema;

    @SerializedName("jump_type")
    private String jumpType;

    @SerializedName(EventConstant.Key.RAW_DATA)
    private String rawData;

    @SerializedName("sug_type")
    private String sugType;

    @SerializedName("ui_type")
    private String uiType;

    public EcomSearchLynxData() {
        this.sugType = "";
        this.uiType = "";
        this.jumpType = "";
        this.jumpSchema = "";
        this.rawData = "";
    }

    public final String getJumpSchema() {
        return this.jumpSchema;
    }

    public final String getJumpType() {
        return this.jumpType;
    }

    public final String getRawData() {
        return this.rawData;
    }

    public final String getSugType() {
        return this.sugType;
    }

    public final String getUiType() {
        return this.uiType;
    }

    public final void setJumpSchema(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.jumpSchema = r100;
    }

    public final void setJumpType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.jumpType = r100;
    }

    public final void setRawData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rawData = r100;
    }

    public final void setSugType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.sugType = r100;
    }

    public final void setUiType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.uiType = r100;
    }
}
