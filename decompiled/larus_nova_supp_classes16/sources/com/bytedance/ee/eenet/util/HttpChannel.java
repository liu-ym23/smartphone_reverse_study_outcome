package com.bytedance.ee.eenet.util;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum HttpChannel extends Enum<HttpChannel> {
    public static final HttpChannel OkHttpChannel = null;
    public static final HttpChannel RustChannel = null;
    public static final /* synthetic */ HttpChannel[] a = null;
    private String channel;

    static {
        HttpChannel r0 = new HttpChannel("RustChannel", 0, "rustChannel");
        RustChannel = r0;
        HttpChannel r1 = new HttpChannel("OkHttpChannel", 1, "okHttp3Channel");
        OkHttpChannel = r1;
        a = new HttpChannel[]{r0, r1};
    }

    public static HttpChannel[] values() {
        return (HttpChannel[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.channel;
    }

    public static HttpChannel valueOf(String r1) {
        return (HttpChannel) a.a(HttpChannel.class, r1);
    }

    public HttpChannel(String r1, int r2, String r3) {
        super(r1, r2);
        this.channel = r3;
    }
}
