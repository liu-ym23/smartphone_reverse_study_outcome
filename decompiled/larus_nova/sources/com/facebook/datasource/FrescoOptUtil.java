package com.facebook.datasource;

/* JADX INFO: loaded from: classes3.dex */
public class FrescoOptUtil {
    public static final String OPT_ON_NEW_RESULT_MSG = "opt_on_new_result_msg";
    private static int mAvifParseLimit;
    private static boolean mBitmapPrepareToDrawForPrefetch;
    private static int mDecodeStreamLimit;
    private static boolean mDownsampleEnabled;
    private static int mHeifAnimDecodeOptType;
    private static boolean mIsOptOnNewResultMsg;
    private static boolean mOptFirstAvailableCache;
    private static boolean mUseBitmapPrepareToDraw;
    private static BizOptDecider sBizOptDecider;

    /* JADX INFO: loaded from: classes22.dex */
    public interface BizOptDecider {
        boolean isOptEnabled(String r100, Object r101);
    }

    /* JADX INFO: loaded from: classes22.dex */
    public @interface HeifAnimDecodeOpt {
        public static final int TYPE1 = 1;
        public static final int TYPE2 = 2;
    }

    public FrescoOptUtil() {
    }

    public static boolean isOptHeifAnimDecode() {
        if (mHeifAnimDecodeOptType <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getAvifParseLimit() {
        return mAvifParseLimit;
    }

    public static int getDecodeStreamLimit() {
        return mDecodeStreamLimit;
    }

    public static int getHeifAnimDecodeOptType() {
        return mHeifAnimDecodeOptType;
    }

    public static boolean isBitmapPrepareToDrawForPrefetch() {
        return mBitmapPrepareToDrawForPrefetch;
    }

    public static boolean isDownsampleEnabled() {
        return mDownsampleEnabled;
    }

    public static boolean isOptFirstAvailableCache() {
        return mOptFirstAvailableCache;
    }

    public static boolean isOptOnNewResultMsg() {
        return mIsOptOnNewResultMsg;
    }

    public static boolean isUseBitmapPrepareToDraw() {
        return mUseBitmapPrepareToDraw;
    }

    public static void setAvifParseLimit(int r100) {
        mAvifParseLimit = r100;
    }

    public static void setBitmapPrepareToDrawForPrefetch(boolean r100) {
        mBitmapPrepareToDrawForPrefetch = r100;
    }

    public static void setBizOptDecider(BizOptDecider r100) {
        sBizOptDecider = r100;
    }

    public static void setDecodeStreamLimit(int r100) {
        mDecodeStreamLimit = r100;
    }

    public static void setDownsampleEnabled(boolean r100) {
        mDownsampleEnabled = r100;
    }

    public static void setHeifAnimDecodeOptType(int r100) {
        mHeifAnimDecodeOptType = r100;
    }

    public static void setOptFirstAvailableCache(boolean r100) {
        mOptFirstAvailableCache = r100;
    }

    public static void setOptOnNewResultMsg(boolean r100) {
        mIsOptOnNewResultMsg = r100;
    }

    public static void setUseBitmapPrepareToDraw(boolean r100) {
        mUseBitmapPrepareToDraw = r100;
    }

    public static boolean isOptEnabledForBiz(String r100, Object r101) {
        BizOptDecider r102 = sBizOptDecider;
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.isOptEnabled(r100, r101) == false) goto L7;
        return true;
    }
}
