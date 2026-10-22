package of5;

import android.app.KeyguardManager;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
public abstract class c extends com.bytedance.ee.bear.edit.component.richtexteditor.a {
    public abstract a a();

    @Override // ws5.c, android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView r100, RenderProcessGoneDetail r101) {
        boolean r102 = r101.didCrash();
        int r103 = r101.rendererPriorityAtExit();
        tt5.a.h("BridgeWebViewClient", "onRenderProcessGone(): ");
        HashMap r104 = new HashMap();     // Catch: Throwable -> L16
        if (r102 == false) goto L6;
        String r105 = "0";
    L7:
        r104.put("didCrash", r105);     // Catch: Throwable -> L16
        r104.put("rendererPriorityAtExit", String.valueOf(r103));     // Catch: Throwable -> L16
        boolean r106 = false;
        if (eu5.a.a().f474073a.get() != 1) goto L10;
        boolean r107 = true;
    L11:
        r104.put("app_visible", String.valueOf(r107));     // Catch: Throwable -> L16
        r104.put("screen_status", String.valueOf(((KeyguardManager) r100.getContext().getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()));     // Catch: Throwable -> L16
        r104.put("doc_sdk", String.valueOf(true));     // Catch: Throwable -> L16
        if (r100.getVisibility() != 0) goto L14;
        r106 = true;
    L14:
        r104.put("webview_visible", String.valueOf(r106));     // Catch: Throwable -> L16
        r104.put("attached_window", String.valueOf(r100.isAttachedToWindow()));     // Catch: Throwable -> L16
        a();     // Catch: Throwable -> L16
        throw null;     // Catch: Throwable -> L16
    L10:
        r107 = false;
        goto L11
    L6:
        r105 = "1";
    L16:
        th = move-exception;
        tt5.a.d("BridgeWebViewClient", "onRenderProcessGone error = " + th);
        return true;
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView r100, WebResourceRequest r101) {
        return shouldOverrideUrlLoading(r100, r101.getUrl().toString());
    }

    @Override // ws5.c, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView r100, String r101) {
        a();
        throw null;
    }
}
