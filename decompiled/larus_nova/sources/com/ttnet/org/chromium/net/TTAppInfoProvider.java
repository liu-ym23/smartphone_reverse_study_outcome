package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes.dex */
@JNINamespace("cronet")
public abstract class TTAppInfoProvider {

    public static class AppInfo {
        private String mAbSdkVersion;
        private String mAbi;
        private String mAppId;
        private String mAppName;
        private String mCarrierRegion;
        private String mChannel;
        private String mDeviceBrand;
        private String mDeviceId;
        private String mDeviceModel;
        private String mDevicePlatform;
        private String mDeviceType;
        private String mDomainBoe;
        private String mDomainBoeHttps;
        private String mDomainHttpDns;
        private String mHostFirst;
        private String mHostSecond;
        private String mHostThird;
        private String mHttpDnsRequestFlags;
        private String mInitRegion;
        private String mIsDomestic;
        private String mIsDropFirstTnc;
        private String mManifestVersionCode;
        private String mNetAccessType;
        private String mOSApi;
        private String mOSVersion;
        private String mRegion;
        private String mSdkAppID;
        private String mSdkVersion;
        private String mStoreIdc;
        private String mSysRegion;
        private String mTNCRequestFlags;
        private String mTNCRequestHeader;
        private String mTNCRequestQuery;
        private String mUpdateVersionCode;
        private String mUserId;
        private String mVersionCode;
        private String mVersionName;

        public AppInfo() {
        }

        public String getAbSdkVersion() {
            return this.mAbSdkVersion;
        }

        public String getAbi() {
            return this.mAbi;
        }

        public String getAppId() {
            return this.mAppId;
        }

        public String getAppName() {
            return this.mAppName;
        }

        public String getCarrierRegion() {
            return this.mCarrierRegion;
        }

        public String getChannel() {
            return this.mChannel;
        }

        public String getDeviceBrand() {
            return this.mDeviceBrand;
        }

        public String getDeviceId() {
            return this.mDeviceId;
        }

        public String getDeviceModel() {
            return this.mDeviceModel;
        }

        public String getDevicePlatform() {
            return this.mDevicePlatform;
        }

        public String getDeviceType() {
            return this.mDeviceType;
        }

        public String getDomainBoe() {
            return this.mDomainBoe;
        }

        public String getDomainBoeHttps() {
            return this.mDomainBoeHttps;
        }

        public String getDomainHttpDns() {
            return this.mDomainHttpDns;
        }

        public String getHostFirst() {
            return this.mHostFirst;
        }

        public String getHostSecond() {
            return this.mHostSecond;
        }

        public String getHostThird() {
            return this.mHostThird;
        }

        public String getHttpDnsRequestFlags() {
            return this.mHttpDnsRequestFlags;
        }

        public String getInitRegion() {
            return this.mInitRegion;
        }

        public String getIsDomestic() {
            return this.mIsDomestic;
        }

        public String getIsDropFirstTnc() {
            return this.mIsDropFirstTnc;
        }

        public String getManifestVersionCode() {
            return this.mManifestVersionCode;
        }

        public String getNetAccessType() {
            return this.mNetAccessType;
        }

        public String getOSApi() {
            return this.mOSApi;
        }

        public String getOSVersion() {
            return this.mOSVersion;
        }

        public String getRegion() {
            return this.mRegion;
        }

        public String getSdkAppID() {
            return this.mSdkAppID;
        }

        public String getSdkVersion() {
            return this.mSdkVersion;
        }

        public String getStoreIdc() {
            return this.mStoreIdc;
        }

        public String getSysRegion() {
            return this.mSysRegion;
        }

        public String getTNCRequestFlags() {
            return this.mTNCRequestFlags;
        }

        public String getTNCRequestHeader() {
            return this.mTNCRequestHeader;
        }

        public String getTNCRequestQuery() {
            return this.mTNCRequestQuery;
        }

        public String getUpdateVersionCode() {
            return this.mUpdateVersionCode;
        }

        public String getUserId() {
            return this.mUserId;
        }

        public String getVersionCode() {
            return this.mVersionCode;
        }

        public String getVersionName() {
            return this.mVersionName;
        }

        public void setAbSdkVersion(String r100) {
            this.mAbSdkVersion = r100;
        }

        public void setAbi(String r100) {
            this.mAbi = r100;
        }

        public void setAppId(String r100) {
            this.mAppId = r100;
        }

        public void setAppName(String r100) {
            this.mAppName = r100;
        }

        public void setCarrierRegion(String r100) {
            this.mCarrierRegion = r100;
        }

        public void setChannel(String r100) {
            this.mChannel = r100;
        }

        public void setDeviceBrand(String r100) {
            this.mDeviceBrand = r100;
        }

        public void setDeviceId(String r100) {
            this.mDeviceId = r100;
        }

        public void setDeviceModel(String r100) {
            this.mDeviceModel = r100;
        }

        public void setDevicePlatform(String r100) {
            this.mDevicePlatform = r100;
        }

        public void setDeviceType(String r100) {
            this.mDeviceType = r100;
        }

        public void setDomainBoe(String r100) {
            this.mDomainBoe = r100;
        }

        public void setDomainBoeHttps(String r100) {
            this.mDomainBoeHttps = r100;
        }

        public void setDomainHttpDns(String r100) {
            this.mDomainHttpDns = r100;
        }

        public void setHostFirst(String r100) {
            this.mHostFirst = r100;
        }

        public void setHostSecond(String r100) {
            this.mHostSecond = r100;
        }

        public void setHostThird(String r100) {
            this.mHostThird = r100;
        }

        public void setHttpDnsRequestFlags(String r100) {
            this.mHttpDnsRequestFlags = r100;
        }

        public void setInitRegion(String r100) {
            this.mInitRegion = r100;
        }

        public void setIsDomestic(String r100) {
            this.mIsDomestic = r100;
        }

        public void setIsDropFirstTnc(String r100) {
            this.mIsDropFirstTnc = r100;
        }

        public void setManifestVersionCode(String r100) {
            this.mManifestVersionCode = r100;
        }

        public void setNetAccessType(String r100) {
            this.mNetAccessType = r100;
        }

        public void setOSApi(String r100) {
            this.mOSApi = r100;
        }

        public void setOSVersion(String r100) {
            this.mOSVersion = r100;
        }

        public void setRegion(String r100) {
            this.mRegion = r100;
        }

        public void setSdkAppID(String r100) {
            this.mSdkAppID = r100;
        }

        public void setSdkVersion(String r100) {
            this.mSdkVersion = r100;
        }

        public void setStoreIdc(String r100) {
            this.mStoreIdc = r100;
        }

        public void setSysRegion(String r100) {
            this.mSysRegion = r100;
        }

        public void setTNCRequestFlags(String r100) {
            this.mTNCRequestFlags = r100;
        }

        public void setTNCRequestHeader(String r100) {
            this.mTNCRequestHeader = r100;
        }

        public void setTNCRequestQuery(String r100) {
            this.mTNCRequestQuery = r100;
        }

        public void setUpdateVersionCode(String r100) {
            this.mUpdateVersionCode = r100;
        }

        public void setUserId(String r100) {
            this.mUserId = r100;
        }

        public void setVersionCode(String r100) {
            this.mVersionCode = r100;
        }

        public void setVersionName(String r100) {
            this.mVersionName = r100;
        }
    }

    public TTAppInfoProvider() {
    }

    public abstract AppInfo getAppInfo();
}
