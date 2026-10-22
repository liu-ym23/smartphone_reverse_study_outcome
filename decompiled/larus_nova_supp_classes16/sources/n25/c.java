package n25;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.ServiceWorkerClient;
import android.webkit.ServiceWorkerController;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ee.bear.document.DocBridgeWebViewV2;
import com.bytedance.ee.bear.document.DocOpenConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends WebViewClient {
    public final String a;
    public final n25.a b;

    public class a extends ServiceWorkerClient {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // android.webkit.ServiceWorkerClient
        public final WebResourceResponse shouldInterceptRequest(WebResourceRequest r4) {
            tt5.a.h(this.a.a, "shouldInterceptRequest() ServiceWorkerController   request= " + r4.getUrl());
            c r0 = this.a;
            n25.a r1 = r0.b;
            if (r1 != null) goto L5;
            tt5.a.k(r0.a, "shouldInterceptRequest()...3");
            return null;
        L5:
            return r1.t(r4.getUrl().toString(), r4.getMethod(), r4.getRequestHeaders());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(DocBridgeWebViewV2 r4, String r5) {
        this.a = "DocSessionEngine";
        if (TextUtils.isEmpty(r5) == true) goto L5;
        this.a = "DocSessionEngine_" + r5;
    L5:
        this.b = new n25.a(r4.getContext().getApplicationContext(), r5, r4.getWebServiceManager(), r4.o3);
        if (Build.VERSION.SDK_INT >= 24) goto L17;
    L15:
        tt5.a.b(this.a, "initDocSessionEngine()...");
        return;
    L17:
    L13:
        th = move-exception;
        tt5.a.d(this.a, "ServiceWorkerController()...e: " + th);
        goto L15
    L8:
        if (DocOpenConfig.g() == false) goto L15;
        ServiceWorkerController r6 = ServiceWorkerController.getInstance();     // Catch: Throwable -> L13
        if (r6 == null) goto L15;
        r6.setServiceWorkerClient(new a(this));     // Catch: Throwable -> L13
        goto L15
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r3, WebResourceRequest r4) {
        n25.a r5 = this.b;
        if (r5 != null) goto L5;
        tt5.a.k(this.a, "shouldInterceptRequest()...2");
        return null;
    L5:
        return r5.t(r4.getUrl().toString(), r4.getMethod(), r4.getRequestHeaders());
    }
}
