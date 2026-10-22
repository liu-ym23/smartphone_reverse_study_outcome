package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
final enum TTNetDnsCacheSource extends Enum<TTNetDnsCacheSource> {
    private static final /* synthetic */ TTNetDnsCacheSource[] $VALUES = null;
    public static final TTNetDnsCacheSource SOURCE_ASYNC_BATCH_HTTPDNS = null;
    public static final TTNetDnsCacheSource SOURCE_HTTPDNS = null;
    public static final TTNetDnsCacheSource SOURCE_PRELOAD_BATCH_HTTPDNS = null;
    public static final TTNetDnsCacheSource SOURCE_PROC = null;
    public static final TTNetDnsCacheSource UNKNOWN = null;
    final int mValue;

    static {
        TTNetDnsCacheSource r100 = new TTNetDnsCacheSource("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        TTNetDnsCacheSource r101 = new TTNetDnsCacheSource("SOURCE_HTTPDNS", 1, 3);
        SOURCE_HTTPDNS = r101;
        TTNetDnsCacheSource r102 = new TTNetDnsCacheSource("SOURCE_PROC", 2, 6);
        SOURCE_PROC = r102;
        TTNetDnsCacheSource r103 = new TTNetDnsCacheSource("SOURCE_PRELOAD_BATCH_HTTPDNS", 3, 7);
        SOURCE_PRELOAD_BATCH_HTTPDNS = r103;
        TTNetDnsCacheSource r104 = new TTNetDnsCacheSource("SOURCE_ASYNC_BATCH_HTTPDNS", 4, 8);
        SOURCE_ASYNC_BATCH_HTTPDNS = r104;
        $VALUES = new TTNetDnsCacheSource[]{r100, r101, r102, r103, r104};
    }

    public static TTNetDnsCacheSource[] values() {
        return (TTNetDnsCacheSource[]) $VALUES.clone();
    }

    public static TTNetDnsCacheSource valueOf(String r100) {
        return (TTNetDnsCacheSource) a.a(TTNetDnsCacheSource.class, r100);
    }

    private TTNetDnsCacheSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.mValue = r102;
    }
}
