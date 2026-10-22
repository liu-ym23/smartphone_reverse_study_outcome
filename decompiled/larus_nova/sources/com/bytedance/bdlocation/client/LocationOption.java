package com.bytedance.bdlocation.client;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.entity.LastLocationEntity;
import com.bytedance.bdlocation.entity.LocationExtraBean;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationExtraDataTraceLogger;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.network.model.StationarySceneCacheInfo;
import com.bytedance.bdlocation.scan.gps.BDGnssInfo;
import com.bytedance.bdlocation.scan.gps.BDGpsInfo;
import com.bytedance.bdlocation.scan.gps.BDScanLocationInfo;
import com.bytedance.bdlocation.scan.gps.GpsInfoManager;
import com.bytedance.bdlocation.service.BDLocationExtraDataServer;

/* JADX INFO: loaded from: classes10.dex */
public class LocationOption {
    public boolean alreadyCallback;
    private long backupIntervalMs;
    private boolean downGradeLocation;
    public boolean enableAMapBackgroundContiLocation;
    private int geocodeMode;
    private long interval;
    public volatile boolean isCallbackThroughLocateTrace;
    private long lastSensorBatchEndTimestampMs;
    private boolean locationChanged;
    private LocationExtraBean locationExtraBean;
    private long locationTimeOutMs;
    private boolean mAMapGpsFirst;
    private long mAMapGpsFirstTimeoutMillis;
    private Boolean mAcceptLightLocationResult;
    private int mAccuracyLevel;
    private String mBpeaAction;
    private Object mBpeaCert;
    private String mBusinessId;
    private boolean mCert;
    private boolean mChineseRegion;
    private boolean mEnableUploadNetSignal;
    private volatile String mExtra;
    private int mFusionLocationUserMotionMode;
    private int mFusionLocationWorkMode;
    private long mGpsTimeoutMs;
    private boolean mHitStationaryScene;
    private long mHostSwitchThreadDuration;
    private boolean mIsBackground;
    private boolean mIsIndoor;
    private LBSLightLocationTraceLogger mLBSLightLocationTraceLogger;
    private volatile LastLocationEntity mLastLocationEntity;
    private boolean mLatestAdminVersion;
    private volatile BDLocation mLightLocation;
    private volatile long mLightLocationWifiGap;
    private String mLocateId;
    private int mLocateType;
    private BDLocationExtraDataServer mLocationExtraDataServer;
    private LocationExtraDataTraceLogger mLocationExtraDataTraceLogger;
    private LocationTraceLogger mLocationTraceLogger;
    private float mMinUpdateDistance;
    private StationarySceneCacheInfo mStationarySceneCacheInfo;
    private boolean mSynchronizeUpload;
    private String mTraceContext;
    private int mTriggerType;
    private long mUploadInterval;
    private long maxCacheTime;
    private int mode;
    private boolean onceLocation;
    private volatile boolean sIsUpload;
    private boolean scanBle;
    public long startLocationElapsedRealtimeMillis;
    private long startLocationTime;
    public long startLocationTimestampInMillis;
    private String uploadSource;

    public BDGpsInfo getGpsInfo() {
        BDLocationExtraDataServer r100 = this.mLocationExtraDataServer;
        if (r100 != null) goto L5;
        return null;
    L5:
        GpsInfoManager r101 = r100.getGpsInfoManager();
        if (r101 != null) goto L8;
        return null;
    L8:
        BDScanLocationInfo r102 = r101.getScanLocationInfo();
        if (r102 != null) goto L11;
        return null;
    L11:
        BDGpsInfo r103 = r102.takeGpsInfo(BDScanLocationInfo.TakeStrategy.lastResult);
        BDGnssInfo r104 = r102.findNearbyGnssInfo(r103);
        if (r103 == null) goto L16;
        if (r104 == null) goto L16;
        return new BDGpsInfo(r103, r104);
    L16:
        return r103;
    }

    public BDLocation getGpsLocation() {
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
        return r102.takeGpsLocation(BDScanLocationInfo.TakeStrategy.lastResult);
    }

    public BDLocation getSysLocation() {
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
        return r102.getSysLocation();
    }

