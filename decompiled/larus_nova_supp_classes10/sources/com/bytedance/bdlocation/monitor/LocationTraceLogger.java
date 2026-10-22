package com.bytedance.bdlocation.monitor;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class LocationTraceLogger extends AbstractTraceLogger {
    private JSONObject getSuccessMetric() {
        JSONObject r0 = new JSONObject();
        dumpMetricsTo(r0);
        return r0;
    }

    public LocationTraceLogger() {
    }

    public void locationErrorReport(BDLocationException r6) {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_SUCCESS, false);
        if (r6 == null) goto L5;
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_CODE, r6.getCode());
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6.getMessage());
        JsonUtil.safePutString(r1, LocationMonitorConst.DETAIL_ERR_MSG, r6.getDetailMessage());
    L6:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BD_LOCATION_TRACE_LOG, r0, null, r1);
        return;
    L5:
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_CODE, "-1002");
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, "exception is null");
        goto L6
    }

    private JSONObject getSuccessCategory(BDLocation r4, LocationOption r5) {
        JSONObject r0 = new JSONObject();
        dumpCategoriesTo(r0);
        JsonUtil.safePutString(r0, LocationMonitorConst.LOCATION_NAME, r4.getLocationSDKName());
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_CODE, BDLocationException.SUCCESS);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, "success");
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_SUCCESS, true);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_TIMEOUT, false);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_CACHE, r4.isCache());
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_CN, r5.isChineseRegion());
        JsonUtil.safePutInt(r0, LocationMonitorConst.LOCATE_TYPE, r4.getLocationType());
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_WIFI_OPEN, LocationUtil.isWifiOpen());
        JsonUtil.safePutString(r0, "upload_source", r5.getUploadSource());
        return r0;
    }

    private JSONObject getSuccessExtra(BDLocation r6, LocationOption r7) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutDouble(r0, LocationMonitorConst.ACCURACY, r6.getAccuracy());
        JsonUtil.safePutLong(r0, "cache_time", r7.getMaxCacheTime());
        JsonUtil.safePutLong(r0, LocationMonitorConst.TIMEOUT, r7.getLocationTimeOutMs());
        JsonUtil.safePutString(r0, "upload_source", r7.getUploadSource());
        JsonUtil.safePutLong(r0, LocationMonitorConst.INTEL_UPLOAD_INTERVAL, r7.getUploadInterval());
        if (r6.isCache() == false) goto L5;
        JsonUtil.safePutLong(r0, LocationMonitorConst.CACHE_TIMESTAMP, r6.getLocationMs());
        JsonUtil.safePutLong(r0, LocationMonitorConst.CACHE_DURATION, System.currentTimeMillis() - r6.getLocationMs());
    L6:
        JsonUtil.safePutLong(r0, LocationMonitorConst.TIMESTAMP, System.currentTimeMillis());
        return r0;
    L5:
        JsonUtil.safePutLong(r0, LocationMonitorConst.CACHE_TIMESTAMP, 0);
        JsonUtil.safePutLong(r0, LocationMonitorConst.CACHE_DURATION, 0);
        goto L6
    }

    public void locationSuccessReport(BDLocation r4, LocationOption r5) {
        if (r4 == null) goto L7;
        if (r5 == null) goto L8;
        JSONObject r0 = getSuccessCategory(r4, r5);
        JSONObject r1 = getSuccessMetric();
        JSONObject r6 = getSuccessExtra(r4, r5);
        Logger.i("LocationTraceLogger category:" + r0.toString());
        Logger.i("LocationTraceLogger   metric:" + r1.toString());
        Logger.i("LocationTraceLogger    extra:" + r6.toString());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BD_LOCATION_TRACE_LOG, r0, r1, r6);
        return;
    L8:
        return;
    }
}
