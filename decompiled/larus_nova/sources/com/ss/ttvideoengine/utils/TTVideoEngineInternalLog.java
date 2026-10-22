package com.ss.ttvideoengine.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes35.dex */
public class TTVideoEngineInternalLog {
    public static final String FORMAT = "<%s>%s";
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 6;
    public static final int LOG_INFO = 2;
    public static final int LOG_KILL = 4;
    public static final int LOG_TRACK = 3;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARN = 5;
    public static int LogNotifyLevel = 116;
    public static int LogTurnOn = 112;
    private static final String TAG = "TTVideoEngineLog";
    public static TTVideoEngineLogListener mListener;
    private static boolean sEnablePredicateLoglevelTurn;

    public TTVideoEngineInternalLog() {
    }

    public static boolean d() {
        return logLevelTurnOn(1);
    }

    public static boolean e() {
        return logLevelTurnOn(6);
    }

    public static boolean i() {
        return logLevelTurnOn(2);
    }

    public static boolean k() {
        return logLevelTurnOn(4);
    }

    public static boolean t() {
        return logLevelTurnOn(3);
    }

    public static boolean w() {
        return logLevelTurnOn(5);
    }

    public static void d(Throwable r100) {
        if (((LogTurnOn >> 1) & 1) != 1) goto L6;
        r100.printStackTrace();
        return;
    }

    public static void enablePredicateLoglevelTurn(boolean r100) {
        sEnablePredicateLoglevelTurn = r100;
    }

    public static boolean isPredicateLoglevelTurnOn(int r100) {
        if (sEnablePredicateLoglevelTurn == true) goto L5;
    L8:
        return true;
    L5:
        if (logLevelTurnOn(r100) == true) goto L8;
        return false;
    }

    private static boolean logLevelTurnOn(int r100) {
        if (((LogTurnOn >> r100) & 1) != 1) goto L5;
        return true;
    L5:
        if (((LogNotifyLevel >> r100) & 1) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public static void setListener(TTVideoEngineLogListener r100) {
        mListener = r100;
    }

    public static void _notifyListener(String r100, String r101) {
        if (mListener != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        TTVideoEngineLogListener r102 = mListener;
        if (TextUtils.isEmpty(r100) == true) goto L10;
        r101 = "TTVideoEngine: tag = " + r100 + ";  " + r101;
    L10:
        r102.consoleLog(r101);
        return;
    }

    public static void d(String r100, String r101) {
        if (((LogNotifyLevel >> 1) & 1) != 1) goto L6;
        _notifyListener(r100, r101);
    L6:
        if (((LogTurnOn >> 1) & 1) != 1) goto L9;
        String.format("<%s>%s", new Object[]{r100, r101});
        return;
    }

    public static void e(String r100, String r101) {
        if (((LogNotifyLevel >> 6) & 1) != 1) goto L6;
        _notifyListener(r100, r101);
    L6:
        if (((LogTurnOn >> 6) & 1) != 1) goto L9;
        String.format("<%s>%s", new Object[]{r100, r101});
        return;
    }

    public static void i(String r100, String r101) {
        if (((LogNotifyLevel >> 2) & 1) != 1) goto L6;
        _notifyListener(r100, r101);
    L6:
        if (((LogTurnOn >> 2) & 1) != 1) goto L9;
        String.format("<%s>%s", new Object[]{r100, r101});
        return;
    }

    public static void k(String r100, String r101) {
        if (((LogNotifyLevel >> 4) & 1) != 1) goto L6;
        _notifyListener(r100, r101);
    L6:
        if (((LogTurnOn >> 4) & 1) != 1) goto L9;
        String.format("<%s>%s", new Object[]{r100, r101});
        return;
    }

    public static void setLogNotifyLevel(int r100, int r101) {
        int r102 = (~(1 << r100)) & LogNotifyLevel;
        LogNotifyLevel = (r101 << r100) | r102;
    }

    public static void t(String r100, String r101) {
        if (((LogNotifyLevel >> 3) & 1) != 1) goto L6;
        _notifyListener(r100, r101);
    L6:
        if (((LogTurnOn >> 3) & 1) != 1) goto L9;
        String.format("<%s>%s", new Object[]{r100, r101});
        return;
    }

    public static void turnOn(int r100, int r101) {
        int r102 = ((~(1 << r100)) & LogTurnOn) | (r101 << r100);
        LogTurnOn = r102;
        if (r100 != 1) goto L7;
        if (r101 != 1) goto L8;
        LogTurnOn = (r102 & (-5)) | (r101 << 2);
        return;
    L8:
        return;
    }

    public static void w(String r100, String r101) {
        if (((LogNotifyLevel >> 5) & 1) != 1) goto L6;
        _notifyListener(r100, r101);
    L6:
        if (((LogTurnOn >> 5) & 1) != 1) goto L9;
        String.format("<%s>%s", new Object[]{r100, r101});
        return;
    }
}
