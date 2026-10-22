package com.bytedance.bdlocation.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.entity.CacheConditionEntity;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.StationarySceneCacheInfo;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.utils.json.JsonUtil;

/* JADX INFO: loaded from: classes3.dex */
public class LocationCache {
    private static final String SHARED_KEY_LOCATE_TIME = "LocateTime";
    private static final String SHARED_KEY_LOCATION_CACHE = "location_cache";
    private static final String SHARED_KEY_LOCATION_DENY_TIME = "LocationDenyTime";
    private static final String SHARED_KEY_LOCATION_SETTINGS = "bd_location_settings";
    private static final String SHARED_KEY_MOCK_WIFI_NAME = "MockWifiName";
    private static final String SHARED_KEY_PRECISE_LATLNG = "PreciseLatLng";
    private static final String SHARED_NAME = "BDLocationCache";
    private static final String TAG = "BDLocationCache";
    private static LocationCache sInstance;
    private Context mContext;
    private volatile LocationCacheInfo mLocationCacheInfo;
    private SharedPreferences mSharedPreferences;
    private StationarySceneCacheInfo mStationarySceneCacheInfo;

    private boolean checkCache() {
        if (this.mSharedPreferences != null) goto L8;
        if (BDLocationConfig.getContext() == null) goto L8;
        Logger.i("checkCache: BDLocationConfig.getContext() is null");
        Context r100 = BDLocationConfig.getContext();
        this.mContext = r100;
        this.mSharedPreferences = r100.getSharedPreferences("BDLocationCache", 0);
    L8:
        if (this.mSharedPreferences == null) goto L11;
        return true;
    L11:
        Logger.i("checkCache: mSharedPreferences is null");
        return false;
    }

