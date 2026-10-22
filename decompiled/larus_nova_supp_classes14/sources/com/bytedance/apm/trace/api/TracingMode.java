package com.bytedance.apm.trace.api;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final enum TracingMode extends Enum<TracingMode> {
    public static final TracingMode BATCH = null;
    public static final /* synthetic */ TracingMode[] a = null;

    static {
        TracingMode r0 = new TracingMode();
        BATCH = r0;
        a = new TracingMode[]{r0};
    }

    public TracingMode() {
        super("BATCH", 0);
    }

    public static TracingMode[] values() {
        return (TracingMode[]) a.clone();
    }

    public static TracingMode valueOf(String r1) {
        return (TracingMode) a.a(TracingMode.class, r1);
    }
}
