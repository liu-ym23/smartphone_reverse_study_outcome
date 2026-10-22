package com.ss.ttvideoengine.strategrycenter;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public class StrategyEvent {
    private static final String EST_PLAYTIME = "est_play";
    private static final String FIRST_BLOCK_DECISION_TIME = "first_block_decision_time";
    private static final String FIRST_BLOCK_EXEC_TIME = "first_block_exec_time";
    public static final String LOG_KEY_ADAPTIVE_RANGE = "st_adaptive_range";
    private static final String LOG_KEY_ADAPTIVE_RANGE_BUFFER_LOG = "buffer_log";
    private static final String LOG_KEY_ADAPTIVE_RANGE_ENABLED = "enabled";
    private static final String LOG_KEY_BANDWIDTH_BITRATE_RATIO = "band_bitrate_ratio";
    public static final String LOG_KEY_BANDWIDTH_RANGE = "st_band_range";
    public static final String LOG_KEY_BUFFER_DURATION = "st_buf_dur";
    public static final String LOG_KEY_COMMON_EVENT_LOG = "st_common";
    private static final String LOG_KEY_CURRENT_BANDWIDTH = "current_bandwidth";
    private static final String LOG_KEY_FIRST_FRAME_LABEL = "first_frame_label";
    private static final String LOG_KEY_LOAD_CONTROL_SLIDING_WINDOW = "sliding_window";
    private static final String LOG_KEY_LOAD_CONTROL_VERSION = "lc_version";
    private static final String LOG_KEY_MODULE_ACTIVATED = "module_activated";
    private static final String LOG_KEY_PLAY_BUFFER_DIFF_COUNT = "diff_ret_count";
    public static final String LOG_KEY_PLAY_TASK_CONTROL = "st_play_task_op";
    public static final String LOG_KEY_PRELOAD = "st_preload";
    public static final String LOG_KEY_PRELOAD_DECISION_INFO = "st_preload_decision";
    public static final String LOG_KEY_PRELOAD_DECISION_INFO2 = "st_preload_decision2";
    public static final String LOG_KEY_PRELOAD_FINISHED_TIME = "st_preload_finished_time";
    public static final String LOG_KEY_PRELOAD_PERSONALIZED = "st_preload_personalized";
    private static final String LOG_KEY_PRELOAD_PERSONALIZED_OPTION = "preload_personalized_option";
    public static final String LOG_KEY_PRELOAD_STRATEGY = "st_preload_sc_info";
    public static final String LOG_KEY_REMAINING_BUFFER_DURATION = "st_remaining_buf_dur";
    private static final String LOG_KEY_RE_BUFFER_DURATION_INITIAL = "rebuf_dur_init";
    private static final String LOG_KEY_STALL_LABEL = "stall_label";
    private static final String LOG_KEY_STARTUP_BUFFER_DURATION = "startup_buf_dur";
    private static final String LOG_KEY_STARTUP_CACHE_SIZE = "startup_cache";
    public static final String LOG_KEY_THROWS = "st_throws";
    private static final String LOG_KEY_WATCH_DURATION_LABEL = "watch_duration_label";
    private static final String PAUSE = "pause";
    private static final String RANGE = "range";
    private static final String RANGE_DURATION = "range_dur";
    private static final String RESUME = "resume";
    private static final String SAFE_FACTOR = "safe_factor";
    private static final String SEEKLABEL = "seek_label";
    private static final String SMART_LEVEL = "smart_level";
    private static final String TAG = "StrategyEvent";
    private static final String TARGET_BUFFER = "target_buffer";
    private final ConcurrentMap<String, Object> mNoVidMap;
    private final Queue<Map<String, Object>> mUnexpectedThrowables;
    private final ConcurrentMap<String, ConcurrentMap<String, Object>> mVidMap;

    public StrategyEvent() {
        this.mVidMap = new ConcurrentHashMap();
        this.mNoVidMap = new ConcurrentHashMap();
        this.mUnexpectedThrowables = new ConcurrentLinkedQueue();
    }

    private static Map<String, Object> convertCounterMap(Map<String, Object> r100) {
        HashMap r101 = new HashMap();
        Iterator<Map.Entry<String, Object>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<String, Object> r103 = r102.next();
        if ((r103.getValue() instanceof Map) == true) goto L7;
        if ((r103.getValue() instanceof AtomicInteger) == true) goto L10;
        r101.put(r103.getKey(), r103.getValue());
        goto L4
    L10:
        r101.put(r103.getKey(), Integer.valueOf(((AtomicInteger) r103.getValue()).get()));
        goto L4
    L7:
        r101.put(r103.getKey(), convertCounterMap((Map) r103.getValue()));
        goto L4
    L12:
        return r101;
    }

    public Map<String, Object> getLogData(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        ConcurrentMap<String, Object> r101 = this.mVidMap.get(r100);
        if (r101 == null) goto L9;
        Map r102 = convertCounterMap(r101);
    L10:
        r102.putAll(this.mNoVidMap);
        String r103 = StrategyHelper.helper().getCenter().p(31301, r100);
        if (TextUtils.isEmpty(r103) == true) goto L14;
        r102.put(LOG_KEY_PRELOAD_STRATEGY, r103);
    L14:
        if (this.mUnexpectedThrowables.isEmpty() == true) goto L16;
        r102.put(LOG_KEY_THROWS, this.mUnexpectedThrowables);
        this.mUnexpectedThrowables.clear();
    L16:
        TTVideoEngineLog.i(TAG, "vid: " + r100 + ", gotten log data: " + r102);
        return r102;
    L9:
        r102 = new HashMap();
        goto L10
    }

    public void removeLogData(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        this.mVidMap.remove(r100);
    }

    private static ConcurrentMap<String, Object> putIfAbsentAndGetMap(ConcurrentMap<String, Object> r100, String r101) {
        r100.putIfAbsent(r101, new ConcurrentHashMap());
        return (ConcurrentMap) r100.get(r101);
    }

    public Map<String, Object> getLogData(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L8;
        return null;
    L8:
        if (r101.equals("st_play_task_op") == false) goto L14;
        Map r102 = (Map) this.mVidMap.get(r100).get(r101);
        if (r102 != null) goto L12;
        return null;
    L12:
        return convertCounterMap(r102);
    L14:
        return null;
    }

    public Map<String, Object> popLogData(int r100, String r101) {
        JSONObject r102 = new JSONObject(StrategyHelper.helper().getCenter().u(r100, r101));     // Catch: JSONException -> L9
        HashMap r103 = new HashMap();     // Catch: JSONException -> L9
        Iterator<String> r104 = r102.keys();     // Catch: JSONException -> L9
    L5:
        if (r104.hasNext() == false) goto L7;
        String r105 = r104.next();     // Catch: JSONException -> L9
        r103.put(r105, r102.get(r105));     // Catch: JSONException -> L9
        goto L5
    L7:
        TTVideoEngineLog.i(TAG, "traceId: " + r101 + ", type: " + r100 + ", gotten log data: " + r103);     // Catch: JSONException -> L9
        return r103;
    L9:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "event log parse failed: " + e);
        return null;
    }

    private void eventImpl(String r210, int r211, int r212, String r213) {
        String r100 = RANGE_DURATION;
        if (TextUtils.isEmpty(r210) == true) goto L8;
        String r110 = LOG_KEY_PRELOAD_DECISION_INFO2;
        if ("unknown".equalsIgnoreCase(r210) == true) goto L9;
        ConcurrentMap<String, ConcurrentMap<String, Object>> r101 = this.mVidMap;
        r100 = RANGE_DURATION;
        r101.putIfAbsent(r210, new ConcurrentHashMap());
        ConcurrentMap<String, Object> r102 = this.mVidMap.get(r210);
    L10:
        ConcurrentMap<String, Object> r103 = r102;
        if (r211 != 2021) goto L13;
        if (r213 == null) goto L217;
        String r104 = r110;
        putIfAbsentAndGetMap(r103, r104).put("info", new JSONObject(r213));     // Catch: JSONException -> L142
        return;
    L142:
        e = move-exception;
        TTVideoEngineLog.w(TAG, "LOG_KEY_PRELOAD_DECISION_INFO2:\n" + e);
        putIfAbsentAndGetMap(r103, r104).put("info", r213);
        return;
    L217:
        return;
    L13:
        switch(r211) {
            case 2000: goto L64;
            case 2001: goto L62;
            case 2002: goto L60;
            case 2003: goto L54;
            case 2004: goto L53;
            case 2005: goto L52;
            case 2006: goto L51;
            case 2007: goto L50;
            case 2008: goto L49;
            case 2009: goto L42;
            case 2010: goto L41;
            case 2011: goto L35;
            case 2012: goto L153;
            case 2013: goto L26;
            case 2014: goto L25;
            case 2015: goto L20;
            case 2016: goto L19;
            case 2017: goto L18;
            case 2018: goto L16;
            default: goto L218;
        };
    L18:
        putIfAbsentAndGetMap(r103, LOG_KEY_BUFFER_DURATION).put(LOG_KEY_LOAD_CONTROL_SLIDING_WINDOW, Integer.valueOf(r212));
        return;
    L19:
        putIfAbsentAndGetMap(r103, LOG_KEY_BUFFER_DURATION).put(LOG_KEY_LOAD_CONTROL_VERSION, Integer.valueOf(r212));
        return;
    L20:
        if (r213 == null) goto L183;
        putIfAbsentAndGetMap(r103, LOG_KEY_PRELOAD_DECISION_INFO).put("info", new JSONObject(r213));     // Catch: JSONException -> L23
        return;
    L23:
        e = move-exception;
        TTVideoEngineLog.w(TAG, "LOG_KEY_PRELOAD_DECISION_INFO:\n" + e);
        putIfAbsentAndGetMap(r103, LOG_KEY_PRELOAD_DECISION_INFO).put("info", r213);
        return;
    L183:
        return;
    L25:
        this.mNoVidMap.put(LOG_KEY_COMMON_EVENT_LOG, Collections.singletonMap(LOG_KEY_MODULE_ACTIVATED, Integer.valueOf(r212)));
        return;
    L26:
        ConcurrentMap<String, Object> r105 = putIfAbsentAndGetMap(r103, LOG_KEY_BANDWIDTH_RANGE);
        r105.put(LOG_KEY_CURRENT_BANDWIDTH, Integer.valueOf(r212));
        r105.put(LOG_KEY_BANDWIDTH_BITRATE_RATIO, Float.valueOf(CastFloatProtector.parseFloat(r213)));     // Catch: NumberFormatException -> L29
        return;
    L29:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "LOG_KEY_BANDWIDTH_BITRATE_RATIO:\n" + e);
        r105.put(LOG_KEY_BANDWIDTH_BITRATE_RATIO, r213);
        return;
    L35:
        Map r106 = (Map) r103.get(LOG_KEY_BUFFER_DURATION);
        if (r106 == null) goto L188;
        Integer r107 = (Integer) r106.get(LOG_KEY_PLAY_BUFFER_DIFF_COUNT);
        if (r107 != null) goto L40;
        r107 = 0;
    L40:
        r106.put(LOG_KEY_PLAY_BUFFER_DIFF_COUNT, Integer.valueOf(r107.intValue() + r212));
        return;
    L188:
        return;
    L41:
        r103.put(LOG_KEY_REMAINING_BUFFER_DURATION, Integer.valueOf(r212));
        return;
    L42:
        if (r213 != null) goto L159;
        TTVideoEngineLog.e(TAG, "EVENT_ADAPTIVE_RANGE_BUFFER: logInfo is null");
        return;
    L159:
        Object r108 = new JSONObject(r213);     // Catch: JSONException -> L46
    L48:
        putIfAbsentAndGetMap(r103, LOG_KEY_ADAPTIVE_RANGE).put(LOG_KEY_ADAPTIVE_RANGE_BUFFER_LOG, r108);
        return;
    L46:
        e = move-exception;
        TTVideoEngineLog.w(TAG, "EVENT_ADAPTIVE_RANGE_BUFFER:\n" + e);
        r108 = r213;
        goto L48
    L49:
        putIfAbsentAndGetMap(r103, LOG_KEY_ADAPTIVE_RANGE).put(LOG_KEY_ADAPTIVE_RANGE_ENABLED, Integer.valueOf(r212));
        return;
    L50:
        putIfAbsentAndGetMap(r103, LOG_KEY_PRELOAD_PERSONALIZED).put(LOG_KEY_FIRST_FRAME_LABEL, Integer.valueOf(r212));
        return;
    L51:
        putIfAbsentAndGetMap(r103, LOG_KEY_PRELOAD_PERSONALIZED).put(LOG_KEY_STALL_LABEL, Integer.valueOf(r212));
        return;
    L52:
        putIfAbsentAndGetMap(r103, LOG_KEY_PRELOAD_PERSONALIZED).put(LOG_KEY_WATCH_DURATION_LABEL, Integer.valueOf(r212));
        return;
    L53:
        putIfAbsentAndGetMap(r103, LOG_KEY_PRELOAD_PERSONALIZED).put(LOG_KEY_PRELOAD_PERSONALIZED_OPTION, Integer.valueOf(r212));
        return;
    L54:
        ConcurrentMap<String, Object> r109 = putIfAbsentAndGetMap(r103, LOG_KEY_BUFFER_DURATION);
        r109.put(LOG_KEY_STARTUP_BUFFER_DURATION, Integer.valueOf(r212));
        if (r213 == null) goto L198;
        r109.put(LOG_KEY_STARTUP_CACHE_SIZE, new JSONObject(r213));     // Catch: JSONException -> L58
        return;
    L58:
        e = move-exception;
        TTVideoEngineLog.w(TAG, "LOG_KEY_STARTUP_CACHE_SIZE:\n" + e);
        r109.put(LOG_KEY_STARTUP_CACHE_SIZE, r213);
        return;
    L198:
        return;
    L60:
        putIfAbsentAndGetMap(r103, LOG_KEY_BUFFER_DURATION).put(LOG_KEY_RE_BUFFER_DURATION_INITIAL, Integer.valueOf(r212));
        return;
    L64:
        r103.putIfAbsent("st_play_task_op", new ConcurrentHashMap());
        ConcurrentMap r111 = (ConcurrentMap) r103.get("st_play_task_op");
        if (r212 != 1) goto L67;
        r111.putIfAbsent("pause", new AtomicInteger());
        ((AtomicInteger) r111.get("pause")).incrementAndGet();
        return;
    L67:
        if (r212 != 2) goto L69;
        r111.putIfAbsent(RESUME, new AtomicInteger());
        ((AtomicInteger) r111.get(RESUME)).incrementAndGet();
        return;
    L69:
        if (r212 != 4) goto L71;
        r111.putIfAbsent("range", new AtomicInteger());
        ((AtomicInteger) r111.get("range")).incrementAndGet();
        return;
    L71:
        if (r212 != 5) goto L73;
        if (r213 != null) goto L155;
        TTVideoEngineLog.e(TAG, "PLAY_TASK_RANGE_DURATION: logInfo is null");
        return;
    L155:
        String r112 = r100;
        r111.put(r112, new JSONObject(r213));     // Catch: JSONException -> L130
        return;
    L130:
        e = e;
    L134:
        TTVideoEngineLog.w(TAG, "PLAY_TASK_RANGE_DURATION:\n" + e);
        r111.put(r112, r213);
        return;
    L132:
        e = e;
        r112 = r100;
        goto L134
    L73:
        if (r212 != 6) goto L75;
        if (r213 != null) goto L145;
        TTVideoEngineLog.e(TAG, "PLAY_TASK_TARGET_BUFFER");
        return;
    L145:
        JSONObject r113 = new JSONObject(r213);     // Catch: JSONException -> L121
        Object r114 = TARGET_BUFFER;
        r111.put(r114, r113);     // Catch: JSONException -> L119
        return;
    L119:
        e = e;
    L123:
        TTVideoEngineLog.w(TAG, "PLAY_TASK_TARGET_BUFFER:\n" + e);
        r111.put(r114, r213);
        return;
    L121:
        e = e;
        r114 = TARGET_BUFFER;
        goto L123
    L75:
        if (r212 == 7) goto L102;
        switch(r212) {
            case 100: goto L101;
            case 101: goto L149;
            case 102: goto L171;
            case 103: goto L147;
            case 104: goto L78;
            default: goto L223;
        };
    L78:
        r111.put(SMART_LEVEL, r213);
        return;
    L101:
        r111.put("seek_label", r213);
        return;
    L147:
        r111.put(EST_PLAYTIME, Long.valueOf(CastLongProtector.parseLong(r213)));     // Catch: NumberFormatException -> L81
        return;
    L81:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "EST_PLAYTIME:\n" + e);
        r111.put(EST_PLAYTIME, r213);
        return;
    L149:
        Long r115 = Long.valueOf(CastLongProtector.parseLong(r213));     // Catch: NumberFormatException -> L98
        Object r116 = FIRST_BLOCK_DECISION_TIME;
        r111.put(r116, r115);     // Catch: NumberFormatException -> L96
        return;
    L96:
        e = e;
    L100:
        TTVideoEngineLog.e(TAG, "PLAY_TASK_FIRST_BLOCK_DECISION_TIME:\n" + e);
        r111.put(r116, r213);
        return;
    L98:
        e = e;
        r116 = FIRST_BLOCK_DECISION_TIME;
        goto L100
    L171:
        Long r117 = Long.valueOf(CastLongProtector.parseLong(r213));     // Catch: NumberFormatException -> L89
        Object r118 = FIRST_BLOCK_EXEC_TIME;
        r111.put(r118, r117);     // Catch: NumberFormatException -> L87
        return;
    L87:
        e = e;
    L91:
        TTVideoEngineLog.e(TAG, "PLAY_TASK_FIRST_BLOCK_EXEC_TIME:\n" + e);
        r111.put(r118, r213);
        return;
    L89:
        e = e;
        r118 = FIRST_BLOCK_EXEC_TIME;
        goto L91
    L223:
        return;
    L102:
        if (r213 != null) goto L157;
        TTVideoEngineLog.e(TAG, "PLAY_TASK_SAFE_FACTOR");
        return;
    L157:
        JSONObject r119 = new JSONObject(r213);     // Catch: JSONException -> L110
        Object r120 = SAFE_FACTOR;
        r111.put(r120, r119);     // Catch: JSONException -> L108
        return;
    L108:
        e = e;
    L112:
        TTVideoEngineLog.w(TAG, "PLAY_TASK_SAFE_FACTOR:\n" + e);
        r111.put(r120, r213);
        return;
    L110:
        e = e;
        r120 = SAFE_FACTOR;
        goto L112
    L153:
        r103.put(LOG_KEY_PRELOAD_FINISHED_TIME, Long.valueOf(CastLongProtector.parseLong(r213)));     // Catch: NumberFormatException -> L33
        return;
    L33:
        e = move-exception;
        TTVideoEngineLog.e(TAG, "EVENT_PLAY_RELATED_PRELOAD_FINISHED:\n" + e);
        r103.put(LOG_KEY_PRELOAD_FINISHED_TIME, r213);
        return;
    L218:
        return;
    L16:
        if (TextUtils.isEmpty(r213) == true) goto L179;
        putIfAbsentAndGetMap(this.mNoVidMap, LOG_KEY_PRELOAD).put("scene", r213);
        return;
    L179:
        return;
    L62:
        if (TextUtils.isEmpty(r213) == true) goto L201;
        putIfAbsentAndGetMap(this.mNoVidMap, LOG_KEY_PRELOAD).put("name", r213);
        return;
    L201:
        return;
    L9:
        r102 = this.mNoVidMap;
        goto L10
    L8:
        r110 = LOG_KEY_PRELOAD_DECISION_INFO2;
        goto L9
    }

    public void event(final String r110, final int r111, final int r112, final String r113) {
        eventImpl(r110, r111, r112, r113);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        this.mUnexpectedThrowables.add(new AnonymousClass1(this, r110, r111, r112, r113, th));
    }
}
