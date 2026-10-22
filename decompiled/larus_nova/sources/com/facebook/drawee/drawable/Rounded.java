package com.facebook.drawee.drawable;

/* JADX INFO: loaded from: classes3.dex */
public interface Rounded {
    int getBorderColor();

    float getBorderWidth();

    float getPadding();

    float[] getRadii();

    boolean getScaleDownInsideBorders();

    boolean isCircle();

    void setBorder(int r100, float r101);

    void setCircle(boolean r100);

    void setPadding(float r100);

    void setRadii(float[] r100);

    void setRadius(float r100);

    void setScaleDownInsideBorders(boolean r100);
}
