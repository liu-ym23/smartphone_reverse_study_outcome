package com.ss.ttvideoengine.utils;

import com.bytedance.vcloud.abrmodule.ABRConfig;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConfig;
import com.ss.ttvideoengine.setting.SettingsHelper;

/* JADX INFO: loaded from: classes35.dex */
public class TTVideoEngineLog {
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 6;
    public static final int LOG_INFO = 2;
    public static final int LOG_KILL = 4;
    public static final int LOG_TRACK = 3;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARN = 5;
    private static final String TAG = "TTVideoEngineLog";

    public TTVideoEngineLog() {
    }

    public static boolean d() {
        return TTVideoEngineInternalLog.d();
    }

    public static boolean e() {
        return TTVideoEngineInternalLog.e();
    }

    public static boolean i() {
        return TTVideoEngineInternalLog.i();
    }

    public static boolean k() {
        return TTVideoEngineInternalLog.k();
    }

    public static boolean t() {
        return TTVideoEngineInternalLog.t();
    }

    public static boolean w() {
        return TTVideoEngineInternalLog.w();
    }

    public static int getLogNotifyLevel() {
        return TTVideoEngineInternalLog.LogNotifyLevel;
    }

    public static int getLogTurnOn() {
        return TTVideoEngineInternalLog.LogTurnOn;
    }

    public static void d(Throwable r100) {
        TTVideoEngineInternalLog.d(r100);
    }

    public static void enablePredicateLoglevelTurn(boolean r100) {
        TTVideoEngineInternalLog.enablePredicateLoglevelTurn(r100);
    }

    public static boolean isPredicateLoglevelTurnOn(int r100) {
        return TTVideoEngineInternalLog.isPredicateLoglevelTurnOn(r100);
    }

    public static void setListener(TTVideoEngineLogListener r100) {
        TTVideoEngineInternalLog.setListener(r100);
    }

    private static void _notifyListener(String r100, String r101) {
        TTVideoEngineInternalLog._notifyListener(r100, r101);
    }

    public static void d(String r100, String r101) {
        TTVideoEngineInternalLog.d(r100, r101);
    }

    public static void e(String r100, String r101) {
        TTVideoEngineInternalLog.e(r100, r101);
    }

    public static void i(String r100, String r101) {
        TTVideoEngineInternalLog.i(r100, r101);
    }

    public static void k(String r100, String r101) {
        TTVideoEngineInternalLog.k(r100, r101);
    }

    public static void setLogNotifyLevel(int r100, int r101) {
        TTVideoEngineInternalLog.setLogNotifyLevel(r100, r101);
    }

    public static void t(String r100, String r101) {
        TTVideoEngineInternalLog.t(r100, r101);
    }

    public static void turnOn(int r100, int r101) {
        TTVideoEngineInternalLog.turnOn(r100, r101);
        if (r100 != 1) goto L6;
        if (r101 != 1) goto L6;
        ABRConfig.setLoglevel(1);
        GearStrategyConfig r102 = GearStrategy.getGlobalConfig();
        r102.setIntValue(33, 1);
        GearStrategy.setGlobalConfig(r102);
        SettingsHelper.helper().setDebug(true);
    L7:
        if (r101 <= 0) goto L9;
        DataLoaderHelper.getDataLoader().setPreloadLogLevel(r100);
        return;
    L9:
        DataLoaderHelper.getDataLoader().setPreloadLogLevel(6);
        return;
    L6:
        SettingsHelper.helper().setDebug(false);
        goto L7
    }

    public static void w(String r100, String r101) {
        TTVideoEngineInternalLog.w(r100, r101);
    }
}
