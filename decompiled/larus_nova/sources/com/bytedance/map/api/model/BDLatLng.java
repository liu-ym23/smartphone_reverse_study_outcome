package com.bytedance.map.api.model;

/* JADX INFO: loaded from: classes21.dex */
public class BDLatLng {
    private boolean mIsMainPoint;
    private double mLatitude;
    private double mLongitude;

    public String toString() {
        return "BDLatLng{mLatitude=" + this.mLatitude + ", mLongitude=" + this.mLongitude + ", mIsMainPoint" + this.mIsMainPoint + '}';
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public boolean isMainPoint() {
        return this.mIsMainPoint;
    }

    public void setLatitude(double r100) {
        this.mLatitude = r100;
    }

    public void setLongitude(double r100) {
        this.mLongitude = r100;
    }

    public void setMainPoint(boolean r100) {
        this.mIsMainPoint = r100;
    }

    public BDLatLng(BDLatLng r100, boolean r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        this.mLatitude = r100.getLatitude();
        this.mLongitude = r100.getLongitude();
        this.mIsMainPoint = r101;
    }

    public BDLatLng(double r100, double r101) {
        this.mLatitude = r100;
        this.mLongitude = r101;
    }
}
