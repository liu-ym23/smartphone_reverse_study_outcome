package com.bytedance.bdlocation.monitor;

import com.bytedance.bdlocation.log.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class InfoRequestQPSOptTraceLogger extends AbstractTraceLogger {
    public static final String CACHE_DURATION = "cache_duration";
    public static final String CACHE_FAILED_REASON = "cache_failed_reason";
    public static final String ERROR_MESSAGE = "error_message";
    public static final String IS_CACHE_SUCCESS = "is_cache_success";
    public static final String IS_SKIP = "is_skip";
    public static final String REASON = "reason";
    public static final String SKIP_CHECK_DURATION = "skip_check_duration";

    public void monitorInfoRequestQPSOptEvent() {
        JSONObject r100 = new JSONObject();
        dumpCategoriesTo(r100);
        JSONObject r101 = new JSONObject();
        dumpMetricsTo(r101);
        JSONObject r102 = new JSONObject();
        dumpLogExtrasTo(r102);
        Logger.i("monitorInfoRequestQPSOptEvent categories: " + r100);
        Logger.i("monitorInfoRequestQPSOptEvent metrics: " + r101);
        Logger.i("monitorInfoRequestQPSOptEvent logExtras: " + r102);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_INFO_QPS_OPT, r100, r101, r102);
    }

    public InfoRequestQPSOptTraceLogger() {
    }
}