    public int hashCode() {
        long r100 = this.locationTimeOutMs;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.interval;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.mHostSwitchThreadDuration;
        int r105 = (((((((((((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.mode) * 31) + this.mTriggerType) * 31) + this.mAccuracyLevel) * 31) + this.mLocateType) * 31) + this.geocodeMode) * 31;
        long r106 = this.maxCacheTime;
        int r107 = (((((((((((((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + (this.mIsIndoor ? 1 : 0)) * 31) + (this.sIsUpload ? 1 : 0)) * 31) + (this.mCert ? 1 : 0)) * 31) + (this.onceLocation ? 1 : 0)) * 31) + (this.downGradeLocation ? 1 : 0)) * 31) + (this.mLatestAdminVersion ? 1 : 0)) * 31;
        String r108 = this.uploadSource;
        int r109 = 0;
        if (r108 == null) goto L5;
        int r110 = r108.hashCode();
    L6:
        int r111 = (r107 + r110) * 31;
        Object r112 = this.mBpeaCert;
        if (r112 == null) goto L9;
        int r113 = r112.hashCode();
    L10:
        int r114 = (r111 + r113) * 31;
        String r115 = this.mBpeaAction;
        if (r115 == null) goto L13;
        int r116 = r115.hashCode();
    L14:
        int r117 = (r114 + r116) * 31;
        if (this.mExtra == null) goto L17;
        int r118 = this.mExtra.hashCode();
    L18:
        long r119 = this.startLocationTime;
        int r120 = (((r117 + r118) * 31) + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        long r121 = this.startLocationElapsedRealtimeMillis;
        int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        long r123 = this.startLocationTimestampInMillis;
        int r124 = (r122 + ((int) (r123 ^ (r123 >>> 32)))) * 31;
        int r125 = 1231;
        if (this.isCallbackThroughLocateTrace == false) goto L21;
        int r126 = 1231;
    L22:
        int r127 = (r124 + r126) * 31;
        if (this.alreadyCallback == false) goto L25;
        int r128 = 1231;
    L26:
        int r129 = (r127 + r128) * 31;
        if (this.mHitStationaryScene == false) goto L29;
        int r130 = 1231;
    L30:
        int r131 = (r129 + r130) * 31;
        StationarySceneCacheInfo r132 = this.mStationarySceneCacheInfo;
        if (r132 == null) goto L33;
        int r133 = r132.hashCode();
    L34:
        int r134 = (r131 + r133) * 31;
        if (this.enableAMapBackgroundContiLocation == false) goto L37;
        int r135 = 1231;
    L38:
        int r136 = (r134 + r135) * 31;
        if (this.mSynchronizeUpload == false) goto L41;
        int r137 = 1231;
    L42:
        int r138 = (((((r136 + r137) * 31) + this.mFusionLocationWorkMode) * 31) + this.mFusionLocationUserMotionMode) * 31;
        if (this.mAMapGpsFirst == false) goto L45;
        int r139 = 1231;
    L46:
        long r140 = this.mAMapGpsFirstTimeoutMillis;
        int r141 = (((((r138 + r139) * 31) + ((int) (r140 ^ (r140 >>> 32)))) * 31) + Float.floatToIntBits(this.mMinUpdateDistance)) * 31;
        long r142 = this.mGpsTimeoutMs;
        int r143 = (r141 + ((int) (r142 ^ (r142 >>> 32)))) * 31;
        long r144 = this.backupIntervalMs;
        int r145 = (r143 + ((int) (r144 ^ (r144 >>> 32)))) * 31;
        if (this.mEnableUploadNetSignal == true) goto L50;
        r125 = 1237;
    L50:
        int r146 = (r145 + r125) * 31;
        Boolean r147 = this.mAcceptLightLocationResult;
        if (r147 == null) goto L53;
        int r148 = r147.hashCode();
    L54:
        int r149 = (r146 + r148) * 31;
        String r150 = this.mTraceContext;
        if (r150 == null) goto L58;
        r109 = r150.hashCode();
    L58:
        return r149 + r109;
    L53:
        r148 = 0;
        goto L54
    L45:
        r139 = 1237;
        goto L46
    L41:
        r137 = 1237;
        goto L42
    L37:
        r135 = 1237;
        goto L38
    L33:
        r133 = 0;
        goto L34
    L29:
        r130 = 1237;
        goto L30
    L25:
        r128 = 1237;
        goto L26
    L21:
        r126 = 1237;
        goto L22
    L17:
        r118 = 0;
        goto L18
    L13:
        r116 = 0;
        goto L14
    L9:
        r113 = 0;
        goto L10
    L5:
        r110 = 0;
        goto L6
    }

    public String toString() {
        return "LocationOption{sIsUpload=" + this.sIsUpload + ", locationTimeOutMs=" + this.locationTimeOutMs + ", interval=" + this.interval + ", hostSwitchThreadDuration: " + this.mHostSwitchThreadDuration + ", amapGpsFirst: " + this.mAMapGpsFirst + ", amapGpsFirstTimeoutMillis: " + this.mAMapGpsFirstTimeoutMillis + ", mode=" + this.mode + ", triggerType=" + this.mTriggerType + ", triggerType=" + this.mLocateType + ", maxCacheTime=" + this.maxCacheTime + ", getGeocodeMode=" + this.geocodeMode + ", mIsIndoor=" + this.mIsIndoor + ", mCert=" + this.mCert + ", onceLocation=" + this.onceLocation + ", downGradeLocation=" + this.downGradeLocation + ", mLatestAdminVersion=" + this.mLatestAdminVersion + ", mBpeaAction=" + this.mBpeaAction + ", mExtra=" + this.mExtra + ", startLocationTime=" + this.startLocationTime + ", startLocationTimestampInMillis=" + this.startLocationElapsedRealtimeMillis + ", startLocationTimestampInMillis=" + this.startLocationTimestampInMillis + ", isCallbackThroughLocateTrace=" + this.isCallbackThroughLocateTrace + ", alreadyCallback=" + this.alreadyCallback + ", mHitStationaryScene=" + this.mHitStationaryScene + ", mStationarySceneCacheInfo=" + this.mStationarySceneCacheInfo + ", uploadSource=" + this.uploadSource + ", sync=" + this.mSynchronizeUpload + ", fusionLocationWorkMode=" + this.mFusionLocationWorkMode + ", fusionLocationUserMotionMode=" + this.mFusionLocationUserMotionMode + ", enableAMapBackgroundLocation=" + this.enableAMapBackgroundContiLocation + '}';
    }

    public LocationOption() {
        this.enableAMapBackgroundContiLocation = false;
        this.alreadyCallback = false;
        this.isCallbackThroughLocateTrace = false;
        this.mAccuracyLevel = 4;
        this.uploadSource = "";
        this.mBpeaAction = "";
        this.mLocateType = -1;
        this.sIsUpload = true;
        this.mTriggerType = 1;
        this.locationTimeOutMs = 30000;
        this.mCert = false;
        this.locationChanged = false;
        this.onceLocation = true;
        this.downGradeLocation = false;
        this.mHostSwitchThreadDuration = -1;
        this.mode = 2;
        this.maxCacheTime = 600000;
        this.geocodeMode = 1;
        this.mLatestAdminVersion = false;
        this.scanBle = true;
        this.mChineseRegion = true;
        this.mLocateId = "-1";
        this.mLightLocationWifiGap = -1;
        this.mSynchronizeUpload = true;
        this.mFusionLocationWorkMode = 1;
        this.mFusionLocationUserMotionMode = 2;
        this.mEnableUploadNetSignal = true;
        this.lastSensorBatchEndTimestampMs = 0;
    }

    public long timeToStartLocationInMillis() {
        return SystemClock.elapsedRealtime() - this.startLocationElapsedRealtimeMillis;
    }

    public boolean enableUploadNetSignal() {
        return this.mEnableUploadNetSignal;
    }

    public long getAMapGpsFirstTimeoutMillis() {
        return this.mAMapGpsFirstTimeoutMillis;
    }

    public Boolean getAcceptLightLocationResult() {
        return this.mAcceptLightLocationResult;
    }

    public int getAccuracyLevel() {
        return this.mAccuracyLevel;
    }

    public long getBackupIntervalMs() {
        return this.backupIntervalMs;
    }

    public String getBpeaAction() {
        return this.mBpeaAction;
    }

    public Object getBpeaCert() {
        return this.mBpeaCert;
    }

    public String getBusinessId() {
        return this.mBusinessId;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public int getFusionLocationUserMotionMode() {
        return this.mFusionLocationUserMotionMode;
    }

    public int getFusionLocationWorkMode() {
        return this.mFusionLocationWorkMode;
    }

    public int getGeocodeMode() {
        return this.geocodeMode;
    }

    public long getGpsTimeoutMs() {
        return this.mGpsTimeoutMs;
    }

    public long getHostSwitchThreadDuration() {
        return this.mHostSwitchThreadDuration;
    }

    public long getInterval() {
        return this.interval;
    }

    public LBSLightLocationTraceLogger getLBSLightLocationTraceLogger() {
        return this.mLBSLightLocationTraceLogger;
    }

    public LastLocationEntity getLastLocationEntity() {
        return this.mLastLocationEntity;
    }

    public long getLastSensorBatchEndTimestampMs() {
        return this.lastSensorBatchEndTimestampMs;
    }

    public BDLocation getLightLocation() {
        return this.mLightLocation;
    }

    public long getLightLocationWifiGap() {
        return this.mLightLocationWifiGap;
    }

    public String getLocateId() {
        return this.mLocateId;
    }

    public int getLocateType() {
        return this.mLocateType;
    }

    public LocationExtraBean getLocationExtraBean() {
        return this.locationExtraBean;
    }

    public BDLocationExtraDataServer getLocationExtraDataServer() {
        return this.mLocationExtraDataServer;
    }

    public LocationExtraDataTraceLogger getLocationExtraDataTraceLogger() {
        return this.mLocationExtraDataTraceLogger;
    }

    public long getLocationTimeOutMs() {
        return this.locationTimeOutMs;
    }

    public LocationTraceLogger getLocationTraceLogger() {
        return this.mLocationTraceLogger;
    }

    public long getMaxCacheTime() {
        return this.maxCacheTime;
    }

    public float getMinUpdateDistance() {
        return this.mMinUpdateDistance;
    }

    public int getMode() {
        return this.mode;
    }

    public long getStartLocationTime() {
        return this.startLocationTime;
    }

    public StationarySceneCacheInfo getStationarySceneCacheInfo() {
        return this.mStationarySceneCacheInfo;
    }

    public String getTraceContext() {
        return this.mTraceContext;
    }

    public int getTriggerType() {
        return this.mTriggerType;
    }

    public long getUploadInterval() {
        return this.mUploadInterval;
    }

    public String getUploadSource() {
        return this.uploadSource;
    }

    public boolean isAMapGpsFirst() {
        return this.mAMapGpsFirst;
    }

    public boolean isBackground() {
        return this.mIsBackground;
    }

    public boolean isCert() {
        return this.mCert;
    }

    public boolean isChineseRegion() {
        return this.mChineseRegion;
    }

    public boolean isDownGradeLocation() {
        return this.downGradeLocation;
    }

    public boolean isHitStationaryScene() {
        return this.mHitStationaryScene;
    }

    public boolean isIndoor() {
        return this.mIsIndoor;
    }

    public boolean isLatestAdminVersion() {
        return this.mLatestAdminVersion;
    }

    public boolean isLocationChanged() {
        return this.locationChanged;
    }

    public boolean isOnceLocation() {
        return this.onceLocation;
    }

    public boolean isSynchronizeUpload() {
        return this.mSynchronizeUpload;
    }

    public boolean isUpload() {
        return this.sIsUpload;
    }

    public boolean scanBle() {
        return this.scanBle;
    }

    public LocationOption(LocationOption r100) {
        this.enableAMapBackgroundContiLocation = false;
        this.alreadyCallback = false;
        this.isCallbackThroughLocateTrace = false;
        this.mAccuracyLevel = 4;
        this.uploadSource = "";
        this.mBpeaAction = "";
        this.mLocateType = -1;
        this.sIsUpload = true;
        this.mTriggerType = 1;
        this.locationTimeOutMs = 30000;
        this.mCert = false;
        this.locationChanged = false;
        this.onceLocation = true;
        this.downGradeLocation = false;
        this.mHostSwitchThreadDuration = -1;
        this.mode = 2;
        this.maxCacheTime = 600000;
        this.geocodeMode = 1;
        this.mLatestAdminVersion = false;
        this.scanBle = true;
        this.mChineseRegion = true;
        this.mLocateId = "-1";
        this.mLightLocationWifiGap = -1;
        this.mSynchronizeUpload = true;
        this.mFusionLocationWorkMode = 1;
        this.mFusionLocationUserMotionMode = 2;
        this.mEnableUploadNetSignal = true;
        this.lastSensorBatchEndTimestampMs = 0;
        if (r100 != null) goto L5;
        return;
    L5:
        this.mLightLocationWifiGap = r100.mLightLocationWifiGap;
        this.mLastLocationEntity = r100.mLastLocationEntity;
        this.locationTimeOutMs = r100.locationTimeOutMs;
        this.interval = r100.interval;
        this.mHostSwitchThreadDuration = r100.mHostSwitchThreadDuration;
        this.mAMapGpsFirst = r100.mAMapGpsFirst;
        this.mAMapGpsFirstTimeoutMillis = r100.mAMapGpsFirstTimeoutMillis;
        this.mode = r100.mode;
        this.maxCacheTime = r100.maxCacheTime;
        this.geocodeMode = r100.geocodeMode;
        this.mIsIndoor = r100.mIsIndoor;
        this.uploadSource = r100.uploadSource;
        this.mBpeaCert = r100.mBpeaCert;
        this.mBpeaAction = r100.mBpeaAction;
        this.mAccuracyLevel = r100.mAccuracyLevel;
        this.enableAMapBackgroundContiLocation = r100.enableAMapBackgroundContiLocation;
        this.mTriggerType = r100.mTriggerType;
        this.mLocateType = r100.mLocateType;
        this.sIsUpload = r100.sIsUpload;
        this.onceLocation = r100.onceLocation;
        this.downGradeLocation = r100.downGradeLocation;
        this.mLatestAdminVersion = r100.mLatestAdminVersion;
        this.locationChanged = r100.locationChanged;
        this.mCert = r100.mCert;
        this.mUploadInterval = r100.mUploadInterval;
        this.startLocationTime = r100.startLocationTime;
        this.locationExtraBean = r100.locationExtraBean;
        this.scanBle = r100.scanBle;
        this.mChineseRegion = r100.mChineseRegion;
        this.mExtra = r100.mExtra;
        this.mLocationTraceLogger = r100.mLocationTraceLogger;
        this.mLocationExtraDataTraceLogger = r100.mLocationExtraDataTraceLogger;
        this.mSynchronizeUpload = r100.mSynchronizeUpload;
        this.mFusionLocationWorkMode = r100.mFusionLocationWorkMode;
        this.mFusionLocationUserMotionMode = r100.mFusionLocationUserMotionMode;
        this.mIsBackground = r100.mIsBackground;
        this.mLocateId = r100.mLocateId;
        this.mLBSLightLocationTraceLogger = r100.mLBSLightLocationTraceLogger;
        this.mLocationExtraDataServer = r100.mLocationExtraDataServer;
        this.mLightLocation = r100.mLightLocation;
        this.startLocationElapsedRealtimeMillis = r100.startLocationElapsedRealtimeMillis;
        this.startLocationTimestampInMillis = r100.startLocationTimestampInMillis;
        this.isCallbackThroughLocateTrace = r100.isCallbackThroughLocateTrace;
        this.alreadyCallback = r100.alreadyCallback;
        this.mHitStationaryScene = r100.mHitStationaryScene;
        this.mStationarySceneCacheInfo = r100.mStationarySceneCacheInfo;
        this.mMinUpdateDistance = r100.mMinUpdateDistance;
        this.mGpsTimeoutMs = r100.mGpsTimeoutMs;
        this.mEnableUploadNetSignal = r100.mEnableUploadNetSignal;
        this.backupIntervalMs = r100.backupIntervalMs;
        this.mBusinessId = r100.mBusinessId;
        this.lastSensorBatchEndTimestampMs = r100.lastSensorBatchEndTimestampMs;
        this.mAcceptLightLocationResult = r100.mAcceptLightLocationResult;
        this.mTraceContext = r100.mTraceContext;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LocationOption) == true) goto L8;
        return false;
    L8:
        LocationOption r101 = (LocationOption) r100;
        if (this.locationTimeOutMs == r101.locationTimeOutMs) goto L12;
        return false;
    L12:
        if (this.interval == r101.interval) goto L15;
        return false;
    L15:
        if (this.mHostSwitchThreadDuration == r101.mHostSwitchThreadDuration) goto L18;
        return false;
    L18:
        if (this.mAMapGpsFirst == r101.mAMapGpsFirst) goto L21;
        return false;
    L21:
        if (this.mAMapGpsFirstTimeoutMillis == r101.mAMapGpsFirstTimeoutMillis) goto L24;
        return false;
    L24:
        if (this.geocodeMode == r101.geocodeMode) goto L27;
        return false;
    L27:
        if (this.mIsIndoor == r101.mIsIndoor) goto L30;
        return false;
    L30:
        if (this.sIsUpload == r101.sIsUpload) goto L33;
        return false;
    L33:
        if (this.onceLocation == r101.onceLocation) goto L36;
        return false;
    L36:
        if (this.downGradeLocation == r101.downGradeLocation) goto L39;
        return false;
    L39:
        if (this.mLatestAdminVersion == r101.mLatestAdminVersion) goto L42;
        return false;
    L42:
        if (this.mCert == r101.mCert) goto L45;
        return false;
    L45:
        if (this.mTriggerType == r101.mTriggerType) goto L48;
        return false;
    L48:
        if (this.mLocateType == r101.mLocateType) goto L51;
        return false;
    L51:
        if (this.mAccuracyLevel == r101.mAccuracyLevel) goto L54;
        return false;
    L54:
        if (this.enableAMapBackgroundContiLocation == r101.enableAMapBackgroundContiLocation) goto L57;
        return false;
    L57:
        if (TextUtils.equals(this.uploadSource, r101.uploadSource) == true) goto L60;
        return false;
    L60:
        if (this.mBpeaCert == r101.mBpeaCert) goto L63;
        return false;
    L63:
        if (TextUtils.equals(this.mBpeaAction, r101.mBpeaAction) == true) goto L66;
        return false;
    L66:
        if (TextUtils.equals(this.mExtra, r101.mExtra) == true) goto L69;
        return false;
    L69:
        if (this.startLocationTime == r101.startLocationTime) goto L72;
        return false;
    L72:
        if (this.mLastLocationEntity == r101.mLastLocationEntity) goto L75;
        return false;
    L75:
        if (this.mLightLocationWifiGap == r101.mLightLocationWifiGap) goto L78;
        return false;
    L78:
        if (this.mSynchronizeUpload == r101.mSynchronizeUpload) goto L81;
        return false;
    L81:
        if (this.mFusionLocationWorkMode == r101.mFusionLocationWorkMode) goto L84;
        return false;
    L84:
        if (this.mFusionLocationUserMotionMode == r101.mFusionLocationUserMotionMode) goto L87;
        return false;
    L87:
        if (this.startLocationElapsedRealtimeMillis == r101.startLocationElapsedRealtimeMillis) goto L90;
        return false;
    L90:
        if (this.startLocationTimestampInMillis == r101.startLocationTimestampInMillis) goto L93;
        return false;
    L93:
        if (this.isCallbackThroughLocateTrace == r101.isCallbackThroughLocateTrace) goto L96;
        return false;
    L96:
        if (this.alreadyCallback == r101.alreadyCallback) goto L99;
        return false;
    L99:
        if (this.mHitStationaryScene == r101.mHitStationaryScene) goto L102;
        return false;
    L102:
        if (this.mStationarySceneCacheInfo == r101.mStationarySceneCacheInfo) goto L105;
        return false;
    L105:
        if (this.mMinUpdateDistance == r101.mMinUpdateDistance) goto L108;
        return false;
    L108:
        if (this.mGpsTimeoutMs == r101.mGpsTimeoutMs) goto L111;
        return false;
    L111:
        if (this.backupIntervalMs == r101.backupIntervalMs) goto L114;
        return false;
    L114:
        if (this.mEnableUploadNetSignal == r101.mEnableUploadNetSignal) goto L116;
        return false;
    L116:
        Boolean r102 = this.mAcceptLightLocationResult;
        if (r102 != null) goto L122;
        if (r101.mAcceptLightLocationResult == null) goto L125;
        return false;
    L125:
        if (TextUtils.equals(this.mTraceContext, r101.mTraceContext) == true) goto L128;
        return false;
    L128:
        if (this.mode == r101.mode) goto L132;
        return false;
    L132:
        return true;
    L122:
        if (r102.equals(r101.mAcceptLightLocationResult) == true) goto L125;
        return false;
    }

    public void setAMapGpsFirst(boolean r100) {
        this.mAMapGpsFirst = r100;
    }

    public void setAMapGpsFirstTimeoutMillis(long r100) {
        this.mAMapGpsFirstTimeoutMillis = r100;
    }

    public void setAcceptLightLocationResult(Boolean r100) {
        this.mAcceptLightLocationResult = r100;
    }

    public void setAccuracyLevel(int r100) {
        this.mAccuracyLevel = r100;
    }

    public void setBackground(boolean r100) {
        this.mIsBackground = r100;
    }

    public void setBackupIntervalMs(long r100) {
        this.backupIntervalMs = r100;
    }

    public void setBpeaAction(String r100) {
        this.mBpeaAction = r100;
    }

    public void setBpeaCert(Object r100) {
        this.mBpeaCert = r100;
    }

    public void setBusinessId(String r100) {
        this.mBusinessId = r100;
    }

    public void setCert(boolean r100) {
        this.mCert = r100;
    }

    public void setChineseRegion(boolean r100) {
        this.mChineseRegion = r100;
    }

    public void setDownGradeLocation(boolean r100) {
        this.downGradeLocation = r100;
    }

    public void setEnableUploadNetSignal(boolean r100) {
        this.mEnableUploadNetSignal = r100;
    }

    public void setExtra(String r100) {
        this.mExtra = r100;
    }

    public void setFusionLocationUserMotionMode(int r100) {
        this.mFusionLocationUserMotionMode = r100;
    }

    public void setFusionLocationWorkMode(int r100) {
        this.mFusionLocationWorkMode = r100;
    }

    public void setGeocodeMode(int r100) {
        this.geocodeMode = r100;
    }

    public void setGpsTimeoutMs(long r100) {
        this.mGpsTimeoutMs = r100;
    }

    public void setHitStationaryScene(boolean r100) {
        this.mHitStationaryScene = r100;
    }

    public void setHostSwitchThreadDuration(long r100) {
        this.mHostSwitchThreadDuration = r100;
    }

    public void setIndoor(boolean r100) {
        this.mIsIndoor = r100;
    }

    public void setInterval(long r100) {
        this.interval = r100;
    }

    public void setLBSLightLocationTraceLogger(LBSLightLocationTraceLogger r100) {
        this.mLBSLightLocationTraceLogger = r100;
    }

    public void setLastLocationEntity(LastLocationEntity r100) {
        this.mLastLocationEntity = r100;
    }

    public void setLastSensorBatchEndTimestampMs(long r100) {
        this.lastSensorBatchEndTimestampMs = r100;
    }

    public void setLatestAdminVersion(boolean r100) {
        this.mLatestAdminVersion = r100;
    }

    public void setLightLocation(BDLocation r100) {
        this.mLightLocation = r100;
    }

    public void setLightLocationWifiGap(long r100) {
        this.mLightLocationWifiGap = r100;
    }

    public void setLocateId(String r100) {
        this.mLocateId = r100;
    }

    public void setLocateType(int r100) {
        this.mLocateType = r100;
    }

    public void setLocationChanged(boolean r100) {
        this.locationChanged = r100;
    }

    public void setLocationExtraBean(LocationExtraBean r100) {
        this.locationExtraBean = r100;
    }

    public void setLocationExtraDataServer(BDLocationExtraDataServer r100) {
        this.mLocationExtraDataServer = r100;
    }

    public void setLocationExtraDataTraceLogger(LocationExtraDataTraceLogger r100) {
        this.mLocationExtraDataTraceLogger = r100;
    }

    public void setLocationTimeOutMs(long r100) {
        if (r100 >= 5000) goto L5;
        r100 = 5000;
    L5:
        this.locationTimeOutMs = r100;
    }

    public void setLocationTraceLogger(LocationTraceLogger r100) {
        this.mLocationTraceLogger = r100;
    }

    public void setMaxCacheTime(long r100) {
        this.maxCacheTime = r100;
    }

    public void setMinUpdateDistance(float r100) {
        this.mMinUpdateDistance = r100;
    }

    public void setMode(int r100) {
        this.mode = r100;
    }

    public void setOnceLocation(boolean r100) {
        this.onceLocation = r100;
    }

    public void setScanBle(boolean r100) {
        this.scanBle = r100;
    }

    public void setStartLocationTime(long r100) {
        this.startLocationTime = r100;
    }

    public void setStationarySceneCacheInfo(StationarySceneCacheInfo r100) {
        this.mStationarySceneCacheInfo = r100;
    }

    public void setSynchronizeUpload(boolean r100) {
        this.mSynchronizeUpload = r100;
    }

    public void setTraceContext(String r100) {
        this.mTraceContext = r100;
    }

    public void setTriggerType(int r100) {
        this.mTriggerType = r100;
    }

    public void setUpload(boolean r100) {
        this.sIsUpload = r100;
    }

    public void setUploadInterval(long r100) {
        this.mUploadInterval = r100;
    }

    public void setUploadSource(String r100) {
        this.uploadSource = r100;
    }
}
