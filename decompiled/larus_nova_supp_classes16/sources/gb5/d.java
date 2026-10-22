package gb5;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.imageviewer.view.DiagramWebView;
import com.bytedance.ee.util.ui.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends WebViewClient {
    public final /* synthetic */ String a;
    public final /* synthetic */ DiagramWebView b;

    public d(DiagramWebView r1, String r2) {
        this.b = r1;
        this.a = r2;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r3, String r4) {
        super.onPageFinished(r3, r4);
        final DiagramWebView r5 = this.b;
        String r6 = this.a;
        int r0 = DiagramWebView.e;
        r5.getClass();
        final JSONObject r1 = new JSONObject();
        r1.put("svgString", r6);
        j.c(new a(r5, r1));
    }
}
