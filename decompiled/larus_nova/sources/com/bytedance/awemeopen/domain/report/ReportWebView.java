package com.bytedance.awemeopen.domain.report;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.awemeopen.domain.base.repo.ConstantsKt;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.net.AoFromSource;
import com.bytedance.awemeopen.infra.base.net.AoNet;
import com.bytedance.awemeopen.infra.base.net.AoNetResponse;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.servicesapi.network.ByteNetEnvHeaderName;
import com.bytedance.sdk.open.aweme.common.constants.OpenConstants;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class ReportWebView extends WebView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f198444e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f198445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f198446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f198447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f198448d;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\fJ\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/awemeopen/domain/report/ReportWebView$JSHandler;", "", "webview", "Lcom/bytedance/awemeopen/domain/report/ReportWebView;", "(Lcom/bytedance/awemeopen/domain/report/ReportWebView;)V", "getWebview", "()Lcom/bytedance/awemeopen/domain/report/ReportWebView;", "callback", "", "code", "", "msg", "", "data", "Lorg/json/JSONObject;", BytedCertConstant.LivenessInfoConfigKey.FRAME_NUM, "doRequest", "Lcom/bytedance/awemeopen/infra/base/net/AoNetResponse;", "p", "onWebExecute", "ao_domain_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class JSHandler {
        private final ReportWebView webview;

        public final ReportWebView getWebview() {
            return this.webview;
        }

        public JSHandler(ReportWebView r100) {
            Intrinsics.checkNotNullParameter(r100, "webview");
            this.webview = r100;
        }

        private final AoNetResponse doRequest(JSONObject r100) {
            if (r100 == null) goto L26;
            String r101 = r100.optString("url");
            q64.f r102 = AoEnv.a().g0();
            if (r102 == null) goto L7;
            String r103 = r102.f531802a;
        L9:
            if (TextUtils.equals(r103, ByteNetEnvHeaderName.BOE) == false) goto L12;
            r101 = StringsKt.replace$default(r101, "https://content-open.douyin.com", OpenConstants.BOE_OPEN_DOMAIN, false, 4, null);
        L12:
            if (StringsKt.startsWith$default(r101, ConstantsKt.a(), false, 2, null) == true) goto L15;
            AoLogger.l("ReportWebView", new Object[]{"illegal jsb request:", r101});
            return null;
        L15:
            String r104 = r100.optString(com.alipay.sdk.m.p.e.f25671s);
            JSONObject r105 = r100.optJSONObject("header");
            JSONObject r106 = r100.optJSONObject("data");
            if (r106 != null) goto L19;
            r106 = new JSONObject();
        L19:
            if (StringsKt.contains$default(r101, "aweme/open/export_sdk/report/commit", false, 2, null) == false) goto L22;
            this.webview.getWebReportCallback().c(r106);
        L22:
            if (Intrinsics.areEqual(r104.toLowerCase(Locale.getDefault()), UGCMonitor.TYPE_POST) == false) goto L24;
            Function0<String> r107 = AoNet.f198669a;
            AoFromSource r108 = AoFromSource.f98default;
            int r109 = ReportWebView.f198444e;
            return AoNet.h(r101, r108, r106, a.a(r105));
        L24:
            Function0<String> r110 = AoNet.f198669a;
            int r111 = ReportWebView.f198444e;
            return AoNet.a(r101, a.a(r105));
        L7:
            r103 = null;
            goto L9
        L26:
            return null;
        }

        @JavascriptInterface
        public final void onWebExecute(String r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            AoLogger.g("ReportWebView", new Object[]{"onWebExecute", r100});     // Catch: Exception -> L11
            JSONObject r101 = new JSONObject(r100);     // Catch: Exception -> L11
            String r102 = r101.optString(com.alipay.sdk.m.p.e.f25671s);     // Catch: Exception -> L11
            final JSONObject r103 = r101.optJSONObject("param");     // Catch: Exception -> L11
            final String r104 = r101.optString("callbackName");     // Catch: Exception -> L11
            if (Intrinsics.areEqual(r102, "request") == false) goto L7;
            AoPool.a(new ReportWebView$JSHandler$onWebExecute$1(this, r103, r104));     // Catch: Exception -> L11
        L14:
            return;
        L7:
            if (Intrinsics.areEqual(r102, "closeWindow") == false) goto L9;
            this.webview.getWebReportCallback().b();     // Catch: Exception -> L11
            goto L14
        L9:
            callback(-1, "not handled", null, r104);     // Catch: Exception -> L11
        L11:
            e = move-exception;
            AoLogger.c("ReportWebView", new Object[]{"error onWebExecute", e});
        }

        public static final /* synthetic */ AoNetResponse access$doRequest(JSHandler r100, JSONObject r101) {
            return r100.doRequest(r101);
        }

        public final void callback(int r100, String r101, JSONObject r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            Intrinsics.checkNotNullParameter(r103, BytedCertConstant.LivenessInfoConfigKey.FRAME_NUM);
            final String r104 = "window." + r103 + '(' + r100 + ",'" + r101 + "'," + r102 + ')';
            AoPool.g(new ReportWebView$JSHandler$callback$1(this, r104));
        }
    }

    public static final class a {
        public static Map a(JSONObject r100) {
            HashMap r101 = new HashMap();
            if (r100 == null) goto L9;
            Iterator<String> r102 = r100.keys();
            if (r102 == null) goto L9;
        L7:
            if (r102.hasNext() == false) goto L9;
            String r103 = r102.next();
            r101.put(r103, r100.optString(r103, ""));
        L9:
            return r101;
        }
    }

    static {
    }

    @Override // android.webkit.WebView
    public final void reload() {
        this.f198448d = false;
        super.reload();
    }

    public final Activity getActivity() {
        return this.f198445a;
    }

    public final l getWebReportCallback() {
        return this.f198446b;
    }

    @Override // android.webkit.WebView
    public final void loadUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        super.loadUrl(r100);
        this.f198447c = r100;
    }

    public ReportWebView(FragmentActivity r100, com.bytedance.awemeopen.apps.framework.report.d r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "webReportCallback");
        new LinkedHashMap();
        super(r100);
        this.f198445a = r100;
        this.f198446b = r101;
        addJavascriptInterface(new JSHandler(this), "AoSDKAndroid");
        getSettings().setJavaScriptEnabled(true);
        getSettings().setAllowFileAccess(true);
        getSettings().setDatabaseEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setGeolocationEnabled(true);
        getSettings().setUserAgentString("Mozilla/5.0 AwemeOpenSDK (Linux; Android+" + Build.VERSION.RELEASE + "; " + Build.MODEL + ") AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.83 Mobile Safari/537.36");
        getSettings().setLoadsImagesAutomatically(true);
        getSettings().setUseWideViewPort(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().setCacheMode(2);
        getSettings().setMixedContentMode(0);
        getSettings().setSavePassword(false);
        getSettings().setSupportZoom(true);
        getSettings().setTextZoom(100);
        setScrollBarStyle(33554432);
        setHorizontalScrollBarEnabled(true);
        requestFocus();
        setWebChromeClient(new AnonymousClass1(this));
        setWebViewClient(new i(this));
    }
}
