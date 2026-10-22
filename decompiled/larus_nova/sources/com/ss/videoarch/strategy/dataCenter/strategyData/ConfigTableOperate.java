package com.ss.videoarch.strategy.dataCenter.strategyData;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.ss.videoarch.strategy.dataCenter.strategyData.model.ConfigCacheInfo;
import com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class ConfigTableOperate extends BaseTableOperate {
    public static String COMMON_CONFIG = null;
    public static String FEATURE_CONFIG = null;
    public static final String SQL_OF_SWITCH = null;
    public static String STRATEGY_CONFIG = null;
    public static final String SWITCH_NAME = "settings_name";
    public static final String SWITCH_VALUE = "settings_value";
    public static String TABLE_NAME_SWITCH = "settings_config";
    public static final String TAG = "ConfigTableOperate";
    public static Map<String, ConfigCacheInfo> mConfigTableCacheInfoMap;
    public static StrategySQLMonitorLog mConfigTableMonitor;

    static {
        SQL_OF_SWITCH = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_SWITCH + " (settings_name text not null ,settings_value text ,expand_value text ,update_time text ,create_time timestamp not null default (datetime('now','localtime')))";
        STRATEGY_CONFIG = "StrategyConfig";
        FEATURE_CONFIG = "FeatureConfig";
        COMMON_CONFIG = "CommonConfig";
        mConfigTableMonitor = new StrategySQLMonitorLog();
        mConfigTableCacheInfoMap = new ConcurrentHashMap();
    }

    public static void updateDBDataToCache() {
        long r100 = System.currentTimeMillis();
        Cursor r101 = BaseTableOperate.querySQL(TABLE_NAME_SWITCH, "select * from " + TABLE_NAME_SWITCH);
        ConfigCacheInfo r102 = new ConfigCacheInfo();     // Catch: Throwable -> L12 Exception -> L14
        long r103 = -1;
    L4:
        if (r101 == null) goto L8;
        if (r101.moveToNext() == false) goto L8;
        r102.mSettingsName = r101.getString(0);     // Catch: Throwable -> L12 Exception -> L14
        r102.mSettingsValue = r101.getString(1);     // Catch: Throwable -> L12 Exception -> L14
        r102.mExpandValue = r101.getString(2);     // Catch: Throwable -> L12 Exception -> L14
        r102.mUpdate = r101.getString(3);     // Catch: Throwable -> L12 Exception -> L14
        r102.mCreate = r101.getString(4);     // Catch: Throwable -> L12 Exception -> L14
        r102.toString();     // Catch: Throwable -> L12 Exception -> L14
        mConfigTableCacheInfoMap.put(r102.mSettingsName, r102);     // Catch: Throwable -> L12 Exception -> L14
        r103 = 1;
    L8:
        mConfigTableMonitor.updateMonitorLogInfo(TABLE_NAME_SWITCH, BaseStrategyMonitor.MONITOR_QUERY_OPERATE, "update_to_cache", r103, r100, "none");     // Catch: Throwable -> L12 Exception -> L14
        mConfigTableMonitor.uploadMonitorLog();     // Catch: Throwable -> L12 Exception -> L14
        if (r101 != null) goto L24;
        return;
    L24:
        r101.close();     // Catch: Exception -> L22
        return;
    L34:
        return;
    L12:
        th = move-exception;
        if (r101 != null) goto L28;
    L21:
        throw th;
    L28:
        r101.close();     // Catch: Exception -> L23
    L14:
        e = move-exception;
        e.getMessage();     // Catch: Throwable -> L12
        if (r101 != null) goto L24;
    }

    public ConfigTableOperate() {
    }

    public static long addSettingsConfigToDB(List<ConfigCacheInfo> r110) {
        long r100 = System.currentTimeMillis();
        if (r110 != null) goto L5;
        return -1;
    L5:
        if (r110.size() <= 0) goto L16;
        StringBuilder r101 = new StringBuilder();
        String[] r102 = {SWITCH_NAME};
        ArrayList r103 = new ArrayList();
        Iterator<ConfigCacheInfo> r111 = r110.iterator();
    L9:
        if (r111.hasNext() == false) goto L11;
        ConfigCacheInfo r104 = r111.next();
        ContentValues r105 = new ContentValues();
        r105.put(SWITCH_NAME, r104.mSettingsName);
        r105.put(SWITCH_VALUE, r104.mSettingsValue);
        r105.put(StrategySQLiteWrapper.TABLE_EXPAND, r104.mExpandValue);
        r105.put("update_time", BaseTableOperate.getCurrentTimeFormat());
        r101.append(r104.mSettingsName);
        r103.add(r105);
        goto L9
    L11:
        long r106 = BaseTableOperate.replaceAll(TABLE_NAME_SWITCH, r102, r103);
        mConfigTableMonitor.updateMonitorLogInfo(TABLE_NAME_SWITCH, BaseStrategyMonitor.MONITOR_UPDATE_OPERATE, r101.toString(), r106, r100, "none");
        mConfigTableMonitor.uploadMonitorLog();
        return r106;
    L16:
        return -1;
    }

    public static ConfigCacheInfo getSettingsConfigFromDB(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return null;
    L5:
        ConfigCacheInfo r111 = new ConfigCacheInfo();
        if (mConfigTableCacheInfoMap.containsKey(r110) == false) goto L8;
        r111 = mConfigTableCacheInfoMap.get(r110);
    L21:
        r111.toString();
        return r111;
    L8:
        long r100 = System.currentTimeMillis();
        Cursor r112 = BaseTableOperate.query(TABLE_NAME_SWITCH, new String[]{SWITCH_NAME, SWITCH_VALUE, StrategySQLiteWrapper.TABLE_EXPAND, "update_time", "create_time"}, "settings_name = ?", new String[]{r110}, null, null, null);
        if (r112 != null) goto L11;
        return null;
    L11:
        long r101 = -1;
    L30:
    L18:
        th = move-exception;
        r112.close();     // Catch: Exception -> L25
    L20:
        throw th;
    L13:
        if (r112.moveToNext() == false) goto L15;
        r111.mSettingsName = r112.getString(0);     // Catch: Exception -> L24 Throwable -> L18
        r111.mSettingsValue = r112.getString(1);     // Catch: Exception -> L24 Throwable -> L18
        r111.mExpandValue = r112.getString(2);     // Catch: Exception -> L24 Throwable -> L18
        r111.mUpdate = r112.getString(3);     // Catch: Exception -> L24 Throwable -> L18
        r111.mCreate = r112.getString(4);     // Catch: Exception -> L24 Throwable -> L18
        mConfigTableCacheInfoMap.put(r110, r111);     // Catch: Exception -> L24 Throwable -> L18
        r101 = 1;
        goto L30
    L15:
        mConfigTableMonitor.updateMonitorLogInfo(TABLE_NAME_SWITCH, BaseStrategyMonitor.MONITOR_QUERY_OPERATE, r110, r101, r100, "none");     // Catch: Exception -> L24 Throwable -> L18
        mConfigTableMonitor.uploadMonitorLog();     // Catch: Exception -> L24 Throwable -> L18
    L26:
        r112.close();     // Catch: Exception -> L23
        goto L21
    }

    public static JSONObject getConfigResultFromSettingsValue(String r100, String r101) {
        JSONObject r102 = null;
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        ConfigCacheInfo r103 = getSettingsConfigFromDB(r100);
        new JSONObject();
        if (r103 != null) goto L8;
    L15:
        Objects.toString(r102);
        return r102;
    L8:
        if (TextUtils.isEmpty(r103.mSettingsValue) == true) goto L15;
        JSONObject r104 = new JSONObject(r103.mSettingsValue);     // Catch: JSONException -> L13
        if (r104.has(r101) == false) goto L15;
        r102 = r104.optJSONObject(r101);     // Catch: JSONException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }
}
