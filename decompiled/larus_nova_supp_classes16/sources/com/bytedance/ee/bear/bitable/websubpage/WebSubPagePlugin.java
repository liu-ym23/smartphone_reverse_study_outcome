package com.bytedance.ee.bear.bitable.websubpage;

import android.content.Context;
import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.WebViewV2;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import d25.d;
import h18.f;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kv4.c;
import n25.h;
import org.json.JSONObject;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/websubpage/WebSubPagePlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "mWillShowSubPage", "", "mPageInfo", "Lorg/json/JSONObject;", "mResInterceptor", "Lcom/bytedance/ee/bear/bitable/websubpage/ResInterceptor;", "resManager", "Lcom/bytedance/ee/bear/bitable/websubpage/ResManager;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "isFullScreenPage", "onDetachFromHost", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebSubPagePlugin extends DocumentPlugin {
    public static final a Companion = null;
    private static final String OPEN_SUB_WEBPAGE_FLAG = "__baseOpenWebSubpage__";
    private static final String TAG = "WebSubPagePlugin";
    private JSONObject mPageInfo;
    private kv4.b mResInterceptor;
    private boolean mWillShowSubPage;
    private final c resManager;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends WebChromeClient {
        public final /* synthetic */ WebSubPagePlugin a;

        public static final class a extends WebViewClient {
            public final /* synthetic */ WebSubPagePlugin a;

            public a(WebSubPagePlugin r1) {
                this.a = r1;
            }

            @Override // android.webkit.WebViewClient
            public final WebResourceResponse shouldInterceptRequest(WebView r11, WebResourceRequest r12) {
                kv4.b r0 = WebSubPagePlugin.access$getMResInterceptor$p(this.a);
                h r1 = null;
                if (r0 == null) goto L19;
                if (r12 == null) goto L19;
                tt5.a.b("ResInterceptor", "intercept-url: " + r12.getUrl());
                Uri r2 = r12.getUrl();
                if (TextUtils.equals("/mobile_subpage.html", r2.getPath()) == false) goto L12;
                String r3 = d.b(r0.b.a(r0.a, "mobile_subpage.html"));
                if (f.a(r0.a) == false) goto L10;
                String r4 = "dark";
            L11:
                String r5 = StringsKt.replace$default(StringsKt.replace$default(r3, "{{ darkmode_enable }}", "true", false, 4, null), "{{ theme }}", r4, false, 4, null);
                String r6 = n25.b.a;
                r1 = new h(r2.toString(), d.c(r2.toString()), r6, new ByteArrayInputStream(r5.getBytes(Charset.forName(r6))));
                goto L19
            L10:
                r4 = "";
                goto L11
            L12:
                String r7 = r2.getPath();
                if (TextUtils.isEmpty(r7) == true) goto L19;
                if (r7 == null) goto L16;
                InputStream r8 = r0.b.a(r0.a, r7);
            L17:
                if (r8 == null) goto L19;
                r1 = new h(r2.toString(), d.c(r2.toString()), n25.b.a, r8);
                goto L19
            L16:
                r8 = null;
            L19:
                if (r1 == null) goto L22;
                return r1;
            L22:
                return super.shouldInterceptRequest(r11, r12);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.websubpage.WebSubPagePlugin$b$b, reason: collision with other inner class name */
        public static final class C0031b implements FullScreenWebSubPage.a {
            public final /* synthetic */ WebSubPagePlugin a;

            @Override // com.bytedance.ee.bear.bitable.websubpage.FullScreenWebSubPage.a
            public final void a() {
                WebSubPagePlugin.access$getUIContainer(this.a).d(this.a);
            }

            public C0031b(WebSubPagePlugin r1) {
                this.a = r1;
            }
        }

        public b(WebSubPagePlugin r1) {
            this.a = r1;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onCreateWindow(WebView r10, boolean r11, boolean r12, Message r13) {
            if (WebSubPagePlugin.access$getMWillShowSubPage$p(this.a) == false) goto L39;
            if (r13 == null) goto L36;
            WebSubPagePlugin r14 = this.a;
            LarkWebView r0 = new WebViewV2(WebSubPagePlugin.access$getContext(r14));
            r0.setBizType(gt5.d.d);
            r0.getSettings().setJavaScriptEnabled(true);
            r0.getSettings().setAllowFileAccess(true);
            r0.setWebViewClient(new a(r14));
            Object r1 = r13.obj;
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.webkit.WebView.WebViewTransport");
            ((WebView.WebViewTransport) r1).setWebView(r0);
            r13.sendToTarget();
            if (WebSubPagePlugin.access$isFullScreenPage(r14) == false) goto L18;
            FullScreenWebSubPage r16 = (FullScreenWebSubPage) WebSubPagePlugin.access$instantiateFragment(r14, FullScreenWebSubPage.class);
            JSONObject r4 = WebSubPagePlugin.access$getMPageInfo$p(r14);
            r16.h = r0;
            r0.setWebChromeClient(new com.bytedance.ee.bear.bitable.websubpage.b(r16));
            if (r4 == null) goto L17;
            JSONObject r2 = r4.optJSONObject("pageStyle");
            if (r2 == null) goto L17;
            JSONObject r3 = r2.optJSONObject("navigationbarInfo");
            if (r3 == null) goto L17;
            String r5 = r3.optString("initTitle");
            BaseTitleBar r6 = r16.e;
            if (r6 == null) goto L17;
            r6.setTitle(r5);
            Unit r7 = Unit.INSTANCE;
        L17:
            r16.i = new C0031b(r14);
            WebSubPagePlugin.access$getUIContainer(r14).i(r14, r16);
            goto L36
        L18:
            WebSubPage r17 = WebSubPagePlugin.access$instantiateFragment(r14, WebSubPage.class);
            JSONObject r8 = WebSubPagePlugin.access$getMPageInfo$p(r14);
            if (r8 == null) goto L30;
            r17.getClass();
            JSONObject r9 = r8.optJSONObject("pageStyle");
            if (r9 == null) goto L29;
            JSONObject r18 = r9.optJSONObject("navigationbarInfo");
            if (r18 == null) goto L25;
            r17.p = r18.optString("initTitle");
            r17.j = true;
        L25:
            r17.k = (float) r9.optDouble("pageHeight", 0.5d);
            JSONObject r19 = r9.optJSONObject("dragParams");
            if (r19 == null) goto L28;
            r17.i = true;
            r17.m = (float) r19.optDouble("minHeight", 0.5d);
            r17.n = (float) r19.optDouble("maxHeight", 0.9d);
        L31:
            r17.o = r0;
            r0.setWebChromeClient(new kv4.d(r17));
            FragmentManager r110 = WebSubPagePlugin.access$getFragmentManager(r14);
            LandscapeRestrictionOperation r20 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r17, "javaClass", r20);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r110, r17, r20) == true) goto L36;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L40
        L35:
            r17.show(r110, "javaClass");
            goto L36
        L28:
            r17.i = false;
            r17.m = 0.5f;
            r17.n = 0.9f;
            goto L31
        L29:
            r17.i = false;
            r17.j = false;
            r17.k = 0.5f;
            r17.m = 0.5f;
            r17.n = 0.9f;
            goto L31
        L30:
            r17.i = false;
            r17.j = false;
            r17.k = 0.5f;
            r17.m = 0.5f;
            r17.n = 0.9f;
        L36:
            WebSubPagePlugin.access$setMWillShowSubPage$p(this.a, false);
            return true;
        L39:
            return super.onCreateWindow(r10, r11, r12, r13);
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsPrompt(WebView r5, String r6, String r7, String r8, JsPromptResult r9) {
            if (TextUtils.equals(r7, WebSubPagePlugin.OPEN_SUB_WEBPAGE_FLAG) == false) goto L13;
            WebSubPagePlugin.access$setMPageInfo$p(this.a, new JSONObject(r8));     // Catch: Exception -> L10
            WebSubPagePlugin.access$setMWillShowSubPage$p(this.a, true);     // Catch: Exception -> L10
            WebSubPagePlugin.access$getResManager$p(this.a).getClass();     // Catch: Exception -> L10
            if (com.bytedance.ee.bear.bitable.core.usercomponent.compat.a.a().a.a.get() == true) goto L7;
            tt5.a.h(WebSubPagePlugin.TAG, "res not loaded on attach");     // Catch: Exception -> L10
            WebSubPagePlugin.access$getResManager$p(this.a).b(false);     // Catch: Exception -> L10
        L7:
            if (r9 == null) goto L9;
            r9.confirm();     // Catch: Exception -> L10
        L9:
            return true;
        L10:
            e = move-exception;
            tt5.a.d(WebSubPagePlugin.TAG, "WebSubPagePlugin can not handle openWind: " + e);
        L13:
            return super.onJsPrompt(r5, r6, r7, r8, r9);
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final boolean isFullScreenPage() {
        JSONObject r0 = this.mPageInfo;
        if (r0 == null) goto L7;
        JSONObject r1 = r0.optJSONObject("pageStyle");
        if (r1 == null) goto L7;
        String r2 = r1.optString("pageType", "");
    L9:
        return TextUtils.equals("page", r2);
    L7:
        r2 = null;
        goto L9
    }

    public WebSubPagePlugin() {
        this.resManager = new c();
    }

    public static final /* synthetic */ Context access$getContext(WebSubPagePlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ FragmentManager access$getFragmentManager(WebSubPagePlugin r0) {
        return r0.getFragmentManager();
    }

    public static final /* synthetic */ JSONObject access$getMPageInfo$p(WebSubPagePlugin r0) {
        return r0.mPageInfo;
    }

    public static final /* synthetic */ kv4.b access$getMResInterceptor$p(WebSubPagePlugin r0) {
        return r0.mResInterceptor;
    }

    public static final /* synthetic */ boolean access$getMWillShowSubPage$p(WebSubPagePlugin r0) {
        return r0.mWillShowSubPage;
    }

    public static final /* synthetic */ c access$getResManager$p(WebSubPagePlugin r0) {
        return r0.resManager;
    }

    public static final /* synthetic */ t access$getUIContainer(WebSubPagePlugin r0) {
        return r0.getUIContainer();
    }

    public static final /* synthetic */ boolean access$isFullScreenPage(WebSubPagePlugin r0) {
        return r0.isFullScreenPage();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(DocumentPluginHost r5) {
        super.onAttachToHost(r5);
        StringBuilder r6 = new StringBuilder("onAttachToHost-");
        if (((DocumentPluginHost) getHost()).getWeb() != null) goto L5;
        boolean r0 = true;
    L6:
        r6.append(r0);
        tt5.a.b(TAG, r6.toString());
        k r7 = lv4.c.a;
        lv4.c.a = ((DocumentPluginHost) getHost()).getWeb();
        this.resManager.getClass();
        if (com.bytedance.ee.bear.bitable.core.usercomponent.compat.a.a().a.a.get() == true) goto L9;
        tt5.a.h(TAG, "onAttachToHost-load-res-start:" + System.currentTimeMillis());
        this.resManager.b(true);
        tt5.a.h(TAG, "onAttachToHost-load-res-end:" + System.currentTimeMillis());
    L9:
        this.mResInterceptor = new kv4.b(getContext());
        ((DocumentPluginHost) getHost()).getWeb().addWebChromeClientDelegate(new b(this), -1073741824);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        k r0 = lv4.c.a;
        super.onDetachFromHost(r2);
    }

    public static final /* synthetic */ Fragment access$instantiateFragment(WebSubPagePlugin r0, Class r1) {
        return r0.instantiateFragment(r1);
    }

    public static final /* synthetic */ void access$setMPageInfo$p(WebSubPagePlugin r0, JSONObject r1) {
        r0.mPageInfo = r1;
    }

    public static final /* synthetic */ void access$setMWillShowSubPage$p(WebSubPagePlugin r0, boolean r1) {
        r0.mWillShowSubPage = r1;
    }
}