    public static LocationCache getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(LocationCache.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new LocationCache();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LocationCache.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void clearLocalLocationCache() {
        removeKey("location_cache");
        this.mLocationCacheInfo = null;
    }

    public LocationCacheInfo fastGetLocationCacheUnsafe() {
        Logger.i("fastGetLocationCacheUnsafe executed.");
        LocationCacheInfo r100 = this.mLocationCacheInfo;
        if (r100 == null) goto L12;
        return r100;
    L12:
        LocationCacheInfo r101 = fromCacheInfoJson(getStringValue("location_cache"));     // Catch: Throwable -> L9
        if (r101 != null) goto L14;
        return new LocationCacheInfo();
    L14:
        return r101;
    L9:
        th = move-exception;
        Logger.e("fastGetLocationCacheUnsafe error: " + th, th);
        return new LocationCacheInfo();
    }

    public LocationCacheInfo getLocationCache() {
        Logger.i("getLocationCache start");
        if (this.mLocationCacheInfo != null) goto L6;
        this.mLocationCacheInfo = fromCacheInfoJson(getStringValue("location_cache"));
        Logger.i("getLocationCache fromCacheInfoJson");
    L6:
        if (this.mLocationCacheInfo != null) goto L9;
        this.mLocationCacheInfo = new LocationCacheInfo();
    L9:
        return this.mLocationCacheInfo;
    }

    public long getLocationDenyTime() {
        return getLongValue(SHARED_KEY_LOCATION_DENY_TIME);
    }

    public String getLocationSettings() {
        return getStringValue(SHARED_KEY_LOCATION_SETTINGS);
    }

    public String getMockWifiName() {
        return getStringValue(SHARED_KEY_MOCK_WIFI_NAME);
    }

    public String getPreciseLatLng() {
        return getStringValue(SHARED_KEY_PRECISE_LATLNG);
    }

    private LocationCache() {
        if (this.mContext != null) goto L5;
        this.mContext = BDLocationConfig.getContext();
    L5:
        Context r100 = this.mContext;
        if (r100 == null) goto L9;
        this.mSharedPreferences = r100.getSharedPreferences("BDLocationCache", 0);
        return;
    }

    public StationarySceneCacheInfo getStationarySceneCacheInfo() {
        return this.mStationarySceneCacheInfo;
    }

    private LocationCacheInfo fromCacheInfoJson(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return null;
    L10:
        return (LocationCacheInfo) JsonUtil.sGson.fromJson(r100, LocationCacheInfo.class);
    L7:
        th = move-exception;
        Logger.e("BDLocation", th);
        return null;
    }

    private void setLocationCache(LocationCacheInfo r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = toCacheInfoJson(r100);
        if (TextUtils.isEmpty(r101) == true) goto L7;
        setStringValue("location_cache", r101);
        setLocateTime(System.currentTimeMillis());
    L7:
        this.mLocationCacheInfo = r100;
    }

    private String toCacheInfoJson(LocationCacheInfo r100) {
        if (r100 != null) goto L9;
    L8:
        return null;
    L9:
        return JsonUtil.sGson.toJson(r100);
    L6:
        th = move-exception;
        Logger.e("BDLocation", th);
        goto L8
    }

    public boolean getBooleanValue(String r100) {
        if (checkCache() == true) goto L6;
        return false;
    L6:
        return this.mSharedPreferences.getBoolean(r100, false);
    }

    public int getIntValue(String r100) {
        if (checkCache() == true) goto L6;
        return 0;
    L6:
        return this.mSharedPreferences.getInt(r100, 0);
    }

    public long getLongValue(String r100) {
        if (checkCache() == true) goto L6;
        return 0;
    L6:
        return this.mSharedPreferences.getLong(r100, 0);
    }

    public String getStringValue(String r100) {
        if (checkCache() == true) goto L6;
        return "";
    L6:
        return this.mSharedPreferences.getString(r100, "");
    }

    public boolean isRecommendLocation(BDLocation r100) {
        if (r100 != null) goto L7;
        Logger.i("isRecommendLocation location is null");
        return false;
    L7:
        if (PermissionManager.isApproximateLocation(BDLocationConfig.getContext()) == false) goto L11;
        Logger.i("isRecommendLocation is approximate location");
        return true;
    L11:
        if (r100.getLocationType() != 3) goto L14;
        Logger.i("isRecommendLocation location type is BASE_STATION");
        return false;
    L14:
        Logger.i("isRecommendLocation location.getAccuracy = " + r100.getAccuracy());
        if (r100.getAccuracy() <= BDLocationConfig.getTailAccuracyThreshold()) goto L19;
        Logger.i("isRecommendLocation accuracy exceeds threshold");
        return false;
    L19:
        if (r100.isRecommendWifiResults() == true) goto L22;
        Logger.i("isRecommendLocation wifi cache time exceeds threshold");
        return false;
    L22:
        return true;
    }

    public void performLocationChangeNotificationIfNeed(BDLocation r100) {
        LocationCacheInfo r101 = this.mLocationCacheInfo;
        if (r101 != null) goto L6;
        r101 = fromCacheInfoJson(getStringValue("location_cache"));
    L6:
        if (r101 == null) goto L10;
        int r102 = LocationUtil.compareLocation(r101.getLatestLocation(), r100);
        Logger.d("BDLocationCache", "location-trace-core executeLocationCache:compareLocation range:" + r102);
        if (r102 == (-1)) goto L12;
        BDLocationConfig.notificationLocationChange(r102, r100);
        return;
    L12:
        return;
    L10:
        Logger.d("BDLocationCache", "location-trace-core executeLocationCache:mLocationCacheInfo==null");
        BDLocationConfig.notificationLocationChange(0, r100);
    }

    public void removeKey(String r100) {
        if (checkCache() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r101 = this.mSharedPreferences.edit();
        r101.remove(r100);
        r101.commit();
    }

    public void setLocateTime(long r100) {
        setLongValue(SHARED_KEY_LOCATE_TIME, r100);
    }

    public void setLocationDenyTime(long r100) {
        setLongValue(SHARED_KEY_LOCATION_DENY_TIME, r100);
    }

    public void setMockLocation(BDLocation r100) {
        if (this.mLocationCacheInfo != null) goto L6;
        this.mLocationCacheInfo = getLocationCache();
    L6:
        if (this.mLocationCacheInfo != null) goto L8;
        this.mLocationCacheInfo = new LocationCacheInfo();
    L8:
        this.mLocationCacheInfo.setMockLocation(r100);
        setLocationCache(this.mLocationCacheInfo);
    }

    public void setMockWifiName(String r100) {
        setStringValue(SHARED_KEY_MOCK_WIFI_NAME, r100);
    }

    public void setPreciseLatLng(String r100) {
        setStringValue(SHARED_KEY_PRECISE_LATLNG, r100);
    }

    public void setStationarySceneCacheInfo(StationarySceneCacheInfo r100) {
        this.mStationarySceneCacheInfo = r100;
    }

    public void setBooleanValue(String r100, boolean r101) {
        if (checkCache() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r102 = this.mSharedPreferences.edit();
        r102.putBoolean(r100, r101);
        r102.apply();
    }

    public void setIntValue(String r100, int r101) {
        if (checkCache() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r102 = this.mSharedPreferences.edit();
        r102.putInt(r100, r101);
        r102.apply();
    }

    public void setLocationSettings(Context r100, String r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mSharedPreferences != null) goto L7;
        this.mSharedPreferences = r100.getSharedPreferences("BDLocationCache", 0);
    L7:
        setStringValue(SHARED_KEY_LOCATION_SETTINGS, r101);
    }

    public void setLongValue(String r100, long r101) {
        if (checkCache() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r102 = this.mSharedPreferences.edit();
        r102.putLong(r100, r101);
        r102.apply();
    }

    public void setStringValue(String r100, String r101) {
        if (checkCache() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r102 = this.mSharedPreferences.edit();
        r102.putString(r100, r101);
        r102.apply();
    }

    public void executeLocationCache(BDLocation r100, boolean r101, boolean r102) {
        executeLocationCache(r100, null, r101, r102);
    }

    public void executeWithoutLocationCache(long r100, CacheConditionEntity r101, boolean r102) {
        if (BDLocationConfig.isUseCacheCondition() == true) goto L5;
        return;
    L5:
        LocationCacheInfo r103 = this.mLocationCacheInfo;
        if (r103 != null) goto L8;
        r103 = getLocationCache();
    L8:
        r103.setLatestLocationCacheCondition(r101.getConditionCode());
        r103.setLatestLocationCacheTime(r100);
        if (r102 == false) goto L11;
        r103.setNextGpsScanInterval(BDLocationConfig.getGpsScanInterval());
        Logger.i("executeWithoutLocationCache: nextGpsScanInterval = " + BDLocationConfig.getGpsScanInterval());
    L11:
        Logger.d("BDLocationCache", "executeWithoutLocationCache");
        setLocationCache(r103);
    }

    public void executeLocationCache(BDLocation r100, CacheConditionEntity r101, boolean r102, boolean r103) {
        if (this.mLocationCacheInfo != null) goto L5;
        this.mLocationCacheInfo = getLocationCache();
    L5:
        if (r103 == false) goto L8;
        performLocationChangeNotificationIfNeed(r100);
    L8:
        if (this.mLocationCacheInfo != null) goto L10;
        this.mLocationCacheInfo = new LocationCacheInfo();
    L10:
        this.mLocationCacheInfo.setLatestLocation(r100);
        if (BDLocationConfig.isUseCacheCondition() == false) goto L14;
        if (r101 == null) goto L14;
        this.mLocationCacheInfo.setLatestLocationCacheCondition(r101.getConditionCode());
        this.mLocationCacheInfo.setLatestLocationCacheTime(r100.getLocationMs());
    L14:
        if (r102 == false) goto L17;
        this.mLocationCacheInfo.setNextGpsScanInterval(BDLocationConfig.getGpsScanInterval());
        Logger.i("executeLocationCache: nextGpsScanInterval = " + BDLocationConfig.getGpsScanInterval());
    L17:
        if (BDLocationConfig.enableTailLocateOptimize() == false) goto L19;
        this.mLocationCacheInfo.setRecommendLocation(isRecommendLocation(r100));
    L19:
        Logger.d("ConnectManager:setLatestLocation is executed and location ");
        setLocationCache(this.mLocationCacheInfo);
    }
}
