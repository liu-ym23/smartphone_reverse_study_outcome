package com.ss.bytertc.engine.loader;

/* JADX INFO: loaded from: classes40.dex */
public class RTCNativeLibraryLoaderInfo {
    private static final String TAG = "RTCNativeLibraryLoaderInfo";
    private boolean mIsLoadSuccess;
    private Long mLoadTimeStampMs;
    private int mLoadTimes;
    private String mLoaderClassName;
    private String mSdkVersion;

    public long getLoadTimeStamp() {
        return this.mLoadTimeStampMs.longValue();
    }

    public void loadLibrary() {
        this.mLoadTimes++;
    }

    public String toString() {
        return "RTCNativeLibraryLoaderInfo{SdkVersion='" + this.mSdkVersion + "', LoadTimeStamp=" + this.mLoadTimeStampMs + ", LoaderClassName='" + this.mLoaderClassName + "', LoadTimes=" + this.mLoadTimes + ", IsLoadSuccess=" + this.mIsLoadSuccess + '}';
    }

    public RTCNativeLibraryLoaderInfo() {
        this.mSdkVersion = "";
        this.mLoadTimeStampMs = 0L;
        this.mLoaderClassName = "";
        this.mLoadTimes = 0;
        this.mIsLoadSuccess = false;
    }

    public String getLoaderClassName() {
        return this.mLoaderClassName;
    }

    public String getSdkVersion() {
        return this.mSdkVersion;
    }

    public boolean isLoadSuccess() {
        return this.mIsLoadSuccess;
    }

    public void setLoadResult(boolean r100) {
        this.mIsLoadSuccess = r100;
    }

    public void setLoadTimeStampMs(long r100) {
        this.mLoadTimeStampMs = Long.valueOf(r100);
    }

    public void setLoaderClassName(String r100) {
        this.mLoaderClassName = r100;
    }

    public void setSdkVersion(String r100) {
        this.mSdkVersion = r100;
    }
}
