package com.facebook.imagepipeline.cache;

import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes23.dex */
public class MemoryCacheUtil {
    private static final int CACHE_MAP_DEFAULT_MAX_SIZE = 1000;
    protected static final String SPLIT_RESIZE_OPTION_MARKER = "resizeOption:";
    protected static final String SPLIT_URI_MARKER = "_uri_end";
    private static final String TAG = "MemoryCacheUtil";
    protected static boolean mKeyOnlyUseUri = false;
    protected static boolean mOptReuseBitmapCache = false;
    protected static ConcurrentHashMap<String, String> mReuseBitmapCacheMap = null;
    protected static int maxHashMapSize = 1000;

    public MemoryCacheUtil() {
    }

    static {
        mReuseBitmapCacheMap = new ConcurrentHashMap();
    }

    public static void clearReuseBitmapCacheMap() {
        if (mOptReuseBitmapCache == false) goto L11;
        mReuseBitmapCacheMap.clear();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        FLog.d(TAG, "clearDiskCacheVisitCountMap mImageLoadDurationMap clear failed! t = " + th);
        return;
    }

    public static boolean isOptReuseBitmapCache() {
        return mOptReuseBitmapCache;
    }

    public static void removeReuseBitmapCache(String r100) {
        if (mOptReuseBitmapCache == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return;
    L7:
        if (r100.contains(SPLIT_URI_MARKER) == true) goto L9;
        return;
    L9:
        if (r100.contains(SPLIT_RESIZE_OPTION_MARKER) == false) goto L25;
    L15:
        th = move-exception;
        FLog.d(TAG, "removeReuseBitmapCache: Throwable = " + th);
        return;
    L11:
        if (mKeyOnlyUseUri == false) goto L13;
        mReuseBitmapCacheMap.remove(r100.substring(0, r100.indexOf(SPLIT_RESIZE_OPTION_MARKER)));     // Catch: Throwable -> L15
    L18:
        return;
    L13:
        mReuseBitmapCacheMap.remove(r100.substring(0, r100.indexOf(SPLIT_RESIZE_OPTION_MARKER)));     // Catch: Throwable -> L15
        goto L18
    }

    public static void setKeyOnlyUseUri(boolean r100) {
        mKeyOnlyUseUri = r100;
    }

    public static void setOptReuseBitmapCache(boolean r100) {
        mOptReuseBitmapCache = r100;
    }

    public static void setReuseBitmapCacheMapMaxSize(int r100) {
        maxHashMapSize = r100;
    }
}
