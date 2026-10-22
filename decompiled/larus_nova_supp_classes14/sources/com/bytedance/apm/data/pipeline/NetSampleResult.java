package com.bytedance.apm.data.pipeline;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final enum NetSampleResult extends Enum<NetSampleResult> {
    public static final NetSampleResult HIT = null;
    public static final NetSampleResult NOT_HIT = null;
    public static final NetSampleResult UNKNOWN = null;
    public static final /* synthetic */ NetSampleResult[] a = null;

    static {
        NetSampleResult r0 = new NetSampleResult("UNKNOWN", 0);
        UNKNOWN = r0;
        NetSampleResult r1 = new NetSampleResult("HIT", 1);
        HIT = r1;
        NetSampleResult r3 = new NetSampleResult("NOT_HIT", 2);
        NOT_HIT = r3;
        a = new NetSampleResult[]{r0, r1, r3};
    }

    public static NetSampleResult[] values() {
        return (NetSampleResult[]) a.clone();
    }

    public static NetSampleResult valueOf(String r1) {
        return (NetSampleResult) a.a(NetSampleResult.class, r1);
    }

    public NetSampleResult(String r1, int r2) {
        super(r1, r2);
    }
}
