package com.bytedance.map.api.monitor;

import com.bytedance.map.api.utils.JsonUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public class MapMonitor {
    public MapMonitor() {
    }

    private static String mapTypeToInfo(int r100) {
        if (r100 != 0) goto L4;
        return MonitorValueConst.MAP_TYPE_AMAP_2D;
    L4:
        if (r100 != 1) goto L6;
        return MonitorValueConst.MAP_TYPE_AMAP_3D;
    L6:
        if (r100 == 4) goto L9;
        return "unknown";
    L9:
        return MonitorValueConst.MAP_TYPE_BAIDU;
    }

    public static void destroyMap() {
        MapMonitorUtil.monitorEvent(MapMonitorConst.EVENT_DESTROY);
    }

    public static void drawLine() {
        MapMonitorUtil.monitorEvent(MapMonitorConst.EVENT_DRAW_LINE, null, new JSONObject());
    }

    public static void moveMap() {
        MapMonitorUtil.monitorEvent(MapMonitorConst.EVENT_USER_MOVE_MAP);
    }

    public static void tapAnnotation() {
        MapMonitorUtil.monitorEvent(MapMonitorConst.EVENT_USER_TAP_ANNOTATION);
    }

    public static void zoomMap() {
        MapMonitorUtil.monitorEvent(MapMonitorConst.EVENT_USER_ZOOM_MAP);
    }

    public static void amapExceptionMonitor(Throwable r100) {
        JSONObject r101 = new JSONObject();
        if (r100 == null) goto L5;
        JsonUtil.safePutString(r101, "exception_msg", r100.getMessage());
    L5:
        MapMonitorUtil.monitorEvent(MapMonitorConst.EVENT_AMAP_EXCEPTION, r101, null);
    }

    public static void buildTextModelsException(Throwable r100) {
        JSONObject r101 = new JSONObject();
        if (r100 == null) goto L5;
        JsonUtil.safePutString(r101, "exception_msg", r100.getMessage());
    L5:
        MapMonitorUtil.monitorEvent(MapMonitorConst.EVENT_BUILD_TEXT_MODELS_EXCEPTION, r101, null);
    }

    public static void customMapStyleTotal(String r100) {
        JSONObject r101 = new JSONObject();
        JsonUtil.safePutInt(r101, "total", 1);
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        JsonUtil.safePutString(r101, "style_id", r100);
        MapMonitorUtil.monitorEvent(MapMonitorConst.EVENT_CUSTOM_STYLE, r101, null);
    }

    private static String truncate(String r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if (r100.length() > 200) goto L7;
        return r100;
    L7:
        return r100.substring(0, 200);
    }

    public static void uploadMapDisplayTime(long r100) {
        JSONObject r101 = new JSONObject();
        JsonUtil.safePutLong(r101, "duration", r100);
        MapMonitorUtil.monitorEvent(MapMonitorConst.EVENT_DISPLAY_TOTAL_TIME, null, r101);
    }

    public static void mapExceptionMonitor(int r100, Throwable r101) {
        JSONObject r102 = new JSONObject();
        JsonUtil.safePutInt(r102, "type", r100);
        if (r101 == null) goto L5;
        JsonUtil.safePutString(r102, "exception_msg", r101.getMessage());
    L5:
        MapMonitorUtil.monitorEvent(MapMonitorConst.EVENT_MAP_EXCEPTION, r102, null);
    }

    public static void customMapStyleFirstFail(int r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        JsonUtil.safePutInt(r103, MapMonitorConst.FIRST_FAIL, 1);
        JsonUtil.safePutString(r103, MapMonitorConst.ERROR_INFO, r100 + "_" + r101);
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        JsonUtil.safePutString(r103, "style_id", r102);
        MapMonitorUtil.monitorEvent(MapMonitorConst.EVENT_CUSTOM_STYLE, r103, null);
    }

    public static void customMapStyleRetryFail(int r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        JsonUtil.safePutInt(r103, MapMonitorConst.RETRY_FAIL, 1);
        JsonUtil.safePutString(r103, MapMonitorConst.ERROR_INFO, r100 + "_" + r101);
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        JsonUtil.safePutString(r103, "style_id", r102);
        MapMonitorUtil.monitorEvent(MapMonitorConst.EVENT_CUSTOM_STYLE, r103, null);
    }

    public static void drawAnnotation(int r100, boolean r101, long r102) {
        JSONObject r103 = new JSONObject();
        JsonUtil.safePutInt(r103, "type", r100);
        JsonUtil.safePutBoolean(r103, "is_success", r101);
        JSONObject r104 = new JSONObject();
        JsonUtil.safePutLong(r104, "duration", r102);
        MapMonitorUtil.monitorEvent(MapMonitorConst.EVENT_DRAW_ANNOTATION, r103, r104);
    }

    public static void firstMapTileLoad(int r100, boolean r101, long r102) {
        JSONObject r103 = new JSONObject();
        JsonUtil.safePutInt(r103, "type", r100);
        JsonUtil.safePutBoolean(r103, "is_success", r101);
        JSONObject r104 = new JSONObject();
        JsonUtil.safePutLong(r104, "duration", r102);
        MapMonitorUtil.monitorEvent(MapMonitorConst.EVENT_FIRST_MAP_TILE_LOAD, r103, r104);
    }

    public static void loadMap(int r100, boolean r101, long r102) {
        JSONObject r103 = new JSONObject();
        JsonUtil.safePutInt(r103, "type", r100);
        JsonUtil.safePutBoolean(r103, "is_success", r101);
        JSONObject r104 = new JSONObject();
        JsonUtil.safePutLong(r104, "duration", r102);
        MapMonitorUtil.monitorEvent(MapMonitorConst.EVENT_LOAD, r103, r104);
    }

    public static void mapInit(int r100, long r101, long r102) {
        JSONObject r103 = new JSONObject();
        JsonUtil.safePutInt(r103, "type", r100);
        JSONObject r104 = new JSONObject();
        JsonUtil.safePutLong(r104, MapMonitorConst.MAP_INIT_DURATION, r101);
        JsonUtil.safePutLong(r104, MapMonitorConst.MAP_LOAD_DURATION, r102);
        MapMonitorUtil.monitorEvent(MapMonitorConst.EVENT_MAP_INIT, r103, r104);
    }

    public static void uploadPluginState(String r100, boolean r101, long r102) {
        JSONObject r103 = new JSONObject();
        JsonUtil.safePutString(r103, "tag", r100);
        JsonUtil.safePutBoolean(r103, "is_success", r101);
        JSONObject r104 = new JSONObject();
        JsonUtil.safePutLong(r104, "duration", r102);
        MapMonitorUtil.monitorEvent(MapMonitorConst.EVENT_PLUGIN_STATE, r103, r104);
    }

    public static void getShotFromCacheMonitor(int r100, String r101, long r102, long r103, boolean r104) {
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutString(r105, MapMonitorConst.MAP_TYPE, mapTypeToInfo(r100));
        JsonUtil.safePutString(r105, "result_type", r101);
        JsonUtil.safePutBoolean(r105, MapMonitorConst.IS_DISK_CACHE, r104);
        JSONObject r106 = new JSONObject();
        JsonUtil.safePutLong(r106, "timestamp", r102);
        JsonUtil.safePutLong(r106, "total_duration", r103);
        MapMonitorUtil.monitorEvent(MapMonitorConst.EVENT_GET_SHOT_FROM_CACHE, r105, r106);
    }

    public static void launchShotToCacheMonitor(int r100, String r101, long r102, long r103, long r104, long r110) {
        JSONObject r105 = new JSONObject();
        JsonUtil.safePutString(r105, MapMonitorConst.MAP_TYPE, mapTypeToInfo(r100));
        JsonUtil.safePutString(r105, "result_type", r101);
        JSONObject r106 = new JSONObject();
        JsonUtil.safePutLong(r106, "timestamp", r102);
        JsonUtil.safePutLong(r106, "total_duration", r103);
        JsonUtil.safePutLong(r106, MapMonitorConst.SHOT_DURATION, r104);
        JsonUtil.safePutLong(r106, "cache_duration", r110);
        MapMonitorUtil.monitorEvent(MapMonitorConst.EVENT_LAUNCH_SHOT_TO_CACHE, r105, r106);
    }

    public static void customMapStyleTrace(int r110, String r111, String r112, String r113, String r114, String r115, String r116, boolean r210, boolean r211, String r212, Integer r213, String r214, Integer r215, String r216, long r217, long r218, long r310, String r311) {
        JSONObject r100 = new JSONObject();
        JsonUtil.safePutString(r100, MapMonitorConst.MAP_TYPE, mapTypeToInfo(r110));
        String r117 = "";
        if (r111 != null) goto L5;
        String r118 = "";
    L6:
        JsonUtil.safePutString(r100, MapMonitorConst.MAP_VIEW_TYPE, r118);
        if (r112 != null) goto L9;
        String r119 = "";
    L10:
        JsonUtil.safePutString(r100, "style_id", r119);
        if (r113 != null) goto L13;
        String r120 = "";
    L14:
        JsonUtil.safePutString(r100, MapMonitorConst.STYLE_TYPE, r120);
        if (r114 != null) goto L17;
        String r121 = "";
    L18:
        JsonUtil.safePutString(r100, MapMonitorConst.STYLE_SOURCE, r121);
        if (r115 != null) goto L21;
        String r122 = "";
    L22:
        JsonUtil.safePutString(r100, MapMonitorConst.ATTEMPT, r122);
        if (r116 == null) goto L26;
        r117 = r116;
    L26:
        JsonUtil.safePutString(r100, "status", r117);
        JsonUtil.safePutBoolean(r100, MapMonitorConst.IS_ENABLE, r210);
        JsonUtil.safePutBoolean(r100, MapMonitorConst.IS_DESTROYED, r211);
        if (r212 == null) goto L29;
        JsonUtil.safePutString(r100, MapMonitorConst.SKIP_REASON, r212);
    L29:
        if (r213 == null) goto L31;
        JsonUtil.safePutInt(r100, "error_code", r213.intValue());
    L31:
        if (r214 == null) goto L33;
        JsonUtil.safePutString(r100, "error_msg", r214);
    L33:
        if (r215 == null) goto L35;
        JsonUtil.safePutInt(r100, MapMonitorConst.FIRST_ERROR_CODE, r215.intValue());
    L35:
        if (r216 == null) goto L37;
        JsonUtil.safePutString(r100, MapMonitorConst.FIRST_ERROR_MSG, r216);
    L37:
        if (r311 == null) goto L39;
        JsonUtil.safePutString(r100, MapMonitorConst.CUSTOM_STYLE_PATH, truncate(r311));
    L39:
        JSONObject r101 = new JSONObject();
        if (r217 < 0) goto L43;
        JsonUtil.safePutLong(r101, MapMonitorConst.FIRST_ATTEMPT_DURATION, r217);
    L43:
        if (r218 < 0) goto L46;
        JsonUtil.safePutLong(r101, MapMonitorConst.ATTEMPT_DURATION, r218);
    L46:
        if (r310 < 0) goto L48;
        JsonUtil.safePutLong(r101, "total_duration", r310);
    L48:
        MapMonitorUtil.monitorEvent(MapMonitorConst.EVENT_CUSTOM_STYLE_TRACE, r100, r101);
        return;
    L21:
        r122 = r115;
        goto L22
    L17:
        r121 = r114;
        goto L18
    L13:
        r120 = r113;
        goto L14
    L9:
        r119 = r112;
        goto L10
    L5:
        r118 = r111;
        goto L6
    }
}
