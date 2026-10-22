package com.bytedance.ee.bear.document;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class b implements x2, d5, y4 {
    public final DocumentPluginHost a;
    public final a b;
    public final List<x2.b> c;
    public com.bytedance.ee.bear.document.a d;
    public b5 e;
    public final s1 f;

    public static class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView r1, String r2, Bitmap r3) {
            super.onPageStarted(r1, r2, r3);
            rcb.c.d(r1);
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedHttpError(WebView r2, WebResourceRequest r3, WebResourceResponse r4) {
            super.onReceivedHttpError(r2, r3, r4);
            tt5.a.h("WebViewFragment#WebStatus", "onReceivedHttpError()... url = " + du5.b.g(r3.getUrl().toString()) + ", err rsp:" + r4);
        }
    }

    public abstract DocBridgeWebViewV2 i();

    public final void D() {
        ((com.bytedance.ee.bear.contract.m) org.koin.java.a.a(com.bytedance.ee.bear.contract.m.class)).a(this.a.c());
        vv4.k r0 = this.a.getWeb();
        if ((r0 instanceof z4) == false) goto L5;
        ((z4) r0).s(false, Integer.valueOf(hashCode()));
    L5:
        i().T(this.b);
    }

    public b(DocumentPluginHost r7) {
        this.a = r7;
        this.b = new a();
        this.c = new CopyOnWriteArrayList();
        this.f = new s1(com.bytedance.ee.bear.contract.j.a.a, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), (com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class), (com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class), ((com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class)).e());
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void S(x2.b r2) {
        List<x2.b> r0 = this.c;
        if (r0 == null) goto L6;
        ((CopyOnWriteArrayList) r0).remove(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void S3(x2.b r2) {
        if (((CopyOnWriteArrayList) this.c).contains(r2) == true) goto L6;
        ((CopyOnWriteArrayList) this.c).add(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.document.y4
    public final void n(String r4) {
        List<x2.b> r0 = this.c;
        if (r0 == null) goto L10;
        Iterator r1 = ((CopyOnWriteArrayList) r0).iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        x2.b r2 = (x2.b) r1.next();
        if ((r2 instanceof x2.a) == false) goto L6;
        ((x2.a) r2).a(r4);
        goto L6
    L16:
        return;
    }
}
