package com.bytedance.ee.eenet.util;

import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum HttpChannel extends Enum<HttpChannel> {
    public static final HttpChannel OkHttpChannel = null;
    public static final HttpChannel RustChannel = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HttpChannel[] f242763a = null;
    private String channel;

    static {
        HttpChannel r100 = new HttpChannel("RustChannel", 0, "rustChannel");
        RustChannel = r100;
        HttpChannel r101 = new HttpChannel("OkHttpChannel", 1, "okHttp3Channel");
        OkHttpChannel = r101;
        f242763a = new HttpChannel[]{r100, r101};
    }

    public static HttpChannel[] values() {
        return (HttpChannel[]) f242763a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.channel;
    }

    public static HttpChannel valueOf(String r100) {
        return (HttpChannel) a.a(HttpChannel.class, r100);
    }

    public HttpChannel(String r100, int r101, String r102) {
        super(r100, r101);
        this.channel = r102;
    }
}
