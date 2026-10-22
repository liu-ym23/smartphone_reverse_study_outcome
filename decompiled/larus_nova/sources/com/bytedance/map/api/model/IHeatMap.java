package com.bytedance.map.api.model;

/* JADX INFO: loaded from: classes21.dex */
public interface IHeatMap {
    void clearTileCache();

    String getId();

    float getZIndex();

    boolean isVisible();

    void remove();

    void setVisible(boolean r100);

    void setZIndex(float r100);
}
