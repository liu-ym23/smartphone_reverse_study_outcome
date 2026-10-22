package com.bytedance.pia.core.bridge.channel;

import android.webkit.JavascriptInterface;
import android.webkit.WebMessagePort;
import android.webkit.WebView;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.utils.d;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;
import m47.l;
import n47.a;
import n47.c;
import n47.e;

/* JADX INFO: loaded from: classes21.dex */
public final class WebViewPort implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.pia.core.utils.a<JsonObject> f266164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.pia.core.utils.a<String> f266165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WebMessagePort f266166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference<WebView> f266167d;

    public static class JSInterface {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final WeakHashMap<WebView, JSInterface> f266168d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference<com.bytedance.pia.core.utils.a<String>> f266169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.bytedance.pia.core.utils.a<String> f266170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f266171c;

        static {
            f266168d = new WeakHashMap();
        }

        public JSInterface(String r100) {
            this.f266169a = new AtomicReference(null);
            this.f266170b = null;
            this.f266171c = r100;
        }

        @JavascriptInterface
        public void postMessage(String r100) {
            if ("__port_init__".equals(r100) == false) goto L5;
        L6:
            AtomicReference<com.bytedance.pia.core.utils.a<String>> r101 = this.f266169a;
            com.bytedance.pia.core.utils.a<String> r102 = new com.bytedance.pia.core.utils.a();
        L8:
            if (r101.compareAndSet(null, r102) == true) goto L9;
            if (r101.get() == null) goto L8;
            boolean r103 = false;
        L13:
            if (r103 == false) goto L15;
            this.f266170b = this.f266169a.get();
        L16:
            com.bytedance.pia.core.utils.a<String> r104 = this.f266170b;
            if (r104 == null) goto L23;
            r104.a(r100);
            return;
        L23:
            return;
        L15:
            this.f266170b = this.f266169a.getAndSet(null);
            goto L16
        L9:
            r103 = true;
            goto L13
        L5:
            if ("__port_init_next__".equals(r100) == false) goto L16;
            goto L6
        }

        @JavascriptInterface
        public void log(String r100, int r101) {
            if (r101 != 0) goto L5;
            d.a(r100, this.f266171c, null, "PIA_Web");
            return;
        L5:
            if (r101 != 1) goto L7;
            d.k(r100, this.f266171c, null, "PIA_Web");
            return;
        L7:
            if (r101 != 2) goto L9;
            d.o(r100, this.f266171c, null, "PIA_Web");
            return;
        L9:
            if (r101 == 3) goto L11;
            d.m(r100, this.f266171c, null, "PIA_Web");
            return;
        L11:
            d.e(r100, null, this.f266171c, "PIA_Web");
        }
    }

    @Override // n47.a
    public final void close() {
        com.bytedance.pia.core.utils.a<JsonObject> r100 = this.f266164a;
        r100.f266388d = true;
        r100.b();
        r100.f266385a.set(null);
        com.bytedance.pia.core.utils.a<String> r101 = this.f266165b;
        r101.f266388d = true;
        r101.b();
        r101.f266385a.set(null);
        ThreadUtil.c(new c(this));
    }

    @Override // n47.a
    public final void a(final l r100) {
        this.f266165b.c(new e(this, r100));
    }

    @Override // n47.a
    public final void b(JsonObject r100) {
        this.f266164a.a(r100);
    }

    public final void c(final Boolean r100) {
        this.f266164a.c(new n47.d(this, r100));
    }

    public WebViewPort(WebView r100, com.bytedance.pia.core.utils.a<String> r101) {
        this.f266164a = new com.bytedance.pia.core.utils.a();
        this.f266165b = r101;
        this.f266167d = new WeakReference(r100);
    }
}
