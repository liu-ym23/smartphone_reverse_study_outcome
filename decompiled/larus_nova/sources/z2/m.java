package z2;

import android.net.Uri;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import d3.w;

/* JADX INFO: loaded from: classes43.dex */
public final class m extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f569754a;

    public m(l r100) {
        this.f569754a = r100;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        super.onPageFinished(r100, r101);
        com.bytedance.ai.applet.base.log.b r102 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.c("ai_bridge", "[EmbedWebViewService] onPageFinished: ".concat(o.a(r101)));
        c r103 = this.f569754a.f569744d;
        if (r103 == null) goto L6;
        r103.onPageFinished();
        return;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
        l r102 = this.f569754a;
        int r103 = l.f569740n;
        r102.getClass();
        if (r101 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L10;
        String r105 = "crashed";
    L11:
        com.bytedance.ai.applet.base.log.b r106 = com.bytedance.ai.applet.base.log.a.f34518a;
        StringBuilder r107 = new StringBuilder("[EmbedWebViewService] render process ");
        r107.append(r105);
        r107.append(", url: ");
        if (r100 == null) goto L14;
        String r108 = r100.getUrl();
    L15:
        r107.append(o.a(r108));
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", r107.toString(), null);
        r102.f569745e = null;
        w r109 = r102.f569746f;
        if (r109 == null) goto L18;
        r109.g();
    L18:
        r102.f569746f = null;
        return true;
    L14:
        r108 = null;
        goto L15
    L10:
        r105 = "killed by system";
        goto L11
    L5:
        if (r101.didCrash() != true) goto L7;
        r104 = true;
        goto L8
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
        if (r101 == null) goto L17;
        Uri r102 = r101.getUrl();
        if (r102 == null) goto L18;
        String r103 = r102.toString();
        if (r103 == null) goto L19;
        l r104 = this.f569754a;
        int r105 = l.f569740n;
        if (r104.d(r103) == true) goto L15;
        com.bytedance.ai.applet.base.log.b r106 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[EmbedWebViewService] navigation blocked: ".concat(o.a(r103)), null);
        this.f569754a.e();
        c r107 = this.f569754a.f569744d;
        if (r107 == null) goto L14;
        r107.b(-4, "Domain not allowed");
    L14:
        return true;
    L15:
        return false;
    L19:
        return true;
    L18:
        return true;
    L17:
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        super.onReceivedError(r100, r101, r102);
        if (r102 == null) goto L14;
        l r103 = this.f569754a;
        com.bytedance.ai.applet.base.log.b r104 = com.bytedance.ai.applet.base.log.a.f34518a;
        StringBuilder r105 = new StringBuilder("[EmbedWebViewService] onReceivedError: code=");
        r105.append(r102.getErrorCode());
        r105.append(", desc=");
        r105.append(r102.getDescription());
        r105.append(", url=");
        if (r101 == null) goto L9;
        Uri r106 = r101.getUrl();
        if (r106 == null) goto L9;
        String r107 = r106.toString();
    L10:
        r105.append(o.a(r107));
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", r105.toString(), null);
        c r108 = r103.f569744d;
        if (r108 == null) goto L15;
        r108.b(r102.getErrorCode(), r102.getDescription().toString());
        return;
    L15:
        return;
    L9:
        r107 = null;
        goto L10
    }
}
