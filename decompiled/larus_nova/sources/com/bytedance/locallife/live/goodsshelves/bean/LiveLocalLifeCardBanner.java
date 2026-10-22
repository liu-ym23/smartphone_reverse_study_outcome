package com.bytedance.locallife.live.goodsshelves.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/bytedance/locallife/live/goodsshelves/bean/LiveLocalLifeCardBanner;", "Ljava/io/Serializable;", "()V", "poiCity", "", "getPoiCity", "()Ljava/lang/String;", "setPoiCity", "(Ljava/lang/String;)V", "poiDistrict", "getPoiDistrict", "setPoiDistrict", "poiId", "getPoiId", "setPoiId", "poiName", "getPoiName", "setPoiName", "poiRankName", "getPoiRankName", "setPoiRankName", "poiTown", "getPoiTown", "setPoiTown", "userDistance", "getUserDistance", "setUserDistance", "userLocateScene", "", "getUserLocateScene", "()I", "setUserLocateScene", "(I)V", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class LiveLocalLifeCardBanner implements Serializable {

    @SerializedName("poi_city")
    private String poiCity;

    @SerializedName("poi_district")
    private String poiDistrict;

    @SerializedName("poi_id")
    private String poiId;

    @SerializedName("poi_name")
    private String poiName;

    @SerializedName("poi_rank_name")
    private String poiRankName;

    @SerializedName("poi_town")
    private String poiTown;

    @SerializedName("user_distance")
    private String userDistance;

    @SerializedName("user_locate_scene")
    private int userLocateScene;

    public LiveLocalLifeCardBanner() {
    }

    public final String getPoiCity() {
        return this.poiCity;
    }

    public final String getPoiDistrict() {
        return this.poiDistrict;
    }

    public final String getPoiId() {
        return this.poiId;
    }

    public final String getPoiName() {
        return this.poiName;
    }

    public final String getPoiRankName() {
        return this.poiRankName;
    }

    public final String getPoiTown() {
        return this.poiTown;
    }

    public final String getUserDistance() {
        return this.userDistance;
    }

    public final int getUserLocateScene() {
        return this.userLocateScene;
    }

    public final void setPoiCity(String r100) {
        this.poiCity = r100;
    }

    public final void setPoiDistrict(String r100) {
        this.poiDistrict = r100;
    }

    public final void setPoiId(String r100) {
        this.poiId = r100;
    }

    public final void setPoiName(String r100) {
        this.poiName = r100;
    }

    public final void setPoiRankName(String r100) {
        this.poiRankName = r100;
    }

    public final void setPoiTown(String r100) {
        this.poiTown = r100;
    }

    public final void setUserDistance(String r100) {
        this.userDistance = r100;
    }

    public final void setUserLocateScene(int r100) {
        this.userLocateScene = r100;
    }
}
