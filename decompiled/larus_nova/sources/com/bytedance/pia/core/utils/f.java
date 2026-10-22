package com.bytedance.pia.core.utils;

import android.webkit.WebResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements i47.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebResourceResponse f266397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LoadFrom f266398b;

    @Override // i47.e
    public final InputStream getData() {
        return this.f266397a.getData();
    }

    @Override // i47.e
    public final String getEncoding() {
        return this.f266397a.getEncoding();
    }

    @Override // i47.e
    public final Map<String, String> getHeaders() {
        return this.f266397a.getResponseHeaders();
    }

    @Override // i47.e
    public final String getMimeType() {
        return this.f266397a.getMimeType();
    }

    @Override // i47.e
    public final String getReasonPhrase() {
        String r100 = this.f266397a.getReasonPhrase();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // i47.e
    public final int getStatusCode() {
        return this.f266397a.getStatusCode();
    }

    @Override // i47.e
    public final LoadFrom a() {
        return this.f266398b;
    }

    public f(WebResourceResponse r100, LoadFrom r101) {
        this.f266397a = r100;
        this.f266398b = r101;
    }
}
