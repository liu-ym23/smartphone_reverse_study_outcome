package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
final enum TTNetDnsSource extends Enum<TTNetDnsSource> {
    private static final /* synthetic */ TTNetDnsSource[] $VALUES = null;
    public static final TTNetDnsSource NOT_SET = null;
    public static final TTNetDnsSource SERVE_FROM_ASYNC_BATCH_PRELOAD = null;
    public static final TTNetDnsSource SERVE_FROM_BATCH_PRELOAD = null;
    public static final TTNetDnsSource SERVE_FROM_CACHE = null;
    public static final TTNetDnsSource SERVE_FROM_HARDCODE_HOSTS = null;
    public static final TTNetDnsSource SERVE_FROM_HTTP_DNS_JOB = null;
    public static final TTNetDnsSource SERVE_FROM_PREFER_ADDR = null;
    public static final TTNetDnsSource SERVE_FROM_PROC_DNS_JOB = null;
    final int mValue;

    static {
        TTNetDnsSource r100 = new TTNetDnsSource("NOT_SET", 0, 0);
        NOT_SET = r100;
        TTNetDnsSource r101 = new TTNetDnsSource("SERVE_FROM_CACHE", 1, 2);
        SERVE_FROM_CACHE = r101;
        TTNetDnsSource r102 = new TTNetDnsSource("SERVE_FROM_PREFER_ADDR", 2, 5);
        SERVE_FROM_PREFER_ADDR = r102;
        TTNetDnsSource r103 = new TTNetDnsSource("SERVE_FROM_HTTP_DNS_JOB", 3, 6);
        SERVE_FROM_HTTP_DNS_JOB = r103;
        TTNetDnsSource r104 = new TTNetDnsSource("SERVE_FROM_PROC_DNS_JOB", 4, 8);
        SERVE_FROM_PROC_DNS_JOB = r104;
        TTNetDnsSource r110 = new TTNetDnsSource("SERVE_FROM_HARDCODE_HOSTS", 5, 9);
        SERVE_FROM_HARDCODE_HOSTS = r110;
        TTNetDnsSource r111 = new TTNetDnsSource("SERVE_FROM_BATCH_PRELOAD", 6, 19);
        SERVE_FROM_BATCH_PRELOAD = r111;
        TTNetDnsSource r105 = new TTNetDnsSource("SERVE_FROM_ASYNC_BATCH_PRELOAD", 7, 20);
        SERVE_FROM_ASYNC_BATCH_PRELOAD = r105;
        $VALUES = new TTNetDnsSource[]{r100, r101, r102, r103, r104, r110, r111, r105};
    }

    public static TTNetDnsSource[] values() {
        return (TTNetDnsSource[]) $VALUES.clone();
    }

    public static TTNetDnsSource valueOf(String r100) {
        return (TTNetDnsSource) a.a(TTNetDnsSource.class, r100);
    }

    private TTNetDnsSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.mValue = r102;
    }
}
