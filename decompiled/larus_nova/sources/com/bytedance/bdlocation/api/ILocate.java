package com.bytedance.bdlocation.api;

import android.os.Looper;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationOption;

/* JADX INFO: loaded from: classes3.dex */
public interface ILocate extends IManager {
    float calculateLineDistance(BDPoint r100, BDPoint r101);

    BDPoint convertGCJ02(BDPoint r100);

    String getLocateName();

    boolean isAMapDataAvailable(double r100, double r101);

    void startLocation(BDLocationCallback r100, LocationOption r101, Looper r102);

    void stopLocation();

    void stopLocationForBusiness(String r100);

    void updateNavigationHint(String r100, int r101, float r102);
}
