package com.lynx.jsbridge.network;

import com.lynx.react.bridge.JavaOnlyMap;

/* JADX INFO: loaded from: classes32.dex */
public class HttpResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f381373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f381374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f381375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JavaOnlyMap f381376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f381377e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JavaOnlyMap f381378f;

    public HttpResponse() {
        this.f381373a = 200;
        this.f381374b = "OK";
        this.f381375c = "";
        this.f381376d = new JavaOnlyMap();
        this.f381377e = new byte[0];
        this.f381378f = new JavaOnlyMap();
    }

    public JavaOnlyMap getCustomInfo() {
        return this.f381378f;
    }

    public byte[] getHttpBody() {
        return this.f381377e;
    }

    public JavaOnlyMap getHttpHeaders() {
        return this.f381376d;
    }

    public int getStatusCode() {
        return this.f381373a;
    }

    public String getStatusText() {
        return this.f381374b;
    }

    public String getUrl() {
        return this.f381375c;
    }
}
