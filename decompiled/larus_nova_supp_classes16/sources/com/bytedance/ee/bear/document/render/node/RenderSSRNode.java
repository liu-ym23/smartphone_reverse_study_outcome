package com.bytedance.ee.bear.document.render.node;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.n0;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.doccomponent.config.DocComponentConfig;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.render.preload.WebViewLoadStateWebService;
import com.bytedance.ee.bear.document.ssr.plugin.RenderHtmlCachePlugin;
import com.bytedance.ee.bear.domain.BearUrl;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.CancellationException;
import k25.e0;
import k25.m0;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class RenderSSRNode implements l {
    public n0 a;

    public static final class a {
    }

    static {
    }

    public RenderSSRNode() {
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final void c(DocumentLoaderV3 r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        n0 r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        this.a = null;
        if ((r4 instanceof DocumentLoaderV3) == true) goto L9;
        r4 = null;
    L9:
        if (r4 == null) goto L12;
        r4.n(r0);
        return;
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final Object b(DocumentLoaderV3 r17, Continuation r18) {
        com.bytedance.ee.bear.document.d r7 = r17.getDocumentMetadata();
        BearUrl r8 = r7.getBearUrl();
        o r9 = r17.h;
        boolean r10 = false;
        if (r7.isSyncBlock() == false) goto L7;
        d25.d.o("");
        r9.a("shouldRenderCacheHtml", Boxing.boxBoolean(false));
        r9.a("renderSSRWebviewType", Boxing.boxInt(0));
        tt5.a.h("RenderSSRNode", r17.i + "skip ssr for sync block origin");
        q.a.getClass();
        return new q.c();
    L7:
        if (TextUtils.equals(r7.getDocumentType(), sbb.e.o.getType()) == false) goto L9;
    L14:
        boolean r0 = true;
    L15:
        if (r0 == false) goto L45;
        com.bytedance.ee.bear.document.render.preload.e r1 = (com.bytedance.ee.bear.document.render.preload.e) r17.d.getWebService(WebViewLoadStateWebService.class);
        if (r1 != null) goto L19;
    L21:
        boolean r2 = false;
    L22:
        if (r2 == false) goto L24;
        boolean r3 = a(r17, r7, r8);
    L25:
        String r4 = r7.getOriginBearUrl().r;
        if (r4 != null) goto L28;
        r4 = r8.r;
    L28:
        String r5 = r8.a;
        boolean r6 = fx4.a.g(r7.getOriginBearUrl());
        Map<String, Serializable> r11 = r9.a;
        int r12 = com.bytedance.ee.bear.document.ssr.j.a;
        Intrinsics.checkNotNullParameter(r11, "renderParams");
        if (r11.containsKey("renderSSRWebviewType") == false) goto L31;
    L33:
        if (r3 == false) goto L35;
    L38:
        int r13 = 0;
    L40:
        if (com.bytedance.ee.bear.document.ssr.j.a(r8) == false) goto L44;
        if (r3 == true) goto L44;
        if (r13 == 1) goto L44;
        r10 = true;
    L44:
        r9.a("shouldRenderCacheHtml", Boxing.boxBoolean(r10));
        r9.a("renderSSRWebviewType", Boxing.boxInt(r13));
        tt5.a.h("RenderSSRNode", r17.i + "renderCacheHTML... renderCacheHtmlFromNative = " + r3 + ",  renderSsrWebViewType = " + r13);
    L46:
        q.a.getClass();
        return new q.c();
    L35:
        if (com.bytedance.ee.bear.document.ssr.j.b(r4, r5, r6) == false) goto L38;
        r13 = 1;
        goto L40
    L31:
        if (DocOpenConfig.f().enable_after_render == true) goto L33;
    L24:
        tt5.a.h("RenderSSRNode", r17.i + "WebView is not ready, so cannot use ssr.");
        p r16 = new p(r17, this, r17, r7, r8);
        this.a = r16;
        r17.m(r16);
        r3 = false;
        goto L25
    L19:
        if (r1.c(r7.getDocumentType()) != true) goto L21;
        r2 = true;
        goto L22
    L45:
        tt5.a.h("RenderSSRNode", r17.i + " documentType: " + r7.getDocumentType() + " does not support ssr");
        r9.a("shouldRenderCacheHtml", Boxing.boxBoolean(false));
        r9.a("renderSSRWebviewType", Boxing.boxInt(0));
        goto L46
    L9:
        if (TextUtils.equals(r7.getDocumentType(), sbb.e.h.getType()) == true) goto L14;
        if (TextUtils.equals(r7.getDocumentType(), sbb.e.m.getType()) == true) goto L14;
        r0 = false;
        goto L15
    }

    public static boolean a(e r10, com.bytedance.ee.bear.document.d r11, BearUrl r12) {
        AccountService$Account r0 = ((h0) r10.a(h0.class)).G2();
        if (r0 != null) goto L5;
        return false;
    L5:
        String r13 = r11.getEditionToken();
        JSONObject r3 = null;
        if (r13 != null) goto L8;
    L15:
        r13 = r12.b;
        if (r13 != null) goto L18;
        r13 = "";
    L18:
        String r5 = r12.a;
        Map<String, String> r6 = r12.d;
        if (r6 != null) goto L21;
        r6 = MapsKt.emptyMap();
    L21:
        m0 r14 = e0.m().n(n35.a.b(r0, r5, r6), r13);
        f r1 = r10.b();
        String r7 = r14.s;
        if (r7 != null) goto L24;
        r7 = "unknown";
    L24:
        r1.d(r7);
        if (r14.c == null) goto L27;
        boolean r2 = true;
    L28:
        boolean r8 = r14.a();
        boolean r9 = fx4.a.f(r12.e);
        if (r2 == false) goto L33;
        if (r8 == false) goto L33;
        if (r9 == true) goto L33;
        boolean r16 = true;
    L34:
        tt5.a.h("RenderSSRNode", r10.f() + "canUseSsr: " + r16 + " isSsrExist: " + r2 + " isSubscriptDoc: " + r9 + " hasNotPaged: " + r8);
        if (r16 == true) goto L43;
        if (r2 == true) goto L38;
        d25.d.o("");
    L42:
        return false;
    L38:
        if (r8 == true) goto L40;
        d25.d.o("paged");
        goto L42
    L40:
        if (r9 == false) goto L42;
        d25.d.o("subscribe_doc");
        goto L42
    L43:
        RenderHtmlCachePlugin r4 = (RenderHtmlCachePlugin) r10.getPluginHost().findPlugin(RenderHtmlCachePlugin.class);
        if (r4 != null) goto L46;
    L48:
        boolean r17 = false;
    L49:
        if (r17 == false) goto L52;
        tt5.a.h("RenderSSRNode", "renderCacheHtmlIfNeeded: renderCacheInSsrWebView is true");
        return false;
    L52:
        String r18 = r14.c;
        if (r18 != null) goto L55;
        return false;
    L55:
        tt5.a.h("RenderSSRNode", r10.f() + "renderCacheHTML... htmlCacheValue = " + r18.length());
        JSONObject r19 = JSON.parseObject(r18);     // Catch: Throwable -> L86 CancellationException -> L89
        if (r19 != null) goto L60;
        tt5.a.k("RenderSSRNode", r10.f() + "renderCacheHTML skipped, html cache is not json object.");     // Catch: Throwable -> L86 CancellationException -> L89
        return false;
    L60:
        Fragment r20 = r10.getPluginHost().getFragment();     // Catch: Throwable -> L86 CancellationException -> L89
        String r21 = r12.r;     // Catch: Throwable -> L79 CancellationException -> L84
        if (r21 != null) goto L64;
    L67:
        boolean r22 = true;
    L68:
        if (r22 == true) goto L70;
        String r110 = r12.r;     // Catch: Throwable -> L79 CancellationException -> L84
    L71:
        JSONObject r111 = DocComponentConfig.getSceneConfig(r110);     // Catch: Throwable -> L79 CancellationException -> L84
        if (r20 == null) goto L74;
        r3 = DocComponentConfig.getPatchSettingConfig(new WeakReference(r20));     // Catch: Throwable -> L79 CancellationException -> L84
    L74:
        if (r111 == null) goto L76;
        r19.put(DocComponentConfig.KEY_INJECT_WEB, r111);     // Catch: Throwable -> L79 CancellationException -> L84
    L76:
        if (r3 == null) goto L81;
        r19.put(DocComponentConfig.KEY_INJECT_WEB_PATCH, r3);     // Catch: Throwable -> L79 CancellationException -> L84
    L81:
        r10.getPluginHost().getWeb().j("javascript:renderCacheHTML", r19);     // Catch: Throwable -> L86 CancellationException -> L89
        r10.c(RenderSSRNode$renderCacheHtmlIfNeeded$2.INSTANCE);
        boolean r112 = com.bytedance.ee.bear.document.render.node.a.a;
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter("csrwebview", DocRedirectToDocxPlugin.FROM);
        com.bytedance.ee.bear.document.render.node.a.a(r10, "load ssr cache, from = ".concat("csrwebview"));
        return true;
    L70:
        r110 = r12.q;     // Catch: Throwable -> L79 CancellationException -> L84
        goto L71
    L64:
        if (r21.length() == 0) goto L67;
        r22 = false;
    L84:
        e = move-exception;
        throw e;     // Catch: Throwable -> L86 CancellationException -> L89
    L79:
        th = move-exception;
        tt5.a.f("DocComponentConfigInjector", th, false);     // Catch: Throwable -> L86 CancellationException -> L89
    L89:
        e = move-exception;
        throw e;
    L86:
        th = move-exception;
        tt5.a.e("RenderSSRNode", r10.f() + "renderCacheHTML failed.", th, false);
        return false;
    L46:
        if (r4.getRenderCacheInSsrWebView() != true) goto L48;
        r17 = true;
    L33:
        r16 = false;
        goto L34
    L27:
        r2 = false;
        goto L28
    L8:
        if (r13.length() <= 0) goto L10;
        boolean r23 = true;
    L11:
        if (r23 == true) goto L14;
        r13 = null;
    L14:
        if (r13 != null) goto L18;
    L10:
        r23 = false;
        goto L11
    }
}
