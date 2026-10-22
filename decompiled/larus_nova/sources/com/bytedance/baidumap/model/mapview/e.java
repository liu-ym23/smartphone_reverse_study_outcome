package com.bytedance.baidumap.model.mapview;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import com.baidu.mapapi.map.BaiduMap;
import com.bytedance.map.api.model.BDMapStyleOptions;

/* JADX INFO: loaded from: classes7.dex */
public interface e {
    void a(boolean r100);

    void b();

    void c(boolean r100);

    boolean d();

    void e(BDMapStyleOptions r100, CustomStyleLoadTrace r101);

    void f(boolean r100, String r101, CustomStyleLoadTrace r102);

    boolean g();

    int getLogoPosition();

    BaiduMap getMap();

    View getRealMapView();

    Point getScaleControlPosition();

    void h(boolean r100);

    boolean i();

    void j(Context r100, Bundle r101);

    void onDestroy();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle r100);

    void setLogoPosition(int r100);

    void setScaleControlPosition(Point r100);
}
