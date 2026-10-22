package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00106\u001a\u00020\u0013J\u0006\u00107\u001a\u00020\u0013J\u0006\u00108\u001a\u000209R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R \u0010'\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R \u0010*\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R \u0010-\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0015\"\u0004\b/\u0010\u0017R\u001e\u00100\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR \u00103\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0015\"\u0004\b5\u0010\u0017¨\u0006:"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/SimplePoiInfoStruct;", "Ljava/io/Serializable;", "()V", "collectCount", "", "getCollectCount", "()J", "setCollectCount", "(J)V", "collectStatus", "getCollectStatus", "setCollectStatus", "cover", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "getCover", "()Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "setCover", "(Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;)V", "optionName", "", "getOptionName", "()Ljava/lang/String;", "setOptionName", "(Ljava/lang/String;)V", "poiAddress", "Lcom/bytedance/locallife/model/poi/resp/PoiAddress;", "getPoiAddress", "()Lcom/bytedance/locallife/model/poi/resp/PoiAddress;", "setPoiAddress", "(Lcom/bytedance/locallife/model/poi/resp/PoiAddress;)V", "poiBackendType", "Lcom/bytedance/locallife/model/poi/resp/PoiBackendType;", "getPoiBackendType", "()Lcom/bytedance/locallife/model/poi/resp/PoiBackendType;", "setPoiBackendType", "(Lcom/bytedance/locallife/model/poi/resp/PoiBackendType;)V", "poiDetailSchema", "getPoiDetailSchema", "setPoiDetailSchema", "poiId", "getPoiId", "setPoiId", "poiName", "getPoiName", "setPoiName", "poiRankDesc", "getPoiRankDesc", "setPoiRankDesc", "rankScore", "getRankScore", "setRankScore", "trackerParams", "getTrackerParams", "setTrackerParams", "getCityCode", "getPoiBackendTypeCode", "isCollected", "", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SimplePoiInfoStruct implements Serializable {

    @SerializedName("collect_count")
    private long collectCount;

    @SerializedName("collect_status")
    private long collectStatus;

    @SerializedName("cover")
    private PoiImageUrlModel cover;

    @SerializedName("option_name")
    private String optionName;

    @SerializedName("address_info")
    private PoiAddress poiAddress;

    @SerializedName("poi_backend_type")
    private PoiBackendType poiBackendType;

    @SerializedName("schema")
    private String poiDetailSchema;

    @SerializedName("poi_id")
    private String poiId;

    @SerializedName("poi_name")
    private String poiName;

    @SerializedName("poi_rank_desc")
    private String poiRankDesc;

    @SerializedName("rank_score")
    private long rankScore;

    @SerializedName("tracker_params")
    private String trackerParams;

    public SimplePoiInfoStruct() {
    }

    public final String getCityCode() {
        PoiAddress r100 = this.poiAddress;
        if (r100 == null) goto L5;
        String r101 = r100.cityCode;
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final String getPoiBackendTypeCode() {
        PoiBackendType r100 = this.poiBackendType;
        if (r100 == null) goto L5;
        String r101 = r100.getCode();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final boolean isCollected() {
        if (this.collectStatus != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public final long getCollectCount() {
        return this.collectCount;
    }

    public final long getCollectStatus() {
        return this.collectStatus;
    }

    public final PoiImageUrlModel getCover() {
        return this.cover;
    }

    public final String getOptionName() {
        return this.optionName;
    }

    public final PoiAddress getPoiAddress() {
        return this.poiAddress;
    }

    public final PoiBackendType getPoiBackendType() {
        return this.poiBackendType;
    }

    public final String getPoiDetailSchema() {
        return this.poiDetailSchema;
    }

    public final String getPoiId() {
        return this.poiId;
    }

    public final String getPoiName() {
        return this.poiName;
    }

    public final String getPoiRankDesc() {
        return this.poiRankDesc;
    }

    public final long getRankScore() {
        return this.rankScore;
    }

    public final String getTrackerParams() {
        return this.trackerParams;
    }

    public final void setCollectCount(long r100) {
        this.collectCount = r100;
    }

    public final void setCollectStatus(long r100) {
        this.collectStatus = r100;
    }

    public final void setCover(PoiImageUrlModel r100) {
        this.cover = r100;
    }

    public final void setOptionName(String r100) {
        this.optionName = r100;
    }

    public final void setPoiAddress(PoiAddress r100) {
        this.poiAddress = r100;
    }

    public final void setPoiBackendType(PoiBackendType r100) {
        this.poiBackendType = r100;
    }

    public final void setPoiDetailSchema(String r100) {
        this.poiDetailSchema = r100;
    }

    public final void setPoiId(String r100) {
        this.poiId = r100;
    }

    public final void setPoiName(String r100) {
        this.poiName = r100;
    }

    public final void setPoiRankDesc(String r100) {
        this.poiRankDesc = r100;
    }

    public final void setRankScore(long r100) {
        this.rankScore = r100;
    }

    public final void setTrackerParams(String r100) {
        this.trackerParams = r100;
    }
}
