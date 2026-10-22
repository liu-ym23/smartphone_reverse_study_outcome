package com.bytedance.ies.bullet.web.pia;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements i47.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebResourceRequest f248317a;

    @Override // i47.d
    public final /* synthetic */ Map getOptions() {
        return null;
    }

    @Override // i47.d
    public final Map<String, String> getRequestHeaders() {
        return this.f248317a.getRequestHeaders();
    }

    @Override // i47.d
    public final Uri getUrl() {
        return this.f248317a.getUrl();
    }

    @Override // i47.d
    public final boolean isForMainFrame() {
        return this.f248317a.isForMainFrame();
    }

    public f(WebResourceRequest r100) {
        this.f248317a = r100;
    }
}
