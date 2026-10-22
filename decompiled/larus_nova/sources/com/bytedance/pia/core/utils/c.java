package com.bytedance.pia.core.utils;

import com.bytedance.pia.core.api.resource.LoadFrom;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements i47.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f266390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f266391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f266392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f266393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Map<String, String> f266394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ InputStream f266395f;

    @Override // i47.e
    public final LoadFrom a() {
        return LoadFrom.Online;
    }

    @Override // i47.e
    public final InputStream getData() {
        return this.f266395f;
    }

    @Override // i47.e
    public final String getEncoding() {
        return this.f266391b;
    }

    @Override // i47.e
    public final Map<String, String> getHeaders() {
        return this.f266394e;
    }

    @Override // i47.e
    public final String getMimeType() {
        return this.f266390a;
    }

    @Override // i47.e
    public final String getReasonPhrase() {
        return this.f266393d;
    }

    @Override // i47.e
    public final int getStatusCode() {
        return this.f266392c;
    }

    public c(String r100, String r101, int r102, String r103, Map<String, String> r104, InputStream r105) {
        this.f266390a = r100;
        this.f266391b = r101;
        this.f266392c = r102;
        this.f266393d = r103;
        this.f266394e = r104;
        this.f266395f = r105;
    }
}
