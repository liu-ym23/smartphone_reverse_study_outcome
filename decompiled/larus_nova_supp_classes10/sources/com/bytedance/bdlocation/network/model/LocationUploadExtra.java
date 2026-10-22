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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
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
        BDLocationExtraDataServer r0 = this.mLocationExtraDataServer;
        if (r0 != null) goto L5;
        return null;
    L5:
        GpsInfoManager r1 = r0.getGpsInfoManager();
        if (r1 != null) goto L8;
        return null;
    L8:
        BDScanLocationInfo r2 = r1.getScanLocationInfo();
        if (r2 != null) goto L12;
        return null;
    L12:
        if (r2.getAMapLocation() != null) goto L15;
        return null;
    L15:
        return LocationUtil.bdLocationToLocationInfo(r2.getAMapLocation(), BDLocationConfig.isUploadGPS());
    }

    public String getContinuousGpsConfigCategory() {
        BDLocationExtraDataServer r0 = this.mLocationExtraDataServer;
        if (r0 != null) goto L5;
        return "";
    L5:
        GpsInfoManager r1 = r0.getGpsInfoManager();
        if (r1 != null) goto L9;
        return "";
    L9:
        return r1.getContinuousGpsConfigCategory();
    }

    public List<BDGnssInfo> getGnssInfoList() {
        BDScanLocationInfo r0 = waitGpsFinishForSteal(0);
        if (r0 != null) goto L7;
        return new ArrayList();
    L7:
        return r0.getGnssInfoList();
    }

    public List<BDGpsInfo> getGpsInfoList() {
        BDScanLocationInfo r0 = waitGpsFinishForSteal(0);
        if (r0 != null) goto L7;
        return new ArrayList();
    L7:
        return r0.getGpsInfo();
    }

    public LocationInfo getSysLocation() {
        BDLocationExtraDataServer r0 = this.mLocationExtraDataServer;
        if (r0 != null) goto L5;
        return null;
    L5:
        GpsInfoManager r1 = r0.getGpsInfoManager();
        if (r1 != null) goto L8;
        return null;
    L8:
        BDScanLocationInfo r2 = r1.getScanLocationInfo();
        if (r2 != null) goto L12;
        return null;
    L12:
        if (r2.getSysLocation() != null) goto L15;
        return null;
    L15:
        return LocationUtil.bdLocationToLocationInfo(r2.getSysLocation(), BDLocationConfig.isUploadGPS());
    }

    public boolean isContinuousGpsInfo() {
        BDScanLocationInfo r0 = waitGpsFinishForSteal(0);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isContinuousGps();
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

    private BDScanLocationInfo waitGpsFinishForSteal(long r8) {
        BDLocationExtraDataServer r0 = this.mLocationExtraDataServer;
        if (r0 != null) goto L6;
        Logger.i("location-trace-core wait gps info, mLocationExtraDataServer == null, return null.");
        return null;
    L6:
        GpsInfoManager r1 = r0.getGpsInfoManager();
        if (r1 != null) goto L10;
        Logger.i("location-trace-core wait gps info, gpsInfoManager == null, return null.");
        return null;
    L10:
        BDScanLocationInfo r2 = r1.getScanLocationInfo();
        if (r2 != null) goto L15;
        Logger.i("location-trace-core wait gps info, scanLocationInfo == null.");
        return null;
    L15:
        if (r8 > 0) goto L17;
    L36:
        Logger.i("location-trace-core wait gps info, before get gps info, gps collect finished: " + r1.isCollectGpsFinishedForSteal());
        return r2;
    L17:
        if (r1.isCollectGpsFinishedForSteal() == true) goto L36;
        long r3 = SystemClock.elapsedRealtime();
        monitor-enter(r1);
    L40:
    L33:
        th = move-exception;
        throw th;
    L21:
        if (r1.isCollectGpsFinishedForSteal() == true) goto L30;
        long r5 = SystemClock.elapsedRealtime() - r3;
        if (r5 >= r8) goto L30;
        r1.wait(r8 - r5);     // Catch: InterruptedException -> L28 Throwable -> L33
    L28:
        e = move-exception;
        Logger.e("wait gps result error: " + e.getMessage(), e);     // Catch: Throwable -> L33
    L30:
        Logger.i("location-trace-core wait gps info, wait finished, isCollectedFinished: " + r1.isCollectGpsFinishedForSteal());     // Catch: Throwable -> L33
        monitor-exit(r1);     // Catch: Throwable -> L33
        goto L36
    }

    public BDGnssInfo findNearbyGnssInfo(BDGpsInfo r3) {
        BDScanLocationInfo r0 = waitGpsFinishForSteal(0);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.findNearbyGnssInfo(r3);
    }

    public BDGpsInfo getGpsInfo(BDScanLocationInfo.TakeStrategy r3) {
        return waitGpsInfo(0, r3);
    }

    public void setBleList(List<BDBleInfo> r1) {
        this.mBleInfoList = r1;
    }

    public void setBpeaCert(Object r1) {
        this.mBpeaCert = r1;
    }

    public void setConnectedWifiInfo(WifiInfo r1) {
        this.mConnectedWifiInfo = r1;
    }

    public void setCurrentStationDuration(long r1) {
        this.mCurrentStationDuration = r1;
    }

    public void setExtra(String r1) {
        this.mExtra = r1;
    }

    public void setGpsAndBleMark(String r1) {
        this.mGpsAndBleMark = r1;
    }

    public void setLatestAdminVersion(boolean r1) {
        this.mLatestAdminVersion = r1;
    }

    public void setLightSubmitDuration(long r1) {
        this.mLightSubmitDuration = r1;
    }

    public void setLocateId(String r1) {
        this.mLocateId = r1;
    }

    public void setLocationEventClockMs(long r1) {
        this.mLocationEventClockMs = r1;
    }

    public void setLocationExtraDataServer(BDLocationExtraDataServer r1) {
        this.mLocationExtraDataServer = r1;
    }

    public void setLocationTraceLogger(LocationTraceLogger r1) {
        this.mLocationTraceLogger = r1;
    }

    public void setLogIdCache(LogIdCacheEntity r1) {
        this.logIdCacheEntity = r1;
    }

    public void setOnceLocation(boolean r1) {
        this.mOnceLocation = r1;
    }

    public void setRecommendWifiResults(boolean r1) {
        this.mIsRecommendWifiResults = r1;
    }

    public void setSensorWindowStartMs(long r1) {
        this.mSensorWindowStartMs = r1;
    }

    public void setStartLocationTime(long r1) {
        this.mStartLocationTime = r1;
    }

    public void setStartLocationTimestampInMillis(long r1) {
        this.mStartLocationTimestampInMillis = r1;
    }

    public void setStationarySceneCacheInfo(StationarySceneCacheInfo r1) {
        this.mStationarySceneCacheInfo = r1;
    }

    public void setTriggerType(int r1) {
        this.triggerType = r1;
    }

    public void setUploadInterval(long r1) {
        this.uploadInterval = r1;
    }

    public void setUploadSource(String r1) {
        this.uploadSource = r1;
    }

    public void setWifiCache(boolean r1) {
        this.mWifiCache = r1;
    }

    public void setWifiDate(JsonArray r1) {
        this.mWifiInfoJson = r1;
    }

    public BDGpsInfo waitGpsInfo(long r1, BDScanLocationInfo.TakeStrategy r3) {
        BDScanLocationInfo r2 = waitGpsFinishForSteal(r1);
        if (r2 != null) goto L6;
        return null;
    L6:
        BDGpsInfo r4 = r2.takeGpsInfo(r3);
        BDGnssInfo r5 = r2.findNearbyGnssInfo(r4);
        if (r4 == null) goto L11;
        if (r5 == null) goto L11;
        return new BDGpsInfo(r4, r5);
    L11:
        return r4;
    }
}
