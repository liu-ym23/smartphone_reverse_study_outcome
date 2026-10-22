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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
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
        BDLocationExtraDataServer r0 = this.mLocationExtraDataServer;
        if (r0 != null) goto L5;
        return null;
    L5:
        GpsInfoManager r1 = r0.getGpsInfoManager();
        if (r1 != null) goto L8;
        return null;
    L8:
        BDScanLocationInfo r2 = r1.getScanLocationInfo();
        if (r2 != null) goto L11;
        return null;
    L11:
        BDGpsInfo r3 = r2.takeGpsInfo(BDScanLocationInfo.TakeStrategy.lastResult);
        BDGnssInfo r4 = r2.findNearbyGnssInfo(r3);
        if (r3 == null) goto L16;
        if (r4 == null) goto L16;
        return new BDGpsInfo(r3, r4);
    L16:
        return r3;
    }

    public BDLocation getGpsLocation() {
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
        return r2.takeGpsLocation(BDScanLocationInfo.TakeStrategy.lastResult);
    }

    public BDLocation getSysLocation() {
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
        return r2.getSysLocation();
    }

    public int hashCode() {
        long r0 = this.locationTimeOutMs;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.interval;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.mHostSwitchThreadDuration;
        int r5 = (((((((((((r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31) + this.mode) * 31) + this.mTriggerType) * 31) + this.mAccuracyLevel) * 31) + this.mLocateType) * 31) + this.geocodeMode) * 31;
        long r6 = this.maxCacheTime;
        int r7 = (((((((((((((r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31) + (this.mIsIndoor ? 1 : 0)) * 31) + (this.sIsUpload ? 1 : 0)) * 31) + (this.mCert ? 1 : 0)) * 31) + (this.onceLocation ? 1 : 0)) * 31) + (this.downGradeLocation ? 1 : 0)) * 31) + (this.mLatestAdminVersion ? 1 : 0)) * 31;
        String r8 = this.uploadSource;
        int r9 = 0;
        if (r8 == null) goto L5;
        int r10 = r8.hashCode();
    L6:
        int r11 = (r7 + r10) * 31;
        Object r12 = this.mBpeaCert;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.mBpeaAction;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        if (this.mExtra == null) goto L17;
        int r18 = this.mExtra.hashCode();
    L18:
        long r19 = this.startLocationTime;
        int r20 = (((r17 + r18) * 31) + ((int) (r19 ^ (r19 >>> 32)))) * 31;
        long r21 = this.startLocationElapsedRealtimeMillis;
        int r22 = (r20 + ((int) (r21 ^ (r21 >>> 32)))) * 31;
        long r23 = this.startLocationTimestampInMillis;
        int r24 = (r22 + ((int) (r23 ^ (r23 >>> 32)))) * 31;
        int r25 = 1231;
        if (this.isCallbackThroughLocateTrace == false) goto L21;
        int r26 = 1231;
    L22:
        int r27 = (r24 + r26) * 31;
        if (this.alreadyCallback == false) goto L25;
        int r28 = 1231;
    L26:
        int r29 = (r27 + r28) * 31;
        if (this.mHitStationaryScene == false) goto L29;
        int r30 = 1231;
    L30:
        int r31 = (r29 + r30) * 31;
        StationarySceneCacheInfo r32 = this.mStationarySceneCacheInfo;
        if (r32 == null) goto L33;
        int r33 = r32.hashCode();
    L34:
        int r34 = (r31 + r33) * 31;
        if (this.enableAMapBackgroundContiLocation == false) goto L37;
        int r35 = 1231;
    L38:
        int r36 = (r34 + r35) * 31;
        if (this.mSynchronizeUpload == false) goto L41;
        int r37 = 1231;
    L42:
        int r38 = (((((r36 + r37) * 31) + this.mFusionLocationWorkMode) * 31) + this.mFusionLocationUserMotionMode) * 31;
        if (this.mAMapGpsFirst == false) goto L45;
        int r39 = 1231;
    L46:
        long r40 = this.mAMapGpsFirstTimeoutMillis;
        int r41 = (((((r38 + r39) * 31) + ((int) (r40 ^ (r40 >>> 32)))) * 31) + Float.floatToIntBits(this.mMinUpdateDistance)) * 31;
        long r42 = this.mGpsTimeoutMs;
        int r43 = (r41 + ((int) (r42 ^ (r42 >>> 32)))) * 31;
        long r44 = this.backupIntervalMs;
        int r45 = (r43 + ((int) (r44 ^ (r44 >>> 32)))) * 31;
        if (this.mEnableUploadNetSignal == true) goto L50;
        r25 = 1237;
    L50:
        int r46 = (r45 + r25) * 31;
        Boolean r47 = this.mAcceptLightLocationResult;
        if (r47 == null) goto L53;
        int r48 = r47.hashCode();
    L54:
        int r49 = (r46 + r48) * 31;
        String r50 = this.mTraceContext;
        if (r50 == null) goto L58;
        r9 = r50.hashCode();
    L58:
        return r49 + r9;
    L53:
        r48 = 0;
        goto L54
    L45:
        r39 = 1237;
        goto L46
    L41:
        r37 = 1237;
        goto L42
    L37:
        r35 = 1237;
        goto L38
    L33:
        r33 = 0;
        goto L34
    L29:
        r30 = 1237;
        goto L30
    L25:
        r28 = 1237;
        goto L26
    L21:
        r26 = 1237;
        goto L22
    L17:
        r18 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
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

    public LocationOption(LocationOption r8) {
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
        if (r8 != null) goto L5;
        return;
    L5:
        this.mLightLocationWifiGap = r8.mLightLocationWifiGap;
        this.mLastLocationEntity = r8.mLastLocationEntity;
        this.locationTimeOutMs = r8.locationTimeOutMs;
        this.interval = r8.interval;
        this.mHostSwitchThreadDuration = r8.mHostSwitchThreadDuration;
        this.mAMapGpsFirst = r8.mAMapGpsFirst;
        this.mAMapGpsFirstTimeoutMillis = r8.mAMapGpsFirstTimeoutMillis;
        this.mode = r8.mode;
        this.maxCacheTime = r8.maxCacheTime;
        this.geocodeMode = r8.geocodeMode;
        this.mIsIndoor = r8.mIsIndoor;
        this.uploadSource = r8.uploadSource;
        this.mBpeaCert = r8.mBpeaCert;
        this.mBpeaAction = r8.mBpeaAction;
        this.mAccuracyLevel = r8.mAccuracyLevel;
        this.enableAMapBackgroundContiLocation = r8.enableAMapBackgroundContiLocation;
        this.mTriggerType = r8.mTriggerType;
        this.mLocateType = r8.mLocateType;
        this.sIsUpload = r8.sIsUpload;
        this.onceLocation = r8.onceLocation;
        this.downGradeLocation = r8.downGradeLocation;
        this.mLatestAdminVersion = r8.mLatestAdminVersion;
        this.locationChanged = r8.locationChanged;
        this.mCert = r8.mCert;
        this.mUploadInterval = r8.mUploadInterval;
        this.startLocationTime = r8.startLocationTime;
        this.locationExtraBean = r8.locationExtraBean;
        this.scanBle = r8.scanBle;
        this.mChineseRegion = r8.mChineseRegion;
        this.mExtra = r8.mExtra;
        this.mLocationTraceLogger = r8.mLocationTraceLogger;
        this.mLocationExtraDataTraceLogger = r8.mLocationExtraDataTraceLogger;
        this.mSynchronizeUpload = r8.mSynchronizeUpload;
        this.mFusionLocationWorkMode = r8.mFusionLocationWorkMode;
        this.mFusionLocationUserMotionMode = r8.mFusionLocationUserMotionMode;
        this.mIsBackground = r8.mIsBackground;
        this.mLocateId = r8.mLocateId;
        this.mLBSLightLocationTraceLogger = r8.mLBSLightLocationTraceLogger;
        this.mLocationExtraDataServer = r8.mLocationExtraDataServer;
        this.mLightLocation = r8.mLightLocation;
        this.startLocationElapsedRealtimeMillis = r8.startLocationElapsedRealtimeMillis;
        this.startLocationTimestampInMillis = r8.startLocationTimestampInMillis;
        this.isCallbackThroughLocateTrace = r8.isCallbackThroughLocateTrace;
        this.alreadyCallback = r8.alreadyCallback;
        this.mHitStationaryScene = r8.mHitStationaryScene;
        this.mStationarySceneCacheInfo = r8.mStationarySceneCacheInfo;
        this.mMinUpdateDistance = r8.mMinUpdateDistance;
        this.mGpsTimeoutMs = r8.mGpsTimeoutMs;
        this.mEnableUploadNetSignal = r8.mEnableUploadNetSignal;
        this.backupIntervalMs = r8.backupIntervalMs;
        this.mBusinessId = r8.mBusinessId;
        this.lastSensorBatchEndTimestampMs = r8.lastSensorBatchEndTimestampMs;
        this.mAcceptLightLocationResult = r8.mAcceptLightLocationResult;
        this.mTraceContext = r8.mTraceContext;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof LocationOption) == true) goto L8;
        return false;
    L8:
        LocationOption r9 = (LocationOption) r8;
        if (this.locationTimeOutMs == r9.locationTimeOutMs) goto L12;
        return false;
    L12:
        if (this.interval == r9.interval) goto L15;
        return false;
    L15:
        if (this.mHostSwitchThreadDuration == r9.mHostSwitchThreadDuration) goto L18;
        return false;
    L18:
        if (this.mAMapGpsFirst == r9.mAMapGpsFirst) goto L21;
        return false;
    L21:
        if (this.mAMapGpsFirstTimeoutMillis == r9.mAMapGpsFirstTimeoutMillis) goto L24;
        return false;
    L24:
        if (this.geocodeMode == r9.geocodeMode) goto L27;
        return false;
    L27:
        if (this.mIsIndoor == r9.mIsIndoor) goto L30;
        return false;
    L30:
        if (this.sIsUpload == r9.sIsUpload) goto L33;
        return false;
    L33:
        if (this.onceLocation == r9.onceLocation) goto L36;
        return false;
    L36:
        if (this.downGradeLocation == r9.downGradeLocation) goto L39;
        return false;
    L39:
        if (this.mLatestAdminVersion == r9.mLatestAdminVersion) goto L42;
        return false;
    L42:
        if (this.mCert == r9.mCert) goto L45;
        return false;
    L45:
        if (this.mTriggerType == r9.mTriggerType) goto L48;
        return false;
    L48:
        if (this.mLocateType == r9.mLocateType) goto L51;
        return false;
    L51:
        if (this.mAccuracyLevel == r9.mAccuracyLevel) goto L54;
        return false;
    L54:
        if (this.enableAMapBackgroundContiLocation == r9.enableAMapBackgroundContiLocation) goto L57;
        return false;
    L57:
        if (TextUtils.equals(this.uploadSource, r9.uploadSource) == true) goto L60;
        return false;
    L60:
        if (this.mBpeaCert == r9.mBpeaCert) goto L63;
        return false;
    L63:
        if (TextUtils.equals(this.mBpeaAction, r9.mBpeaAction) == true) goto L66;
        return false;
    L66:
        if (TextUtils.equals(this.mExtra, r9.mExtra) == true) goto L69;
        return false;
    L69:
        if (this.startLocationTime == r9.startLocationTime) goto L72;
        return false;
    L72:
        if (this.mLastLocationEntity == r9.mLastLocationEntity) goto L75;
        return false;
    L75:
        if (this.mLightLocationWifiGap == r9.mLightLocationWifiGap) goto L78;
        return false;
    L78:
        if (this.mSynchronizeUpload == r9.mSynchronizeUpload) goto L81;
        return false;
    L81:
        if (this.mFusionLocationWorkMode == r9.mFusionLocationWorkMode) goto L84;
        return false;
    L84:
        if (this.mFusionLocationUserMotionMode == r9.mFusionLocationUserMotionMode) goto L87;
        return false;
    L87:
        if (this.startLocationElapsedRealtimeMillis == r9.startLocationElapsedRealtimeMillis) goto L90;
        return false;
    L90:
        if (this.startLocationTimestampInMillis == r9.startLocationTimestampInMillis) goto L93;
        return false;
    L93:
        if (this.isCallbackThroughLocateTrace == r9.isCallbackThroughLocateTrace) goto L96;
        return false;
    L96:
        if (this.alreadyCallback == r9.alreadyCallback) goto L99;
        return false;
    L99:
        if (this.mHitStationaryScene == r9.mHitStationaryScene) goto L102;
        return false;
    L102:
        if (this.mStationarySceneCacheInfo == r9.mStationarySceneCacheInfo) goto L105;
        return false;
    L105:
        if (this.mMinUpdateDistance == r9.mMinUpdateDistance) goto L108;
        return false;
    L108:
        if (this.mGpsTimeoutMs == r9.mGpsTimeoutMs) goto L111;
        return false;
    L111:
        if (this.backupIntervalMs == r9.backupIntervalMs) goto L114;
        return false;
    L114:
        if (this.mEnableUploadNetSignal == r9.mEnableUploadNetSignal) goto L116;
        return false;
    L116:
        Boolean r1 = this.mAcceptLightLocationResult;
        if (r1 != null) goto L122;
        if (r9.mAcceptLightLocationResult == null) goto L125;
        return false;
    L125:
        if (TextUtils.equals(this.mTraceContext, r9.mTraceContext) == true) goto L128;
        return false;
    L128:
        if (this.mode == r9.mode) goto L132;
        return false;
    L132:
        return true;
    L122:
        if (r1.equals(r9.mAcceptLightLocationResult) == true) goto L125;
        return false;
    }

    public void setAMapGpsFirst(boolean r1) {
        this.mAMapGpsFirst = r1;
    }

    public void setAMapGpsFirstTimeoutMillis(long r1) {
        this.mAMapGpsFirstTimeoutMillis = r1;
    }

    public void setAcceptLightLocationResult(Boolean r1) {
        this.mAcceptLightLocationResult = r1;
    }

    public void setAccuracyLevel(int r1) {
        this.mAccuracyLevel = r1;
    }

    public void setBackground(boolean r1) {
        this.mIsBackground = r1;
    }

    public void setBackupIntervalMs(long r1) {
        this.backupIntervalMs = r1;
    }

    public void setBpeaAction(String r1) {
        this.mBpeaAction = r1;
    }

    public void setBpeaCert(Object r1) {
        this.mBpeaCert = r1;
    }

    public void setBusinessId(String r1) {
        this.mBusinessId = r1;
    }

    public void setCert(boolean r1) {
        this.mCert = r1;
    }

    public void setChineseRegion(boolean r1) {
        this.mChineseRegion = r1;
    }

    public void setDownGradeLocation(boolean r1) {
        this.downGradeLocation = r1;
    }

    public void setEnableUploadNetSignal(boolean r1) {
        this.mEnableUploadNetSignal = r1;
    }

    public void setExtra(String r1) {
        this.mExtra = r1;
    }

    public void setFusionLocationUserMotionMode(int r1) {
        this.mFusionLocationUserMotionMode = r1;
    }

    public void setFusionLocationWorkMode(int r1) {
        this.mFusionLocationWorkMode = r1;
    }

    public void setGeocodeMode(int r1) {
        this.geocodeMode = r1;
    }

    public void setGpsTimeoutMs(long r1) {
        this.mGpsTimeoutMs = r1;
    }

    public void setHitStationaryScene(boolean r1) {
        this.mHitStationaryScene = r1;
    }

    public void setHostSwitchThreadDuration(long r1) {
        this.mHostSwitchThreadDuration = r1;
    }

    public void setIndoor(boolean r1) {
        this.mIsIndoor = r1;
    }

    public void setInterval(long r1) {
        this.interval = r1;
    }

    public void setLBSLightLocationTraceLogger(LBSLightLocationTraceLogger r1) {
        this.mLBSLightLocationTraceLogger = r1;
    }

    public void setLastLocationEntity(LastLocationEntity r1) {
        this.mLastLocationEntity = r1;
    }

    public void setLastSensorBatchEndTimestampMs(long r1) {
        this.lastSensorBatchEndTimestampMs = r1;
    }

    public void setLatestAdminVersion(boolean r1) {
        this.mLatestAdminVersion = r1;
    }

    public void setLightLocation(BDLocation r1) {
        this.mLightLocation = r1;
    }

    public void setLightLocationWifiGap(long r1) {
        this.mLightLocationWifiGap = r1;
    }

    public void setLocateId(String r1) {
        this.mLocateId = r1;
    }

    public void setLocateType(int r1) {
        this.mLocateType = r1;
    }

    public void setLocationChanged(boolean r1) {
        this.locationChanged = r1;
    }

    public void setLocationExtraBean(LocationExtraBean r1) {
        this.locationExtraBean = r1;
    }

    public void setLocationExtraDataServer(BDLocationExtraDataServer r1) {
        this.mLocationExtraDataServer = r1;
    }

    public void setLocationExtraDataTraceLogger(LocationExtraDataTraceLogger r1) {
        this.mLocationExtraDataTraceLogger = r1;
    }

    public void setLocationTimeOutMs(long r4) {
        if (r4 >= 5000) goto L5;
        r4 = 5000;
    L5:
        this.locationTimeOutMs = r4;
    }

    public void setLocationTraceLogger(LocationTraceLogger r1) {
        this.mLocationTraceLogger = r1;
    }

    public void setMaxCacheTime(long r1) {
        this.maxCacheTime = r1;
    }

    public void setMinUpdateDistance(float r1) {
        this.mMinUpdateDistance = r1;
    }

    public void setMode(int r1) {
        this.mode = r1;
    }

    public void setOnceLocation(boolean r1) {
        this.onceLocation = r1;
    }

    public void setScanBle(boolean r1) {
        this.scanBle = r1;
    }

    public void setStartLocationTime(long r1) {
        this.startLocationTime = r1;
    }

    public void setStationarySceneCacheInfo(StationarySceneCacheInfo r1) {
        this.mStationarySceneCacheInfo = r1;
    }

    public void setSynchronizeUpload(boolean r1) {
        this.mSynchronizeUpload = r1;
    }

    public void setTraceContext(String r1) {
        this.mTraceContext = r1;
    }

    public void setTriggerType(int r1) {
        this.mTriggerType = r1;
    }

    public void setUpload(boolean r1) {
        this.sIsUpload = r1;
    }

    public void setUploadInterval(long r1) {
        this.mUploadInterval = r1;
    }

    public void setUploadSource(String r1) {
        this.uploadSource = r1;
    }
}
