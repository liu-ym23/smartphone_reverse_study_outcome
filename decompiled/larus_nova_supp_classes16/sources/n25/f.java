package n25;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.DocBridgeWebViewV2;
import com.bytedance.ee.bear.document.g5;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f extends WebViewClient {
    public static String b = "FrontProxyResourceInterceptor";
    public final Context a;

    /* JADX WARN: Multi-variable type inference failed */
    public f(DocBridgeWebViewV2 r3, String r4) {
        if (TextUtils.isEmpty(r4) == true) goto L5;
        b += OfflineDoc.DASH_DELIMITER + r4;
    L5:
        this.a = r3.getContext().getApplicationContext();
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView r4, WebResourceRequest r5) {
        String r6 = r5.getUrl().toString();
        r5.getMethod();
        Map<String, String> r7 = r5.getRequestHeaders();
    L7:
        e = move-exception;
        tt5.a.e(b, "internalGetSubResponseStream ", e, false);
    L9:
        String r8 = b;
        if (r6 != null) goto L12;
    L16:
        r6 = "";
    L17:
        tt5.a.h(r8, "internalGetSubResponseStream... not InterceptRequest ".concat(r6));
        return null;
    L12:
        if (r6.endsWith(".js") == true) goto L17;
        if (r6.endsWith(".css") == false) goto L16;
    L4:
        if (g5.d(r6) == false) goto L9;
        int r0 = j.a;     // Catch: Exception -> L7
        return a(r6, j.a(this.a, r6), r7);
    }

    public static WebResourceResponse a(String r2, InputStream r3, Map r4) {
        String r5 = d25.d.c(r2);
        if (r3 != null) goto L19;
    L12:
        if (r3 != null) goto L14;
        tt5.a.k(b, "WebResourceResponse input is null.");     // Catch: IOException -> L16
    L17:
        return null;
    L14:
        tt5.a.k(b, "WebResourceResponse input is not available.");     // Catch: IOException -> L16
        goto L17
    L19:
    L16:
        tt5.a.d(b, "  internalGetImageResponse(): ");
        goto L17
    L5:
        if (r3.available() <= 0) goto L12;
        WebResourceResponse r0 = new WebResourceResponse(r5, b.a, r3);     // Catch: IOException -> L16
        if (r4 != null) goto L9;
    L11:
        r0.setResponseHeaders(r4);     // Catch: IOException -> L16
        return r0;
    L9:
        if (r4.containsKey("Origin") == false) goto L11;
        r4.put("access-control-allow-credentials", "true");     // Catch: IOException -> L16
        r4.put("access-control-allow-methods", "POST, GET, OPTIONS, PUT, DELETE");     // Catch: IOException -> L16
        r4.put("access-control-allow-origin", (String) r4.get("Origin"));     // Catch: IOException -> L16
        goto L11
    }
}
