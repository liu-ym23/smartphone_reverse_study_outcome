package com.bytedance.bdlocation.continuous;

import android.content.Context;
import android.os.Looper;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\u0012\u0010 \u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010!\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocationImpl;", "Lcom/bytedance/bdlocation/BaseLocate;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "location", "Lcom/bytedance/bdlocation/continuous/ByteFusionContinuousLocation;", "calculateLineDistance", "", "startLatlng", "Lcom/bytedance/bdlocation/client/BDPoint;", "endLatlng", "convertGCJ02", "wgs84", "getLocateName", "", "isAMapDataAvailable", "", "latitude", "", "longitude", "isLocationRunningForBusiness", "navInstanceId", "startLocation", "", "callback", "Lcom/bytedance/bdlocation/callback/BDLocationCallback;", "option", "Lcom/bytedance/bdlocation/client/LocationOption;", "looper", "Landroid/os/Looper;", "stopLocation", "stopLocationForBusiness", "updateNavigationHint", "navigationCode", "", "projectionBearing", "bdlocation_continuous_release"}, k = 1, mv = {1, 1, 16})
public final class ByteFusionContinuousLocationImpl extends BaseLocate {
    private final ByteFusionContinuousLocation location;

    @Override // com.bytedance.bdlocation.api.ILocate
    public float calculateLineDistance(BDPoint r100, BDPoint r101) {
        return -1.0f;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public BDPoint convertGCJ02(BDPoint r100) {
        return null;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public String getLocateName() {
        return LocationInfoConst.BYTE_FUSION_CONTINUOUS;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public boolean isAMapDataAvailable(double r100, double r101) {
        return false;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public void stopLocation() {
        this.location.stopLocation();
    }

    public ByteFusionContinuousLocationImpl(Context r100) {
        super(r100);
        this.location = new ByteFusionContinuousLocation(new ByteFusionContinuousLocationConfig(r100, null, null, 6, null));
    }

    @Override // com.bytedance.bdlocation.BaseLocate
    public boolean isLocationRunningForBusiness(String r100) {
        return this.location.isLocationRunningForBusiness(r100);
    }

    @Override // com.bytedance.bdlocation.BaseLocate, com.bytedance.bdlocation.api.ILocate
    public void stopLocationForBusiness(String r100) {
        this.location.stopLocationForBusiness(r100);
    }

    @Override // com.bytedance.bdlocation.BaseLocate, com.bytedance.bdlocation.api.ILocate
    public void startLocation(BDLocationCallback r100, LocationOption r101, Looper r102) {
        super.startLocation(r100, r101, r102);
        this.location.startLocation(r100, r101, r102);
    }

    @Override // com.bytedance.bdlocation.BaseLocate, com.bytedance.bdlocation.api.ILocate
    public void updateNavigationHint(String r100, int r101, float r102) {
        this.location.updateNavigationHint(r100, r101, r102);
    }
}
