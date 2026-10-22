package sv5;

import android.webkit.WebResourceResponse;
import java.io.InputStream;
import java.util.HashMap;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static WebResourceResponse a(String r100, String r101, InputStream r110) {
        if (r110 == null) goto L14;
        HashMap r102 = new HashMap();     // Catch: Exception -> L8
        r102.put("Access-Control-Allow-Origin", "*");     // Catch: Exception -> L8
        r102.put("Content-Type", r100);     // Catch: Exception -> L8
        if ("font/ttf".equals(r100) == true) goto L13;
        WebResourceResponse r103 = new WebResourceResponse(r100, r101, r110);     // Catch: Exception -> L8
        r103.setResponseHeaders(r102);     // Catch: Exception -> L8
        return r103;
    L13:
        return new WebResourceResponse(r100, r101, 200, "OK", r102, r110);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L14:
        return null;
    }
}
