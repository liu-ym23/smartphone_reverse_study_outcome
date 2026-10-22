package com.bytedance.ies.bullet.web.pia;

import android.webkit.WebResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements i47.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebResourceResponse f248314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Integer f248315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LoadFrom f248316c;

    @Override // i47.e
    public final InputStream getData() {
        return this.f248314a.getData();
    }

    @Override // i47.e
    public final String getEncoding() {
        return this.f248314a.getEncoding();
    }

    @Override // i47.e
    public final Map<String, String> getHeaders() {
        return this.f248314a.getResponseHeaders();
    }

    @Override // i47.e
    public final String getMimeType() {
        return this.f248314a.getMimeType();
    }

    @Override // i47.e
    public final String getReasonPhrase() {
        String r100 = this.f248314a.getReasonPhrase();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // i47.e
    public final int getStatusCode() {
        Integer r100 = this.f248315b;
        if (r100 == null) goto L6;
        return r100.intValue();
    L6:
        return this.f248314a.getStatusCode();
    }

    @Override // i47.e
    public final LoadFrom a() {
        return this.f248316c;
    }

    public e(WebResourceResponse r100, Integer r101, LoadFrom r102) {
        this.f248314a = r100;
        this.f248315b = r101;
        this.f248316c = r102;
    }
}
