package com.bytedance.bdlocation.network.model;

import android.os.SystemClock;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.entity.LogIdCacheEntity;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.scan.bluetooth.BDBleInfo;
import com.bytedance.bdlocation.scan.gps.BDGnssInfo;
import com.bytedance.bdlocation.scan.gps.BDGpsInfo;
import com.bytedance.bdlocation.scan.gps.BDScanLocationInfo;
import com.bytedance.bdlocation.scan.gps.GpsInfoManager;
import com.bytedance.bdlocation.service.BDLocationExtraDataServer;
import com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class LocationUploadExtra {
    public volatile LocationOption locationOption;
    private LogIdCacheEntity logIdCacheEntity;
    private List<BDBleInfo> mBleInfoList;
    private Object mBpeaCert;
    private WifiInfo mConnectedWifiInfo;
    private long mCurrentStationDuration;
    private String mExtra;
    private String mGpsAndBleMark;
    private boolean mIsRecommendWifiResults;
    private boolean mLatestAdminVersion;
    private long mLightSubmitDuration;
    private String mLocateId;
    private long mLocationEventClockMs;
    private BDLocationExtraDataServer mLocationExtraDataServer;
    private LocationTraceLogger mLocationTraceLogger;
    private boolean mOnceLocation;
    private BDScanLocationInfo mScanLocationInfo;
    private long mSensorWindowStartMs;
    private long mStartLocationTime;
    private long mStartLocationTimestampInMillis;
    private StationarySceneCacheInfo mStationarySceneCacheInfo;
    private boolean mWifiCache;
    private JsonArray mWifiInfoJson;
    private int triggerType;
    private long uploadInterval;
    private String uploadSource;

    public LocationInfo getAMapLocation() {
        BDLocationExtraDataServer r100 = this.mLocationExtraDataServer;
        if (r100 != null) goto L5;
        return null;
    L5:
        GpsInfoManager r101 = r100.getGpsInfoManager();
        if (r101 != null) goto L8;
        return null;
    L8:
        BDScanLocationInfo r102 = r101.getScanLocationInfo();
        if (r102 != null) goto L12;
        return null;
    L12:
        if (r102.getAMapLocation() != null) goto L15;
        return null;
    L15:
        return LocationUtil.bdLocationToLocationInfo(r102.getAMapLocation(), BDLocationConfig.isUploadGPS());
    }

    public String getContinuousGpsConfigCategory() {
        BDLocationExtraDataServer r100 = this.mLocationExtraDataServer;
        if (r100 != null) goto L5;
        return "";
    L5:
        GpsInfoManager r101 = r100.getGpsInfoManager();
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101.getContinuousGpsConfigCategory();
    }

    public List<BDGnssInfo> getGnssInfoList() {
        BDScanLocationInfo r100 = waitGpsFinishForSteal(0);
        if (r100 != null) goto L7;
        return new ArrayList();
    L7:
        return r100.getGnssInfoList();
    }

    public List<BDGpsInfo> getGpsInfoList() {
        BDScanLocationInfo r100 = waitGpsFinishForSteal(0);
        if (r100 != null) goto L7;
        return new ArrayList();
    L7:
        return r100.getGpsInfo();
    }

    public LocationInfo getSysLocation() {
        BDLocationExtraDataServer r100 = this.mLocationExtraDataServer;
        if (r100 != null) goto L5;
        return null;
    L5:
        GpsInfoManager r101 = r100.getGpsInfoManager();
        if (r101 != null) goto L8;
        return null;
    L8:
        BDScanLocationInfo r102 = r101.getScanLocationInfo();
        if (r102 != null) goto L12;
        return null;
    L12:
        if (r102.getSysLocation() != null) goto L15;
        return null;
    L15:
        return LocationUtil.bdLocationToLocationInfo(r102.getSysLocation(), BDLocationConfig.isUploadGPS());
    }

    public boolean isContinuousGpsInfo() {
        BDScanLocationInfo r100 = waitGpsFinishForSteal(0);
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isContinuousGps();
    }

    public LocationUploadExtra() {
        this.mGpsAndBleMark = "";
        this.mOnceLocation = true;
        this.mIsRecommendWifiResults = true;
    }

    public List<BDBleInfo> getBleList() {
        return this.mBleInfoList;
    }

    public Object getBpeaCert() {
        return this.mBpeaCert;
    }

    public WifiInfo getConnectedWifiInfo() {
        return this.mConnectedWifiInfo;
    }

    public long getCurrentStationDuration() {
        return this.mCurrentStationDuration;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public String getGpsAndBleMark() {
        return this.mGpsAndBleMark;
    }

    public long getLightSubmitDuration() {
        return this.mLightSubmitDuration;
    }

    public String getLocateId() {
        return this.mLocateId;
    }

    public long getLocationEventClockMs() {
        return this.mLocationEventClockMs;
    }

    public BDLocationExtraDataServer getLocationExtraDataServer() {
        return this.mLocationExtraDataServer;
    }

    public LocationTraceLogger getLocationTraceLogger() {
        return this.mLocationTraceLogger;
    }

    public LogIdCacheEntity getLogIdCache() {
        return this.logIdCacheEntity;
    }

    public long getSensorWindowStartMs() {
        return this.mSensorWindowStartMs;
    }

    public long getStartLocationTime() {
        return this.mStartLocationTime;
    }

    public long getStartLocationTimestampInMillis() {
        return this.mStartLocationTimestampInMillis;
    }

    public StationarySceneCacheInfo getStationarySceneCacheInfo() {
        return this.mStationarySceneCacheInfo;
    }

    public int getTriggerType() {
        return this.triggerType;
    }

    public long getUploadInterval() {
        return this.uploadInterval;
    }

    public String getUploadSource() {
        return this.uploadSource;
    }

    public JsonArray getWifiData() {
        return this.mWifiInfoJson;
    }

    public boolean isLatestAdminVersion() {
        return this.mLatestAdminVersion;
    }

    public boolean isOnceLocation() {
        return this.mOnceLocation;
    }

    public boolean isRecommendWifiResults() {
        return this.mIsRecommendWifiResults;
    }

    public boolean isWifiCache() {
        return this.mWifiCache;
    }

    private BDScanLocationInfo waitGpsFinishForSteal(long r100) {
        BDLocationExtraDataServer r101 = this.mLocationExtraDataServer;
        if (r101 != null) goto L6;
        Logger.i("location-trace-core wait gps info, mLocationExtraDataServer == null, return null.");
        return null;
    L6:
        GpsInfoManager r102 = r101.getGpsInfoManager();
        if (r102 != null) goto L10;
        Logger.i("location-trace-core wait gps info, gpsInfoManager == null, return null.");
        return null;
    L10:
        BDScanLocationInfo r103 = r102.getScanLocationInfo();
        if (r103 != null) goto L15;
        Logger.i("location-trace-core wait gps info, scanLocationInfo == null.");
        return null;
    L15:
        if (r100 > 0) goto L17;
    L36:
        Logger.i("location-trace-core wait gps info, before get gps info, gps collect finished: " + r102.isCollectGpsFinishedForSteal());
        return r103;
    L17:
        if (r102.isCollectGpsFinishedForSteal() == true) goto L36;
        long r104 = SystemClock.elapsedRealtime();
        monitor-enter(r102);
    L40:
    L33:
        th = move-exception;
        throw th;
    L21:
        if (r102.isCollectGpsFinishedForSteal() == true) goto L30;
        long r105 = SystemClock.elapsedRealtime() - r104;
        if (r105 >= r100) goto L30;
        r102.wait(r100 - r105);     // Catch: InterruptedException -> L28 Throwable -> L33
    L28:
        e = move-exception;
        Logger.e("wait gps result error: " + e.getMessage(), e);     // Catch: Throwable -> L33
    L30:
        Logger.i("location-trace-core wait gps info, wait finished, isCollectedFinished: " + r102.isCollectGpsFinishedForSteal());     // Catch: Throwable -> L33
        monitor-exit(r102);     // Catch: Throwable -> L33
        goto L36
    }

    public BDGnssInfo findNearbyGnssInfo(BDGpsInfo r100) {
        BDScanLocationInfo r101 = waitGpsFinishForSteal(0);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.findNearbyGnssInfo(r100);
    }

    public BDGpsInfo getGpsInfo(BDScanLocationInfo.TakeStrategy r100) {
        return waitGpsInfo(0, r100);
    }

    public void setBleList(List<BDBleInfo> r100) {
        this.mBleInfoList = r100;
    }

    public void setBpeaCert(Object r100) {
        this.mBpeaCert = r100;
    }

    public void setConnectedWifiInfo(WifiInfo r100) {
        this.mConnectedWifiInfo = r100;
    }

    public void setCurrentStationDuration(long r100) {
        this.mCurrentStationDuration = r100;
    }

    public void setExtra(String r100) {
        this.mExtra = r100;
    }

    public void setGpsAndBleMark(String r100) {
        this.mGpsAndBleMark = r100;
    }

    public void setLatestAdminVersion(boolean r100) {
        this.mLatestAdminVersion = r100;
    }

    public void setLightSubmitDuration(long r100) {
        this.mLightSubmitDuration = r100;
    }

    public void setLocateId(String r100) {
        this.mLocateId = r100;
    }

    public void setLocationEventClockMs(long r100) {
        this.mLocationEventClockMs = r100;
    }

    public void setLocationExtraDataServer(BDLocationExtraDataServer r100) {
        this.mLocationExtraDataServer = r100;
    }

    public void setLocationTraceLogger(LocationTraceLogger r100) {
        this.mLocationTraceLogger = r100;
    }

    public void setLogIdCache(LogIdCacheEntity r100) {
        this.logIdCacheEntity = r100;
    }

    public void setOnceLocation(boolean r100) {
        this.mOnceLocation = r100;
    }

    public void setRecommendWifiResults(boolean r100) {
        this.mIsRecommendWifiResults = r100;
    }

    public void setSensorWindowStartMs(long r100) {
        this.mSensorWindowStartMs = r100;
    }

    public void setStartLocationTime(long r100) {
        this.mStartLocationTime = r100;
    }

    public void setStartLocationTimestampInMillis(long r100) {
        this.mStartLocationTimestampInMillis = r100;
    }

    public void setStationarySceneCacheInfo(StationarySceneCacheInfo r100) {
        this.mStationarySceneCacheInfo = r100;
    }

    public void setTriggerType(int r100) {
        this.triggerType = r100;
    }

    public void setUploadInterval(long r100) {
        this.uploadInterval = r100;
    }

    public void setUploadSource(String r100) {
        this.uploadSource = r100;
    }

    public void setWifiCache(boolean r100) {
        this.mWifiCache = r100;
    }

    public void setWifiDate(JsonArray r100) {
        this.mWifiInfoJson = r100;
    }

    public BDGpsInfo waitGpsInfo(long r100, BDScanLocationInfo.TakeStrategy r101) {
        BDScanLocationInfo r102 = waitGpsFinishForSteal(r100);
        if (r102 != null) goto L6;
        return null;
    L6:
        BDGpsInfo r103 = r102.takeGpsInfo(r101);
        BDGnssInfo r104 = r102.findNearbyGnssInfo(r103);
        if (r103 == null) goto L11;
        if (r104 == null) goto L11;
        return new BDGpsInfo(r103, r104);
    L11:
        return r103;
    }
}
