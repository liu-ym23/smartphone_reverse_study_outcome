package com.bytedance.assem.arch.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/assem/arch/core/InflateMode;", "", "SYNC", "ASYNC", "X2C", "ASYNC_X2C", "assem_release"}, k = 1, mv = {1, 4, 0})
public final enum InflateMode extends Enum<InflateMode> {
    public static final InflateMode ASYNC = null;
    public static final InflateMode ASYNC_X2C = null;
    public static final InflateMode SYNC = null;
    public static final InflateMode X2C = null;
    public static final /* synthetic */ InflateMode[] a = null;

    static {
        InflateMode r1 = new InflateMode("SYNC", 0);
        SYNC = r1;
        InflateMode r2 = new InflateMode("ASYNC", 1);
        ASYNC = r2;
        InflateMode r3 = new InflateMode("X2C", 2);
        X2C = r3;
        InflateMode r4 = new InflateMode("ASYNC_X2C", 3);
        ASYNC_X2C = r4;
        a = new InflateMode[]{r1, r2, r3, r4};
    }

    public static InflateMode valueOf(String r1) {
        return (InflateMode) r27.a.a(InflateMode.class, r1);
    }

    public static InflateMode[] values() {
        return (InflateMode[]) a.clone();
    }

    public InflateMode(String r1, int r2) {
        super(r1, r2);
    }
}
