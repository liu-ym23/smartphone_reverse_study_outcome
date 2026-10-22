package com.bytedance.apm.trace.api.wrapper;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final enum TracingWrapperMode extends Enum<TracingWrapperMode> {
    public static final TracingWrapperMode PARALLEL_WRAPPER_MODE = null;
    public static final TracingWrapperMode SERIAL_WRAPPER_MODE = null;
    public static final /* synthetic */ TracingWrapperMode[] a = null;

    static {
        TracingWrapperMode r0 = new TracingWrapperMode("PARALLEL_WRAPPER_MODE", 0);
        PARALLEL_WRAPPER_MODE = r0;
        TracingWrapperMode r1 = new TracingWrapperMode("SERIAL_WRAPPER_MODE", 1);
        SERIAL_WRAPPER_MODE = r1;
        a = new TracingWrapperMode[]{r0, r1};
    }

    public static TracingWrapperMode[] values() {
        return (TracingWrapperMode[]) a.clone();
    }

    public static TracingWrapperMode valueOf(String r1) {
        return (TracingWrapperMode) a.a(TracingWrapperMode.class, r1);
    }

    public TracingWrapperMode(String r1, int r2) {
        super(r1, r2);
    }
}
