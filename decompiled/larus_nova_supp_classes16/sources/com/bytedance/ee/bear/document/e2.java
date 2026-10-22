package com.bytedance.ee.bear.document;

import android.webkit.WebView;
import com.bytedance.ee.bear.browser.WebFragment;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e2 implements com.bytedance.ee.bear.contract.m {
    public final List<com.bytedance.ee.bear.contract.m.c> a;
    public final List<com.bytedance.ee.bear.contract.m.a> b;

    @Override // com.bytedance.ee.bear.contract.m
    public final Flowable b() {
        tt5.a.h("DocWebServiceImp2", "preloadTemplate=== start preloadTemplateNotDestroyWebview");
        l7 r0 = y7.j;
        y7 r1 = y7.a.a;
        r1.getClass();
        tt5.a.h("WebViewManager", "preloadTemplateNotDestroyWebview()... isReloadRN = false");
        if (y7.m() == false) goto L32;
        r1.c();
        if (r1.a.f() == 0) goto L33;
        DocBridgeWebViewV2[] r2 = {null};
        q45.c r3 = r1.a;
        monitor-enter(r3);
        Iterator r4 = new ArrayList(r3.a).iterator();     // Catch: Throwable -> L21
    L11:
        if (r4.hasNext() == false) goto L18;
        DocBridgeWebViewV2 r5 = ((q45.c.a) r4.next()).b;     // Catch: Throwable -> L21
        if (r2[0] == null) goto L15;
        r1.a.b(r5);     // Catch: Throwable -> L21
        goto L11
    L15:
        r2[0] = r5;     // Catch: Throwable -> L21
        goto L11
    L18:
        monitor-exit(r3);
        return r1.q(r2[0], false);
    L21:
        th = move-exception;
        throw th;
    L33:
        return r1.l(false);
    L32:
        return Flowable.just(Boolean.FALSE);
    }

    @Override // com.bytedance.ee.bear.contract.m
    public final void i() {
        tt5.a.b("DocWebServiceImp2", "export()...");
        Iterator r0 = ((ArrayList) this.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.contract.m.a) r0.next()).onRequestExport();
        goto L4
    }

    public e2() {
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    @Override // com.bytedance.ee.bear.contract.m
    public final void a(WebFragment r5) {
        WebViewFragment r0 = o(r5, "detach");
        if (r0 != null) goto L5;
        return;
    L5:
        b5 r1 = r0.k;
        if (r1 != null) goto L8;
    L17:
        tt5.a.h("DocWebServiceImp2", "detach: already detached");
        return;
    L8:
        if (r1.isAttached() == false) goto L17;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("ccm.bitable.docx_base.optimized.enable") == false) goto L13;
        ((com.bytedance.ee.bear.share.b) org.koin.java.a.a(com.bytedance.ee.bear.share.b.class)).g(r0);
    L13:
        r1.a(r5);
        l7 r6 = y7.j;
        DocBridgeWebViewV2 r7 = y7.a.a.f(r0.ba0());
        if (r7 == null) goto L19;
        r7.getWebServiceManager().d();
        return;
    }

    @Override // com.bytedance.ee.bear.contract.m
    public final Flowable<Boolean> c(boolean r6) {
        tt5.a.h("DocWebServiceImp2", "preloadTemplate=== start");
        l7 r0 = y7.j;
        y7 r1 = y7.a.a;
        r1.getClass();
        tt5.a.h("WebViewManager", "preloadTemplate()... isReloadRN = " + r6);
        if (y7.m() == false) goto L31;
        r1.c();
        tt5.a.h("WebViewManager", "destroyAll()... ");
        r1.b.dispose();
        r1.b.clear();
        r1.b = new CompositeDisposable();
        q45.c r2 = r1.a;
        monitor-enter(r2);
    L21:
        th = move-exception;
        throw th;
    L8:
        if (r2.a.isEmpty() == false) goto L11;
        monitor-exit(r2);
    L20:
        return r1.l(r6);
    L11:
        ArrayList r3 = new ArrayList(r2.a);     // Catch: Throwable -> L21
        ((LinkedList) r2.a).clear();     // Catch: Throwable -> L21
        Iterator r4 = r3.iterator();     // Catch: Throwable -> L21
    L13:
        if (r4.hasNext() == false) goto L18;
        q45.c.a r5 = (q45.c.a) r4.next();     // Catch: Throwable -> L21
        q45.b r7 = r2.b;     // Catch: Throwable -> L21
        if (r7 == null) goto L13;
        ((y7) r7).p(r5.b);     // Catch: Throwable -> L21
        goto L13
    L18:
        monitor-exit(r2);
        goto L20
    L31:
        return Flowable.just(Boolean.FALSE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.contract.m
    public final Flowable d(WebView r4) {
        if ((r4 instanceof DocBridgeWebViewV2) == true) goto L6;
        tt5.a.d("DocWebServiceImp2", "preloadTemplate()... webView is not DocBridgeWebViewV2!");
        return Flowable.just(Boolean.FALSE);
    L6:
        l7 r0 = y7.j;
        y7 r1 = y7.a.a;
        DocBridgeWebViewV2 r5 = (DocBridgeWebViewV2) r4;
        r1.getClass();
        tt5.a.h("WebViewManager", "destroyAndPreloadNewWebView()... webView = " + r5 + ", isReloadRN = false");
        r1.c();
        r1.e(r5);
        return r1.d(false);
    }

    @Override // com.bytedance.ee.bear.contract.m
    public final void e(com.bytedance.ee.bear.contract.m0 r2) {
        l7 r0 = y7.j;
        y7.a.a.k().C(r2);
    }

    @Override // com.bytedance.ee.bear.contract.m
    public final void f(WebFragment r5) {
        WebViewFragment r0 = o(r5, "attach");
        if (r0 != null) goto L5;
        return;
    L5:
        b5 r1 = r0.k;
        if (r1 != null) goto L8;
    L11:
        if (r1 != null) goto L15;
        tt5.a.d("DocWebServiceImp2", "attach: container is null");
        return;
    L15:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("ccm.bitable.docx_base.optimized.enable") == false) goto L22;
        DocBridgeWebViewV2 r2 = ((com.bytedance.ee.bear.share.b) org.koin.java.a.a(com.bytedance.ee.bear.share.b.class)).e(r0);
        if (r2 != null) goto L20;
        r2 = null;
    L20:
        if (r2 != null) goto L23;
        l7 r3 = y7.j;
        r2 = y7.a.a.r(r0.ba0());
    L23:
        r1.d(r2, r5);
        r2.getWebServiceManager().e();
        return;
    L22:
        l7 r4 = y7.j;
        r2 = y7.a.a.r(r0.ba0());
        goto L23
    L8:
        if (r1.isAttached() == false) goto L11;
        tt5.a.h("DocWebServiceImp2", "attach: container is already attached");
    }

    @Override // com.bytedance.ee.bear.contract.m
    public final void g(com.bytedance.ee.bear.contract.m.a r3) {
        tt5.a.b("DocWebServiceImp2", "unregisterExportDelegate()...");
        ((ArrayList) this.b).remove(r3);
    }

    @Override // com.bytedance.ee.bear.contract.m
    public final void k(com.bytedance.ee.bear.contract.m.c r3) {
        tt5.a.b("DocWebServiceImp2", "registerSnapshotDelegate()...");
        if (((ArrayList) this.a).contains(r3) == true) goto L6;
        ((ArrayList) this.a).add(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.contract.m
    public final void l(com.bytedance.ee.bear.contract.m.a r3) {
        tt5.a.b("DocWebServiceImp2", "registerExportDelegate()...");
        if (((ArrayList) this.b).contains(r3) == true) goto L6;
        ((ArrayList) this.b).add(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.contract.m
    public final void m(String r4) {
        tt5.a.b("DocWebServiceImp2", "docShot()... size = " + ((ArrayList) this.a).size());
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.contract.m.c) r0.next()).onRequestSnapshot(r4, "");
        goto L4
    }

    @Override // com.bytedance.ee.bear.contract.m
    public final void n(com.bytedance.ee.bear.contract.m.c r3) {
        tt5.a.b("DocWebServiceImp2", "unregisterSnapshotDelegate()...");
        ((ArrayList) this.a).remove(r3);
    }

    public static WebViewFragment o(WebFragment r1, String r2) {
        if ((r1 instanceof WebViewFragment) == true) goto L5;
        tt5.a.d("DocWebServiceImp2", r2.concat(": fragment is not WebViewFragment"));
        return null;
    L5:
        return (WebViewFragment) r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.contract.m
    public final Flowable<Boolean> j(WebView r2, boolean r3) {
        if ((r2 instanceof DocBridgeWebViewV2) == true) goto L6;
        tt5.a.d("DocWebServiceImp2", "preloadTemplateNotDestroyWebview()... webView is not DocBridgeWebViewV2!");
        return Flowable.just(Boolean.FALSE);
    L6:
        l7 r0 = y7.j;
        return y7.a.a.q((DocBridgeWebViewV2) r2, r3);
    }

    @Override // com.bytedance.ee.bear.contract.m
    public final void h(String r3, String r4, com.bytedance.ee.bear.contract.m.b r5) {
        tt5.a.b("DocWebServiceImp2", "docShot()... source = " + r3 + ", size = " + ((ArrayList) this.a).size());
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.contract.m.c) r0.next()).onRequestSnapshot(r3, r4, r5);
        goto L4
    }
}
