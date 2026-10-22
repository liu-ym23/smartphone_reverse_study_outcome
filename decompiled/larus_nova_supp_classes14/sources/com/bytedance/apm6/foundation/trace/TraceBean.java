package com.bytedance.apm6.foundation.trace;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class TraceBean {
    public String a;
    public long b;
    public String c;
    public String d;
    public int e;
    public long f;
    public TraceType g;
    public JSONObject h;

    public static final enum TraceType extends Enum<TraceType> {
        public static final TraceType ASYNC_SLICE_BEGIN = null;
        public static final TraceType ASYNC_SLICE_END = null;
        public static final TraceType COUNTER = null;
        public static final TraceType FLOAT_COUNTER = null;
        public static final TraceType SLICE_BEGIN = null;
        public static final TraceType SLICE_END = null;
        public static final TraceType SLICE_INSTANT = null;
        public static final /* synthetic */ TraceType[] a = null;
        private final int value;

        static {
            TraceType r0 = new TraceType("SLICE_BEGIN", 0, 0);
            SLICE_BEGIN = r0;
            TraceType r1 = new TraceType("SLICE_END", 1, 1);
            SLICE_END = r1;
            TraceType r3 = new TraceType("ASYNC_SLICE_BEGIN", 2, 2);
            ASYNC_SLICE_BEGIN = r3;
            TraceType r5 = new TraceType("ASYNC_SLICE_END", 3, 3);
            ASYNC_SLICE_END = r5;
            TraceType r7 = new TraceType("SLICE_INSTANT", 4, 4);
            SLICE_INSTANT = r7;
            TraceType r9 = new TraceType("COUNTER", 5, 5);
            COUNTER = r9;
            TraceType r11 = new TraceType("FLOAT_COUNTER", 6, 6);
            FLOAT_COUNTER = r11;
            a = new TraceType[]{r0, r1, r3, r5, r7, r9, r11};
        }

        public static TraceType[] values() {
            return (TraceType[]) a.clone();
        }

        public static /* synthetic */ int access$000(TraceType r0) {
            return r0.value;
        }

        public static TraceType valueOf(String r1) {
            return (TraceType) r27.a.a(TraceType.class, r1);
        }

        public TraceType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public TraceBean() {
    }

    public final void a() {
        JSONObject r0 = new JSONObject();
        r0.putOpt("processName", this.a).putOpt("processId", Long.valueOf(this.b)).putOpt("traceName", this.c).putOpt("timestamp", Long.valueOf(this.f)).putOpt("traceType", Integer.valueOf(TraceType.access$000(this.g)));     // Catch: JSONException -> L24
        TraceType r1 = this.g;     // Catch: JSONException -> L24
        if (r1 != TraceType.COUNTER) goto L7;
        r0.putOpt("counterValue", 0);     // Catch: JSONException -> L24
    L14:
        TraceType r2 = this.g;     // Catch: JSONException -> L24
        if (r2 != TraceType.ASYNC_SLICE_BEGIN) goto L17;
    L18:
        r0.putOpt("asyncTag", Integer.valueOf(this.e));     // Catch: JSONException -> L24
    L19:
        JSONObject r3 = this.h;     // Catch: JSONException -> L24
        if (r3 == null) goto L22;
        r0.putOpt("debugAnnotation", r3);     // Catch: JSONException -> L24
    L22:
        r0.toString();
        return;
    L17:
        if (r2 != TraceType.ASYNC_SLICE_END) goto L19;
    L7:
        if (r1 != TraceType.FLOAT_COUNTER) goto L10;
        r0.putOpt("floatCounterValue", Float.valueOf(0.0f));     // Catch: JSONException -> L24
        goto L14
    L10:
        if (r1 == TraceType.SLICE_END) goto L14;
        if (r1 == TraceType.ASYNC_SLICE_END) goto L14;
        r0.putOpt("name", this.d);     // Catch: JSONException -> L24
    L24:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
