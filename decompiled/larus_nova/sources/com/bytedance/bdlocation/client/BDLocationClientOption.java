package com.bytedance.bdlocation.client;

/* JADX INFO: loaded from: classes10.dex */
public class BDLocationClientOption {
    private boolean mAMapGpsFirst;
    private long mAMapGpsFirstTimeoutMillis;
    private Boolean mAcceptLightLocationResult;
    private int mAccuracyLevel;
    private long mBackupIntervalMs;
    private Object mBpeaCert;
    private String mBusinessId;
    private boolean mCert;
    private boolean mEnableAMapBackgroundContiLocation;
    private String mExtra;
    private int mFusionLocationUserMotionMode;
    private int mFusionLocationWorkMode;
    private long mGpsTimeoutMs;
    private long mHostSwitchThreadDuration;
    private long mInterval;
    private boolean mLatestAdminVersion;
    private int mLocateType;
    private int mLocationMode;
    private long mLocationTimeOut;
    private long mMaxCacheTime;
    private boolean mSynchronizeUpload;
    private String mTraceContext;
    private int mTriggerType;
    private boolean mUpload;
    private String mUploadSource;

    public BDLocationClientOption() {
        this.mEnableAMapBackgroundContiLocation = false;
        this.mTriggerType = 1;
        this.mAccuracyLevel = 4;
        this.mLocationMode = 2;
        this.mLocateType = 3;
        this.mMaxCacheTime = 600000;
        this.mLocationTimeOut = 30000;
        this.mUploadSource = "";
        this.mInterval = 0;
        this.mCert = false;
        this.mLatestAdminVersion = false;
        this.mUpload = true;
        this.mHostSwitchThreadDuration = -1;
        this.mSynchronizeUpload = true;
        this.mFusionLocationWorkMode = 1;
        this.mFusionLocationUserMotionMode = 2;
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
        return this.mBackupIntervalMs;
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

    public long getGpsTimeoutMs() {
        return this.mGpsTimeoutMs;
    }

    public long getHostSwitchThreadDuration() {
        return this.mHostSwitchThreadDuration;
    }

    public long getInterval() {
        return this.mInterval;
    }

    public int getLocateType() {
        return this.mLocateType;
    }

    public int getLocationMode() {
        return this.mLocationMode;
    }

    public long getLocationTimeOut() {
        return this.mLocationTimeOut;
    }

    public long getMaxCacheTime() {
        return this.mMaxCacheTime;
    }

    public String getTraceContext() {
        return this.mTraceContext;
    }

    public int getTriggerType() {
        return this.mTriggerType;
    }

    public String getUploadSource() {
        return this.mUploadSource;
    }

    public int getUserMotionMode() {
        return this.mFusionLocationUserMotionMode;
    }

    public int getWorkMode() {
        return this.mFusionLocationWorkMode;
    }

    public boolean isAMapGpsFirst() {
        return this.mAMapGpsFirst;
    }

    public boolean isCert() {
        return this.mCert;
    }

    public boolean isEnableAMapBackgroundContiLocation() {
        return this.mEnableAMapBackgroundContiLocation;
    }

    public boolean isLatestAdminVersion() {
        return this.mLatestAdminVersion;
    }

    public boolean isSynchronizeUpload() {
        return this.mSynchronizeUpload;
    }

    public boolean isUpload() {
        return this.mUpload;
    }

    public BDLocationClientOption setAMapGpsFirst(boolean r100) {
        this.mAMapGpsFirst = r100;
        return this;
    }

    public BDLocationClientOption setAMapGpsFirstTimeoutMillis(long r100) {
        this.mAMapGpsFirstTimeoutMillis = r100;
        return this;
    }

    public BDLocationClientOption setAcceptLightLocationResult(Boolean r100) {
        this.mAcceptLightLocationResult = r100;
        return this;
    }

    public BDLocationClientOption setAccuracyLevel(int r100) {
        this.mAccuracyLevel = r100;
        return this;
    }

    public BDLocationClientOption setBackupIntervalMs(long r100) {
        this.mBackupIntervalMs = r100;
        return this;
    }

    public BDLocationClientOption setBpeaCert(Object r100) {
        this.mBpeaCert = r100;
        return this;
    }

    public BDLocationClientOption setBusinessId(String r100) {
        this.mBusinessId = r100;
        return this;
    }

    public BDLocationClientOption setCert(boolean r100) {
        this.mCert = r100;
        return this;
    }

    public BDLocationClientOption setEnableAMapBackgroundContiLocation(boolean r100) {
        this.mEnableAMapBackgroundContiLocation = r100;
        return this;
    }

    public void setExtra(String r100) {
        this.mExtra = r100;
    }

    public BDLocationClientOption setFusionLocationUserMotionMode(int r100) {
        this.mFusionLocationUserMotionMode = r100;
        return this;
    }

    public BDLocationClientOption setFusionLocationWorkMode(int r100) {
        this.mFusionLocationWorkMode = r100;
        return this;
    }

    public BDLocationClientOption setGpsTimeoutMs(long r100) {
        this.mGpsTimeoutMs = r100;
        return this;
    }

    public BDLocationClientOption setHostSwitchThreadDuration(long r100) {
        this.mHostSwitchThreadDuration = r100;
        return this;
    }

    public BDLocationClientOption setInterval(long r100) {
        this.mInterval = r100;
        return this;
    }

    public BDLocationClientOption setLatestAdminVersion(boolean r100) {
        this.mLatestAdminVersion = r100;
        return this;
    }

    public BDLocationClientOption setLocateType(int r100) {
        this.mLocateType = r100;
        return this;
    }

    public BDLocationClientOption setLocationMode(int r100) {
        this.mLocationMode = r100;
        return this;
    }

    public BDLocationClientOption setLocationTimeOut(long r100) {
        this.mLocationTimeOut = r100;
        return this;
    }

    public BDLocationClientOption setMaxCacheTime(long r100) {
        this.mMaxCacheTime = r100;
        return this;
    }

    public BDLocationClientOption setSynchronizeUpload(boolean r100) {
        this.mSynchronizeUpload = r100;
        return this;
    }

    public BDLocationClientOption setTraceContext(String r100) {
        this.mTraceContext = r100;
        return this;
    }

    public BDLocationClientOption setTriggerType(int r100) {
        this.mTriggerType = r100;
        return this;
    }

    public void setUpload(boolean r100) {
        this.mUpload = r100;
    }

    public BDLocationClientOption setUploadSource(String r100) {
        this.mUploadSource = r100;
        return this;
    }

    public BDLocationClientOption setUserMotionMode(int r100) {
        this.mFusionLocationUserMotionMode = r100;
        return this;
    }

    public BDLocationClientOption setWorkMode(int r100) {
        this.mFusionLocationWorkMode = r100;
        return this;
    }
}
