package q7;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.web.jsbridge2.x;
import com.bytedance.sdk.xbridge.cn.protocol.auth.AuthUrlSourceType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public class d extends WebView implements x, o7.b, ke7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f531902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f531903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f531904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f531905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AuthUrlSourceType f531906e;

    @Override // com.bytedance.ies.web.jsbridge2.x
    public String getSafeUrl() {
        if (this.f531903b == true) goto L7;
        this.f531906e = AuthUrlSourceType.DisableSafeAuthInXBridge2;
        return this.f531902a;
    L7:
        return getXSafeUrl();
    }

    @Override // ke7.b
    public String getXSafeUrl() {
        if (TextUtils.isEmpty(this.f531905d) == true) goto L6;
        this.f531906e = AuthUrlSourceType.PageCommitVisibleUrl;
        String r100 = this.f531905d;
    L12:
        HybridLogger r101 = HybridLogger.f246343a;
        HybridLogger.m("SSWebView", "GetXSafeUrl: return " + r100 + ", type is " + this.f531906e, null, null, 12);
        return r100;
    L6:
        if (TextUtils.isEmpty(this.f531904c) == true) goto L9;
        this.f531906e = AuthUrlSourceType.PageStartedUrl;
        r100 = this.f531904c;
        goto L12
    L9:
        if (TextUtils.isEmpty(getUrl()) == true) goto L11;
        this.f531906e = AuthUrlSourceType.WebViewUrl;
        r100 = getUrl();
        goto L12
    L11:
        this.f531906e = AuthUrlSourceType.AbnormalUrl;
        r100 = null;
        goto L12
    }

    @Override // android.webkit.WebView
    public boolean canGoBack() {
        return super.canGoBack();
    L4:
        return false;
    }

    @Override // android.webkit.WebView
    public final boolean canGoForward() {
        return super.canGoForward();
    L4:
        return false;
    }

    @Override // android.webkit.WebView
    public int getContentHeight() {
        return super.getContentHeight();
    L4:
        return 1;
    }

    @Override // android.webkit.WebView
    public String getOriginalUrl() {
        return super.getOriginalUrl();
    L4:
        return null;
    }

    @Override // android.webkit.WebView
    public int getProgress() {
        return super.getProgress();
    L4:
        return 100;
    }

    @Override // android.webkit.WebView
    public String getUrl() {
        return super.getUrl();
    L4:
        return null;
    }

    @Override // ke7.b
    public final boolean a() {
        return this.f531903b;
    }

    @Override // android.webkit.WebView
    public final void clearFormData() {
        super.clearFormData();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void clearHistory() {
        super.clearHistory();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView, android.view.View
    public final void computeScroll() {
        super.computeScroll();     // Catch: Exception -> L4
        return;
    }

    @Override // ke7.b
    public AuthUrlSourceType getAuthUrlSourceType() {
        return this.f531906e;
    }

    @Override // android.webkit.WebView
    public void goBack() {
        super.goBack();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void goForward() {
        super.goForward();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public void reload() {
        super.reload();     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        super.stopLoading();     // Catch: Exception -> L4
        return;
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f531902a = "";
        this.f531906e = AuthUrlSourceType.Unset;
    }

    @Override // android.webkit.WebView
    public final boolean canGoBackOrForward(int r100) {
        return super.canGoBackOrForward(r100);
    L4:
        return false;
    }

    @Override // android.webkit.WebView
    public final void clearCache(boolean r100) {
        super.clearCache(r100);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public final void goBackOrForward(int r100) {
        super.goBackOrForward(r100);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        super.loadUrl(r100);     // Catch: Exception -> L5
        return;
    }

    @Override // android.webkit.WebView, android.view.View
    public void setBackgroundColor(int r100) {
        super.setBackgroundColor(r100);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public void setDownloadListener(DownloadListener r100) {
        super.setDownloadListener(r100);     // Catch: Exception -> L4
        return;
    }

    public final void setEnableSafeAuth(Boolean r100) {
        if (r100 == null) goto L4;
        boolean r101 = r100.booleanValue();
    L5:
        this.f531903b = r101;
        return;
    L4:
        r101 = false;
        goto L5
    }

    @Override // android.webkit.WebView
    public void setNetworkAvailable(boolean r100) {
        super.setNetworkAvailable(r100);     // Catch: Exception -> L4
        return;
    }

    public final void setPageCommitVisibleUrl(String r100) {
        this.f531905d = r100;
    }

    public final void setPageStartUrl(String r100) {
        this.f531904c = r100;
    }

    @Override // o7.b
    public void setSafeUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f531902a = r100;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient r100) {
        super.setWebChromeClient(r100);     // Catch: Exception -> L4
        return;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient r100) {
        Intrinsics.checkNotNullParameter(r100, "client");
        super.setWebViewClient(r100);     // Catch: Exception -> L5
        return;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "additionalHttpHeaders");
        super.loadUrl(r100, r101);
    }

    @Override // android.webkit.WebView
    public final void postUrl(String r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "postData");
        super.postUrl(r100, r101);     // Catch: Exception -> L5
        return;
    }
}
