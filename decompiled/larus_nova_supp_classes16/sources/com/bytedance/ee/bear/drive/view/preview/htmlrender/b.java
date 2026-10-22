package com.bytedance.ee.bear.drive.view.preview.htmlrender;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.ee.bear.drive.view.widget.DriveWebView;
import com.bytedance.ee.bear.drive.view.widget.j;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.appsetting.api.SettingManager;
import fo5.d;
import io.reactivex.Flowable;
import j95.m;
import j95.n;
import j95.o;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends BaseWebPreviewView {
    public static final List<String> n = null;
    public static final Pattern o = null;
    public static final Pattern p = null;
    public static final Pattern q = null;
    public C0177b h;
    public c i;
    public String j;
    public boolean k;
    public boolean l;
    public boolean m;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RenderSecurityScene.values().length];
            a = r0;
            r0[RenderSecurityScene.IM_SCENE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[RenderSecurityScene.DRIVE_NORMAL_SCENE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[RenderSecurityScene.DRIVE_DEGRADED_SCENE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.htmlrender.b$b, reason: collision with other inner class name */
    public static class C0177b {
        public final z a;

        public C0177b(z r1) {
            this.a = r1;
        }
    }

    public static class c extends j {
        public String a;
        public RenderSecurityScene b;

        public final WebResourceResponse g() {
            tt5.a.h("SafeHtmlRenderView", "buildHtmlResponse() innerLength=" + this.a.length() + ", strictSecurityMode=" + this.b);
            WebResourceResponse r0 = new WebResourceResponse("text/html", "utf-8", new ByteArrayInputStream(this.a.getBytes(StandardCharsets.UTF_8)));
            HashMap r1 = new HashMap();
            RenderSecurityScene r2 = this.b;
            int r3 = a.a[r2.ordinal()];
            boolean r4 = true;
            if (r3 != 1) goto L5;
        L7:
            String r5 = "sandbox allow-scripts allow-forms; default-src http: https: data: blob:; script-src 'self' 'unsafe-inline' http: https:; style-src 'self' 'unsafe-inline' http: https:; img-src 'self' http: https: data: blob:; media-src 'self' http: https: data: blob:; font-src 'self' http: https: data: blob:; connect-src http: https: ; frame-src 'none'; child-src 'none'; base-uri 'none'; form-action 'none'; frame-ancestors 'self';";
        L8:
            int r6 = SafeHtmlRenderSettings.a;
            SafeHtmlRenderSettings.SafeHtmlRenderConfig r7 = (SafeHtmlRenderSettings.SafeHtmlRenderConfig) SettingManager.getInstance().get(SafeHtmlRenderSettings.SafeHtmlRenderConfig.class);
            StringBuilder r8 = new StringBuilder("getConfig() hasCloudPolicy=");
            if (r7 != null) goto L11;
        L13:
            r4 = false;
        L14:
            r8.append(r4);
            tt5.a.h("SafeHtmlRenderSettings", r8.toString());
            if (r7 != null) goto L17;
            r7 = new SafeHtmlRenderSettings.SafeHtmlRenderConfig(null, null, null, 7, null);
        L17:
            r1.put("Content-Security-Policy", r7.getCsp(r2, r5));
            r1.put("Referrer-Policy", "no-referrer");
            r0.setResponseHeaders(r1);
            return r0;
        L11:
            if (r7.hasCloudPolicy$contentmanager_drive_impl_productionChinaRelease() != true) goto L13;
        L5:
            if (r3 == 2) goto L7;
            r5 = "sandbox; default-src 'self'; script-src 'none'; style-src 'self' 'unsafe-inline' ; img-src 'none'; media-src 'none'; font-src 'self'; connect-src 'none'; frame-src 'none'; object-src 'none'; worker-src 'none'; child-src 'none'; base-uri 'none'; form-action 'none'; frame-ancestors 'self';";
            goto L8
        }

        public c() {
            this.a = "";
            this.b = RenderSecurityScene.DRIVE_DEGRADED_SCENE;
        }

        public static String h(String r3) {
            if (r3 != null) goto L5;
            return "";
        L5:
            int r1 = r3.indexOf(":");
            if (r1 > 0) goto L8;
            return "";
        L8:
            String r4 = r3.substring(0, r1);
            if (r4 != null) goto L12;
            return "";
        L12:
            return r4.toLowerCase(Locale.ROOT);
        }

        @Override // com.bytedance.ee.bear.drive.view.widget.j
        public final WebResourceResponse d(WebResourceRequest r6) {
            String r0 = "";
            if (r6 != null) goto L5;
        L7:
            String r1 = "";
        L8:
            boolean r3 = false;
            boolean r4 = true;
            if ("https://drive-html-preview.local/untrusted.html".equals(r1) == false) goto L17;
            StringBuilder r2 = new StringBuilder("loadUntrustedHtml() mainFrame=");
            if (r6 != null) goto L13;
        L15:
            r2.append(r3);
            tt5.a.h("SafeHtmlRenderView", r2.toString());
            return g();
        L13:
            if (r6.isForMainFrame() == false) goto L15;
            r3 = true;
            goto L15
        L17:
            if (r6 != null) goto L19;
        L24:
            if (r6 != null) goto L26;
        L28:
            r4 = false;
        L30:
            return i(r1, r0, r4, false);
        L26:
            if (r6.isForMainFrame() == false) goto L28;
        L19:
            if (r6.getUrl() == null) goto L24;
            String r5 = r6.getUrl().getScheme();
            if (r5 == null) goto L24;
            r0 = r5.toLowerCase(Locale.ROOT);
            goto L24
        L5:
            if (r6.getUrl() == null) goto L7;
            r1 = r6.getUrl().toString();
            goto L8
        }

        @Override // com.bytedance.ee.bear.drive.view.widget.j
        public final WebResourceResponse e(String r4) {
            if ("https://drive-html-preview.local/untrusted.html".equals(r4) == false) goto L7;
            tt5.a.h("SafeHtmlRenderView", "loadUntrustedHtml() legacy");
            return g();
        L7:
            return i(r4, h(r4), false, true);
        }

        @Override // com.bytedance.ee.bear.drive.view.widget.j
        public final void a(WebView r2, String r3) {
            tt5.a.h("SafeHtmlRenderView", "sandboxPageFinished() scheme=" + h(r3));
        }

        @Override // com.bytedance.ee.bear.drive.view.widget.j
        public final void b(int r3, String r4, String r5) {
            tt5.a.h("SafeHtmlRenderView", "sandboxReceivedError() errorCode=" + r3 + ", scheme=" + h(r5) + ", description=" + r4);
        }

        public static WebResourceResponse i(String r7, String r8, boolean r9, boolean r10) {
            if (TextUtils.equals("about", r8) == false) goto L5;
        L8:
            boolean r0 = true;
        L10:
            if (r0 == false) goto L13;
            return null;
        L13:
            if (TextUtils.isEmpty(r7) == false) goto L30;
        L19:
            boolean r11 = false;
        L21:
            if (r11 == false) goto L25;
            tt5.a.h("SafeHtmlRenderView", "blockInternalSandboxRequest() scheme=" + r8 + ", mainFrame=" + r9 + ", legacy=" + r10);
            return new WebResourceResponse("text/plain", "utf-8", new ByteArrayInputStream(new byte[0]));
        L25:
            if (b.n.contains(r8) == false) goto L28;
            tt5.a.h("SafeHtmlRenderView", "allowSandboxRequest() scheme=" + r8 + ", mainFrame=" + r9 + ", legacy=" + r10);
            return null;
        L28:
            tt5.a.h("SafeHtmlRenderView", "blockSandboxRequest() scheme=" + r8 + ", mainFrame=" + r9 + ", legacy=" + r10);
            return new WebResourceResponse("text/plain", "utf-8", new ByteArrayInputStream(new byte[0]));
        L30:
            r11 = TextUtils.equals("drive-html-preview.local", UriProtector.parse(r7).getHost());     // Catch: Exception -> L17
        L17:
            e = move-exception;
            tt5.a.e("SafeHtmlRenderView", "isInternalSandboxUrl failed", e, false);
            goto L19
        L5:
            if (TextUtils.equals("data", r8) == true) goto L8;
            r0 = false;
            goto L10
        }
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView
    public /* bridge */ /* synthetic */ z getPreviewFileModel() {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, m85.a
    public String getReleaseKey() {
        return "SafeHtmlRenderView";
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onBackPressed() {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void show() {
        this.l = true;
        DriveWebView r0 = getWebView();
        if (r0 != null) goto L6;
        tt5.a.k("SafeHtmlRenderView", "show skipped, webView is null (already released)");
        return;
    L6:
        r0.setOnClickListener(null);
        if (this.k == true) goto L10;
        tt5.a.h("SafeHtmlRenderView", "show wait for ownerTenantInfo before render");
        return;
    L10:
        f();
    }

    static {
        n = Arrays.asList(new String[]{"http", "https"});
        o = PatternProtector.compile("<meta\\b[^>]*http-equiv\\s*=\\s*(['\"]?)content-security-policy\\1[^>]*>", 2);
        p = PatternProtector.compile("<meta\\b[^>]*http-equiv\\s*=\\s*(['\"]?)refresh\\1[^>]*>", 2);
        q = PatternProtector.compile("<meta\\b[^>]*name\\s*=\\s*(['\"]?)referrer\\1[^>]*>", 2);
    }

    public final void f() {
        if (this.m == false) goto L5;
        return;
    L5:
        this.m = true;
        C0177b r0 = this.h;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.a == null) goto L18;
        c95.c r1 = this.c;
        if (r1 == null) goto L12;
        r1.onShowStart();
    L12:
        j65.a.b(this.d, "SafeHtmlRenderView");
        DriveFilePath r2 = this.h.a.d;
        if (r2.isEmpty() == false) goto L15;
        tt5.a.d("SafeHtmlRenderView", "showDocuments filePath is empty");
        return;
    L15:
        this.b = Flowable.just(r2).map(new m(this)).subscribeOn(d.b()).observeOn(d.d()).subscribe(new n(this), new o(this));
        return;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, m85.a
    public final void onRelease() {
        super.onRelease();
    }

    public b(Context r1) {
        super(r1);
        this.j = "";
        this.k = false;
        this.l = false;
        this.m = false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void onSetup(ViewOwner r4, ViewOwner r5) {
        super.onSetup(r4, r5);
        C0177b r6 = this.h;
        if (r6 == null) goto L16;
        DriveWebView r7 = this.a;
        z r8 = r6.a;
        if (r7 == null) goto L17;
        r7.setFileModel(r8);
        WebSettings r9 = r7.getSettings();
        r9.setDefaultTextEncodingName("utf-8");
        r9.setJavaScriptCanOpenWindowsAutomatically(false);
        r9.setDomStorageEnabled(false);
        r9.setDatabaseEnabled(false);
        r9.setAllowFileAccess(false);
        r9.setAllowContentAccess(false);
        r9.setAllowFileAccessFromFileURLs(false);
        r9.setLoadWithOverviewMode(false);
        r9.setAllowUniversalAccessFromFileURLs(false);
        r9.setGeolocationEnabled(false);
        r9.setBlockNetworkLoads(false);     // Catch: SecurityException -> L10
        r9.setSavePassword(false);     // Catch: SecurityException -> L10
        r9.setSaveFormData(false);     // Catch: SecurityException -> L10
    L12:
        c r10 = new c();
        this.i = r10;
        r7.f(r10);
        return;
    L10:
        e = move-exception;
        tt5.a.e("SafeHtmlRenderView", "setupSandboxWebView failed", e, false);
        goto L12
    L17:
        return;
    }
}
