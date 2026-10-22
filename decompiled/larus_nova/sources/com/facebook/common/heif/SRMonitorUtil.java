package com.facebook.common.heif;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes22.dex */
public class SRMonitorUtil {
    private static String cacheDir;
    private static int mConcurrencyLimit;
    private static int maxHeight;
    private static int maxWidth;
    private static int optimizeLevel;
    private static int stageType;
    private static boolean useOpenGL;

    public SRMonitorUtil() {
    }

    public static String getCacheDir() {
        if (TextUtils.isEmpty(cacheDir) == false) goto L6;
        return "";
    L6:
        return cacheDir;
    }

    public static int getConcurrencyLimit() {
        return mConcurrencyLimit;
    }

    public static int getMaxHeight() {
        return maxHeight;
    }

    public static int getMaxWidth() {
        return maxWidth;
    }

    public static int getOptimizeLevel() {
        return optimizeLevel;
    }

    public static int getStageType() {
        return stageType;
    }

    public static boolean isUseOpenGL() {
        return useOpenGL;
    }

    public static void setCacheDir(String r100) {
        cacheDir = r100;
    }

    public static void setConcurrencyLimit(int r100) {
        mConcurrencyLimit = r100;
    }

    public static void setMaxHeight(int r100) {
        maxHeight = r100;
    }

    public static void setMaxWidth(int r100) {
        maxWidth = r100;
    }

    public static void setOptimizeLevel(int r100) {
        optimizeLevel = r100;
    }

    public static void setStageType(int r100) {
        stageType = r100;
    }

    public static void setUseOpenGL(boolean r100) {
        useOpenGL = r100;
    }
}
