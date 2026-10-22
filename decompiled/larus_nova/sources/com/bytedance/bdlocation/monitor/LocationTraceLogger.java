package com.bytedance.bdlocation.monitor;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class LocationTraceLogger extends AbstractTraceLogger {
    private JSONObject getSuccessMetric() {
        JSONObject r100 = new JSONObject();
        dumpMetricsTo(r100);
        return r100;
    }

    public LocationTraceLogger() {
    }

    public void locationErrorReport(BDLocationException r100) {
        JSONObject r101 = new JSONObject();
        JSONObject r102 = new JSONObject();
        JsonUtil.safePutBoolean(r101, "is_success", false);
        if (r100 == null) goto L5;
        JsonUtil.safePutString(r101, "err_code", r100.getCode());
        JsonUtil.safePutString(r101, LocationMonitorConst.ERR_MSG, r100.getMessage());
        JsonUtil.safePutString(r102, LocationMonitorConst.DETAIL_ERR_MSG, r100.getDetailMessage());
    L6:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BD_LOCATION_TRACE_LOG, r101, null, r102);
        return;
    L5:
        JsonUtil.safePutString(r101, "err_code", "-1002");
        JsonUtil.safePutString(r101, LocationMonitorConst.ERR_MSG, "exception is null");
        goto L6
    }

    private JSONObject getSuccessCategory(BDLocation r100, LocationOption r101) {
        JSONObject r102 = new JSONObject();
        dumpCategoriesTo(r102);
        JsonUtil.safePutString(r102, LocationMonitorConst.LOCATION_NAME, r100.getLocationSDKName());
        JsonUtil.safePutString(r102, "err_code", "200");
        JsonUtil.safePutString(r102, LocationMonitorConst.ERR_MSG, "success");
        JsonUtil.safePutBoolean(r102, "is_success", true);
        JsonUtil.safePutBoolean(r102, LocationMonitorConst.IS_TIMEOUT, false);
        JsonUtil.safePutBoolean(r102, LocationMonitorConst.IS_CACHE, r100.isCache());
        JsonUtil.safePutBoolean(r102, LocationMonitorConst.IS_CN, r101.isChineseRegion());
        JsonUtil.safePutInt(r102, LocationMonitorConst.LOCATE_TYPE, r100.getLocationType());
        JsonUtil.safePutBoolean(r102, LocationMonitorConst.IS_WIFI_OPEN, LocationUtil.isWifiOpen());
        JsonUtil.safePutString(r102, "upload_source", r101.getUploadSource());
        return r102;
    }

    private JSONObject getSuccessExtra(BDLocation r100, LocationOption r101) {
        JSONObject r102 = new JSONObject();
        JsonUtil.safePutDouble(r102, LocationMonitorConst.ACCURACY, r100.getAccuracy());
        JsonUtil.safePutLong(r102, "cache_time", r101.getMaxCacheTime());
        JsonUtil.safePutLong(r102, "timeout", r101.getLocationTimeOutMs());
        JsonUtil.safePutString(r102, "upload_source", r101.getUploadSource());
        JsonUtil.safePutLong(r102, LocationMonitorConst.INTEL_UPLOAD_INTERVAL, r101.getUploadInterval());
        if (r100.isCache() == false) goto L5;
        JsonUtil.safePutLong(r102, LocationMonitorConst.CACHE_TIMESTAMP, r100.getLocationMs());
        JsonUtil.safePutLong(r102, "cache_duration", System.currentTimeMillis() - r100.getLocationMs());
    L6:
        JsonUtil.safePutLong(r102, "timestamp", System.currentTimeMillis());
        return r102;
    L5:
        JsonUtil.safePutLong(r102, LocationMonitorConst.CACHE_TIMESTAMP, 0);
        JsonUtil.safePutLong(r102, "cache_duration", 0);
        goto L6
    }

    public void locationSuccessReport(BDLocation r100, LocationOption r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        JSONObject r102 = getSuccessCategory(r100, r101);
        JSONObject r103 = getSuccessMetric();
        JSONObject r104 = getSuccessExtra(r100, r101);
        Logger.i("LocationTraceLogger category:" + r102.toString());
        Logger.i("LocationTraceLogger   metric:" + r103.toString());
        Logger.i("LocationTraceLogger    extra:" + r104.toString());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BD_LOCATION_TRACE_LOG, r102, r103, r104);
        return;
    L8:
        return;
    }
}
