package com.bytedance.map.api.trace;

import af6.b;
import android.os.SystemClock;
import com.bytedance.ai.api.navi.AppletNaviThirdApp;
import com.bytedance.lbs.trace.contract.TraceLevel;
import com.bytedance.map.api.MapInitConfig;
import com.bytedance.map.api.logger.MapLogger;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.LinkedHashMap;
import java.util.Map;
import r27.a;
import xe6.d;

/* JADX INFO: loaded from: classes21.dex */
public final class MapTraceReporter {
    private static final String IS_REUSED = "is_reused";
    private static final String IS_SUCCESS = "is_success";
    private static final String MAP_DESTROY = "lbs_client_map_destroy";
    private static final String MAP_LOAD_FINISH = "lbs_client_map_load_finish";
    private static final String MAP_LOAD_START = "lbs_client_map_load_start";
    private static final String MAP_OVERLAY_CREATE_FINISH = "lbs_client_map_overlay_create_finish";
    private static final String MAP_OVERLAY_CREATE_START = "lbs_client_map_overlay_create_start";
    private static final String MAP_TYPE = "map_type";
    private static final String MSG = "msg";
    private static final String OVERLAY_ID = "overlay_id";
    private static final String OVERLAY_TYPE = "overlay_type";
    private static final String TAG = "MapTraceReporter";
    private static final String UNKNOWN = "unknown";
    private final long mMapLoadStartElapsedRealtimeMs;
    private final MapTraceContext mTraceContext;

    public static final enum MapLoadFinishReason extends Enum<MapLoadFinishReason> {
        private static final /* synthetic */ MapLoadFinishReason[] $VALUES = null;
        public static final MapLoadFinishReason INIT_FAILED = null;
        public static final MapLoadFinishReason SUCCESS = null;
        private final TraceLevel mLevel;
        private final String mMsg;
        private final boolean mSuccess;

        static {
            MapLoadFinishReason r100 = new MapLoadFinishReason("SUCCESS", 0, true, "success", TraceLevel.INFO);
            SUCCESS = r100;
            MapLoadFinishReason r101 = new MapLoadFinishReason("INIT_FAILED", 1, false, "init_failed", TraceLevel.ERROR);
            INIT_FAILED = r101;
            $VALUES = new MapLoadFinishReason[]{r100, r101};
        }

        public static MapLoadFinishReason[] values() {
            return (MapLoadFinishReason[]) $VALUES.clone();
        }

        public static /* synthetic */ boolean access$000(MapLoadFinishReason r100) {
            return r100.mSuccess;
        }

        public static /* synthetic */ String access$100(MapLoadFinishReason r100) {
            return r100.mMsg;
        }

        public static /* synthetic */ TraceLevel access$200(MapLoadFinishReason r100) {
            return r100.mLevel;
        }

        public static MapLoadFinishReason valueOf(String r100) {
            return (MapLoadFinishReason) a.a(MapLoadFinishReason.class, r100);
        }

        private MapLoadFinishReason(String r100, int r101, boolean r102, String r103, TraceLevel r104) {
            super(r100, r101);
            this.mSuccess = r102;
            this.mMsg = r103;
            this.mLevel = r104;
        }
    }

    public static final enum OverlayCreateMsg extends Enum<OverlayCreateMsg> {
        private static final /* synthetic */ OverlayCreateMsg[] $VALUES = null;
        public static final OverlayCreateMsg EXCEPTION = null;
        public static final OverlayCreateMsg INVALID_PARAMS = null;
        public static final OverlayCreateMsg SUCCESS = null;
        private final String mValue;

        static {
            OverlayCreateMsg r100 = new OverlayCreateMsg("SUCCESS", 0, "success");
            SUCCESS = r100;
            OverlayCreateMsg r101 = new OverlayCreateMsg("INVALID_PARAMS", 1, "invalid_params");
            INVALID_PARAMS = r101;
            OverlayCreateMsg r102 = new OverlayCreateMsg("EXCEPTION", 2, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
            EXCEPTION = r102;
            $VALUES = new OverlayCreateMsg[]{r100, r101, r102};
        }

        public static OverlayCreateMsg[] values() {
            return (OverlayCreateMsg[]) $VALUES.clone();
        }

        public static /* synthetic */ String access$300(OverlayCreateMsg r100) {
            return r100.mValue;
        }

        public static OverlayCreateMsg valueOf(String r100) {
            return (OverlayCreateMsg) a.a(OverlayCreateMsg.class, r100);
        }

        private OverlayCreateMsg(String r100, int r101, String r102) {
            super(r100, r101);
            this.mValue = r102;
        }
    }

    public static final enum OverlayType extends Enum<OverlayType> {
        private static final /* synthetic */ OverlayType[] $VALUES = null;
        public static final OverlayType ARC = null;
        public static final OverlayType CIRCLE = null;
        public static final OverlayType MARKER = null;
        public static final OverlayType POLYGON = null;
        public static final OverlayType POLYLINE = null;
        public static final OverlayType TEXT_PATH = null;
        private final String mValue;

        static {
            OverlayType r100 = new OverlayType("MARKER", 0, "marker");
            MARKER = r100;
            OverlayType r101 = new OverlayType("POLYLINE", 1, SVGRenderEngine.POLYLINE);
            POLYLINE = r101;
            OverlayType r102 = new OverlayType("CIRCLE", 2, SVGRenderEngine.CIRCLE);
            CIRCLE = r102;
            OverlayType r103 = new OverlayType("POLYGON", 3, SVGRenderEngine.POLYGON);
            POLYGON = r103;
            OverlayType r104 = new OverlayType("ARC", 4, "arc");
            ARC = r104;
            OverlayType r105 = new OverlayType("TEXT_PATH", 5, "text_path");
            TEXT_PATH = r105;
            $VALUES = new OverlayType[]{r100, r101, r102, r103, r104, r105};
        }

