package com.bytedance.map.api.listener;

import android.view.MotionEvent;
import com.bytedance.map.api.model.BDLatLng;

/* JADX INFO: loaded from: classes21.dex */
public interface MapActionListener {
    void onMapClick(BDLatLng r100);

    void onMapLoad();

    void onMapMove(BDLatLng r100);

    void onMapMoveEnd(BDLatLng r100);

    void onMapTouch(MotionEvent r100);

    void onMapZoom(float r100);

    void onMapZoomEnd(float r100);
}
