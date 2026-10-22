package com.bytedance.map.api.model;

/* JADX INFO: loaded from: classes21.dex */
public class BDWeightedLatLng {
    private final BDLatLng latLng;
    private final double weight;

    public BDLatLng getLatLng() {
        return this.latLng;
    }

    public double getWeight() {
        return this.weight;
    }

    public BDWeightedLatLng(BDLatLng r100, double r101) {
        this.latLng = r100;
        this.weight = r101;
    }
}
