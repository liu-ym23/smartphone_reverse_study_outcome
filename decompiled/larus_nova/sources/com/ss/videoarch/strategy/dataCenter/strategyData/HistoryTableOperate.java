package com.ss.videoarch.strategy.dataCenter.strategyData;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.ss.videoarch.strategy.IAppInfoBundle;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.dataCenter.strategyData.model.SessionCacheInfos;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public class HistoryTableOperate extends BaseTableOperate {
    public static final String HISTORY_DOMAIN = "domain";
    public static final String HISTORY_NETWORK = "first_frame_network";
    public static final String HISTORY_PLAY_TIME = "play_time";
    public static final String HISTORY_SESSION_ID = "session_id";
    public static final String HISTORY_SPEED = "first_frame_download_speed";
    public static final String SQL_OF_HISTORY = null;
    public static String TABLE_NAME_HISTORY = "history_info";
    public static final String TABLE_NAME_HISTORY_TRIGGER = null;
    public static Map<String, IAppInfoBundle> mAppInfoBundleMap;
    private static Context mContext;
    public static StrategySQLMonitorLog mHisTableMonitor;
    private static String mPreferenceName;
    private static long mSPKey;
    public static Map<String, SessionCacheInfos> mSessionCacheInfosMap;
    private static SharedPreferences mSharedPreferences;

    static {
        SQL_OF_HISTORY = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_HISTORY + " (session_id text not null ,domain text ,play_time integer ,first_frame_download_speed integer ,first_frame_network text ,expand_value text,update_time text ,create_time timestamp not null default (datetime('now','localtime')))";
        TABLE_NAME_HISTORY_TRIGGER = "CREATE TRIGGER delete_till INSERT ON " + TABLE_NAME_HISTORY + " WHEN (select count(*) from " + TABLE_NAME_HISTORY + ") > " + LSSettings.inst().mPersistenceConfigInfo.mHisTableRecordLimit + " BEGIN  DELETE FROM " + TABLE_NAME_HISTORY + " WHERE update_time IN (SELECT update_time FROM " + TABLE_NAME_HISTORY + " ORDER BY update_time limit (select count(*) -30 from " + TABLE_NAME_HISTORY + ")) ; END ";
        mAppInfoBundleMap = new ConcurrentHashMap();
        mSessionCacheInfosMap = new ConcurrentHashMap();
        mPreferenceName = "live_stream_strategy_hisinfo";
        mSPKey = 0;
        mHisTableMonitor = new StrategySQLMonitorLog();
    }

    public static int clearCacheData() {
        mSessionCacheInfosMap.clear();
        Context r100 = mContext;
        if (r100 != null) goto L6;
        return -1;
    L6:
        if (mSharedPreferences != null) goto L8;
        mSharedPreferences = r100.getSharedPreferences(mPreferenceName, 0);
    L8:
        SharedPreferences r101 = mSharedPreferences;
        if (r101 != null) goto L14;
    L13:
        return 0;
    L14:
        SharedPreferences.Editor r102 = r101.edit();     // Catch: Exception -> L12
        r102.clear();     // Catch: Exception -> L12
        r102.commit();     // Catch: Exception -> L12
        mSPKey = 0;     // Catch: Exception -> L12
    L12:
        return -1;
    }

    public static List<SessionCacheInfos> getSPData() {
        ArrayList r100 = new ArrayList();
        Context r101 = mContext;
        if (r101 != null) goto L6;
        return r100;
    L6:
        if (mSharedPreferences != null) goto L8;
        mSharedPreferences = r101.getSharedPreferences(mPreferenceName, 0);
    L8:
        SharedPreferences r102 = mSharedPreferences;
        if (r102 == null) goto L27;
        Iterator<Map.Entry<String, ?>> r103 = r102.getAll().entrySet().iterator();
    L12:
        if (r103.hasNext() == false) goto L27;
        String r104 = (String) r103.next().getValue();
        if (TextUtils.isEmpty(r104) == true) goto L12;
        ByteArrayInputStream r105 = new ByteArrayInputStream(Base64.decode(r104.getBytes(), 0));
        new SessionCacheInfos();
        SessionCacheInfos r106 = (SessionCacheInfos) new ObjectInputStream(r105).readObject();     // Catch: Exception -> L21 ClassNotFoundException -> L23 IOException -> L25
        if (r106 == null) goto L12;
        r100.add(r106);     // Catch: Exception -> L21 ClassNotFoundException -> L23 IOException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L23:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = move-exception;
        e.printStackTrace();
    L27:
        return r100;
    }

    public HistoryTableOperate() {
    }

    public static int addSPData(SessionCacheInfos r100) {
        if (r100 == null) goto L19;
        Context r101 = mContext;
        if (r101 == null) goto L19;
        if (mSharedPreferences != null) goto L10;
        mSharedPreferences = r101.getSharedPreferences(mPreferenceName, 0);
    L10:
        SharedPreferences r102 = mSharedPreferences;
        if (r102 == null) goto L18;
        SharedPreferences.Editor r103 = r102.edit();
        ByteArrayOutputStream r104 = new ByteArrayOutputStream();
        new ObjectOutputStream(r104).writeObject(r100);     // Catch: IOException -> L15
        r103.putString(String.valueOf(mSPKey), new String(Base64.encode(r104.toByteArray(), 0)));     // Catch: IOException -> L15
        r103.commit();     // Catch: IOException -> L15
        mSPKey++;     // Catch: IOException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L18:
        return 0;
    L19:
        return -1;
    }

    public static SessionCacheInfos getRecord(String r100) {
        Cursor r101 = BaseTableOperate.query(TABLE_NAME_HISTORY, new String[]{"domain", HISTORY_PLAY_TIME, HISTORY_SPEED, HISTORY_NETWORK}, "session_id= ? ", new String[]{r100}, null, null, null);
        if (r101 != null) goto L17;
        return null;
    L17:
        if (r101.moveToFirst() == false) goto L19;
        SessionCacheInfos r102 = new SessionCacheInfos();     // Catch: Throwable -> L13
        r102.mSessionId = r100;     // Catch: Throwable -> L13
        r102.mDomain = r101.getString(0);     // Catch: Throwable -> L13
        r102.mPlayTime = r101.getLong(1);     // Catch: Throwable -> L13
        r102.mDownloadSpeed = r101.getLong(2);     // Catch: Throwable -> L13
        r102.mNetwork = r101.getString(3);     // Catch: Throwable -> L13
        r101.close();     // Catch: Exception -> L12
    L9:
        return r102;
    L19:
        r101.close();     // Catch: Exception -> L14
    L11:
        return null;
    }

    public static long insertRecord(SessionCacheInfos r100) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        ContentValues r101 = new ContentValues();
        r101.put("session_id", r100.mSessionId);
        r101.put("domain", r100.mDomain);
        r101.put(HISTORY_PLAY_TIME, Long.valueOf(r100.mPlayTime));
        r101.put(HISTORY_SPEED, Long.valueOf(r100.mDownloadSpeed));
        r101.put(HISTORY_NETWORK, r100.mNetwork);
        r101.put("update_time", r100.mUpdate);
        return BaseTableOperate.insert(TABLE_NAME_HISTORY, r101);
    }

    public static long replaceAllRecord(List<SessionCacheInfos> r100) {
        if (r100 != null) goto L4;
        return -1;
    L4:
        if (r100.size() <= 0) goto L15;
        String[] r101 = {"session_id"};
        ArrayList r102 = new ArrayList();
        Iterator<SessionCacheInfos> r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L11;
        SessionCacheInfos r104 = r103.next();
        ContentValues r105 = new ContentValues();
        r105.put("domain", r104.mDomain);
        r105.put("session_id", r104.mSessionId);
        r105.put(HISTORY_NETWORK, r104.mNetwork);
        r105.put(HISTORY_SPEED, Long.valueOf(r104.mDownloadSpeed));
        r105.put(HISTORY_PLAY_TIME, Long.valueOf(r104.mPlayTime));
        r105.put("update_time", r104.mUpdate);
        r102.add(r105);
        goto L8
    L11:
        return BaseTableOperate.replaceAll(TABLE_NAME_HISTORY, r101, r102);
    L15:
        return -1;
    }

    public static void setContext(Context r100) {
        mContext = r100;
    }

    public static long updateRecord(SessionCacheInfos r100) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        ContentValues r101 = new ContentValues();
        r101.put("session_id", r100.mSessionId);
        r101.put("domain", r100.mDomain);
        r101.put(HISTORY_PLAY_TIME, Long.valueOf(r100.mPlayTime));
        r101.put(HISTORY_SPEED, Long.valueOf(r100.mDownloadSpeed));
        r101.put(HISTORY_NETWORK, r100.mNetwork);
        r101.put("update_time", r100.mUpdate);
        return BaseTableOperate.update(TABLE_NAME_HISTORY, r101, "session_id = ? ", new String[]{r100.mSessionId});
    }
}