        public static OverlayType[] values() {
            return (OverlayType[]) $VALUES.clone();
        }

        public static /* synthetic */ String access$400(OverlayType r100) {
            return r100.mValue;
        }

        public static OverlayType valueOf(String r100) {
            return (OverlayType) a.a(OverlayType.class, r100);
        }

        private OverlayType(String r100, int r101, String r102) {
            super(r100, r101);
            this.mValue = r102;
        }
    }

    private static String mapTypeName(int r100) {
        if (r100 != 0) goto L4;
        return "amap_2d";
    L4:
        if (r100 != 1) goto L6;
        return AppletNaviThirdApp.AMAP;
    L6:
        if (r100 != 2) goto L8;
        return "google";
    L8:
        if (r100 != 3) goto L10;
        return "google_static";
    L10:
        if (r100 == 4) goto L13;
        return "unknown";
    L13:
        return "baidu";
    }

    public MapTraceReporter(Map<String, Object> r100) {
        this.mTraceContext = MapTraceContext.fromExtraParams(r100);
        this.mMapLoadStartElapsedRealtimeMs = SystemClock.elapsedRealtime();
    }

    private void report(b r100) {
        MapLogger.i(TAG, "report eventName=" + r100.f3177a);
        MapTraceContext r101 = this.mTraceContext;
        if (r101 != null) goto L10;
        MapLogger.i(TAG, "report Trace context is null");
        return;
    L10:
        d.b(r101.toSdkTraceContext(), r100);     // Catch: Throwable -> L8
        return;
    L8:
        MapLogger.w(TAG, "report Trace report failed");
    }

    private static String trimmedString(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = r100.trim();
        if (r101.isEmpty() == false) goto L8;
        return null;
    L8:
        if ("null".equalsIgnoreCase(r101) == false) goto L11;
        return null;
    L11:
        return r101;
    }

    public void reportMapDestroy(int r100) {
        if (this.mTraceContext != null) goto L6;
        MapLogger.i(TAG, "reportMapDestroy Trace context is null");
        return;
    L6:
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("map_type", mapTypeName(r100));
        long r102 = Math.max(-1, SystemClock.elapsedRealtime() - this.mMapLoadStartElapsedRealtimeMs);
        report(new b(MAP_DESTROY, TraceLevel.INFO, Long.valueOf(r102), r101));
    }

    public void reportMapLoadStart(MapInitConfig r100) {
        if (this.mTraceContext != null) goto L6;
        MapLogger.i(TAG, "reportMapLoadStart Trace context is null");
        return;
    L6:
        if (r100 != null) goto L9;
        MapLogger.w(TAG, "reportMapLoadStart MapInitConfig is null");
        return;
    L9:
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("map_type", mapTypeName(r100.getMapType()));
        report(new b(MAP_LOAD_START, TraceLevel.INFO, null, r101));
    }

    private Map<String, Object> createOverlayCustomParams(int r100, OverlayType r101, String r102) {
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("map_type", mapTypeName(r100));
        r103.put(OVERLAY_TYPE, OverlayType.access$400(r101));
        String r104 = trimmedString(r102);
        if (r104 == null) goto L5;
        r103.put(OVERLAY_ID, r104);
    L5:
        return r103;
    }

    public void reportMapLoadFinish(MapLoadFinishReason r100, int r101, boolean r102) {
        if (this.mTraceContext != null) goto L6;
        MapLogger.i(TAG, "reportMapLoadFinish Trace context is null");
        return;
    L6:
        if (r100 != null) goto L9;
        MapLogger.w(TAG, "reportMapLoadFinish Finish reason is null");
        return;
    L9:
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("map_type", mapTypeName(r101));
        r103.put("is_success", Boolean.valueOf(MapLoadFinishReason.access$000(r100)));
        r103.put(IS_REUSED, Boolean.valueOf(r102));
        r103.put("msg", MapLoadFinishReason.access$100(r100));
        long r104 = Math.max(-1, SystemClock.elapsedRealtime() - this.mMapLoadStartElapsedRealtimeMs);
        report(new b(MAP_LOAD_FINISH, MapLoadFinishReason.access$200(r100), Long.valueOf(r104), r103));
    }

    public void reportMapOverlayCreateStart(int r100, OverlayType r101, String r102) {
        if (this.mTraceContext != null) goto L6;
        MapLogger.i(TAG, "reportMapOverlayCreateStart Trace context is null");
        return;
    L6:
        Map<String, Object> r103 = createOverlayCustomParams(r100, r101, r102);
        report(new b(MAP_OVERLAY_CREATE_START, TraceLevel.INFO, null, r103));
    }

    public void reportMapOverlayCreateFinish(int r100, OverlayType r101, String r102, long r103, boolean r104, OverlayCreateMsg r105) {
        if (r105 != null) goto L7;
        MapLogger.w(TAG, "reportMapOverlayCreateFinish Msg is null");
        return;
    L7:
        if (this.mTraceContext != null) goto L10;
        MapLogger.i(TAG, "reportMapOverlayCreateFinish Trace context is null");
        return;
    L10:
        if (r104 == false) goto L12;
        TraceLevel r106 = TraceLevel.INFO;
    L13:
        Map<String, Object> r107 = createOverlayCustomParams(r100, r101, r102);
        r107.put("is_success", Boolean.valueOf(r104));
        r107.put("msg", OverlayCreateMsg.access$300(r105));
        report(new b(MAP_OVERLAY_CREATE_FINISH, r106, Long.valueOf(r103), r107));
        return;
    L12:
        r106 = TraceLevel.WARNING;
        goto L13
    }
}
