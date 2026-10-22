package com.bytedance.bdlocation.store;

import com.bytedance.bdlocation.BDLocation;

/* JADX INFO: loaded from: classes3.dex */
public class LocationCacheInfo {
    private boolean mIsRecommendLocation;
    private volatile BDLocation mLatestLocation;
    private int mLatestLocationCacheCondition;
    private long mLatestLocationCacheTime;
    private BDLocation mMockLocation;
    private long mNextGpsScanInterval;

    public String toString() {
        return "LocationCacheInfo{, mLatestLocation=" + this.mLatestLocation + ", mMockLocation=" + this.mMockLocation + '}';
    }

    public LocationCacheInfo() {
        this.mLatestLocationCacheCondition = -1;
        this.mLatestLocationCacheTime = -1;
        this.mNextGpsScanInterval = 0;
        this.mIsRecommendLocation = true;
    }

    public BDLocation getLatestLocation() {
        return this.mLatestLocation;
    }

    public int getLatestLocationCacheCondition() {
        return this.mLatestLocationCacheCondition;
    }

    public long getLatestLocationCacheTime() {
        return this.mLatestLocationCacheTime;
    }

    public BDLocation getMockLocation() {
        return this.mMockLocation;
    }

    public long getNextGpsScanInterval() {
        return this.mNextGpsScanInterval;
    }

    public boolean isRecommendLocation() {
        return this.mIsRecommendLocation;
    }

    public void setLatestLocation(BDLocation r100) {
        this.mLatestLocation = r100;
    }

    public void setLatestLocationCacheCondition(int r100) {
        this.mLatestLocationCacheCondition = r100;
    }

    public void setLatestLocationCacheTime(long r100) {
        this.mLatestLocationCacheTime = r100;
    }

    public void setMockLocation(BDLocation r100) {
        this.mMockLocation = r100;
    }

    public void setNextGpsScanInterval(long r100) {
        this.mNextGpsScanInterval = r100;
    }

    public void setRecommendLocation(boolean r100) {
        this.mIsRecommendLocation = r100;
    }
}
