package com.bytedance.map.api.model;

/* JADX INFO: loaded from: classes21.dex */
public class BDPoi {
    private BDLatLng mCoordinate;
    private String mName;
    private String mPoiId;

    public BDPoi() {
    }

    public String toString() {
        return "BDPoi{mPoiId=" + this.mPoiId + ", mName=" + this.mName + ", mCoordinate=" + this.mCoordinate + '}';
    }

    public BDLatLng getCoordinate() {
        return this.mCoordinate;
    }

    public String getName() {
        return this.mName;
    }

    public String getPoiId() {
        return this.mPoiId;
    }

    public void setCoordinate(BDLatLng r100) {
        this.mCoordinate = r100;
    }

    public void setName(String r100) {
        this.mName = r100;
    }

    public void setPoiId(String r100) {
        this.mPoiId = r100;
    }

    public BDPoi(String r100, BDLatLng r101, String r102) {
        this.mName = r100;
        this.mCoordinate = r101;
        this.mPoiId = r102;
    }
}
