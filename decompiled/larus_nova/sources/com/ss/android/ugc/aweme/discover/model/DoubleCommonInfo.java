package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/DoubleCommonInfo;", "Ljava/io/Serializable;", "()V", "infos", "", "Lcom/ss/android/ugc/aweme/discover/model/CommonInfo;", "getInfos", "()Ljava/util/List;", "setInfos", "(Ljava/util/List;)V", "pointType", "", "getPointType", "()Ljava/lang/Integer;", "setPointType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "sellingPtInfo", "", "getSellingPtInfo", "()Ljava/lang/String;", "setSellingPtInfo", "(Ljava/lang/String;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DoubleCommonInfo implements Serializable {

    @SerializedName("text")
    private List<CommonInfo> infos;

    @SerializedName("point_type")
    private Integer pointType;

    @SerializedName(a.KEY_SELLING_PT_INFO)
    private String sellingPtInfo;

    public DoubleCommonInfo() {
    }

    public final List<CommonInfo> getInfos() {
        return this.infos;
    }

    public final Integer getPointType() {
        return this.pointType;
    }

    public final String getSellingPtInfo() {
        return this.sellingPtInfo;
    }

    public final void setInfos(List<CommonInfo> r100) {
        this.infos = r100;
    }

    public final void setPointType(Integer r100) {
        this.pointType = r100;
    }

    public final void setSellingPtInfo(String r100) {
        this.sellingPtInfo = r100;
    }
}
