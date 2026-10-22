package com.bytedance.map.api.model;

/* JADX INFO: loaded from: classes21.dex */
public interface ICircle {
    boolean contains(BDLatLng r100);

    String getId();

    double getRadius();

    void remove();

    void setFillColor(int r100);

    void setLineWidth(float r100);

    void setStrokeColor(int r100);

    void updateCenter(BDLatLng r100);

    void updateRadius(double r100);
}
