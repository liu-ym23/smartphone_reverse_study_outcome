package com.bytedance.bdlocation;

import android.content.Context;
import android.os.Looper;
import com.bytedance.bdlocation.api.ILocate;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.callback.LocateCallback;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseLocate implements ILocate, LocateCallback {
    protected Context mContext;
    protected LocateCallback mLocateCallback;
    private volatile LocationOption mLocationOption;

    public boolean isLocationRunningForBusiness(String r100) {
        return false;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public void stopLocationForBusiness(String r100) {
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public void updateNavigationHint(String r100, int r101, float r102) {
    }

    public LocationOption getLocationOption() {
        return this.mLocationOption;
    }

    public BaseLocate(Context r100) {
        this.mContext = r100;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateStart(String r100) {
        LocateCallback r101 = this.mLocateCallback;
        if (r101 == null) goto L6;
        r101.onLocateStart(r100);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateStop(String r100) {
        LocateCallback r101 = this.mLocateCallback;
        if (r101 == null) goto L6;
        r101.onLocateStop(r100);
        return;
    }

    public void setLocateCallback(LocateCallback r100) {
        this.mLocateCallback = r100;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateChange(String r100, BDLocation r101) {
        LocateCallback r102 = this.mLocateCallback;
        if (r102 == null) goto L6;
        r102.onLocateChange(r100, r101);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateError(String r100, BDLocationException r101) {
        LocateCallback r102 = this.mLocateCallback;
        if (r102 == null) goto L6;
        r102.onLocateError(r100, r101);
        return;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public void startLocation(BDLocationCallback r100, LocationOption r101, Looper r102) {
        this.mLocationOption = r101;
    }
}
