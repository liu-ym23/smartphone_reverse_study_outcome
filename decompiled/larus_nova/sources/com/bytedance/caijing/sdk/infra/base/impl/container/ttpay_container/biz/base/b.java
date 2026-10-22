package com.bytedance.caijing.sdk.infra.base.impl.container.ttpay_container.biz.base;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import b36.g;
import b36.k;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements WebResourceRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f202524a;

    @Override // android.webkit.WebResourceRequest
    public final String getMethod() {
        g r100 = this.f202524a;
        if (r100 == null) goto L5;
        CharSequence r101 = r100.getMethod();
    L7:
        return String.valueOf(r101);
    L5:
        r101 = null;
        goto L7
    }

    @Override // android.webkit.WebResourceRequest
    public final Map<String, String> getRequestHeaders() {
        g r100 = this.f202524a;
        if (r100 == null) goto L9;
        Map<String, String> r101 = r100.getRequestHeaders();
        if (r101 == null) goto L9;
        Map<String, String> r102 = MapsKt.toMutableMap(r101);
        if (r102 == null) goto L9;
        return r102;
    L9:
        return new LinkedHashMap();
    }

    @Override // android.webkit.WebResourceRequest
    public final Uri getUrl() {
        g r100 = this.f202524a;
        if (r100 == null) goto L7;
        Uri r101 = r100.getUrl();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return Uri.EMPTY;
    }

    @Override // android.webkit.WebResourceRequest
    public final boolean hasGesture() {
        g r100 = this.f202524a;
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.a());
    L6:
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.booleanValue();
    L5:
        r101 = null;
        goto L6
    }

    @Override // android.webkit.WebResourceRequest
    public final boolean isForMainFrame() {
        g r100 = this.f202524a;
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.isForMainFrame());
    L6:
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.booleanValue();
    L5:
        r101 = null;
        goto L6
    }

    @Override // android.webkit.WebResourceRequest
    public final boolean isRedirect() {
        g r100 = this.f202524a;
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.isRedirect());
    L6:
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.booleanValue();
    L5:
        r101 = null;
        goto L6
    }

    public b(k r100) {
        this.f202524a = r100;
    }
}
