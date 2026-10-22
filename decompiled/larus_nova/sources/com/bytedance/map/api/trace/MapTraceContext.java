package com.bytedance.map.api.trace;

import af6.a;
import com.bytedance.map.api.logger.MapLogger;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
final class MapTraceContext {
    private static final String PAGE_ID = "pageId";
    private static final String TAG = "MapTraceContext";
    private static final String TRACE_CONTEXT = "traceContext";
    private static final String TRACE_ID = "traceId";
    private static final String TRACE_NAME = "traceName";
    private static final String WIDGET_INSTANCE_ID = "widgetInstanceId";
    private final a mSdkTraceContext;

    public a toSdkTraceContext() {
        return this.mSdkTraceContext;
    }

    public static MapTraceContext fromExtraParams(Map<String, Object> r100) {
        if (r100 != null) goto L6;
        MapLogger.i(TAG, "fromExtraParams Extra params is null");
        return null;
    L6:
        Object r101 = r100.get(TRACE_CONTEXT);
        if (r101 != null) goto L11;
        MapLogger.i(TAG, "fromExtraParams Trace context is absent");
        return null;
    L11:
        if ((r101 instanceof Map) == true) goto L14;
        MapLogger.w(TAG, "fromExtraParams Trace context is not a map");
        return null;
    L14:
        MapLogger.i(TAG, "fromExtraParams Trace context=" + r101);
        Map r102 = (Map) r101;
        String r103 = trimmedString(r102.get(TRACE_NAME));
        String r104 = trimmedString(r102.get(TRACE_ID));
        if (r103 == null) goto L20;
        if (r104 == null) goto L20;
        return new MapTraceContext(r103, r104, trimmedString(r102.get(PAGE_ID)), trimmedString(r102.get(WIDGET_INSTANCE_ID)));
    L20:
        MapLogger.w(TAG, "fromExtraParams Trace name or trace ID is invalid");
        return null;
    }

    private static String trimmedString(Object r100) {
        if ((r100 instanceof String) == true) goto L5;
        return null;
    L5:
        String r101 = ((String) r100).trim();
        if (r101.isEmpty() == false) goto L8;
        return null;
    L8:
        if ("null".equalsIgnoreCase(r101) == false) goto L11;
        return null;
    L11:
        return r101;
    }

    private MapTraceContext(String r100, String r101, String r102, String r103) {
        this.mSdkTraceContext = new a(r100, r101, r102, r103);
    }
}
