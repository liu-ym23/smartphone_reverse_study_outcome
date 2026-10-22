package com.bytedance.map.api.model;

import android.graphics.Bitmap;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public interface IPolyline {
    String getId();

    boolean isCollideWithPoi();

    void remove();

    void setAlpha(float r100);

    void setCollideWithPoi(boolean r100);

    void setColor(int r100);

    void setColorList(List<Integer> r100);

    void setCustomTexture(Bitmap r100);

    void setCustomTextureList(List<Bitmap> r100);

    void setDottedLine(boolean r100);

    void setPoints(List<BDLatLng> r100);

    void setTextureIndexList(List<Integer> r100);

    void setWidth(float r100);

    void setZIndex(float r100);
}
