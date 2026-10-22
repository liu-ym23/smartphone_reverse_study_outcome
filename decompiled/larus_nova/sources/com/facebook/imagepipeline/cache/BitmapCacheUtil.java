package com.facebook.imagepipeline.cache;

import android.text.TextUtils;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import java.util.HashSet;

/* JADX INFO: loaded from: classes23.dex */
public class BitmapCacheUtil extends MemoryCacheUtil {
    private static final String ORIGIN_RESIZE_OPTION_MARKER = "origin";
    public static final ResizeOptions REUSE_ORIGIN_RESIZE_OPTION = null;
    private static final String TAG = "BitmapCacheUtil";
    private static HashSet<String> allowStaticSet;
    private static String mCurrentBizTag;
    private static boolean mOptAnim;
    private static int mOptAnimSingleLimit;
    private static int mOptAnimTotalLimit;
    private static int mReuseRule;

    public @interface ReuseRule {
        public static final int BOTH_WH = 0;
        public static final int W_OR_H = 1;
        public static final int W_X_H = 2;
    }

    static {
        REUSE_ORIGIN_RESIZE_OPTION = new ResizeOptions(1, 1);
        mOptAnim = false;
        mOptAnimTotalLimit = BmLocated.ALIGN_RIGHT_BOTTOM;
        mOptAnimSingleLimit = 4194304;
        allowStaticSet = new HashSet();
    }

    public static boolean isCurrentBizTagAllowStatic() {
        if (TextUtils.isEmpty(mCurrentBizTag) == false) goto L7;
        return false;
    L7:
        return allowStaticSet.contains(mCurrentBizTag);
    }

    private BitmapCacheUtil() {
    }

    public static int getOptAnimSingleLimit() {
        return mOptAnimSingleLimit;
    }

    public static int getOptAnimTotalLimit() {
        return mOptAnimTotalLimit;
    }

    public static boolean isOptAnim() {
        return mOptAnim;
    }

    public static ResizeOptions getOptReuseResizeOption(CacheKey r100) {
    L50:
        th = move-exception;
        FLog.d(TAG, "getOptReuseResizeOption: 111 Throwable = " + th);
    L52:
        return null;
    L4:
        if (MemoryCacheUtil.mOptReuseBitmapCache == false) goto L52;
        if ((r100 instanceof BitmapMemoryCacheKey) == false) goto L52;
        ResizeOptions r101 = ((BitmapMemoryCacheKey) r100).getResizeOptions();     // Catch: Throwable -> L50
        if (r101 != null) goto L11;
        return null;
    L11:
        if (MemoryCacheUtil.mKeyOnlyUseUri == false) goto L53;
        String r102 = r100.getUriString();     // Catch: Throwable -> L50
    L17:
        String r103 = MemoryCacheUtil.mReuseBitmapCacheMap.get(r102);     // Catch: Throwable -> L50
        if ("origin".equals(r103) == false) goto L22;
        return REUSE_ORIGIN_RESIZE_OPTION;
    L22:
        if (TextUtils.isEmpty(r103) == false) goto L24;
        String[] r104 = null;
    L25:
        if (r104 == null) goto L52;
        if (r104.length != 2) goto L52;
        int r105 = Integer.parseInt(r104[0]);     // Catch: Throwable -> L50
        int r106 = Integer.parseInt(r104[1]);     // Catch: Throwable -> L50
        int r107 = r101.width;     // Catch: Throwable -> L50
        if (r105 == r107) goto L31;
    L33:
        int r108 = mReuseRule;     // Catch: Throwable -> L50
        if (r108 == 1) goto L45;
        if (r108 == 2) goto L42;
        if (r105 < r107) goto L52;
        if (r106 < r101.height) goto L52;
        return new ResizeOptions(r105, r106);
    L42:
        if ((r105 * r106) < (r107 * r101.height)) goto L52;
        return new ResizeOptions(r105, r106);
    L45:
        if (r105 >= r107) goto L49;
        if (r106 < r101.height) goto L52;
    L49:
        return new ResizeOptions(r105, r106);
    L31:
        if (r106 != r101.height) goto L33;
        return null;
    L24:
        r104 = r103.split("x");     // Catch: Throwable -> L50
        goto L25
    L53:
        r102 = r100.toString().substring(0, r100.toString().indexOf("resizeOption:"));     // Catch: Exception -> L16 Throwable -> L50
    L16:
        r102 = r100.getUriString();     // Catch: Throwable -> L50
        goto L17
    }

    public static void insertReuseBitmapCacheMap(CacheKey r100) {
        if (MemoryCacheUtil.mOptReuseBitmapCache == false) goto L38;
        if (r100 != null) goto L6;
        return;
    L6:
        if ((r100 instanceof BitmapMemoryCacheKey) == true) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r100.toString()) == false) goto L10;
        return;
    L10:
        if (r100.toString().contains("resizeOption:") == false) goto L42;
    L32:
        th = move-exception;
        FLog.d(TAG, "newDiskCacheVisitCount: Throwable = " + th);
        return;
    L12:
        if (MemoryCacheUtil.mReuseBitmapCacheMap.size() <= MemoryCacheUtil.maxHashMapSize) goto L14;
        MemoryCacheUtil.mReuseBitmapCacheMap.clear();     // Catch: Throwable -> L32
    L14:
        ResizeOptions r101 = ((BitmapMemoryCacheKey) r100).getResizeOptions();     // Catch: Throwable -> L32
        if (FrescoCacheMonitorUtil.isAutoDownsampleKeyOpt() == true) goto L19;
        if (r101 != null) goto L19;
        return;
    L19:
        if (MemoryCacheUtil.mKeyOnlyUseUri == false) goto L35;
        String r102 = r100.getUriString();     // Catch: Throwable -> L32
    L26:
        if (r101 != null) goto L29;
        MemoryCacheUtil.mReuseBitmapCacheMap.put(r102, "origin");     // Catch: Throwable -> L32
        return;
    L29:
        if ("origin".equals(MemoryCacheUtil.mReuseBitmapCacheMap.get(r102)) == true) goto L44;
        MemoryCacheUtil.mReuseBitmapCacheMap.put(r102, r101.toString());     // Catch: Throwable -> L32
        return;
    L44:
        return;
    L35:
        r102 = r100.toString().substring(0, r100.toString().indexOf("resizeOption:"));     // Catch: Exception -> L24 Throwable -> L32
    L24:
        r102 = r100.getUriString();     // Catch: Throwable -> L32
        goto L26
    L42:
        return;
    }

    public static void setAllowStaticBizTag(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        allowStaticSet.add(r100);
        return;
    }

    public static void setCurrentBizTag(String r100) {
        mCurrentBizTag = r100;
    }

    public static void setOptAnim(boolean r100) {
        mOptAnim = r100;
    }

    public static void setOptAnimSingleLimit(int r100) {
        mOptAnimSingleLimit = r100;
    }

    public static void setOptAnimTotalLimit(int r100) {
        mOptAnimTotalLimit = r100;
    }

    public static void setReuseRule(int r100) {
        mReuseRule = r100;
    }
}
