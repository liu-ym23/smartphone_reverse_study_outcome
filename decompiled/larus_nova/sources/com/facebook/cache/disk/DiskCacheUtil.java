package com.facebook.cache.disk;

import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import java.util.HashMap;

/* JADX INFO: loaded from: classes22.dex */
public class DiskCacheUtil {
    private static final int CACHE_MAP_DEFAULT_MAX_SIZE = 1000;
    private static final String TAG = "DiskCacheUtil";
    private static HashMap<String, Integer> mDiskCacheVisitCountMap = null;
    private static boolean mOptDiskCacheLRU = false;
    private static int maxHashMapSize = 1000;

    static {
        mDiskCacheVisitCountMap = new HashMap();
    }

    public static void clearDiskCacheVisitCountMap() {
        if (mOptDiskCacheLRU == false) goto L11;
        mDiskCacheVisitCountMap.clear();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        FLog.d(TAG, "clearDiskCacheVisitCountMap mImageLoadDurationMap clear failed! t = " + th);
        return;
    }

    private DiskCacheUtil() {
    }

    public static boolean isOptDiskCacheLRU() {
        return mOptDiskCacheLRU;
    }

    public static void deleteDiskCacheVisitCount(String r100) {
        if (mOptDiskCacheLRU == false) goto L11;
        mDiskCacheVisitCountMap.remove(r100);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        FLog.d(TAG, "deleteDiskCacheVisitCountById: Throwable = " + th);
        return;
    }

    public static int getVisitCount(String r100) {
    L10:
        th = move-exception;
        FLog.d(TAG, "getVisitCount: Throwable = " + th);
        return 0;
    L3:
        if (mOptDiskCacheLRU == true) goto L5;
        return 0;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return 0;
    L7:
        if (mDiskCacheVisitCountMap.containsKey(r100) == false) goto L18;
        return mDiskCacheVisitCountMap.get(r100).intValue();
    L18:
        return 0;
    }

    public static void newDiskCacheVisitCount(String r100) {
        if (mOptDiskCacheLRU == false) goto L14;
    L9:
        th = move-exception;
        FLog.d(TAG, "newDiskCacheVisitCount: Throwable = " + th);
        return;
    L5:
        if (mDiskCacheVisitCountMap.size() <= maxHashMapSize) goto L7;
        mDiskCacheVisitCountMap.clear();     // Catch: Throwable -> L9
    L7:
        mDiskCacheVisitCountMap.put(r100, 1);     // Catch: Throwable -> L9
        return;
    }

    public static void setMapMaxSize(int r100) {
        maxHashMapSize = r100;
    }

    public static void setOptDiskCacheLRU(boolean r100) {
        mOptDiskCacheLRU = r100;
    }

    public static void updateDiskCacheVisitCount(String r100) {
        if (mOptDiskCacheLRU == true) goto L16;
        return;
    L16:
    L13:
        th = move-exception;
        mDiskCacheVisitCountMap.put(r100, 1);
        FLog.d(TAG, "updateDiskCacheVisitCount: Throwable = " + th);
        return;
    L6:
        if (mDiskCacheVisitCountMap.size() <= maxHashMapSize) goto L9;
        mDiskCacheVisitCountMap.clear();     // Catch: Throwable -> L13
    L9:
        if (mDiskCacheVisitCountMap.containsKey(r100) == true) goto L11;
        mDiskCacheVisitCountMap.put(r100, 1);     // Catch: Throwable -> L13
        return;
    L11:
        mDiskCacheVisitCountMap.put(r100, Integer.valueOf(mDiskCacheVisitCountMap.get(r100).intValue() + 1));     // Catch: Throwable -> L13
    }
}
