package com.ss.videoarch.strategy.strategy.liveio;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.bytedance.android.ec.slice.SliceInitService;
import com.ss.ttvideoengine.net.DNSParser;
import com.ss.videoarch.strategy.IFunctionCalledByStrategyEngine;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class LiveIOEngine {
    static final String TAG = "LiveIOEngine";
    private static final long TTL_MIN_THRES = 300000;
    private final String QUIC;
    private IFunctionCalledByStrategyEngine mEngine;
    private List<String> mPreconnDomainList;
    private int mPreconnMapCapacity;
    private Map<String, JSONObject> mPreconnParamsMap;
    private Map<String, Integer> mPreconnProtoInfoMap;
    private Map<String, PreconnInfo> mPreconnResultsMap;
    private long mTTL;

    public class PreconnInfo {
        private JSONObject preConnResults;
        private long preconnUpdateTime;
        final /* synthetic */ LiveIOEngine this$0;

        public JSONObject getPreConnResults() {
            return this.preConnResults;
        }

        public long getPreconnUpdateTime() {
            return this.preconnUpdateTime;
        }

        public PreconnInfo(LiveIOEngine r100, JSONObject r101, long r102) {
            this.this$0 = r100;
            this.preConnResults = r101;
            this.preconnUpdateTime = r102;
        }
    }

    public void resetPreconnResults() {
        Map<String, PreconnInfo> r100 = this.mPreconnResultsMap;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L9;
        this.mPreconnResultsMap.clear();
        return;
    }

    public void updatePreconnResultMap() {
        Map<String, PreconnInfo> r100 = this.mPreconnResultsMap;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L27;
        Iterator<Map.Entry<String, PreconnInfo>> r101 = this.mPreconnResultsMap.entrySet().iterator();
    L9:
        if (r101.hasNext() == false) goto L28;
        PreconnInfo r102 = r101.next().getValue();
        if (r102 == null) goto L9;
        long r103 = r102.getPreconnUpdateTime();
        if (r103 <= 0) goto L9;
        if ((System.currentTimeMillis() - r103) <= this.mTTL) goto L9;
        r101.remove();
        goto L9
    L28:
        return;
    }

    public LiveIOEngine(IFunctionCalledByStrategyEngine r100) {
        this.mPreconnDomainList = new ArrayList();
        this.mEngine = null;
        this.mPreconnProtoInfoMap = new ArrayMap();
        this.mPreconnParamsMap = new ArrayMap();
        this.QUIC = "quic";
        this.mTTL = 300000;
        this.mPreconnMapCapacity = 50;
        if (r100 == null) goto L6;
        this.mEngine = r100;
        return;
    }

    public JSONObject getPreconnResults(String r100) {
        Map<String, PreconnInfo> r101 = this.mPreconnResultsMap;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return null;
    L7:
        if (this.mPreconnResultsMap.containsKey(r100) == false) goto L16;
        PreconnInfo r102 = this.mPreconnResultsMap.get(r100);
        if (r102 != null) goto L12;
        return null;
    L12:
        return r102.getPreConnResults();
    L16:
        return null;
    }

    public void notifyCharacterChange(String r100) {
        IFunctionCalledByStrategyEngine r101 = this.mEngine;
        if (r101 == null) goto L6;
        r101.callFunctionByKey(2, r100);
        return;
    }

    public void savePreconnResult(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L20;
        return;
    L20:
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L17
        String r102 = "";
        if (r101.has(DNSParser.DNS_RESULT_IP) == false) goto L10;
        r102 = r101.optString(DNSParser.DNS_RESULT_IP);     // Catch: JSONException -> L17
        if (TextUtils.isEmpty(r102) == false) goto L10;
        return;
    L10:
        Map<String, PreconnInfo> r103 = this.mPreconnResultsMap;     // Catch: JSONException -> L17
        if (r103 == null) goto L22;
        r103.size();     // Catch: JSONException -> L17
        if (this.mPreconnResultsMap.size() < this.mPreconnMapCapacity) goto L15;
        updatePreconnResultMap();     // Catch: JSONException -> L17
    L15:
        PreconnInfo r104 = new PreconnInfo(this, r101, System.currentTimeMillis());     // Catch: JSONException -> L17
        this.mPreconnResultsMap.put(r102, r104);     // Catch: JSONException -> L17
        return;
    L22:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    public void setIFunctionCalledByStrategyEngine(IFunctionCalledByStrategyEngine r100) {
        if (r100 == null) goto L5;
        this.mEngine = r100;
        return;
    }

    public void setLiveIOPreconnConfig(String r100) {
        String r101 = (String) LSSettings.inst().getAppInfoForKey("live_stream_strategy_preconnect_protocol", SliceInitService.DEFAULT_SWITCH);
        this.mPreconnDomainList = (List) LSSettings.inst().getAppInfoForKey("live_stream_strategy_preconnect_domains", new ArrayList());
        String r102 = (String) LSSettings.inst().getAppInfoForKey("live_stream_strategy_peconnect_params", SliceInitService.DEFAULT_SWITCH);
        this.mTTL = ((Long) LSSettings.inst().getAppInfoForKey("live_stream_strategy_peconnect_result_ttl", 300000L)).longValue();
        this.mPreconnMapCapacity = ((Integer) LSSettings.inst().getAppInfoForKey("live_stream_strategy_peconnect_result_capacity", 50)).intValue();
        this.mPreconnResultsMap = new ArrayMap(this.mPreconnMapCapacity);
        Objects.toString(this.mPreconnDomainList);
        if (r101 == null) goto L30;
        JSONObject r103 = new JSONObject(r101);     // Catch: JSONException -> L18
        Iterator<String> r104 = r103.keys();     // Catch: JSONException -> L18
    L5:
        if (r104.hasNext() == false) goto L31;
        String r105 = r104.next();     // Catch: JSONException -> L18
        int r106 = r103.optInt(r105);     // Catch: JSONException -> L18
        this.mPreconnProtoInfoMap.put(r105, Integer.valueOf(r106));     // Catch: JSONException -> L18
        if (r102 == null) goto L5;
        String r107 = new JSONObject(r102).optString(r105);     // Catch: JSONException -> L18
        if (r107 == null) goto L5;
        JSONObject r108 = new JSONObject(r107);     // Catch: JSONException -> L18
        if (r105.equals("quic") == true) goto L14;
    L16:
        this.mPreconnParamsMap.put(r105, r108);     // Catch: JSONException -> L18
        goto L5
    L14:
        if (TextUtils.isEmpty(r100) == true) goto L16;
        r108.put("scfg_address", r100);     // Catch: JSONException -> L18
        goto L16
    L31:
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void doPreConnectTask(String r100, String r101) {
        if (this.mPreconnDomainList.isEmpty() == false) goto L5;
        return;
    L5:
        if (this.mPreconnProtoInfoMap.isEmpty() == false) goto L8;
        return;
    L8:
        if (this.mPreconnDomainList.contains(r100) == true) goto L10;
        return;
    L10:
        Map<String, PreconnInfo> r102 = this.mPreconnResultsMap;
        if (r102 != null) goto L13;
    L21:
        Iterator<String> r103 = this.mPreconnProtoInfoMap.keySet().iterator();
    L23:
        if (r103.hasNext() == false) goto L47;
        String r104 = r103.next();
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L34
        int r106 = this.mPreconnProtoInfoMap.get(r104).intValue();     // Catch: JSONException -> L34
        JSONObject r107 = new JSONObject();     // Catch: JSONException -> L34
        r107.put("given_ips", r101);     // Catch: JSONException -> L34
        r107.put("host", r100);     // Catch: JSONException -> L34
        r107.put("port", r106);     // Catch: JSONException -> L34
        r107.put("suggest_protocol", r104);     // Catch: JSONException -> L34
        r105.put("url_info", r107.toString());     // Catch: JSONException -> L34
        if (this.mPreconnParamsMap.containsKey(r104) == false) goto L30;
        JSONObject r108 = this.mPreconnParamsMap.get(r104);     // Catch: JSONException -> L34
        if (r108 == null) goto L30;
        r105.put("preconn_params", r108.toString());     // Catch: JSONException -> L34
    L30:
        IFunctionCalledByStrategyEngine r109 = this.mEngine;     // Catch: JSONException -> L34
        if (r109 == null) goto L23;
        r109.callFunctionByKey(1, String.valueOf(r105.toString()));     // Catch: JSONException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L47:
        return;
    L13:
        if (r102.containsKey(r101) == false) goto L21;
        PreconnInfo r110 = this.mPreconnResultsMap.get(r101);
        if (r110 == null) goto L21;
        long r111 = r110.getPreconnUpdateTime();
        if (r111 <= 0) goto L21;
        if ((System.currentTimeMillis() - r111) >= this.mTTL) goto L21;
    }
}
