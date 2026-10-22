package com.ss.videoarch.strategy.strategy.smartStrategy;

import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.dataCenter.config.model.StrategyConfigInfo;
import com.ss.videoarch.strategy.dataCenter.strategyData.BaseTableOperate;
import com.ss.videoarch.strategy.dataCenter.strategyData.HistoryTableOperate;
import com.ss.videoarch.strategy.dataCenter.strategyData.StrategySQLMonitorLog;
import com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor;
import com.ss.videoarch.strategy.utils.JNINamespace;
import com.ss.videoarch.strategy.utils.VeLSUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@JNINamespace("jni")
public class TopNHostStrategy extends BaseSmartStrategy {
    private static final String TAG = "TopNHostStrategy";
    private static volatile TopNHostStrategy sInstance;
    private String mCurOptName;
    private long mCurOptStartTime;
    private Map<String, Integer> mDBHostCacheInfos;
    public int mEnable;
    private boolean mHasClear;
    public String mParams;
    public int mTopnCount;
    public StrategySQLMonitorLog mTopnStrategyMonitor;

    private native void nativeAddDomainUsedCount(String r100, int r101);

    private native void nativeClearRecords();

    private native String nativeRunStrategy();

    public static TopNHostStrategy inst() {
        if (sInstance != null) goto L15;
        monitor-enter(TopNHostStrategy.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TopNHostStrategy();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TopNHostStrategy.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private TopNHostStrategy() {
        this.mDBHostCacheInfos = new ConcurrentHashMap();
        this.mCurOptStartTime = 0;
        this.mCurOptName = "";
        this.mHasClear = false;
        this.mEnable = -1;
        this.mTopnCount = 0;
        this.mParams = "";
        this.mStrategyName = "live_stream_strategy_topn_host";
        StrategyConfigInfo r100 = this.mStrategyConfigInfo;
        if (r100 == null) goto L5;
        r100.mStrategyName = "live_stream_strategy_topn_host";
    L5:
        this.mProjectKey = "2";
        this.mTopnStrategyMonitor = new StrategySQLMonitorLog();
    }

    private JSONObject _runStrategy() {
        return super.runStrategy();
    }

    public void clearMDBHostCacheInfos() {
        if (LSSettings.inst().mEnableMgrTopN == 1) goto L5;
        this.mDBHostCacheInfos.clear();
        this.mHasClear = true;
        return;
    L5:
        if (VeLSUtils.isLoadSoSuccess() == false) goto L9;
        nativeClearRecords();
        return;
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runStrategy() {
        if (LSSettings.inst().mEnableMgrTopN != 1) goto L14;
        JSONObject r100 = null;
        if (VeLSUtils.isLoadSoSuccess() == false) goto L15;
        String r101 = nativeRunStrategy();
        if (TextUtils.isEmpty(r101) == true) goto L15;
        if (Objects.equals(r101, "none") == true) goto L15;
        r100 = new JSONObject(r101);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L15:
        Objects.toString(r100);
        return r100;
    L14:
        r100 = _runStrategy();
        goto L15
    }

    private JSONObject _runLocalStrategy(JSONObject r110) {
        StrategyConfigInfo r111 = this.mStrategyConfigInfo;
        if (r111 != null) goto L6;
        return null;
    L6:
        JSONObject r112 = r111.mInputSettingsParam;
        int r100 = 0;
        if (r112 != null) goto L9;
    L11:
        this.mCurOptStartTime = System.currentTimeMillis();
        JSONObject r113 = new JSONObject();
        JSONArray r101 = new JSONArray();
        JSONArray r102 = new JSONArray();
        Map<String, Integer> r103 = this.mDBHostCacheInfos;
        if (r103 != null) goto L14;
    L23:
        String r114 = "select domain, count(*) as counts from " + HistoryTableOperate.TABLE_NAME_HISTORY + " group by domain order by counts desc limit 0," + this.mTopnCount;
        Cursor r104 = BaseTableOperate.querySQL(HistoryTableOperate.TABLE_NAME_HISTORY, r114);
        int r105 = -1;
    L24:
        if (r104 == null) goto L36;
    L44:
        if (r104 != null) goto L57;
    L46:
        HistoryTableOperate.mHisTableMonitor.updateMonitorLogInfo(HistoryTableOperate.TABLE_NAME_HISTORY, BaseStrategyMonitor.MONITOR_QUERY_OPERATE, this.mStrategyName, r105, this.mCurOptStartTime, r114);
        HistoryTableOperate.mHisTableMonitor.uploadMonitorLog();
    L48:
        if (r101.length() > 0) goto L61;
    L53:
        r113.toString();
        return r113;
    L61:
        r113.put("host_name", r101);     // Catch: JSONException -> L51
        r113.put("host_count", r102);     // Catch: JSONException -> L51
    L51:
        e = move-exception;
        e.printStackTrace();
    L57:
        r104.close();     // Catch: Exception -> L55
    L40:
        th = move-exception;
        if (r104 != null) goto L59;
    L43:
        throw th;
    L59:
        r104.close();     // Catch: Exception -> L56
        goto L43
    L26:
        if (r104.moveToNext() == false) goto L36;
        if (r105 != (-1)) goto L29;
        r105 = 0;
    L29:
        String r106 = r104.getString(0);     // Catch: Throwable -> L40 Exception -> L44
        int r107 = r104.getInt(1);     // Catch: Throwable -> L40 Exception -> L44
        if (TextUtils.isEmpty(r106) == true) goto L24;
        r101.put(r106);     // Catch: Throwable -> L40 Exception -> L44
        if (this.mDBHostCacheInfos.containsKey(r106) == false) goto L35;
        r107 = r107 + this.mDBHostCacheInfos.get(r106).intValue();     // Catch: Throwable -> L40 Exception -> L44
    L35:
        r102.put(r107);     // Catch: Throwable -> L40 Exception -> L44
        this.mDBHostCacheInfos.put(r106, Integer.valueOf(r107));     // Catch: Throwable -> L40 Exception -> L44
    L36:
        this.mHasClear = false;     // Catch: Throwable -> L40 Exception -> L44
        if (r104 == null) goto L46;
    L14:
        if (r103.size() <= 0) goto L23;
        if (this.mHasClear == true) goto L23;
        LinkedList r108 = new LinkedList(this.mDBHostCacheInfos.entrySet());
        Collections.sort(r108, new AnonymousClass1(this));
        int r109 = Math.min(this.mTopnCount, r108.size());
    L18:
        if (r100 >= r109) goto L48;
        String r115 = (String) ((Map.Entry) ListProtector.get(r108, r100)).getKey();
        if (TextUtils.isEmpty(r115) == true) goto L22;
        r101.put(r115);
        r102.put(((Map.Entry) ListProtector.get(r108, r100)).getValue());
    L22:
        r100 = r100 + 1;
        goto L18
    L9:
        if (r112.has("topn_count") == false) goto L11;
        this.mTopnCount = this.mStrategyConfigInfo.mInputSettingsParam.optInt("topn_count", 0);
        goto L11
    }

    private JSONObject _runSmartStrategy(JSONObject r100) {
        return super.runSmartStrategy(r100);
    }

    public Set<String> parseDomainResult(JSONObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        HashSet r101 = new HashSet();
        if (r100.has("host_name") == false) goto L13;
        JSONArray r102 = r100.optJSONArray("host_name");
        if (r102 == null) goto L13;
        int r103 = 0;
    L11:
        if (r103 >= r102.length()) goto L13;
        r101.add(r102.optString(r103));
        r103 = r103 + 1;
    L13:
        return r101;
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject r100) {
        if (LSSettings.inst().mEnableMgrTopN != 1) goto L5;
        JSONObject r101 = null;
    L6:
        Objects.toString(r101);
        return r101;
    L5:
        r101 = _runLocalStrategy(r100);
        goto L6
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runSmartStrategy(JSONObject r100) {
        if (LSSettings.inst().mEnableMgrTopN != 1) goto L6;
        return null;
    L6:
        return _runSmartStrategy(r100);
    }

    public void addDomainUsedCount(String r100, int r101) {
        if (LSSettings.inst().mEnableMgrTopN != 1) goto L8;
        if (VeLSUtils.isLoadSoSuccess() == false) goto L14;
        nativeAddDomainUsedCount(r100, r101);
        return;
    L14:
        return;
    L8:
        if (this.mDBHostCacheInfos.containsKey(r100) == false) goto L12;
        Integer r102 = this.mDBHostCacheInfos.get(r100);
        if (r102 == null) goto L12;
        r101 = r101 + r102.intValue();
    L12:
        this.mDBHostCacheInfos.put(r100, Integer.valueOf(r101));
    }
}
