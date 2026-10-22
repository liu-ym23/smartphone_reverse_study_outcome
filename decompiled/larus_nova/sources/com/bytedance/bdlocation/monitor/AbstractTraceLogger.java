package com.bytedance.bdlocation.monitor;

import android.os.SystemClock;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractTraceLogger {
    private final Map<String, Object> CATEGORY_DATA;
    private final String CLASS_NAME_STR;
    private final Map<String, Object> LOG_EXTRAS;
    private final Map<String, Long> METRIC_CACHE_DATA;
    private final Map<String, Long> REPORT_METRIC_DATA;

    public AbstractTraceLogger() {
        this.CLASS_NAME_STR = getClass().getName();
        this.CATEGORY_DATA = new ConcurrentHashMap();
        this.METRIC_CACHE_DATA = new ConcurrentHashMap();
        this.REPORT_METRIC_DATA = new ConcurrentHashMap();
        this.LOG_EXTRAS = new ConcurrentHashMap();
    }

    public void begin(String r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.METRIC_CACHE_DATA.containsKey(r100) == false) goto L8;
        Logger.i("begin action error:" + r100 + ", class: " + this.CLASS_NAME_STR);
        this.METRIC_CACHE_DATA.remove(r100);
        return;
    L8:
        this.METRIC_CACHE_DATA.put(r100, Long.valueOf(SystemClock.uptimeMillis()));
    }

    public void dumpCategoriesTo(JSONObject r100) {
        if (this.CATEGORY_DATA.isEmpty() == true) goto L17;
        if (r100 == null) goto L27;
        Iterator<Map.Entry<String, Object>> r101 = this.CATEGORY_DATA.entrySet().iterator();
    L8:
        if (r101.hasNext() == false) goto L28;
        Map.Entry<String, Object> r102 = r101.next();
        if (r102 == null) goto L8;
        if (r102.getKey() == null) goto L8;
        if (r102.getValue() == null) goto L8;
        JsonUtil.safePutObject(r100, r102.getKey(), r102.getValue());
        goto L8
    L28:
        return;
    L27:
        return;
    }

    public void dumpLogExtrasTo(JSONObject r100) {
        if (this.LOG_EXTRAS.isEmpty() == true) goto L17;
        if (r100 == null) goto L27;
        Iterator<Map.Entry<String, Object>> r101 = this.LOG_EXTRAS.entrySet().iterator();
    L8:
        if (r101.hasNext() == false) goto L28;
        Map.Entry<String, Object> r102 = r101.next();
        if (r102 == null) goto L8;
        if (r102.getKey() == null) goto L8;
        if (r102.getValue() == null) goto L8;
        JsonUtil.safePutObject(r100, r102.getKey(), r102.getValue());
        goto L8
    L28:
        return;
    L27:
        return;
    }

    public void dumpMetricsTo(JSONObject r100) {
        if (this.REPORT_METRIC_DATA.isEmpty() == true) goto L17;
        if (r100 == null) goto L27;
        Iterator<Map.Entry<String, Long>> r101 = this.REPORT_METRIC_DATA.entrySet().iterator();
    L8:
        if (r101.hasNext() == false) goto L28;
        Map.Entry<String, Long> r102 = r101.next();
        if (r102 == null) goto L8;
        if (r102.getKey() == null) goto L8;
        if (r102.getValue() == null) goto L8;
        JsonUtil.safePutLong(r100, r102.getKey(), r102.getValue().longValue());
        goto L8
    L28:
        return;
    L27:
        return;
    }

    public void end(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Long r101 = this.METRIC_CACHE_DATA.get(r100);
        if (r101 != null) goto L7;
    L11:
        Logger.i("end action error:" + r100 + ", class: " + this.CLASS_NAME_STR);
        return;
    L7:
        if (this.REPORT_METRIC_DATA.containsKey(r100) == true) goto L11;
        this.REPORT_METRIC_DATA.put(r100, Long.valueOf(SystemClock.uptimeMillis() - r101.longValue()));
        this.METRIC_CACHE_DATA.remove(r100);
    }

    public void putCategoryData(String r100, Object r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        this.CATEGORY_DATA.put(r100, r101);
        return;
    L8:
        return;
    }

    public void putLogExtra(String r100, Object r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        this.LOG_EXTRAS.put(r100, r101);
        return;
    L8:
        return;
    }

    public void putReportMetricData(String r100, long r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.REPORT_METRIC_DATA.put(r100, Long.valueOf(r101));
    }
}
