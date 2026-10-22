package com.bytedance.map.api.model;

import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public interface IPolygon {
    String getId();

    List<BDLatLng> getPoints();

    boolean isClickable();

    void remove();

    void setClickable(boolean r100);

    void setFillColor(int r100);

    void setLineWidth(float r100);

    void setStrokeColor(int r100);

    void updatePoints(List<BDLatLng> r100);
}
