package com.bytedance.ee.bear.drive.preload;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.ttvideoengine.DataLoaderHelper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class VideoCacheInfo implements NonProguard {
    DataLoaderHelper.DataLoaderCacheInfo cacheInfo;
    DriveCacheInfo driveCacheInfo;

    public f85.a getFileModel() {
        return this.driveCacheInfo.toFileModel();
    }

    public boolean isCacheValid() {
        DataLoaderHelper.DataLoaderCacheInfo r0 = this.cacheInfo;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.mMediaSize <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public VideoCacheInfo() {
    }

    public boolean isDataVersionChanged(w75.c r2) {
        return !TextUtils.equals(this.driveCacheInfo.getDataVersion(), r2.h());
    }

    public boolean isPreviewUrlChanged(String r2) {
        return !TextUtils.equals(r2, this.driveCacheInfo.getVideoPreviewUrl());
    }

    public VideoCacheInfo(DataLoaderHelper.DataLoaderCacheInfo r1, DriveCacheInfo r2) {
        this.cacheInfo = r1;
        this.driveCacheInfo = r2;
    }
}
