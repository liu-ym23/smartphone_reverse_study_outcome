package com.bytedance.ee.bear.bitable.preload;

import com.bytedance.ee.bear.document.DocBridgeWebViewV2;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<DocBridgeWebViewV2> f214983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f214984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<DocBridgeWebViewV2> f214985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f214986d;

    public c() {
    }

    public final void a() {
        this.f214983a = null;
        this.f214984b = null;
    }

    public final void b() {
        this.f214985c = null;
        this.f214986d = null;
    }

    public final DocBridgeWebViewV2 c() {
        WeakReference<DocBridgeWebViewV2> r100 = this.f214985c;
        if (r100 == null) goto L5;
        DocBridgeWebViewV2 r101 = r100.get();
    L6:
        if (r101 != null) goto L9;
        b();
        return null;
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final DocBridgeWebViewV2 d() {
        WeakReference<DocBridgeWebViewV2> r100 = this.f214983a;
        if (r100 == null) goto L5;
        DocBridgeWebViewV2 r101 = r100.get();
    L6:
        if (r101 != null) goto L9;
        a();
        return null;
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }
}
