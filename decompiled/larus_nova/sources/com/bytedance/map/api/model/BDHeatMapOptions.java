package com.bytedance.map.api.model;

import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class BDHeatMapOptions {
    private int[] mColorArray;
    private List<BDWeightedLatLng> mData;
    private String mId;
    private int mRadius;
    private float[] mStepArray;
    private float mZIndex;

    public BDHeatMapOptions() {
    }

    public int[] getColorArray() {
        return this.mColorArray;
    }

    public List<BDWeightedLatLng> getData() {
        return this.mData;
    }

    public String getId() {
        return this.mId;
    }

    public int getRadius() {
        return this.mRadius;
    }

    public float[] getStepArray() {
        return this.mStepArray;
    }

    public float getZIndex() {
        return this.mZIndex;
    }

    public void setColorArray(int[] r100) {
        this.mColorArray = r100;
    }

    public void setData(List<BDWeightedLatLng> r100) {
        this.mData = r100;
    }

    public void setId(String r100) {
        this.mId = r100;
    }

    public void setRadius(int r100) {
        this.mRadius = r100;
    }

    public void setStepArray(float[] r100) {
        this.mStepArray = r100;
    }

    public void setZIndex(float r100) {
        this.mZIndex = r100;
    }

    public BDHeatMapOptions(List<BDWeightedLatLng> r100, int[] r101, float[] r110, int r111, float r112) {
        this(r100, r101, r110, r111, r112, "");
    }

    public BDHeatMapOptions(List<BDWeightedLatLng> r100, int[] r101, float[] r102, int r103, float r104, String r105) {
        this.mData = r100;
        this.mColorArray = r101;
        this.mStepArray = r102;
        this.mRadius = r103;
        this.mZIndex = r104;
        this.mId = r105;
    }
}
