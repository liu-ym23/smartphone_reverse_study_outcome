package com.bytedance.map.api.model;

import android.graphics.Typeface;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public interface ITextPath {
    String getId();

    List<BDLatLng> getPoints();

    String getText();

    int getTextBorderColor();

    int getTextBorderWidth();

    int getTextColor();

    int getTextSize();

    Typeface getTypeface();

    float getZIndex();

    void remove();

    void setPoints(List<BDLatLng> r100);

    void setText(String r100);

    void setTextBorderColor(int r100);

    void setTextBorderWidth(int r100);

    void setTextColor(int r100);

    void setTextSize(int r100);

    void setTypeface(Typeface r100);

    void setZIndex(float r100);
}
