package com.bytedance.map.api.model;

/* JADX INFO: loaded from: classes21.dex */
public interface IArc {
    int getColor();

    String getId();

    int getWidth();

    float getZIndex();

    boolean isVisible();

    void remove();

    void setColor(int r100);

    void setVisible(boolean r100);

    void setWidth(int r100);

    void setZIndex(float r100);
}
