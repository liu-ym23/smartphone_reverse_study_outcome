package com.lynx.jsbridge.network;

import com.lynx.react.bridge.JavaOnlyMap;

/* JADX INFO: loaded from: classes32.dex */
public class HttpRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f381368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f381369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f381370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JavaOnlyMap f381371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JavaOnlyMap f381372e;

    public HttpRequest() {
        this.f381368a = "";
        this.f381369b = "";
        this.f381370c = null;
        this.f381371d = new JavaOnlyMap();
        this.f381372e = new JavaOnlyMap();
    }

    public static HttpRequest CreateHttpRequest(String r100, String r101, String r102, byte[] r103, JavaOnlyMap r104, JavaOnlyMap r105) {
        HttpRequest r106 = new HttpRequest();
        r106.f381368a = r100;
        r106.f381369b = r101;
        r106.f381370c = r103;
        r106.f381371d = r104;
        r106.f381372e = r105;
        return r106;
    }
}
