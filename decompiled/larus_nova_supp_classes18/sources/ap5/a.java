package ap5;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.alibaba.fastjson.JSONObject;
import swb.k;
import swb.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static boolean b(WebView r1) {
        if (r1 != null) goto L5;
        o.a("SafeJSExecutor", new IllegalStateException("execJS no webView !"));
        return true;
    L5:
        return false;
    }

    public static void a(WebView r1, String r2, JSONObject r3, ValueCallback<String> r4) {
        if (b(r1) == false) goto L5;
        return;
    L5:
        r1.evaluateJavascript(k.a(r2, r3), r4);
    }
}
