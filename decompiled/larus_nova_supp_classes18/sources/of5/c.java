package of5;

import android.app.KeyguardManager;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class c extends com.bytedance.ee.bear.edit.component.richtexteditor.a {
    public abstract a a();

    public final boolean onRenderProcessGone(WebView r7, RenderProcessGoneDetail r8) {
        boolean r0 = r8.didCrash();
        int r9 = r8.rendererPriorityAtExit();
        tt5.a.h("BridgeWebViewClient", "onRenderProcessGone(): ");
        HashMap r3 = new HashMap();     // Catch: Throwable -> L16
        if (r0 == false) goto L6;
        String r1 = "0";
    L7:
        r3.put("didCrash", r1);     // Catch: Throwable -> L16
        r3.put("rendererPriorityAtExit", String.valueOf(r9));     // Catch: Throwable -> L16
        boolean r4 = false;
        if (eu5.a.a().a.get() != 1) goto L10;
        boolean r2 = true;
    L11:
        r3.put("app_visible", String.valueOf(r2));     // Catch: Throwable -> L16
        r3.put("screen_status", String.valueOf(((KeyguardManager) r7.getContext().getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()));     // Catch: Throwable -> L16
        r3.put("doc_sdk", String.valueOf(true));     // Catch: Throwable -> L16
        if (r7.getVisibility() != 0) goto L14;
        r4 = true;
    L14:
        r3.put("webview_visible", String.valueOf(r4));     // Catch: Throwable -> L16
        r3.put("attached_window", String.valueOf(r7.isAttachedToWindow()));     // Catch: Throwable -> L16
        a();     // Catch: Throwable -> L16
        throw null;     // Catch: Throwable -> L16
    L10:
        r2 = false;
        goto L11
    L6:
        r1 = "1";
    L16:
        th = move-exception;
        tt5.a.d("BridgeWebViewClient", "onRenderProcessGone error = " + th);
        return true;
    }

    public final boolean shouldOverrideUrlLoading(WebView r1, WebResourceRequest r2) {
        return shouldOverrideUrlLoading(r1, r2.getUrl().toString());
    }

    public boolean shouldOverrideUrlLoading(WebView r1, String r2) {
        a();
        throw null;
    }
}
