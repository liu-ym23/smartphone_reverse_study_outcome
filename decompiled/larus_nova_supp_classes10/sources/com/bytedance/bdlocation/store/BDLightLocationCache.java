package com.bytedance.bdlocation.store;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.BaseStation;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.scan.wifi.WifiInfoModule;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class BDLightLocationCache {
    private static final String KEY_LAST_LOCATION_TIME = "last_location_time";
    private static final String SHARED_NAME = "BDLightLocationCache";
    private static final Object lightCacheLock = null;
    private static SharedPreferences mSharedPreferences;
    private static volatile BaseStation sColdBootBaseStation;
    private static volatile String sCurrentStation;
    private static volatile boolean sGetCellCache;
    private static volatile JSONObject sGetLightLocationMonitorData;
    private static volatile boolean sGetWifiCacheList;
    private static volatile int sHasLocationPermission;
    private static volatile boolean sIsCellDowngrade;
    private static volatile boolean sIsEndRequestCellInfo;
    private static volatile boolean sIsEndRequestWifiInfo;
    private static volatile boolean sIsStartRequestCellInfo;
    private static volatile boolean sIsStartRequestWifiInfo;
    private static volatile boolean sIsWifiDowngrade;
    private static volatile long sLastLocationTime;
    private static volatile long sLightLocationCacheInterval;
    private static volatile JSONObject sRequestCellUpdateMonitorData;
    private static volatile JSONObject sRequestWifiUpdateMonitorData;
    private static volatile String sWifiCacheList;
    private static volatile WifiInfoModule sWifiInfoModule;

    public BDLightLocationCache() {
    }

    static {
        sHasLocationPermission = PermissionManager.LOCATION_PERMISSION_UNKNOWN;
        sLightLocationCacheInterval = 0;
        lightCacheLock = new Object();
        sLastLocationTime = -1;
    }

    public static JSONObject getAndClearLightLocationMonitorData() {
        if (sGetLightLocationMonitorData != null) goto L5;
        return null;
    L5:
        JSONObject r0 = sGetLightLocationMonitorData;
        sGetLightLocationMonitorData = null;
        return r0;
    }

    public static JSONObject getAndClearRequestCellUpdateMonitorData() {
        if (sRequestCellUpdateMonitorData != null) goto L5;
        return null;
    L5:
        JSONObject r0 = sRequestCellUpdateMonitorData;
        sRequestCellUpdateMonitorData = null;
        return r0;
    }

    public static JSONObject getAndClearRequestWifiCacheUpdateMonitorData() {
        if (sRequestWifiUpdateMonitorData != null) goto L5;
        return null;
    L5:
        JSONObject r0 = sRequestWifiUpdateMonitorData;
        sRequestWifiUpdateMonitorData = null;
        return r0;
    }

    public static boolean lightLocationNeedCheckCache() {
        if (sLightLocationCacheInterval <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static BaseStation getColdBootBaseStation() {
        return sColdBootBaseStation;
    }

    public static String getCurrentStation() {
        return sCurrentStation;
    }

    public static long getLightLocationCacheInterval() {
        return sLightLocationCacheInterval;
    }

    public static String getWifiCacheList() {
        return sWifiCacheList;
    }

    public static WifiInfoModule getWifiCacheModule() {
        return sWifiInfoModule;
    }

    public static int hasLocationPermission() {
        return sHasLocationPermission;
    }

    public static boolean isCellDowngrade() {
        return sIsCellDowngrade;
    }

    public static boolean isEndRequestCellInfo() {
        return sIsEndRequestCellInfo;
    }

    public static boolean isEndRequestWifiInfo() {
        return sIsEndRequestWifiInfo;
    }

    public static boolean isGetCellCache() {
        return sGetCellCache;
    }

    public static boolean isGetWifiCacheList() {
        return sGetWifiCacheList;
    }

    public static boolean isStartRequestCellInfo() {
        return sIsStartRequestCellInfo;
    }

    public static boolean isStartRequestWifiInfo() {
        return sIsStartRequestWifiInfo;
    }

    public static boolean isWifiDowngrade() {
        return sIsWifiDowngrade;
    }

    public static long getLastLocationTime(Context r5) {
        if (sLastLocationTime != (-1)) goto L5;
        Object r0 = lightCacheLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L9:
        if (mSharedPreferences != null) goto L12;
        if (r5 == null) goto L12;
        mSharedPreferences = r5.getSharedPreferences(SHARED_NAME, 0);     // Catch: Throwable -> L19
    L12:
        SharedPreferences r6 = mSharedPreferences;     // Catch: Throwable -> L19
        if (r6 == null) goto L17;
        sLastLocationTime = r6.getLong(KEY_LAST_LOCATION_TIME, 0);     // Catch: Throwable -> L19
        long r1 = sLastLocationTime;     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return r1;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return 0;
    L5:
        return sLastLocationTime;
    }

    public static void setColdBootBaseStation(BaseStation r0) {
        sColdBootBaseStation = r0;
    }

    public static void setCurrentStation(String r0) {
        sCurrentStation = r0;
    }

    public static void setEndRequestCellInfo(boolean r0) {
        sIsEndRequestCellInfo = r0;
    }

    public static void setEndRequestWifiInfo(boolean r0) {
        sIsEndRequestWifiInfo = r0;
    }

    public static void setHasLocationPermission(int r0) {
        sHasLocationPermission = r0;
    }

    public static void setIsCellDowngrade(boolean r0) {
        sIsCellDowngrade = r0;
    }

    public static void setIsGetCellCache(boolean r0) {
        sGetCellCache = r0;
    }

    public static void setIsGetWifiCacheList(boolean r0) {
        sGetWifiCacheList = r0;
    }

    public static void setIsWifiDowngrade(boolean r0) {
        sIsWifiDowngrade = r0;
    }

    public static void setLightLocationCacheInterval(long r0) {
        sLightLocationCacheInterval = r0;
    }

    public static void setLightLocationMonitorData(JSONObject r0) {
        sGetLightLocationMonitorData = r0;
    }

    public static void setRequestCellUpdateMonitorData(JSONObject r0) {
        sRequestCellUpdateMonitorData = r0;
    }

    public static void setRequestWifiCacheUpdateMonitorData(JSONObject r0) {
        sRequestWifiUpdateMonitorData = r0;
    }

    public static void setStartRequestCellInfo(boolean r0) {
        sIsStartRequestCellInfo = r0;
    }

    public static void setStartRequestWifiInfo(boolean r0) {
        sIsStartRequestWifiInfo = r0;
    }

    public static void setWifiCacheList(String r0) {
        sWifiCacheList = r0;
    }

    public static void setWifiCacheModule(WifiInfoModule r0) {
        sWifiInfoModule = r0;
    }

    public static void setLastLocationTime(Context r6, long r7) {
        Object r1 = lightCacheLock;
        monitor-enter(r1);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (mSharedPreferences != null) goto L9;
        if (r6 == null) goto L9;
        mSharedPreferences = r6.getSharedPreferences(SHARED_NAME, 0);     // Catch: Throwable -> L16
    L9:
        if (mSharedPreferences != null) goto L11;
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L16
        return;
    L11:
        if (sLastLocationTime != (-1)) goto L13;
        sLastLocationTime = mSharedPreferences.getLong(KEY_LAST_LOCATION_TIME, 0);     // Catch: Throwable -> L16
    L13:
        mSharedPreferences.edit().putLong(KEY_LAST_LOCATION_TIME, r7).apply();     // Catch: Throwable -> L16
        Logger.i("setLastLocationTime for light location: " + r7);     // Catch: Throwable -> L16
        goto L14
    }
}
