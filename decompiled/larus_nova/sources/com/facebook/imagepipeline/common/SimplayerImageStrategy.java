package com.facebook.imagepipeline.common;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public abstract class SimplayerImageStrategy {
    public static final int OPTION_OPEN_LOG = 1001;
    public static final int OPTION_SKIP_POST_PROCESSOR = 1000;
    public static final int OPTION_UPLOAD_LOG = 1002;
    public static final String PARAM_IMAGE_FORMAT = "imageFormat";
    public static final String PARAM_VIEW_HEIGHT = "viewHeight";
    public static final String PARAM_VIEW_WIDTH = "viewWidth";
    public static final int PRIORITY_HIGH = 3;
    public static final int PRIORITY_LOW = 1;
    public static final int PRIORITY_MEDIUM = 2;
    public static final String RESULT_BITMAP = "bitmap";
    public static final String RESULT_PRIORITY = "priority";
    public static final String RESULT_USE_SYSTEM_API_FIRST = "useSystemApiFirst";
    public static final int STRATEGY_DECODE_BITMAP = 1;
    public static final int STRATEGY_DECODE_USE_SYSTEM_API_FIRST = 2;
    public static final String TAG = "SimplayerImageStrategy";
    private static boolean mOpenLog;
    private static boolean mUploadLog;
    private static SimplayerImageStrategy sStrategy;

    public SimplayerImageStrategy() {
    }

    public abstract int getIntValue(int r100, String r101, int r102);

    public abstract JSONObject getResult(int r100, String r101, JSONObject r102);

    public static synchronized boolean isOpenLog() {
        monitor-enter(SimplayerImageStrategy.class);
        boolean r100 = mOpenLog;     // Catch: Throwable -> L7
        monitor-exit(SimplayerImageStrategy.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean isUploadLog() {
        monitor-enter(SimplayerImageStrategy.class);
        boolean r100 = mUploadLog;     // Catch: Throwable -> L7
        monitor-exit(SimplayerImageStrategy.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static SimplayerImageStrategy getStrategy() {
        return sStrategy;
    }

    public static synchronized void setOpenLog(boolean r100) {
        monitor-enter(SimplayerImageStrategy.class);
        mOpenLog = r100;     // Catch: Throwable -> L7
        monitor-exit(SimplayerImageStrategy.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setStrategy(SimplayerImageStrategy r100) {
        sStrategy = r100;
    }

    public static synchronized void setUploadLog(boolean r100) {
        monitor-enter(SimplayerImageStrategy.class);
        mUploadLog = r100;     // Catch: Throwable -> L7
        monitor-exit(SimplayerImageStrategy.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
